Feature: Update contact information

  As a customer,
  I want to update my contact information
  So that my address, phone number, and other details are always correct and I can communicate with the bank without problems.

  Background:
    Given The user is logged in and on the Update Profile page

  @Positive
  Scenario: Successfully update contact information
    When The user fills in valid contact details
      | First Name   | Gorkem           |
      | Last Name    | Kezer          |
      | Address      | 123 Atasehir  |
      | City         | Istanbul       |
      | State        | Marmara        |
      | Zip Code     | 34000          |
      | Phone Number | 05554443322    |
    And Clicks the "Update Profile" button
    Then A success message should be displayed
    And The user logs out and logs back in
    Then The updated contact information should be visible and correct

  @Negative
  Scenario: Attempt to update with missing required fields
    When The user clears the following fields
      | Address      |
      | City         |
      | Phone Number |
    And Clicks the "Update Profile" button
    Then Validation error messages should be displayed for the empty fields
    And No changes should be saved on the profile