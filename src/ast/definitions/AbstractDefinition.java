package ast.definitions;

import ast.AbstractASTNode;
import ast.Definition;

public abstract class AbstractDefinition extends AbstractASTNode implements Definition {

    int scope;

    public int getScope() {
        return this.scope;
    }

    public void setScope(int scope) {
        this.scope = scope;
    }
    public AbstractDefinition(int line, int column) {
        super(line, column);
    }
}
