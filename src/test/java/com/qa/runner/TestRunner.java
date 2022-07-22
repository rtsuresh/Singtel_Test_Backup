package com.qa.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(  features = "src/test/java/com/qa/features",glue = {"com/qa/stepDefinitions","com/qa/util"},
		monochrome = true,plugin = {"html:target/cucumber-html-report", "json:target/cucumber-json-report.json" },
		strict=true,
		dryRun = false
       )

public class TestRunner {
	
	
}

