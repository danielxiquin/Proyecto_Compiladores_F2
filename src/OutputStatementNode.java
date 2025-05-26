/**
 * Clase que representa un nodo de instrucción de salida (write) en el AST.
 */
public class OutputStatementNode extends StatementNode {
    private String value;
    private boolean isVariable;

    /**
     * Constructor para la instrucción de salida.
     *
     * @param line Línea en el código fuente
     * @param column Columna en el código fuente
     * @param value Valor a mostrar (puede ser un string literal o un nombre de variable)
     * @param isVariable Indica si el valor es un identificador de variable
     */
    public OutputStatementNode(int line, int column, String value, boolean isVariable) {
        super(line, column);
        this.value = value;
        this.isVariable = isVariable;
    }

    /**
     * Obtiene el valor a mostrar.
     *
     * @return El valor como string
     */
    public String getValue() {
        return value;
    }

    /**
     * Indica si el valor es un identificador de variable.
     *
     * @return true si es un ID, false si es un string literal
     */
    public boolean isVariable() {
        return isVariable;
    }

    @Override
    public String toString() {
        if (isVariable) {
            return "OutputStatement(variable: " + value + ")";
        } else {
            return "OutputStatement(string: " + value + ")";
        }
    }

    /**
     * Método para generar código para esta instrucción.
     * Esto dependerá del lenguaje objetivo de tu compilador.
     */
    public String generateCode() {
        if (isVariable) {
            // Generar código para mostrar una variable
            return "System.out.println(" + value + ");";
        } else {
            // Generar código para mostrar un string literal
            return "System.out.println(" + value + ");";
        }
    }
}