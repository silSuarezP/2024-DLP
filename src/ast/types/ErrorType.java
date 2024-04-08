package ast.types;

import ast.Type;
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

    @Override
    public Type arithmetic(Type t, int line, int column) {
        return this;
    }

    @Override
    public Type squareBrackets(Type t, int line, int column) {
        return this;
    }

    @Override
    public Type castTo(Type castType, int line, int column) {
        return this;
    }

    @Override
    public Type compareTo(Type t, int line, int column) {
        return this;
    }

    @Override
    public Type dot(String field, int line, int column) {
        return this;
    }

    @Override
    public Type logical(Type t, int line, int column) {
        return this;
    }

    @Override
    public Type modulus(Type t, int line, int column) {
        return this;
    }

    @Override
    public Type toUnaryMinus(int line, int column) {
        return this;
    }

    @Override
    public Type toUnaryNot(int line, int column) {
        return this;
    }

    @Override
    public void assign(Type type, int line, int column) {
    }

    @Override
    public void mustBeBoolean(int line, int column) {
    }

    @Override
    public void readable(int line, int column) {
    }

    @Override
    public void writable(int line, int column) {
    }

    @Override
    public void isReturnable(Type type, int line, int column) {
    }
}

