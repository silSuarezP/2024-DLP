package ast.expressions.literals;

import ast.AbstractASTNode;
import ast.AbstractExpression;
import semantic.Visitor;

public class CharLiteral extends AbstractExpression {

    private int value;

    public CharLiteral (int line, int column, int value) {
        super(line, column);
        this.value = value;
    }

    @Override
    public String toString() {
        return "Char: " + this.value;
    }


    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }
}