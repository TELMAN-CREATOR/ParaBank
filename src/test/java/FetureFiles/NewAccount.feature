Feature: New Account

  Background:
    Given Navigate to ParaBank
    When Enter username and password and click login button
    Then User should login successfully
    And Navigate to open new account

  Scenario: User opens a new checking account successfully
    When Select Checking as account type
    And Required initial deposit message should be displayed
    And Select an existing account to fund the new account
    And Click the Open New Account button
    Then User should see the account creation confirmation and the new account number

  Scenario: User opens a new saving account successfully
    When Select Saving as account type
    And Required initial deposit message should be displayed
    And Select an existing account to fund the new account
    And Click the Open New Account button
    Then User should see the account creation confirmation and the new account number