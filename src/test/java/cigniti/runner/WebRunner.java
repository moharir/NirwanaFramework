package cigniti.runner;


import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;


import cigniti.common.utils.CignitiProperties;
import cigniti.common.utils.ReportGeneration;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

@CucumberOptions(features = "src/test/java/cigniti/features/web", tags = {
		"not @Ignore" }, monochrome = true, plugin = { "pretty", "html:target/cucumber-report/webresult",
				"json:target/cucumber-report/webresult.json",
				"rerun:target/webrerun.txt" }, glue = { "cigniti/steps/web" }

)
public class WebRunner extends AbstractTestNGCucumberTests {

	static CignitiProperties properties;
	static WebDriver webDriver = null;
	DesiredCapabilities capabilities;
	ReportGeneration generateReport = new ReportGeneration();

	public WebDriver getWebDriver() {
		return webDriver;
	}

	@BeforeSuite
	public void connectToSauceLab() {
		properties = new CignitiProperties();

		String userName = properties.getProperty("userName");
		String accessKey = properties.getProperty("accessKey");
		String browserName = properties.getProperty("browserName");
		String webPlatform = properties.getProperty("webPlatform");
		String runOn = properties.getProperty("webRunAs");

		capabilities = new DesiredCapabilities();
		capabilities.setBrowserName(browserName);
		capabilities.setCapability("platform", webPlatform);

		if (runOn.trim().equalsIgnoreCase("Local")) {
			WebDriverManager.chromedriver().setup();
			webDriver = new ChromeDriver();
			webDriver.manage().window().maximize();
		} else {
			try {
				webDriver = new RemoteWebDriver(
						new URL("https://" + userName + ":" + accessKey + "@hub-cloud.browserstack.com/wd/hub"),
						capabilities);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * Quit the webdriver
	 */
	@AfterSuite
	public void stopServer() {
		if (webDriver != null) {
			webDriver.quit();
		}
		generateReport.generateSummaryReport();
	}

	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}
}
