parser grammar MathExprParser;

options { tokenVocab=MathExprLexer; }

program
        :       expr
                (EOF | NEWLINE)
        ;

expr
        : LPARENT expr RPARENT
        | expr CIRCUMFLEX_ACCENT expr
        | expr (ASTERISK|SOLIDUS) expr
        | expr (PLUS_SIGN|HYPHEN_MINUS) expr
        | NUM
        ;
