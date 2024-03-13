Feature:   Venue Booking

  Scenario: Checking Workshop Venue Availability
    Given the workshop user wants to schedule a new workshop
    When the user navigates to the venue selection step
    Then display a list of available venues suitable for workshops on the specified date and time


  Scenario: Reserving a Venue for a Workshop
    Given the workshop user has selected a location from the available options
    When the user confirms the venue selection
    Then the system should reserve the chosen location for the workshop
    And update the workshop details with the reserved venue information

  Scenario Outline: Displaying Workshop Venue Details
    Given the workshop user is viewing the details of a specific workshop
    When the organizer reviews the workshop details
    Then the venue information, including <capacity>, <amenities>, and <pricing>, should be displayed
    Examples:
      | Capacity | Amenities                        | Pricing    |
      | 100      | Audio-Visual Equipment, Wi-Fi    | $1000/day  |
      | 50       | Projector, Whiteboard, Seating   | $500/day   |
      | 200      | Catering, Stage, Lighting        | $1500/day  |


  Scenario: Handling Unavailable Venues for Workshops
    Given the workshop user is selecting a venue for a workshop
    When the venue booking system indicates unavailability
    Then the system should notify the user about the unavailability
    And prompt the organizer to choose an alternative venue or adjust the workshop details

  Scenario: Managing Workshop Venue Information
    Given the system has integrated with a venue booking system
    When new workshop-specific venues are added or existing venues are updated
    Then the system should synchronize the venue information to ensure accuracy for workshops

  Scenario: Cancelling Workshop Venue Reservation
    Given the workshop user has already reserved a place for a workshop
    When the organizer decides to cancel the reservation
    Then the system should release the venue reservation
    And update the workshop details accordingly


