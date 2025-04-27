public class ElsePartNode extends ASTNode {
    private StatementListNode body;

    // Constructor para else presente
    public ElsePartNode(int line, int column, StatementListNode body) {
        super(line, column);
        this.body = body;
    }

    // Constructor para epsilon (sin else)
    public ElsePartNode(int line, int column) {
        super(line, column);
        this.body = null;
    }

    public StatementListNode getBody() {
        return body;
    }

    public boolean hasElse() {
        return body != null;
    }
}
