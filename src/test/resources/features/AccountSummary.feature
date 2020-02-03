@accsummary
Feature: Account Summary

  Background:
    Given the user navigates to login page
    And the user gives valid credentials to login

  Scenario: user should see the four account types
    When the user is in the Account Summary Page
    Then user should see following account types
      | Cash Accounts       |
      | Investment Accounts |
      | Credit Accounts     |
      | Loan Accounts       |

  Scenario: user should see the three columns
    When the user is in the Account Summary Page
    Then user should see following columns
      | Account     |
      | Credit Card |
      | Balance     |