package nl.wi99ert {

    class Circle(val radius: Int) {
        def this(circle1: Circle, circle2: Circle) {
            this(circle1.radius + circle2.radius)
        }
    }
    
    class CircleCombination(val smallCircle: Circle, val bigCircle: Circle) { }
    
    object CircleCombination {
        def from(circle: Circle) = {
            new CircleCombination(new Circle(0), circle)
        }
        
        def from(circle1: Circle, circle2: Circle) = {
            if (circle1.radius < circle2.radius) {
                new CircleCombination(circle1, circle2)
            } else {  
                new CircleCombination(circle2, circle1)
            }
        }
    }
    
    class SortedCircles(val smallCircle: Circle,
                        val normalCircle: Circle,
                        val bigCircle: Circle) { }
    
    object SortedCircles {
        def from(circleCombination: CircleCombination, circle: Circle) = {
            var sortedCircles = List(circleCombination.smallCircle,
                                     circleCombination.bigCircle, 
                                     circle)
            sortedCircles = sortedCircles.sortWith((s, t) => s.radius < t.radius)
            new SortedCircles(sortedCircles(0), sortedCircles(1), sortedCircles(2))
        }
    }
                        
    object CircleArithmetic {
        def add(circle1: Circle, circle2: Circle) = {
            CircleCombination.from(circle1, circle2)
        }
        
        def add(circleCombination: CircleCombination, circle: Circle) = {
            val sortedCircles = SortedCircles.from(circleCombination, circle)
            CircleCombination.from(new Circle(sortedCircles.smallCircle, 
                                              sortedCircles.normalCircle), 
                                   sortedCircles.bigCircle)
        }
        
        def subtract(circle1: Circle, circle2: Circle) = {
            doSubtraction(circle1, circle2)
        }
        
        def subtract(circleCombination: CircleCombination, circle: Circle): CircleCombination = {
            val sortedCircles = SortedCircles.from(circleCombination, circle)
            
            if (sortedCircles.bigCircle == circle) {
                return CircleCombination.from(doSubtraction(doSubtraction(sortedCircles.smallCircle,
                                                                          sortedCircles.normalCircle),
                                                            sortedCircles.bigCircle))
            } else {
                return CircleCombination.from(doSubtraction(sortedCircles.smallCircle,
                                                            sortedCircles.bigCircle),
                                              sortedCircles.normalCircle) 
            }
        }
        
        private def doSubtraction(circle1: Circle, circle2: Circle) = {
            new Circle(math.abs(circle1.radius - circle2.radius))
        }
    }
}
