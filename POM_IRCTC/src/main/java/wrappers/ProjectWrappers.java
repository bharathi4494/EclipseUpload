package wrappers;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class ProjectWrappers extends GenericWrappers {
	
	
	public String browser;

	@BeforeSuite
	public void beforeSuite(){
	startReport();	
	}
	
	@BeforeTest
	public void beforeTest(){
		loadObjects();
	}
	

	@BeforeMethod
	public void launchIrctc(){
		startTest(testCaseName, testCaseDescription);
		invokeApp(browser, "http://www.irctc.co.in");
	}
	
	
	@AfterMethod
	public void closeIrctc(){
		closeAllBrowsers();
		
	}
	
	@AfterClass
	public void afterClass(){
		endTest();
	}
	
	@AfterTest
	public void afterTest(){
		unloadObjects();
	}
	
	@AfterSuite
	public void afterSuite(){
		endReport();
	}
	

}
