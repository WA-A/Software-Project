Feature: Calendar View

  @scenario1
  Scenario Outline: User views upcoming events and important dates
    Given the user is on the calendar view
    When the user navigates to the upcoming events and important dates section
    Then the user should see a list of upcoming events and important dates
      | Event Title      | <EventTitle> |
      | Date Time        | <DateTime>   |
      | Type             | <Type>       |
    And each entry should display relevant details

    Examples:
      | EventTitle         | DateTime               | Type          |
      | Team Meeting       | 2024-03-10 14:00       | Meeting       |
      | Project Meeting    | 2024-03-12 10:00       | Event         |

