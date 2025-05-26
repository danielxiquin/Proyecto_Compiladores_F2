public class FunctionDeclarationNode extends ASTNode {
    private String id;
    private ParameterListNode parameters;
    private StatementListTailNode body;
    private VariableNode returnValue;

    public FunctionDeclarationNode(int line, int column, String id, ParameterListNode parameters,
                                   StatementListTailNode body, VariableNode returnValue) {
        super(line, column);
        this.id = id;
        this.parameters = parameters;
        this.body = body;
        this.returnValue = returnValue;
    }

    public String getId() {
        return id;
    }

    public ParameterListNode getParameters() {
        return parameters;
    }

    public StatementListTailNode getBody() {
        return body;
    }

    public VariableNode getReturnValue() {
        return returnValue;
    }
}
