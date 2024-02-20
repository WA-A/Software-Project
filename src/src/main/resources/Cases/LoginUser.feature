Feature: User Login

  @scenario1
  Scenario Outline: User Login with Different Cases
    Given The user is on the login page
    When The user enters a valid username <User-Name> and password <Password>
    And Clicks the login button
    Then the user should be logged in <message>

    Examples:
      | User-Name               | Password         | message             |
      |  Ghina                  | 1142018          | Successful   Login  |
      |  Ghina                  | WorngPassword    | Unsuccessful Login  |
      | nonexistent User Name   | 1142018          | Unsuccessful Login  |
      | Ghina                   |                  | Unsuccessful Login  |
      |                         | 1142018          | Unsuccessful Login  |
