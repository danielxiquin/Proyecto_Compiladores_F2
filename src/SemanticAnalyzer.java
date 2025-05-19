import java.util.ArrayList;
import java.util.List;

/**
 * Analizador semántico que verifica tipos y reglas semánticas.
 */
public class SemanticAnalyzer extends MyLanguageBaseVisitor<String> {
    private SymbolTable symbolTable;
    private List<String> errors = new ArrayList<>();
    private String currentFunction = null;
    
    public SemanticAnalyzer(SymbolTable symbolTable) {
        this.symbolTable = symbolTable;
    }
    
    public List<String> getErrors() {
        return errors;
    }
    
    public boolean hasErrors() {
        return !errors.isEmpty();
    }
    
    @Override
    public String visitFunctionDeclaration(MyLanguageParser.FunctionDeclarationContext ctx) {
        String functionName = ctx.ID().getText();
        currentFunction = functionName;
        
        // Entrar al ámbito de la función
        symbolTable.enterScope(functionName);
        
        // Visitar el cuerpo de la función
        visit(ctx.statementListTail());
        
        // Verificar que el tipo de retorno coincida
        if (ctx.variable() != null) {
            String declaredReturnType = symbolTable.lookup(functionName).getReturnType();
            String actualReturnType = visit(ctx.variable());
            
            if (!declaredReturnType.equals(actualReturnType) && 
                !declaredReturnType.equals("unknown")) {
                errors.add("Error en línea " + ctx.getStart().getLine() + 
                         ": El tipo de retorno '" + actualReturnType + 
                         "' no coincide con el declarado '" + declaredReturnType + "'");
            }
        }
        
        // Salir del ámbito de la función
        symbolTable.exitScope();
        currentFunction = null;
        
        return "function";
    }
    
    @Override
    public String visitMain(MyLanguageParser.MainContext ctx) {
        currentFunction = "main";
        
        // Entrar al ámbito de main
        symbolTable.enterScope("main");
        
        // Visitar el cuerpo de main
        if (ctx.statement() != null) {
            visit(ctx.statement());
        }
        
        if (ctx.statementListTail() != null) {
            visit(ctx.statementListTail());
        }
        
        // Salir del ámbito de main
        symbolTable.exitScope();
        currentFunction = null;
        
        return "void";
    }
    
    @Override
    public String visitVariableDeclarationEmpty(MyLanguageParser.VariableDeclarationEmptyContext ctx) {
        String varType = ctx.TYPE().getText();
        String varName = ctx.ID().getText();
        
        // Si hay un valor inicial, verificar tipo
        if (ctx.variableDeclarationValue() != null) {
            if (ctx.variableDeclarationValue().variable() != null) {
                String valueType = visit(ctx.variableDeclarationValue().variable());
                
                // Verificar compatibilidad de tipos
                if (!isTypeCompatible(varType, valueType)) {
                    errors.add("Error en línea " + ctx.getStart().getLine() + 
                             ": No se puede asignar valor de tipo '" + valueType + 
                             "' a variable '" + varName + "' de tipo '" + varType + "'");
                }
            } else if (ctx.variableDeclarationValue().functionCallExpr() != null) {
                String functionCallType = visit(ctx.variableDeclarationValue().functionCallExpr());
                
                // Verificar compatibilidad con el tipo de retorno de la función
                if (!isTypeCompatible(varType, functionCallType)) {
                    errors.add("Error en línea " + ctx.getStart().getLine() + 
                             ": No se puede asignar retorno de función de tipo '" + functionCallType + 
                             "' a variable '" + varName + "' de tipo '" + varType + "'");
                }
            }
        }
        
        return varType;
    }
    
    @Override
    public String visitVariableAssigment(MyLanguageParser.VariableAssigmentContext ctx) {
        String varName = ctx.ID().getText();
        SymbolTable.SymbolEntry varEntry = symbolTable.lookup(varName);
        
        if (varEntry == null) {
            errors.add("Error en línea " + ctx.getStart().getLine() + 
                     ": Variable no declarada '" + varName + "'");
            return "unknown";
        }
        
        String varType = varEntry.getType();
        
        // Verificar tipo del valor asignado
        if (ctx.variable() != null) {
            String valueType = visit(ctx.variable());
            
            // Verificar compatibilidad de tipos
            if (!isTypeCompatible(varType, valueType)) {
                errors.add("Error en línea " + ctx.getStart().getLine() + 
                         ": No se puede asignar valor de tipo '" + valueType + 
                         "' a variable '" + varName + "' de tipo '" + varType + "'");
            }
        }
        
        return varType;
    }
    
    @Override
    public String visitVariable(MyLanguageParser.VariableContext ctx) {
        if (ctx.STRING() != null) return "string";
        if (ctx.BOOL() != null) return "bool";
        if (ctx.FLOAT() != null) return "float";
        if (ctx.figure() != null) return "int";
        
        if (ctx.ID() != null) {
            String id = ctx.ID().getText();
            SymbolTable.SymbolEntry entry = symbolTable.lookup(id);
            
            if (entry == null) {
                errors.add("Error en línea " + ctx.getStart().getLine() + 
                         ": Variable no declarada '" + id + "'");
                return "unknown";
            }
            
            return entry.getType();
        }
        
        return "unknown";
    }
    
    @Override
    public String visitFigure(MyLanguageParser.FigureContext ctx) {
        // Una figura (número entero) siempre tiene tipo int
        return "int";
    }
    
    @Override
    public String visitIfStatement(MyLanguageParser.IfStatementContext ctx) {
        // Verificar que la condición sea booleana
        String conditionType = visit(ctx.whichCondition());
        if (!conditionType.equals("bool")) {
            errors.add("Error en línea " + ctx.getStart().getLine() + 
                     ": La condición del 'if' debe ser de tipo booleano, pero es de tipo '" + 
                     conditionType + "'");
        }
        
        // Visitar el cuerpo del if
        visit(ctx.statementListTail());
        
        // Visitar el cuerpo del else si existe
        if (ctx.elsePart() != null) {
            visit(ctx.elsePart());
        }
        
        return "void";
    }
    
    
}