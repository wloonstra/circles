Feature: Circles 
  In order to explore Cucumber and Ruby
  As a programmer
  I want to be able to use ruby for circle arithmetic

  Scenario: creating a circle
    Given a circle A with radius 1
    And a circle B with radius 8
    Then I can assert that A has radius 1
    And I can assert that B has radius 8

  Scenario: adding two circles, smallest first
    Given a circle A with radius 1
    And a circle B with radius 8
    When I add circle A and B
    Then the combination has radius 1 and 8

  Scenario: adding two circles, biggest first
    Given a circle A with radius 1
    And a circle B with radius 8
    When I add circle B and A
    Then the combination has radius 1 and 8 

  Scenario: adding a small circle to a circleCombination
    Given a circleCombination C with radius 8 and 50
    And a circle S with radius 1
    When I add circle S to circleCombination C
    Then the combination has radius 9 and 50
