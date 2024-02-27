grammar Cmm;

@header {
	import ast.*;
	import ast.definitions.*;
	import ast.expressions.*;
	import ast.expressions.literals.*;
	import ast.statements.*;
	import ast.types.*;
}


program: definitions* main_function;


definitions: variable_definition
    | function_definition
    ;

variable_definition: type ID (',' ID)* ';'
                   ;

function_definition: function_return_type ID '(' function_parameters* ')' function_body
                   ;

function_parameters: built_in_type ID (',' built_in_type ID)*
                   ;

function_body: '{' ( variable_definition)* (statement )*  '}'
             ;


function_return_type: built_in_type
                    | 'void'
                    ;


main_function: 'void' 'main' '(' ')' function_body EOF
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
    | REAL_CONSTANT
            { $ast = new DoubleLiteral($IC.getLine(), $IC.getCharPositionInLine()+1, LexerHelper.lexemeToReal($IC.text)); }
    | CHAR_CONSTANT
            { $ast = new CharLiteral($IC.getLine(), $IC.getCharPositionInLine()+1, LexerHelper.lexemeToChar($IC.text)); }
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
    | '!' expression // unary not
            { $ast = new UnaryNot($e.ast.getLine(), $e.ast.getColumn(), $e.ast); }
    | e1=expression OP=('*'|'/'|'%') e2=expression // mult. div. and mod.
            { $ast = new Arithmetic($e1.ast.getLine(), $e1.ast.getColumn()+1, $e1.ast, $OP.text, $e2.ast); }
    | e1=expression OP=('+'|'-') e2=expression // addition and substraction
            { $ast = new Arithmetic($e1.ast.getLine(), $e1.ast.getColumn()+1, $e1.ast, $OP.text, $e2.ast); }
    | e1=expression OP=('>'|'>='|'<'|'<='|'!='|'==') e2=expression // comparison
            { $ast = new Comparison($e1.ast.getLine(), $e1.ast.getColumn()+1, $e1.ast, $OP.text, $e2.ast); }
    | e1=expression OP=('&&'|'||') e2=expression // logical
            { $ast = new Logical($e1.ast.getLine(), $e1.ast.getColumn()+1, $e1.ast, $OP.text, $e2.ast); }
    | ID '(' oa=optional_arguments ')' // function invocation
            { $ast = new FunctionInvocation($ID.getLine(), $ID.getCharPositionInLine()+1, $ID.text, $oa.ast); }
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
statement: expression '=' expression ';'
         | 'while' '(' expression ')' block
         | 'if' '(' expression ')' block // if statement
         | 'if' '(' expression ')' block 'else' block // if-else statement
         | 'write' arguments ';'
         | 'read' arguments ';'
         | 'return' expression ';'
         | ID '(' optional_arguments ')' ';' // function invocation
         ;

arguments: expression (',' expression)* ;

block: statement
     | '{' statement* '}'
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

type returns [Type ast]:
    b = built_in_type
        { $ast = $b.ast; }
    | t=type '[' IC=INT_CONSTANT ']'
        { $ast = new ArrayType($t.ast.getLine(), $t.ast.getColumn(), LexerHelper.lexemeToInt($IC.text)); }
    | S='struct' '{' ( fd=field_definition )+ '}'
        { $ast = new Struct($S.getLine(), $S.getCharPositionInLine()+1, $fd.ast); }
    ;


field_definition returns [List<RecordFieldType> ast = new ArrayList<RecordFieldType>();]:
    t=type ID1=ID
            { $ast.add(new RecordFieldType($t.ast.getLine(), $t.ast.getColumn(), $t.ast, $ID1.text)); }
    ( (',' ID2=ID
            { $ast.add(new RecordFieldType($t.ast.getLine(), $t.ast.getColumn(), $t.ast, $ID2.text)); }
    )* ';')*
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


