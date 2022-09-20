package org.tyss.ProvidenceSMS.genericUtility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtility {
	JavascriptExecutor jse;

	/**
	 * This method is used for initialization of JavascriptExecutor
	 * 
	 * @param driver
	 */
	public void jsInitialization(WebDriver driver) {
		jse = (JavascriptExecutor) driver;
	}

	/**
	 * This method is used to open the application using JavascriptExecutor
	 * 
	 * @param url
	 */
	public void openApplicationUsingJSE(String url) {
		jse.executeScript("window.location=arguments[0]", url);
	}

	/**
	 * This method is used to provide inputs to the web elements using
	 * JavascriptExecutor
	 * 
	 * @param element
	 * @param data
	 */
	public void sendKeysUsingJSE(WebElement element, String data) {
		jse.executeScript("arguments[0].value=arguments[1]", element, data);
	}

	/**
	 * This method is used to click the given web element using JavascriptExecutor
	 * 
	 * @param element
	 */
	public void clickUsingJSE(WebElement element) {
		jse.executeScript("arguments[0].click()", element);
	}

	/**
	 * This method is used to scroll till the given web element using
	 * JavascriptExecutor
	 * 
	 * @param element
	 */
	public void scrollTillElementUsingJSE(WebElement element) {
		jse.executeScript("arguments[0].scrollIntoView()", element);
	}
//	public void scroll() {
//		WebElement scroll = gradePage
////		jsu.scrollTillElementUsingJSE(scroll);
////		Point loc = scroll.getLocation();
////		int x = loc.getX();
////		int y = loc.getY();
////		JavascriptExecutor js = (JavascriptExecutor) driver;
////		js.executeScript("window.scrollBy(" + x + "," + y + ")");
//	}

}
