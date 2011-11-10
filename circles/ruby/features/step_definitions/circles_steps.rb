require 'test/unit/assertions'
require 'src/ruby/circles'
World(Test::Unit::Assertions)

Given /^a circle (\w+) with radius (\d+)$/ do |name, radius|
    newCircle = Circle.new(radius) 
    instance_variable_set("@#{name}", newCircle)
end

Given /^a circleCombination (\w+) with radius (\d+) and (\d+)$/ do |name, firstRadius, secondRadius|
    firstCircle = Circle.new(firstRadius)
    secondCircle = Circle.new(secondRadius)
    circleCombination = CircleCombination.new(firstCircle, secondCircle)
    instance_variable_set("@#{name}", circleCombination)
end

When /^I add circle (\w+) and (\w+)$/ do |first, second|
    firstCircle = instance_variable_get("@#{first}")
    secondCircle = instance_variable_get("@#{second}")
    combi = addToCircle(firstCircle, secondCircle)
    instance_variable_set("@result", combi)
end

When /^I add circle (\w+) to circleCombination (\w+)$/ do |circle, circleCombination|
    combination = instance_variable_get("@#{circleCombination}")
    circleToAttach = instance_variable_get("@#{circle}")
    combi = addToCombination(combination, circleToAttach)
    instance_variable_set("@result", combi)
end

begin
    require 'rubygems'
    require 'matchy'
    
    Then /^I can assert that (\w+) has radius (\d+)$/ do |name, radius|
        circle = instance_variable_get("@#{name}")
        circle.radius.to_i.should == radius.to_i
    end
    
    Then /^the combination has radius (\d+) and (\d+)$/ do |radiusA, radiusB|
        actual = instance_variable_get("@result")
        actual.smallCircle.radius.to_i.should == radiusA.to_i
        actual.bigCircle.radius.to_i.should == radiusB.to_i
    end
end
