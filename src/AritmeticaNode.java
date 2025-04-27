public class AritmeticaNode extends ASTNode {
    private String operator;
    private Integer number;
    private String id;
    private AritmeticaNode next;

    // Constructor para operador + número
    public AritmeticaNode(int line, int column, String operator, Integer number, AritmeticaNode next) {
        super(line, column);
        this.operator = operator;
        this.number = number;
        this.id = null;
        this.next = next;
    }

    // Constructor para operador + ID
    public AritmeticaNode(int line, int column, String operator, String id, AritmeticaNode next) {
        super(line, column);
        this.operator = operator;
        this.number = null;
        this.id = id;
        this.next = next;
    }

    // Constructor para epsilon
    public AritmeticaNode(int line, int column) {
        super(line, column);
        this.operator = null;
        this.number = null;
        this.id = null;
        this.next = null;
    }

    public String getOperator() {
        return operator;
    }

    public Integer getNumber() {
        return number;
    }

    public String getId() {
        return id;
    }

    public AritmeticaNode getNext() {
        return next;
    }

    public boolean isEmpty() {
        return operator == null;
    }

    public boolean hasNumber() {
        return number != null;
    }

    public boolean hasId() {
        return id != null;
    }
}
