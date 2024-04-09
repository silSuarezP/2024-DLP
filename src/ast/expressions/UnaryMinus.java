package ast.expressions;

import ast.AbstractASTNode;
import ast.AbstractExpression;
import ast.Expression;
import semantic.Visitor;

public class UnaryMinus extends AbstractExpression {
    private Expression expr;

    public UnaryMinus(int line, int column, Expression expr) {
        super(line, column);
        this.expr = expr;
    }

    public Expression getExpr() {
        return this.expr;
    }

    @Override
    public String toString() {
        return "UnaryMinus { -" + this.expr + " }\n";
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

}
