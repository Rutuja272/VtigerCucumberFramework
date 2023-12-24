package com.concretecomponents;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.apache.commons.io.FileUtils;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.vtiger.stepdefinitions.BaseTest;


import org.openqa.selenium.support.ui.Select;

public class ConcreteComponetAction {

	public WebDriver driver;
	public WebDriverWait wait;

	public ConcreteComponetAction(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	}

	public ConcreteComponetAction() {

	}
	

	public void actionSelectByText(WebElement element, String text) {
		try {
			Select select = new Select(element);
			select.selectByVisibleText(text);
		} catch (Exception e) {
			e.printStackTrace();
			BaseTest.logger.fail("step failed due to "+e.getMessage()+" "+"<span class='label end-time'><a href='"+getScreenshot()+"'>Screenshot</a></span>");
		}

	}

	public void actionMouseOver(By findLocaror) {
		try {
			Actions actions = new Actions(driver);
			actions.moveToElement(driver.findElement(findLocaror)).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
			BaseTest.logger.fail("step failed due to "+e.getMessage()+" "+"<span class='label end-time'><a href='"+getScreenshot()+"'>Screenshot</a></span>");
		}

	}

	public void enterText(WebElement element, String text, String msg) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			element.clear();
			element.sendKeys(text);
			BaseTest.logger.pass(msg);
		} catch (Exception e) {
			e.printStackTrace();
			BaseTest.logger.fail("step failed due to "+e.getMessage()+" "+"<span class='label end-time'><a href='"+getScreenshot()+"'>Screenshot</a></span>");
		}
	}

	public void elementVisibility(WebElement element , String msg) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			element.isDisplayed();
			BaseTest.logger.pass(msg);
		} catch (Exception e) {
			e.printStackTrace();
			BaseTest.logger.fail("step failed due to "+e.getMessage()+" "+"<span class='label end-time'><a href='"+getScreenshot()+"'>Screenshot</a></span>");
		}

	}

	public void actionClick(WebElement element, String msg) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
			BaseTest.logger.pass(msg);
		} catch (Exception e) {
			e.printStackTrace();
			BaseTest.logger.fail("step failed due to "+e.getMessage()+" "+"<span class='label end-time'><a href='"+getScreenshot()+"'>Screenshot</a></span>");
		}
	}

	public void verifyTitle(String exp) {

		try {
			if (exp.equals(driver.getTitle())) {
				BaseTest.logger.pass("Pasesd");
			}
			else {
				BaseTest.logger.fail("failed");
			}
		} catch (Exception e) {
			e.printStackTrace();
			BaseTest.logger.fail("step failed due to "+e.getMessage()+" "+"<span class='label end-time'><a href='"+getScreenshot()+"'>Screenshot</a></span>");
		}

	}
	
	public String getScreenshot() {
		Date date = new Date();
		DateFormat dt = new SimpleDateFormat("ddMMyyyyhhmmss");
		String fileName = dt.format(date);
		String path = System.getProperty("user.dir") + "\\src\\test\\resources\\screenshots\\screenshot_" + fileName
				+ ".png";

		TakesScreenshot ts = ((TakesScreenshot) driver);
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(path);

		try {
			FileUtils.copyFile(src, dest);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return path;

	}
	
	public void scrollingDownAction(WebElement element, String msg) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", element);
			BaseTest.logger.pass(msg);
		} catch (Exception e) {
			BaseTest.logger.fail("step failed due to "+e.getMessage()+" "+"<span class='label end-time'><a href='"+getScreenshot()+"'>Screenshot</a></span>");
		}
		
	}
	
	public void windowsHnadler(WebElement element, String msg) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element));
			int count = element.findElements(By.tagName("a")).size();
			for (int i = 0; i < count; i++) {
				String linkKey = Keys.chord(Keys.CONTROL, Keys.ENTER);
				element.findElements(By.tagName("a")).get(i).sendKeys(linkKey);
			}
			BaseTest.logger.pass(msg);
		} catch (Exception e) {
			BaseTest.logger.fail("step failed due to "+e.getMessage()+" "+"<span class='label end-time'><a href='"+getScreenshot()+"'>Screenshot</a></span>");
		}	
	}
	
	public void closeAllOpenTab(String msg) {
		try {
		
			Set<String> set = driver.getWindowHandles();
			Iterator<String> itr = set.iterator();
			int count=0;
			while (itr.hasNext()) {
				count ++;
				String window=itr.next();
				driver.switchTo().window(window);
				driver.close();
			}
			System.out.println(count);
			BaseTest.logger.pass(msg);
		} catch (Exception e) {
			BaseTest.logger.fail("step failed due to "+e.getMessage()+" "+"<span class='label end-time'><a href='"+getScreenshot()+"'>Screenshot</a></span>");
		}
		
	}

	/*
	 * public void calenderActions(WebElement calElement, String month1, String
	 * year1, String day) throws InterruptedException {
	 * 
	 * System.out.println("000000000000000000");
	 * calElement.findElement(By.xpath("//td[text()='Today']")).click();
	 * System.out.println("1111111111111111111"); String nameString=
	 * calElement.findElement(By.xpath("//td[text()='Today']")).getText();
	 * System.out.println(nameString); //getAttribute("innerHTML"); String monthYear
	 * = calElement.findElement(By.xpath("//td[@class='title']")).getAttribute(
	 * "innerHTML"); System.out.println("444444444444");
	 * System.out.println(monthYear); System.out.println("555555555555555555");
	 * 
	 * String month = monthYear.replace(",", " ").split(" ")[0].trim();
	 * System.out.println(month); String year = monthYear.split(" ")[1].trim();
	 * System.out.println(year);
	 * 
	 * while (!(month.equalsIgnoreCase(month1) && year.equalsIgnoreCase(year1))) {
	 * calElement.findElement(By.xpath("//td[contains(text(),'�')]")).click();
	 * monthYear =
	 * calElement.findElement(By.xpath("//td[@class='title']")).getAttribute(
	 * "innerHTML"); System.out.println(monthYear); month = monthYear.replace(",",
	 * " ").split(" ")[0].trim();
	 * 
	 * year = monthYear.split(" ")[1].trim(); }
	 * 
	 * calElement.findElement(By.xpath("//td[text()='" + day + "' ]")).click();
	 * 
	 * }
	 */

}
