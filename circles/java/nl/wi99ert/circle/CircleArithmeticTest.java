package nl.wi99ert.circle;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;


public class CircleArithmeticTest {
    
    private static final int SMALL = 1;
    private static final int MEDIUM = 8;
    private static final int BIG = 50;
    
    private final Circle smallCircle = new Circle(SMALL);
    private final Circle mediumCircle = new Circle(MEDIUM);
    private final Circle bigCircle = new Circle(BIG);
    
    /**
     * [small] + [big] = [small][big]
     */
    @Test
    public void addsTwoCirclesTogether() throws Exception {
        CircleCombination actual = CircleArithmetic.add(smallCircle, bigCircle);
        assertSmallAndBig(actual, SMALL, BIG);
    }
    
    /**
     * [big] + [small] = [small][big]
     */
    @Test
    public void addsTwoCirclesTogetherBigFirst() throws Exception {
        CircleCombination actual = CircleArithmetic.add(bigCircle, smallCircle);
        assertSmallAndBig(actual, SMALL, BIG);
    }
    
    /**
     * [medium][big] + [small] = [small + medium][big]
     */
    @Test
    public void addsCircleCombinationAndSmallCircle() throws Exception {
        CircleCombination combi = CircleArithmetic.add(mediumCircle, bigCircle);
        CircleCombination actual = CircleArithmetic.add(combi, smallCircle);
        
        assertSmallAndBig(actual, SMALL + MEDIUM, BIG);
    }
    
    /**
     * [small][medium] + [big] = [small + medium][big]
     */
    @Test
    public void addsCircleCombinationAndBigCircle() throws Exception {
        CircleCombination combi = CircleArithmetic.add(smallCircle, mediumCircle);
        CircleCombination actual = CircleArithmetic.add(combi, bigCircle);
        
        assertSmallAndBig(actual, SMALL + MEDIUM, BIG);
    }
    
    /**
     * [big] - [small] = [big-small] 
     */
    @Test
    public void subtractOneCircleFromTheOther() throws Exception {
        Circle actual = CircleArithmetic.subtract(bigCircle, smallCircle);
        assertThat(actual.getRadius(), is(BIG - SMALL));
    }
    
    /**
     * [small] - [big] = [ | small-big | ] 
     */
    @Test
    public void subtractOneCircleFromTheOtherSmallestFirst() throws Exception {
        Circle actual = CircleArithmetic.subtract(smallCircle, bigCircle);
        assertThat(actual.getRadius(), is(BIG - SMALL));
    }
    
    /**
     * [medium][big] - [small] = [medium][big-small]  
     */
    @Test
    public void subtractSmallestFromCircleCombination() throws Exception {
        CircleCombination combi = CircleArithmetic.add(mediumCircle, bigCircle);
        CircleCombination actual = CircleArithmetic.subtract(combi, smallCircle);
        
        assertSmallAndBig(actual, MEDIUM, BIG - SMALL);
    }
    
    /**
     * [small][medium] - [big] = [ | big - | medium - small | | ]
     */
    @Test
    public void subtractBiggestFromCircleCombination() throws Exception {
        CircleCombination combi = CircleArithmetic.add(smallCircle, mediumCircle);
        CircleCombination actual = CircleArithmetic.subtract(combi, bigCircle);
        
        assertSmallAndBig(actual, 0, BIG - (MEDIUM - SMALL));
    }

    private void assertSmallAndBig(CircleCombination actual, int small, int big) {
        assertThat(actual.getSmallCircle().getRadius(), is(small));
        assertThat(actual.getBigCircle().getRadius(), is(big));
        
    }
}
