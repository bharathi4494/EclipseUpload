
package pom.irctc.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pom.irctc.pages.HomePage;
import wrappers.ProjectWrappers;

public class TC004 extends ProjectWrappers {
	
	@BeforeClass
	public void beforeClass(){
		testCaseName="TC004";
		testCaseDescription="To verify Saloon_Mandatory_Check";
		author="Jaya Bharati";
		category="smoke";
	}
	
	@Test
	public void Saloon_Mandatory_Check(){
		
		new HomePage(driver,test)
			.clickOnStays()
			.clickOnLounge()
			.clickOnMenu()
			.clickCharter()
			.clickCharterEnquiryForm()
			.enterNameOfApplicant("abc")
			.enterNameOfOrganisation("CTS")
			.enterAddress("address")
			.enterMobileNo("748596125")
			.enterEmailId("asd@asd.com")
			.selectRequestFor("1")
			.enterOriginatingStation("New Delhi")
			.enterDestinationStation("Chennai")
			.selectDateOfDeparture()
			.clickonDateOfDeparture()
			.clickOnDateOfArrival()
			.selectDateOfArrivalBack()
			.enterDurationOfTour("12")
			.enterNumberAndTypeOfCoachRequired("2")
			.enterNumberOfPassengers("3")
			.enterPurposeOfCharter("charterPurpose")
			.enterAdditionalServicesRequired("services")
			.clickOnSubmit()
			.verifyText("");
			
			
		
		
	}

}
