package pom.irctc.pages;

import wrappers.GenericWrappers;

public class HillRailwaysHomePage extends GenericWrappers {

	public HillTourPackageDescriptionPage clickBookNow() {
		
		clickByXpath("//a[contains(text(),' Book Now')]");
		return new HillTourPackageDescriptionPage();
		
	}
	
	
}
