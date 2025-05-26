public class NumbersConditionNode extends ASTNode {
    private boolean isInteger;
    private int intValue;
    private float floatValue;

    // Constructor para enteros
    public NumbersConditionNode(int line, int column, int value) {
        super(line, column);
        this.intValue = value;
        this.isInteger = true;
    }

    // Constructor para flotantes
    public NumbersConditionNode(int line, int column, float value) {
        super(line, column);
        this.floatValue = value;
        this.isInteger = false;
    }

    public boolean isInteger() {
        return isInteger;
    }

    public int getIntValue() {
        return intValue;
    }

    public float getFloatValue() {
        return floatValue;
    }

    @Override
    public String toString() {
        if (isInteger) {
            return "NumbersCondition(" + intValue + ")";
        } else {
            return "NumbersCondition(" + floatValue + ")";
        }
    }
}