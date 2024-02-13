grammar Cmm;	

program: CHAR_CONSTANT
       ;


//////////////////// CONSTANTS
INT_CONSTANT: [1-9] DIGIT*
            | '0'
            ;

REAL_CONSTANT: REAL_FLOATING
             | REAL_MANTISSA
             ;

REAL_FLOATING: '.' INT_CONSTANT
        | INT_CONSTANT '.' INT_CONSTANT?
        ;

REAL_MANTISSA: REAL_FLOATING EXPONENT
             ;

CHAR_CONSTANT: '\'' . '\''
             | NEW_LINE
             | TAB
             ;


//////////////////// COMMENTS
ONE_LINE_COMMENT: '//' .*? ('\n'|EOF) -> skip
               ;

MULTIPLE_LINE_COMMENTS: '/*' .*? '*/' -> skip
                      ;





//////////////////// IDENTIFIER
ID: (LETTER | '_') ID_COMPONENT*
  ;




//////////////////// WHITE SPACES
WHITE_SPACES: [\r\n\t ]+ -> skip
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
EXPONENT: ('e'|'E') ('+'|'-')? [1-9] DIGIT*
        ;

fragment
NEW_LINE: '\n'
        ;

fragment
TAB: '\t'
   ;
