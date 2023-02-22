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

INT
        : DIGIT+
        ;

DOUBLE
        : DIGIT+ '.' DIGIT+
        ;

FORMAT
        : ( ' ' | '\t' | '\n' | '\f')+ -> skip
        ;

ANY
	    : .
	    ;