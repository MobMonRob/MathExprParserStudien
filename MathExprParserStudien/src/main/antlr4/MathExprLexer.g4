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

CROSS
        : 'x'
        ;

CIRCUMFLEX_ACCENT
        : '^'
        ;

SEMICOLON
        : ';'
        ;

LPARENT
        : '('
        ;

RPARENT
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

DOUBLE
        : DIGIT+ ('.' DIGIT+)?
        ;

FORMAT
        : ( ' ' | '\t' | '\n' | '\f')+ -> skip
        ;

ANY
	    : .
	    ;