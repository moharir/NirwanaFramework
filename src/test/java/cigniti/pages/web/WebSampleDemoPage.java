package cigniti.pages.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cigniti.runner.WebRunner;

public class WebSampleDemoPage extends WebRunner {
	private WebElement element;

	public WebElement getMessageInputField() {
		element = getWebDriver().findElement(By.id("user-message"));
		return element;
	}

	public WebElement getBtnShowMessage() {
		element = getWebDriver().findElement(By.xpath("//button[contains(text(),'Show Message')]"));
		return element;
	}
	
	public WebElement getLblMessage() {
		element = getWebDriver().findElement(By.id("display"));
		return element;
	}

	public WebElement getFirstInuptText() {
		element = getWebDriver().findElement(By.id("sum1"));
		return element;
	}

	public WebElement getSecondInuptText() {
		element = getWebDriver().findElement(By.id("sum2"));
		return element;
	}

	public WebElement getBtnTotal() {
		element = getWebDriver().findElement(By.xpath("//button[contains(text(),'Get Total')]"));
		return element;
	}

	public WebElement getLblTotal() {
		element = getWebDriver().findElement(By.id("displayvalue"));
		return element;
	}

}
