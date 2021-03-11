package pom.irctc.pages;

import wrappers.GenericWrappers;

public class IndianFrroHomePage extends GenericWrappers {

	public FrroRegistartionPage clickSignUpRegistration() {
		clickByXpath("(//a[contains(text(),'Sign Up (Registration)')])[1]");
		return new FrroRegistartionPage();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
