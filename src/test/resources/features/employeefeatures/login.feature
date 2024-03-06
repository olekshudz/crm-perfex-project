@regression @login
Feature: Testing Login Functionality

  Background:
    Given Navigate to CRM url
    And Verify the title is "Techtorial CRM - Login"
    And Verify Log In is visible on the page

  Scenario: Positive Login
    When User enters correct employee email and password
    Then User verifies title is "Dashboard"

  Scenario: Negative Login
    When User enters incorrect employee email and password
    Then User verifies error message "Invalid email or password" in red color