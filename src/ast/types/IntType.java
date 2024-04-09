package ast.types;

import ast.AbstractASTNode;
import ast.Type;
import semantic.Visitor;

public class IntType extends AbstractType {

    public IntType(int line, int column) {
        super(line, column);
    }

    @Override
    public String toString() {
        return "Int";
    }


    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public Type compareTo(Type t, int line, int column) {
        if (t instanceof ErrorType)
            return t;
        if (t instanceof IntType)
            return this;
        return new ErrorType(line, column, String.format(
                "The type of %s does not support comparisons with %s.", t, this
        ));
    }

    @Override
    public Type arithmetic(Type t, int line, int column) {
        if (t instanceof ErrorType)
            return t;
        if (t instanceof IntType)
            return this;
        return new ErrorType(line, column, String.format(
                "The type of %s does not support arithmetic operations with %s.", t, this
        ));
    }

    @Override
    public Type modulus(Type t, int line, int column) {
        if (t instanceof ErrorType)
            return t;
        if (t instanceof IntType)
            return this;
        return new ErrorType(line, column, String.format(
                "The type of %s does not support modulus.", t
        ));
    }

    @Override
    public Type toUnaryMinus(int line, int column) {
        return this;
    }

    @Override
    public Type castTo(Type castType, int line, int column) {
        if (castType instanceof ErrorType)
            return castType;
        if (castType instanceof DoubleType)
            return castType;
        if (castType instanceof CharType)
            return castType;
        if (castType instanceof  IntType)
            return this;
        return new ErrorType(line, column, String.format(
                "IntType cannot be casted to %s.", castType
        ));
    }


    @Override
    public void assign(Type type, int line, int column) {
        if (type instanceof IntType)
            return;
        if (type instanceof CharType)
            return;
        if (type instanceof ErrorType)
            return;
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
        if (type instanceof IntType) return;
        if (type instanceof ErrorType) return;

        new ErrorType(line, column, String.format(
                "Cannot return type %s for function of return type %s.", type, this
        ));
    }


    @Override
    public void mustBeBoolean(int line, int column){
    }

    @Override
    public int numberOfBytes() {
        return 2;
    }

}
