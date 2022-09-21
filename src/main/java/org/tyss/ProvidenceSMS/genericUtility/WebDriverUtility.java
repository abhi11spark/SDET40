package org.tyss.ProvidenceSMS.genericUtility;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This class consists all webdriver common actions
 * 
 * @author Intel
 *
 */
public class WebDriverUtility {
	WebDriver driver;

	/**
	 * This method is used to launch browser
	 * 
	 * @param browser
	 * @return
	 */
	public WebDriver launchBrowser(String browser) {

		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "ie":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;
		default:
			System.out.println("Enter valid browser name");
			break;
		}
		return driver;
	}

	/**
	 * This method is used to maximize the browser
	 */
	public void maximizeBrowser() {
		driver.manage().window().maximize();
	}

	/**
	 * This method is used to give implicit wait till the browser is completely
	 * loaded
	 * 
	 * @param longTimeouts
	 */
	public void waitTillLoad(long longTimeouts) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(longTimeouts));
	}

	/**
	 * This method is used to open the application
	 * 
	 * @param url
	 */
	public void navigateToApplication(String url) {
		driver.get(url);
	}

	/**
	 * This method is used launch browser, maximize browser, wait implicitly and
	 * open the application
	 * 
	 * @param browser
	 * @param timeout
	 * @param url
	 * @return
	 */
	public WebDriver openBrowserAndApplication(String browser, long timeout, String url) {
		launchBrowser(browser);
		maximizeBrowser();
		waitTillLoad(timeout);
		navigateToApplication(url);
		return driver;
	}

	public String loginValidation() {
		String message = driver
				.findElement(By.xpath("//h5[text()='Abhishek K H,']/descendant::span[text()=' Welcome back! ']"))
				.getText();
		return message;
	}

	public void verifyWebPage(String actual, String expected) {
//		SoftAssert soft = new SoftAssert();
//		soft.assertTrue(actual.equals(expected),"Login Successful");
//		soft.assertAll();
		Assert.assertTrue(actual.equals(expected), "Login Successfull");
	}

	/**
	 * This method is used to scroll down using text
	 * 
	 * @param element
	 * @param value
	 */
	public void dropdownByText(WebElement element, String value) {
		Select dd = new Select(element);
		dd.selectByVisibleText(value);

	}

	/**
	 * This method is used to scroll down using value
	 * 
	 * @param element
	 * @param value
	 */
	public void dropdownByValue(WebElement element, String value) {
		Select dd = new Select(element);
		dd.selectByValue(value);

	}

	/**
	 * This method is used to dropdown down using Index
	 * 
	 * @param element
	 * @param value
	 */
	public void dropdownByIndex(WebElement element, int value) {
		Select dd = new Select(element);
		dd.selectByIndex(value);

	}

	/**
	 * This method is used to do mouse hover action
	 * 
	 * @param driver
	 * @param element
	 */
	public void mouseHoverAction(WebDriver driver, WebElement element) {
		new Actions(driver).moveToElement(element).perform();
	}

	/**
	 * This method is used to give waiting statement explicitly
	 * 
	 * @param element
	 * @param timeout
	 */
	public void explicitWait(WebElement element, long timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * This method is used to convert dynamicPath from string to web element
	 * 
	 * @param dynamicPath
	 * @param replaceData
	 * @return
	 */
	public WebElement convertDynamicXpathIntoWebElement(String dynamicPath, String replaceData) {
		String requiredPath = String.format(dynamicPath, replaceData);
		WebElement element = driver.findElement(By.xpath(requiredPath));
		return element;
	}

	/**
	 * This method is used to close the application
	 */
	public void closeDriver() {
		driver.close();
	}

}
