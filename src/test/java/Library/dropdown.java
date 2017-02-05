package Library;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class dropdown {
	
	public static void selectbyname(WebElement element, String value) {
	
		Select sel= new Select(element); 
		sel.deselectByValue(value);
		
	}

}
