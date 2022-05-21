package pages;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends pagebase {

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(id="login_credentials")
	private WebElement usernamelist;
	
	@FindBy(className="login_password")
	private WebElement passwordl;
	
	@FindBy(id="user-name")
	private WebElement username;
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(id="login-button")
	private WebElement loginbtn;
	
	@FindBy(css="button.error-button")
	private WebElement errormsg;
	
	public void extractlogindetailsintoarray(WebDriver drivers) throws InterruptedException {
		String usernametxt = usernamelist.getText();
		List<String> usernamesl = Arrays.asList(usernametxt.split("\n"));
       Object[] usernames = usernamesl.toArray();
       String passwordtxt = passwordl.getText();
   		List<String> passw = Arrays.asList(passwordtxt.split("\n"));
   		Object[] passwords = passw.toArray();
   	 for (int i=1;i<usernames.length;i++) 
	 {	
	drivers.get("https://www.saucedemo.com/");
	keyssent(username,usernames[i].toString());
	keyssent(password,passwords[1].toString());
	Thread.sleep(2000);
    btnclick(loginbtn);
	String url=drivers.getCurrentUrl();
	WebDriverWait wait = new WebDriverWait(drivers,30);
    if (url.contentEquals("https://www.saucedemo.com/inventory.html")) {
    	System.out.println("test case passed by email "+ usernames[i].toString() );
    } else if  (isElementPresent(By.cssSelector("button.error-button"), drivers)) {
    	System.out.println("test case failed by email "+ usernames[i].toString() + " and error message appears successfully" );
    } else {System.out.println("test case failed");}
	 }
}
	
	public void loginwithvaliduser() {
		keyssent(username,"standard_user");
		keyssent(password,"secret_sauce");
		btnclick(loginbtn);
	}
	
	private boolean isElementPresent(By cssSelector,WebDriver drivers) {
		try {
   			drivers.findElement(cssSelector);
   			return true;
   		}catch(NoSuchElementException e) {
   			return false;
   		}
	}
 	


	}
	


