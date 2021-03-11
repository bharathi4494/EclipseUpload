package pom.irctc.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pom.irctc.pages.HomePage;
import wrappers.ProjectWrappers;

public class TC003 extends ProjectWrappers {
	
	@BeforeClass
	public void beforeClass(){
		testCaseName="TC003";
		testCaseDescription="To verify National_Voter_Services_Portal";
		author="Jaya Bharati";
		category="smoke";
	}
	
	@Test
	
	public void National_Voter_Services_Portal(){
		
		new HomePage(driver,test)
			.clickOnStays()
			.clickOnLounge()
			.switchToNextWindow()
			.clickOnMenu()
			.clickBookCoach()
			.clickFtrNewUserSignUp()
			.enterUserId("userId")
			.enterPwd("passworD44!")
			.enterCnfPwd("passworD44!")
			.selectSecurityQues("secQstn")
			.enterSecurityAns("secAnswer")
			.clickDob()
			.clickDobMonth()
			.clickDobYear()
			.clickGender()
			.clickMaritalStatus()
			.enterEmailId("abc@abc.com")
			.selectOccupation("Government")
			.enterFirstName("First")
			.enterMiddleName("mid")
			.enterLastName("Last")
			.selectNationality("94")
			//Address	
			.enterFlatNo("10")
			.enterStreetName("main st")
			.enterArea("Anna st")
			.clickCountryName()
			.selectCountry("94")
			.enterMobile("1234561236")
			.selectPostOffice("Sathyabama University S.O")
			//Communication Address
			.enterCommunicationFlatNo("10")
			.enterCommunicationStreetName("anna st")
			.enterCommunicationArea("Lakshmi nagar")
			.clickCommunicationCountryName()
			.enterCommunicationMobile("1234561425")
			.enterCommunicationPincode("600119")
			.selectCommunicationPostOffice("Sathyabama University S.O");
	}	

}
