package nl.wi99ert.circle;

public class Circle {
    
    private int radius;
    private Circle attachedCircle;
    
    Circle(int radius) {
        this.radius = radius;
    }
    
    public void attachTo(Circle circleToAttach) {
        this.attachedCircle = circleToAttach;
    }
    
    public int getRadius() {
        return radius;
    }

    public void show() {
        String message = this.toString();
        if (attachedCircle != null) {
            message += " and attached to it another " + attachedCircle;
        }
        System.out.println(message);
    }
    
    @Override
    public String toString() {
        return "circle with radius " + radius;
    }
}