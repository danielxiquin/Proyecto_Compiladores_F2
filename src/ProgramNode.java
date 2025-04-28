public class ProgramNode extends ASTNode {
    private StatementListNode statementList;

    public ProgramNode(int line, int column, StatementListNode statementList) {
        super(line, column);
        this.statementList = statementList;
    }
}
