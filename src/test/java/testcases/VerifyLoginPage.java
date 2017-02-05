package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.ExtentReports;
import factory.BrowserFactory;
import factory.DataProviderFactor;
import pages.LoginPage;

public class VerifyLoginPage 
{
	
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	
	@BeforeMethod
	public void setUP()
	{
		/*Creating reports*/
		report=new ExtentReports(".\\Reports\\LoginPageReport.html",true);
		logger=report.startTest("Verify Test Login with valid Data");
		/*To get Browser from Factory*/
		driver=BrowserFactory.getBrowser("Chrome");
		/*To get Application url from Config file*/
		driver.get(DataProviderFactor.getConfig().getApplicationUrl());
		logger.log(LogStatus.INFO, "Should able to login");
	}
	
	
	@Test
	public void testLoginPage()
	{

		/*Calling LoginPage*/
		LoginPage login=PageFactory.initElements(driver, LoginPage.class);
		logger.log(LogStatus.PASS, "Login success");
		login.LoginApplication(DataProviderFactor.getExcel().getData(0, 0, 0), DataProviderFactor.getExcel().getData(0, 0, 1));
		
	}

	@AfterMethod
	public void tearDown()
	{
		BrowserFactory.closeBrowser(driver);
		report.endTest(logger);
		report.flush();
	}
}
