package cigniti.runner;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import cigniti.common.utils.CignitiProperties;
import cigniti.common.utils.ReportGeneration;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/cigniti/features/ios", tags = { "@ios" }, monochrome = true, plugin = { "pretty",
		"html:target/cucumber-report/iosresult", "json:target/cucumber-report/iosresult.json",
		"rerun:target/iosrerun.txt" }, glue = { "cigniti/steps/ios" }

)
public class iOSRunner extends AbstractTestNGCucumberTests {

	static CignitiProperties properties;
	static ThreadLocal<AppiumDriverLocalService> service = new ThreadLocal<>();
	static AppiumDriver<MobileElement> appiumDriver = null;
	ReportGeneration generateReport = new ReportGeneration();

	// static ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();

	public AppiumDriver<MobileElement> getDriver() {
		return appiumDriver;
	}

	public AppiumDriverLocalService getService() {
		return service.get();
	}

	@BeforeSuite
	public void initializeiOSDriver() {
		properties = new CignitiProperties();

		String userName = properties.getProperty("userName");
		String accessKey = properties.getProperty("accessKey");

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platform", "ios");
		capabilities.setCapability("device", "iPhone 8 Plus");
		capabilities.setCapability("os_version", "11");
		capabilities.setCapability("app", "bs://385862de3dfe491f6d4e9684413b4b391da068f0");
		capabilities.setCapability("appiumVersion", "1.13.0");

		try {
			appiumDriver = new IOSDriver<MobileElement>(
					new URL("https://" + userName + ":" + accessKey + "@hub-cloud.browserstack.com/wd/hub"),
					capabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * Stop Appium Server Programmatically before each scenario
	 */
	@AfterSuite
	public void stopServer() {
		if (appiumDriver != null) {
			appiumDriver.quit();
		}
		if (service.get() != null) {
			service.get().stop();
		}

		generateReport.generateSummaryReport();
	}

}
