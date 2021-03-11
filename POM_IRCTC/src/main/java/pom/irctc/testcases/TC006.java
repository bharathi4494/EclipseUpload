package pom.irctc.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pom.irctc.pages.HomePage;
import wrappers.ProjectWrappers;


public class TC006 extends ProjectWrappers {

	@BeforeClass
	public void beforeClass(){
		testCaseName="TC006";
		testCaseDescription="To verify National_Voter_Services_Portal";
		author="Jaya Bharati";
		category="smoke";
	}
	
	@Test
	public  void Book_Hotels(){
		
		new HomePage(driver,test)
			.clickOnStays()
			.clickOnLounge()
			.clickIrctcHotels()	
		//Guest Login and Find Hotel
			.clickHotelLoginLink()
			.clickHotelGuestLoginPage()
			.enterEmailId("email@email.com")
			.enterPhoneNo("1231231236")
			.clickGuestSignInButton()
			.enterHotelOrCityName("New Delhi")
			.clickCheckInDate()
			.selectCheckInDate()
			.clickCheckOutDate()
			.selectCheckOutDate()
			.SelectRooms()
			.SelectAdults()
			.SelectChildren()
			.clickFindHotel()
			.clickBook()
			.clickContinueToBook()
		//Passenger Details 		
			.selectTitle()
			.enterFirstName("first")
			.enterLastName("last")
			.enterMobileNo("1231231236")
			.clickGo()
			.clickTermsAndConditions()
			.clickPaymentPage()
			.enterOtpNo("123654")
			.clickOtpVerify();
		
	}
	
	
	
	
	
	
}
