package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import factory.BrowserFactory;
import factory.DataProviderFactor;
import pages.LoginPage;
import utility.Helper;


public class VerifyLoginPagewithInvalidData 
{
	
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
		
	@BeforeMethod
	public void setUP()
	{
		/*Creating reports*/
		report=new ExtentReports(".\\Reports\\LoginPageReport.html",true);
		logger=report.startTest("Verify Test Login with Invalid Data");
		/*To get Browser from Factory*/
		driver=BrowserFactory.getBrowser("Chrome");
		/*To get Application url from Config file*/
		driver.get(DataProviderFactor.getConfig().getApplicationUrl());
		logger.log(LogStatus.INFO, "Should not able to login");
	}
	
	@Test
	public void testLoginPage()
	{

		/*Calling LoginPage*/
		LoginPage login=PageFactory.initElements(driver, LoginPage.class);
		logger.log(LogStatus.FAIL,"Login Failed");
		login.LoginApplication(DataProviderFactor.getExcel().getData(0, 1, 0), DataProviderFactor.getExcel().getData(0, 1, 1));
		/*Assert.assertTrue(login.LoginApplication(user, pass));*/
		
	}

	@AfterMethod
	public void tearDown(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
	{
			Helper.captureScreenshot(driver, result.getName());
			String path = null;
			logger.log(LogStatus.FAIL,logger.addScreenCapture(path));
	}
	/*	BrowserFactory.closeBrowser(driver);*/
		report.endTest(logger);
		report.flush();
	}
}
