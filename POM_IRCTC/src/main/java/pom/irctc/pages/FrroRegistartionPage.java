package pom.irctc.pages;


import wrappers.GenericWrappers;

public class FrroRegistartionPage  extends GenericWrappers{

	//Individual Registration
	
	public FrroRegistartionPage enterUserId(String data) {
		enterByXpath("//input[@id='u_id']", data);
		return this;
		
	}
	
	public FrroRegistartionPage enterPassword(String data) {
		enterByXpath("//input[@id='u_pwd']", data);
		return this;
		
	}
	
	public FrroRegistartionPage enterConfirmfPwd(String data) {
		enterByXpath("//input[@id='u_repwd']", data);
		return this;
		
	}
	
	public FrroRegistartionPage selectSecurityQuestion(String data) {
		selectvaluebyXpath("//select[@id='u_secques']/option[contains(text(),' What is the name of the street where you grew up?')]", data);
		return this;
		
	}
	
	public FrroRegistartionPage enterSecQuesAns(String data) {
		enterByXpath("//input[@name='u_secans']", data);
		return this;
		
	}
	
	public FrroRegistartionPage enterUserName(String data) {
		enterByXpath("//input[@name='u_name']", data);
		return this;
		
	}
	
	public FrroRegistartionPage selectGender(String data) {
		selectvaluebyXpath("//select[@name='u_gender']/option[@value='F']", data);
		return this;
		
	}
	
	public FrroRegistartionPage selectDOB(String data) {
		enterByXpath("//input[@id='u_dob']", data);
		return this;
		
	}
	
	public FrroRegistartionPage enterDesignation(String data) {
		enterByXpath("//input[@id='u_designation']", data);
		return this;
		
	}
	
	public FrroRegistartionPage enterUserEmailId(String data) {
		enterByXpath("//input[@id='u_emailid']", data);
		return this;
		
	}
	
	public FrroRegistartionPage enterUserMobileNo(String data) {
		enterByXpath("//input[@id='u_mobile']", data);
		return this;
		
	}
	
	public FrroRegistartionPage enterUserPhoneNo(String data) {
		enterByXpath("//input[@id='u_phone']", data);
		return this;
		
	}
	
	public FrroRegistartionPage selectNationality(String data) {
		selectvaluebyXpath("//select[@id='u_nationality']/option[@value='IND']", data);
		return this;
		
	}
	
	//Other Details
	
	public FrroRegistartionPage enterName(String data) {
		enterByXpath("//input[@id='name']", data);
		return this;
		
	}
	
	public FrroRegistartionPage enterCapacity(String data) {
		enterByXpath("//input[@id='capacity']", data);
		return this;
		
	}
	
	public FrroRegistartionPage enterAddress(String data) {
		enterByXpath("//textarea[@id='address']", data);
		return this;
		
	}
	
	public FrroRegistartionPage selectState(String data) {
		selectvaluebyXpath("//select[@id='state']/option[contains(text(),'TAMIL')]", data);
		return this;
		
	}
	
	public FrroRegistartionPage selectCity(String data) {
		selectvaluebyXpath("//select[@id='city_distr']/option[@value='4C']", data);
		return this;
		
	}
	
	public FrroRegistartionPage selectAccomodationType(String data) {
		selectvaluebyXpath("//select[@name='acco_type']/option[@value='IH']", data);
		return this;
		
	}
	
	public FrroRegistartionPage selectAccomodationGrade(String data) {
		selectvaluebyXpath("//select[@name='star_rat']/option[@value='3s']", data);
		return this;
		
	}
	
	public FrroRegistartionPage enterEmailId(String data) {
		enterByXpath("//input[@id='email']", data);
		return this;
		
	}
	
	public FrroRegistartionPage enterMobile(String data) {
		enterByXpath("//input[@id='mcontact']", data);
		return this;
		
	}
	
	public FrroRegistartionPage enterPhoneNo(String data) {
		enterByXpath("//input[@id='contact']", data);
		return this;
		
	}
	
	//Owners Details
	
	public FrroRegistartionPage enterOwnerOneName(String data) {
		enterByXpath("//input[@name='name_o']", data);
		return this;
		
	}
	
	public FrroRegistartionPage enterOwnerOneAddress(String data) {
		enterByXpath("//input[@name='address_o']", data);
		return this;
		
	}
	
	public FrroRegistartionPage selectOwnerOneState(String data) {
		selectvaluebyXpath("//select[@name='state_o']/option[@value='28']", data);
		return this;
		
	}
	
	public FrroRegistartionPage selectOwnerOneCity(String data) {
		selectvaluebyXpath("//select[@name='citydistr_o']/option[@value='24D']", data);
		return this;
		
	}
	
	public FrroRegistartionPage enterOwnerOneEmailId(String data) {
		enterByXpath("//input[@name='emailid_o']", data);
		return this;
		
	}
	
	public FrroRegistartionPage enterOwnerOnePhoneNo(String data) {
		enterByXpath("//input[@name='phoneno_o']", data);
		return this;
		
	}
	
	public FrroRegistartionPage enterOwnerOneMobileNo(String data) {
		enterByXpath("//input[@name='mobile_o']", data);
		return this;
		
	}
	
	public FrroRegistartionPage enterOwnerTwoName(String data) {
		return this;
		
	}
	
	public FrroRegistartionPage enterOwnerTwoAddress(String data) {
		return this;
		
	}
	
	public FrroRegistartionPage selectOwnerTwoState() {
		return this;
		
	}
	
	public FrroRegistartionPage selectOwnerTwoCity() {
		return this;
		
	}
	
	public FrroRegistartionPage enterOwnerTwoEmailId(String data) {
		return this;
		
	}
	
	public FrroRegistartionPage enterOwnerTwoPhoneNo(String data) {
		return this;
		
	}
	
	public FrroRegistartionPage enterOwnerTwoMobileNo(String data) {
		return this;
		
	}
	
	public FrroRegistartionPage enterOwnerThreeName(String data) {
		return this;
		
	}
	
	public FrroRegistartionPage enterOwnerThreeAddress(String data) {
		return this;
		
	}
	
	public FrroRegistartionPage selectOwnerThreeState() {
		return this;
		
	}
	
	public FrroRegistartionPage selectOwnerThreeCity() {
		return this;
		
	}
	
	public FrroRegistartionPage enterOwnerThreeEmailId(String data) {
		return this;
		
	}
	
	public FrroRegistartionPage enterOwnerThreePhoneNo(String data) {
		return this;
		
	}
	
	public FrroRegistartionPage enterOwnerThreeMobileNo(String data) {
		return this;
		
	}
	
	public FrroRegistartionPage clickAddButton(){
		clickByXpath("//input[@name='add' and @value='Add']");
		return this;
		
	}
	

	
	
	
	
}
