lexer grammar MathExprLexer;

PLUS_SIGN
        : '+'
        ;

HYPHEN_MINUS
        : '-'
        ;

ASTERISK
        : '*'
        ;

SOLIDUS
        : '/'
        ;

CIRCUMFLEX_ACCENT
        : '^'
        ;

LPARENT
        : '('
        ;

RPARENT
        : ')'
        ;

NUM
        : [0-9]+ ('.' [0-9]+)?
        ;

WS
        : [ \t]+ -> skip
        ;

NEWLINE
        : '\r'? '\n'
        ;

ANY
	    : .
	    ;