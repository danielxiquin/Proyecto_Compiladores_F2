public class ParameterListTailNode extends ASTNode {
    private FunctionVariableDeclarationNode declaration;
    private ParameterListTailNode next;

    // Constructor para lista que continúa
    public ParameterListTailNode(int line, int column, FunctionVariableDeclarationNode declaration, ParameterListTailNode next) {
        super(line, column);
        this.declaration = declaration;
        this.next = next;
    }

    // Constructor para epsilon (fin de lista)
    public ParameterListTailNode(int line, int column) {
        super(line, column);
        this.declaration = null;
        this.next = null;
    }

    public FunctionVariableDeclarationNode getDeclaration() {
        return declaration;
    }

    public ParameterListTailNode getNext() {
        return next;
    }

    public boolean isEmpty() {
        return declaration == null;
    }
}
