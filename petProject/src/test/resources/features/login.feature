Feature: login to sauceDemo
@login
  Scenario: login to sauceDemo and verify you are logged in
    Given user is on the login page
    When user provides a valid username
    And user provides a valid password
    And user clicks on login button
    Then verify user logged in
