package pom.irctc.pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.GenericWrappers;

public class SelectedProductDetailsPage extends GenericWrappers {
	
	public  SelectedProductDetailsPage (RemoteWebDriver driver, ExtentTest test) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		this.test = test;
		
	}

	public FlipkartMyCartPage clickAddToCart() {
		return new FlipkartMyCartPage(driver, test) ;
		
		
		
	}
	
	
}
