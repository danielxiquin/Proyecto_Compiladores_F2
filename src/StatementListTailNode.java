
public class StatementListTailNode extends ASTNode {
    private StatementNode statement;
    private StatementListTailNode next;

    // Constructor para lista que continúa
    public StatementListTailNode(int line, int column, StatementNode statement, StatementListTailNode next) {
        super(line, column);
        this.statement = statement;
        this.next = next;
    }

    // Constructor para fin de lista (epsilon)
    public StatementListTailNode(int line, int column) {
        super(line, column);
        this.statement = null;
        this.next = null;
    }

    public StatementNode getStatement() {
        return statement;
    }

    public StatementListTailNode getNext() {
        return next;
    }

    public boolean isEmpty() {
        return statement == null;
    }
}
