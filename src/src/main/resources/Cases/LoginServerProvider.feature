
Feature: service Provider Login

  @scenario1
  Scenario Outline: Successful ServerProvider Login
    Given The Server Provider is on the login page
    Given  a list of service Providers <servicesProviders>
    When The serviceProvider enters a valid username <Username> and password <Password> are checked
    Then the serviceProvider is found and logged in
    Then The serviceProvider should be logged in successfully in <message>

    Examples:
      | Username                   | Password             | message                                             |
      | mohammad                   | 123123               |The Service Provider is found    Successfully Login  |



  Scenario Outline: Unsuccessful ServerProvider Login with Incorrect Password
    Given The Server Provider is on the login page
    Given  a list of service Providers <servicesProviders>
    When The service Provider enters a valid username <Username> and incorrect password "wrongPassword" in <Password> are checked
    Then the service Provider is notfound and logged in
    Then The service Provider should see an error message indicating incorrect password in <message>

    Examples:
      | Username                | Password      | message                                                  |
      | mohammad                | wrongPassword        | The Service Provider is not found    incorrect password  |

  Scenario Outline: Unsuccessful ServerProvider Login with Nonexistent Username
    Given The Server Provider is on the login page
    Given  a list of service Providers <servicesProviders>
    When The service Provider enters a nonexistent username <Username> and password "somePassword" in <Password> are checked When The admin enters a valid username <Username> and password <Password> are checked
    Then the service Provider is notfound and logged in
    Then The service Provider should see an error message indicating invalid username in <message>

    Examples:
      | Username                | Password             | message                                               |
      | nonexistent Admin-User  | 123123              |The Service Provider is not found    invalid username  |


  Scenario Outline: ServerProvider Attempts to Login Without Entering Password
    Given The Server Provider is on the login page
    Given  a list of service Providers <servicesProviders>
    When the service Provider enters a valid username <Username> and leaves the password field blank in <Password> are checked
    Then the service Provider is notfound and logged in
    Then The service Provider should see an error message indicating incorrect password in <message>

    Examples:
      | Username                | Password          | message                                                  |
      | mohammad                |                   |The Service Provider is not found    password is required |

  Scenario Outline: ServerProvider Attempts to Login Without Entering Username
    Given The Server Provider is on the login page
    Given  a list of service Providers <servicesProviders>
    When the Server Provider leaves the username field blank in <Username>  and enters a valid password <Password> are checked
    Then the service Provider is notfound and logged in
    Then The service Provider should see an error message indicating incorrect password in <message>


    Examples:
      | Username                | Password             | message                                       |
      |                         | 123123              |The Service Provider is not found    username is required |