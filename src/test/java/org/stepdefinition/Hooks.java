package org.stepdefinition;

import java.io.IOException;

import org.base.BaseClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends BaseClass {
	
	@Before
	public void beforeScenario() {
		System.out.println("===========================Before==========================");
		browserLaunch("Chrome");
		implicitWait(10);
		urlLaunch("https://www.facebook.com/");
	}
	
	@After
	public void afterScenario(Scenario sc) throws IOException {	
		System.out.println("===========================After==========================");
//		// take screenshot for all scenarios
//		String name = sc.getName();
//		takeScreenshot("Fb-" + name);

//		// take screenshot only for failed scenarios
//		if (sc.isFailed()) {
//			String name = sc.getName();
//			takeScreenshot("Fb-" + name);
//		}
		
		// take screenshot only for failed scenarios attached to report
		if (sc.isFailed()) {
			TakesScreenshot tk = (TakesScreenshot) driver;
			byte[] bt = tk.getScreenshotAs(OutputType.BYTES);
			sc.embed(bt, "image/png");
		}
		quit();
	}

}
