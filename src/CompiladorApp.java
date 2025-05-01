import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.atn.PredictionMode;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class CompiladorApp {
    private static Map<String, String> symbolTable = new HashMap<>();

    public static void main(String[] args) {
        if (args.length > 0) {
            analizarArchivo(args[0]);
        } else {
            analizarArchivosDePrueba();
        }
    }

    private static void analizarArchivosDePrueba() {
        String[] archivos = {
                "prueba1_hola_mundo.txt",
                "prueba6_error_lexico.txt"

        };

        for (String archivo : archivos) {
            System.out.println("\n===========================================");
            System.out.println("Analizando archivo: " + archivo);
            System.out.println("===========================================");

            try {
                analizarArchivo("pruebas/" + archivo);
            } catch (Exception e) {
                System.out.println("Error al analizar el archivo " + archivo + ": " + e.getMessage());
            }

            System.out.println("\n");
            symbolTable.clear();
        }
    }

    private static void analizarArchivo(String rutaArchivo) {
        try {
            String contenido = leerArchivo(rutaArchivo);
            System.out.println("Contenido del archivo:");
            System.out.println("---------------------");
            System.out.println(contenido);
            System.out.println("---------------------\n");

            CharStream input = CharStreams.fromString(contenido);

            // Análisis léxico
            MyLanguageLexer lexer = new MyLanguageLexer(input);
            lexer.removeErrorListeners();
            lexer.addErrorListener(new ErrorListener("léxico"));

            CommonTokenStream tokens = new CommonTokenStream(lexer);

            // Verificar errores léxicos primero
            try {
                List<Token> allTokens = new ArrayList<>();
                for (Token token = lexer.nextToken(); token.getType() != Token.EOF; token = lexer.nextToken()) {
                    allTokens.add(token);
                    if (token.getType() == MyLanguageLexer.MULTI_CHARACTER_ERROR) {
                        throw new RuntimeException("Error léxico: Carácter multi-carácter no válido: " + token.getText());
                    }
                    if (token.getType() == MyLanguageLexer.FLOAT && !validarFloat(token.getText())) {
                        throw new RuntimeException("Error léxico: Formato de número flotante inválido: " + token.getText());
                    }
                }

                lexer.reset();

                System.out.println("Tokens reconocidos:");
                for (Token token : allTokens) {
                    System.out.println(token.getText() + " - Tipo: " + token.getType() + " - " +
                            lexer.getVocabulary().getDisplayName(token.getType()));
                }
            } catch (RuntimeException e) {
                System.err.println("Error de compilación: " + e.getMessage());
                return;
            }

            // Análisis sintáctico
            MyLanguageParser parser = new MyLanguageParser(tokens);
            parser.removeErrorListeners();
            parser.addErrorListener(new ErrorListener("sintáctico"));

            System.out.println("\nInformación detallada del parsing:");
            System.out.println("--------------------------------");
            parser.setTrace(true);
            parser.setBuildParseTree(true);

            ParseTree tree;
            try {
                tree = parser.program();
            } catch (RuntimeException e) {
                System.err.println("Error de compilación: " + e.getMessage());
                return;
            }

            System.out.println("--------------------------------");

            // Análisis semántico
            try {
                System.out.println("\nIniciando análisis semántico:");
                System.out.println("-------------------------------");
                SemanticVisitor semanticVisitor = new SemanticVisitor(symbolTable);
                semanticVisitor.visit(tree);
                System.out.println("Análisis semántico completado con éxito");
                System.out.println("-------------------------------");
            } catch (RuntimeException e) {
                System.err.println("Error semántico: " + e.getMessage());
                return;
            }

            // Ejecución del visitor normal
            System.out.println("\nIniciando recorrido del árbol de sintaxis:");
            System.out.println("---------------------------------------");
            MyVisitor visitor = new MyVisitor();
            visitor.visit(tree);
            System.out.println("---------------------------------------");
            System.out.println("Análisis completado con éxito.");

        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    private static boolean validarFloat(String text) {
        return text.matches("[0-9]+\\.[0-9][0-9]?[0-9]?[0-9]?");
    }

    private static String leerArchivo(String rutaArchivo) throws IOException {
        return new String(Files.readAllBytes(Paths.get(rutaArchivo)));
    }

    private static class ErrorListener extends BaseErrorListener {
        private String tipo;

        public ErrorListener(String tipo) {
            this.tipo = tipo;
        }

        @Override
        public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
                                int line, int charPositionInLine,
                                String msg, RecognitionException e) {
            throw new RuntimeException("Error " + tipo + " en línea " + line + ":" + charPositionInLine + " - " + msg);
        }
    }

    private static class SemanticVisitor extends MyLanguageBaseVisitor<Void> {
        private Map<String, String> symbolTable;

        public SemanticVisitor(Map<String, String> symbolTable) {
            this.symbolTable = symbolTable;
        }

        @Override
        public Void visitVariableDeclarationEmpty(MyLanguageParser.VariableDeclarationEmptyContext ctx) {
            String id = ctx.ID().getText();
            String type = ctx.TYPE().getText();

            symbolTable.put(id, type);

            if (ctx.variableDeclarationValue() != null &&
                    ctx.variableDeclarationValue().variable() != null) {

                MyLanguageParser.VariableContext varCtx = ctx.variableDeclarationValue().variable();

                if (type.equals("int") && varCtx.FLOAT() != null) {
                    throw new RuntimeException("Error semántico: No se puede asignar un valor flotante a una variable de tipo entero: " + id);
                }

                if ((type.equals("int") || type.equals("float")) && varCtx.STRING() != null) {
                    throw new RuntimeException("Error semántico: No se puede asignar un string a una variable numérica: " + id);
                }

                if (!type.equals("bool") && varCtx.BOOL() != null) {
                    throw new RuntimeException("Error semántico: No se puede asignar un valor booleano a una variable de tipo: " + type);
                }
            }

            return super.visitVariableDeclarationEmpty(ctx);
        }

        @Override
        public Void visitVariableAssigment(MyLanguageParser.VariableAssigmentContext ctx) {
            String id = ctx.ID().getText();

            if (!symbolTable.containsKey(id)) {
                throw new RuntimeException("Variable no declarada: " + id);
            }

            String varType = symbolTable.get(id);

            if (ctx.variable() != null) {
                MyLanguageParser.VariableContext varCtx = ctx.variable();

                if (varType.equals("int") && varCtx.FLOAT() != null) {
                    throw new RuntimeException("Error semántico: No se puede asignar un valor flotante a una variable de tipo entero: " + id);
                }

                if ((varType.equals("int") || varType.equals("float")) && varCtx.STRING() != null) {
                    throw new RuntimeException("Error semántico: No se puede asignar un string a una variable numérica: " + id);
                }

                if (!varType.equals("bool") && varCtx.BOOL() != null) {
                    throw new RuntimeException("Error semántico: No se puede asignar un valor booleano a una variable de tipo: " + varType);
                }
            }

            return super.visitVariableAssigment(ctx);
        }

        @Override
        public Void visitOutputStatement(MyLanguageParser.OutputStatementContext ctx) {
            if (ctx.ID() != null) {
                String id = ctx.ID().getText();
                if (!symbolTable.containsKey(id)) {
                    throw new RuntimeException("Variable no declarada en write: " + id);
                }
            }

            return super.visitOutputStatement(ctx);
        }

        @Override
        public Void visitInputStatement(MyLanguageParser.InputStatementContext ctx) {
            String id = ctx.ID().getText();

            if (!symbolTable.containsKey(id)) {
                throw new RuntimeException("Variable no declarada en read: " + id);
            }

            return super.visitInputStatement(ctx);
        }

        @Override
        public Void visitCondition(MyLanguageParser.ConditionContext ctx) {
            if (ctx.ID() != null) {
                String id = ctx.ID().getText();
                if (!symbolTable.containsKey(id)) {
                    throw new RuntimeException("Variable no declarada en condición: " + id);
                }
            }

            return super.visitCondition(ctx);
        }
    }
}