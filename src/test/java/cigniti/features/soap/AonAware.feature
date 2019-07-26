@aon
Feature: SOAP: Example using AonAware
  #  NOTE : YOU CAN RIGHT CLICK and RUN THE SCENARIOS DIRECTLY (if your IDE supports)
  #  This feature is based on a sample web API found in google. It is observed that if we hit
  #  if it is more often hit then they will return a message as "Object Moved" and you will see failures
  #  This DictService API takes any word as input in envelope and returns definition from the dictionary (same word) as response

  @smoke
  Scenario: AON 1.0 - AON test for status check
    Given I have my end point as "http://services.aonaware.com/DictService/DictService.asmx"
    And I have the request headers defined as follows
      | SOAPAction | Define |
      | Content-Type | application/soap+xml; charset=UTF-8; |
    And I have the soap envelope defined in "src/test/resources/soapinputfiles/leg.xml"
    When I post the request body as XML
    And I verify the response status code as "200"

  #  This is an example of Scenario Outline, means repeating the same scenario with varying data
  #  We are repeating the below scenario with varying PATH and WORD
  @regression
  Scenario Outline: AON 1.1 - AON test for response comparision
    Given I have my "AON" API ready
    And I have the request headers defined as follows
      | SOAPAction   | Define                               |
      | Content-Type | application/soap+xml; charset=UTF-8; |
    And I have the soap envelope defined in "<path>"
    When I post the request body as XML
    And I verify the AON response contains the word "<word>"

    Examples:
      | path | word |
      | src/test/resources/soapinputfiles/hand.xml  | hand |
      | src/test/resources/soapinputfiles/leg.xml   | leg  |