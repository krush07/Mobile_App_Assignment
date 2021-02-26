package com.test.cucumber;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
			features= {"src/test/resources/features"},
			glue= {"com.test.stepDefinitions"},
			dryRun= false,
			monochrome = true,
			plugin = {"html:target/cucumber-html-report","json:target/jsonReports/cucumber-report.json",
					"junit:target/cucumber-reports/cucumber.xml"}
		)
public class TestRunner {


}
