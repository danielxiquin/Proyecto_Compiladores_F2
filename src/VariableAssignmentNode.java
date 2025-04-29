public class VariableAssignmentNode extends StatementNode {
    private String id;
    private VariableNode value;

    public VariableAssignmentNode(int line, int column, String id, VariableNode value) {
        super(line, column);
        this.id = id;
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public VariableNode getValue() {
        return value;
    }
}
