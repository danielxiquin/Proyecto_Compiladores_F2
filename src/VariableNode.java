public class VariableNode extends ASTNode {
    private String stringValue;
    private Boolean boolValue;
    private FigureNode figure;
    private Float floatValue;
    private String id;
    private AritmeticaNode aritmetica;

    // Constructor para string
    public VariableNode(int line, int column, String stringValue) {
        super(line, column);
        this.stringValue = stringValue;
        this.boolValue = null;
        this.figure = null;
        this.floatValue = null;
        this.id = null;
        this.aritmetica = null;
    }

    // Constructor para boolean
    public VariableNode(int line, int column, Boolean boolValue) {
        super(line, column);
        this.stringValue = null;
        this.boolValue = boolValue;
        // this.figure = null;
        this.floatValue = null;
        this.id = null;
        this.aritmetica = null;
    }

    // Constructor para figure
    public VariableNode(int line, int column, FigureNode figure) {
        super(line, column);
        this.stringValue = null;
        this.boolValue = null;
        // this.figure = figure;
        // this.floatValue = null;
        // this.id = null;
        this.aritmetica = null;
    }

    // Constructor para float
    public VariableNode(int line, int column, Float floatValue) {
        super(line, column);
        // this.stringValue = null;
        this.boolValue = null;
        // this.figure = null;
        this.floatValue = floatValue;
        this.id = null;
        this.aritmetica = null;
    }
}
