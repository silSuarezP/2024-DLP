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

import java.lang.reflect.Field;

public interface Visitor <TP, TR> {

    // PROGRAM
    public TR visit(Program program, TP param);



    // STATEMENTS
    public TR visit(Assignment assignment, TP param);
    public TR visit(Read readSt, TP param);
    public TR visit(Write writeSt, TP param);
    public TR visit(IfElse ifElse, TP param);
    public TR visit(While whileSt, TP param);
    public TR visit(Cast cast, TP param);
    public TR visit(FunctionDefinition funcDefinition, TP param);
    public TR visit(VarDefinition varDefinition, TP param);
    public TR visit(Return aReturn, TP param);



    // EXPRESSIONS
    public TR visit(Arithmetic arithmetic, TP param);
    public TR visit(Comparison comparison, TP param);
    public TR visit(FieldAccess fieldAccess, TP param);
    public TR visit(FunctionInvocation functionInvocation, TP param);
    public TR visit(Indexing indexing, TP param);
    public TR visit(Logical logical, TP param);
    public TR visit(Modulus modulus, TP param);
    public TR visit(UnaryMinus unaryMinus, TP param);
    public TR visit(UnaryNot unaryNot, TP param);
    public TR visit(Variable variable, TP param);



    // LITERALS
    public TR visit(IntLiteral intLiteral, TP param);
    public TR visit(CharLiteral charLiteral, TP param);
    public TR visit(DoubleLiteral doubleLiteral, TP param);



    // TYPES
    public TR visit(ArrayType arrayType, TP param);
    public TR visit(CharType charType, TP param);
    public TR visit(DoubleType doubleType, TP param);
    public TR visit(ErrorType errorType, TP param);
    public TR visit(VoidType voidType, TP param);
    public TR visit(FunctionType functionType, TP param);
    public TR visit(IntType intType, TP param);
    public TR visit(RecordFieldType recordFieldType, TP param);
    public TR visit(Struct struct, TP param);


}
