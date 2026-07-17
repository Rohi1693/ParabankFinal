@api
Feature: Login Security Validation

  Background:
    Given the Login service is available

  Scenario: Login with valid credentials
    When the client logs in with valid credentials
    Then the login should be successful
    And the customer details should be returned

  Scenario: Login with invalid username
    When the client logs in with an invalid username
    Then the login should be rejected with invalid username
    And an appropriate authentication error should be returned

  Scenario: Login with invalid password
    When the client logs in with an invalid password
    Then the login should be rejected with invalid password
    And an appropriate authentication error should be returned
