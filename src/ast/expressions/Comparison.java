package ast.expressions;

import ast.AbstractASTNode;
import ast.AbstractExpression;
import ast.Expression;
import semantic.Visitor;

public class Comparison extends AbstractExpression {

    private String operator;
    private Expression left;
    private Expression right;

    public Comparison (int line, int column, Expression left, String operator, Expression right) {
        super(line, column);
        this.operator = operator;
        this.left = left;
        this.right = right;
    }

    public String getOperator() {
        return operator;
    }

    public Expression getLeft() {
        return this.left;
    }

    public Expression getRight() {
        return this.right;
    }

    @Override
    public String toString() {
        return "Comparison { " + this.left + " " + this.operator + " " + this.right + " }\n";
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }
}
