package pom.irctc.pages;

import wrappers.GenericWrappers;

public class FtrHomePage extends GenericWrappers {
	
		public FtrUserRegistrationPage clickFtrNewUserSignUp(){
			
			clickByXpath("//a[contains(text(),'New User? Signup')]");
//			clickByLink("New User? Signup");
			return new FtrUserRegistrationPage();
			
		}
	
	
}
