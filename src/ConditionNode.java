public class ConditionNode extends ASTNode {
    private NumbersConditionNode numbersCondition;
    private Expression1Node expression1;
    private String stringValue;
    private Expression3Node expression3;
    private String id;
    private Expression2Node expression2;

    // Constructor para números
    public ConditionNode(int line, int column, NumbersConditionNode numbersCondition, Expression1Node expression1) {
        super(line, column);
        this.numbersCondition = numbersCondition;
        this.expression1 = expression1;
        this.stringValue = null;
        this.expression3 = null;
        this.id = null;
        this.expression2 = null;
    }

    // Constructor para string
    public ConditionNode(int line, int column, String stringValue, Expression3Node expression3) {
        super(line, column);
        this.numbersCondition = null;
        this.expression1 = null;
        this.stringValue = stringValue;
        this.expression3 = expression3;
        this.id = null;
        this.expression2 = null;
    }

    // Constructor para ID
    public ConditionNode(int line, int column, String id, Expression2Node expression2) {
        super(line, column);
        this.numbersCondition = null;
        this.expression1 = null;
        this.stringValue = null;
        this.expression3 = null;
        this.id = id;
        this.expression2 = expression2;
    }

    // Getters y helpers
    public NumbersConditionNode getNumbersCondition() { return numbersCondition; }
    public Expression1Node getExpression1() { return expression1; }
    public String getStringValue() { return stringValue; }
    public Expression3Node getExpression3() { return expression3; }
    public String getId() { return id; }
    public Expression2Node getExpression2() { return expression2; }

    public boolean isNumbers() { return numbersCondition != null; }
    public boolean isString() { return stringValue != null; }
    public boolean isId() { return id != null; }
}
