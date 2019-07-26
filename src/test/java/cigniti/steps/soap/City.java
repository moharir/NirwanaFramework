package cigniti.steps.soap;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class City {
	private String[] properties = new String[2];

	@Given("^a car with an empty gas tank$")
	public void a_car_with_an_empty_gas_tank() {
		// Nothing to do here, it will be taken care of in the SoapUI script
	}

	@When("^you fill it with (.*) litres of fuel$")
	public void you_fill_it_with_litres_of_fuel(String addedFuel) {
		properties[0] = "addedFuel=" + addedFuel;
	}

	@Then("^the tank contains (.*) litres$")
	public void the_tank_contains_litres(String expectedFuel) {
		properties[1] = "expectedFuel=" + expectedFuel;
	}
}
