public class Expression2Node extends ASTNode {
    private String operator;
    private VariableNode right;
    private Expression2Node next;
    private boolean hasExpression;

    public Expression2Node(int line, int column) {
        super(line, column);
        this.hasExpression = false;
    }

    public Expression2Node(int line, int column, String operator, VariableNode right, Expression2Node next) {
        super(line, column);
        this.operator = operator;
        this.right = right;
        this.next = next;
        this.hasExpression = true;
    }

    public boolean hasExpression() {
        return hasExpression;
    }

    public String getOperator() {
        return operator;
    }

    public VariableNode getRight() {
        return right;
    }

    public Expression2Node getNext() {
        return next;
    }

    @Override
    public String toString() {
        if (hasExpression) {
            return "Expression2(" + operator + ", " + right + ", " + next + ")";
        } else {
            return "Expression2()";
        }
    }
}