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
}