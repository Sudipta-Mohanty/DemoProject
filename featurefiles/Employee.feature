
@tag
Feature:  Employee Registration
  I want to use this template for add new employee

  @tag1
  Scenario: Check new emplyoee registration with valid input
    Given I open browser with url "http://orangehrm.qedgetech.com"
    Then I should see login page
    When I eneter username as "Admin"
    And enter password as "Qedge123!@#"
    And click login 
    Then I should see  admin module
    When I go to add employee page
    When I enter firstname as "Mohanlal"
    And enter lastname as "Demo"
    And click save
    Then I should see new employee in emp list table
    When I click logout
    Then I should see login page
    When I close browser

