class Circle(val radius: Int) {
    var attachedCircle: Circle = null
    
    def show() = {
        var message = this.toString;
        if (attachedCircle != null) {
            message += " and attached to it another " + attachedCircle
        }
        println(message)
    }
    
    def attachTo(circle: Circle) = {
        attachedCircle = circle
    }
    
    override def toString() = "circle with radius " + radius
    
}

object Circle {
    def bringTogether(circle1: Circle, circle2: Circle) = {
        var circles = List(circle1, circle2)
        circles = circles.sortWith((s, t) => s.radius > t.radius)
        circles(0).attachTo(circles(1))
        circles(0)
    }
}

val smallCircle = new Circle(4)
smallCircle.show
val bigCircle = new Circle(12)
bigCircle.show

val circleWithRelation = Circle.bringTogether(smallCircle, bigCircle)
circleWithRelation.show
