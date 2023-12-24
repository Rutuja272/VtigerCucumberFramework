package com.vtiger.stepdefinitions;

import org.openqa.selenium.WebDriver;

import com.pageobject.HomePage;
import com.pageobject.LeadPage;
import com.pageobject.LoginPage;

public class PageObjectManager {

	public static WebDriver driver;

	public LoginPage loginPage;
	public LeadPage leadPage;
	public HomePage homePage;

	public LoginPage getLoginPage() {
		if (loginPage == null) {
			return loginPage = new LoginPage(driver);
		} else {
			return loginPage;
		}
	}
	
	public LeadPage getLeadPage() {
		if (leadPage == null) {
			return leadPage = new LeadPage(driver);
		} else {
			return leadPage;
		}
	}
	
	public HomePage getHomePage() {
		if (homePage == null) {
			return homePage = new HomePage(driver);
		} else {
			return homePage;
		}
	}
}
