rm *.class
export CLASSPATH=../../../lib/hamcrest-all-1.1.jar:../../../lib/guava-10.0.1.jar:../../../lib/junit.jar
javac -cp $CLASSPATH *.java
export CLASSPATH=../../../lib/junit.jar:.
java -cp $CLASSPATH org.junit.runner.JUnitCore CircleArithmeticTest
