Feature: Venue Management

  Scenario: Adding a new venue by a serviceProvider
    Given I am logged in as a "serviceProvider"
    When I enter the following details:
      | Id  | Name             | Capacity | Amenities                  | Pricing | Location         |
      | 101 | Lakeside Retreat | 200      | Outdoor area, Parking, Bar | 5500    | Mountain View, CA |
    Then "Lakeside Retreat" with Id "101" should be added to the venue list

  Scenario: Removing a venue by a serviceProvider
    Given I am logged in as a "serviceProvider"
    And "Lakeside Retreat" with Id "101" is listed in the venue list
    When I request to remove the venue with Id "101"
    Then "Lakeside Retreat" with Id "101" should be removed from the venue list


  Scenario: Updating venue details by a serviceProvider
    Given I am logged in as a "serviceProvider"
    And "Lakeside Retreat" with Id "101" is listed in the venue list
    When I update the details for venue with Id "101" as follows:
      | Capacity | Amenities | Pricing | Location |
      | 250 | Outdoor area, Parking, Bar, Pool | 6000 | Mountain View, CA |
    Then "Lakeside Retreat" with Id "101" should have updated details in the venue list