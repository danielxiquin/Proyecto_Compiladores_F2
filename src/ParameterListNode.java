public class ParameterListNode extends ASTNode {
    private FunctionVariableDeclarationNode declaration;
    private ParameterListTailNode tail;

    // Constructor para lista con parámetros
    public ParameterListNode(int line, int column, FunctionVariableDeclarationNode declaration, ParameterListTailNode tail) {
        super(line, column);
        this.declaration = declaration;
        this.tail = tail;
    }

    // Constructor para epsilon (sin parámetros)
    public ParameterListNode(int line, int column) {
        super(line, column);
        this.declaration = null;
        this.tail = null;
    }

    public FunctionVariableDeclarationNode getDeclaration() {
        return declaration;
    }

    public ParameterListTailNode getTail() {
        return tail;
    }

    public boolean isEmpty() {
        return declaration == null;
    }
}
