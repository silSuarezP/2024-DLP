package symboltable;

import ast.Definition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SymbolTable {
    private int scope = 0;

    private List<Map<String, Definition>> table;

    public SymbolTable() {
        this.table = new ArrayList<>();

        this.table.add(new HashMap<String, Definition>());
    }

    /**
     * creates a new map inside the table, and increments the scope 1 unit
     */
    public void set() {
        this.table.add(new HashMap<String, Definition>());

        this.scope++;
    }

    /**
     * removes the map that refers to the actual scope, and decrements the scope 1 unit
     */
    public void reset() {
        this.table.remove(scope);

        this.scope--;
    }

    /**
     * returns true if the definition can be added to the symboltable, and false otherwise
     */
    public boolean insert(Definition definition) {
        if (!this.table.get(scope).containsKey(definition.getName())) {
            this.table.get(scope).put(definition.getName(), definition);
            definition.setScope(scope);
            return true;
        }
        return false;
    }

    /**
     * if the string received as a parameter is already in the symboltable (no matter which scope),
     * returns its definition, otherwise returns null
     */
    public Definition find(String id) {
        for (int i = 0; i < table.size(); i++) {
            if (this.table.get(i).containsKey(id)) {
                return this.table.get(i).get(id);
            }
        }
        return null;
    }

    /**
     * if the string received as a parameter is already in the symboltable of the current scope,
     * returns its definition, otherwise returns null
     */
    public Definition findInCurrentScope(String id) {
        if (this.table.get(scope).containsKey(id)) {
            return this.table.get(scope).get(id);
        }

        return null;
    }
}
