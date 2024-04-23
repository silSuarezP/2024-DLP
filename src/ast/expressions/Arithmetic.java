package ast.expressions;

import ast.AbstractExpression;
import ast.Expression;
import semantic.Visitor;

public class Arithmetic extends AbstractExpression {

    private String operator;
    private Expression left;
    private Expression right;

    public Arithmetic (int line, int column, Expression left, String operator, Expression right) {
        super(line, column);
        this.operator = operator;
        this.left = left;
        this.right = right;
    }

    public Expression getLeft() {
        return left;
    }

    public Expression getRight() {
        return right;
    }

    // Factory method
    public static Expression createArithmetic(int line, int column, Expression left, String operator, Expression right) {
        if (operator == "%")
            return new Modulus(line, column, left, right);
        return new Arithmetic(line, column, left, operator, right);
    }

    public String getOperator() {
        return operator;
    }

    @Override
    public String toString() {
        return "Arithmetic { " + this.left + " " + this.operator + " " + this.right + " }\n";
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }
}
