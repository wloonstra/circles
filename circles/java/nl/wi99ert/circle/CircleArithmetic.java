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
        List<Circle> circles = Lists.newArrayList();
        circles.addAll(combination.getCircles());
        circles.add(circle);
        
        Collections.sort(circles, new Comparator<Circle>(){
            @Override
            public int compare(Circle circleA, Circle circleB) {
                return circleA.getRadius() - circleB.getRadius();
            }
        });
        
        return new CircleCombination(new Circle(circles.get(0), circles.get(1)), 
                                     circles.get(2));
    }

    public static Circle subtract(Circle bigCircle, Circle smallCircle) {
        return new Circle(Math.abs(bigCircle.getRadius() - smallCircle.getRadius()));
    }

}
