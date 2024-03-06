Feature: Event Planning Scheduling Tools

  @scenario1
  Scenario Outline: Create a new event task
    Given the user is on the event planning scheduling page
    When the user clicks on "Create Task"
    And fills in task details such as "<TaskTitle>", "<Deadline>", and "<AssignedTo>"
    Then the new task should be added to the scheduling tools

    Examples:
      | TaskTitle          | Deadline       | AssignedTo    |
      | Plan Venue Layout  | 2024-04-10     | Event Team    |
      | Send Invitations   | 2024-04-15     | Marketing     |
      | Arrange Catering   | 2024-04-20     | Catering Team |


  @scenario2
  Scenario Outline: Set appointment for event discussion
    Given the user is on the event planning scheduling page
    When the user schedules an appointment for "<MeetingTitle>" on "<AppointmentDate>" with "<Attendees>"
    Then the appointment should be added to the scheduling tools
    And all specified attendees should receive notification

    Examples:
      | MeetingTitle          | AppointmentDate | Attendees                       |
      | Event Kickoff Meeting | 2024-04-05      | Event Team, Marketing, Catering |