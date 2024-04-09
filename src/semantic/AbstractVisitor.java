package semantic;

import ast.Program;
import ast.definitions.FunctionDefinition;
import ast.definitions.VarDefinition;
import ast.expressions.*;
import ast.expressions.literals.CharLiteral;
import ast.expressions.literals.DoubleLiteral;
import ast.expressions.literals.IntLiteral;
import ast.statements.*;
import ast.types.*;

public abstract class AbstractVisitor<TP, TR> implements Visitor<TP, TR> {

    ///////////////// STATEMENTS
    @Override
    public TR visit(Program program, TP param) {
        program.getDefinitions().forEach(def -> def.accept(this, param));
        return null;
    }

    @Override
    public TR visit(Arithmetic arithmetic, TP param) {
        arithmetic.getLeft().accept(this,param);
        arithmetic.getRight().accept(this,param);
        return null;
    }

    @Override
    public TR visit(Indexing indexing, TP param) {
        // first we need to traverse the children
        indexing.getArray().accept(this, null);
        indexing.getIndex().accept(this, null);

        return null;
    }

    @Override
    public TR visit(Read readSt, TP param) {
        readSt.getExpr().accept(this, param);
        return null;
    }

    @Override
    public TR visit(Write writeSt, TP param) {
        writeSt.getExpr().accept(this, param);
        return null;
    }

    @Override
    public TR visit(IfElse ifElse, TP param) {
        ifElse.getCondition().accept(this, param);
        ifElse.getIfBody().forEach(s -> s.accept(this, param));
        ifElse.getElseBody().forEach(s -> s.accept(this, param));
        return null;
    }

    @Override
    public TR visit(While whileSt, TP param) {
        whileSt.getCondition().accept(this, param);
        whileSt.getBody().forEach(s -> s.accept(this, null));
        return null;
    }

    @Override
    public TR visit(Return returnSt, TP param) {
        returnSt.getExpr().accept(this, param);
        return null;
    }

    @Override
    public TR visit(Assignment assignment, TP param) {
        // traverse and accept
        assignment.getLeft().accept(this, null);
        assignment.getRight().accept(this, null);

        return null;
    }





    ///////////////// EXPRESSIONS
    @Override
    public TR visit(Cast cast, TP param) {
        cast.getCastType().accept(this, param);
        cast.getExpr().accept(this, param);


        return null;
    }

    @Override
    public TR visit(FunctionDefinition funcDefinition, TP param) {
        funcDefinition.getType().accept(this, null);

        funcDefinition.getFuncBody().forEach(p -> p.accept(this, param));
        return null;
    }

    @Override
    public TR visit(VarDefinition varDefinition, TP param) {
        varDefinition.getType().accept(this, param);
        return null;
    }


    @Override
    public TR visit(Comparison comparison, TP param) {
        comparison.getLeft().accept(this, param);
        comparison.getRight().accept(this, param);


        return null;
    }

    @Override
    public TR visit(FieldAccess fieldAccess, TP param) {
        fieldAccess.getStruct().accept(this, param);

        return null;
    }

    @Override
    public TR visit(FunctionInvocation functionInvocation, TP param) {
        functionInvocation.getParams().forEach(p -> p.accept(this, param));
        functionInvocation.getFunction().accept(this, null);

        return null;
    }

    @Override
    public TR visit(Logical logical, TP param) {
        // first we need to traverse the children
        logical.getLeft().accept(this, null);
        logical.getRight().accept(this, null);


        return null;
    }

    @Override
    public TR visit(Modulus modulus, TP param) {
        modulus.getLeft().accept(this, param);
        modulus.getRight().accept(this, param);


        return null;
    }

    @Override
    public TR visit(UnaryMinus unaryMinus, TP param) {
        unaryMinus.getExpr().accept(this, param);
        return null;
    }

    @Override
    public TR visit(UnaryNot unaryNot, TP param) {
        unaryNot.getExpr().accept(this, param);
        return null;
    }

    @Override
    public TR visit(Variable variable, TP param) {
        return null;
    }


    ///////////////// LITERALS
    @Override
    public TR visit(IntLiteral intLiteral, TP param) {
        return null;
    }

    @Override
    public TR visit(CharLiteral charLiteral, TP param) {
        return null;
    }

    @Override
    public TR visit(DoubleLiteral doubleLiteral, TP param) {
        return null;
    }



    ///////////////// TYPES
    @Override
    public TR visit(ArrayType arrayType, TP param) {
        arrayType.getType().accept(this, param);
        return null;
    }

    @Override
    public TR visit(CharType charType, TP param) {
        return null;
    }

    @Override
    public TR visit(DoubleType doubleType, TP param) {
        return null;
    }

    @Override
    public TR visit(ErrorType errorType, TP param) {
        return null;
    }

    @Override
    public TR visit(FunctionType functionType, TP param) {
        functionType.getReturnType().accept(this, param);
        functionType.getParams().forEach(p -> p.accept(this, param));
        return null;
    }

    @Override
    public TR visit(IntType intType, TP param) {
        return null;
    }

    @Override
    public TR visit(RecordFieldType recordFieldType, TP param) {
        recordFieldType.getType().accept(this, param);
        return null;
    }

    @Override
    public TR visit(Struct struct, TP param) {
        struct.getRecords().forEach(field -> field.accept(this, param));
        return null;
    }

    @Override
    public TR visit(VoidType voidType, TP param) {
        return null;
    }

}
