Feature: ANDROID: EriBank App Login Sample

@android
Scenario Outline: Log into the EriBank application and logout

Given user is already on Login Screen
Then user enters "<username>" and "<password>"
And user clicks on login button
Then user is on payment home page
And user clicks on logout button

Examples:
	| username | password |
	| company  | company |