package bexel;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.FilterPage;
import pages.LoginPage;

public class pricesortingtest extends testbase{
	
	LoginPage loginpage;
	FilterPage filterpage;
	@Test
	public void ascsorttest() {
		loginpage = new LoginPage(driver);
		filterpage= new FilterPage(driver);
		loginpage.loginwithvaliduser();
		filterpage.sortfromlowtohighwithselenium();
		filterpage.selectbyapp(driver);
		Assert.assertEquals(filterpage.selectbyapp(driver), filterpage.sortfromlowtohighwithselenium());
	}

}
