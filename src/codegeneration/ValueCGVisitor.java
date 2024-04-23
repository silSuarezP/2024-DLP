package codegeneration;

import ast.Type;
import ast.expressions.*;
import ast.expressions.literals.CharLiteral;
import ast.expressions.literals.DoubleLiteral;
import ast.expressions.literals.IntLiteral;

public class ValueCGVisitor extends AbstractCGVisitor<Void, Void> {


    /**
     ****************+ LAB11
     * ------ EXPRESSIONS
     * - integer literal
     * - character literal
     * - double literal
     * - variable
     * - arithmetic
     * - comparison
     * - logical
     * - cast
     *
     *
     * value [[ IntLiteral: expression -> INT_CONSTANT ]] =
     *      <pushi > INT_CONSTANT
     *
     *
     * value [[ CharLiteral: expression -> CHAR_CONSTANT ]] =
     *      int aux = expression.value
     *      <pushb > aux
     *
     *
     * value [[ DoubleLiteral: expression -> REAL_CONSTANT ]] =
     *      <pushf > REAL_CONSTANT
     *
     *
     * value [[ Variable: expression -> ID ]] =
     *      address [[ expression ]]
     *      <load> expression.type.suffix
     *
     *
     * value [[ Arithmetic: expression1 -> expression2 expression3 ]] =
     *      value [[ expression2 ]]
     *      expression2.type.convertTo(expression1.type);
     *      value [[ expression3 ]]
     *      expression3.type.convertTo(expression1.type);
     *
     *      switch(expression1.operator) {
     *          case "+":
     *              <add > expression1.type.suffix
     *              break;
     *          case "-":
     *              <sub > expression1.type.suffix
     *              break;
     *          case "*":
     *              <mul > expression1.type.suffix
     *              break;
     *          case "/":
     *              <div > expression1.type.suffix
     *              break;
     *      }
     *
     *
     * value [[ Comparison: expression1 -> expression2 expression3 ]] =
     *      Type superType = expression2.type.superType(expression1.type);
     *      value [[ expression2 ]]
     *      expression2.type.convertTo(superType);
     *      value [[ expression3 ]]
     *      expression3.type.convertTo(superType);
     *
     *      switch(expression1.operator) {
     *          case ">":
     *              <gt> expression1.type.suffix()
     *              break;
     *          case "<":
     *              <lt> expression1.type.suffix()
     *              break;
     *          case ">=":
     *              <ge> expression1.type.suffix()
     *              break;
     *          case "<=":
     *              <le> expression1.type.suffix()
     *              break;
     *          case "==":
     *              <eq> expression1.type.suffix()
     *              break;
     *          case "!=":
     *              <ne> expression1.type.suffix()
     *              break;
     *      }
     *
     *
     * // we dont need to check if expression2 and expression3 are integers, because it is already checked
     * value [[ Logical: expression1 -> expression2 (&& | ||) expression3 ]] =
     *      value [[ expression2 ]]
     *      value [[ expression3 ]]
     *      switch(expression1.operator) {
     *          case "&&":
     *              <and>
     *              break;
     *          case "||":
     *              <or>
     *              break;
     *      }
     *
     *
     * value [[ Cast: expression1 -> type expression2 ]] =
     *      expression2.type.convertTo(type);
     *
     *
     ****************+ LAB12
     * ------ EXPRESSIONS
     * - indexing
     * - fieldAccess
     *
     * value [[ Indexing: expression1 -> expression2 expression3 ]]:
     *      address [[ expression1 ]]
     *      <load > expression1.type.suffix()
     *
     *
     * value [[ FieldAccess: expression1: expression2 ID ]]:
     *      address [[ expression1 ]]
     *      <load > expression2.type.suffix()
     *
     */

    AddressCGVisitor addressVisitor;

    public ValueCGVisitor(CodeGenerator cg) {
        super(cg);
        this.addressVisitor = new AddressCGVisitor(cg, this);
    }

    @Override
    public Void visit(IntLiteral intLiteral, Void param) {
        cg.pushInt(intLiteral.getValue());

        return null;
    }

    @Override
    public Void visit(CharLiteral charLiteral, Void param) {
        cg.pushByte((int) charLiteral.getValue());

        return null;
    }

    @Override
    public Void visit(DoubleLiteral doubleLiteral, Void param) {
        cg.pushFloat(doubleLiteral.getValue());

        return null;
    }

    @Override
    public Void visit(Variable variable, Void param) {
        variable.accept(addressVisitor, null);

        cg.load(variable.getType());

        return null;
    }

    @Override
    public Void visit(Arithmetic arith, Void param) {
        // (superType: new responsibility, take two types and return the "greater" one)
        Type superType = arith.getType().superType(arith.getLeft().getType());

        arith.getLeft().accept(this, null);
        cg.convert(arith.getLeft().getType(), superType);

        arith.getRight().accept(this, null);
        cg.convert(arith.getRight().getType(), superType);

        cg.arithmetic(arith.getOperator(), superType);

        return null;
    }

    @Override
    public Void visit(Comparison comparison, Void param) {
        Type superType = comparison.getLeft().getType().superType(comparison.getRight().getType());

        comparison.getLeft().accept(this, null);
        cg.convert(comparison.getLeft().getType(), superType);

        comparison.getRight().accept(this, null);
        cg.convert(comparison.getRight().getType(), superType);

        cg.compare(comparison.getOperator(), superType);

        return null;
    }

    @Override
    public Void visit(Logical logical, Void param) {

        logical.getLeft().accept(this, null);
        logical.getRight().accept(this, null);

        cg.logical(logical.getOperator());

        return null;
    }

    @Override
    public Void visit(Cast cast, Void param) {
        cast.getExpr().accept(this, null);
        cg.convert(cast.getExpr().getType(), cast.getCastType());

        return null;
    }

}
