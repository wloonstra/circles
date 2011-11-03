import org.scalatest.FunSuite
import nl.wi99ert._
 
class CirclesTest extends FunSuite {
    val small = 1
    val normal = 8
    val big = 50

    val smallCircle = new Circle(small)
    val normalCircle = new Circle(normal)
    val bigCircle = new Circle(big)
 
    test("adds two circles, smallest first") {
        val actual = CircleArithmetic.add(smallCircle, bigCircle)
        assertSmallAndBig(actual, small, big)
    }
    
    test("adds two circles, biggest first") {
        val actual = CircleArithmetic.add(bigCircle, smallCircle)
        assertSmallAndBig(actual, small, big)
    }
    
    def assertSmallAndBig(actual: CircleCombination, small: Int, big: Int) = {
        assert(actual.smallCircle.radius === small)   
        assert(actual.bigCircle.radius === big)
    }
 
}