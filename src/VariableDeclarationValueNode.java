public class VariableDeclarationValueNode extends ASTNode {
    private VariableNode value;
    private FunctionCallExprNode functionCall;
    private boolean hasValue;
    private boolean isFunctionCall;

    // Constructor para cuando no hay valor asignado
    public VariableDeclarationValueNode(int line, int column) {
        super(line, column);
        this.hasValue = false;
        this.isFunctionCall = false;
    }

    // Constructor para cuando se asigna una variable
    public VariableDeclarationValueNode(int line, int column, VariableNode value) {
        super(line, column);
        this.value = value;
        this.hasValue = true;
        this.isFunctionCall = false;
    }

    // Constructor para cuando se asigna una llamada a función
    public VariableDeclarationValueNode(int line, int column, FunctionCallExprNode functionCall) {
        super(line, column);
        this.functionCall = functionCall;
        this.hasValue = true;
        this.isFunctionCall = true;
    }

    public boolean hasValue() {
        return hasValue;
    }

    public boolean isFunctionCall() {
        return isFunctionCall;
    }

    public VariableNode getValue() {
        return value;
    }

    public FunctionCallExprNode getFunctionCall() {
        return functionCall;
    }

    @Override
    public String toString() {
        if (!hasValue) {
            return "VariableDeclarationValue()";
        } else if (isFunctionCall) {
            return "VariableDeclarationValue(" + functionCall + ")";
        } else {
            return "VariableDeclarationValue(" + value + ")";
        }
    }
}