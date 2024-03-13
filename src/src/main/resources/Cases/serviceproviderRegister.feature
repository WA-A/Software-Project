Feature: Service Provider Meeting Registration

  @scenario1
  Scenario Outline: Successful Service Provider Registration
    Given The Service Provider is on the registration page
    When The Service Provider enters <E-mail> , <Password> , <Phone> , <ServiceProvider-Name>
    Then I should E-mail and Password is valid

    Examples:
      | E-mail              | Password  | Phone   | ServiceProvider-Name
      | wasan2020@gmail.com | 1832002   |095636   | Wasan

  @scenario2
  Scenario Outline: Attempting to Register with Existing E-mail
    Given The Service Provider is on the registration page
    When The Service Provider enters an existing <E-mail> ,a valid  password <Password> and  phone <Phone> and user name <ServiceProvider-Name>
    Then The Service Provider should see an error message indicating the Email is already taken

    Examples:
      | E-mail              | Password   | Phone   | ServiceProvider-Name
      | wasan2020@gmail.com | 1832002   |095636   | Wasan