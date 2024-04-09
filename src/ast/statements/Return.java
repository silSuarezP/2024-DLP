package ast.statements;

import ast.AbstractASTNode;
import ast.AbstractStatement;
import ast.Expression;
import semantic.Visitor;

public class Return extends AbstractStatement {

    private Expression expr;


    public Return(int line, int column, Expression expr) {
        super(line, column);
        this.expr = expr;
    }

    public Expression getExpr() {
        return expr;
    }

    @Override
    public String toString() {
        return "Return " + this.expr + "\n";
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }
}
