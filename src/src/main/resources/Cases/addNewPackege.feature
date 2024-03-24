Feature: Venue Management




  Scenario: Adding a new venue by an organizer
    Given I am logged in as an "organizer"
    When I enter the following details:
      | Id  | Name             | Capacity | Amenities                  | Pricing   |
      | 101 | Lakeside Retreat | 200      | Outdoor area, Parking, Bar | 5000/day  |
    Then "Lakeside Retreat" with Id "101" should be added to the venue list
