Feature: Verify tag creation
  Scenario: User must be able to create a tag
    user creates a tag using API
    Verify tag is created in database
    Update tag using API
    Verify tag is updated in database
    Delete the tag from db using SQL
    verify test is deleted  using API GET request


    Given  base url "https://backend.cashwise.us/api/myaccount"
    And user has endpoint "/tags"
    When user provides valid token
    And user provides request body with "key" and "value"
    Then user hits POST request
    Then verify status code 201
