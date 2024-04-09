package ast.expressions;

import ast.AbstractExpression;
import ast.Definition;
import ast.Type;
import semantic.Visitor;

public class Variable extends AbstractExpression {

    private String name;
    private Type type;
    private Definition definition;

    public Variable(int line, int column, String name) {
        super(line, column);
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public void setDefinition(Definition definition) {
        this.definition = definition;
    }

    public Definition getDefinition() {
        return this.definition;
    }


    @Override
    public String toString() {
        return "Variable { name: " + name + " }\n";
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }
}
