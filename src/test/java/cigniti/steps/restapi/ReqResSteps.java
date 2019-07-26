package cigniti.steps.restapi;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;

import cigniti.common.utils.APISteps;
import cigniti.common.utils.RESTAssuredAPI;
import io.cucumber.java.en.When;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ReqResSteps {
	JSONObject response;
	JSONParser parser = new JSONParser();

	@When("^I verify that all users are displayed with below mandatory fields$")
	public void iVerifyUsers(List<String> mandatoryKeys) throws ParseException {
		response = (JSONObject) parser.parse(RESTAssuredAPI.globalResponse.getBody().print());
		for (String key : mandatoryKeys) {
			JSONArray data = (JSONArray) response.get("data");
			JSONObject user = (JSONObject) data.get(0);
			assertThat(user.get(key), is(notNullValue()));
		}
	}

	@When("^I register a user$")
	public void iRegisterAUser() {
		APISteps.restAssuredAPI.post(APISteps.currentMessageAsJson, APISteps.headersAsMap, APISteps.endpoint);
	}

	@When("^I verify a token is generated$")
	public void iVerifyToken() {
		try {
			response = (JSONObject) parser.parse(RESTAssuredAPI.globalResponse.getBody().print());
			assertThat(response.get("token"), is(notNullValue()));
		} catch (Exception e) {

			Assert.fail("Unable parse the JSON or the response doesn't have a token");
		}
	}
}
