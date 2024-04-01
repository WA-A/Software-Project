Feature: User Registration

  @scenario1
  Scenario Outline: Successful User Registration
    Given The user is on the registration page
    When The user enters <Username>,  <Password> ,<Email>  , <PhoneNum>
    Then I should Email and Password is valid

    Examples:
    |Username  | Email              | Password  | PhoneNum   |
    | sameh    |sameh@gmail.com     | 223344    |0598553051  |



  @scenario2
  Scenario Outline: Attempting to Register with Existing E-mail
    Given The user is on the registration page
    When The user enters an existing <Email> ,a valid  password <Password>, phone <PhoneNum> and user name <Username>
    Then The user should see an error message indicating the Email is already taken

    Examples:
      |Username  | Email              | Password  | PhoneNum   |
      | sameh    |sameh@gmail.com     | 223344    |0598553051  |


