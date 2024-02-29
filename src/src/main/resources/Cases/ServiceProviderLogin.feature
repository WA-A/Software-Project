
Feature: Service Provider Login

  @scenario1
  Scenario Outline: Successful Service Provider Login
    Given The Service Provider is on the login page
    When The Service Provider enters a valid username <Service Provider-Name> and password <Password>
    Then The Service Provider should be logged in successfully in <message>

    Examples:
      | Service Provider-Name   | Password             | message               |
      | Wasan                   | 1832002              | Successfully   Login  |
      | Wasan                   | wrongPassword        | Unsuccessfully Login  |

      | Wasan                   |                      | Unsuccessfully Login  |
      |                         | 1832002              | Unsuccessfully Login  |


  Scenario Outline: Unsuccessful Service Provider Login with Incorrect Password
    Given The Service Provider is on the login page
    When The Service Provider enters a valid username <Service Provider-Name> and incorrect password "wrongPassword" in <Password>
    Then The Service Provider should see an error message indicating incorrect password in <message>

    Examples:
      | Service Provider-Name   | Password             | message              |
      | Wasan                   | wrongPassword        |  incorrect password  |

  Scenario Outline: Unsuccessful Service Provider Login with Nonexistent Username
    Given The Service Provider is on the login page
    When The Service Provider enters a nonexistent username <Service Provider-Name> and password "someAdminPassword" in <Password>
    Then The Service Provider should see an error message indicating invalid username in <message>

    Examples:
      | Service Provider-Name   | Password             | message           |
      | nonexistent Admin-User  | 1832002              | invalid username  |


  Scenario Outline: Service Provider Attempts to Login Without Entering Password
    Given The Service Provider is on the login page
    When The Service Provider enters a valid username <Service Provider-Name> and leaves the password field blank in <Password>
    Then The Service Provider should see an error message indicating the password is required in <message>

    Examples:
      | Service Provider-Name   | Password             | message              |
      | Wasan                   |                      | password is required |

  Scenario Outline: Service Provider Attempts to Login Without Entering Username
    Given The Service Provider is on the login page
    When The Service Provider leaves the username field blank in <Service Provider-Name> and enters a valid password  <Password>
    Then The Service Provider should see an error message indicating the username is required in <message>


    Examples:
      | Service Provider-Name   | Password             | message              |
      |                         | 1832002              | username is required |