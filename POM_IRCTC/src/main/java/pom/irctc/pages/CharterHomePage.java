package pom.irctc.pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.GenericWrappers;

public class CharterHomePage extends GenericWrappers{
	
	
	public CharterHomePage(RemoteWebDriver driver, ExtentTest test){
		this.driver  =driver;
		this.test = test;
	}
	

	public CharterHomePage clickCharterEnquiryForm(){
		
		clickByXpath("//*[@id='Enquiry-tab-just']");
//		clickById("Enquiry-tab-just");
		return this;
	}
	
	public CharterHomePage enterNameOfApplicant(String data){
		
		enterByXpath("//*[@name='name']", data);
//		enterByXpath("//*[@id='Enquiry-just']/div/form/div/div[3]/input", data);
		return this;
	}
	
	public CharterHomePage enterNameOfOrganisation(String data) {
		
		enterByXpath("//*[@name='organization']", data);
//		enterByName("organization", data);
		return this;
	}
	
	public CharterHomePage enterAddress(String data){
		
		enterByXpath("//*[@name='address']", data);
//		enterByName("address", data);
		return this;
	}
	
	public CharterHomePage enterMobileNo(String data) {
		
		enterByXpath("//*[@name='mobile']", data);
//		enterByName("mobile", data);
		return this;
	}
	
	public CharterHomePage enterEmailId(String data){	
		
		enterByXpath("//*[@name='email']//preceding::input[@name = 'email']", data);
//		enterByXpath("//*[@id='Enquiry-just']/div/form/div/div[7]/input", data);
		return this;
	}
	
	public CharterHomePage selectRequestFor(String data) {
		
		selectvaluebyXpath("//*[@name='requestFor']/option [@value='Saloon Charter']", data);
//		int requestfor = Integer.parseInt(data);
//		selectIndexById("requestFor", data );
		return this;
	}
	
	public CharterHomePage enterOriginatingStation(String data){	
			
		enterByXpath("//*[@name='originStation']", data);
//		enterByName("originStation", data);
		return this;
		}
	
	public CharterHomePage enterDestinationStation(String data){	
		
		enterByXpath("//*[@name='destnStation']", data);
//		enterByName("destnStation", data);
		return this;
	}
	
	
	public CharterHomePage clickonDateOfDeparture(){
		
		clickByXpath("//table[@class='date-table']/tbody/tr[5]/td[3]/span[contains(text(),'31')]");
//		clickByName("checkInDate");
		return this;
	}

	public CharterHomePage selectDateOfDeparture(){	
		
//		clickByXpath("//*[@id='Enquiry-just']/div/form/div/div[11]/div/div/table/tbody/tr[5]/td[3]/span");
		return this;
	}
	
	public CharterHomePage clickOnDateOfArrival(){
		
		clickByXpath("(//div[@class='datepicker-days'])[2]/table/tbody/tr[5]/td[3]/span[contains(text(),'31')]");
//		clickByName("checkOutDate");
		return this;
		
	}
	
	public CharterHomePage selectDateOfArrivalBack(){	
		
		clickByXpath("//*[@id='Enquiry-just']/div/form/div/div[12]/div/div/table/tbody/tr[4]/td[3]/span");
		return this;
	}
	
	public CharterHomePage enterDurationOfTour(String data){	
		
		enterByXpath("//*[@name='durationPeriod']", data);
//		enterByName("durationPeriod", data);
		return this;
	}
	public CharterHomePage enterNumberAndTypeOfCoachRequired(String data){	
		
		enterByXpath("//*[@name='coachDetails']", data);
//		enterByName("coachDetails", data);
		return this;
	}
	public CharterHomePage enterNumberOfPassengers(String data){	
		
		enterByXpath("(//*[@name='numPassenger'])[1]", data);
//		enterByXpath("//*[@id='Enquiry-just']/div/form/div/div[15]/input",data );
		return this;
	}
	public CharterHomePage enterPurposeOfCharter(String data){	
		
		enterByXpath("(//*[@name='charterPurpose'])", data);
//		enterByXpath("//*[@id='Enquiry-just']/div/form/div/div[16]/input",data);
		return this;
	}
	public CharterHomePage enterAdditionalServicesRequired(String data){	
		
		enterByXpath("(//*[@name='services'])", data);
//		enterByName("services", data);
		return this;
	}
	
	public CharterHomePage verifyText(String data){

		verifyTextByXpath("//span[@class='ERR2' and contains (text(), 'Mobile no. not valid')]", data);
//		verifyTextByXpath("//*[@id='Enquiry-just']/div/form/div/div[6]/span", "Mobile no. not valid");
		return this;
	}
	public CharterHomePage clickOnSubmit(){	
		
		clickByXpath("(//button[@type='submit'])[1]");
//		clickByXpath("//*[@id='Enquiry-just']/div/form/div/div[19]/button");
		return this;
	}
	
	public CharterHomePage CharterPageWait(long data){
		
		sleep(data);
		return this;
	}
	
	public CharterHomePage CharterPageKeyBoardOperations(String data) {
		
		performKeyBoardOperationByXpath("//html/body", data);
		return this;
	}
	
	
	
	
	
	
	
}
