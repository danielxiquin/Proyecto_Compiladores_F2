public class MainNode extends ASTNode {
    private StatementNode statement;
    private StatementListTailNode statementListTail;

    public MainNode(int line, int column, StatementNode statement, StatementListTailNode statementListTail) {
        super(line, column);
        this.statement = statement;
        this.statementListTail = statementListTail;
    }

    public StatementNode getStatement() {
        return statement;
    }

    public StatementListTailNode getStatementListTail() {
        return statementListTail;
    }
}
