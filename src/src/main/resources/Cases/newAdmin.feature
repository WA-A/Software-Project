Feature: Admin Management of Service Providers and Information Display

  Scenario: Add a new service provider
    Given the admin is logged in
    When the admin adds the service provider with username "ahmad", password "123", phone number "05123123", and email "ahmad@example.com"
    Then the service provider with username "serviceUser" should be added to the system

  Scenario: Delete a service provider
    Given the admin is logged in
    When the admin deletes the service provider with username "ahmad" and phone number "05123123"
    Then the service provider with username "ahmad" should be removed from the system

  Scenario: Print all service providers
    Given the admin is logged in
    When the admin requests to print all service providers
    Then the system should display all service providers with their username, phone number, and email

  Scenario: Print all users
    Given the admin is logged in
    When the admin requests to print all users
    Then the system should display all users with their username, phone number, and email

  Scenario: Print all events
    Given the admin is logged in
    When the admin requests to print all events
    Then the system should display all events with their title, location, date, start and end times, number of invitees, user name, package id, and service provider name
