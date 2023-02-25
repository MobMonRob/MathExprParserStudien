parser grammar MathExprParser;

options { tokenVocab=MathExprLexer; }
// generate into org.example.Parsing.Gen
program
        :       expr EOF
        ;
//negation muss da auch noch irgendwie rein
// Operatorauswertung in antlr (wie in Compilerbau) oder in JVM (wie Fabiean)
//Idee: matrizen transponieren oder was es da so gibt
// was mit e oder pi?
expr
        : LPARENT expr RPARENT #ParenExpr
        | expr CIRCUMFLEX_ACCENT expr #ExponentExpr
        | expr ASTERISK expr #MultExpr
        | expr SOLIDUS expr #DivExpr //weiss nicht ob div(ide) und dif(ference) vllt nicht bisschen zu ähnlich ist
        | expr PLUS_SIGN expr #AddExpr //TODO plus ist hier actually mehr gewichtet wie minus :(
        | expr HYPHEN_MINUS expr #DifExpr
        | vector CROSS vector #CrossProductExpr
        | vector #VectorExpr
        | matrix #MatrixExpr
        | DOUBLE #LiteralExpr
        ;

vector
        : LSQUAREBRACKET (DOUBLE SEMICOLON)* RSQUAREBRACKET
        ;

matrix
        : LSQUAREBRACKET transposedVector* RSQUAREBRACKET
        ;

transposedVector
        : ( DOUBLE DOUBLE+ SEMICOLON)
        ;
