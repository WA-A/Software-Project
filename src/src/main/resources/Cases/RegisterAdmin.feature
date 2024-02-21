Feature: Admin Registration

  @scenario1
  Scenario Outline: Successful Admin Registration
    Given The admin is on the registration page
    When The admin enters <E-mail> , <Password> , <Phone> , <Admin-Name>
    Then I should E-mail and Password is valid

    Examples:
      | E-mail              | Password  | Phone   | Admin-Name
      | wasan2020@gmail.com | 1832002   |095636   | Wasan

  @scenario2
  Scenario Outline: Attempting to Register with Existing E-mail
    Given The admin is on the registration page
    When The admin enters an existing <E-mail> ,a valid  password <Password> and  phone <Phone> and user name <Admin-Name>
    Then The admin should see an error message indicating the Email is already taken

    Examples:
      | E-mail              | Password  | Phone   | Admin-Name
      | wasan2020@gmail.com  | 1832002  |095636   |Wasan

