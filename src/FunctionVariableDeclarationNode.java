public class FunctionVariableDeclarationNode extends ASTNode {
    private String type;
    private String id;

    public FunctionVariableDeclarationNode(int line, int column, String type, String id) {
        super(line, column);
        this.type = type;
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }
}
