package ast;

import ast.ASTNode;
import ast.AbstractASTNode;

import java.util.List;

public interface Type extends ASTNode {


    Type arithmetic(Type t, int line, int column);
    Type castTo(Type t, int line, int column);
    Type compareTo(Type t, int line, int column);
    Type dot(String t, int line, int column);
    Type parenthesis(List<Type> argumentTypes, int line, int column);
    Type squareBrackets(Type t, int line, int column);
    Type logical(Type t, int line, int column);
    Type modulus(Type t, int line, int column);
    Type toUnaryMinus(int line, int column);
    Type toUnaryNot(int line, int column);

    void assign(Type t, int line, int column);
    void readable(int line, int column);
    void isReturnable(Type t, int line, int column);
    void mustBeBoolean(int line, int column);
    void writable(int line, int column);

}
