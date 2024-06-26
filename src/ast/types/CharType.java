package ast.types;

import ast.AbstractASTNode;
import ast.Type;
import errorhandler.ErrorHandler;
import semantic.Visitor;

public class CharType extends AbstractType  {

    public CharType(int line, int column) {
        super(line, column);
    }

    @Override
    public String toString() {
        return "Char";
    }


    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }


    public void readable(int line, int column) {
    }

    @Override
    public void writable(int line, int column) {
    }

    @Override
    public void isReturnable(Type type, int line, int column) {
        if (type instanceof CharType) return;
        if (type instanceof ErrorType) return;

        new ErrorType(line, column, String.format(
                "Cannot return type %s for function of return type %s.", type, this
        ));
    }



    @Override
    public Type castTo(Type castType, int line, int column) {
        if (castType instanceof ErrorType)
            return castType;
        if (castType instanceof DoubleType)
            return castType;
        if (castType instanceof IntType)
            return castType;
        if (castType instanceof CharType)
            return this;
        return new ErrorType(line, column, String.format(
                "CharType cannot be casted to %s.", castType
        ));
    }

    @Override
    public Type compareTo(Type t, int line, int column) {
        if (t instanceof ErrorType)
            return t;
        if (t instanceof CharType)
            return this;
        return new ErrorType(line, column, String.format(
                "The type of %s does not support comparisons with %s.", t, this
        ));
    }

    @Override
    public Type modulus(Type t, int line, int column) {
        if (t instanceof ErrorType)
            return t;
        if (t instanceof CharType)
            return new IntType(line, column);
        return new ErrorType(line, column, String.format(
                "The type of %s does not support modulus.", t
        ));
    }

    @Override
    public void assign(Type type, int line, int column) {
        if (type instanceof ErrorType) return;
        if (type instanceof CharType) return;

        new ErrorType(line, column, String.format(
                "Cannot assign type %s to type %s.", type, this
        ));
    }

    @Override
    public int numberOfBytes() {
        return 1;
    }

    @Override
    public String suffix() {
        return "b";
    }

    @Override
    public String convertTo(Type to) {
        if (to instanceof DoubleType)
            return "b2i\n\ti2f";
        else if (to instanceof IntType)
            return "b2i";
        return null;
    }

    @Override
    public Type superType(Type type) {
        if (type instanceof IntType || type instanceof DoubleType)
            return type;
        return this;
    }
}
