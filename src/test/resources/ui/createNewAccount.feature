Feature: Open New Account

  Background:
    Given the customer is logged into ParaBank

  Scenario Outline: Open a new account
    When the customer opens a new "<accountType>" account using existing account "<accountNumber>"
    Then the account should be opened successfully
    And the new account should appear in the account overview

    Examples:
      | accountType | accountNumber |
      | SAVINGS     | 12345         |

  Scenario: View account details
    Given the customer has an active newly created account
    When the customer accesses the account overview
    Then the newly created account should be visible with its account number