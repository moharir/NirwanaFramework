Feature: WEB: Basic Form Validation

  Scenario: Validating the input message displayed correctly or not
    Given user is already on the Demo Form
    When user inputs the text as "Hey this is just a demo message"
    Then user clicks on the Show Message button
    And user verifies the entered message

  Scenario Outline: Validating sum of the 2 digits
    Given user is already on the Demo Form
    When user enters "<Number1>" and "<Number2>"
    Then user clicks on Show Total button
    And user confirms the total of the digits

    Examples: 
      | Number1 | Number2  |
      | 40 			| 67 |
