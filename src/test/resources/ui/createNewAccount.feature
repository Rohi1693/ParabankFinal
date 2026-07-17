@ui2
Feature: Open New Account

  Background:
    Given the customer is authenticated into Parabank application




  Scenario: Customer opens a new checking account successfully
    When the customer requests a new checking account using an existing account
    Then the new account should be created successfully
    And the customer should be provided with the new account number

  Scenario: Customer opens a new savings account successfully
    When the customer requests a new savings account using an existing account
    Then the new account should be created successfully
    And the customer should be provided with the new account number
    And Verify the account number in Account overview section