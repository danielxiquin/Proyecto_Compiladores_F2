public class InputStatementNode extends StatementNode {
    private String id;

    public InputStatementNode(int line, int column, String id) {
        super(line, column);
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
