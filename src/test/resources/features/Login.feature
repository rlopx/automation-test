@login
Feature: Login Page
  As a registered user
  I want to log in to the application
  So that I can access my dashboard

  Scenario: Validate Successful Login
    Given I access the login page
    When I fill in username and password
    And I click on the login button
    Then I should Verify user is on dashboard