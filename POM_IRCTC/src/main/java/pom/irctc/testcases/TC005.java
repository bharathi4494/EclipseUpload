
package pom.irctc.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pom.irctc.pages.HomePage;
import wrappers.ProjectWrappers;

public class TC005 extends ProjectWrappers {
	@BeforeClass
	public void beforeClass(){
		testCaseName="TC005";
		testCaseDescription="To verify Accommodations_GST_Validation";
		author="Jaya Bharati";
		category="smoke";
	}
	
	@Test
	
	public void Accommodations_GST_Validation(){
		
		new HomePage(driver,test)
			.clickOnStays()
			.clickOnLounge()
//		 LoungeHomePage()
			.selectStationName("NDLS")
			.selectNoOfPassengers("3")
			.selectCheckInDate("23")
			.selectCheckInTime("07:00")
			.selectDuration("20:00")
			.clickOnBook()
//		LoungeLoginPage()
			.clickGuestUserLogin()
			.enterEmailId("abc@abc.com")
			.enterMobileNo("1121211245")
			.clickLogInButton()
//		LoungePassengerDetailsPage()	
			.selectGst("Yes")
			.enterGstNo("12345612563")
			.enterPassengerOneName("new")
			.enterPassengerOneAge("22")
			.selectPassengerOneGender("Female")
			.enterPassengerTwoName("two")
			.enterPassengerTwoAge("20")
			.selectPassengerTwoGender("Female")
			.enterPassengerThreeName("three")
			.enterPassengerThreeAge("22")
			.selectPassengerThreeGender("Male")
			.selectState("TAMIL NADU")
			.clickSubmit();
		
		
		
		
		
		
		
		
		
		
	}

}
