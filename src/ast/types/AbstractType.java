package ast.types;

import ast.AbstractASTNode;
import ast.Type;
import semantic.Visitor;

import java.util.List;

public class AbstractType extends AbstractASTNode implements Type {

    public AbstractType(int line, int column) {
        super(line, column);
    }

    @Override
    public Type arithmetic(Type t, int line, int column) {
        return new ErrorType(line, column, String.format(
                "The types of %s and %s do not support arithmetic operations.", this, t
        ));
    }

    @Override
    public Type castTo(Type t, int line, int column) {
        return new ErrorType(line, column, String.format(
                "The types of %s and %s do not support casting operations.", this, t
        ));
    }

    @Override
    public Type compareTo(Type t, int line, int column) {
        return new ErrorType(line, column, String.format(
                "The types of %s and %s do not support comparing operations.", this, t
        ));
    }

    @Override
    public Type dot(String t, int line, int column) {
        return new ErrorType(line, column, String.format(
                "The types of %s and %s do not support field access operations.", this, t
        ));
    }

    @Override
    public Type parenthesis(List<Type> argumentTypes, int line, int column) {
        return new ErrorType(line, column, String.format(
                "The types of %s and %s do not support invocation.", this, argumentTypes
        ));
    }

    @Override
    public Type squareBrackets(Type t, int line, int column) {
        if (t instanceof ErrorType)
            return t;
        return new ErrorType(line, column, String.format(
                "The types of %s and %s do not support array indexing operations.", this, t
        ));
    }

    @Override
    public Type logical(Type t, int line, int column) {
        return new ErrorType(line, column, String.format(
                "The types of %s and %s do not support logical operations.", this, t
        ));
    }

    @Override
    public Type modulus(Type t, int line, int column) {
        return new ErrorType(line, column, String.format(
                "The types of %s and %s do not support modulus operations.", this, t
        ));
    }

    @Override
    public Type toUnaryMinus(int line, int column) {
        return new ErrorType(line, column, String.format(
                "The types of %s does not support unary minus operations.", this
        ));
    }

    @Override
    public Type toUnaryNot(int line, int column) {
        return new ErrorType(line, column, String.format(
                "The types of %s does not support unary not operations.", this
        ));
    }

    @Override
    public void assign(Type t, int line, int column) {
        new ErrorType(line, column, String.format(
                "The types of %s cannot be assigned to %s.", t, this
        ));
    }

    @Override
    public void readable(int line, int column) {
        new ErrorType(line, column, String.format(
                "The type %s cannot be read.", this
        ));
    }

    @Override
    public void isReturnable(Type t, int line, int column) {
        new ErrorType(line, column, String.format(
                "The type %s cannot be returned for return type %s.", t, this
        ));
    }

    @Override
    public void mustBeBoolean(int line, int column) {
        new ErrorType(line, column, String.format(
                "The type %s cannot be evaluated as a boolean.", this
        ));
    }

    @Override
    public void writable(int line, int column) {
        new ErrorType(line, column, String.format(
                "The type %s cannot be written.", this
        ));
    }

    @Override
    public int numberOfBytes() {
        return 0;
    }

}
