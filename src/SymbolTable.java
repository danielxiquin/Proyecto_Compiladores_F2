import java.util.*;

/**
 * Clase que implementa una tabla de símbolos para el compilador.
 * Maneja ámbitos globales y locales para funciones.
 */
public class SymbolTable {
    // Tabla de símbolos global (para variables y funciones de nivel superior)
    private Map<String, SymbolEntry> globalScope = new HashMap<>();
    
    // Tabla para ámbitos de funciones: Map<nombreFuncion, Map<nombreVariable, entrada>>
    private Map<String, Map<String, SymbolEntry>> functionScopes = new HashMap<>();
    
    // Control de ámbito actual
    private String currentScope = "global";
    
    /**
     * Clase interna que representa una entrada en la tabla de símbolos.
     */
    public static class SymbolEntry {
        private String name;        // Nombre del símbolo
        private String type;        // Tipo: "int", "float", "string", "bool"
        private String kind;        // Clase: "variable", "function", "parameter"
        private int line, column;   // Posición en el código fuente
        private List<SymbolEntry> parameters = new ArrayList<>();  // Parámetros (para funciones)
        private String returnType;  // Tipo de retorno (para funciones)
        
        /**
         * Constructor para crear una nueva entrada de símbolo.
         */
        public SymbolEntry(String name, String type, String kind, int line, int column) {
            this.name = name;
            this.type = type;
            this.kind = kind;
            this.line = line;
            this.column = column;
        }
        
        // Getters y setters
        public String getName() { return name; }
        public String getType() { return type; }
        public String getKind() { return kind; }
        public int getLine() { return line; }
        public int getColumn() { return column; }
        public List<SymbolEntry> getParameters() { return parameters; }
        public String getReturnType() { return returnType; }
        
        public void setReturnType(String returnType) { this.returnType = returnType; }
        
        public void addParameter(SymbolEntry param) {
            parameters.add(param);
        }
    }
    
    /**
     * Entrar a un nuevo ámbito (por ejemplo, al entrar a una función).
     * @param scopeName Nombre del ámbito (nombre de la función)
     */
    public void enterScope(String scopeName) {
        if (!functionScopes.containsKey(scopeName)) {
            functionScopes.put(scopeName, new HashMap<>());
        }
        currentScope = scopeName;
    }
    
    /**
     * Salir del ámbito actual y volver al global.
     */
    public void exitScope() {
        currentScope = "global";
    }
    
    /**
     * Añadir símbolo al ámbito actual.
     * @param entry Entrada a añadir
     */
    public void addSymbol(SymbolEntry entry) {
        if (currentScope.equals("global")) {
            globalScope.put(entry.getName(), entry);
        } else {
            functionScopes.get(currentScope).put(entry.getName(), entry);
        }
    }
    
    /**
     * Buscar un símbolo en todos los ámbitos (primero local, luego global).
     * @param name Nombre del símbolo
     * @return Entrada del símbolo o null si no se encuentra
     */
    public SymbolEntry lookup(String name) {
        if (!currentScope.equals("global") && 
            functionScopes.get(currentScope).containsKey(name)) {
            return functionScopes.get(currentScope).get(name);
        }
        
        return globalScope.getOrDefault(name, null);
    }
    
    /**
     * Buscar un símbolo sólo en el ámbito actual.
     * @param name Nombre del símbolo
     * @return Entrada del símbolo o null si no se encuentra
     */
    public SymbolEntry lookupInCurrentScope(String name) {
        if (currentScope.equals("global")) {
            return globalScope.getOrDefault(name, null);
        } else {
            return functionScopes.get(currentScope).getOrDefault(name, null);
        }
    }
    
    /**
     * Verificar si existe una función.
     * @param name Nombre de la función
     * @return true si existe, false en caso contrario
     */
    public boolean functionExists(String name) {
        SymbolEntry entry = globalScope.get(name);
        return entry != null && entry.getKind().equals("function");
    }
    
    /**
     * Para depuración: imprimir toda la tabla de símbolos.
     */
    public void printSymbolTable() {
        System.out.println("====== TABLA DE SÍMBOLOS GLOBAL ======");
        for (Map.Entry<String, SymbolEntry> entry : globalScope.entrySet()) {
            SymbolEntry symbol = entry.getValue();
            System.out.println(symbol.getName() + " | " + symbol.getType() + 
                               " | " + symbol.getKind());
        }
        
        System.out.println("\n====== TABLAS DE SÍMBOLOS DE FUNCIONES ======");
        for (String function : functionScopes.keySet()) {
            System.out.println("--- Función: " + function + " ---");
            Map<String, SymbolEntry> scope = functionScopes.get(function);
            for (Map.Entry<String, SymbolEntry> entry : scope.entrySet()) {
                SymbolEntry symbol = entry.getValue();
                System.out.println("  " + symbol.getName() + " | " + symbol.getType() + 
                                   " | " + symbol.getKind());
            }
        }
    }
}