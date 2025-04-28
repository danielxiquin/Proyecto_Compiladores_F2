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

    @Override
    public ASTNode visitMain(MyLanguageParser.MainContext ctx) {
        StatementNode statement = (StatementNode) visit(ctx.statement());
        StatementListTailNode statementListTail = (StatementListTailNode) visit(ctx.statementListTail());
        return new MainNode(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), statement, statementListTail);
    }

    @Override
    public ASTNode visitStatementListTail(MyLanguageParser.StatementListTailContext ctx) {
        if (ctx.statement() != null) {
            StatementNode statement = (StatementNode) visit(ctx.statement());
            StatementListTailNode next = (StatementListTailNode) visit(ctx.statementListTail());
            return new StatementListTailNode(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), statement, next);
        } else {
            // Caso epsilon
            return new StatementListTailNode(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
        }
    }

    @Override
    public ASTNode visitStatement(MyLanguageParser.StatementContext ctx) {
        if (ctx.variableDeclarationEmpty() != null) {
            return visit(ctx.variableDeclarationEmpty());
        } else if (ctx.ifStatement() != null) {
            return visit(ctx.ifStatement());
        } else if (ctx.whileStatement() != null) {
            return visit(ctx.whileStatement());
        } else if (ctx.functionCall() != null) {
            return visit(ctx.functionCall());
        } else if (ctx.inputStatement() != null) {
            return visit(ctx.inputStatement());
        } else if (ctx.outputStatement() != null) {
            return visit(ctx.outputStatement());
        } else if (ctx.variableAssigment() != null) {
            return visit(ctx.variableAssigment());
        }
        throw new RuntimeException("Tipo de instrucción no reconocida");
    }

   
}