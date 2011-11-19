rm nl/wi99ert/circle/*.class
export CLASSPATH="lib/hamcrest-all-1.1.jar:lib/guava-10.0.1.jar:lib/junit.jar:nl/wi99ert/circle/*"
javac nl/wi99ert/circle/*.java
java org.junit.runner.JUnitCore CircleArithmeticTest
echo "Classpath is $CLASSPATH"
