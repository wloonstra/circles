public class Circle {
    
    private int radius;
    private Circle attachedCircle;
    
    Circle(int radius) {
        this.radius = radius;
    }
    
    public void show() {
        String message = this.toString();
        if (attachedCircle != null) {
            message += " and attached to it another " + attachedCircle;
        }
        System.out.println(message);
    }
    
    public void attachTo(Circle circleToAttach) {
        this.attachedCircle = circleToAttach;
    }
    
    public int getRadius() {
        return radius;
    }
    
    @Override
    public String toString() {
        return "circle with radius " + radius;
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
    
    private static void attach(Circle circleA, Circle circleB) {
        circleA.attachTo(circleB);
    }
    
    public static void main(String... args) {
        Circle smallCircle = new Circle(4);
        smallCircle.show();
        Circle bigCircle = new Circle(12);
        bigCircle.show();
        
        Circle circleWithRelation = bringTogether(smallCircle, bigCircle);
        circleWithRelation.show();
    }
    
}