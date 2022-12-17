package com.cucumbertestngstructure;

import org.testng.annotations.DataProvider;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;


@CucumberOptions(
		features = { "src/test/resources/com/features" },
		glue = {
				"com/cucumbertestngstructure",
//				"src/test/java/com/stepdefinitions", 
				"com/hooks"}, 
		plugin = {
		"pretty", // To print console output in a nice format
		"json:target/reports/report.json", "junit:target/reports/report.xml" ,
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"timeline:test-output-thread/"
		},
//		strict = true,
		publish = true,
		dryRun = false
		)
public class TestNGTestRunner extends AbstractTestNGCucumberTests  {

	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}
}
