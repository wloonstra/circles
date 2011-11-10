class Circle
    attr_accessor :radius
    
    def initialize(radius)
        @radius = radius
    end
    
    def to_s
        "circle with radius " + radius.to_s
    end
end

class CircleCombination
    attr_accessor :smallCircle, :bigCircle
    
    def initialize(circleA, circleB)
        if circleA.radius < circleB.radius
            @smallCircle = circleA
            @bigCircle = circleB
        else
            @smallCircle = circleB
            @bigCircle = circleA
        end
    end
end

def addToCircle(circleA, circleB) 
    CircleCombination.new(circleA, circleB)
end

def addToCombination(circleCombination, circle)
    radii = [circleCombination.smallCircle, 
             circleCombination.bigCircle,
             circle]
    radii.sort! {|a,b| a.radius <=> b.radius }
    radiusForFirstCircle = radii[0].radius + radii[1].radius
    CircleCombination.new(Circle.new(radiusForFirstCircle),
                          radii[2])
end

def subtract(circleA, circleB)
    newRadius = (circleA.radius - circleB.radius).abs
    Circle.new(newRadius)
end
