package nl.wi99ert.circle;

import static com.google.common.collect.Lists.newArrayList;

import java.util.Collection;

public class CircleCombination {
    
    private final Circle smallCircle;
    private final Circle bigCircle;
    
    public CircleCombination(Circle circleA, Circle circleB) {
        if (circleA.getRadius() < circleB.getRadius()) {
            this.smallCircle = circleA;
            this.bigCircle = circleB;
        } else {
            this.smallCircle = circleB;
            this.bigCircle = circleA;
        }
    }
    
    public CircleCombination(Circle circle) {
        this.bigCircle = circle;
        this.smallCircle = new Circle(0);
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
