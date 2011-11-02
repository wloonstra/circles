package nl.wi99ert.circle;

import static nl.wi99ert.circle.CircleHelper.bringTogether;

public class CircleRunner {

    public static void main(String... args) {
        Circle smallCircle = new Circle(4);
        smallCircle.show();
        Circle bigCircle = new Circle(12);
        bigCircle.show();
        
        Circle circleWithRelation = bringTogether(smallCircle, bigCircle);
        circleWithRelation.show();
    }

}
