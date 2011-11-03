package nl.wi99ert.circle;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.google.common.collect.Lists;

public class CircleArithmetic {
    
    public static CircleCombination add(Circle circle1, Circle circle2) {
        if (circle1.getRadius() <= circle2.getRadius()) {
            return new CircleCombination(circle1, circle2);
        } else {
            return new CircleCombination(circle2, circle1);
        }
    }
    
    public static CircleCombination add(CircleCombination combination, Circle circle) {
        SortedCircles sortedCircles = getSortedCircles(combination, circle);
        return new CircleCombination(new Circle(sortedCircles.getSmallCircle(), sortedCircles.getNormalCircle()), 
                                     sortedCircles.getBigCircle());
    }

    public static Circle subtract(Circle bigCircle, Circle smallCircle) {
        return doSubtraction(bigCircle, smallCircle);
    }
    
    public static CircleCombination subtract(CircleCombination combination, Circle circle) {
        SortedCircles sortedCircles = getSortedCircles(combination, circle);
        if (sortedCircles.getBigCircle() == circle) {
            return new CircleCombination(doSubtraction(sortedCircles.getBigCircle(),
                                                       doSubtraction(sortedCircles.getSmallCircle(), 
                                                                     sortedCircles.getNormalCircle())));
        }
        return new CircleCombination(doSubtraction(sortedCircles.getBigCircle(), sortedCircles.getSmallCircle()),
                                     sortedCircles.getNormalCircle());
    }
    
    private static SortedCircles getSortedCircles(CircleCombination combination,
            Circle circle) {
        List<Circle> circles = Lists.newArrayList();
        circles.addAll(combination.getCircles());
        circles.add(circle);
        
        return new SortedCircles(circles);
    }
    
    private static Circle doSubtraction(Circle bigCircle, Circle smallCircle) {
        return new Circle(Math.abs(bigCircle.getRadius() - smallCircle.getRadius()));
    }
    
    private static class SortedCircles {
        
        private final Circle smallCircle;
        private final Circle normalCircle;
        private final Circle bigCircle;

        public SortedCircles(List<Circle> circles) {
            Collections.sort(circles, new Comparator<Circle>(){
                @Override
                public int compare(Circle circleA, Circle circleB) {
                    return circleA.getRadius() - circleB.getRadius();
                }
            });
            
            this.smallCircle = circles.get(0);
            this.normalCircle = circles.get(1);
            this.bigCircle = circles.get(2);
        }

        public Circle getSmallCircle() {
            return smallCircle;
        }

        public Circle getNormalCircle() {
            return normalCircle;
        }

        public Circle getBigCircle() {
            return bigCircle;
        }
    }

}
