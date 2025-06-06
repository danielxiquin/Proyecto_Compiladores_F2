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

    @Override
    public ASTNode visitVariableDeclarationEmpty(MyLanguageParser.VariableDeclarationEmptyContext ctx) {
        String type = ctx.TYPE().getText();
        String id = ctx.ID().getText();
        VariableDeclarationValueNode value = (VariableDeclarationValueNode) visit(ctx.variableDeclarationValue());
        return new VariableDeclarationNode(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), type, id, value);
    }

    @Override
    public ASTNode visitVariableAssigment(MyLanguageParser.VariableAssigmentContext ctx) {
        String id = ctx.ID().getText();
        VariableNode value = (VariableNode) visit(ctx.variable());
        return new VariableAssignmentNode(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), id, value);
    }

    @Override
    public ASTNode visitVariableDeclarationValue(MyLanguageParser.VariableDeclarationValueContext ctx) {
        if (ctx.variable() != null) {
            VariableNode value = (VariableNode) visit(ctx.variable());
            return new VariableDeclarationValueNode(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), value);
        } else if (ctx.functionCallExpr() != null) {
            FunctionCallExprNode functionCall = (FunctionCallExprNode) visit(ctx.functionCallExpr());
            return new VariableDeclarationValueNode(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), functionCall);
        } else {
            // Caso epsilon (sin valor asignado)
            return new VariableDeclarationValueNode(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
        }
    }

    @Override
    public ASTNode visitFunctionCallExpr(MyLanguageParser.FunctionCallExprContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        String id = ctx.ID().getText();
        ArgumentListNode arguments = (ArgumentListNode) visit(ctx.argumentList());

        return new FunctionCallExprNode(line, column, id, arguments);
    }

    @Override
    public ASTNode visitArgumentList(MyLanguageParser.ArgumentListContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        if (ctx.variable() != null && !ctx.variable().isEmpty()) {
            // Procesar los argumentos
            ArgumentListNode argumentList = new ArgumentListNode(line, column);

            // Procesar el primer argumento
            VariableNode firstArg = (VariableNode) visit(ctx.variable(0));
            argumentList.addArgument(firstArg);

            // Procesar los argumentos adicionales si existen
            for (int i = 1; i < ctx.variable().size(); i++) {
                VariableNode arg = (VariableNode) visit(ctx.variable(i));
                argumentList.addArgument(arg);
            }

            return argumentList;
        } else {
            // Caso epsilon (sin argumentos)
            return new ArgumentListNode(line, column);
        }
    }

    @Override
    public ASTNode visitVariable(MyLanguageParser.VariableContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        if (ctx.STRING() != null) {
            return new VariableNode(line, column, ctx.STRING().getText());
        } else if (ctx.BOOL() != null) {
            boolean value = Boolean.parseBoolean(ctx.BOOL().getText());
            return new VariableNode(line, column, value);
        } else if (ctx.figure() != null) {
            FigureNode figure = (FigureNode) visit(ctx.figure());
            return new VariableNode(line, column, figure);
        } else if (ctx.FLOAT() != null) {
            float value = Float.parseFloat(ctx.FLOAT().getText());
            return new VariableNode(line, column, value);
        } else if (ctx.ID() != null) {
            AritmeticaNode aritmetica = (AritmeticaNode) visit(ctx.aritmetica());
            return new VariableNode(line, column, ctx.ID().getText(), aritmetica);
        }

        throw new RuntimeException("Tipo de variable no reconocido");
    }

    @Override
    public ASTNode visitFigure(MyLanguageParser.FigureContext ctx) {
        int number = Integer.parseInt(ctx.DIGITO().getText());
        AritmeticaNode aritmetica = (AritmeticaNode) visit(ctx.aritmetica());
        return new FigureNode(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), number, aritmetica);
    }

    @Override
    public ASTNode visitAritmetica(MyLanguageParser.AritmeticaContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        if (ctx.operator() != null) {
            String operator = ctx.operator().getText();
            if (ctx.DIGITO() != null) {
                Integer number = Integer.parseInt(ctx.DIGITO().getText());
                AritmeticaNode next = (AritmeticaNode) visit(ctx.aritmetica());
                return new AritmeticaNode(line, column, operator, number, next);
            } else if (ctx.ID() != null) {
                String id = ctx.ID().getText();
                AritmeticaNode next = (AritmeticaNode) visit(ctx.aritmetica());
                return new AritmeticaNode(line, column, operator, id, next);
            }
        }

        // Caso epsilon
        return new AritmeticaNode(line, column);
    }

    @Override
    public ASTNode visitWhichCondition(MyLanguageParser.WhichConditionContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        if (ctx.BOOL() != null) {
            boolean value = Boolean.parseBoolean(ctx.BOOL().getText());
            return new WhichConditionNode(line, column, value);
        } else {
            ConditionNode condition = (ConditionNode) visit(ctx.condition());
            return new WhichConditionNode(line, column, condition);
        }
    }

    @Override
    public ASTNode visitCondition(MyLanguageParser.ConditionContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        if (ctx.numbersCondition() != null) {
            NumbersConditionNode numbersCondition = (NumbersConditionNode) visit(ctx.numbersCondition());
            Expression1Node expression = (Expression1Node) visit(ctx.expression1());
            return new ConditionNode(line, column, numbersCondition, expression);
        } else if (ctx.STRING() != null) {
            String value = ctx.STRING().getText();
            Expression3Node expression = (Expression3Node) visit(ctx.expression3());
            return new ConditionNode(line, column, value, expression);
        } else if (ctx.ID() != null) {
            String id = ctx.ID().getText();
            Expression2Node expression = (Expression2Node) visit(ctx.expression2());
            return new ConditionNode(line, column, id, expression);
        }

        throw new RuntimeException("Tipo de condición no reconocido");
    }

    @Override
    public ASTNode visitNumbersCondition(MyLanguageParser.NumbersConditionContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        if (ctx.DIGITO() != null) {
            int value = Integer.parseInt(ctx.DIGITO().getText());
            return new NumbersConditionNode(line, column, value);
        } else if (ctx.FLOAT() != null) {
            float value = Float.parseFloat(ctx.FLOAT().getText());
            return new NumbersConditionNode(line, column, value);
        }

        throw new RuntimeException("Tipo de condición numérica no reconocido");
    }

    @Override
    public ASTNode visitExpression1(MyLanguageParser.Expression1Context ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        if (ctx.COMPARISON_OP() != null) {
            String operator = ctx.COMPARISON_OP().getText();
            NumbersConditionNode right = (NumbersConditionNode) visit(ctx.numbersCondition());
            Expression1Node next = (Expression1Node) visit(ctx.expression1());
            return new Expression1Node(line, column, operator, right, next);
        } else {
            // Caso epsilon
            return new Expression1Node(line, column);
        }
    }

    @Override
    public ASTNode visitExpression2(MyLanguageParser.Expression2Context ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        if (ctx.COMPARISON_OP() != null) {
            String operator = ctx.COMPARISON_OP().getText();
            VariableNode right = (VariableNode) visit(ctx.variable());
            Expression2Node next = (Expression2Node) visit(ctx.expression2());
            return new Expression2Node(line, column, operator, right, next);
        } else if (ctx.relationOperator2() != null) {
            String operator = ctx.relationOperator2().getText();
            VariableNode right = (VariableNode) visit(ctx.variable());
            Expression2Node next = (Expression2Node) visit(ctx.expression2());
            return new Expression2Node(line, column, operator, right, next);
        } else {
            // Caso epsilon
            return new Expression2Node(line, column);
        }
    }

    @Override
    public ASTNode visitExpression3(MyLanguageParser.Expression3Context ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        if (ctx.relationOperator2() != null) {
            String operator = ctx.relationOperator2().getText();
            String right = ctx.STRING().getText();
            Expression3Node next = (Expression3Node) visit(ctx.expression3());
            return new Expression3Node(line, column, operator, right, next);
        } else {
            // Caso epsilon
            return new Expression3Node(line, column);
        }
    }

    @Override
    public ASTNode visitIfStatement(MyLanguageParser.IfStatementContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        WhichConditionNode condition = (WhichConditionNode) visit(ctx.whichCondition());
        StatementListTailNode body = (StatementListTailNode) visit(ctx.statementListTail());
        ElsePartNode elsePart = (ElsePartNode) visit(ctx.elsePart());

        return new IfStatementNode(line, column, condition, body, elsePart);
    }

    @Override
    public ASTNode visitElsePart(MyLanguageParser.ElsePartContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        if (ctx.statementListTail() != null) {
            StatementListNode body = (StatementListNode) visit(ctx.statementListTail());
            return new ElsePartNode(line, column, body);
        } else {
            // Caso epsilon (sin else)
            return new ElsePartNode(line, column);
        }
    }

    @Override
    public ASTNode visitWhileStatement(MyLanguageParser.WhileStatementContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        WhichConditionNode condition = (WhichConditionNode) visit(ctx.whichCondition());
        StatementListTailNode body = (StatementListTailNode) visit(ctx.statementListTail());

        return new WhileStatementNode(line, column, condition, body);
    }

    @Override
    public ASTNode visitFunctionCall(MyLanguageParser.FunctionCallContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        String id = ctx.ID().getText();
        ParameterListNode parameters = (ParameterListNode) visit(ctx.parameterList());

        return new FunctionCallNode(line, column, id, parameters);
    }

    @Override
    public ASTNode visitFunctionDeclaration(MyLanguageParser.FunctionDeclarationContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        String id = ctx.ID().getText();
        ParameterListNode parameters = (ParameterListNode) visit(ctx.parameterList());
        StatementListTailNode body = (StatementListTailNode) visit(ctx.statementListTail());
        VariableNode returnValue = (VariableNode) visit(ctx.variable());

        return new FunctionDeclarationNode(line, column, id, parameters, body, returnValue);
    }

    @Override
    public ASTNode visitParameterList(MyLanguageParser.ParameterListContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        if (ctx.functionVariableDeclaration() != null) {
            FunctionVariableDeclarationNode declaration = (FunctionVariableDeclarationNode) visit(ctx.functionVariableDeclaration());
            ParameterListTailNode tail = (ParameterListTailNode) visit(ctx.parameterListTail());
            return new ParameterListNode(line, column, declaration, tail);
        } else {
            // Caso epsilon (sin parámetros)
            return new ParameterListNode(line, column);
        }
    }

    @Override
    public ASTNode visitParameterListTail(MyLanguageParser.ParameterListTailContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        if (ctx.functionVariableDeclaration() != null) {
            FunctionVariableDeclarationNode declaration = (FunctionVariableDeclarationNode) visit(ctx.functionVariableDeclaration());
            ParameterListTailNode next = (ParameterListTailNode) visit(ctx.parameterListTail());
            return new ParameterListTailNode(line, column, declaration, next);
        } else {
            // Caso epsilon (fin de lista)
            return new ParameterListTailNode(line, column);
        }
    }

    @Override
    public ASTNode visitFunctionVariableDeclaration(MyLanguageParser.FunctionVariableDeclarationContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        String type = ctx.TYPE().getText();
        String id = ctx.ID().getText();

        return new FunctionVariableDeclarationNode(line, column, type, id);
    }

    @Override
    public ASTNode visitInputStatement(MyLanguageParser.InputStatementContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        String id = ctx.ID().getText();

        return new InputStatementNode(line, column, id);
    }

    @Override
    public ASTNode visitOutputStatement(MyLanguageParser.OutputStatementContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        String value;
        boolean isVariable = false;

        if (ctx.STRING() != null) {
            value = ctx.STRING().getText();
        } else if (ctx.ID() != null) {
            value = ctx.ID().getText();
            isVariable = true;
        } else {
            throw new RuntimeException("Se esperaba STRING o ID en outputStatement");
        }

        return new OutputStatementNode(line, column, value, isVariable);
    }
}