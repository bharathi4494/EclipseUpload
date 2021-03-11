package pom.irctc.pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.GenericWrappers;

public class SearchResultsPage extends GenericWrappers {

	
	public SearchResultsPage(RemoteWebDriver driver, ExtentTest test) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		this.test = test;
	}
	

	public SelectedProductDetailsPage clickFirstSearchResult(){
		return new SelectedProductDetailsPage(driver, test) ;
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
