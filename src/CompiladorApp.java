import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.atn.PredictionMode;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CompiladorApp {
    public static void main(String[] args) {
        if (args.length > 0) {
            analizarArchivo(args[0]);
        } else {
            analizarArchivosDePrueba();
        }
    }

    private static void analizarArchivosDePrueba() {
        String[] archivos = {
                "prueba1_hola_mundo.txt"};

        for (String archivo : archivos) {
            System.out.println("\n===========================================");
            System.out.println("Analizando archivo: " + archivo);
            System.out.println("===========================================");

            try {
                analizarArchivo("pruebas/" + archivo);
            } catch (Exception e) {
                System.out.println("Error al analizar el archivo " + archivo + ": " + e.getMessage());
                e.printStackTrace();
            }

            System.out.println("\n");
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

            MyLanguageLexer lexer = new MyLanguageLexer(input);

            lexer.removeErrorListeners();
            lexer.addErrorListener(new BaseErrorListener() {
                @Override
                public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
                                        int line, int charPositionInLine,
                                        String msg, RecognitionException e) {
                    throw new RuntimeException("Error léxico en línea " + line + ":" + charPositionInLine + " - " + msg);
                }
            });

            lexer.reset();
            System.out.println("Tokens reconocidos:");
            for (Token token = lexer.nextToken(); token.getType() != Token.EOF; token = lexer.nextToken()) {
                System.out.println(token.getText() + " - Tipo: " + token.getType() + " - " + lexer.getVocabulary().getDisplayName(token.getType()));
            }
            lexer.reset();

            CommonTokenStream tokens = new CommonTokenStream(lexer);

            MyLanguageParser parser = new MyLanguageParser(tokens);

            parser.removeErrorListeners();
            parser.addErrorListener(new BaseErrorListener() {
                @Override
                public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
                                        int line, int charPositionInLine,
                                        String msg, RecognitionException e) {
                    throw new RuntimeException("Error sintáctico en línea " + line + ":" + charPositionInLine + " - " + msg);
                }
            });

            System.out.println("\nInformación detallada del parsing:");
            System.out.println("--------------------------------");
            parser.addErrorListener(new DiagnosticErrorListener(true));
            parser.getInterpreter().setPredictionMode(PredictionMode.LL_EXACT_AMBIG_DETECTION);

            parser.setTrace(true);

            parser.setBuildParseTree(true);

            parser.addParseListener(new ParseTreeListener() {
                @Override
                public void visitTerminal(TerminalNode node) {
                    System.out.println("Consumido: " + node.getText() + " - Tipo: " +
                            parser.getVocabulary().getDisplayName(node.getSymbol().getType()));
                }

                @Override
                public void visitErrorNode(ErrorNode node) {
                    System.out.println("Error: " + node.getText());
                }

                @Override
                public void enterEveryRule(ParserRuleContext ctx) {
                    System.out.println("Entrando en regla: " + parser.getRuleNames()[ctx.getRuleIndex()]);
                }

                @Override
                public void exitEveryRule(ParserRuleContext ctx) {
                    System.out.println("Saliendo de regla: " + parser.getRuleNames()[ctx.getRuleIndex()]);
                }
            });

            ParseTree tree = parser.program();

            System.out.println("--------------------------------");

            MyVisitor visitor = new MyVisitor();

            System.out.println("\nIniciando recorrido del árbol de sintaxis:");
            System.out.println("---------------------------------------");

            visitor.visit(tree);

            System.out.println("---------------------------------------");
            System.out.println("Análisis completado con éxito.");

        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        } catch (RuntimeException e) {
            System.err.println("Error de compilación: " + e.getMessage());
        }
    }

    private static String leerArchivo(String rutaArchivo) throws IOException {
        return new String(Files.readAllBytes(Paths.get(rutaArchivo)));
    }
}