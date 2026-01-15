@register
Feature: Register Page

  Background: Given I access the register page

  Scenario: Register new user
    When I populate the form fields
    And I click the sign up button
    Then I should Verify user is on dashboard