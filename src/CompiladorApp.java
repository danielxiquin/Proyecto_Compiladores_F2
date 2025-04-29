import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CompiladorApp {
    public static void main(String[] args) {
        // Comprueba si se proporciona un argumento de línea de comando
        if (args.length > 0) {
            // Analiza el archivo especificado en la línea de comandos
            analizarArchivo(args[0]);
        } else {
            // Si no se proporciona un archivo, analiza todos los archivos de prueba
            analizarArchivosDePrueba();
        }
    }

    private static void analizarArchivosDePrueba() {
        // Lista de archivos de prueba
        String[] archivos = {
                "prueba1_hola_mundo.txt"};

        // Analiza cada archivo
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
            // Lee el contenido del archivo
            String contenido = leerArchivo(rutaArchivo);
            System.out.println("Contenido del archivo:");
            System.out.println("---------------------");
            System.out.println(contenido);
            System.out.println("---------------------\n");

            // Crea un CharStream a partir del contenido
            CharStream input = CharStreams.fromString(contenido);

            // Crea un lexer a partir del CharStream
            MyLanguageLexer lexer = new MyLanguageLexer(input);

            // Manejo de errores para el lexer
            lexer.removeErrorListeners();
            lexer.addErrorListener(new BaseErrorListener() {
                @Override
                public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
                                        int line, int charPositionInLine,
                                        String msg, RecognitionException e) {
                    throw new RuntimeException("Error léxico en línea " + line + ":" + charPositionInLine + " - " + msg);
                }
            });

            // Mostrar tokens reconocidos
            lexer.reset();
            System.out.println("Tokens reconocidos:");
            for (Token token = lexer.nextToken(); token.getType() != Token.EOF; token = lexer.nextToken()) {
                System.out.println(token.getText() + " - Tipo: " + token.getType() + " - " + lexer.getVocabulary().getDisplayName(token.getType()));
            }
            lexer.reset();

            // Crea un flujo de tokens a partir del lexer
            CommonTokenStream tokens = new CommonTokenStream(lexer);

            // Crea un parser a partir del flujo de tokens
            MyLanguageParser parser = new MyLanguageParser(tokens);

            // Manejo de errores para el parser
            parser.removeErrorListeners();
            parser.addErrorListener(new BaseErrorListener() {
                @Override
                public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
                                        int line, int charPositionInLine,
                                        String msg, RecognitionException e) {
                    throw new RuntimeException("Error sintáctico en línea " + line + ":" + charPositionInLine + " - " + msg);
                }
            });

            // Obtiene el árbol de análisis sintáctico
            ParseTree tree = parser.program();

            // Crea un visitador para recorrer el árbol
            MyVisitor visitor = new MyVisitor();

            System.out.println("Iniciando recorrido del árbol de sintaxis:");
            System.out.println("---------------------------------------");

            // Aplica el visitador al árbol
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