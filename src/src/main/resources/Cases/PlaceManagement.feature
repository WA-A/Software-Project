Feature: Venue Management



  Scenario: Adding a new venue by a serviceProvider
    Given I am logged in as a serviceProvider
    When I add a new venue with details "101", "Lakeside Retreat", "200", "Outdoor area, Parking, Bar", "5500", "Mountain View, CA"
    Then  Id "101" should be added to the venue list


  Scenario: Removing a venue by a serviceProvider
    Given I am logged in as a serviceProvider
    And  Id "101" is listed in the venue list
    When I request to remove the venue with Id "101"
    Then " Id "101" should be removed from the venue list



  Scenario: Updating venue details by a serviceProvider
    Given I am logged in as a serviceProvider
    And  Id "101" is listed in the venue list
    When I update the venue "101" with name "Lakeside Retreat",capacity "250", amenities "Outdoor area, Parking, Bar, Pool", pricing "6000", location "Mountain View, CA"
    Then  Id "101" should have updated details in the venue list
