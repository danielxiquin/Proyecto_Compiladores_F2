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
    
}