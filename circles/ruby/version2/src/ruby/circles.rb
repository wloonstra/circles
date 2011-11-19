class Circle
    attr_accessor :radius
    
    def initialize(radius)
        @radius = radius
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
