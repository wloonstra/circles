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
    
    test("adds circleCombination and small circle") {
        val combi = CircleArithmetic.add(normalCircle, bigCircle)
        val actual = CircleArithmetic.add(combi, smallCircle)
        assertSmallAndBig(actual, small + normal, big)
    }
    
    test("adds circleCombination and big circle") {
        val combi = CircleArithmetic.add(smallCircle, normalCircle)
        val actual = CircleArithmetic.add(combi, bigCircle)
        assertSmallAndBig(actual, small + normal, big)
    }
    
    test("subtract one circle from the other, biggest first") {
        val actual = CircleArithmetic.subtract(bigCircle, smallCircle)
        assert(actual.radius === big - small)
    }
    
    test("subtract one circle from the other, smallest first") {
        val actual = CircleArithmetic.subtract(smallCircle, bigCircle)
        assert(actual.radius === big - small)
    }
    
    test("subtract smallest from circle combination") {
        val combi = CircleArithmetic.add(normalCircle, bigCircle)
        val actual = CircleArithmetic.subtract(combi, smallCircle)
        assertSmallAndBig(actual, normal, big - small)
    }
    
    test("subtract biggest from circle combination") {
        val combi = CircleArithmetic.add(smallCircle, normalCircle)
        val actual = CircleArithmetic.subtract(combi, bigCircle)
        assertSmallAndBig(actual, 0, big - (normal - small))
    } 
    
    def assertSmallAndBig(actual: CircleCombination, small: Int, big: Int) = {
        assert(actual.smallCircle.radius === small)   
        assert(actual.bigCircle.radius === big)
    }
    
    
    
    
//    public void subtractSmallestFromCircleCombination() throws Exception {
//    public void subtractBiggestFromCircleCombination() throws Exception {
 
}