@login
Feature: Login Page
  As a registered user
  I want to log in to the application
  So that I can access my dashboard

  Background:
    Given I access the login page

  Scenario: Validate Successful Login
    When I fill in username and password
    And I click on the login button
    Then I should Verify user is on dashboard