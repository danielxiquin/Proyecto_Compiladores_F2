import java.util.*;

public class CodeGenerator extends MyLanguageBaseVisitor<String> {
    private SymbolTable symbolTable;
    private StringBuilder codeBuilder = new StringBuilder();
    private String currentFunction = null;
    private int indentLevel = 0;

    public CodeGenerator(SymbolTable symbolTable) {
        this.symbolTable = symbolTable;
    }

    private String indent() {
        return "  ".repeat(indentLevel);
    }

    public String getGeneratedCode() {
        return codeBuilder.toString();
    }

    @Override
    public String visitProgram(MyLanguageParser.ProgramContext ctx) {
        // Encabezado
        codeBuilder.append("// Código generado automáticamente\n");
        codeBuilder.append("// Fecha: ").append(new Date()).append("\n\n");

        // Agregar funciones predefinidas
        codeBuilder.append("// Funciones predefinidas\n");
        codeBuilder.append("function read(promptText) {\n");
        codeBuilder.append("  return prompt(promptText || 'Ingrese un valor:');\n");
        codeBuilder.append("}\n\n");

        codeBuilder.append("function write(text) {\n");
        codeBuilder.append("  console.log(text);\n");
        codeBuilder.append("  if (typeof document !== 'undefined') {\n");
        codeBuilder.append("    document.body.innerHTML += text + '<br>';\n");
        codeBuilder.append("  }\n");
        codeBuilder.append("}\n\n");

        // Visitar el resto del programa
        visit(ctx.statementList());

        // Llamar automáticamente a main al final
        codeBuilder.append("\n// Ejecución automática\n");
        codeBuilder.append("if (typeof main === 'function') {\n");
        codeBuilder.append("  main();\n");
        codeBuilder.append("}\n");

        return null;
    }

    @Override
    public String visitStatementList(MyLanguageParser.StatementListContext ctx) {
        if (ctx.main() != null) {
            visit(ctx.main());
        } else if (ctx.functionDeclaration() != null) {
            // Primero procesar la declaración de función
            visit(ctx.functionDeclaration());

            // Luego procesar el resto de la lista de declaraciones
            if (ctx.statementList() != null) {
                visit(ctx.statementList());
            }
        }

        return null;
    }

    @Override
    public String visitMain(MyLanguageParser.MainContext ctx) {
        currentFunction = "main";

        codeBuilder.append("function main() {\n");
        indentLevel++;

        // Procesar el cuerpo de main
        if (ctx.statement() != null) {
            visit(ctx.statement());
        }

        if (ctx.statementListTail() != null) {
            visit(ctx.statementListTail());
        }

        indentLevel--;
        codeBuilder.append("}\n\n");

        currentFunction = null;
        return null;
    }

    @Override
    public String visitStatementListTail(MyLanguageParser.StatementListTailContext ctx) {
        if (ctx.statement() != null) {
            // Procesar la instrucción actual
            visit(ctx.statement());

            // Procesar el resto de instrucciones
            if (ctx.statementListTail() != null) {
                visit(ctx.statementListTail());
            }
        }
        // Caso epsilon: no hacer nada

        return null;
    }

    @Override
    public String visitStatement(MyLanguageParser.StatementContext ctx) {
        if (ctx.variableDeclarationEmpty() != null) {
            visit(ctx.variableDeclarationEmpty());
        } else if (ctx.variableAssigment() != null) {
            visit(ctx.variableAssigment());
        } else if (ctx.ifStatement() != null) {
            visit(ctx.ifStatement());
        } else if (ctx.whileStatement() != null) {
            visit(ctx.whileStatement());
        } else if (ctx.functionCall() != null) {
            visit(ctx.functionCall());
        } else if (ctx.inputStatement() != null) {
            visit(ctx.inputStatement());
        } else if (ctx.outputStatement() != null) {
            visit(ctx.outputStatement());
        }

        return null;
    }

    @Override
    public String visitFunctionDeclaration(MyLanguageParser.FunctionDeclarationContext ctx) {
        String functionName = ctx.ID().getText();
        currentFunction = functionName;

        codeBuilder.append("function ").append(functionName).append("(");

        // Generar parámetros
        if (ctx.parameterList() != null) {
            String params = visitParameterList(ctx.parameterList());
            codeBuilder.append(params);
        }

        codeBuilder.append(") {\n");
        indentLevel++;

        // Procesar el cuerpo de la función
        if (ctx.statementListTail() != null) {
            visit(ctx.statementListTail());
        }

        // Procesar el return
        if (ctx.variable() != null) {
            codeBuilder.append(indent()).append("return ");
            String returnValue = visitVariable(ctx.variable());
            codeBuilder.append(returnValue).append(";\n");
        }

        indentLevel--;
        codeBuilder.append("}\n\n");

        currentFunction = null;
        return null;
    }

    @Override
    public String visitVariableDeclarationEmpty(MyLanguageParser.VariableDeclarationEmptyContext ctx) {
        String varName = ctx.ID().getText();
        String varType = ctx.TYPE().getText();

        codeBuilder.append(indent()).append("let ").append(varName);

        // Si hay un valor inicial
        if (ctx.variableDeclarationValue() != null) {
            if (ctx.variableDeclarationValue().variable() != null) {
                codeBuilder.append(" = ");
                String value = visitVariable(ctx.variableDeclarationValue().variable());

                // Aplicar conversión para tipos numéricos
                if (varType.equals("int") || varType.equals("float")) {
                    codeBuilder.append("Number(").append(value).append(")");
                } else {
                    codeBuilder.append(value);
                }
            } else if (ctx.variableDeclarationValue().functionCallExpr() != null) {
                codeBuilder.append(" = ");
                String value = visitFunctionCallExpr(ctx.variableDeclarationValue().functionCallExpr());

                // Aplicar conversión para tipos numéricos
                if (varType.equals("int") || varType.equals("float")) {
                    codeBuilder.append("Number(").append(value).append(")");
                } else {
                    codeBuilder.append(value);
                }
            } else {
                // Valores por defecto según el tipo
                if (varType.equals("int") || varType.equals("float")) {
                    codeBuilder.append(" = 0");
                } else if (varType.equals("string")) {
                    codeBuilder.append(" = \"\"");
                } else if (varType.equals("bool")) {
                    codeBuilder.append(" = false");
                }
            }
        } else {
            // Valores por defecto según el tipo
            if (varType.equals("int") || varType.equals("float")) {
                codeBuilder.append(" = 0");
            } else if (varType.equals("string")) {
                codeBuilder.append(" = \"\"");
            } else if (varType.equals("bool")) {
                codeBuilder.append(" = false");
            }
        }

        codeBuilder.append(";\n");
        return null;
    }

    @Override
    public String visitFunctionVariableDeclaration(MyLanguageParser.FunctionVariableDeclarationContext ctx) {
        // Este método se usa principalmente durante la construcción de la tabla de
        // símbolos
        // En la generación de código, solo necesitamos el nombre del parámetro
        return ctx.ID().getText();
    }

    @Override
    public String visitVariable(MyLanguageParser.VariableContext ctx) {
        StringBuilder result = new StringBuilder();

        if (ctx.STRING() != null) {
            result.append(ctx.STRING().getText());
        } else if (ctx.BOOL() != null) {
            result.append(ctx.BOOL().getText());
        } else if (ctx.FLOAT() != null) {
            result.append(ctx.FLOAT().getText());
        } else if (ctx.figure() != null) {
            result.append(visitFigure(ctx.figure()));
        } else if (ctx.ID() != null) {
            String varName = ctx.ID().getText();
            result.append(varName);

            // Procesar operaciones aritméticas si existen
            if (ctx.aritmetica() != null && !ctx.aritmetica().getText().isEmpty()) {
                // Si hay operaciones aritméticas, asegurar que el lado izquierdo es un número
                SymbolTable.SymbolEntry varEntry = symbolTable.lookup(varName);
                if (varEntry != null && (varEntry.getType().equals("int") || varEntry.getType().equals("float"))) {
                    // Ya es un número, no necesita conversión
                } else {
                    // Reemplazar el resultado actual con una versión con conversión
                    result = new StringBuilder("Number(").append(varName).append(")");
                }

                String aritmetica = visitAritmetica(ctx.aritmetica());
                result.append(aritmetica);
            }
        }

        return result.toString();
    }

    @Override
    public String visitFigure(MyLanguageParser.FigureContext ctx) {
        StringBuilder result = new StringBuilder();

        // Añadir el número
        result.append(ctx.DIGITO().getText());

        // Procesar operaciones aritméticas si existen
        if (ctx.aritmetica() != null && !ctx.aritmetica().getText().isEmpty()) {
            String aritmetica = visitAritmetica(ctx.aritmetica());
            result.append(aritmetica);
        }

        return result.toString();
    }

    @Override
    public String visitAritmetica(MyLanguageParser.AritmeticaContext ctx) {
        if (ctx.operator() == null) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        String operatorText = ctx.operator().getText();

        // Solo asegurarse de conversión para operadores aritméticos
        result.append(" ").append(operatorText).append(" ");

        // Construir la parte derecha de la operación
        String rightOperand = "";
        if (ctx.DIGITO() != null) {
            rightOperand = ctx.DIGITO().getText();
        } else if (ctx.ID() != null) {
            // Para variables, podríamos necesitar una conversión
            String varName = ctx.ID().getText();
            SymbolTable.SymbolEntry varEntry = symbolTable.lookup(varName);
            if (varEntry != null && (varEntry.getType().equals("int") || varEntry.getType().equals("float"))) {
                // Ya es un número, usar directamente
                rightOperand = varName;
            } else {
                // Para asegurar, convertimos a número
                rightOperand = "Number(" + varName + ")";
            }
        }

        result.append(rightOperand);

        // Procesar operaciones aritméticas adicionales
        if (ctx.aritmetica() != null) {
            String nextAritmetica = visitAritmetica(ctx.aritmetica());
            result.append(nextAritmetica);
        }

        return result.toString();
    }

    @Override
    public String visitOperator(MyLanguageParser.OperatorContext ctx) {
        // Simplemente devuelve el operador
        if (ctx.PLUS() != null) {
            return "+";
        } else if (ctx.MINUS() != null) {
            return "-";
        } else if (ctx.MULT() != null) {
            return "*";
        } else if (ctx.DIV() != null) {
            return "/";
        }

        return "";
    }

    @Override
    public String visitIfStatement(MyLanguageParser.IfStatementContext ctx) {
        // Primera parte: condición if y su bloque
        codeBuilder.append(indent()).append("if (");
        String condition = visitWhichCondition(ctx.whichCondition());
        codeBuilder.append(condition).append(") {\n");

        indentLevel++;
        visit(ctx.statementListTail());
        indentLevel--;

        codeBuilder.append(indent()).append("}");

        // Procesar parte else/else if
        if (ctx.elsePart() != null) {
            String elseResult = visitElsePart(ctx.elsePart());
        } else {
            codeBuilder.append("\n");
        }

        return null;
    }

    @Override
    public String visitElsePart(MyLanguageParser.ElsePartContext ctx) {
        if (ctx.statementListTail() != null) {
            // Caso de else normal
            codeBuilder.append(" else {\n");
            indentLevel++;
            visit(ctx.statementListTail());
            indentLevel--;
            codeBuilder.append(indent()).append("}\n");
        } else if (ctx.ifStatement() != null) {
            // Caso de else if - importante: no usamos visit() aquí
            // sino que manejamos el else if explícitamente
            codeBuilder.append(" else if (");
            String elseIfCondition = visitWhichCondition(ctx.ifStatement().whichCondition());
            codeBuilder.append(elseIfCondition).append(") {\n");

            indentLevel++;
            visit(ctx.ifStatement().statementListTail());
            indentLevel--;

            codeBuilder.append(indent()).append("}");

            // Si el else if tiene a su vez un else o else if, lo procesamos
            if (ctx.ifStatement().elsePart() != null) {
                visitElsePart(ctx.ifStatement().elsePart());
            } else {
                codeBuilder.append("\n");
            }
        }

        return null;
    }

    @Override
    public String visitWhileStatement(MyLanguageParser.WhileStatementContext ctx) {
        codeBuilder.append(indent()).append("while (");
        String condition = visitWhichCondition(ctx.whichCondition());
        codeBuilder.append(condition).append(") {\n");

        indentLevel++;
        visit(ctx.statementListTail());
        indentLevel--;

        codeBuilder.append(indent()).append("}\n");
        return null;
    }

    @Override
    public String visitWhichCondition(MyLanguageParser.WhichConditionContext ctx) {
        if (ctx.BOOL() != null) {
            return ctx.BOOL().getText();
        } else if (ctx.condition() != null) {
            return visitCondition(ctx.condition());
        }

        return "";
    }

    @Override
    public String visitCondition(MyLanguageParser.ConditionContext ctx) {
        StringBuilder condition = new StringBuilder();

        if (ctx.numbersCondition() != null) {
            condition.append(visitNumbersCondition(ctx.numbersCondition()));

            // Procesar expresiones adicionales
            if (ctx.expression1() != null) {
                String expr = visitExpression1(ctx.expression1());
                if (!expr.isEmpty()) {
                    condition.append(expr);
                }
            }
        } else if (ctx.STRING() != null) {
            condition.append(ctx.STRING().getText());

            // Procesar expresiones adicionales
            if (ctx.expression3() != null) {
                String expr = visitExpression3(ctx.expression3());
                if (!expr.isEmpty()) {
                    condition.append(expr);
                }
            }
        } else if (ctx.ID() != null) {
            condition.append(ctx.ID().getText());

            // Procesar expresiones adicionales
            if (ctx.expression2() != null) {
                String expr = visitExpression2(ctx.expression2());
                if (!expr.isEmpty()) {
                    condition.append(expr);
                }
            }
        }

        return condition.toString();
    }

    @Override
    public String visitNumbersCondition(MyLanguageParser.NumbersConditionContext ctx) {
        if (ctx.DIGITO() != null) {
            return ctx.DIGITO().getText();
        } else if (ctx.FLOAT() != null) {
            return ctx.FLOAT().getText();
        }

        return "";
    }

    @Override
    public String visitExpression1(MyLanguageParser.Expression1Context ctx) {
        if (ctx.COMPARISON_OP() == null) {
            return ""; // Caso epsilon
        }

        StringBuilder expr = new StringBuilder();
        expr.append(" ").append(ctx.COMPARISON_OP().getText()).append(" ");

        if (ctx.numbersCondition() != null) {
            expr.append(visitNumbersCondition(ctx.numbersCondition()));
        }

        // Procesar expresiones adicionales encadenadas
        if (ctx.expression1() != null && !ctx.expression1().getText().isEmpty()) {
            String nextExpr = visitExpression1(ctx.expression1());
            if (!nextExpr.isEmpty()) {
                expr.append(nextExpr);
            }
        }

        return expr.toString();
    }

    @Override
    public String visitExpression2(MyLanguageParser.Expression2Context ctx) {
        if (ctx.COMPARISON_OP() == null && ctx.relationOperator2() == null) {
            return ""; // Caso epsilon
        }

        StringBuilder expr = new StringBuilder();

        // Operador de comparación
        if (ctx.COMPARISON_OP() != null) {
            expr.append(" ").append(ctx.COMPARISON_OP().getText()).append(" ");
        } else if (ctx.relationOperator2() != null) {
            expr.append(" ").append(visitRelationOperator2(ctx.relationOperator2())).append(" ");
        }

        // Lado derecho de la expresión
        if (ctx.variable() != null) {
            expr.append(visitVariable(ctx.variable()));
        }

        // Procesar expresiones adicionales encadenadas
        if (ctx.expression2() != null && !ctx.expression2().getText().isEmpty()) {
            String nextExpr = visitExpression2(ctx.expression2());
            if (!nextExpr.isEmpty()) {
                expr.append(nextExpr);
            }
        }

        return expr.toString();
    }

    @Override
    public String visitExpression3(MyLanguageParser.Expression3Context ctx) {
        if (ctx.relationOperator2() == null) {
            return ""; // Caso epsilon
        }

        StringBuilder expr = new StringBuilder();

        // Operador de relación
        expr.append(" ").append(visitRelationOperator2(ctx.relationOperator2())).append(" ");

        // Lado derecho de la expresión (string)
        if (ctx.STRING() != null) {
            expr.append(ctx.STRING().getText());
        }

        // Procesar expresiones adicionales encadenadas
        if (ctx.expression3() != null && !ctx.expression3().getText().isEmpty()) {
            String nextExpr = visitExpression3(ctx.expression3());
            if (!nextExpr.isEmpty()) {
                expr.append(nextExpr);
            }
        }

        return expr.toString();
    }

    @Override
    public String visitRelationOperator2(MyLanguageParser.RelationOperator2Context ctx) {
        if (ctx.EQUALS() != null) {
            return "==";
        } else if (ctx.NOT_EQUALS() != null) {
            return "!=";
        }

        return "";
    }

    @Override
    public String visitOutputStatement(MyLanguageParser.OutputStatementContext ctx) {
        codeBuilder.append(indent()).append("write(");

        if (ctx.STRING() != null) {
            // Caso original: imprimir un string literal
            codeBuilder.append(ctx.STRING().getText());
        } else if (ctx.ID() != null) {
            // Caso original: imprimir el valor de una variable
            codeBuilder.append(ctx.ID().getText());
        } else if (ctx.functionCallExpr() != null) {
            // Nuevo caso: imprimir el resultado de una llamada a función
            String functionCall = visitFunctionCallExpr(ctx.functionCallExpr());
            codeBuilder.append(functionCall);
        }

        codeBuilder.append(");\n");
        return null;
    }

    @Override
    public String visitInputStatement(MyLanguageParser.InputStatementContext ctx) {
        String varName = ctx.ID().getText();
        codeBuilder.append(indent()).append(varName).append(" = read(\"Ingrese valor para ").append(varName)
                .append(":\");\n");

        // Conversion de tipo según el tipo de la variable
        SymbolTable.SymbolEntry varEntry = symbolTable.lookup(varName);
        if (varEntry != null) {
            String varType = varEntry.getType();
            if (varType.equals("int")) {
                codeBuilder.append(indent()).append(varName).append(" = parseInt(").append(varName).append(");\n");
            } else if (varType.equals("float")) {
                codeBuilder.append(indent()).append(varName).append(" = parseFloat(").append(varName).append(");\n");
            } else if (varType.equals("bool")) {
                codeBuilder.append(indent()).append(varName).append(" = (").append(varName).append(" === 'true');\n");
            }
        }

        return null;
    }

    @Override
    public String visitFunctionCall(MyLanguageParser.FunctionCallContext ctx) {
        String functionName = ctx.ID().getText();
        codeBuilder.append(indent()).append(functionName).append("(");

        // Generar argumentos
        if (ctx.parameterList() != null) {
            String args = visitParameterList(ctx.parameterList());
            codeBuilder.append(args);
        }

        codeBuilder.append(");\n");
        return null;
    }

    @Override
    public String visitParameterList(MyLanguageParser.ParameterListContext ctx) {
        // Este método debe manejar la declaración de parámetros en funciones
        // y la llamada a funciones con argumentos

        StringBuilder params = new StringBuilder();

        if (ctx.functionVariableDeclaration() != null) {
            // Caso: declaración de función
            params.append(ctx.functionVariableDeclaration().ID().getText());

            // Procesar parámetros adicionales
            if (ctx.parameterListTail() != null &&
                    !ctx.parameterListTail().getText().isEmpty()) {
                params.append(", ");
                visitParameterListTail(ctx.parameterListTail(), params);
            }
        }

        return params.toString();
    }

    // Método auxiliar para visitar la cola de la lista de parámetros
    private void visitParameterListTail(MyLanguageParser.ParameterListTailContext ctx, StringBuilder params) {
        if (ctx.functionVariableDeclaration() != null) {
            params.append(ctx.functionVariableDeclaration().ID().getText());

            if (ctx.parameterListTail() != null &&
                    !ctx.parameterListTail().getText().isEmpty()) {
                params.append(", ");
                visitParameterListTail(ctx.parameterListTail(), params);
            }
        }
    }

    @Override
    public String visitFunctionCallExpr(MyLanguageParser.FunctionCallExprContext ctx) {
        StringBuilder call = new StringBuilder();
        call.append(ctx.ID().getText()).append("(");

        // Generar argumentos
        if (ctx.argumentList() != null) {
            String args = visitArgumentList(ctx.argumentList());
            call.append(args);
        }

        call.append(")");
        return call.toString();
    }

    @Override
    public String visitArgumentList(MyLanguageParser.ArgumentListContext ctx) {
        StringBuilder args = new StringBuilder();

        if (ctx.variable() != null && !ctx.variable().isEmpty()) {
            // Procesar el primer argumento
            String firstArg = visitVariable(ctx.variable(0));
            args.append(firstArg);

            // Procesar argumentos adicionales
            for (int i = 1; i < ctx.variable().size(); i++) {
                args.append(", ");
                String arg = visitVariable(ctx.variable(i));
                args.append(arg);
            }
        }

        return args.toString();
    }

    @Override
    public String visitVariableAssigment(MyLanguageParser.VariableAssigmentContext ctx) {
        String varName = ctx.ID().getText();

        codeBuilder.append(indent()).append(varName).append(" = ");

        // Verificar qué tipo de asignación es
        if (ctx.variable() != null) {
            // Caso original: asignar valor de una variable
            String value = visitVariable(ctx.variable());

            // Verificar si la variable es numérica para asegurar la conversión
            SymbolTable.SymbolEntry varEntry = symbolTable.lookup(varName);
            if (varEntry != null && (varEntry.getType().equals("int") || varEntry.getType().equals("float"))) {
                // Asegurarse que el valor asignado sea numérico
                codeBuilder.append("Number(").append(value).append(")");
            } else {
                codeBuilder.append(value);
            }
        } else if (ctx.functionCallExpr() != null) {
            // Nuevo caso: asignar resultado de una llamada a función
            String functionCall = visitFunctionCallExpr(ctx.functionCallExpr());

            // Verificar si la variable es numérica para asegurar la conversión
            SymbolTable.SymbolEntry varEntry = symbolTable.lookup(varName);
            if (varEntry != null && (varEntry.getType().equals("int") || varEntry.getType().equals("float"))) {
                // Asegurarse que el valor asignado sea numérico
                codeBuilder.append("Number(").append(functionCall).append(")");
            } else {
                codeBuilder.append(functionCall);
            }
        }

        codeBuilder.append(";\n");
        return null;
    }

    @Override
    public String visitVariableDeclarationValue(MyLanguageParser.VariableDeclarationValueContext ctx) {
        if (ctx.variable() != null) {
            return visitVariable(ctx.variable());
        } else if (ctx.functionCallExpr() != null) {
            return visitFunctionCallExpr(ctx.functionCallExpr());
        }
        return "";
    }
}