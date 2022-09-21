package org.tyss.ProvidenceSMS.genericUtility;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.tyss.ProvidenceSMS_ObjectRepository.AdminHomePage;
import org.tyss.ProvidenceSMS_ObjectRepository.ClassroomPage;
import org.tyss.ProvidenceSMS_ObjectRepository.CommonPage;
import org.tyss.ProvidenceSMS_ObjectRepository.GradePage;
import org.tyss.ProvidenceSMS_ObjectRepository.PettyCashPage;
import org.tyss.ProvidenceSMS_ObjectRepository.SubjectPage;

public class BaseClass {
	protected  WebDriver driver;
	protected WebDriverUtility webdriver;
	protected PropertyFileUtility property;
	protected JavaUtility javaUtility;
	public ExcelUtility excel;
	protected CommonPage commonPage;
	protected AdminHomePage adminHomePage;
	protected GradePage gradePage;
	protected ClassroomPage classroomPage;
	protected PettyCashPage pettyCashPage;
	protected SubjectPage subjectPage;
	protected JavaScriptUtility jsu;
	public static WebDriver sDriver;
	
	@BeforeClass
	public void classSetup() {
		
		webdriver = new WebDriverUtility();
		property = new PropertyFileUtility();
		javaUtility = new JavaUtility();
		excel = new ExcelUtility();
		jsu=new JavaScriptUtility();
		jsu.jsInitialization(driver);
		excel.initializeExcel(IConstantUtility.EXCEL_PATH);
		property.initializePropertyFile(IConstantUtility.PROPERTY_FILE_PATH);

		String browser = property.getDataFromPropertyFile("browser");
		String path = property.getDataFromPropertyFile("url");

		String time = property.getDataFromPropertyFile("timeout");
		long timeouts = (Long) (javaUtility.convertStringToAnyData(time, DataType.LONG));
		driver = webdriver.openBrowserAndApplication(browser, timeouts, path);
		commonPage = new CommonPage(driver);
		sDriver=driver;
	}

	@BeforeMethod
	public void methodSetup() {
		adminHomePage = new AdminHomePage(driver);
		gradePage = new GradePage(driver);
		classroomPage = new ClassroomPage(driver);
		subjectPage = new SubjectPage(driver);
		pettyCashPage = new PettyCashPage(driver);
	}
		
	
	@AfterClass
	public void classTeardown() {
		excel.closeExcelWorkbook();
		webdriver.closeDriver();
	}
	

}
