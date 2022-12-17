package com.cucumbertestngstructure;

import com.factory.DriverFactory;
import com.pages.HomePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import java.util.List;

public class HomePageStepDefinition {
	private static String title;
	HomePage homePage = new HomePage(DriverFactory.getDriver());

	@Then("dashboard page should have {int} menu items as below")
	public void dashboard_page_should_have_menu_items_as_below(int totalNumberOfMenuItems, DataTable dataTable) {
		List<String> expectedMenuItemLabels = dataTable.asList();
		List<String> actualMenuItemLabels = homePage.getMenuItemLabels();
		Assert.assertEquals(actualMenuItemLabels, expectedMenuItemLabels, "comparing menu item labels");
		Assert.assertEquals(homePage.getMenuItemCount(), totalNumberOfMenuItems);
	}
}
