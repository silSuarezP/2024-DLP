package ast.statements;

import ast.AbstractASTNode;
import ast.AbstractStatement;
import ast.Expression;
import semantic.Visitor;

public class Assignment extends AbstractStatement {

    private Expression left;
    private Expression right;


    public Assignment(int line, int column, Expression left, Expression right) {
        super(line, column);
        this.left = left;
        this.right = right;
    }

    public Expression getLeft() {
        return this.left;
    }

    public Expression getRight() {
        return this.right;
    }

    @Override
    public String toString() {
        return "Assignment { " + this.left + " = " + this.right + " }\n";
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }
}
