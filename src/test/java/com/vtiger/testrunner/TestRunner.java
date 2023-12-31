package com.vtiger.testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features ="src/test/resources/Features",
		glue ="com.vtiger.stepdefinitions" ,
		plugin= { "pretty", "json:target/cucumber-reports/Cucumber.json",
				"junit:target/cucumber-reports/Cucumber.xml",
				"html:target/cucumber-reports.html"},
		dryRun= false
	//	,tags = "@home"
		,monochrome = true
				
		)

public class TestRunner {

}
