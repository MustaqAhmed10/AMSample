package org.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.jvmreport.JVMReport;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources", glue="org.stepdefinition", dryRun=false,
			     tags={"@smoke or @retest"},
				 monochrome=true,
				 //snippets = SnippetType.CAMELCASE,
				 snippets = SnippetType.UNDERSCORE,
				 strict = true,
				 plugin = { "pretty",
						    "html:src\\test\\resources\\Reports\\HTMLReport\\htmlreport.html",
						    "json:src\\test\\resources\\Reports\\JSONReport\\jsonreport.json",
						    "junit:src\\test\\resources\\Reports\\JUnitReport\\junitreport.xml",
						    "rerun:src\\test\\resources\\FailedReport\\failed.txt"
				 })

public class TestRunner {
	
	@AfterClass
	public static void report() {
		
		JVMReport.generateJVMReport("src\\test\\resources\\Reports\\JSONReport\\jsonreport.json");
		System.out.println("=====================================Report Generated===============================");
		
	}

}
