package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class pagebase {
	protected WebDriver drivers;
	public Select select;
	public pagebase(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	protected static void btnclick(WebElement button) {
		button.click();
		
	}
	protected static void keyssent(WebElement txtinput ,String value) {
		txtinput.sendKeys(value);
	}

}
