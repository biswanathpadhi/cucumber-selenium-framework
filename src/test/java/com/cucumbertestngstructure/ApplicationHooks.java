package com.cucumbertestngstructure;

import com.factory.DriverFactory;
import com.util.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class ApplicationHooks {

	private DriverFactory driverFactory = new DriverFactory();
	private WebDriver driver;
	private ConfigReader configReader;
	private Properties properties;

	@Before(order = 0)
	public void setProperty() {
		this.configReader = new ConfigReader();
		this.configReader.init_prop();
		this.properties = this.configReader.getProperties();
	}

	@Before(order = 1)
	public void setUp() {
		this.driverFactory = new DriverFactory();
		String browserName = this.properties.getProperty("browser");
		this.driver = driverFactory.initializeDriver(browserName);
	}

	@After (order = 0)
	public void quitBrowser() {
		if (this.driver != null) {
			driver.quit();
		}
	}
	
	@After (order = 1)
	public void tearDown(Scenario scenario) {
		if(scenario.isFailed()) {
			byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			scenario.attach(sourcePath, "image/png", screenshotName);
		} else {
			byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			scenario.attach(sourcePath, "image/png", screenshotName);
		}
	}
}
