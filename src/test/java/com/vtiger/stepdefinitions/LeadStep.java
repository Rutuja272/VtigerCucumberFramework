package com.vtiger.stepdefinitions;

import java.io.IOException;

import com.pageobject.LeadPage;
import com.pageobject.LoginPage;

import io.cucumber.java.en.*;

public class LeadStep extends BaseTest {
	@Given("user should be on home page")
	public void user_should_be_on_home_page() throws IOException {
		lunchApp();
		//getLoginPage().login("admin", "admin");
		getLoginPage().login(dt.get(TCName).get("Userid"),dt.get(TCName).get("Password"));
	}

	@When("user click on leads then click on new lead")
	public void user_click_on_leads_then_click_on_new_lead() {

		getLeadPage().clickLead();
		getLeadPage().clickNewLead();

	}

	@Then("user should be land on new lead page")
	public void user_should_be_land_on_new_lead_page() {
		getLeadPage().isDisplayLeadPage();
	}

	@Then("user enter title and fisrt name and last name and company name")
	public void user_enter_title_as_fisrt_name_as_and_last_name_as_and_company_name_as() {
		getLeadPage().createNewLead(dt.get(TCName).get("title"), dt.get(TCName).get("firstname"), dt.get(TCName).get("lastname"),dt.get(TCName).get("company"));
	}

	@Then("user click on save button")
	public void user_click_on_save_button() {
		getLeadPage().lowerSaveBtn();
	}

	@Then("lead should be created successfully")
	public void lead_should_be_created_successfully() {
		getLeadPage().isLeadCreate();
	}

}
