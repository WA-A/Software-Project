Feature: Service Provider Management

  Scenario: Add a new package
    Given the service provider is logged in
    When a service provider adds a new package with ID "123", price "200", capacity "100", location "Nablus", place name "Sunny Beach Resort", servisec "wifi", and service provider name "abdullah"
    Then the new package added to the system
    And display a confirmation message "package added successfully"

  Scenario: Remove an existing package
    Given the service provider is logged in
    And a package with ID "123" exists
    When the service provider requests to remove the package with ID "123"
    Then the system should remove the package
    And display a confirmation message "The Packege is removed"

  Scenario: Attempt to remove a non-existing package
    Given the service provider is logged in
    When the service provider requests to remove a package with ID "999" that does not exist
    Then the system should not remove any package
    And display a message "package not found"

  Scenario: Update an existing package's price
    Given the service provider is logged in
    And a package with ID "123" exists
    When the service provider selects to update the package with ID "123"
    And enters "1" for the option to update the price
    And inputs the new price "250"
    Then the system should update the package's price to "250"
    And display a confirmation message "Package updated successfully."

  Scenario: Attempt to update a non-existing package
    Given the service provider is logged in
    When the service provider attempts to update a package with ID "999" that does not exist
    Then the system should display a message "Package not found."

  Scenario: View service provider's packages
    Given the service provider is logged in
    And service provider "abdullah" has added packages
    When "abdullah" views their packages
    Then the system should display all packages added by "abdullah"

  Scenario: View service provider's tasks
    Given the service provider is logged in
    And service provider "abdullah" has tasks assigned
    When "abdullah" views their tasks
    Then the system should display all tasks assigned to "abdullah"

  Scenario: View service provider's messages
    Given the service provider is logged in
    And service provider "abdullah" has messages
    When "abdullah" views their messages
    Then the system should display all messages for "abdullah"


