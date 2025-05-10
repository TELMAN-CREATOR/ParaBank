Feature:Paying Bill
  Background:
    Given Navigate to ParaBank site
    When Enter username and password and click login button.
    Then User should login successfully.
    And Navigate to paying bill

  Scenario:
    When Enter pay information
    And Send the payment
    Then Verify sending

  Scenario:
    When Enter pay information su
    And Send the payment
    Then Verify sending

  Scenario:
    When Enter pay information doğal gaz
    And Send the payment
    Then Verify sending





