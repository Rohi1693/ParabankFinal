@ui
Feature: User Login

  Background:
    Given the ParaBank application is available

  Scenario: Login with valid credentials
    When the customer signs in with valid credentials
    Then the customer should be successfully authenticated
    And the customer should be taken to the account overview page