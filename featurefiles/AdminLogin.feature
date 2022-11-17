
  @tag
  Feature: Admin Login
  I want to use this template for Admin Login Test

    @tag1
    Scenario: Admin Login Test with valid Input
    Given I open browser with url "http://orangehrm.qedgetech.com"
    Then I should see login page
    When I eneter username as "Admin"
    And enter password as "Qedge123!@#"
    And click login 
    Then I should see  admin module
    When I click logout
    Then I should see login page
    When I close browser
    
  @tag2
  Scenario Outline: Admin Login test with invalid test
   Given I open browser with url "http://orangehrm.qedgetech.com"
   Then I should see login page
   When I eneter username as "usname"
   And enter password as "pword"
   And  click login
   Then I should see an error message
   When I close browser
   
   
   
    Examples: 
      | usname  | pword | 
      | Admin |     abc | 
      | abc |  Qedge123!@#| 
      | abc | xyz |
    