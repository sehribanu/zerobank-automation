@login
Feature: Login to the application
  Background: the user is on the login page
    Given the user navigates to login page

  Scenario: authorized users should be able to login
      When the user gives valid credentials to login
      Then Account Summary page should be displayed

  Scenario: users with wrong username and password should not be able to login
      When the user gives wrong credentials to login
      Then error message "Login and/or password are wrong." should be displayed

  Scenario:
      When the user does not give credentials to login
      Then error message "Login and/or password are wrong." should be displayed

