parser grammar MathExprParser;

options { tokenVocab=MathExprLexer; }
// generate into org.example.Parsing.Gen
program
        :       expr
                (EOF | NEWLINE)
        ;

expr
        : LPARENT expr RPARENT #ParenExpr
        | expr CIRCUMFLEX_ACCENT expr #ExponentExpr
        | expr ASTERISK expr #MultExpr
        | expr SOLIDUS expr #DivExpr //weiss nicht ob div(ide) und dif(ference) vllt nicht bisschen zu ähnlich ist
        | expr PLUS_SIGN expr #AddExpr
        | expr HYPHEN_MINUS expr #DifExpr
        | NUM #LiteralExpr
        ;
