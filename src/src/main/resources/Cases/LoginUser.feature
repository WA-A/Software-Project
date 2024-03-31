Feature: User Login

  @scenario1
  Scenario Outline: Successful User Login
    Given The user is on the login page
    Given  a list of users <User>
    When The user enters a valid username <Username> and password <Password> are checked
    Then the user is found and logged in
    Then the user should be logged in successfully and show <message>

    Examples:
      | Username                | Password          | message                                   |
      |  Ghina                  | 1142018           | The User is not found   Successful Login  |

  Scenario Outline: Unsuccessful User Login with Incorrect Password
    Given The user is on the login page
    Given  a list of users <User>
    When The user enters a valid username <Username> and incorrect password "wrongPassword" in <Password> are checked
    Then the user is notfound and logged in
    Then The user should see an error message indicating incorrect password in <message>

    Examples:
    | Username                | Password          | message                                      |
    |  Ghina                  | WorngPassword     | The User is not found   incorrect password   |


  Scenario Outline: Unsuccessful User Login with Nonexistent Username
    Given The user is on the login page
    Given  a list of users <User>
    When The user enters a nonexistent username <Username> and password "somePassword" in <Password> are checked
    Then the user is notfound and logged in
    Then The user should see an error message indicating invalid username in <message>

    Examples:
      | Username                | Password          | message                                     |
      | nonexistent User Name   | 1142018           | The User is not found   invalid username    |

  Scenario Outline: User Attempts to Login Without Entering Password
    Given the user is on the login page
    Given  a list of users <User>
    When the user enters a valid username <Username> and leaves the password field blank in <Password> are checked
    Then the user is notfound and logged in
    And clicks the login button
    Then the user should see an error message indicating the password is required in <message>

    Examples:
      | Username                | Password         | message                                     |
      | Ghina                   |                  |The User is not found   password is required |


  Scenario Outline: User Attempts to Login Without Entering Username
    Given the user is on the login page
    Given  a list of users <User>
    When the user leaves the username field blank in <Username>  and enters a valid password <Password> are checked
    Then the user is notfound and logged in
    Then the user should see an error message indicating the username is required in <message>

Examples:
  | Username               | Password          | message                                      |
  |                         | 1142018          |The User is not found   username is required  |



