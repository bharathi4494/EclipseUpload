package pom.irctc.pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.GenericWrappers;

public class RegistrationPage extends GenericWrappers{

	
	public RegistrationPage (RemoteWebDriver driver, ExtentTest test) {
		
		this.driver = driver;
		this.test = test;
		
	}
	//Login details
	
	public RegistrationPage enterUserName(String data){
//		 enterById("userName", data);
		enterByXpath(prop.getProperty("RegistrationPage.UserName.Xpath"), data);
		
		 return this;
	}
	
	
	public RegistrationPage enterPassword(String data){
//		 enterById("usrPwd", data);
		 
		enterByXpath("//input[@id='usrPwd']", data); 
		 return this;
	}
	
	
	public RegistrationPage enterConfirmPassword(String data){
//		 enterById("cnfUsrPwd", data);
		 
		enterByXpath("//input[@id='cnfUsrPwd']", data);
		 return this;
	}
	
	public RegistrationPage clickSecurityQuestion() {
		
//		clickByXpath("//*[@id='divMain']/div/app-user-registration/div[2]/div/div[2]/div[4]/form/div[5]/div[2]/p-dropdown/div/label");
		
		clickByXpath("//label[text()='Select Security Question']");
		
		return this;
	}
	
	public RegistrationPage selectSecurityQuestion(){
		
//		clickByXpath("//*[@id='divMain']/div/app-user-registration/div[2]/div/div[2]/div[4]/form/div[5]/div[2]/p-dropdown/div/div[4]/div/ul/li[3]");
		
		clickByXpath("//span[text()='Who was your Childhood hero?']");
		return this;
	}
	
	public RegistrationPage selectSecurityAnswer(String data){
//		enterByXpath("//*[@id='divMain']/div/app-user-registration/div[2]/div/div[2]/div[4]/form/div[5]/div[4]/input", data);
		
		enterByXpath("//input[@formcontrolname='secAns']", data);
		return this;
	}
		
	public RegistrationPage clickPreferredLanguage(){
	
//		clickByXpath("//*[@id='divMain']/div/app-user-registration/div[2]/div/div[2]/div[4]/form/div[6]/div[2]/p-dropdown/div/label");
		
		clickByXpath("//label[text()='Select Preferred Language']");
		return this;
		
	}
	
	public RegistrationPage selectPreferredLanguage(){
//		clickByXpath("//*[@id='divMain']/div/app-user-registration/div[2]/div/div[2]/div[4]/form/div[6]/div[2]/p-dropdown/div/div[4]/div/ul/li[1]/span");
		clickByXpath("//span[text()='English']");
		return this;
	}
	
	//Personal details
	
	public RegistrationPage enterFirstName(String data){
//		enterById("firstName", data);
		enterByXpath("//input[@id='firstName']", data);
		return this;
	}
	
	public RegistrationPage enterMiddleName(String data) {
//		enterById("middleName", data);
		enterByXpath("//input[@id='middleName']", data);
		return this;
	}
	
	public RegistrationPage enterLastName(String data){
//		enterById("lastname", data);
		enterByXpath("//input[@id='lastname']", data);
		return this;
	}
	
	public RegistrationPage selectGender() {
//		clickById("F");
		clickByXpath("//input[@id='F' and @value='F']");
		return this;
	}
	
	
	public RegistrationPage selectDob(){
		
		clickByXpath("//span[@class='ng-tns-c14-10 ui-calendar']");
		 return this;
	}
	
	public RegistrationPage selectMonth(){
		
		clickByXpath("//select[contains(@class,'ui-datepicker-month')]//option[(contains(text(),'April')) ]");
		return this;
		
	}
	
	public RegistrationPage selectYear(){
		
		clickByXpath("//select[contains(@class,'ui-datepicker-year')]//option[(contains(text(),'1994')) ]");
		return this;
			
		}
	
	
	public RegistrationPage selectDate(){
		clickByXpath("//span[@class='ng-tns-c14-10 ui-calendar']//tbody/tr[2]/td[2]");
		return this;
	
}

	
	public RegistrationPage clickOccupation(){
		
		clickByXpath("//label[contains(text(),'Select Occupation')]");
//		clickByXpath("//*[@id='divMain']/div/app-user-registration/div[2]/div/div[2]/div[4]/form/div[10]/div[4]/p-dropdown/div/label");
		return this;
	}
	
	public RegistrationPage selectOccupation(){
		
		clickByXpath("//span [contains(text(),'PRIVATE')]");
//		clickByXpath("//*[@id='divMain']/div/app-user-registration/div[2]/div/div[2]/div[4]/form/div[10]/div[4]/p-dropdown/div/div[4]/div/ul/li[4]/span");
		return this;
		
	}
	
	public RegistrationPage selectMaritalStatus(){
		
		clickByXpath("//input [@formcontrolname = 'martitalS' and @value='U']");
//		clickByXpath("//*[@id='divMain']/div/app-user-registration/div[2]/div/div[2]/div[4]/form/div[11]/div[2]/label[2]/input");
		return this;
		
	}
	
	public RegistrationPage selectCountry(String data){
		
		
//		selectvaluebyXpath("//*[@id='divMain']/div/app-user-registration/div[2]/div/div[2]/div[4]/form/div[12]/div[2]/select", data);
		return this;
		
	}
	
	public RegistrationPage enterEmailId(String data){
		
		enterByXpath("//input[@id='email']", data);
//		enterById("email", data);
		return this;
		
	}
	public RegistrationPage enterMobileNo(String data){
		
		enterByXpath("//input[@name='mobile']", data);
//		enterById("mobile", data);
		return this;
		
	}
	
	public RegistrationPage selectNationality(String data){
		
		selectvaluebyXpath("//select[@formcontrolname = 'nationality']", data);
//		selectvaluebyXpath("/html/body/app-root/app-home/div[2]/div/app-user-registration/div[2]/div/div[2]/div[4]/form/div[14]/div[5]/select", data);
		return this;
		
	}
	
	// Residential Address
	
	public RegistrationPage enterFloorNo(String data){
		
		enterByXpath("//*[@id='resAddress1']", data);
//		enterById("resAddress1", data);
		return this;
		
	}
	
	public RegistrationPage enterStreetName(String data){
		
		enterByXpath("//*[@id='resAddress2']", data);
//		enterById("resAddress2", data);
		return this;
		
	}
	
	public RegistrationPage enterArea(String data){
		
		enterByXpath("//*[@id='resAddress3']", data);
//		enterById("resAddress3", data);
		return this;
		
	}
	
	public RegistrationPage enterPincode(String data){
		
		
		enterByXpath("//*[@name='resPinCode']", data);
//		enterByXpath("//*[@id='divMain']/div/app-user-registration/div[2]/div/div[2]/div[4]/form/div[17]/div[4]/input", data);
		return this;
		
	}
	
	public RegistrationPage enterState(String data){
		
		enterByXpath("//*[@name='resState']", data);
//		enterById("resState", data);
		return this;
		
	}
	
	public RegistrationPage selectCity(String data){
		
		selectvaluebyXpath("//*[@formcontrolname='resCity']", data);
//		enterById("resCity", data);
		return this;
		
	}
	
	public RegistrationPage clickPostOffice(){
		
		clickByXpath("//*[@formcontrolname='resPostOff']");
		return this;
		
	}
		
	public RegistrationPage selectPostOffice(String data){	
		selectvaluebyXpath("//*[@formcontrolname='resPostOff']", data);
//		enterById("resPostOff", data);
		return this;
		
	}
	
	public RegistrationPage enterPhoneNo(String data){
		
		enterByXpath("//input[@id ='resPhone']", data);
//		enterById("resPhone", data);
		return this;
		
	}
	
	public RegistrationPage clickCopyResidenceToOffice(){
		
		clickByXpath("//input[@formcontrolname ='officeSameAsRes' and @value='N']");
//		clickByXpath("//*[@id='divMain']/div/app-user-registration/div[2]/div/div[2]/div[4]/form/div[20]/div[3]/input");
		return this;
		
	}
	
	public RegistrationPage officeFlatNo(String data){
		
		enterByXpath("//*[@id='offAddress1' ]", data);
//		enterById("offAddress1", data);
		return this;
		
	}
	
	public RegistrationPage officeStreetName(String data){
		
		enterByXpath("//*[@id='offAddress2' ]", data);
//		enterById("offAddress2", data);
		return this;
		
	}

	public RegistrationPage officeArea(String data){
		
		enterByXpath("//*[@id='offAddress3' ]", data);
//		enterById("offAddress3", data);
		return this;
		
	}

	public RegistrationPage officePincode(String data){
	
		enterByXpath("//*[@id='offPinCode' ]", data);
//		enterById("offPinCode", data);
		return this;
	
	}
	
	public RegistrationPage officeCity(String data){
		 	
		selectvaluebyXpath("//select[@formcontrolname='offCity']", data);
//		 int city = Integer.parseInt(data);
//		 selectIndexByXpath("//*[@id='divMain']/div/app-user-registration/div[2]/div/div[2]/div[4]/form/div[20]/div[5]/div[2]/select", data);
		 return this;
	}
	
	public RegistrationPage officePostOffice(String data){
		
		selectvaluebyXpath("//select[@formcontrolname='offPostOff']",data);
//		int post = Integer.parseInt(data);
//		selectIndexByXpath("//*[@id='divMain']/div/app-user-registration/div[2]/div/div[2]/div[4]/form/div[20]/div[5]/div[4]/select", data);
		return this;	
	}
	
	public RegistrationPage officePhoneNo(String data){
		
		enterByXpath("//input[@id='offPhone' ]", data);
//		enterById("offPhone", data);
		return this;
	}
	
	public RegistrationPage clickTermsAndConditions(){
		
		clickByXpath("//*[@type='checkbox' and @formcontrolname = 'termCondition' ]");
//		clickByXpath("//*[@id='divMain']/div/app-user-registration/div[2]/div/div[2]/div[4]/form/div[22]/div/input");
		return this;
	}
	
	public RegistrationPage waitOperation(long a){		
		sleep(a);
		return this;
	}
	
	
	public RegistrationPage  keyboardOperation(String actionName){
		
		performKeyBoardOperationByXpath("//input[@formcontrolname = 'resPinCode']", actionName);
		return this;
		
	}
	
	
	
	
	
}
