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
- Build project```mvn package```
- Run Main```java -cp ".\target\MathExprParserStudien-1.0-SNAPSHOT.jar;.\target\lib\*" de.dhbw.karlsruhe.dsl.Main --add-exports org.graalvm.truffle/com.oracle.truffle.api.nodes=ALL-UNNAMED```
