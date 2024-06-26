package ast.expressions.literals;

import ast.*;
import semantic.Visitor;

public class DoubleLiteral extends AbstractExpression {

    private double value;

    public DoubleLiteral (int line, int column, double value) {
        super(line, column);
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Double: " + this.value;
    }


    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }
}
