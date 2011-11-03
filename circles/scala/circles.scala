package nl.wi99ert {
    class Circle(val radius: Int) {
        override def toString() = "circle with radius " + radius
    }
    
    class CircleCombination(val smallCircle: Circle, val bigCircle: Circle) {       
        override def toString() = bigCircle.toString + " and attached to it another " + smallCircle.toString   
    }
    
    object CircleArithmetic {
        def add(circle1: Circle, circle2: Circle): CircleCombination = {
//            var circles = List(circle1, circle2)
//            circles = circles.sortWith((s, t) => s.radius < t.radius)
            new CircleCombination(circle1, circle2)
        }
    }
}