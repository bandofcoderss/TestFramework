Feature: BriteERP Login Functionality

  @smoke @regression
  Scenario: Login with valid credentials - employee
    Given Employee on Login Page of the application
    When Employee logs in with valid credentials
    Then Employee navigates to Inbox page of the application

  @regression
  Scenario: Login with valid credentials - manager
    Given Manager on Login Page of the application
    When Manager logs in with valid credentials
    Then Manager navigates to Inbox page of the application