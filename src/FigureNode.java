public class FigureNode extends ASTNode {
    private int number;
    private AritmeticaNode aritmetica;

    public FigureNode(int line, int column, int number, AritmeticaNode aritmetica) {
        super(line, column);
        this.number = number;
        this.aritmetica = aritmetica;
    }

    public int getNumber() {
        return number;
    }

    public AritmeticaNode getAritmetica() {
        return aritmetica;
    }
}
