import java.util.List;

public class FunctionCallExprNode extends ASTNode {
    private String id;
    private ArgumentListNode arguments;

    public FunctionCallExprNode(int line, int column, String id, ArgumentListNode arguments) {
        super(line, column);
        this.id = id;
        this.arguments = arguments;
    }

    public String getId() {
        return id;
    }

    public ArgumentListNode getArguments() {
        return arguments;
    }

    @Override
    public String toString() {
        return "FunctionCallExpr(" + id + ", " + arguments + ")";
    }

    public String generateCode() {
        StringBuilder sb = new StringBuilder();
        sb.append(id).append("(");

        List<VariableNode> args = arguments.getArguments();
        for (int i = 0; i < args.size(); i++) {
            VariableNode arg = args.get(i);

            // Generar código según el tipo de valor en VariableNode
            if (arg.isString()) {
                sb.append("\"").append(arg.getStringValue()).append("\"");
            } else if (arg.isBool()) {
                sb.append(arg.getBoolValue());
            } else if (arg.isFloat()) {
                sb.append(arg.getFloatValue());
            } else if (arg.isId()) {
                sb.append(arg.getId());
                if (arg.getAritmetica() != null) {
                    // Asumiendo que AritmeticaNode tiene un método generateCode()
                }
            } else if (arg.isFigure()) {

                sb.append(arg.getFigure().toString());
            }

            if (i < args.size() - 1) {
                sb.append(", ");
            }
        }

        sb.append(")");
        return sb.toString();
    }
}