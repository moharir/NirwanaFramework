@weather
Feature: REST: Example using http://restapi.demoqa.com for weather information
  #  This demonstrates how you drive your test data within the scenarios as
  #  inline strings and numbers
  #  multiple records of key-value pairs
  #  Note that this scenario may fail as the wind direction comparision fails if the value is different
  #  If it fails, it gives you an idean on how the failures are handled and reported by Serenity
  @smoke
  Scenario: REST Weather 1.0 - Get the weather condition of a city and verify te City name
    Given I have my "Weather" API ready
    And I have the request headers defined as follows
      | Content-Type | application/json |
      | Authorisation | Jai_Bahubali Jai Chandra |
    And I have the URL parameter as "Chester"
    When I send a GET request
    Then I verify the response status code as "200"
    And I verify the response for chester weather
      | City                | Chester     |
      
