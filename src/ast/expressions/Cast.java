package ast.expressions;

import ast.AbstractExpression;
import ast.Expression;
import ast.Type;
import semantic.Visitor;

public class Cast extends AbstractExpression {

    private Type castType;
    private Expression expr;

    public Cast(int line, int column, Type castType, Expression expr) {
        super(line, column);
        this.castType = castType;
        this.expr = expr;
    }

    public Type getCastType() {
        return this.castType;
    }

    public Expression getExpr() {
        return this.expr;
    }

    @Override
    public String toString() {
        return "Cast: ( " + this.castType + ")" + this.expr + " }\n";
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }
}
