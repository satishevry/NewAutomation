package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage
{
	private static final By WELCOME = null;

	WebDriver driver;
	
	public LoginPage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}

	/*Xpath for UserName*/
	@FindBy(id="cphBody_tbUsername") WebElement Username;
	
	/*Xpath for Password*/
	@FindBy(id="cphBody_tbPassword") WebElement Password;
	
	/*Xpath for Log In*/
	@FindBy(name="ctl00$cphBody$btnSubmit") WebElement LoginButton;

	private WebElement ele;

	public void LoginApplication(String user,String pass)
	{
		Username.sendKeys(user);
		Password.sendKeys(pass);
		LoginButton.click();
	}
	

	/*public String verifytext()
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		ele = wait.until(ExpectedConditions.presenceOfElementLocated(WELCOME));
		String text=ele.getText();
		Assert.assertEquals(text,"WELCOME ADMINISTRATOR!","Invalid password");
		return text;
	}*/
}
