Feature: Depositing money in to a User account

  @UserAccounts
  Scenario: Depositing money in to User's account should add money to the User's current
    Given a User has no money in their account
    When 100euro is deposited in to the account
    Then the balance should be 100euro