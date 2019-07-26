@reqres
Feature: REST: Example using https://reqres.in/
  #  This demonstrates how you drive your test data within the scenarios as
  #  inline strings and numbers
  #  list of data items / single column data
  #  Single record of key-value pairs
  @smoke
  Scenario: ReqRes 1.0 - Get all the users
    Given I have my "ReqRes" API with path "LIST_USERS" ready
    And I have the request headers defined as follows
      | Content-Type | application/json |
    When I send a GET request
    Then I verify the response status code as "200"
    And I verify that all users are displayed with below mandatory fields
      | id         |
      | first_name |
      | last_name  |
      | avatar     |

  #  This demonstrates how you drive your test data within the scenarios as
  #  inline strings and numbers
  #  A json file referenced with path
  #  Single record of key-value pairs
  @regression
  Scenario: ReqRes 1.1 - Register a user
    Given I have my "ReqRes" API with path "REGISTER" ready
    And I have the request headers defined as follows
      | Content-Type | application/json |
    And I have the request body defined in "src/test/resources/commoninputfiles/user.json"
    When I register a user
    Then I verify the response status code as "201"
    And I verify a token is generated