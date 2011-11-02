package nl.wi99ert.circle;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;


public class CircleArithmeticTest {
    
    private static final int SMALL = 1;
    private static final int NORMAL = 8;
    private static final int BIG = 50;
    
    
    private Circle smallCircle = new Circle(SMALL);
    private Circle normalCircle = new Circle(NORMAL);
    private Circle bigCircle = new Circle(BIG);
    
    /**
     * [small] + [big] = [small][big]
     */
    @Test
    public void addsTwoCirclesTogether() throws Exception {
        CircleCombination actual = CircleArithmetic.add(smallCircle, bigCircle);
        assertSmallAndBig(actual, SMALL, BIG);
    }
    
    /**
     * [normal][big] + [small] = [small + normal][big]
     */
    @Test
    public void addsCircleCombinationAndSmallCircle() throws Exception {
        CircleCombination combi = CircleArithmetic.add(normalCircle, bigCircle);
        CircleCombination actual = CircleArithmetic.add(combi, smallCircle);
        
        assertSmallAndBig(actual, SMALL + NORMAL, BIG);
    }
    
    @Test
    public void addsCircleCombinationAndBigCircle() throws Exception {
        CircleCombination combi = CircleArithmetic.add(smallCircle, normalCircle);
        CircleCombination actual = CircleArithmetic.add(combi, bigCircle);
        
        assertSmallAndBig(actual, SMALL + NORMAL, BIG);
    }
    
    @Test
    public void subtractOneCircleFromTheOther() throws Exception {
        Circle actual = CircleArithmetic.subtract(bigCircle, smallCircle);
        assertThat(actual.getRadius(), is(BIG - SMALL));
    }
    
    @Test
    public void subtractOneCircleFromTheOtherSmallestFirst() throws Exception {
        Circle actual = CircleArithmetic.subtract(smallCircle, bigCircle);
        assertThat(actual.getRadius(), is(BIG - SMALL));
    }

    private void assertSmallAndBig(CircleCombination actual, int small, int big) {
        assertThat(actual.getSmallCircle().getRadius(), is(small));
        assertThat(actual.getBigCircle().getRadius(), is(big));
        
    }
}
