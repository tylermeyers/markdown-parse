
CLASSPATH =.:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar

echo $CLASSPATH

javac -cp $CLASSPATH MarkdownParseTest.java MarkdownParse.java

java -cp $CLASSPATH org.junit.runner.JUnitCore MarkdownParseTest