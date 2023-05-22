# MathExprParserStudien
Studienarbeit Parsen mathematischer Formeln und Rechnen auf Zeitreihen

## Setup
 - Download [Maven](https://maven.apache.org/download.cgi)
 - Download [GraalVM | Java 19](https://github.com/graalvm/graalvm-ce-builds/releases/tag/vm-22.3.1) 
 - Download [IntelliJ IDEA Community Edition](https://www.jetbrains.com/idea/download/)
 - Add GraalVM as JDK
 - Maven, generate source and update folders
 - Build Project
 - Run Tests in src/test/java/mep

## Run Main
- Move to correct folder ```cd MathExprParserStudien```
- Build project ```mvn package```
- Run Main ```java -cp ".\target\MathExprParserStudien-1.0-SNAPSHOT.jar;.\target\lib\*" de.dhbw.karlsruhe.dsl.Main --add-exports org.graalvm.truffle/com.oracle.truffle.api.nodes=ALL-UNNAMED```

- Hier kann nun die Funktion in der Konsole eingegeben und mit _Enter_ ausgeführt werden. Das Ergebnis wird ebenfalls in der Konsole angezeigt.
- Beispiel: Matrixmultiplikation ```[1.5 7.2; 9.2 5.2;] * [0.1 8.5; 5.2 2.1;] ```

## Syntax

| Token            | Syntax     | Beschreibung                               |
|------------------|------------|--------------------------------------------|
| PLUS_SIGN        | +        | Pluszeichen für Addition                   |
| HYPHEN_MINUS     | -        | Minuszeichen für Subtraktion oder Negation  |
| APOSTROPHE       | '        | Apostroph für die Transpositionen          |
| ASTERISK         | *        | Stern für Multiplikation                   |
| SOLIDUS          | /        | Schrägstrich für Division                  |
| CROSS            | x        | Kreuz für Kreuzprodukt                     |
| CARET            | ^        | Dachsymbol für Exponentiation              |
| SEMICOLON        | ;        | Semikolon zur Trennung von Elementen        |
| LPARENTHESIS     | (        | Linke runde Klammer für Priorisierung       |
| RPARENTHESIS     | )        | Rechte runde Klammer für Priorisierung      |
| LSQUAREBRACKET   | [        | Definition von Vektoren oder Matrizen      |
| RSQUAREBRACKET   | ]        | Definition von Vektoren oder Matrizen      |
| DIGIT            | 0-9      | Ziffern für numerische Werte               |
| LETTER           | a-z, A-Z | Buchstaben für Bezeichner    |


__Double (Gleitkommazahl):__ Ein Double kann aus einer oder mehreren Ziffern bestehen, gefolgt von einem optionalen Dezimalpunkt und weiteren Ziffern. Zum Beispiel definiert 3.14 eine Gleitkommazahl mit dem Wert 3.14. Ein weiteres Beispiel ist 42, was eine Gleitkommazahl ohne Dezimalstellen darstellt. Diese Gleitkommazahlen können direkt als Elemente in Vektoren oder Matrizen verwendet werden.

__Vektoren:__ Ein Vektor wird durch eine Liste von Zahlen (double) dargestellt, die durch Semikolons getrennt und in eckigen Klammern eingeschlossen sind. Zum Beispiel definiert [1; 3; 4;] einen Vektor mit den Elementen 1, 3 und 4.

__Matrizen:__ Eine Matrix wird durch eine Liste von Vektoren (hier als transponierte Vektoren interpretiert) dargestellt, die durch Semikolons getrennt und in eckigen Klammern eingeschlossen sind. Jeder Vektor repräsentiert eine Zeile in der Matrix. Zum Beispiel definiert [3 5; 3 2;] eine Matrix mit den Zeilen (3, 5) und (3, 2).

Die Elemente in den Vektoren und den Zeilen der Matrix sind durch Leerzeichen getrennt.

Zusätzlich ist es wichtig zu beachten, dass sowohl für Vektoren als auch für Matrizen die Semikolons zum Trennen der Elemente bzw. Zeilen obligatorisch sind. Dies bedeutet, dass sogar der letzte Vektor bzw. die letzte Zeile in der Matrix mit einem Semikolon enden muss.

Eine eindimensionale Matrix wie [3 5 6;] repräsentiert einen Zeilenvektor (3, 5, 6). Wenn dieser Vektor als Spaltenvektor dargestellt werden soll, muss der Apostroph-Operator verwendet werden, z.B. [3 5 6;]' = [3; 5; 6;].-