Feature: Expense Tracking for Special Events

  @scenario1
  Scenario Outline: Track Various Event Expenses
    Given I have access to the expense tracking system
    When I add a new expense with the following details:
    * Description: "<Description>"
    * Category: "<Category>"
    * Amount: "<Amount>"
    * Payee (optional): "<Payee>"
    Then the expense should be saved successfully
    And I should be able to see the expense details in the "<Category>" category

    Examples:
      | Description                   | Category        | Amount | Payee       |
      | Rental costs for ABC Company  | Rental costs    | $1500  | ABC Company |
      | Food costs for DEF Company    | Food costs      | $2000  | DEF Company |
      | Service costs for DEF Company | Service costs   | $3000  | DEF Company |



