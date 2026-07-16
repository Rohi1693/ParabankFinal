Feature: Create Account

  Background:
    Given the Create Account service is available

  Scenario: Create account successfully
    When the customer submits a valid account creation request
    Then the account should be created successfully
    And the response should contain the new account details

    Scenario: Reject account creation for an invalid customer
      When the customer submits an account creation request with an invalid customer
      Then the request should be rejected
      And an appropriate error message should be returned

    Scenario: Reject account creation when mandatory fields are missing
      When the customer submits an incomplete account creation request
      Then the request should be rejected
      And validation errors should be returned