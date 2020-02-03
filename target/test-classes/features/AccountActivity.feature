@accactivity
Feature: Account Activity

  Background:
    Given the user navigates to login page
    And the user gives valid credentials to login
    And the user navigates to Account Activity Page

  Scenario: user should see dropdown options
    When the user is in the Account Activity Page
    Then user should see following dropdown options
      | Savings     |
      | Checking    |
      | Loan        |
      | Credit Card |
      | Brokerage   |

  Scenario: transactions table should have column names
    When the user is in the Account Activity Page
    Then user should see following column names in transactions
      | Date        |
      | Description |
      | Deposit     |
      | Withdrawal  |

  Scenario: dropdown default option should be Savings
    When the user is in the Account Activity Page
    Then the dropdown default option should be "Savings"