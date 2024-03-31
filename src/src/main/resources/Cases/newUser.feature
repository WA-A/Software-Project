Feature: User Management and Event Handling

  Scenario: User registration with valid details
    Given no user is currently registered with username "yazan"
    When "yazan" registers with password "yazan123", email "yazan@example.com", and phone number "123456"
    Then the user "yazan" should be successfully registered

  Scenario: User login with correct credentials
    Given "yazan" is a registered user
    When "yazan" logs in with password "yazan123"
    Then "yazan" should be successfully logged in

  Scenario: Creating an event with all valid details
    Given user is logged in
    And user has specified a budget of 3000, location "City Park", number of invitees 50, date "2024-06-15", and start time "14"
    When user attempts to create an event "Spring Gala"
    Then the event "Spring Gala" should be successfully created
    And user should receive a confirmation with the event details

  Scenario: Creating an event with a budget too low for available packages
    Given user is logged in
    And "yazan" specifies a budget of 100
    When "yazan" attempts to create an event "Budget Meeting"
    Then the creation should fail with a budget error

  Scenario: Creating an event with an invalid location
    Given user is logged in
    And user specifies the location "Unknown Valley"
    When "yazan" attempts to create an event "Desert Adventure"
    Then the creation should fail with a location error


  Scenario: Creating an event exceeding capacity limits
    Given user is logged in
    And user specifies a number of invitees 500
    When user attempts to create an event "Mega Party"
    Then the creation should fail with a capacity error


  Scenario: Viewing user's created events
    Given user is logged in and has created multiple events
    When user requests to view his events
    Then all events created by user should be listed

  Scenario: Deleting an existing event
    Given user is logged in
    And user has created an event "Farewell Party"
    When user requests to delete the event "Farewell Party"
    Then the event "Farewell Party" should be successfully deleted
    And user should receive confirmation of the deletion
