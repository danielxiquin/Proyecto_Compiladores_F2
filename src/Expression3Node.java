public class Expression3Node extends ASTNode {
    private String operator;
    private String right;
    private Expression3Node next;
    private boolean hasExpression;

    public Expression3Node(int line, int column) {
        super(line, column);
        this.hasExpression = false;
    }

    public Expression3Node(int line, int column, String operator, String right, Expression3Node next) {
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

    public String getRight() {
        return right;
    }

    public Expression3Node getNext() {
        return next;
    }

    @Override
    public String toString() {
        if (hasExpression) {
            return "Expression3(" + operator + ", " + right + ", " + next + ")";
        } else {
            return "Expression3()";
        }
    }
}