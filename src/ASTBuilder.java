import org.antlr.v4.runtime.tree.ParseTree;

/**
 * Esta clase construye el AST a partir del árbol de análisis sintáctico
 * generado por ANTLR.
 */
public class ASTBuilder extends MyLanguageBaseVisitor<ASTNode> {

    @Override
    public ASTNode visitProgram(MyLanguageParser.ProgramContext ctx) {
        StatementListNode statementList = (StatementListNode) visit(ctx.statementList());
        return new ProgramNode(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), statementList);
    }

    @Override
    public ASTNode visitStatementList(MyLanguageParser.StatementListContext ctx) {
        if (ctx.main() != null) {
            MainNode main = (MainNode) visit(ctx.main());
            return new StatementListNode(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), main);
        } else {
            FunctionDeclarationNode functionDeclaration = (FunctionDeclarationNode) visit(ctx.functionDeclaration());
            StatementListNode nextStatementList = (StatementListNode) visit(ctx.statementList());
            return new StatementListNode(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), functionDeclaration, nextStatementList);
        }
    }
}