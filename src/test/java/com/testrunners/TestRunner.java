package com.testrunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = { "src/test/resources/com/features" },
		glue = {
				"com/stepdefinitions",
//				"src/test/java/com/stepdefinitions", 
				"com/hooks"}, 
		plugin = {
		"pretty", // To print console output in a nice format
		"json:target/reports/report.json", "junit:target/reports/report.xml" ,
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"timeline:test-output-thread/"
		},
//		strict = true,
//		publish = true,
		dryRun = false
		)
public class TestRunner {
}
