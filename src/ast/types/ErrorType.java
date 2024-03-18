package ast.types;

import semantic.Visitor;

public class ErrorType extends AbstractType {

    private String message;

    public ErrorType(int line, int column, String message) {
        super(line, column);
        this.message = message;
    }

    @Override
    public String toString() {
        return String.format("Error [line: %d, column: %d]: %s", this.getLine(), this.getColumn(), this.message);
    }


    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }
}

