class Circle
    attr_accessor :radius
    
    def initialize(radius)
        @radius = radius
    end
    
    def to_s
        "circle with radius " + radius.to_s
    end
end
