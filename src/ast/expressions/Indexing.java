package ast.expressions;

import ast.AbstractExpression;
import ast.Expression;
import semantic.Visitor;

public class Indexing extends AbstractExpression {


    private Expression index;

    private Expression array;

    public Indexing(int line, int column, Expression array, Expression index) {
        super(line, column);
        this.index = index;
        this.array = array;
    }

    public Expression getIndex() {
        return index;
    }

    public Expression getArray() {
        return array;
    }


    @Override
    public String toString() {
        return "Indexing { array: " + this.array + ", index = " + this.index + "] }\n";
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }
}
