@login
Feature: Login to the application
@test
  Scenario: authorized users should be able to login
      Given the user navigates to login page
      When the user gives valid credentials to login
      Then Account Summary page should be displayed

  Scenario: users with wrongUsername and wrongPassword should not be able to login
      Given the user navigates to login page
      When the user gives wrong credentials to login
      Then error message should be displayed

  Scenario:
      Given the user navigates to login page
      When the user does not give credentials to login
      Then error message should be displayed

