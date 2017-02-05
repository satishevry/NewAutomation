package utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.OutputType;

public class Helper 
{
	public static String captureScreenshot(WebDriver driver, String screenshotName)
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		
		
		String destination="D:\\ToolsQA\\com.pharmpixsample.hybrid\\Screenshots\\"+screenshotName+System.currentTimeMillis()+".png";
		try {
			FileUtils.copyFile(src, new File(destination));
		} catch (IOException e) 
		{
			System.out.println("Failed to capture screenshots"+e.getMessage());
		}
		
		return destination;
		
		
	}
	
	

}
