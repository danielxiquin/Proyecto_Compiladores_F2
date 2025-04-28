public class WhichConditionNode extends ASTNode {
    private Boolean boolValue;
    private ConditionNode condition;

    // Constructor para boolean
    public WhichConditionNode(int line, int column, Boolean boolValue) {
        super(line, column);
        this.boolValue = boolValue;
        this.condition = null;
    }

    // Constructor para condición
    public WhichConditionNode(int line, int column, ConditionNode condition) {
        super(line, column);
        this.boolValue = null;
        this.condition = condition;
    }

    public Boolean getBoolValue() {
        return boolValue;
    }

    public ConditionNode getCondition() {
        return condition;
    }

    public boolean isBool() {
        return boolValue != null;
    }
}
