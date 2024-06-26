package ast.types;

import ast.AbstractASTNode;
import ast.Type;
import semantic.Visitor;

public class DoubleType extends AbstractType  {

    public DoubleType(int line, int column) {
        super(line, column);
    }

    @Override
    public String toString() {
        return "Double";
    }


    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }


    @Override
    public Type arithmetic(Type t, int line, int column) {
        if (t instanceof ErrorType)
            return t;
        if (t instanceof DoubleType)
            return this;
        return new ErrorType(line, column, String.format(
                "The type of %s does not support arithmetic operations with %s.", t, this
        ));
    }

    @Override
    public Type compareTo(Type t, int line, int column) {
        if (t instanceof ErrorType)
            return t;
        if (t instanceof DoubleType)
            return this;
        return new ErrorType(line, column, String.format(
                "The type of %s does not support comparisons with %s.", t, this
        ));
    }

    @Override
    public Type toUnaryMinus(int line, int column) {
        return this;
    }

    @Override
    public void assign(Type type, int line, int column) {
        if (type instanceof ErrorType) return;
        if (type instanceof DoubleType) return;

        new ErrorType(line, column, String.format(
                "Cannot assign type %s to type %s.", type, this
        ));
    }

    @Override
    public void readable(int line, int column) {
    }

    @Override
    public void writable(int line, int column) {
    }

    @Override
    public void isReturnable(Type type, int line, int column) {
        if (type instanceof DoubleType) return;
        if (type instanceof ErrorType) return;

        new ErrorType(line, column, String.format(
                "Cannot return type %s for function of return type %s.", type, this
        ));
    }

    @Override
    public Type castTo(Type castType, int line, int column) {
        if (castType instanceof ErrorType)
            return castType;
        if (castType instanceof IntType)
            return castType;
        if (castType instanceof CharType)
            return castType;
        if (castType instanceof DoubleType)
            return this;
        return new ErrorType(line, column, String.format(
                "The type %s does not support casting to %s.", this, castType
        ));
    }

    @Override
    public int numberOfBytes() {
        return 4;
    }

    @Override
    public String suffix() {
        return "f";
    }

    @Override
    public String convertTo(Type to) {
        if (to instanceof CharType)
            return "f2i\n\ti2b";
        else if (to instanceof IntType)
            return "f2i";

        return null;
    }

    @Override
    public Type superType(Type type) {
        if (type instanceof DoubleType || type instanceof IntType || type instanceof CharType)
            return this;
        return null;
    }
}
