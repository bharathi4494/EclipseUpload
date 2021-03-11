package pom.irctc.pages;

import wrappers.GenericWrappers;

public class FtrUserRegistrationPage extends GenericWrappers{

	
	//Create new user Profile
	
	public FtrUserRegistrationPage enterUserId(String data){
		enterByXpath("//input[@id='userId']", data);
		return this;	
	}
	
	public FtrUserRegistrationPage enterPwd(String data){
		enterByXpath("//input[@id='password']", data);
		return this;
		
	}
	 public FtrUserRegistrationPage enterCnfPwd(String data){
		 enterByXpath("//input[@id='cnfPassword']", data);
		return this;
		 
	 }
	
	public FtrUserRegistrationPage clickSecurityQues(String data){
		selectvaluebyXpath("//select[@id='secQstn']/option[@value='2']", data);
		return this;
		
	}
	
	public FtrUserRegistrationPage selectSecurityQues(String data){
		
		return this;
		
	}
	
	public FtrUserRegistrationPage enterSecurityAns(String data){
		enterByXpath("//input[@id='secAnswer']", data);
		return this;
		
	}
	
	public FtrUserRegistrationPage clickDob() {
		clickByXpath("//input[@id='dateOfBirth']");
		return this;
		
	}
	
	public FtrUserRegistrationPage clickDobYear(){
		clickByXpath("//select[@class='ui-datepicker-year']/option[@value='1994']");
		return this;
		
	}
	
	public FtrUserRegistrationPage clickDobMonth() {
		
		clickByXpath("//select[@class='ui-datepicker-month']/option[@value='3']");
		return this;
		
	}
	
	public FtrUserRegistrationPage clickGender(){
		clickByXpath("//input[@value='F' and @id='gender1']");
		return this;
		
	}
	
	public FtrUserRegistrationPage clickMaritalStatus(){
		clickByXpath("//input[@value='UnMarried' and @id='maritalStatus1']");
		return this;
	}
	
	public FtrUserRegistrationPage enterEmailId(String data) {
		
		enterByXpath("//input[@id='email']", data);
		return this;
		
	}
	
	public FtrUserRegistrationPage selectOccupation(String data){
		selectvaluebyXpath("//select[@id='occupation']//option[@value='Professional']", data);
		return this;
	}
	
	public FtrUserRegistrationPage enterFirstName(String data){
		 	 	enterByXpath("//input[@id='fname']", data);
		return this;
		
	}
	
	public FtrUserRegistrationPage enterMiddleName(String data){
		enterByXpath("//input[@id='mname']", data);
		return this;
		
	}
	
	public FtrUserRegistrationPage enterLastName(String data){
		enterByXpath("//input[@id='lname']", data);
		return this;
		
	}
	
	public FtrUserRegistrationPage selectNationality(String data){
		selectvaluebyXpath("//select[@id='natinality']/option[@value='94']", data);
		return this;
		
	}
	
	//Residential Address Details
	
	public FtrUserRegistrationPage enterFlatNo(String data){
		enterByXpath("//input[@id='flatNo']", data);
		return this;
		
	}
	
	public FtrUserRegistrationPage enterStreetName(String data){
		enterByXpath("//input[@id='street']", data);
		return this;
		
	}
	
	public FtrUserRegistrationPage enterArea(String data){
		enterByXpath("//input[@id='area']", data);
		return this;
		
	}
	
	public FtrUserRegistrationPage clickCountryName() {
		enterByXpath("//select[@id='country']/option[@value='94']", author);
		return this;
		
	}
	
	public FtrUserRegistrationPage selectCountry(String data) {
		
		return this;
		
	}
	
	public FtrUserRegistrationPage enterMobile(String data) {
		enterByXpath("//input[@id='mobile']", data);
		return this;
		
	}
	
	public FtrUserRegistrationPage enterPincode(String data){
		enterByXpath("//input[@id='pincode']", data);
		return this;
	}
	
	public FtrUserRegistrationPage selectPostOffice(String data){
		selectvaluebyXpath("//select[@id='postOffice']/option[@value='Sholinganallur S.O']", data);
		return this;
	}
	
	//Communication address 
	
	public FtrUserRegistrationPage enterCommunicationFlatNo(String data){
		enterByXpath("//input[@id='flatNoOffice']", data);
		return this;
		
	}
	
	public FtrUserRegistrationPage enterCommunicationStreetName(String data){
		return this;
		
	}
	
	public FtrUserRegistrationPage enterCommunicationArea(String data){
		return this;
		
	}
	
	public FtrUserRegistrationPage clickCommunicationCountryName() {
		return this;
		
	}
	
	public FtrUserRegistrationPage enterCommunicationMobile(String data) {
		return this;
		
	}
	
	public FtrUserRegistrationPage enterCommunicationPincode(String data){
		return this;
	}
	
	public FtrUserRegistrationPage selectCommunicationPostOffice(String data){
		return this;
	} 
	
	
	
	
}
