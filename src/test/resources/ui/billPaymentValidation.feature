@ui
Feature: Bill Payment Processing

  Background:
    Given the customer is authenticated into application

  Scenario: Successful bill payment to a payee
    Given the customer land on a bill payment page
    When the customer submits a bill payment with all required payment details
    Then the bill payment should be processed successfully
    And the payment should be associated with the selected payee

  Scenario: Payment request without complete payee contact information
    Given the customer land on a bill payment page
    And the payee contact information is incomplete
    When the customer submits the payment request
    Then the payment should not be processed