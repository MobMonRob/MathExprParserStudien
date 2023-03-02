lexer grammar MathExprLexer;

PLUS_SIGN
        : '+'
        ;

HYPHEN_MINUS
        : '-'
        ;

APOSTROPHE
        : '\''
        ;

ASTERISK
        : '*'
        ;

SOLIDUS
        : '/'
        ;

CROSS
        : 'x'
        ;

CARET
        : '^'
        ;

SEMICOLON
        : ';'
        ;

LPARENTHESIS
        : '('
        ;

RPARENTHESIS
        : ')'
        ;

LSQUAREBRACKET
        : '['
        ;

RSQUAREBRACKET
        : ']'
        ;

fragment DIGIT
        : [0-9]
        ;

fragment LETTER
        : [a-z,A-Z]
        ;

IDENTIFIER
        : LETTER+
        ;

DOUBLE
        : DIGIT+ ('.' DIGIT+)?
        ;

FORMAT
        : ( ' ' | '\t' | '\n' | '\f')+ -> skip
        ;

ANY
	    : .
	    ;