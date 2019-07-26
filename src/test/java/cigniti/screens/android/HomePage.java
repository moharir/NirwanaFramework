package cigniti.screens.android;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import cigniti.runner.AndroidRunner;
import io.appium.java_client.MobileElement;

public class HomePage extends AndroidRunner {

	@FindBy(id = "makePaymentButton")
	private MobileElement btnMakePayment;
	private MobileElement element;

	public MobileElement getPaymentHomeView() {
		element = getDriver().findElementById("paymentHomeView");
		return element;
	}

	public MobileElement getBtnMakePayment() {
		return btnMakePayment;
	}

	public MobileElement getBtnLogout() {
		element = getDriver().findElement(By.id("logoutButton"));
		return element;
	}

	public MobileElement getLblYourBalance() {
		element = getDriver().findElementByXPath("//android.view.View");
		return element;
	}

}
