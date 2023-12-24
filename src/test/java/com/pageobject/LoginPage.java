package com.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.concretecomponents.ConcreteComponetAction;

public class LoginPage extends ConcreteComponetAction {

	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public LoginPage() {

	}

	@FindBy(name = "user_name")
	WebElement tb_uname;

	@FindBy(name = "user_password")
	WebElement tb_pass;

	@FindBy(name = "Login")
	WebElement btn_login;

	@FindBy(linkText = "Logout")
	WebElement ln_logout;

	@FindBy(xpath = "//*[contains(text(),'You must specify a valid username and password.')]")
	WebElement txt_errorMsg;

	@FindBy(name = "login_theme")
	WebElement dd_theme;
	
	@FindBy(xpath = "//img[@alt='vigercrm']")
	WebElement logo;
	
	

	public void login(String user_name, String user_password) {
		setUserName(user_name);
		setPassword(user_password);
		clickLogin();
	}

	public void login(String user_name, String user_password, String themeName) {
		setUserName(user_name);
		setPassword(user_password);
		actionSelectByText(dd_theme, themeName);
		clickLogin();
	}

	public void logout() {
		actionClick(ln_logout,"logout link clicked");
	}

	public void errorMsgVerification() {
		elementVisibility(txt_errorMsg,"error msg is displayed");

	}

	public void setUserName(String userid) {
		enterText(tb_uname, userid,userid+" entered into username field" );
	}

	public void setPassword(String pass) {
		enterText(tb_pass, pass ,pass+" entered into password field");
	}

	public void clickLogin() {
		actionClick(btn_login, "login button clicked");
	}

	public void verifyLogo() {
		elementVisibility(logo,"logo is displayed");
	}

	

}
