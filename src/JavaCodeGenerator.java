import java.util.*;

public class JavaCodeGenerator extends MyLanguageBaseVisitor<String> {
    private SymbolTable symbolTable;
    private String className;
    private StringBuilder codeBuilder = new StringBuilder();
    private String currentFunction = null;
    private int indentLevel = 0;

    public JavaCodeGenerator(SymbolTable symbolTable, String name) {
        this.symbolTable = symbolTable;
        this.className = name.replaceAll("\\.txt$", "");;
    }

    private String indent() {
        return "    ".repeat(indentLevel);
    }

    public String getGeneratedCode() {
        String code = codeBuilder.toString();
        // Reemplazar operador mod por %
        code = code.replaceAll("\\s+mod\\s+", " % ");
        return code;
    }

    @Override
    public String visitProgram(MyLanguageParser.ProgramContext ctx) {
        // Imports de Java
        codeBuilder.append("import java.util.Scanner;\n");
        codeBuilder.append("import java.text.DecimalFormat;\n\n");

        // Clase principal
        codeBuilder.append("public class ").append(className).append(" {\n");
        indentLevel++;

        // Scanner estático para entrada
        codeBuilder.append(indent()).append("private static Scanner scanner = new Scanner(System.in);\n");
        codeBuilder.append(indent()).append("private static DecimalFormat df = new DecimalFormat(\"#.####\");\n\n");

        // Funciones predefinidas para entrada/salida
        codeBuilder.append(indent()).append("// Funciones predefinidas\n");
        codeBuilder.append(indent()).append("public static int readInt() {\n");
        indentLevel++;
        codeBuilder.append(indent()).append("return scanner.nextInt();\n");
        indentLevel--;
        codeBuilder.append(indent()).append("}\n\n");

        codeBuilder.append(indent()).append("public static float readFloat() {\n");
        indentLevel++;
        codeBuilder.append(indent()).append("return scanner.nextFloat();\n");
        indentLevel--;
        codeBuilder.append(indent()).append("}\n\n");

        codeBuilder.append(indent()).append("public static String readString() {\n");
        indentLevel++;
        codeBuilder.append(indent()).append("return scanner.next();\n");
        indentLevel--;
        codeBuilder.append(indent()).append("}\n\n");

        codeBuilder.append(indent()).append("public static void writeInt(int value) {\n");
        indentLevel++;
        codeBuilder.append(indent()).append("System.out.println(value);\n");
        indentLevel--;
        codeBuilder.append(indent()).append("}\n\n");

        codeBuilder.append(indent()).append("public static void writeFloat(float value) {\n");
        indentLevel++;
        codeBuilder.append(indent()).append("System.out.println(df.format(value));\n");
        indentLevel--;
        codeBuilder.append(indent()).append("}\n\n");

        codeBuilder.append(indent()).append("public static void writeString(String str) {\n");
        indentLevel++;
        codeBuilder.append(indent()).append("System.out.println(str);\n");
        indentLevel--;
        codeBuilder.append(indent()).append("}\n\n");

        codeBuilder.append(indent()).append("public static void writeBoolean(boolean value) {\n");
        indentLevel++;
        codeBuilder.append(indent()).append("System.out.println(value);\n");
        indentLevel--;
        codeBuilder.append(indent()).append("}\n\n");

        // Visitar el resto del programa
        visit(ctx.statementList());

        // Cerrar la clase
        indentLevel--;
        codeBuilder.append("}\n");

        return null;
    }

    @Override
    public String visitStatementList(MyLanguageParser.StatementListContext ctx) {
        if (ctx.main() != null) {
            visit(ctx.main());
        } else if (ctx.functionDeclaration() != null) {
            visit(ctx.functionDeclaration());
            if (ctx.statementList() != null) {
                visit(ctx.statementList());
            }
        }
        return null;
    }

    @Override
    public String visitMain(MyLanguageParser.MainContext ctx) {
        currentFunction = "main";

        codeBuilder.append(indent()).append("public static void main(String[] args) {\n");
        indentLevel++;

        if (ctx.statement() != null) {
            visit(ctx.statement());
        }

        if (ctx.statementListTail() != null) {
            visit(ctx.statementListTail());
        }

        indentLevel--;
        codeBuilder.append(indent()).append("}\n\n");

        currentFunction = null;
        return null;
    }

    @Override
    public String visitStatementListTail(MyLanguageParser.StatementListTailContext ctx) {
        if (ctx.statement() != null) {
            visit(ctx.statement());
            if (ctx.statementListTail() != null) {
                visit(ctx.statementListTail());
            }
        }
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

        String returnType = getFunctionReturnTypeByName(functionName);

        if (returnType.equals("unknown") && ctx.variable() != null) {
            returnType = inferReturnType(ctx.variable());
        }

        if (returnType.equals("unknown")) {
            returnType = "int";
        }

        codeBuilder.append(indent()).append("public static ").append(returnType).append(" ").append(functionName).append("(");

        if (ctx.parameterList() != null) {
            String params = visitParameterList(ctx.parameterList());
            codeBuilder.append(params);
        }

        codeBuilder.append(") {\n");
        indentLevel++;

        if (ctx.statementListTail() != null) {
            visit(ctx.statementListTail());
        }

        if (ctx.variable() != null) {
            codeBuilder.append(indent()).append("return ");
            String returnValue = visitVariable(ctx.variable());
            codeBuilder.append(returnValue).append(";\n");
        }

        indentLevel--;
        codeBuilder.append(indent()).append("}\n\n");

        currentFunction = null;
        return null;
    }

    private String getFunctionReturnTypeByName(String functionName) {
        // Funciones que definitivamente retornan float
        if (functionName.equals("convertirCelsiusAFahrenheit") ||
                functionName.equals("convertirFahrenheitACelsius") ||
                functionName.equals("calcularAreaCirculo") ||
                functionName.equals("calcularAreaRectangulo") ||
                functionName.equals("promedioTresNumeros") ||
                functionName.contains("promedio") ||
                functionName.contains("area") ||
                functionName.contains("Area") ||
                functionName.contains("convertir")) {
            return "float";
        }

        // Funciones que definitivamente retornan boolean
        if (functionName.equals("esPar") ||
                functionName.contains("verificar") ||
                functionName.contains("es") ||
                functionName.contains("Es")) {
            return "boolean";
        }

        // Funciones que definitivamente retornan int
        if (functionName.equals("calcularPotencia") ||
                functionName.equals("calcularFactorial") ||
                functionName.contains("contar") ||
                functionName.contains("calcular")) {
            return "int";
        }

        return "unknown";
    }

    private String inferReturnType(MyLanguageParser.VariableContext ctx) {
        if (ctx.FLOAT() != null) {
            return "float";
        }

        if (ctx.figure() != null) {
            return "int";
        }

        if (ctx.STRING() != null) {
            return "String";
        }

        if (ctx.BOOL() != null) {
            return "boolean";
        }

        if (ctx.ID() != null) {
            String varName = ctx.ID().getText();
            SymbolTable.SymbolEntry varEntry = symbolTable.lookup(varName);

            if (varEntry != null) {
                String varType = varEntry.getType();
                return mapTypeToJava(varType);
            }

            if (currentFunction != null) {
                if (currentFunction.toLowerCase().contains("convertir") ||
                        currentFunction.toLowerCase().contains("area") ||
                        currentFunction.toLowerCase().contains("promedio")) {
                    return "float";
                }
            }

            if (ctx.aritmetica() != null && !ctx.aritmetica().getText().isEmpty()) {
                String arithmeticText = ctx.aritmetica().getText();
                if (arithmeticText.contains("/")) {
                    return "float";
                }
            }
        }

        return "int";
    }

    @Override
    public String visitVariableDeclarationEmpty(MyLanguageParser.VariableDeclarationEmptyContext ctx) {
        String varName = ctx.ID().getText();
        String varType = ctx.TYPE().getText();
        String javaType = mapTypeToJava(varType);

        codeBuilder.append(indent()).append(javaType).append(" ").append(varName);

        if (ctx.variableDeclarationValue() != null) {
            if (ctx.variableDeclarationValue().variable() != null) {
                codeBuilder.append(" = ");
                String value = visitVariable(ctx.variableDeclarationValue().variable());
                codeBuilder.append(value);
            } else if (ctx.variableDeclarationValue().functionCallExpr() != null) {
                codeBuilder.append(" = ");
                String functionCall = visitFunctionCallExpr(ctx.variableDeclarationValue().functionCallExpr());
                codeBuilder.append(functionCall);
            } else {
                String defaultValue = getDefaultValue(varType);
                if (!defaultValue.isEmpty()) {
                    codeBuilder.append(" = ").append(defaultValue);
                }
            }
        } else {
            String defaultValue = getDefaultValue(varType);
            if (!defaultValue.isEmpty()) {
                codeBuilder.append(" = ").append(defaultValue);
            }
        }

        codeBuilder.append(";\n");
        return null;
    }

    @Override
    public String visitFunctionVariableDeclaration(MyLanguageParser.FunctionVariableDeclarationContext ctx) {
        String paramType = ctx.TYPE().getText();
        String paramName = ctx.ID().getText();
        String javaType = mapTypeToJava(paramType);

        return javaType + " " + paramName;
    }

    @Override
    public String visitVariable(MyLanguageParser.VariableContext ctx) {
        StringBuilder result = new StringBuilder();

        if (ctx.STRING() != null) {
            result.append(ctx.STRING().getText());
        } else if (ctx.BOOL() != null) {
            String boolValue = ctx.BOOL().getText();
            result.append(boolValue); // Java maneja true/false nativamente
        } else if (ctx.FLOAT() != null) {
            result.append(ctx.FLOAT().getText()).append("f"); // Sufijo f para floats en Java
        } else if (ctx.figure() != null) {
            result.append(visitFigure(ctx.figure()));
        } else if (ctx.ID() != null) {
            String varName = ctx.ID().getText();
            result.append(varName);

            if (ctx.aritmetica() != null && !ctx.aritmetica().getText().isEmpty()) {
                String aritmetica = visitAritmetica(ctx.aritmetica());
                result.append(aritmetica);
            }
        }

        return result.toString();
    }

    @Override
    public String visitFigure(MyLanguageParser.FigureContext ctx) {
        StringBuilder result = new StringBuilder();
        result.append(ctx.DIGITO().getText());

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

        if (operatorText.equals("mod")) {
            operatorText = "%";
        }

        result.append(" ").append(operatorText).append(" ");

        if (ctx.DIGITO() != null) {
            result.append(ctx.DIGITO().getText());
        } else if (ctx.ID() != null) {
            result.append(ctx.ID().getText());
        }

        if (ctx.aritmetica() != null) {
            String nextAritmetica = visitAritmetica(ctx.aritmetica());
            result.append(nextAritmetica);
        }

        return result.toString();
    }

    @Override
    public String visitOperator(MyLanguageParser.OperatorContext ctx) {
        if (ctx.PLUS() != null) return "+";
        if (ctx.MINUS() != null) return "-";
        if (ctx.MULT() != null) return "*";
        if (ctx.DIV() != null) return "/";
        if (ctx.PERCENT() != null) return "%";
        return "";
    }

    @Override
    public String visitIfStatement(MyLanguageParser.IfStatementContext ctx) {
        codeBuilder.append(indent()).append("if (");
        String condition = visitWhichCondition(ctx.whichCondition());
        codeBuilder.append(condition).append(") {\n");

        indentLevel++;
        visit(ctx.statementListTail());
        indentLevel--;

        codeBuilder.append(indent()).append("}");

        if (ctx.elsePart() != null) {
            visitElsePart(ctx.elsePart());
        } else {
            codeBuilder.append("\n");
        }

        return null;
    }

    @Override
    public String visitElsePart(MyLanguageParser.ElsePartContext ctx) {
        if (ctx.statementListTail() != null) {
            codeBuilder.append(" else {\n");
            indentLevel++;
            visit(ctx.statementListTail());
            indentLevel--;
            codeBuilder.append(indent()).append("}\n");
        } else if (ctx.ifStatement() != null) {
            codeBuilder.append(" else if (");
            String elseIfCondition = visitWhichCondition(ctx.ifStatement().whichCondition());
            codeBuilder.append(elseIfCondition).append(") {\n");

            indentLevel++;
            visit(ctx.ifStatement().statementListTail());
            indentLevel--;

            codeBuilder.append(indent()).append("}");

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
            return ctx.BOOL().getText(); // Java maneja true/false nativamente
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
            if (ctx.expression1() != null) {
                String expr = visitExpression1(ctx.expression1());
                if (!expr.isEmpty()) {
                    condition.append(expr);
                }
            }
        } else if (ctx.STRING() != null) {
            condition.append(ctx.STRING().getText());
            if (ctx.expression3() != null) {
                String expr = visitExpression3(ctx.expression3());
                if (!expr.isEmpty()) {
                    condition.append(expr);
                }
            }
        } else if (ctx.ID() != null) {
            condition.append(ctx.ID().getText());
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
            return ctx.FLOAT().getText() + "f";
        }
        return "";
    }

    @Override
    public String visitExpression1(MyLanguageParser.Expression1Context ctx) {
        if (ctx.COMPARISON_OP() == null) {
            return "";
        }

        StringBuilder expr = new StringBuilder();
        expr.append(" ").append(ctx.COMPARISON_OP().getText()).append(" ");

        if (ctx.numbersCondition() != null) {
            expr.append(visitNumbersCondition(ctx.numbersCondition()));
        }

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
            return "";
        }

        StringBuilder expr = new StringBuilder();

        if (ctx.COMPARISON_OP() != null) {
            expr.append(" ").append(ctx.COMPARISON_OP().getText()).append(" ");
        } else if (ctx.relationOperator2() != null) {
            expr.append(" ").append(visitRelationOperator2(ctx.relationOperator2())).append(" ");
        }

        if (ctx.variable() != null) {
            expr.append(visitVariable(ctx.variable()));
        }

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
            return "";
        }

        StringBuilder expr = new StringBuilder();
        
        String operator = visitRelationOperator2(ctx.relationOperator2());
        
        // Para comparación de strings en Java, usar .equals()
        if (operator.equals("==")) {
            expr.append(".equals(");
            if (ctx.STRING() != null) {
                expr.append(ctx.STRING().getText());
            }
            expr.append(")");
        } else if (operator.equals("!=")) {
            expr.append("!").append(".equals(");
            if (ctx.STRING() != null) {
                expr.append(ctx.STRING().getText());
            }
            expr.append(")");
        }

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
        codeBuilder.append(indent());

        if (ctx.STRING() != null) {
            codeBuilder.append("writeString(").append(ctx.STRING().getText()).append(")");
        } else if (ctx.ID() != null) {
            String varName = ctx.ID().getText();
            SymbolTable.SymbolEntry varEntry = symbolTable.lookup(varName);

            if (varEntry != null) {
                String varType = varEntry.getType();
                if (varType.equals("float")) {
                    codeBuilder.append("writeFloat(").append(varName).append(")");
                } else if (varType.equals("string")) {
                    codeBuilder.append("writeString(").append(varName).append(")");
                } else if (varType.equals("bool")) {
                    codeBuilder.append("writeBoolean(").append(varName).append(")");
                } else {
                    codeBuilder.append("writeInt(").append(varName).append(")");
                }
            } else {
                // Heurística por nombre de variable
                if (varName.toLowerCase().contains("temp") ||
                        varName.toLowerCase().contains("resultado") ||
                        varName.toLowerCase().contains("area") ||
                        varName.toLowerCase().contains("promedio") ||
                        varName.toLowerCase().contains("decimal") ||
                        varName.toLowerCase().contains("radio")) {
                    codeBuilder.append("writeFloat(").append(varName).append(")");
                } else {
                    codeBuilder.append("writeInt(").append(varName).append(")");
                }
            }
        }

        codeBuilder.append(";\n");
        return null;
    }

    @Override
    public String visitInputStatement(MyLanguageParser.InputStatementContext ctx) {
        String varName = ctx.ID().getText();
        SymbolTable.SymbolEntry varEntry = symbolTable.lookup(varName);

        codeBuilder.append(indent());

        if (varEntry != null) {
            String varType = varEntry.getType();
            if (varType.equals("int")) {
                codeBuilder.append(varName).append(" = readInt()");
            } else if (varType.equals("float")) {
                codeBuilder.append(varName).append(" = readFloat()");
            } else if (varType.equals("string")) {
                codeBuilder.append(varName).append(" = readString()");
            } else {
                codeBuilder.append(varName).append(" = readInt()");
            }
        } else {
            codeBuilder.append(varName).append(" = readInt()");
        }

        codeBuilder.append(";\n");
        return null;
    }

    @Override
    public String visitFunctionCall(MyLanguageParser.FunctionCallContext ctx) {
        String functionName = ctx.ID().getText();
        codeBuilder.append(indent()).append(functionName).append("(");

        if (ctx.parameterList() != null) {
            String args = visitParameterList(ctx.parameterList());
            codeBuilder.append(args);
        }

        codeBuilder.append(");\n");
        return null;
    }

    @Override
    public String visitParameterList(MyLanguageParser.ParameterListContext ctx) {
        StringBuilder params = new StringBuilder();

        if (ctx.functionVariableDeclaration() != null) {
            params.append(visitFunctionVariableDeclaration(ctx.functionVariableDeclaration()));

            if (ctx.parameterListTail() != null && !ctx.parameterListTail().getText().isEmpty()) {
                params.append(", ");
                visitParameterListTail(ctx.parameterListTail(), params);
            }
        }

        return params.toString();
    }

    private void visitParameterListTail(MyLanguageParser.ParameterListTailContext ctx, StringBuilder params) {
        if (ctx.functionVariableDeclaration() != null) {
            params.append(visitFunctionVariableDeclaration(ctx.functionVariableDeclaration()));

            if (ctx.parameterListTail() != null && !ctx.parameterListTail().getText().isEmpty()) {
                params.append(", ");
                visitParameterListTail(ctx.parameterListTail(), params);
            }
        }
    }

    @Override
    public String visitFunctionCallExpr(MyLanguageParser.FunctionCallExprContext ctx) {
        StringBuilder call = new StringBuilder();
        call.append(ctx.ID().getText()).append("(");

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
            String firstArg = visitVariable(ctx.variable(0));
            args.append(firstArg);

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

        if (ctx.variable() != null) {
            String value = visitVariable(ctx.variable());
            codeBuilder.append(value);
        } else if (ctx.functionCallExpr() != null) {
            String functionCall = visitFunctionCallExpr(ctx.functionCallExpr());
            codeBuilder.append(functionCall);
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

    // Métodos auxiliares
    private String mapTypeToJava(String type) {
        switch (type) {
            case "int":
                return "int";
            case "float":
                return "float";
            case "string":
                return "String";
            case "bool":
                return "boolean";
            default:
                return "int";
        }
    }

    private String getDefaultValue(String type) {
        switch (type) {
            case "int":
                return "0";
            case "float":
                return "0.0f";
            case "string":
                return "\"\"";
            case "bool":
                return "false";
            default:
                return "0";
        }
    }

    // Método para cambiar el nombre de la clase generada
    public void setClassName(String className) {
        this.className = className;
    }
}