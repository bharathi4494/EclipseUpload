

package pom.irctc.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pom.irctc.pages.HomePage;
import wrappers.ProjectWrappers;

public class TC001 extends ProjectWrappers {

	@BeforeClass
	public void beforeClass(){
		testCaseName="TC001";
		testCaseDescription="To verify IRCTC Signup";
		author="Jaya Bharati";
		category="smoke";
		browser = "chrome";
	}
	
	
	@Test
	public void irctcSignUp(){
		new	HomePage(driver, test)
		.clickOnRegister()
		//Profile Information
		.waitOperation(5000)
		.enterUserName("Jaya bharati")
		.enterPassword("secret")
		.enterConfirmPassword("secret")
		.clickSecurityQuestion()
		.selectSecurityQuestion()
		.selectSecurityAnswer("Vijay")
		.waitOperation(3000)
		.clickPreferredLanguage()
		.selectPreferredLanguage()
		//Personal Details
		.enterFirstName("First")
		.enterMiddleName("Name")
		.enterLastName("Last")
		.selectGender()
		.selectDob()
		.selectMonth()
		.selectYear()
		.selectDate()
		.clickOccupation()
		.selectOccupation()
		.selectMaritalStatus()
		.waitOperation(3000)
		.selectCountry("93")
		.enterEmailId("email@email.com")
		.enterMobileNo("1234152632")
		.selectNationality("94")
		.enterFloorNo("10")
		.enterStreetName("main st")
		.enterArea("sholing")
		.enterPincode("600119")
		.keyboardOperation("Tab")
		.waitOperation(5000)
		.selectCity("Kanchipuram")
		.waitOperation(5000)
		.selectPostOffice("Sholinganallur S.O")
		.enterPhoneNo("123123123")
		.clickCopyResidenceToOffice()
		//Residential Address
		.officeFlatNo("20")
		.officeStreetName("main st")
		.officeArea("sholing")
		.officePincode("600119")
		.keyboardOperation("Tab")
		.waitOperation(8000)
		.officeCity("Kanchipuram")
		.waitOperation(5000)
		.officePostOffice("Sholinganallur S.O")
		.officePhoneNo("1234561231")
		.waitOperation(3000)
//		.clickTermsAndConditions();
		.keyboardOperation("Space");
		
	}
}
