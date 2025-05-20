// Generated from grammar/MyLanguage.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MyLanguageParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MyLanguageVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MyLanguageParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(MyLanguageParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLanguageParser#statementList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementList(MyLanguageParser.StatementListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLanguageParser#main}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMain(MyLanguageParser.MainContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLanguageParser#statementListTail}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementListTail(MyLanguageParser.StatementListTailContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLanguageParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(MyLanguageParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLanguageParser#variableDeclarationEmpty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclarationEmpty(MyLanguageParser.VariableDeclarationEmptyContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLanguageParser#variableAssigment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableAssigment(MyLanguageParser.VariableAssigmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLanguageParser#variableDeclarationValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclarationValue(MyLanguageParser.VariableDeclarationValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLanguageParser#functionCallExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCallExpr(MyLanguageParser.FunctionCallExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLanguageParser#argumentList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumentList(MyLanguageParser.ArgumentListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLanguageParser#functionVariableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionVariableDeclaration(MyLanguageParser.FunctionVariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLanguageParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(MyLanguageParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLanguageParser#figure}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFigure(MyLanguageParser.FigureContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLanguageParser#aritmetica}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAritmetica(MyLanguageParser.AritmeticaContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLanguageParser#whichCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhichCondition(MyLanguageParser.WhichConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLanguageParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(MyLanguageParser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLanguageParser#numbersCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumbersCondition(MyLanguageParser.NumbersConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLanguageParser#expression1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression1(MyLanguageParser.Expression1Context ctx);
	/**
	 * Visit a parse tree produced by {@link MyLanguageParser#expression2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression2(MyLanguageParser.Expression2Context ctx);
	/**
	 * Visit a parse tree produced by {@link MyLanguageParser#expression3}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression3(MyLanguageParser.Expression3Context ctx);
	/**
	 * Visit a parse tree produced by {@link MyLanguageParser#relationOperator2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationOperator2(MyLanguageParser.RelationOperator2Context ctx);
	/**
	 * Visit a parse tree produced by {@link MyLanguageParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(MyLanguageParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLanguageParser#elsePart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElsePart(MyLanguageParser.ElsePartContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLanguageParser#whileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement(MyLanguageParser.WhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLanguageParser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(MyLanguageParser.FunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLanguageParser#functionDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDeclaration(MyLanguageParser.FunctionDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLanguageParser#parameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterList(MyLanguageParser.ParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLanguageParser#parameterListTail}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterListTail(MyLanguageParser.ParameterListTailContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLanguageParser#inputStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInputStatement(MyLanguageParser.InputStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLanguageParser#outputStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOutputStatement(MyLanguageParser.OutputStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLanguageParser#operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperator(MyLanguageParser.OperatorContext ctx);
}