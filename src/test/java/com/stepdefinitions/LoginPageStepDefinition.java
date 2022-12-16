package com.stepdefinitions;

import org.junit.Assert;

import com.factory.DriverFactory;
import com.pages.LoginPage;
import com.util.ConfigReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageStepDefinition {
	private static String title;
	LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

	@Given("user is on login page")
	public void user_is_on_login_page() {
		String url = new ConfigReader().init_prop().getProperty("baseUrl");
		DriverFactory.getDriver().get(url);
		loginPage.waitUntilPageLoads();
	}

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {
		loginPage.waitUntilPageLoads();
		title = loginPage.getLoginPageTitle();
		System.out.println();

	}

	@Then("the page title should be {string}")
	public void the_page_title_should_be(String expectedTitle) {
		Assert.assertTrue(expectedTitle.equalsIgnoreCase(title));
	}

	@Then("forgot your password link should be displayed")
	public void forgot_your_password_link_should_be_displayed() {
		Assert.assertTrue(loginPage.isForgotPassworkLinkDisplayed());
	}

	@When("user enters username as {string} as password as {string}")
	public void user_enters_username_as_as_password_as(String username, String password) {
		loginPage.enterCredentials(username, password);
	}

	@When("clicks on login button")
	public void clicks_on_login_button() {
		loginPage.clickOnLoginButton();
	}

	@Then("dashboard page should be displayed")
	public void dashboard_page_should_be_displayed() {
		// Write code here that turns the phrase above into concrete actions
		
	}
}
