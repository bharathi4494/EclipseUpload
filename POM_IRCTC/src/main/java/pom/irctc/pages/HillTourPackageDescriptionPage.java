package pom.irctc.pages;

import wrappers.GenericWrappers;

public class HillTourPackageDescriptionPage extends GenericWrappers{

	public HillTourPackageBookingPage clickNextBookNow() {
		clickByXpath("//a[contains(text(),'Book Now')]");
		return new HillTourPackageBookingPage();
		
	}

	
	
	
}
