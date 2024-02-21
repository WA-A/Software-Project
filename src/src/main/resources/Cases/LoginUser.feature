Feature: User Login

  @scenario1
  Scenario Outline: Successful User Login
    Given The user is on the login page
    When The user enters a valid username <User-Name> and password <Password>
    Then the user should be logged in successfully and show <message>

    Examples:
      | User-Name               | Password         | message             |
      |  Ghina                  | 1142018          | Successful   Login  |

  Scenario Outline: Unsuccessful User Login with Incorrect Password
    Given The user is on the login page
    When The user enters a valid username <User-Name> and incorrect password "wrongPassword" in <Password>
    Then The user should see an error message indicating incorrect password in <message>

    Examples:
    | User-Name               | Password         | message             |
    |  Ghina                  | WorngPassword    | incorrect password  |


  Scenario Outline: Unsuccessful User Login with Nonexistent Username
    Given The user is on the login page
    When The user enters a nonexistent username <User-Name> and password "somePassword" in <Password>
    Then The user should see an error message indicating invalid username in <message>

    Examples:
      | User-Name               | Password         | message             |
      | nonexistent User Name   | 1142018          | invalid username    |

  Scenario Outline: User Attempts to Login Without Entering Password
    Given the user is on the login page
    When the user enters a valid username <User-Name> and leaves the password field blank in <Password>
    And clicks the login button
    Then the user should see an error message indicating the password is required in <message>

    Examples:
      | User-Name               | Password         | message              |
      | Ghina                   |                  | password is required |


  Scenario Outline: User Attempts to Login Without Entering Username
    Given the user is on the login page
    When the user leaves the username field blank in <User-Name>  and enters a valid password <Password>
    Then the user should see an error message indicating the username is required in <message>

Examples:
  | User-Name               | Password         | message               |
  |                         | 1142018          | username is required  |



