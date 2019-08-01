package com.ChangeHealthCare.Test;

import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;

/**
 * @author Varadharajan.Thiruvengadam
 */
@RunWith(Cucumber.class)
@Cucumber.Options(
		
		features="C:\\Users\\Varadharajan.Thiruve\\eclipse-workspace\\SalesForceService\\src\\main\\java\\com\\ChangeHealthCare\\FeatureFile\\login.feature",
		glue="com.ChangeHealthCare.StepDefinition",
		format={"pretty","html:test-output", "junit:junit_xml/cucumber.xml"},
		tags={"@tags1"}, 
		monochrome=true,
		strict = false,
		dryRun = false
		
		)

public class TestRunner {

}
