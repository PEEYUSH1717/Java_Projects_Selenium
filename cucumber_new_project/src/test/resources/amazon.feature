Feature: Amazon Login

  Scenario: Login with valid credentials
    Given I open Amazon login page
    When I enter valid email and password
    And I click on login button
    Then I should be redirected to my account page

    
  Scenario: Register with invalid email
    Given I open Amazon registration page
    When I enter invalid email in registration form
    And I click on create account button
    Then I should see an invalid email error message