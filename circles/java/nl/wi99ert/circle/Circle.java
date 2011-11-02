package nl.wi99ert.circle;

/**
 * Circle with radius.
 */
public class Circle {
    
    private int radius;
    
    Circle(int radius) {
        this.radius = radius;
    }
    
    Circle(Circle firstCircle, Circle secondCircle) {
        this.radius = firstCircle.getRadius() + secondCircle.getRadius();
    }
    
    public int getRadius() {
        return radius;
    }

    @Override
    public String toString() {
        return "circle with radius " + radius;
    }
}