package pom.irctc.pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.GenericWrappers;

public class FlipkartHomeLoginPage extends GenericWrappers{
	
	public FlipkartHomeLoginPage (RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		
	}
	
	public FlipkartHomeLoginPage enterEmailOrMobile(String data){
		return this;
		
	}
	
	public FlipkartHomeLoginPage enterPassword(String data){
		return this;
		
	}
	
	public FlipkartHomeLoginPage clickLogin(){
		return this;
		
	}
	
	public SearchResultsPage enterSearchText(String data){
		return new SearchResultsPage(driver, test);
		
		
	}
	
	
	
	
	
	
	
	

}
