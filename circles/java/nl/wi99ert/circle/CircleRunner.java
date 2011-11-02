package nl.wi99ert.circle;

import static nl.wi99ert.circle.CircleArithmetic.add;

public class CircleRunner {

    public static void main(String... args) {
        Circle smallCircle = new Circle(4);
        System.out.println(smallCircle);
        Circle bigCircle = new Circle(12);
        System.out.println(bigCircle);
        
        CircleCombination circleCombination = add(smallCircle, bigCircle);
        System.out.println(circleCombination);
    }

}
