// Generated from grammar/MyLanguage.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MyLanguageParser}.
 */
public interface MyLanguageListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MyLanguageParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(MyLanguageParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLanguageParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(MyLanguageParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLanguageParser#statementList}.
	 * @param ctx the parse tree
	 */
	void enterStatementList(MyLanguageParser.StatementListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLanguageParser#statementList}.
	 * @param ctx the parse tree
	 */
	void exitStatementList(MyLanguageParser.StatementListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLanguageParser#main}.
	 * @param ctx the parse tree
	 */
	void enterMain(MyLanguageParser.MainContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLanguageParser#main}.
	 * @param ctx the parse tree
	 */
	void exitMain(MyLanguageParser.MainContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLanguageParser#statementListTail}.
	 * @param ctx the parse tree
	 */
	void enterStatementListTail(MyLanguageParser.StatementListTailContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLanguageParser#statementListTail}.
	 * @param ctx the parse tree
	 */
	void exitStatementListTail(MyLanguageParser.StatementListTailContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(MyLanguageParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(MyLanguageParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLanguageParser#variableDeclarationEmpty}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclarationEmpty(MyLanguageParser.VariableDeclarationEmptyContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLanguageParser#variableDeclarationEmpty}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclarationEmpty(MyLanguageParser.VariableDeclarationEmptyContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLanguageParser#variableAssigment}.
	 * @param ctx the parse tree
	 */
	void enterVariableAssigment(MyLanguageParser.VariableAssigmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLanguageParser#variableAssigment}.
	 * @param ctx the parse tree
	 */
	void exitVariableAssigment(MyLanguageParser.VariableAssigmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLanguageParser#variableDeclarationValue}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclarationValue(MyLanguageParser.VariableDeclarationValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLanguageParser#variableDeclarationValue}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclarationValue(MyLanguageParser.VariableDeclarationValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLanguageParser#functionCallExpr}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCallExpr(MyLanguageParser.FunctionCallExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLanguageParser#functionCallExpr}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCallExpr(MyLanguageParser.FunctionCallExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLanguageParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void enterArgumentList(MyLanguageParser.ArgumentListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLanguageParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void exitArgumentList(MyLanguageParser.ArgumentListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLanguageParser#functionVariableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFunctionVariableDeclaration(MyLanguageParser.FunctionVariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLanguageParser#functionVariableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFunctionVariableDeclaration(MyLanguageParser.FunctionVariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLanguageParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(MyLanguageParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLanguageParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(MyLanguageParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLanguageParser#figure}.
	 * @param ctx the parse tree
	 */
	void enterFigure(MyLanguageParser.FigureContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLanguageParser#figure}.
	 * @param ctx the parse tree
	 */
	void exitFigure(MyLanguageParser.FigureContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLanguageParser#aritmetica}.
	 * @param ctx the parse tree
	 */
	void enterAritmetica(MyLanguageParser.AritmeticaContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLanguageParser#aritmetica}.
	 * @param ctx the parse tree
	 */
	void exitAritmetica(MyLanguageParser.AritmeticaContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLanguageParser#whichCondition}.
	 * @param ctx the parse tree
	 */
	void enterWhichCondition(MyLanguageParser.WhichConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLanguageParser#whichCondition}.
	 * @param ctx the parse tree
	 */
	void exitWhichCondition(MyLanguageParser.WhichConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLanguageParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(MyLanguageParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLanguageParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(MyLanguageParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLanguageParser#numbersCondition}.
	 * @param ctx the parse tree
	 */
	void enterNumbersCondition(MyLanguageParser.NumbersConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLanguageParser#numbersCondition}.
	 * @param ctx the parse tree
	 */
	void exitNumbersCondition(MyLanguageParser.NumbersConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLanguageParser#expression1}.
	 * @param ctx the parse tree
	 */
	void enterExpression1(MyLanguageParser.Expression1Context ctx);
	/**
	 * Exit a parse tree produced by {@link MyLanguageParser#expression1}.
	 * @param ctx the parse tree
	 */
	void exitExpression1(MyLanguageParser.Expression1Context ctx);
	/**
	 * Enter a parse tree produced by {@link MyLanguageParser#expression2}.
	 * @param ctx the parse tree
	 */
	void enterExpression2(MyLanguageParser.Expression2Context ctx);
	/**
	 * Exit a parse tree produced by {@link MyLanguageParser#expression2}.
	 * @param ctx the parse tree
	 */
	void exitExpression2(MyLanguageParser.Expression2Context ctx);
	/**
	 * Enter a parse tree produced by {@link MyLanguageParser#expression3}.
	 * @param ctx the parse tree
	 */
	void enterExpression3(MyLanguageParser.Expression3Context ctx);
	/**
	 * Exit a parse tree produced by {@link MyLanguageParser#expression3}.
	 * @param ctx the parse tree
	 */
	void exitExpression3(MyLanguageParser.Expression3Context ctx);
	/**
	 * Enter a parse tree produced by {@link MyLanguageParser#relationOperator2}.
	 * @param ctx the parse tree
	 */
	void enterRelationOperator2(MyLanguageParser.RelationOperator2Context ctx);
	/**
	 * Exit a parse tree produced by {@link MyLanguageParser#relationOperator2}.
	 * @param ctx the parse tree
	 */
	void exitRelationOperator2(MyLanguageParser.RelationOperator2Context ctx);
	/**
	 * Enter a parse tree produced by {@link MyLanguageParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(MyLanguageParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLanguageParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(MyLanguageParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLanguageParser#elsePart}.
	 * @param ctx the parse tree
	 */
	void enterElsePart(MyLanguageParser.ElsePartContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLanguageParser#elsePart}.
	 * @param ctx the parse tree
	 */
	void exitElsePart(MyLanguageParser.ElsePartContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLanguageParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(MyLanguageParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLanguageParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(MyLanguageParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLanguageParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(MyLanguageParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLanguageParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(MyLanguageParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLanguageParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDeclaration(MyLanguageParser.FunctionDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLanguageParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDeclaration(MyLanguageParser.FunctionDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLanguageParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void enterParameterList(MyLanguageParser.ParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLanguageParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void exitParameterList(MyLanguageParser.ParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLanguageParser#parameterListTail}.
	 * @param ctx the parse tree
	 */
	void enterParameterListTail(MyLanguageParser.ParameterListTailContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLanguageParser#parameterListTail}.
	 * @param ctx the parse tree
	 */
	void exitParameterListTail(MyLanguageParser.ParameterListTailContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLanguageParser#inputStatement}.
	 * @param ctx the parse tree
	 */
	void enterInputStatement(MyLanguageParser.InputStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLanguageParser#inputStatement}.
	 * @param ctx the parse tree
	 */
	void exitInputStatement(MyLanguageParser.InputStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLanguageParser#outputStatement}.
	 * @param ctx the parse tree
	 */
	void enterOutputStatement(MyLanguageParser.OutputStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLanguageParser#outputStatement}.
	 * @param ctx the parse tree
	 */
	void exitOutputStatement(MyLanguageParser.OutputStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLanguageParser#operator}.
	 * @param ctx the parse tree
	 */
	void enterOperator(MyLanguageParser.OperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLanguageParser#operator}.
	 * @param ctx the parse tree
	 */
	void exitOperator(MyLanguageParser.OperatorContext ctx);
}