package pom.irctc.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pom.irctc.pages.HomePage;
import wrappers.GenericWrappers;

public class TC008 extends GenericWrappers {
	
	@BeforeClass
	public void beforeClass(){
		testCaseName="TC008";
		testCaseDescription="To verify Book_Hotels_Gst";
		author="Jaya Bharati";
		category="smoke";
	}
	
	@Test
	public void Book_Hotels_Gst(){
		new HomePage(driver,test)
		.clickOnStays()
		.clickOnLounge()
		.clickIrctcHotels()
		
	//Guest Login and Find Hotel
		.clickHotelLoginLink()
		.clickHotelGuestLoginPage()
		.enterEmailId("")
		.enterPhoneNo("")
		.clickGuestSignInButton()
		.enterHotelOrCityName("")
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
		.enterFirstName("name1")
		.enterLastName("name2")
		.enterMobileNo("1234152636")
		.selectGst()
		.enterCustomerGstNo("2541635263")
		.enterCompanyName("CTS")
		.enterCompanyAddress("elcot")
		.clickGo()
		.clickTermsAndConditions()
		.clickPaymentPage()
		.enterOtpNo("124563")
		.clickOtpVerify();
	}
}