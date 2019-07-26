package cigniti.screens.android;

import cigniti.runner.AndroidRunner;
import io.appium.java_client.MobileElement;

public class LoginPage extends AndroidRunner {

	private MobileElement element;

	public MobileElement getLoginScreen() {
		element = getDriver().findElementById("loginView");
		return element;
	}

	public MobileElement getTxtUsername() {
		element = getDriver().findElementById("usernameTextField");
		return element;
	}

	public MobileElement getTxtPassword() {
		element = getDriver().findElementById("passwordTextField");
		return element;
	}

	public MobileElement getBtnLogin() {
		element = getDriver().findElementById("loginButton");
		return element;
	}

}
