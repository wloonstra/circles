find . -name '*.class' | xargs rm
scalac -cp lib/scalatest-1.6.1.jar Circles.scala CirclesTest.scala &&
scala -cp lib/scalatest-1.6.1.jar org.scalatest.tools.Runner -p . -o -s CirclesTest
