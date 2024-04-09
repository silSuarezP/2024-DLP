grammar Cmm;

@header {
	import ast.*;
	import ast.definitions.*;
	import ast.expressions.*;
	import ast.expressions.literals.*;
	import ast.statements.*;
	import ast.types.*;
}


program returns [Program ast] locals [List<Definition> defs = new ArrayList<Definition>()]:
    (d=definitions
            { $defs.addAll($d.ast); }
    )*
    m=main_function
           { $defs.add($m.ast); }
           { $ast = new Program($defs.get(0).getLine(), $defs.get(0).getColumn(), $defs); }

    EOF
    ;



definitions returns [List<Definition> ast = new ArrayList<Definition>()]:
    v=variable_definition
            { $ast.addAll($v.ast); }
    | f=function_definition
            { $ast.add($f.ast); }
    ;

variable_definition returns [List<VarDefinition> ast = new ArrayList<VarDefinition>();]:
    t=type ID1=ID
            { $ast.add(new VarDefinition($t.ast.getLine(), $t.ast.getColumn(), $t.ast, $ID1.text)); }
    (',' ID2=ID
        { $ast.add(new VarDefinition($t.ast.getLine(), $t.ast.getColumn(), $t.ast, $ID2.text)); }
    )* ';'
    ;

function_definition returns [FunctionDefinition ast]:
    frt=function_return_type ID '(' fp=function_parameters')' fb=function_body
            { $ast = new FunctionDefinition($frt.ast.getLine(), $frt.ast.getColumn(),
                            new FunctionType($frt.ast.getLine(), $frt.ast.getColumn(), $frt.ast, $fp.ast), $ID.text, $fb.ast); }
    ;

function_parameters returns [List<VarDefinition> ast = new ArrayList<VarDefinition>();]:

    | t1=built_in_type ID1=ID
            { $ast.add(new VarDefinition($t1.ast.getLine(), $t1.ast.getColumn(), $t1.ast, $ID1.text)); }
    (',' t2=built_in_type ID2=ID
            { $ast.add(new VarDefinition($t2.ast.getLine(), $t2.ast.getColumn(), $t2.ast, $ID2.text)); }
    )* ;

function_body returns [List<Statement> ast = new ArrayList<Statement>();]:
    '{' ( vd=variable_definition
            { $ast.addAll($vd.ast); }
    )* (st=statement
            { $ast.addAll($st.ast); }
    )*  '}'
    ;
    /*
        We can also create a DTO so we don't need to change the design (this is, to make VarDefinition implement
        Statement).
        So the DTO is a new class that "considers" VarDefinition and Statements as well.
    */


function_return_type returns [Type ast]:
    t=built_in_type
            { $ast = $t.ast; }
    | T='void'
            { $ast = new VoidType($T.getLine(), $T.getCharPositionInLine()+1); }
    ;


main_function returns [FunctionDefinition ast]:
    T='void' 'main' '(' ')' fb=function_body EOF
            { $ast = new FunctionDefinition($T.getLine(), $T.getCharPositionInLine()+1,
                            new FunctionType($T.getLine(), $T.getCharPositionInLine()+1,
                                new VoidType($T.getLine(), $T.getCharPositionInLine()+1), new ArrayList<VarDefinition>()), "main", $fb.ast); }
    ;



//////////////////// EXPRESSIONS
/*
parenthesis
indexing
field access
cast
unary minus
unary not
multiplication, division and modulus
addition and substraction
comparison operations > >= < <= != ==
logical operations && ||

*/
expression returns [Expression ast]:
    ID { $ast = new Variable($ID.getLine(), $ID.getCharPositionInLine()+1, $ID.text); }
    | IC=INT_CONSTANT
            { $ast = new IntLiteral($IC.getLine(), $IC.getCharPositionInLine()+1, LexerHelper.lexemeToInt($IC.text)); }
    | RC=REAL_CONSTANT
            { $ast = new DoubleLiteral($RC.getLine(), $RC.getCharPositionInLine()+1, LexerHelper.lexemeToReal($RC.text)); }
    | CC=CHAR_CONSTANT
            { $ast = new CharLiteral($CC.getLine(), $CC.getCharPositionInLine()+1, LexerHelper.lexemeToChar($CC.text)); }
    | '(' e=expression ')' // parenthesis
            { $ast = $e.ast; }
    | e1=expression '[' e2=expression ']' // indexing
            { $ast = new Indexing($e1.ast.getLine(), $e1.ast.getColumn(), $e1.ast, $e2.ast); }
    | e=expression '.' ID // field access
            { $ast = new FieldAccess($e.ast.getLine(), $e.ast.getColumn(), $e.ast, $ID.text); }
    | '(' t=type ')' e=expression // cast
            { $ast = new Cast($t.ast.getLine(), $t.ast.getColumn(), $t.ast, $e.ast); }
    | '-' e=expression // unary minus
             { $ast = new UnaryMinus($e.ast.getLine(), $e.ast.getColumn(), $e.ast); }
    | '!' e=expression // unary not
            { $ast = new UnaryNot($e.ast.getLine(), $e.ast.getColumn(), $e.ast); }
    | e1=expression OP=('*'|'/'|'%') e2=expression // mult. div. and mod.
            { $ast = Arithmetic.createArithmetic($e1.ast.getLine(), $e1.ast.getColumn()+1, $e1.ast, $OP.text, $e2.ast); }
    | e1=expression OP=('+'|'-') e2=expression // addition and substraction
            { $ast = new Arithmetic($e1.ast.getLine(), $e1.ast.getColumn()+1, $e1.ast, $OP.text, $e2.ast); }
    | e1=expression OP=('>'|'>='|'<'|'<='|'!='|'==') e2=expression // comparison
            { $ast = new Comparison($e1.ast.getLine(), $e1.ast.getColumn()+1, $e1.ast, $OP.text, $e2.ast); }
    | e1=expression OP=('&&'|'||') e2=expression // logical
            { $ast = new Logical($e1.ast.getLine(), $e1.ast.getColumn()+1, $e1.ast, $OP.text, $e2.ast); }
    | ID '(' oa=optional_arguments ')' // function invocation
            {
                $ast = new FunctionInvocation($ID.getLine(), $ID.getCharPositionInLine()+1,
                $ID.text,
                $oa.ast);
             }
    ;


optional_arguments returns [List<Expression> ast = new ArrayList<Expression>();]:
    | e1=expression
         { $ast.add($e1.ast); }
    (',' e2=expression
        { $ast.add($e2.ast); }
    )* ;






//////////////////// STATEMENTS
/*
read
write
assignment
if
if-else
return
while
function invocation
*/
statement returns [List<Statement> ast = new ArrayList<Statement>();]:
    e1=expression '=' e2=expression ';'
            { $ast.add(new Assignment($e1.ast.getLine(), $e1.ast.getColumn(), $e1.ast, $e2.ast)); }
    | 'while' '(' e=expression ')' b=block
            { $ast.add(new While($e.ast.getLine(), $e.ast.getColumn(), $e.ast, $b.ast)); }
    | 'if' '(' e=expression ')' b=block // if statement
            { $ast.add(new IfElse($e.ast.getLine(), $e.ast.getColumn(), $e.ast, $b.ast)); }
    | 'if' '(' e=expression ')' b1=block 'else' b2=block // if-else statement
            { $ast.add(new IfElse($e.ast.getLine(), $e.ast.getColumn(), $e.ast, $b1.ast, $b2.ast)); }
    | 'write' e1=expression
            { $ast.add(new Write($e1.ast.getLine(), $e1.ast.getColumn(), $e1.ast));  }
    (',' e2=expression
            { $ast.add(new Write($e2.ast.getLine(), $e2.ast.getColumn(), $e2.ast));  }
    )* ';'
    | 'read' e1=expression
            { $ast.add(new Read($e1.ast.getLine(), $e1.ast.getColumn(), $e1.ast));  }
     (',' e2=expression
            { $ast.add(new Read($e2.ast.getLine(), $e2.ast.getColumn(), $e2.ast));  }
     )* ';'
    | 'return' e=expression ';'
            { $ast.add(new Return($e.ast.getLine(), $e.ast.getColumn(), $e.ast));  }
    | ID '(' oa=optional_arguments ')' ';' // function invocation
            {
                $ast.add(new FunctionInvocation($ID.getLine(), $ID.getCharPositionInLine()+1,
                $ID.text,
                $oa.ast));
            }
    ;

block returns [List<Statement> ast = new ArrayList<Statement>();]:
    s1=statement
            { $ast.addAll($s1.ast); }
    | '{' (s2=statement
            { $ast.addAll($s2.ast); }
    )* '}'
    ;





//////////////////// TYPES
/*
Built-in types are "int", "double" and "char".
Array types can be created with the "[]" type constructor, following the Java syntax but specifying the size of the array with an integer constant (like C).
The "struct" type constructor is added for specifying record types.
Records have no type identifier, and fields are declared as var definitions between { and }. Type definition (i.e., typedef) is not supported.
*/
built_in_type returns [Type ast]:
    T='int'
            { $ast = new IntType($T.getLine(), $T.getCharPositionInLine()+1); }
    | T='double'
            { $ast = new DoubleType($T.getLine(), $T.getCharPositionInLine()+1); }
    | T='char'
            { $ast = new CharType($T.getLine(), $T.getCharPositionInLine()+1); }
    ;

type returns [Type ast] locals [List<RecordFieldType> records = new ArrayList<RecordFieldType>();]:
    b = built_in_type
        { $ast = $b.ast; }
    | t=type '[' IC=INT_CONSTANT ']'
        { $ast = ArrayType.createArray($t.ast.getLine(), $t.ast.getColumn(), $t.ast, LexerHelper.lexemeToInt($IC.text)); }
    | S='struct' '{' ( fd=field_definitions { $records.addAll($fd.ast);})+ '}'
        { $ast = new Struct($S.getLine(), $S.getCharPositionInLine()+1, $records); }
    ;


field_definitions returns [List<RecordFieldType> ast = new ArrayList<RecordFieldType>();]:
    t=type ID1=ID
            { $ast.add(new RecordFieldType($t.ast.getLine(), $t.ast.getColumn(), $t.ast, $ID1.text)); }
    (
    (',' ID2=ID
            { $ast.add(new RecordFieldType($t.ast.getLine(), $t.ast.getColumn(), $t.ast, $ID2.text)); }
    )*
    ';')*
    ;



//////////////////// CONSTANTS
INT_CONSTANT: [1-9] DIGIT*
            | '0'
            ;

REAL_CONSTANT: INT_CONSTANT? '.' INT_CONSTANT+
               | INT_CONSTANT '.' INT_CONSTANT*
               | (INT_CONSTANT? '.' INT_CONSTANT+ | INT_CONSTANT '.' INT_CONSTANT*)  EXPONENT?
               | INT_CONSTANT EXPONENT?
               ;

REAL_FLOATING: '.' INT_CONSTANT*
        | INT_CONSTANT '.' INT_CONSTANT?
        ;

REAL_MANTISSA: REAL_FLOATING EXPONENT
             ;

CHAR_CONSTANT: '\'' AUX_CHAR_CONSTANT2 '\''


             ;
fragment
AUX_CHAR_CONSTANT1: '\\' INT_CONSTANT ;

fragment
AUX_CHAR_CONSTANT2: AUX_CHAR_CONSTANT1 | . | '\\n' | '\\t' ;


//////////////////// COMMENTS
ONE_LINE_COMMENT: '//' .*? ('\n'|EOF) -> skip
               ;

MULTIPLE_LINE_COMMENTS: '/*' .*? '*/' -> skip
                      ;





//////////////////// IDENTIFIER
ID: (LETTER | '_') ID_COMPONENT*
  ;




//////////////////// WHITE SPACES
WHITE_SPACES: (' '|'\r'|'\n'|'\t')+ -> skip
            ;




//////////////////// FRAGMENTS
fragment
DIGIT: [0-9]
     ;

fragment
LETTER: [a-zA-Z]
      ;

fragment
ID_COMPONENT: LETTER
            | DIGIT
            | '_'
            ;

fragment
EXPONENT: [Ee][-+]?[1-9][0-9]*
        ;


