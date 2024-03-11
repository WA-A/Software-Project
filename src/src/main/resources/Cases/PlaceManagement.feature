Feature: Venue/Place Management

  Scenario: Adding a New Venue
    Given the organizer wants to add a new venue
    When the organizer navigates to the venue management section
    And selects the option to add a new venue
    Then the system should prompt the organizer to enter details
    And the details should include capacity, amenities, pricing

  Scenario: Viewing Venue Details
    Given the organizer is reviewing details of a specific venue
    When the organizer views the venue information
    Then the system should display the venue details Including capacity, amenities, pricing

  Scenario: Editing Venue Details
    Given the organizer wants to edit the details of a venue
    When the organizer navigates to the venue management section
    And selects the option to edit a specific venue
    Then the system should allow the organizer to modify venue details Including capacity, amenities, pricing


  Scenario: Integrating Venue with Booking System
    Given the system has integrated with venue booking systems
    When the organizer checks venue availability
    Then the system should seamlessly connect to the booking system
    And provide real-time information on venue availability and reservation status

  Scenario: Deleting a Venue
    Given the organizer wants to remove a venue from the system
    When the organizer selects the option to delete a specific venue
    Then the system should prompt the organizer for confirmation
  And upon confirmation, remove the venue from the system
