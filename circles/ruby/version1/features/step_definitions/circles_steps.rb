require 'test/unit/assertions'
require 'src/ruby/circles'
World(Test::Unit::Assertions)

Given /^a circle (\w+) with radius (\d+)$/ do |name, radius|
    newCircle = Circle.new(radius.to_i) 
    instance_variable_set("@#{name}", newCircle)
end

begin
    require 'rubygems'
    require 'matchy'
    
    Then /^I can assert that (\w+) has radius (\d+)$/ do |name, radius|
        circle = instance_variable_get("@#{name}")
        circle.radius.should == radius.to_i
    end
end
