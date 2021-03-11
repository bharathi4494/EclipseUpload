package pom.irctc.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pom.irctc.pages.FlipkartHomeLoginPage;
import wrappers.ProjectWrappers;

public class TC009 extends ProjectWrappers {
	
	@BeforeClass
	public void beforeClass(){
		testCaseName="TC009";
		testCaseDescription="To verify Book mobile in flipkart";
		author="Jaya Bharati";
		category="smoke";
	}
	
	@Test

	public void Book_Mobile() {
		
			new FlipkartHomeLoginPage(driver,test)
			.enterEmailOrMobile("9612451212")
			.enterPassword("Password")
			.clickLogin()
			.enterSearchText("samsung galaxy")
			.clickFirstSearchResult()
			.clickAddToCart();
			
		
		
		
	}
}
