@scenario1
Scenario Outline: Organizers creating a new event with all required details
Given The organizer is logged in
When The organizer creates an event with title <Event Title>, date <Event Date>, time <Event Time>, location <Event Location>, theme <Event Theme>, description <Event Description>, and attendee count <Attendee Count>
And Clicks the create event button
Then The event should be created successfully with message <Message>

Examples:
| Event Title  | Event Date  | Event Time | Event Location    | Event Theme | Event Description        | Attendee Count | Message                   |
| Tech Meetup  | 2024-05-20  | 10:00      | Tech Hub          | Technology  | Discussing tech trends   | 50             | Event created successfully |
| Art Workshop | 2024-06-15  | 14:00      | Downtown Gallery  | Art         | Exploring modern art     | 20             | Event created successfully |


@scenario2
Scenario Outline: Organizers attempting to create an event with incomplete details
Given The organizer is logged in
When The organizer tries to create an event missing <Missing Detail>
And Clicks the create event button
Then The event creation should fail with an error message <Error Message>

Examples:
| Missing Detail | Error Message                       |
| Event Date     | "Event date is required"            |
| Event Location | "Event location is required"        |


@scenario3
Scenario: Organizer edits an existing event's details
Given The organizer is logged in
And There exists an event titled "Tech Meetup" on 2024-05-20 at Tech Hub
When The organizer edits the event's time to "11:00" and attendee count to "60"
Then The event details should be updated successfully with message "Event updated successfully"


@scenario4
Scenario: Organizer deletes an existing event
Given The organizer is logged in
And There exists an event titled "Art Workshop" on 2024-06-15 in Downtown Gallery
When The organizer deletes the event
Then The event should be removed successfully with message "Event deleted successfully"


@scenario5
Scenario Outline: Organizers creating an event with a specific theme and custom details
Given The organizer is logged in
When The organizer creates an event with title <Event Title>, theme <Event Theme>, and custom detail <Custom Detail>
And Clicks the create event button
Then The event should be created successfully with theme-specific details and message <Message>

Examples:
| Event Title    | Event Theme | Custom Detail                | Message                   |
| Fitness Camp   | Health      | Outdoor activities included  | Event created successfully |
| Science Fair   | Education   | Science projects exhibition  | Event created successfully |

