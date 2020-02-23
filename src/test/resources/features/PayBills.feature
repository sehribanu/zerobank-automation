@all
Feature: Pay Bills

  Background:
    Given the user navigates to login page
    And the user gives valid credentials to login
    And the user navigates to Pay Bills Page

  Scenario: the user completes a succesfull pay operation
    When the user selects "Sprint" as payee
    And the user selects "Savings" as account
    And the user types down "100" as amount
    And the user select "2020-01-22" as date
    And the user writes down "payment" as description
    And the user clicks the Pay button
    Then the user gets "The payment was successfully submitted." message
  @failed
  Scenario: amount field should not accept alphabetical characters
    When the user selects "Apple" as payee
    And the user selects "Loan" as account
    When the user types down "10a" as amount
    And the user select "2020-01-22" as date
    And the user writes down "payment" as description
    And the user clicks the Pay button
    Then the user should not get "The payment was successfully submitted." message
  @failed
  Scenario: amount field should not accept special characters
    When the user selects "Wells Fargo" as payee
    And the user selects "Credit Card" as account
    When the user types down "10*" as amount
    And the user select "2020-01-22" as date
    And the user writes down "payment" as description
    And the user clicks the Pay button
    Then the user should not get "The payment was successfully submitted." message

  Scenario: date field should not accept alphabetical characters
    When the user selects "Bank of America" as payee
    And the user selects "Checking" as account
    When the user types down "10*" as amount
    And the user writes down "payment" as description
    And the user select "a" as date
    And the user clicks the Pay button
    Then the user should get "Please fill in this field." alert