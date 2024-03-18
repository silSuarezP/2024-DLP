package ast.expressions;

import ast.AbstractExpression;
import ast.Expression;
import semantic.Visitor;

public class Modulus extends AbstractExpression {
    private Expression right;
    private Expression left;

    public Modulus(int line, int column, Expression left, Expression right) {
        super(line, column);
        this.left = left;
        this.right = right;
    }

    public Expression getRight() {
        return right;
    }

    public Expression getLeft() {
        return left;
    }

    @Override
    public String toString() {
        return "Modulus { " + this.left + " % " + this.right + " }\n";
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }
}
