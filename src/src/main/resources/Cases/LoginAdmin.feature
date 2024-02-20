
Feature: Admin Login

  @scenario1
  Scenario Outline: Admin Login with Different Cases
    Given The admin is on the login page
    When The admin enters a valid username <Admin-User> and password <Password>
    And Clicks the login button
    Then The admin should be logged in <message>

    Examples:
      | Admin-User              | Password             | message               |
      | Wasan                   | 1832002              | Successfully   Login  |
      | Wasan                   | wrongPassword        | Unsuccessfully Login  |
      | nonexistent Admin-User  | 1832002              | Unsuccessfully Login  |
      | Wasan                   |                      | Unsuccessfully Login  |
      |                         | 1832002              | Unsuccessfully Login  |
