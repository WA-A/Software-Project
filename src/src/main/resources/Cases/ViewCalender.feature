Feature: Calendar View for Meetings


  @scenario1
  Scenario: Display upcoming events and important dates
    Given the user is on the calendar page
    When the page loads
    Then the calendar should display a clear and organized view

  @scenario2
  Scenario Outline: View upcoming meetings
    Given the user is on the calendar page
    When the user looks at the calendar view
    Then upcoming meetings should be prominently displayed <MeetingTitle>,<Date>,<Time>
    And each meeting entry should include the meeting title, date, and time

    Examples:
      | MeetingTitle     | Date        | Time    |
      | Team Metting     | 2024-03-15  | 10:00AM |
      | Project Metting  | 2024-03-20  | 02:30PM |
      | Client Meeting   | 2024-03-25  | 11:00AM |


  @scenario3
  Scenario Outline: Highlight important dates
    Given the user is on the calendar page
    When there are important dates marked
    Then those dates should be visually distinct from regular events <ImportantDate> ,<AdditionalInfo>
    And hovering over an important date should display additional information

    Examples:
      | ImportantDate    | AdditionalInfo         |
      | 2024-03-22       | Team Building Event    |
