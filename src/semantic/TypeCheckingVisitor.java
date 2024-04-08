package semantic;

import ast.Type;
import ast.definitions.FunctionDefinition;
import ast.expressions.*;
import ast.expressions.literals.CharLiteral;
import ast.expressions.literals.DoubleLiteral;
import ast.expressions.literals.IntLiteral;
import ast.statements.*;
import ast.types.CharType;
import ast.types.ErrorType;
import ast.types.FunctionType;
import ast.types.IntType;
import errorhandler.ErrorHandler;

import java.util.List;
import java.util.stream.Collectors;

public class TypeCheckingVisitor extends AbstractVisitor<Void, Void> {


    /**
     ****************** EXPRESSIONS
     * (P)
     *      Arithmetic: expression1 -> expression2 expression3
     * (R)
     *      expression1.type = expression2.type.arithmetic(expression3.type);
     *
     *
     *
     * (P)
     *      Cast: expression1 -> type expression2
     * (R)
     *      expression1.type = expression2.type.castTo(type)
     *
     *
     *
     * (P)
     *      Comparison: expression1 -> expression2 expression3
     * (R)
     *      expression1.type = expression2.type.comparison(expression3.type)
     *
     *
     *
     * (P)
     *      FieldAccess: expression1 -> expression2 ID
     * (R)
     *      expression1.type = expression2.type.dot(ID)
     *
     *
     *
     * (P)
     *      FunctionInvocation: expression1 -> expression2 expression*
     * (R)
     *      expression1.type = expression2.type.parenthesis(
     *              expression*.stream().map(exp -> exp.type).toArray())
     *
     *
     *
     * (P)
     *      Indexing: expression1 -> expression2 expression3
     * (R)
     *      expression1.type = expression2.type.squareBrackets(expression3.type)
     *
     *
     *
     * (P)
     *      Logical: expression1 -> expression2 expression3
     * (R)
     *      expression1.type = expression2.type.logical(expression3.type)
     *
     *
     *
     * (P)
     *      Modulus: expression1 -> expression2 expression3
     * (R)
     *      expression1.type = expression2.type.modulus(expression3.type);
     *
     *
     *
     * (P)
     *      UnaryMinus: expression1 -> expression2
     * (R)
     *      expression1.type = expression2.type.toUnaryMinus();
     *
     *
     *
     * (P)
     *      UnaryNot: expression1 -> expression2
     * (R)
     *      expression1.type = expression2.type.toUnaryNot();
     *
     *
     *
     * (P)
     *      Variable: expression -> ID
     * (R)
     *      if (expression.definition == null)
     *          expression.type = new ErrorType(expression.getLine(), expression.getColumn(),
     *                     "There is no definition for variable " + ID))
     *      else
     *          expression.type = expression.definition.type
     *
     *
     *
     ****************** STATEMENTS
     * (P)
     *      Assignment: statement -> expression1 expression2
     * (R)
     *      expression2.type.assignedTo(expression1.type)
     *
     *
     *
     * (P)
     *      IfElse: statement -> expression statement*
     * (R)
     *      expression.type.mustBeBoolean()
     *
     *
     *
     * (P)
     *      Read: statement -> expression
     * (R)
     *      expression.type.mustBeReadable()
     *
     *
     *
     * (P)
     *      Return: statement -> expression
     * (R)
     *      expression.type.mustBeReturnableAs(statement.returnType)
     *
     *
     *
     * (P)
     *      While: statement -> expression statement*
     * (R)
     *      expression.type.mustBeBoolean()
     *
     *
     *
     * (P)
     *      Write: statement -> expression
     * (R)
     *      expression.type.mustBeWritable()
     *
     *
     *
     * (P)
     *      FunctionInvocation: statement -> expression expression*
     * (R)
     *      expression.type.parenthesis(expression*.stream().map(exp -> exp.type).toArray())
     *
     *
     *
     * (P)
     *      WhileStmt: statement -> expression statement2*
     * (R)
     *      expression.type.mustBeBoolean()
     *
     *
     *
     ****************** LITERALS
     *
     * (P)
     *      IntLiteral: expression -> INT_CONSTANT
     * (R)
     *      expression.type = new IntType()
     *
     *
     *
     * (P)
     *      CharLiteral: expression -> CHAR_CONSTANT
     * (R)
     *      expression.type = new CharType()
     *
     *
     *
     * (P)
     *      DoubleLiteral: expression -> REAL_CONSTANT
     * (R)
     *      expression.type = new DoubleType()
     *
     */



    @Override
    public Void visit(Assignment assignment, Void param) {
        // traverse and accept
        assignment.getLeft().accept(this, null);
        assignment.getRight().accept(this, null);

        // lvalue depends on the left child
        if (!assignment.getLeft().getlValue())
            ErrorHandler.getInstance().addError(new ErrorType(assignment.getLine(), assignment.getColumn(),
                    "The left hand side of the assignment is not an lValue."));

        assignment.getLeft().getType().assign(assignment.getRight().getType(), assignment.getLine(), assignment.getColumn());

        return null;
    }

    @Override
    public Void visit(Read readSt, Void param) {
        readSt.getExpr().accept(this, param);

        if (!readSt.getExpr().getlValue())
            new ErrorType(readSt.getExpr().getLine(),readSt.getExpr().getColumn(),
                    "L-value required");

        readSt.getExpr().getType().readable(readSt.getExpr().getLine(), readSt.getExpr().getColumn());
        return null;
    }

    @Override
    public Void visit(Write writeSt, Void param) {
        writeSt.getExpr().accept(this, param);

        if (!writeSt.getExpr().getlValue())
            new ErrorType(writeSt.getExpr().getLine(), writeSt.getExpr().getColumn(),
                    "L-value required");

        writeSt.getExpr().getType().writable(writeSt.getExpr().getLine(), writeSt.getExpr().getColumn());
        return null;
    }


    @Override
    public Void visit(Cast cast, Void param) {
        cast.getCastType().accept(this,param);
        cast.getExpr().accept(this, param);

        cast.setlValue(false);

        cast.setType(cast.getExpr().getType().castTo(cast.getCastType(),
                cast.getLine(), cast.getColumn()));

        return null;
    }


    @Override
    public Void visit(Comparison comparison, Void param) {
        comparison.getLeft().accept(this, param);
        comparison.getRight().accept(this, param);

        comparison.setlValue(false);

        comparison.setType(comparison.getLeft().getType().compareTo(comparison.getRight().getType(),
                comparison.getLine(), comparison.getColumn()));

        return null;
    }

    @Override
    public Void visit(FieldAccess fieldAccess, Void param) {
        fieldAccess.getStruct().accept(this, param);
        fieldAccess.setlValue(true);

        fieldAccess.setType(fieldAccess.getStruct().getType().dot(fieldAccess.getFieldName(),
                fieldAccess.getLine(), fieldAccess.getColumn()));

        return null;
    }

    @Override
    public Void visit(Indexing indexing, Void param) {
        // first we need to traverse the children
        indexing.getArray().accept(this, null);
        indexing.getIndex().accept(this, null);

        // set lvalue to true
        indexing.setlValue(true);

        indexing.setType(indexing.getArray().getType().squareBrackets(indexing.getIndex().getType(),
                indexing.getLine(), indexing.getColumn()));


        return null;
    }

    @Override
    public Void visit(Logical logical, Void param) {
        // first we need to traverse the children
        logical.getLeft().accept(this, null);
        logical.getRight().accept(this, null);

        // set lvalue to false
        logical.setlValue(false);

        logical.setType(logical.getLeft().getType().logical(logical.getRight().getType(),
                logical.getLine(), logical.getColumn()));

        return null;
    }

    @Override
    public Void visit(Modulus modulus, Void param) {
        modulus.getLeft().accept(this, param);
        modulus.getRight().accept(this, param);

        modulus.setlValue(false);

        modulus.setType(modulus.getLeft().getType().modulus(modulus.getRight().getType(),
                modulus.getLine(), modulus.getColumn()));

        return null;
    }

    @Override
    public Void visit(UnaryMinus unaryMinus, Void param) {
        unaryMinus.getExpr().accept(this, param);
        unaryMinus.setlValue(false);

        unaryMinus.setType(unaryMinus.getExpr().getType().toUnaryMinus(unaryMinus.getLine(), unaryMinus.getColumn()));

        return null;
    }


    @Override
    public Void visit(UnaryNot unaryNot, Void param) {
        unaryNot.getExpr().accept(this, param);
        unaryNot.setlValue(false);
        return null;
    }


    @Override
    public Void visit(Variable variable, Void param) {
        // lvalue true
        variable.setlValue(true);

        if (variable.getDefinition() == null)
            variable.setType(new ErrorType(variable.getLine(), variable.getColumn(),
                    String.format("Variable %s not defined.", variable.getName())));
        else
            variable.setType(variable.getDefinition().getType());

        return null;
    }


    @Override
    public Void visit(FunctionInvocation functionInvocation, Void param) {
        functionInvocation.getParams().forEach(p -> p.accept(this, param));

        // lvalue false
        functionInvocation.setlValue(false);

        List<Type> argumentTypes = functionInvocation.getParams()
                .stream()
                .map(exp -> exp.getType())
                .collect(Collectors.toList());

        functionInvocation.setType(functionInvocation.getFunction().getType().parenthesis(argumentTypes, functionInvocation.getLine(), functionInvocation.getColumn()) );
        return null;
    }




    @Override
    public Void visit(IntLiteral intLiteral, Void param) {
        // lvalue false
        intLiteral.setlValue(false);
        intLiteral.setType(new IntType(intLiteral.getLine(), intLiteral.getColumn()));
        return null;
    }

    @Override
    public Void visit(CharLiteral charLiteral, Void param) {
        // lvalue false
        charLiteral.setlValue(false);
        charLiteral.setType(new CharType(charLiteral.getLine(), charLiteral.getColumn()));
        return null;
    }

    @Override
    public Void visit(DoubleLiteral doubleLiteral, Void param) {
        // lvalue false
        doubleLiteral.setlValue(false);
        doubleLiteral.setType(new CharType(doubleLiteral.getLine(), doubleLiteral.getColumn()));
        return null;
    }

    @Override
    public Void visit(Arithmetic arithmetic, Void param) {
        // postorder traversal
        // first we need to traverse the children
        arithmetic.getLeft().accept(this, null);
        arithmetic.getRight().accept(this, null);

        // set lvalue to false
        arithmetic.setlValue(false);

        arithmetic.setType(arithmetic.getRight().getType().arithmetic(arithmetic.getLeft().getType(),
                arithmetic.getLine(), arithmetic.getColumn()));

        return null;
    }

    @Override
    public Void visit(FunctionDefinition funcDefinition, Void param) {
        funcDefinition.getFuncBody().forEach(st -> st.setReturnType(((FunctionType)funcDefinition.getType()).getReturnType()));
        funcDefinition.getFuncBody().forEach(st -> st.accept(this, null));

        funcDefinition.getType().accept(this, param);

        return null;
    }
}
