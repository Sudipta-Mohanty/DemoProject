
@tag
Feature: User Registration
  I want to use this template for new user registration

  @tag1
  Scenario: check new user registration with valid input
    Given I open browser with url "http://orangehrm.qedgetech.com"
    Then I should see login page
    When I eneter username as "Admin"
    And enter password as "Qedge123!@#"
    And click login 
    Then I should see  admin module
    When I go to user registration page
    When I select userrole
    And enter emplyoee name as "Mohanlal Demo"
    And enter username as "Mohanlal32"
    And enter user password as "Mohanlal123!@#"
    And enter confirm password as "Mohanlal123!@#"
    And click savebtn
    Then i should see new user in the user registration list table
    When I click logout
    Then I should see login page
    When I close browser
    
    
    
 