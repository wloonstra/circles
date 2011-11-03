package nl.wi99ert {
    class Circle(val radius: Int) {
        def this(circle1: Circle, circle2: Circle) {
            this(circle1.radius + circle2.radius)
        }
        override def toString() = "circle with radius " + radius
    }
    
    class CircleCombination(val smallCircle: Circle, val bigCircle: Circle) {       
        override def toString() = bigCircle.toString + " and attached to it another " + smallCircle.toString   
    }
    
    object CircleCombination {
        def from(circle: Circle) = {
            new CircleCombination(new Circle(0), circle)
        }
        
        def from(circle1: Circle, circle2: Circle) = {
            var circles = List(circle1, circle2)
            circles = circles.sortWith((s, t) => s.radius < t.radius)
            new CircleCombination(circles(0), circles(1))
        }
    }
    
    object CircleArithmetic {
        def add(circle1: Circle, circle2: Circle) = {
            CircleCombination.from(circle1, circle2)
        }
        
        def add(circleCombination: CircleCombination, circle: Circle) = {
            val circles = getSortedCircles(circleCombination, circle)
            CircleCombination.from(new Circle(circles(0), circles(1)), 
                                   circles(2))
        }
        
        def subtract(circle1: Circle, circle2: Circle) = {
            doSubtraction(circle1, circle2)
        }
        
        def subtract(circleCombination: CircleCombination, circle: Circle): CircleCombination = {
            val circles = getSortedCircles(circleCombination, circle)
            
            if (circles(2) == circle) {
                return CircleCombination.from(doSubtraction(doSubtraction(circles(1), circles(0)),
                                              circles(2)))
            } else {
                return CircleCombination.from(doSubtraction(circles(0), circles(2)),
                                              circles(1)) 
            }
        }
        
        private def doSubtraction(circle1: Circle, circle2: Circle) = {
            new Circle(math.abs(circle1.radius - circle2.radius))
        }
        
        private def getSortedCircles(circleCombination: CircleCombination, circle: Circle) = { 
            var circles = List(circleCombination.smallCircle,
                               circleCombination.bigCircle, 
                               circle)
            circles.sortWith((s, t) => s.radius < t.radius)
        }
    }
    

}