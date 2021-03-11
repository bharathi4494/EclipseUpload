package pom.irctc.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pom.irctc.pages.HomePage;
import wrappers.ProjectWrappers;

public class TC007 extends ProjectWrappers{
	
	@BeforeClass
	public void beforeClass(){
		testCaseName="TC007";
		testCaseDescription="To verify Hill Railways";
		author="Jaya Bharati";
		category="smoke";
	}
	
	@Test
	public void Book_Hill_Railways(){
		
		new HomePage(driver,test)
			.clickOnStays()
			.clickOnLounge()
			.clickOnMenu()
			.clickHillRailways()
			.clickBookNow()
			.clickNextBookNow()
			.clickTourStartingDate("")
			.selectTourStartingDate("")
			.clickBoardingStation()
			.selectBoardingStation()
			.clickContinue()
			.selectAccomodationType("2 Adult + 1 Child without bed (28580 /-)")		
			.clickBook1()
//		 HillUserLogin()
			.clickGuestUserLogin()
			.enterEmailId("abc@abc.com")
			.enterMobileNo("1234561236")
			.clickLogInButton()
			.enterFirstPassengerFirstName("First1")
			.enterFirstPassengerLastName("First2")
			.enterFirstPassengerAge("20")
			.selectFirstPassengerGender()
			.enterSecondPassengerFirstName("First2")
			.enterSecondPassengerLastName("First3")
			.enterSecondPassengerAge("21")
			.selectSecondPassengerGender()
			.enterThirdPassengerFirstName("First3")
			.enterThirdPassengerLastName("First4")
			.enterThirdPassengerAge("22")
			.selectThirdPassengerGender()
			.enterNomineeName("Nominee")
			.enterRelationWithPassenger("Nominee")
			.enterContactNo("1331231236")
			.enterPhoneNoWithCode("012-123456")
			.enterFaxNo("120120365")
			.enterAddress("10 main st")
			.enterCity("Kanchipuram")
			.selectCountry()
			.selectStateName()
			.selectIdCardType()
			.enterIdCardNo("1237418523");
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
