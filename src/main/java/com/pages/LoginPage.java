package com.pages;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	private WebDriver driver;

	// 1. By locators
	private By usernameInput = By.cssSelector("input[name='username']");
	private By passwordInput = By.cssSelector("input[name='password']");
	private By loginButton = By.cssSelector("button[type=submit]");
	private By forgotPasswordLink = By.cssSelector("div[class=orangehrm-login-forgot]");

	// 2. Constructors
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// 3. page Actions: features of the page the form of methods:
	public String getLoginPageTitle() {
		return driver.getTitle();
	}

	public By getPasswordInput() {
		return passwordInput;
	}

	public By getLoginButton() {
		return loginButton;
	}

	public By getUsernameInput() {
		return usernameInput;
	}

	public void enterUsername(String username) {
		this.driver.findElement(getUsernameInput()).sendKeys(username);
	}

	public void enterPassword(String password) {
		this.driver.findElement(getPasswordInput()).sendKeys(password);
	}

	public void enterCredentials(String username, String password) {
		this.enterUsername(username);
		this.enterPassword(password);
	}

	public void clickOnLoginButton() {
		driver.findElement(getLoginButton()).click();
	}

	public boolean isForgotPassworkLinkDisplayed() {
		return driver.findElement(getForgotPasswordLink()).isDisplayed();
	}

	public By getForgotPasswordLink() {
		return forgotPasswordLink;
	}

	public void waitUntilPageLoads() {
		int count = 0;
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		if ((Boolean) executor.executeScript("return document.readyState").equals("complete")) {
			while (!(Boolean) executor.executeScript("return document.readyState").equals("complete")) {
				try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (count > 4)
					break;
				count++;
			}
		}

		// Declare and initialise a fluent wait
		FluentWait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));
		System.out.println("wait is over");
	}
}
