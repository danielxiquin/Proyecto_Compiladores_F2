import java.util.ArrayList;
import java.util.List;

/**
 * Clase que construye la tabla de símbolos a partir del árbol de análisis sintáctico.
 */
public class SymbolTableBuilder extends MyLanguageBaseVisitor<Void> {
    private SymbolTable symbolTable;
    private List<String> errors = new ArrayList<>();
    
    public SymbolTableBuilder(SymbolTable symbolTable) {
        this.symbolTable = symbolTable;
    }
    
    public List<String> getErrors() {
        return errors;
    }
    
    public boolean hasErrors() {
        return !errors.isEmpty();
    }
    
    @Override
    public Void visitFunctionDeclaration(MyLanguageParser.FunctionDeclarationContext ctx) {
        String functionName = ctx.ID().getText();
        
        // Verificar que la función no esté ya definida
        if (symbolTable.lookup(functionName) != null) {
            errors.add("Error en línea " + ctx.getStart().getLine() + 
                       ": La función '" + functionName + "' ya está definida");
            return null;
        }
        
        // Crear y registrar la entrada para la función
        SymbolTable.SymbolEntry functionEntry = new SymbolTable.SymbolEntry(
            functionName, 
            "function", 
            "function", 
            ctx.getStart().getLine(), 
            ctx.getStart().getCharPositionInLine()
        );
        
        // Extraer el tipo de retorno del último statement (return)
        if (ctx.variable() != null) {
            // Determinar el tipo de retorno según la variable
            String returnType = inferTypeFromVariable(ctx.variable());
            functionEntry.setReturnType(returnType);
        }
        
        symbolTable.addSymbol(functionEntry);
        
        // Entrar al ámbito de la función para procesar parámetros y cuerpo
        symbolTable.enterScope(functionName);
        
        // Procesar parámetros
        visit(ctx.parameterList());
        
        // Procesar cuerpo de la función
        visit(ctx.statementListTail());
        
        // Salir del ámbito de la función
        symbolTable.exitScope();
        
        return null;
    }
    
    @Override
    public Void visitVariableDeclarationEmpty(MyLanguageParser.VariableDeclarationEmptyContext ctx) {
        String varName = ctx.ID().getText();
        String varType = ctx.TYPE().getText();
        
        // Verificar que la variable no esté ya definida en el ámbito actual
        if (symbolTable.lookupInCurrentScope(varName) != null) {
            errors.add("Error en línea " + ctx.getStart().getLine() + 
                       ": La variable '" + varName + "' ya está definida en este ámbito");
            return null;
        }
        
        // Crear y registrar la entrada para la variable
        SymbolTable.SymbolEntry varEntry = new SymbolTable.SymbolEntry(
            varName, 
            varType, 
            "variable", 
            ctx.getStart().getLine(), 
            ctx.getStart().getCharPositionInLine()
        );
        
        symbolTable.addSymbol(varEntry);
        
        // Visitar la parte de inicialización si existe
        if (ctx.variableDeclarationValue() != null) {
            visit(ctx.variableDeclarationValue());
        }
        
        return null;
    }
    
    @Override
    public Void visitFunctionVariableDeclaration(MyLanguageParser.FunctionVariableDeclarationContext ctx) {
        String paramName = ctx.ID().getText();
        String paramType = ctx.TYPE().getText();
        
        // Verificar que el parámetro no esté ya definido en este ámbito
        if (symbolTable.lookupInCurrentScope(paramName) != null) {
            errors.add("Error en línea " + ctx.getStart().getLine() + 
                       ": El parámetro '" + paramName + "' ya está definido");
            return null;
        }
        
        // Crear y registrar la entrada para el parámetro
        SymbolTable.SymbolEntry paramEntry = new SymbolTable.SymbolEntry(
            paramName, 
            paramType, 
            "parameter", 
            ctx.getStart().getLine(), 
            ctx.getStart().getCharPositionInLine()
        );
        
        symbolTable.addSymbol(paramEntry);
        
        return null;
    }
    
    @Override
    public Void visitMain(MyLanguageParser.MainContext ctx) {
        // Registrar main como una función especial
        SymbolTable.SymbolEntry mainEntry = new SymbolTable.SymbolEntry(
            "main", 
            "function", 
            "function", 
            ctx.getStart().getLine(), 
            ctx.getStart().getCharPositionInLine()
        );
        
        mainEntry.setReturnType("void");
        symbolTable.addSymbol(mainEntry);
        
        // Entrar al ámbito de main
        symbolTable.enterScope("main");
        
        // Procesar cuerpo de main
        if (ctx.statement() != null) {
            visit(ctx.statement());
        }
        
        if (ctx.statementListTail() != null) {
            visit(ctx.statementListTail());
        }
        
        // Salir del ámbito de main
        symbolTable.exitScope();
        
        return null;
    }
    
    @Override
    public Void visitIfStatement(MyLanguageParser.IfStatementContext ctx) {
        // Visitar condición
        if (ctx.whichCondition() != null) {
            visit(ctx.whichCondition());
        }
        
        // Visitar cuerpo del if
        if (ctx.statementListTail() != null) {
            visit(ctx.statementListTail());
        }
        
        // Visitar parte else si existe
        if (ctx.elsePart() != null) {
            visit(ctx.elsePart());
        }
        
        return null;
    }
    
    @Override
    public Void visitWhileStatement(MyLanguageParser.WhileStatementContext ctx) {
        // Visitar condición
        if (ctx.whichCondition() != null) {
            visit(ctx.whichCondition());
        }
        
        // Visitar cuerpo del while
        if (ctx.statementListTail() != null) {
            visit(ctx.statementListTail());
        }
        
        return null;
    }
    
    @Override
    public Void visitFunctionCall(MyLanguageParser.FunctionCallContext ctx) {
        String functionName = ctx.ID().getText();
        
        // Verificar que la función exista
        SymbolTable.SymbolEntry functionEntry = symbolTable.lookup(functionName);
        if (functionEntry == null) {
            errors.add("Error en línea " + ctx.getStart().getLine() + 
                       ": Llamada a función no declarada '" + functionName + "'");
        }
        
        // Visitar los parámetros de la llamada
        if (ctx.parameterList() != null) {
            visit(ctx.parameterList());
        }
        
        return null;
    }
    
    @Override
    public Void visitOutputStatement(MyLanguageParser.OutputStatementContext ctx) {
        // Verificar si se está imprimiendo una variable y esta existe
        if (ctx.ID() != null) {
            String varName = ctx.ID().getText();
            if (symbolTable.lookup(varName) == null) {
                errors.add("Error en línea " + ctx.getStart().getLine() + 
                           ": Variable no declarada '" + varName + "' en write");
            }
        }
        
        return null;
    }
    
    @Override
    public Void visitInputStatement(MyLanguageParser.InputStatementContext ctx) {
        // Verificar que la variable donde se guarda la entrada exista
        String varName = ctx.ID().getText();
        if (symbolTable.lookup(varName) == null) {
            errors.add("Error en línea " + ctx.getStart().getLine() + 
                       ": Variable no declarada '" + varName + "' en read");
        }
        
        return null;
    }
    
    @Override
    public Void visitVariableAssigment(MyLanguageParser.VariableAssigmentContext ctx) {
        String varName = ctx.ID().getText();
        
        // Verificar que la variable exista
        if (symbolTable.lookup(varName) == null) {
            errors.add("Error en línea " + ctx.getStart().getLine() + 
                       ": Asignación a variable no declarada '" + varName + "'");
        }
        
        // Visitar el valor asignado
        if (ctx.variable() != null) {
            visit(ctx.variable());
        }
        
        return null;
    }
    
    @Override
    public Void visitCondition(MyLanguageParser.ConditionContext ctx) {
        // Verificar variables en la condición
        if (ctx.ID() != null) {
            String varName = ctx.ID().getText();
            if (symbolTable.lookup(varName) == null) {
                errors.add("Error en línea " + ctx.getStart().getLine() + 
                           ": Variable no declarada '" + varName + "' en condición");
            }
        }
        
        // Visitar el resto de la condición
        return super.visitCondition(ctx);
    }
    
    // Método auxiliar para inferir el tipo de una variable
    private String inferTypeFromVariable(MyLanguageParser.VariableContext ctx) {
        if (ctx.STRING() != null) return "string";
        if (ctx.BOOL() != null) return "bool";
        if (ctx.FLOAT() != null) return "float";
        if (ctx.figure() != null) return "int";
        if (ctx.ID() != null) {
            // Buscar el tipo en la tabla de símbolos
            SymbolTable.SymbolEntry entry = symbolTable.lookup(ctx.ID().getText());
            if (entry != null) {
                return entry.getType();
            }
        }
        // Tipo por defecto si no se puede determinar
        return "unknown";
    }
}