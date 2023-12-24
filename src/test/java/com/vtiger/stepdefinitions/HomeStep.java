package com.vtiger.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomeStep extends BaseTest {

	@When("user scrolldown to footer section")
	public void user_scrolldown_to_footer_section() {
	    getHomePage().scrollDown();
	}
	@Then("user should be able to see all links")
	public void user_should_be_able_to_see_all_links() {
		getHomePage().visibilityOfLinks();;
	}
	@Then("user open this all links in different tab")
	public void user_open_this_all_links_in_different_tab() {
	   getHomePage().linkHandler();
	}
	@Then("close all links one by one")
	public void close_all_links_one_by_one() {
	    getHomePage().linkClose();
	}


}
