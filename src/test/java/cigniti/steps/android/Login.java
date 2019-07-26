package cigniti.steps.android;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.ScreenshotException;
import org.testng.Assert;

import cigniti.screens.android.HomePage;
import cigniti.screens.android.LoginPage;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.AfterStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Login {
	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();

	@Given("^user is already on Login Screen$")
	public void user_already_on_login_page() {
		Assert.assertTrue(loginPage.getLoginScreen().isDisplayed());
	}

	// Reg Exp:
	// 1. \"([^\"]*)\"
	// 2. \"(.*)\"

	@Then("^user enters \"(.*)\" and \"(.*)\"$")
	public void user_enters_username_and_password(String username, String password) {
		loginPage.getTxtUsername().sendKeys(username);
		loginPage.getTxtPassword().sendKeys(password);
	}

	@And("^user clicks on login button$")
	public void user_clicks_on_login_button() {
		loginPage.getBtnLogin().click();
	}

	@Then("^user is on payment home page$")
	public void user_is_on_hopme_page() {
		Assert.assertTrue(homePage.getBtnLogout().isDisplayed());
	}

	@And("^user clicks on logout button$")
	public void user_confirms_the_balance() {
		homePage.getBtnLogout().click();
	}

	@AfterStep
	public void afterStep(Scenario scenario) {
		try {
			final byte[] screenshot = ((TakesScreenshot) loginPage.getDriver()).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png");
		} catch (ScreenshotException se) {
			se.getMessage();
		}
	}
}
