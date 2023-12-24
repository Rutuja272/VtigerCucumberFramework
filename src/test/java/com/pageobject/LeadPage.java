package com.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.concretecomponents.ConcreteComponetAction;

public class LeadPage extends ConcreteComponetAction {

	public LeadPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Leads")
	WebElement ln_leads;

	@FindBy(linkText = "New Lead")
	WebElement ln_newLead;
	
	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	WebElement btn_upperSave;
	
	@FindBy(xpath = "(//input[@title1='Save [Alt+S]'])[2]")
	WebElement btn_lowerSave;
	
	@FindBy(xpath = "//select[@name='salutationtype']")
	WebElement dd_title;
	
	@FindBy(name = "firstname")
	WebElement tb_firstName;
	
	@FindBy(name = "lastname")
	WebElement tb_lastName;
	
	@FindBy(name = "company")
	WebElement tb_companyName;

	@FindBy(xpath = "//input[@name='Edit']")
	WebElement btn_edit;

	public void clickLead() {
		actionClick(ln_leads, "");
	}

	public void clickNewLead() {
		actionClick(ln_newLead,"");
	}

	public void isDisplayLeadPage() {
		elementVisibility(btn_upperSave,"create new lead page displayed");
	}

	public void upperSaveBtn() {
		actionClick(btn_upperSave,"");
	}

	public void lowerSaveBtn() {
		actionClick(btn_lowerSave,"");
	}

	public void createNewLead(String title, String fname, String lname, String cname) {
		salutationtype(title);
		setFirstName(fname);
		setLastName(lname);
		setCompanyName(cname);
	}

	public void salutationtype(String title) {
		actionSelectByText(dd_title, title);
	}

	public void setFirstName(String fname) {
		enterText(tb_firstName, fname,"");
	}

	public void setLastName(String lname) {
		enterText(tb_lastName, lname,"");
	}

	public void setCompanyName(String cname) {
		enterText(tb_companyName, cname,"");
	}

	public void isLeadCreate() {
		elementVisibility(btn_edit,"Lead created successfully");
	}
}
