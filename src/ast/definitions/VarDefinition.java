package ast.definitions;

import ast.Statement;
import ast.Type;
import semantic.Visitor;

public class VarDefinition extends AbstractDefinition implements Statement {

    private Type type;
    private String name;
    private Type returnType;

    public VarDefinition(int line, int column, Type type, String name) {
        super(line, column);
        this.type = type;
        this.name = name;
    }

    @Override
    public Type getType() {
        return this.type;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return "VarDefinition { type: " + this.type + ", name:" + this.name + ", offset: " + this.offset + " }\n";
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public void setReturnType(Type type) {
        this.returnType = type;
    }

    @Override
    public Type getReturnType() {
        return returnType;
    }
}
