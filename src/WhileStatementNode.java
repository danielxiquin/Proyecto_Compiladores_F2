public class WhileStatementNode extends StatementNode {
    private WhichConditionNode condition;
    private StatementListTailNode body;

    public WhileStatementNode(int line, int column, WhichConditionNode condition, StatementListTailNode body) {
        super(line, column);
        this.condition = condition;
        this.body = body;
    }

    public WhichConditionNode getCondition() {
        return condition;
    }

    public StatementListTailNode getBody() {
        return body;
    }
}
