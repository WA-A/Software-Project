Feature: Filter Service-Provider

  @secnario:
  Scenario: finding Service Provider
    Given the admin has loged in the system
    When the admin choose to search about one of the Services Providers
    And he enterd the name of the Service Provider "name"
    Then the service provider is found
    And print all the information about him


  Scenario: finding Service Provider
    Given the admin has loged in the system
    When the admin choose to search about one of the Services Providers
    And he enterd the name of the Service Provider "name"
    Then the service provider is not found
    And print "The service provide is not found"

  Scenario: finding Service Provider
    Given the admin has loged in the system
    When the admin choose to search about one of the Services Providers
    And he enterd the Email of the Service Provider "email"
    Then the service provider is found
    And print all the information about him

  Scenario: finding Service Provider
    Given the admin has loged in the system
    When the admin choose to search about one of the Services Providers
    And he enterd the Email of the Service Provider "email"
    Then the service provider is not found
    And print "The service provide is not found"
