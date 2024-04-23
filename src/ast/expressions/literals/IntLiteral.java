package ast.expressions.literals;

import ast.AbstractASTNode;
import ast.AbstractExpression;
import semantic.Visitor;

public class IntLiteral extends AbstractExpression {

    private int value;

    public IntLiteral (int line, int column, int value) {
        super(line, column);
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Int: " + this.value;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }


}
