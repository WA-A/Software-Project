Feature: Event Management

  @scenario1
  Scenario Outline: Organizers managing events and participants registering for events
    Given The organizer is logged in
    When The organizer creates an event with title <Event Title>, date <Event Date>, and location <Event Location>
    And Clicks the create event button
    Then The event should be created successfully <Message>

    Examples:
      | Event Title   | Event Date     | Event Location     | Message                    |
      | Meeting 1     | 2024-03-15     | Conference Room 1  | Event created successfully |
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
