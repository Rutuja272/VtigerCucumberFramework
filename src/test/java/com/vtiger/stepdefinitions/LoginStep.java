package com.vtiger.stepdefinitions;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentTest;
import com.pageobject.LoginPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginStep extends BaseTest{
	
	@Before
	public void getScenario(Scenario scenario) throws IOException {
		initation();
		TCName=scenario.getName();
		logger=extent.createTest(TCName);
	}
	
	@After
	public void tireDown() {
		extent.flush();
	}
	
	@Then("close browser")
	public void close_browser() {
		closeApp();

	}
	@Given("user should be on login page")
	public void user_should_be_on_login_page() throws IOException {
		lunchApp();
	}

	@When("user enter valid crednatial and click on login button")
	public void user_enter_valid_crednatial_and_click_on_login_button() {
		getLoginPage().login(dt.get(TCName).get("Userid"),dt.get(TCName).get("Password"));
				
	}

	@Then("user should be navigate to home page and validate the logout")
	public void user_should_be_navigate_to_home_page_and_validate_the_logout() {
		getLoginPage().logout();
	}

	@When("user enter invalid crednatial and click on login button")
	public void user_enter_invalid_crednatial_and_click_on_login_button() {
		getLoginPage().setUserName(dt.get(TCName).get("Userid"));
		getLoginPage().setPassword(dt.get(TCName).get("Password"));
		getLoginPage().clickLogin();
	}
	@Then("user should be navigate to login page and validate the error msg")
	public void user_should_be_navigate_to_login_page_and_validate_the_error_message_as() {
		getLoginPage().errorMsgVerification();
	}

	@Then("verify the logo")
	public void verify_the_logo() {
		getLoginPage().verifyLogo();
	}
	
	@Then("verify the title")
	public void verify_the_title() {
		getLoginPage().verifyTitle(dt.get(TCName).get("ExpTitle"));
	}
	
	@When("user enter valid userid as {string} and password as {string} and click on login button")
	public void user_enter_valid_userid_as_and_password_as_and_click_on_login_button(String string, String string2) {
		getLoginPage().setUserName(string);
		getLoginPage().setPassword(string2);
		getLoginPage().clickLogin();
	}
	
	@When("user enter valid crednatial and select the theme and click on login button")
	public void user_enter_valid_crednatial_and_select_the_theme_as_and_click_on_login_button() {
	
		getLoginPage().login(dt.get(TCName).get("Userid"), dt.get(TCName).get("Password"), dt.get(TCName).get("theme"));
	}
	
	@When("user enter valid userid as {string} and password as {string} and theme as {string} and click on login button")
	public void user_enter_valid_userid_as_and_password_as_and_theme_as_and_click_on_login_button(String string, String string2, String string3) {
	
		getLoginPage().login(string,string2, string3);
	}
	
	
}



