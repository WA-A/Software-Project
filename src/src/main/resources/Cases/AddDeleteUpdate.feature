Feature: Event Management

  @scenario1
  Scenario Outline: Organizers managing events and participants registering for events
    Given The organizer is logged in
    When The organizer creates an event with title <Event Title>, date <Event Date>, and location <Event Location>
    And Clicks the create event button
    Then The event should be created successfully <Message>

    Examples:
      | Event Title   | Event Date     | Event Location     | Message                    |
      | investment     | 2024-03-15     | Conference Room 1  | Event created successfully |
      | Conference    | 2024-04-20     | Hall A             | Event created successfully |

  @scenario2
  Scenario Outline: Participants registering for events
    Given The participant is logged in
    When The participant searches for events
    And Registers for an event with title <Event Title>
    Then The participant should be registered successfully <Message>

    Examples:
      | Event Title   | Message                    |
      | Meeting 1     | Registered successfully    |
      | Conference    | Registered successfully    |

  @scenario3
  Scenario: Organizer edits an existing event
    Given The organizer is logged in
    And There exists an event titled "Meeting 1" on 2024-03-15 in Conference Room 1
    When The organizer edits the event's location to "Conference Room 2"
    Then The event details should be updated successfully

  @scenario4
  Scenario: Organizer deletes an existing event
    Given The organizer is logged in
    And There exists an event titled "Conference" on 2024-04-20 in Hall A
    When The organizer deletes the event
    Then The event should be removed successfully

  @scenario5
  Scenario: Participant registers for a full event
    Given The participant is logged in
    And There exists an event titled "Full Conference" with maximum capacity reached
    When The participant tries to register for the event
    Then The participant should receive a message indicating that the event is full

  @scenario6
  Scenario: Participant registers for a canceled event
    Given The participant is logged in
    And There exists an event titled "Canceled Event" that has been canceled
    When The participant tries to register for the event
    Then The participant should receive a message indicating that the event is canceled
