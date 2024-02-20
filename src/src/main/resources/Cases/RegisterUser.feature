Feature: User Registration

  @scenario1
  Scenario Outline: Successful User Registration
    Given The user is on the registration page
    When The user enters <E-mail> , <Password> , <Phone> , <User-Name>  # Email is unique
    And Clicks the register button
    Then I should E-mail and Password is valid

    Examples:
   | E-mail              | Password  | Phone   | User-Name
   | Misk2023@gmail.com  | 2262023   | 0987654 | Misk
   | Ghina2018@gmail.com | 1142018   | 0123487 | Ghina



  @scenario2
  Scenario Outline: Attempting to Register with Existing E-mail
    Given The user is on the registration page
    When The user enters an existing <E-mail> ,a valid  password <Password>, phone <Phone> and user name <User-Name>
    And Clicks the register button
    Then The user should see an error message indicating the Email is already taken

    Examples:
    | E-mail              | Password  | Phone   | User-Name
    | Abood2019@gmail.com | 2552019   |0943178  | Abood
    | Ghina2018@gmail.com | 1142018   | 0123487 | Ghina


