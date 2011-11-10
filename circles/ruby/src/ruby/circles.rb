class Circle
    attr_accessor :radius
    
    def initialize(radius)
        @radius = radius
    end
    
    def to_s
        "circle with radius " + radius.to_s
    end
    
    def <=> other_circle
        if self.radius.to_i < other_circle.radius.to_i
            return -1
        elsif self.radius.to_i > other_circle.radius.to_i
            return 1
        else
            return 0
        end
    end
end

class CircleCombination
    attr_accessor :smallCircle, :bigCircle
    
    def initialize(circleA, circleB)
        if circleA.radius.to_i < circleB.radius.to_i
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
    radii.sort! {|a,b| a.radius.to_i <=> b.radius.to_i }
    radiusForFirstCircle = radii[0].radius.to_i + radii[1].radius.to_i
    CircleCombination.new(Circle.new(radiusForFirstCircle.to_i),
                          radii[2])
end
