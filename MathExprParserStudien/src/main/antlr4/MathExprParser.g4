parser grammar MathExprParser;

options { tokenVocab=MathExprLexer; }
// generate into org.example.Parsing.Gen
program
        :       expr EOF
        ;
// Operatorauswertung in antlr (wie in Compilerbau) oder in JVM (wie Fabiean)
//Idee: matrizen transponieren oder was es da so gibt
// was mit e oder pi?
expr
        // precedence 0
        : LPARENTHESIS expr RPARENTHESIS #ParenExpr
        // precedence 1
        | IDENTIFIER LPARENTHESIS expr RPARENTHESIS #FunctionExpr
        // precedence 1.5
        | expr CARET expr #ExponentExpr
        // precedence 2
        | HYPHEN_MINUS expr #NegationExpr
        // precedence 3
        | expr (ASTERISK | SOLIDUS | CROSS) expr #MultExpr //#DivExpr
        // precedence 5
        | expr (PLUS_SIGN | HYPHEN_MINUS) expr #AddExpr //#DifExpr
        // Literals
        | vector #VectorExpr
        | matrix #MatrixExpr
        | (vector | matrix) APOSTROPHE #TransExpr
        | POSITIVEDOUBLE #LiteralExpr;

double  :(HYPHEN_MINUS)? POSITIVEDOUBLE #DoubleLiteral
        ;

vector
        : LSQUAREBRACKET (double SEMICOLON)* RSQUAREBRACKET #VectorLiteral
        ;

matrix
        : LSQUAREBRACKET transposedVector* RSQUAREBRACKET
        ;

transposedVector
        : (double+ SEMICOLON)
        ;
