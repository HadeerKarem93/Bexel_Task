package bexel;

import org.testng.annotations.Test;

import pages.LoginPage;

public class loginbuusersandverify extends testbase {
	
	LoginPage loginpage;
	
	@Test
	public void loginandverifyuser() throws InterruptedException {
		loginpage = new LoginPage(driver);
		loginpage.extractlogindetailsintoarray(driver);
		
	}

}
