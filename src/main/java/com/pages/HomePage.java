package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.util.ElementUtil;

public class HomePage {

	private By dashboardText = By.xpath("//h6");
	private By mainMenuItemLinks = By.xpath("//ul[@class='oxd-main-menu']//li");
	private WebDriver driver = null;
	private ElementUtil util = new ElementUtil();

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public By getDashboardText() {
		return dashboardText;
	}

	public void setDashboardText(By dashboardText) {
		this.dashboardText = dashboardText;
	}

	public By getMainMenuItemLinks() {
		return mainMenuItemLinks;
	}

	public void setMainMenuItemLinks(By mainMenuItemLinks) {
		this.mainMenuItemLinks = mainMenuItemLinks;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public int getMenuItemCount() {
		return driver.findElements(mainMenuItemLinks).size();
	}

	public List<String> getMenuItemLabels() {

		util.waitUntilElementIsLocated(driver.findElement(getDashboardText()));
		List<String> menuItemLabels = new ArrayList<>();

		// List<WebElement> menuItems = driver.findElements(getMainMenuItemLinks());

		driver.findElements(getMainMenuItemLinks()).forEach(x -> menuItemLabels.add(x.getText()));
		;
		// for(WebElement menuItem: menuItems) {
		// menuItemLabels.add(menuItem.getText().trim());
		// }
		System.out.println("MenuItemLabels = " + menuItemLabels);
		return menuItemLabels;
	}

}
