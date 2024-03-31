
Feature: Admin Login

  @scenario1
  Scenario Outline: Successful Admin Login
    Given The admin is on the login page
    Given  a list of admin <Admin>
    When The admin enters a valid username <Username> and password <Password> are checked
    Then the admin is found and logged in
    Then The admin should be logged in successfully in <message>

    Examples:
      | Username                | Password             | message                                  |
      | Wasan                   | 1832002              |The admin is found    Successfully Login  |



  Scenario Outline: Unsuccessful Admin Login with Incorrect Password
    Given The admin is on the login page
    Given  a list of admin <Admin>
    When The user enters a valid username <Username> and incorrect password "wrongPassword" in <Password> are checked
    Then the admin is found and logged in
    Then The admin should see an error message indicating incorrect password in <message>

    Examples:
      | Username                | Password             | message                                       |
      | Wasan                   | wrongPassword        | The admin is not found    incorrect password  |

  Scenario Outline: Unsuccessful Admin Login with Nonexistent Username
    Given The admin is on the login page
    Given  a list of admin <Admin>
    When The admin enters a nonexistent username <Username> and password "somePassword" in <Password> are checked
    Then the admin is found and logged in
    Then The admin should see an error message indicating invalid username in <message>

    Examples:
      | Username                | Password             | message                                    |
      | nonexistent Admin-User  | 1832002              |The admin is not found    invalid username  |


  Scenario Outline: Admin Attempts to Login Without Entering Password
    Given The admin is on the login page
    Given  a list of admin <Admin>
    When the admin enters a valid username <Username> and leaves the password field blank in <Password> are checked
    Then the admin is found and logged in
    Then The admin should see an error message indicating the password is required in <message>

    Examples:
      | Username                | Password               | message                                       |
      | Wasan                   |                      |The admin is not found    password is required |

  Scenario Outline: Admin Attempts to Login Without Entering Username
    Given The admin is on the login page
    Given  a admin of admin <Admin>
    When the user leaves the username field blank in <Username>  and enters a valid password <Password> are checked
    Then the admin is found and logged in
    Then The admin should see an error message indicating the username is required in <message>


    Examples:
      | Username                | Password             | message                                       |
      |                         | 1832002              |The admin is not found    username is required |