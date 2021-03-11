package pom.irctc.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pom.irctc.pages.HomePage;
import wrappers.ProjectWrappers;

public class TC002 extends ProjectWrappers{

	@BeforeClass
	public void beforeClass(){
		testCaseName="TC002";
		testCaseDescription="To verify IRCTC Accommodations";
		author="Jaya Bharati";
		category="smoke";
	}
	
	
	@Test
	public void Irctc_Accommodations(){
		
		new HomePage(driver,test)
			.clickOnStays()
			.clickOnLounge()
			.switchToNextWindow()
			.waitOperation(3000)
			.selectStationName("NDLS")
			.selectNoOfPassengers("3")
			.clickCheckInDate()
			.selectCheckInDate("22")
			.selectCheckInTime("20:00")
			.selectDuration("6")
			.waitOperation(3000)
			.clickOnBook()
			.waitOperation(3000)
		//Login
			
			.clickGuestUserLogin()
			.enterEmailId("abc@abc.com")
			.enterMobileNo("1231231236")
			.clickLogInButton()	
		//Passenger Details
			.enterPassengerOneName("one")
			.enterPassengerOneAge("20")
			.selectPassengerOneGender("Female")
			.enterPassengerTwoName("two")
			.enterPassengerTwoAge("21")
			.selectPassengerTwoGender("Female")
			.enterPassengerThreeName("three")
			.enterPassengerThreeAge("20")
			.selectPassengerThreeGender("Male")
			.selectState("TAMIL NADU")
			.clickSubmit()	
		// Summary Page
			.getTotalAmount()
			.clickTermsAndConditons()
			.clickOnMakePayment();

			
			
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
}
