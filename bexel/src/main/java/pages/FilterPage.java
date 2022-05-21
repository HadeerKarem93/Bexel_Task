package pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class FilterPage extends pagebase {

	public FilterPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(className="inventory_item_price")
	private List<WebElement> app_price;
	
	@FindBy(className="product_sort_container")
	private WebElement product_sort;
	
	
	public List<Double> sortfromlowtohighwithselenium() {
       List<Double> beforefilterprice=new ArrayList<Double>();
		for (WebElement price: app_price) {
			beforefilterprice.add(Double.valueOf(price.getText().replace("$", "")));
		}
		 Collections.sort(beforefilterprice);
return beforefilterprice;
		
	}
	public List<Double> selectbyapp(WebDriver drivers) {
			select = new Select(product_sort);
			select.selectByVisibleText("Price (low to high)");
			List<WebElement> afterfilter= drivers.findElements(By.className("inventory_item_price"));
			List<Double> afterfilterprice=new ArrayList<Double>();
			for (WebElement price: app_price) {
				afterfilterprice.add(Double.valueOf(price.getText().replace("$", "")));
			}
			return afterfilterprice;

		}
		
	}


