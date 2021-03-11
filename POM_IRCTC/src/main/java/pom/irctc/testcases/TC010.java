package pom.irctc.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pom.irctc.pages.IndianFrroHomePage;
import wrappers.ProjectWrappers;

public class TC010 extends ProjectWrappers {
	
	@BeforeClass
	public void beforeClass(){
		testCaseName="TC010";
		testCaseDescription="To verify Form_C_registration";
		author="Jaya Bharati";
		category="smoke";
	}
	
	@Test
	
	public void Form_C(){
		
		new IndianFrroHomePage()
			.clickSignUpRegistration()
			.enterUserId("USer")
			.enterPassword("Pwd")
			.enterConfirmfPwd("Pwd")
			.selectSecurityQuestion("")
			.enterSecQuesAns("Vijay")
			.enterUserName("Username")
			.selectGender("Female")
			.selectDOB("")
			.enterDesignation("Design")
			.enterUserEmailId("abc@abc.com")
			.enterUserMobileNo("1231212111")
			.enterUserPhoneNo("1231231236")
			.selectNationality("")
			.enterName("Nametwo")
			.enterCapacity("2")
			.enterAddress("Address")
			.selectState("")
			.selectCity("")
			.selectAccomodationType("")
			.selectAccomodationGrade("")
			.enterEmailId("email@email.com")
			.enterMobile("4152634152")
			.enterPhoneNo("132122")
			.enterOwnerOneName("one")
			.enterOwnerOneAddress("one address")
			.selectOwnerOneState("")
			.selectOwnerOneCity("")
			.enterOwnerOneEmailId("one@one.com")
			.enterOwnerOnePhoneNo("2323121212")
			.enterOwnerOneMobileNo("2020202020")
			.enterOwnerTwoName("two")
			.enterOwnerTwoAddress("two address")
			.selectOwnerTwoState()
			.selectOwnerTwoCity()
			.enterOwnerTwoEmailId("two@two.com")
			.enterOwnerTwoPhoneNo("1201201201")
			.enterOwnerTwoMobileNo("1245124512")
			.enterOwnerThreeName("three")
			.enterOwnerThreeAddress("three address")
			.selectOwnerThreeState()
			.selectOwnerThreeCity()
			.enterOwnerThreeEmailId("three@three.com")
			.enterOwnerThreePhoneNo("104104")
			.enterOwnerThreeMobileNo("3213201020");
			
		
		
		
		
		
		
		
		
	}

}
