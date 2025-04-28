
public class VariableDeclarationNode extends StatementNode {
    private String type;
    private String id;
    private VariableDeclarationValueNode value;

    public VariableDeclarationNode(int line, int column, String type, String id, VariableDeclarationValueNode value) {
        super(line, column);
        this.type = type;
        this.id = id;
        this.value = value;
    }

    public VariableDeclarationValueNode getValue() {
        return value;
    }
}