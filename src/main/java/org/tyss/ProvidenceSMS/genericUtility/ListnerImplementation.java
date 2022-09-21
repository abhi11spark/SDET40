package org.tyss.ProvidenceSMS.genericUtility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListnerImplementation implements ITestListener{
	private ExtentReports reports;
	public static ExtentTest sTest;
	private ExtentTest test;
		
	@Override
	public void onStart(ITestContext context) {
		ExtentSparkReporter spark = new ExtentSparkReporter("./extentReport/extentReport.html");
		spark.config().setDocumentTitle("Document Title - ProvidenceSMS");
		spark.config().setReportName("Report Name  ProvidenceSMS");
		spark.config().setTheme(Theme.STANDARD);
		
		reports = new ExtentReports();
		reports.attachReporter(spark);
		reports.setSystemInfo("Author", "Abhishek K H");
		reports.setSystemInfo("OS", "WINDOWS 10 PRO");
		reports.setSystemInfo("Browser", "chrome");
		
	}
	@Override
	public void onTestStart(ITestResult result) {
		test= reports.createTest(result.getMethod().getMethodName());
		sTest=test;
		
	}


	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.fail(result.getMethod().getMethodName()+"Fail");
		new WebDriverUtility().getScreenshot(BaseClass.sDriver);
//		String testName = result.getMethod().getMethodName();
//		System.out.println(testName+"**Execute**");
//		
//		
//		TakesScreenshot eDriver = (TakesScreenshot)(BaseClass.sDriver);
//		File srcFile = eDriver.getScreenshotAs(OutputType.FILE);
//		try
//		{
//			FileUtils.copyFile(srcFile, new File("./screenshot/"+testName+".png"));
//		}
//		catch(IOException e)
//		{
//			e.printStackTrace();
//		}
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.skip(result.getMethod().getMethodName());
		test.fail(result.getThrowable());
	}

	
	@Override
	public void onTestSuccess(ITestResult result) {
		test.pass(result.getMethod().getMethodName()+"pass");
		
	}
	@Override
	public void onFinish(ITestContext context) {
	reports.flush();
		
	}
	

}
