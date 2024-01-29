package com.vtiger.stepdefinitions;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

import java.io.File;
import java.io.FileInputStream;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest extends PageObjectManager {
	public static Properties prop;
	public static Map<String, Map<String, String>> dt;
	public static String TCName;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest logger;

	public void initation() throws IOException {
		if (prop == null) {
			prop = readProperties();
		}
		if(dt==null) {
		dt = readExcel(System.getProperty("user.dir") + "\\src\\test\\resources\\TestData\\data.xlsx", "sheet1");
		}
		if(extent==null) {
		createExtentReport();
		}
	}

	public void initDriver() throws IOException {
		String browser = System.getProperty("browser") != null ? System.getProperty("browser")
				: prop.getProperty("browser");

		if (browser.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);

		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

	}

	public void lunchApp() throws IOException {

		initDriver();
		driver.manage().window().maximize();
		int sec = Integer.parseInt(prop.getProperty("GobalTimeOut"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
		String url = prop.getProperty("AppUrl");
		driver.get(url);
	}

	public Properties readProperties() {
		Properties prop = new Properties();
		try {
			FileInputStream file = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\main\\resources\\com\\testdata\\TestData.properties");
			prop.load(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prop;
	}

	public Map<String, Map<String, String>> readExcel(String path, String sheet) {
		Map<String, Map<String, String>> allData = null;
		try {
			Fillo fillo = new Fillo();
			Connection connection = fillo.getConnection(path);
			String strQuery = "Select * from " + sheet;
			Recordset recordset = connection.executeQuery(strQuery);

			allData = new HashMap<>();

			List<String> collist = recordset.getFieldNames();

			while (recordset.next()) {
				String TCName = recordset.getField("TCName");
				Map<String, String> rowdata = new HashMap<>();
				for (int i = 0; i < collist.size(); i++) {

					String key = collist.get(i);
					String colval = recordset.getField(key);
					rowdata.put(key, colval);
				}
				allData.put(TCName, rowdata);
			}
			recordset.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return allData;

	}

	public void createExtentReport() {
		Date date = new Date();
		DateFormat dt = new SimpleDateFormat("ddMMyyyyhhmmss");
		String fileName = dt.format(date);
		String reportName = System.getProperty("user.dir") + "\\src\\test\\resources\\reports\\ExtentReport_" + fileName
				+ ".html";
		htmlReporter = new ExtentHtmlReporter(reportName);
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", "ATH");
		extent.setSystemInfo("Environment", "Test");
		extent.setSystemInfo("User Name", "Rutuja");
		htmlReporter.config().setDocumentTitle("Cucumber_Extent_Report");
		htmlReporter.config().setReportName(reportName);
		htmlReporter.config().setTheme(Theme.STANDARD);
	}

	public void closeWindow() {
		driver.close();
	}
	

	public void closeApp() {
		driver.quit();
	}

}
