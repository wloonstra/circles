package nl.wi99ert.circle;

public class CircleHelper {
    
    
    private static void attach(Circle circleA, Circle circleB) {
        circleA.attachTo(circleB);
    }
    
    public static Circle bringTogether(Circle circle1, Circle circle2) {
        if (circle1.getRadius() <= circle2.getRadius()) {
            attach(circle2, circle1);
            return circle2;
        } else {
            attach(circle1, circle2);
            return circle1;
        }
    }

}
