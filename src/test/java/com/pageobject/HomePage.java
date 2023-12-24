package com.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.concretecomponents.ConcreteComponetAction;

public class HomePage extends ConcreteComponetAction{

	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "table[cellspacing='3']")
	WebElement linkTable;

	public void scrollDown() {
		scrollingDownAction(linkTable ,"Scrolling down");
		
	}

	public void linkHandler() {
		windowsHnadler(linkTable,"All links opened");
		
	}

	public void linkClose() {
		closeAllOpenTab("all tab get closed");
		
	}
	
	public void visibilityOfLinks() {
		elementVisibility(linkTable, "all links are visible");
	}
	
}
