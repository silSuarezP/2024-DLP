package ast.statements;

import ast.AbstractASTNode;
import ast.AbstractStatement;
import ast.Expression;
import semantic.Visitor;

public class Read extends AbstractStatement {

    private Expression expr;

    public Read(int line, int column, Expression expr) {
        super(line, column);
        this.expr = expr;
    }

    public Expression getExpr() {
        return this.expr;
    }

    @Override
    public String toString() {
        return "Read " + this.expr + "\n";
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }
}