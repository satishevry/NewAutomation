package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import factory.DataProviderFactor;

public class AddPatient
{
	WebDriver driver;
	
		
	public AddPatient(WebDriver ldriver)
	{
		this.driver=ldriver;
	}

	/*Xpath for mouse over BACMAN*/
	@FindBy(xpath=".//*[@id='cphBody_ApplicationID_2']/div/div[2]/p") WebElement BACMAN;
	/*Xpath for clicking on Add patient*/
	@FindBy(xpath=".//*[@id='menuHeader']/ul/li[2]/a") WebElement APatient;
	/*Xpath for inserting data on First Name*/
	@FindBy(xpath=".//*[@id='FirstName']") WebElement FName;
	/*Xpath for inserting data on Last Name*/
	@FindBy(xpath=".//*[@id='LastName1']") WebElement LName;
	/*Xpath for inserting data on Address*/
	@FindBy(xpath=".//*[@id='PostalAddressLine1']") WebElement address;
	/*Xpath for inserting data on city*/
	@FindBy(xpath=".//*[@id='PostalCity']") WebElement city;
	/*Xpath for inserting data on State*/
	@FindBy(xpath=".//*[@id='PostalState']") WebElement state;
	/*Xpath for inserting data on Zip*/
	@FindBy(xpath=".//*[@id='PostalZipCode']") WebElement zip;
	/*Xpath for inserting data on Cardholder*/
	@FindBy(xpath=".//*[@id='CardholderID']") WebElement ch;
	/*Xpath for Effective Date*/
	@FindBy(id="StrEffectiveDate_date") WebElement ed;
	/*Xpath for Effective Date*/
	@FindBy(id="StrExpirationDate_date") WebElement expd;
	/*Xpath for Date of Birth*/
	@FindBy(id="StrBirthDate_date") WebElement db;
	/*Xpath for clicking on Radio Button*/
	@FindBy(id="rbGender0") WebElement rb;
	/*id for clicking on dropdown*/
	@FindBy(id="Customer") WebElement dd;
	/*id for selecting relationship  on dropdown*/
	@FindBy(id="RelationshipCode") WebElement re;
	/*id for clicking on save button*/
	@FindBy(xpath=".//*[@id='insertPatient']") WebElement Save;
	/*Xpath for Sign off*/
	/*	By SignOff=By.xpath(".//*[@id='menuHeader']/ul/li[6]/a");*/
	/*Xpath for clicking on Sign out*/
	@FindBy(xpath=".//*[@id='menuHeader']/ul/li[6]/a") WebElement SignOff;
	
		
	
	/*Xpath for Password*/
	/*@FindBy(id="cphBody_tbPassword") WebElement Password;*/
	
	/*Xpath for Log In*/
	/*@FindBy(name="ctl00$cphBody$btnSubmit") WebElement LoginButton;*/

	public void ClickBACMAN()
	{
			BACMAN.click();
	}
	
	public void ClickAPatient()
	{
		APatient.click();
	}
	
	public void EnterFName(String s) 
	{
		FName.sendKeys(s);
		FName.sendKeys(Keys.TAB);
	}

	public void EnterLName(String s) 
	{
		LName.sendKeys(s);
		LName.sendKeys(Keys.TAB);
	}
	
	public void address(String s) 
	{
		address.sendKeys(s);
	}
	
	public void city(String s) 
	{
		city.sendKeys(s);
	}
	
	public void state(String s) 
	{
		state.sendKeys(s);
	}
	
	public void zip(String s) 
	{
		zip.sendKeys(s);
		
	}
	
	public void ch(String s) 
	{
		ch.sendKeys(s);
		
	}
	
	public void ed(String s)
	{
		ed.sendKeys(s);
	}
	
	public void expd(String s)
	{
		expd.sendKeys(s);
	}
	
	public void db(String s)
	{
		db.sendKeys(s);
	}
	
	public void rb()
	{
		rb.click();
	}
	public void ddown() 
	{
		
		Select ddown = new Select(dd);
		//ddown.selectByVisibleText("Triple S");
		ddown.selectByValue(DataProviderFactor.getExcel().getData(0, 13, 0));
		
	}
	
	public void re() 
	{
		
		Select ddown = new Select(re);
		//ddown.selectByVisibleText("Triple S");
		ddown.selectByValue(DataProviderFactor.getExcel().getData(0, 14, 0));
		
	}
	
	public void Save()
	{
		Save.click();
	}
	
	
	
	
	
	/*public void SignOff()
	{
		SignOff.click();
	}
	*/
	/*public void Save()
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		WebElement ele=wait.until(ExpectedConditions.presenceOfElementLocated(SignOff));
		String text=ele.getText();
		Assert.assertEquals(text,"Sign Off","Sign off link not working");
		
	}*/
	/*public String verifytext()
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		ele = wait.until(ExpectedConditions.presenceOfElementLocated(WELCOME));
		String text=ele.getText();
		Assert.assertEquals(text,"WELCOME ADMINISTRATOR!","Invalid password");
		return text;
	}*/
}
