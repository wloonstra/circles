package nl.wi99ert.circle;

import static com.google.common.collect.Lists.newArrayList;

import java.util.Collection;

public class CircleCombination {
    
    private Circle smallCircle;
    private Circle bigCircle;
    
    public CircleCombination(Circle smallCircle, Circle bigCircle) {
        this.smallCircle = smallCircle;
        this.bigCircle = bigCircle;
    }
    
    @Override
    public String toString() {
        return bigCircle + " and attached to it another " + smallCircle;
    }

    public Collection<Circle> getCircles() {
        return newArrayList(smallCircle, bigCircle);
    }

    public Circle getSmallCircle() {
        return smallCircle;
    }

    public Circle getBigCircle() {
        return bigCircle;
    }
    
    
}
