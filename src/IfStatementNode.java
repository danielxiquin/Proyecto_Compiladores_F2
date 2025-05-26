public class IfStatementNode extends StatementNode {
    private WhichConditionNode condition;
    private StatementListTailNode body;
    private ElsePartNode elsePart;

    public IfStatementNode(int line, int column, WhichConditionNode condition, StatementListTailNode body, ElsePartNode elsePart) {
        super(line, column);
        this.condition = condition;
        this.body = body;
        this.elsePart = elsePart;
    }

    public WhichConditionNode getCondition() {
        return condition;
    }

    public StatementListTailNode getBody() {
        return body;
    }

    public ElsePartNode getElsePart() {
        return elsePart;
    }
}
