@login
Feature: Login Page

  Background:
    Given I access the login page

  Scenario Outline: Validate Successful & Unsuccessful Login
    When I fill in username and password with <username> and <password>
    And I click on the login button
    Then I should Verify user is on dashboard
    Examples:
      | username              | password   |
      | email@nttdata.com     | mYpas$w0rd |
      | failemail@nttdata.com | mYpas$w0rd |