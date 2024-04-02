package semantic;

import ast.expressions.*;
import ast.expressions.literals.CharLiteral;
import ast.expressions.literals.DoubleLiteral;
import ast.expressions.literals.IntLiteral;
import ast.statements.*;
import ast.types.ErrorType;
import errorhandler.ErrorHandler;

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

        return null;
    }

    @Override
    public Void visit(Read readSt, Void param) {
        readSt.getExpr().accept(this, param);
        if (!readSt.getExpr().getlValue())
            new ErrorType(readSt.getExpr().getLine(),readSt.getExpr().getColumn(),
                    "L-value required");
        return null;
    }

    @Override
    public Void visit(Write writeSt, Void param) {
        writeSt.getExpr().accept(this, param);
        if (!writeSt.getExpr().getlValue())
            new ErrorType(writeSt.getExpr().getLine(), writeSt.getExpr().getColumn(),
                    "L-value required");
        return null;
    }


    @Override
    public Void visit(Cast cast, Void param) {
        cast.getCastType().accept(this,param);
        cast.getExpr().accept(this, param);

        cast.setlValue(false);

        return null;
    }


    @Override
    public Void visit(Comparison comparison, Void param) {
        comparison.getLeft().accept(this, param);
        comparison.getRight().accept(this, param);

        comparison.setlValue(false);

        return null;
    }

    @Override
    public Void visit(FieldAccess fieldAccess, Void param) {
        fieldAccess.getStruct().accept(this, param);
        fieldAccess.setlValue(true);

        return null;
    }

    @Override
    public Void visit(Indexing indexing, Void param) {
        // first we need to traverse the children
        indexing.getArray().accept(this, null);
        indexing.getIndex().accept(this, null);

        // set lvalue to true
        indexing.setlValue(true);

        return null;
    }

    @Override
    public Void visit(Logical logical, Void param) {
        // first we need to traverse the children
        logical.getLeft().accept(this, null);
        logical.getRight().accept(this, null);

        // set lvalue to false
        logical.setlValue(false);

        return null;
    }

    @Override
    public Void visit(Modulus modulus, Void param) {
        modulus.getLeft().accept(this, param);
        modulus.getRight().accept(this, param);

        modulus.setlValue(false);

        return null;
    }

    @Override
    public Void visit(UnaryMinus unaryMinus, Void param) {
        unaryMinus.getExpr().accept(this, param);
        unaryMinus.setlValue(false);
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
        return null;
    }


    @Override
    public Void visit(FunctionInvocation functionInvocation, Void param) {
        functionInvocation.getParams().forEach(p -> p.accept(this, param));

        // lvalue false
        functionInvocation.setlValue(false);
        return null;
    }


    @Override
    public Void visit(IntLiteral intLiteral, Void param) {
        // lvalue false
        intLiteral.setlValue(false);
        return null;
    }

    @Override
    public Void visit(CharLiteral charLiteral, Void param) {
        // lvalue false
        charLiteral.setlValue(false);
        return null;
    }

    @Override
    public Void visit(DoubleLiteral doubleLiteral, Void param) {
        // lvalue false
        doubleLiteral.setlValue(false);
        return null;
    }
}
