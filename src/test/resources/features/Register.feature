@register
Feature: Register Page

  Scenario: Register new user
    Given I access the register page
    When I populate the form fields
    And I click the sign up button
    Then I should Verify user is on dashboard