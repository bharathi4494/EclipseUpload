package pom.irctc.pages;

import wrappers.GenericWrappers;

public class HillTourPackageBookingPage extends GenericWrappers{
	
	public HillTourPackageBookingPage clickTourStartingDate(String data){
		selectvaluebyXpath("//select[@name='country']/option[text()='26-DEC-19']", data);
		return this;
		
	}
	
	public HillTourPackageBookingPage selectTourStartingDate(String data){
		selectvaluebyXpath("//select[@name='boardst'/option[@value='CHENNAI CENTRAL']", data);
		return this;
		
	}
	
	public HillTourPackageBookingPage clickBoardingStation(){
		return this;
		
	}
	public HillTourPackageBookingPage selectBoardingStation(){
		return this;
		
	}
	
	public HillTourPackageBookingPage clickContinue(){
		clickByXpath("//button[contains(text(),'Continue')]");
		return this;
		
	}
	
	public HillUserLogin clickBook1(){
		clickByXpath("//button[contains(text(),'Continue')]");
		return new HillUserLogin();
		
	}
	public HillTourPackageBookingPage selectAccomodationType(String data){
		selectvaluebyXpath("//select[@id='selectID0']/option[@value='3: Object']", data);
		return this;
		
	}
	
	public HillUserLogin clickBook() {
		clickByXpath("//button[text()='Book']");
		return new HillUserLogin();
		
	}



}
