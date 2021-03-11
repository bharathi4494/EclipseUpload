package pom.irctc.pages;



import wrappers.GenericWrappers;

public class HillUserLogin extends GenericWrappers{

	public HillUserLogin clickGuestUserLogin (){
	clickByXpath("(//a[text()='Guest User Login'])[1]");
		return this;
	}
	
	public HillUserLogin enterEmailId(String data){
		enterByXpath("(//input[@name='email'])[1]", data);
		return this;
	}
	
	public HillUserLogin enterMobileNo(String data){
		enterByXpath("(//input[@name='mobileNo'])[1]", data);
		return this;
		
	}

	public HillTourPassengerDetailsPage clickLogInButton(){
		clickByXpath("//button[contains(text(),'Log In ')]");
		return new HillTourPassengerDetailsPage();
	}
}
