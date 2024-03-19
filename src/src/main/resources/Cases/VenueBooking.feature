Feature: Venue Managment
  Scenario: booking an reserved venue caused by time
    Given i am user
    When i booking a venue that reserved
    And  The venue is booked at this time
    Then Booking venue failed


  Scenario: booking a reserved venue caused by unavailabilty
    Given i am user
    When i booking an reserved venue
    And venue not available
    Then Booking venue failed


  Scenario: booking a venue that number of guist is up maximum
    Given i am user
    When i booking a venue
    And venue  capasity not enough
    Then Booking venue failed

  Scenario: booking a venue with already reserved
    Given i am user
    When i booking a venue
    And Already reserved
    Then booking failed

  Scenario: booking a venue with all perfectly
    Given i am user
    When i am user and venue is perfectly available
    Then booking Succesfully Done
