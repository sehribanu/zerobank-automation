@all
Feature: Purchase Foreign Currency
  Background:
    Given the user navigates to login page
    And the user gives valid credentials to login
    And the user navigates to Pay Bills Page

  Scenario: Available currencies
    Given the user accesses the Purchase foreign currency cash tab
    Then following currencies should be available
        |Australia (dollar) |
        |Canada (dollar) |
        |Switzerland (franc) |
        |China (yuan) |
        |Denmark (krone) |
        |Eurozone (euro) |
        |Great Britain (pound)|
        |Japan (yen) |
        |Mexico (peso) |
        |Norway (krone) |
        |New Zealand (dollar) |
        |Singapore (dollar) |

  Scenario: Error message for not selecting currency
    Given the user accesses the Purchase foreign currency cash tab
    When user tries to calculate cost without selecting a currency
    Then error message "Please, ensure that you have filled all the required fields with valid values." should be displayed

  Scenario: Error message for not entering value
    Given the user accesses the Purchase foreign currency cash tab
    When user tries to calculate cost without entering a value
    Then error message "Please, ensure that you have filled all the required fields with valid values." should be displayed