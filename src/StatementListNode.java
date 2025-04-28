public class StatementListNode extends ASTNode {
    private MainNode main;
    private FunctionDeclarationNode functionDeclaration;
    private StatementListNode nextStatementList;

    // Constructor para lista que comienza con main
    public StatementListNode(int line, int column, MainNode main) {
        super(line, column);
        this.main = main;
        this.functionDeclaration = null;
        this.nextStatementList = null;
    }

    // Constructor para lista que comienza con función
    public StatementListNode(int line, int column, FunctionDeclarationNode functionDeclaration, StatementListNode nextStatementList) {
        super(line, column);
        this.main = null;
        this.functionDeclaration = functionDeclaration;
        this.nextStatementList = nextStatementList;
    }

    public MainNode getMain() {
        return main;
    }

    public FunctionDeclarationNode getFunctionDeclaration() {
        return functionDeclaration;
    }

    public StatementListNode getNextStatementList() {
        return nextStatementList;
    }
}
