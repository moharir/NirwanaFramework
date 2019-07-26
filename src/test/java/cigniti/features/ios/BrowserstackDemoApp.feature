Feature: iOS: Browserstack demo application

  @ios
  Scenario: Verify the alert message
    Given user is already on Home Screen
    When user clicks on "Alert" button
    Then user verifies alert message
    And user dismiss the alert

  @ios
  Scenario: Verify the input text
    Given user is already on Home Screen
    When user clicks on "Text" button
    Then user verifies input label
    And user enters text as "This is automation sample test"
