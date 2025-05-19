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

/**
 * Clase principal del compilador que integra todas las fases.
 */
public class CompiladorApp {
    private static Map<String, String> symbolTable = new HashMap<>();

    public static void main(String[] args) {
        if (args.length > 0) {
            analizarArchivo(args[0]);
        } else {
            System.out.println("Ejecutando pruebas automáticas...");
            analizarArchivosDePrueba();
        }
    }

    private static void analizarArchivosDePrueba() {
        String[] archivos = {
                "trigonometria.txt"
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
                        throw new RuntimeException(
                                "Error léxico: Carácter multi-carácter no válido: " + token.getText());
                    }
                    if (token.getType() == MyLanguageLexer.FLOAT && !validarFloat(token.getText())) {
                        throw new RuntimeException(
                                "Error léxico: Formato de número flotante inválido: " + token.getText());
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

            // FASE III: TABLA DE SÍMBOLOS Y ANÁLISIS SEMÁNTICO COMPLETO

            // 1. Construir tabla de símbolos
            System.out.println("\nIniciando construcción de tabla de símbolos:");
            System.out.println("-------------------------------");
            SymbolTable symbolTable = new SymbolTable();
            SymbolTableBuilder symbolBuilder = new SymbolTableBuilder(symbolTable);
            symbolBuilder.visit(tree);

            if (symbolBuilder.hasErrors()) {
                System.err.println("Errores en la construcción de la tabla de símbolos:");
                for (String error : symbolBuilder.getErrors()) {
                    System.err.println("  " + error);
                }
                return;
            }

            symbolTable.printSymbolTable();
            System.out.println("Tabla de símbolos construida exitosamente");
            System.out.println("-------------------------------");

            // 2. Análisis semántico completo
            System.out.println("\nIniciando análisis semántico:");
            System.out.println("-------------------------------");
            SemanticAnalyzer semanticAnalyzer = new SemanticAnalyzer(symbolTable);
            semanticAnalyzer.visit(tree);

            if (semanticAnalyzer.hasErrors()) {
                System.err.println("Errores semánticos encontrados:");
                for (String error : semanticAnalyzer.getErrors()) {
                    System.err.println("  " + error);
                }
                return;
            }

            System.out.println("Análisis semántico completado con éxito");
            System.out.println("-------------------------------");

            // 3. Generación de código
            System.out.println("\nIniciando generación de código:");
            System.out.println("-------------------------------");
            CodeGenerator codeGenerator = new CodeGenerator(symbolTable);
            codeGenerator.visit(tree);
            String generatedCode = codeGenerator.getGeneratedCode();

            // Guardar código generado a un archivo
            String nombreArchivoSalida = rutaArchivo.replaceAll("\\.txt$", ".js");
            Files.write(Paths.get(nombreArchivoSalida), generatedCode.getBytes());
            System.out.println("Código generado guardado en: " + nombreArchivoSalida);

            // Mostrar código generado
            System.out.println("\nCódigo generado:");
            System.out.println("---------------------");
            System.out.println(generatedCode);
            System.out.println("---------------------");

            System.out.println("\nCompilación completada con éxito");
            System.out.println("-------------------------------");

            // 4. Ejecución del visitor original (para mantener compatibilidad)
            System.out.println("\nIniciando recorrido del árbol con el visitor original:");
            System.out.println("---------------------------------------");
            MyVisitor visitor = new MyVisitor();
            visitor.visit(tree);
            System.out.println("---------------------------------------");

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
}