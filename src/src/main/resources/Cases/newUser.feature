Feature: User Management and Event Handling


  Scenario: Successfully Creating an Event
    Given the user wants to create an event with specific details
    When the user provides event details including "Meeting 1", a budget of 6000, "Nablus" location, 250 invitees, "2024-04-20" date, "18:00" start time, and "22:00" end time
    Then the system processes these details and the system prints a list of suitable packages based on the provided criteria


  Scenario: Choosing a Package for the Event
    Given the user has already created an event and received a list of suitable packages
    When the user selects a package by its Id 1
    Then the system assigns the selected package to the event


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
