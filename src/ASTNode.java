// Clase base para todos los nodos AST
public abstract class ASTNode {
    protected int line;
    protected int column;
    
    public ASTNode(int line, int column) {
        this.line = line;
        this.column = column;
    }
    
    public int getLine() {
        return line;
    }
    
    public int getColumn() {
        return column;
    }
}




// Seguiría con el resto de clases para Expression1, Expression2, Expression3, etc.









