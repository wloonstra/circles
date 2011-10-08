class Circle

    attr_accessor :attachedCircle, :radius
    
    def initialize(radius)
        @radius = radius
    end
    
    def show() 
        message = self.to_s
        if (attachedCircle != nil)
            message = message + " and attached to it another " + attachedCircle.to_s
        end
        puts message
    end
    
    def attachTo(circle)
        @attachedCircle = circle
    end
    
    def to_s
        "circle with radius " + radius.to_s
    end
end

def bringTogether(circle1, circle2)
    if circle1.radius <= circle2.radius
        attach(circle2, circle1)
        return circle2
    else
        attach(circle1, circle2)
        return circle1
    end
end

def attach(circleA, circleB)
    circleA.attachTo(circleB)
end

smallCircle = Circle.new(4)
smallCircle.show
bigCircle = Circle.new(12)
bigCircle.show

circleWithRelation = bringTogether(smallCircle, bigCircle)
circleWithRelation.show
    