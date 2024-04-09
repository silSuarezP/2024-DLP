package ast.definitions;

import ast.AbstractASTNode;
import ast.Definition;

public abstract class AbstractDefinition extends AbstractASTNode implements Definition {

    int scope;
    int offset;


    public AbstractDefinition(int line, int column) {
        super(line, column);
    }


    public int getScope() {
        return this.scope;
    }

    public void setScope(int scope) {
        this.scope = scope;
    }


    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getOffset() {
        return this.offset;
    }
}
