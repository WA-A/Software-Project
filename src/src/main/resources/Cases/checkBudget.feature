Feature: checking budget
  @Scenario:
  Scenario: finding a packege with the same budget
  Given the user is loged in the system
    And he enterd the value of the budget that he can pay "budget"
    Then the system show all the packeges with the same "budget"

  Scenario:  not finding a packege with the same budget
    Given the user is loged in the system
    And he enterd the value of the budget that he can pay "budget"
    Then no packeges has a same budget "budget"


