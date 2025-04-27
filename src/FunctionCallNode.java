public class FunctionCallNode extends StatementNode {
    private String id;
    private ParameterListNode parameters;

    public FunctionCallNode(int line, int column, String id, ParameterListNode parameters) {
        super(line, column);
        this.id = id;
        this.parameters = parameters;
    }

    public String getId() {
        return id;
    }

    public ParameterListNode getParameters() {
        return parameters;
    }
}

