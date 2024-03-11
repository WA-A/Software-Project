
Feature: Admin Login

  @scenario1
  Scenario Outline: Successful Admin Login
    Given The admin is on the login page
    When The admin enters a valid username <Admin-User> and password <Password>
    Then The admin should be logged in successfully in <message>

    Examples:
      | Admin-User              | Password             | message               |
      | Wasan                   | 1832002              | Successfully   Login  |
      | Wasan                   | wrongPassword        | Unsuccessfully Login  |

      | Wasan                   |                      | Unsuccessfully Login  |
      |                         | 1832002              | Unsuccessfully Login  |


  Scenario Outline: Unsuccessful Admin Login with Incorrect Password
    Given The admin is on the login page
    When The admin enters a valid username <Admin-User> and incorrect password "wrongPassword" in <Password>
    Then The admin should see an error message indicating incorrect password in <message>

    Examples:
      | Admin-User              | Password             | message              |
      | Wasan                   | wrongPassword        |  incorrect password  |

  Scenario Outline: Unsuccessful Admin Login with Nonexistent Username
    Given The admin is on the login page
    When The admin enters a nonexistent username <Admin-User> and password "someAdminPassword" in <Password>
    Then The admin should see an error message indicating invalid username in <message>

    Examples:
      | Admin-User              | Password             | message           |
      | nonexistent Admin-User  | 1832002              | invalid username  |


  Scenario Outline: Admin Attempts to Login Without Entering Password
    Given The admin is on the login page
    When The admin enters a valid username <Admin-User> and leaves the password field blank in <Password>
    Then The admin should see an error message indicating the password is required in <message>

    Examples:
      | Admin-User              | Password             | message              |
      | Wasan                   |                      | password is required |

  Scenario Outline: Admin Attempts to Login Without Entering Username
    Given The admin is on the login page
    When The admin leaves the username field blank in <Admin-User> and enters a valid password  <Password>
    Then The admin should see an error message indicating the username is required in <message>


    Examples:
      | Admin-User              | Password             | message              |
      |                         | 1832002              | username is required |