import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

public class MyVisitor extends MyLanguageBaseVisitor<Object> {

    @Override
    public Object visitProgram(MyLanguageParser.ProgramContext ctx) {
        System.out.println("Visitando nodo Program: " + ctx.getText());
        return super.visitProgram(ctx);
    }

    @Override
    public Object visitStatementList(MyLanguageParser.StatementListContext ctx) {
        System.out.println("Visitando nodo StatementList: " + ctx.getText());
        return super.visitStatementList(ctx);
    }

    @Override
    public Object visitMain(MyLanguageParser.MainContext ctx) {
        System.out.println("Visitando nodo Main: " + ctx.getText());
        return super.visitMain(ctx);
    }

    @Override
    public Object visitStatementListTail(MyLanguageParser.StatementListTailContext ctx) {
        System.out.println("Visitando nodo StatementListTail: " + ctx.getText());
        return super.visitStatementListTail(ctx);
    }

    @Override
    public Object visitStatement(MyLanguageParser.StatementContext ctx) {
        System.out.println("Visitando nodo Statement: " + ctx.getText());
        return super.visitStatement(ctx);
    }

    @Override
    public Object visitVariableDeclarationEmpty(MyLanguageParser.VariableDeclarationEmptyContext ctx) {
        System.out.println("Visitando nodo VariableDeclarationEmpty: " + ctx.getText());
        System.out.println("  Tipo: " + ctx.TYPE().getText());
        System.out.println("  Identificador: " + ctx.ID().getText());
        return super.visitVariableDeclarationEmpty(ctx);
    }

    @Override
    public Object visitVariableAssigment(MyLanguageParser.VariableAssigmentContext ctx) {
        System.out.println("Visitando nodo VariableAssigment: " + ctx.getText());
        System.out.println("  Identificador: " + ctx.ID().getText());
        return super.visitVariableAssigment(ctx);
    }

    @Override
    public Object visitVariableDeclarationValue(MyLanguageParser.VariableDeclarationValueContext ctx) {
        System.out.println("Visitando nodo VariableDeclarationValue: " + ctx.getText());
        return super.visitVariableDeclarationValue(ctx);
    }

    @Override
    public Object visitFunctionVariableDeclaration(MyLanguageParser.FunctionVariableDeclarationContext ctx) {
        System.out.println("Visitando nodo FunctionVariableDeclaration: " + ctx.getText());
        System.out.println("  Tipo: " + ctx.TYPE().getText());
        System.out.println("  Identificador: " + ctx.ID().getText());
        return super.visitFunctionVariableDeclaration(ctx);
    }

    @Override
    public Object visitVariable(MyLanguageParser.VariableContext ctx) {
        System.out.println("Visitando nodo Variable: " + ctx.getText());
        if (ctx.STRING() != null) {
            System.out.println("  Tipo: String, Valor: " + ctx.STRING().getText());
        } else if (ctx.BOOL() != null) {
            System.out.println("  Tipo: Bool, Valor: " + ctx.BOOL().getText());
        } else if (ctx.figure() != null) {
            System.out.println("  Tipo: Figure");
        } else if (ctx.FLOAT() != null) {
            System.out.println("  Tipo: Float, Valor: " + ctx.FLOAT().getText());
        } else if (ctx.ID() != null) {
            System.out.println("  Tipo: ID, Nombre: " + ctx.ID().getText());
        }
        return super.visitVariable(ctx);
    }

    @Override
    public Object visitFigure(MyLanguageParser.FigureContext ctx) {
        System.out.println("Visitando nodo Figure: " + ctx.getText());
        System.out.println("  Valor: " + ctx.DIGITO().getText());
        return super.visitFigure(ctx);
    }

    @Override
    public Object visitAritmetica(MyLanguageParser.AritmeticaContext ctx) {
        System.out.println("Visitando nodo Aritmetica: " + ctx.getText());
        if (ctx.operator() != null) {
            System.out.println("  Operador: " + ctx.operator().getText());
        }
        return super.visitAritmetica(ctx);
    }

    @Override
    public Object visitWhichCondition(MyLanguageParser.WhichConditionContext ctx) {
        System.out.println("Visitando nodo WhichCondition: " + ctx.getText());
        if (ctx.BOOL() != null) {
            System.out.println("  Tipo: Bool directo, Valor: " + ctx.BOOL().getText());
        } else {
            System.out.println("  Tipo: Condición compleja");
        }
        return super.visitWhichCondition(ctx);
    }

    @Override
    public Object visitCondition(MyLanguageParser.ConditionContext ctx) {
        System.out.println("Visitando nodo Condition: " + ctx.getText());
        return super.visitCondition(ctx);
    }

    @Override
    public Object visitNumbersCondition(MyLanguageParser.NumbersConditionContext ctx) {
        System.out.println("Visitando nodo NumbersCondition: " + ctx.getText());
        return super.visitNumbersCondition(ctx);
    }

    @Override
    public Object visitExpression1(MyLanguageParser.Expression1Context ctx) {
        System.out.println("Visitando nodo Expression1: " + ctx.getText());
        return super.visitExpression1(ctx);
    }

    @Override
    public Object visitExpression2(MyLanguageParser.Expression2Context ctx) {
        System.out.println("Visitando nodo Expression2: " + ctx.getText());
        return super.visitExpression2(ctx);
    }

    @Override
    public Object visitExpression3(MyLanguageParser.Expression3Context ctx) {
        System.out.println("Visitando nodo Expression3: " + ctx.getText());
        return super.visitExpression3(ctx);
    }

    @Override
    public Object visitRelationOperator2(MyLanguageParser.RelationOperator2Context ctx) {
        System.out.println("Visitando nodo RelationOperator2: " + ctx.getText());
        return super.visitRelationOperator2(ctx);
    }

    @Override
    public Object visitIfStatement(MyLanguageParser.IfStatementContext ctx) {
        System.out.println("Visitando nodo IfStatement: " + ctx.getText());
        System.out.println("  Condición: " + ctx.whichCondition().getText());
        return super.visitIfStatement(ctx);
    }

    @Override
    public Object visitElsePart(MyLanguageParser.ElsePartContext ctx) {
        System.out.println("Visitando nodo ElsePart: " + (ctx.getText().isEmpty() ? "vacío (sin else)" : ctx.getText()));
        return super.visitElsePart(ctx);
    }

    @Override
    public Object visitWhileStatement(MyLanguageParser.WhileStatementContext ctx) {
        System.out.println("Visitando nodo WhileStatement: " + ctx.getText());
        System.out.println("  Condición: " + ctx.whichCondition().getText());
        return super.visitWhileStatement(ctx);
    }

    @Override
    public Object visitFunctionCall(MyLanguageParser.FunctionCallContext ctx) {
        System.out.println("Visitando nodo FunctionCall: " + ctx.getText());
        System.out.println("  Nombre de función: " + ctx.ID().getText());
        return super.visitFunctionCall(ctx);
    }

    @Override
    public Object visitFunctionDeclaration(MyLanguageParser.FunctionDeclarationContext ctx) {
        System.out.println("Visitando nodo FunctionDeclaration: " + ctx.getText());
        System.out.println("  Nombre de función: " + ctx.ID().getText());
        return super.visitFunctionDeclaration(ctx);
    }

    @Override
    public Object visitParameterList(MyLanguageParser.ParameterListContext ctx) {
        System.out.println("Visitando nodo ParameterList: " + (ctx.getText().isEmpty() ? "vacío (sin parámetros)" : ctx.getText()));
        return super.visitParameterList(ctx);
    }

    @Override
    public Object visitParameterListTail(MyLanguageParser.ParameterListTailContext ctx) {
        System.out.println("Visitando nodo ParameterListTail: " + (ctx.getText().isEmpty() ? "vacío (fin de lista)" : ctx.getText()));
        return super.visitParameterListTail(ctx);
    }

    @Override
    public Object visitInputStatement(MyLanguageParser.InputStatementContext ctx) {
        System.out.println("Visitando nodo InputStatement: " + ctx.getText());
        System.out.println("  Variable a leer: " + ctx.ID().getText());
        return super.visitInputStatement(ctx);
    }

    @Override
    public Object visitOutputStatement(MyLanguageParser.OutputStatementContext ctx) {
        System.out.println("Visitando nodo OutputStatement: " + ctx.getText());
        if (ctx.STRING() != null) {
            System.out.println("  Mensaje (String): " + ctx.STRING().getText());
        } else if (ctx.ID() != null) {
            System.out.println("  Mensaje (Variable): " + ctx.ID().getText());
        } else {
            System.out.println("  Error: No se encontró ni STRING ni ID en la sentencia write");
        }
        return super.visitOutputStatement(ctx);
    }

    @Override
    public Object visitOperator(MyLanguageParser.OperatorContext ctx) {
        System.out.println("Visitando nodo Operator: " + ctx.getText());
        return super.visitOperator(ctx);
    }
}
