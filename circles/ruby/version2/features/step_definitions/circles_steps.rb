require 'test/unit/assertions'
require 'src/ruby/circles'
World(Test::Unit::Assertions)

Given /^a circle (\w+) with radius (\d+)$/ do |name, radius|
    newCircle = Circle.new(radius.to_i) 
    instance_variable_set("@#{name}", newCircle)
end

When /^I add circle (\w+) and (\w+)$/ do |first, second|
    firstCircle = instance_variable_get("@#{first}")
    secondCircle = instance_variable_get("@#{second}")
    combi = addToCircle(firstCircle, secondCircle)
    instance_variable_set("@result", combi)
end

begin
    require 'rubygems'
    require 'matchy'
    
    Then /^I can assert that (\w+) has radius (\d+)$/ do |name, radius|
        circle = instance_variable_get("@#{name}")
        circle.radius.should == radius.to_i
    end
    
    Then /^the combination has radius (\d+) and (\d+)$/ do |radiusA, radiusB|
        actual = instance_variable_get("@result")
        actual.smallCircle.radius.should == radiusA.to_i
        actual.bigCircle.radius.should == radiusB.to_i
    end
end
