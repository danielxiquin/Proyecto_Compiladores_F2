import java.util.ArrayList;
import java.util.List;


public class ArgumentListNode extends ASTNode {
    private List<VariableNode> arguments;

    public ArgumentListNode(int line, int column) {
        super(line, column);
        this.arguments = new ArrayList<>();
    }


    public void addArgument(VariableNode argument) {
        arguments.add(argument);
    }

    public List<VariableNode> getArguments() {
        return arguments;
    }

    public boolean isEmpty() {
        return arguments.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("ArgumentList(");
        for (int i = 0; i < arguments.size(); i++) {
            sb.append(arguments.get(i));
            if (i < arguments.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append(")");
        return sb.toString();
    }
}