package cigniti.steps.restapi;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import cigniti.common.utils.RESTAssuredAPI;
import io.cucumber.java.en.When;

import java.util.Map;
import java.util.Set;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class WeatherSteps {

	JSONObject response;
	JSONParser parser = new JSONParser();

	@When("^I verify the response for chester weather$")
	public void iVerifyResponseForWeatherInformation(Map<String, String> keyValuePairs) throws ParseException {
		Set<String> keys = keyValuePairs.keySet();
		response = (JSONObject) parser.parse(RESTAssuredAPI.globalResponse.getBody().print());
		for (String key : keys) {
			assertThat(response.get(key).toString(), hasToString(keyValuePairs.get(key)));
		}
	}
}
