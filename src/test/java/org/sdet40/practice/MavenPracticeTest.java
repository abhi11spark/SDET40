package org.sdet40.practice;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.tyss.ProvidenceSMS.genericUtility.WebDriverUtility;

public class MavenPracticeTest {

	
	@Test
		
		public void Step1Test() {
			String browser = System.getProperty("browser");
			String url = System.getProperty("url");
			
			System.out.println("Browser name is_"+browser);
			System.out.println("URl  is_"+url);
			
			WebDriverUtility webDriverUtility = new WebDriverUtility();
			WebDriver driver = webDriverUtility.launchBrowser(browser);
			webDriverUtility.navigateToApplication(url);
			
		}

	}


