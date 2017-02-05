package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import factory.BrowserFactory;
import factory.DataProviderFactor;
import pages.AddPatient;
import pages.LoginPage;

public class VerifyAddPatient 
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
	public void testLoginPage() throws InterruptedException
	{

		/*Calling LoginPage*/
		LoginPage login=PageFactory.initElements(driver, LoginPage.class);
		logger.log(LogStatus.PASS, "Login success");
		login.LoginApplication(DataProviderFactor.getExcel().getData(0, 0, 0), DataProviderFactor.getExcel().getData(0, 0, 1));
		AddPatient AP=PageFactory.initElements(driver, AddPatient.class);
		AP.ClickBACMAN();
		AP.ClickAPatient();
	/*	AP.EnterFName(DataProviderFactor.getExcel().getData(0, 2, 0));
		AP.EnterLName(DataProviderFactor.getExcel().getData(0, 3, 0));
		AP.address(DataProviderFactor.getExcel().getData(0, 4, 0));
		AP.city(DataProviderFactor.getExcel().getData(0, 5, 0));
		AP.state(DataProviderFactor.getExcel().getData(0, 6, 0));
		AP.zip(DataProviderFactor.getExcel().getData(0, 7, 0));
		AP.ch(DataProviderFactor.getExcel().getData(0, 8, 0));
		AP.ed(DataProviderFactor.getExcel().getData(0, 9, 0));
		AP.expd(DataProviderFactor.getExcel().getData(0, 10, 0));
		AP.db(DataProviderFactor.getExcel().getData(0, 11, 0));
		AP.rb();
		AP.ddown();
		AP.re();*/
		AP.Save();
		/*AP.SignOff();*/
		/*driver.findElement(By.xpath(".//*[@id='insertPatient']")).click();*/
		/*driver.findElement(By.id("insertPatient")).click();*/
		logger.log(LogStatus.PASS, "Patient added successfully");
	}
	

	@AfterMethod
	public void tearDown()
	{
		/*BrowserFactory.closeBrowser(driver);*/
		report.endTest(logger);
		report.flush();
		
	}
}
