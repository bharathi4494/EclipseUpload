package pom.irctc.pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.GenericWrappers;

public class LoungeHomePage extends GenericWrappers {
	
	public LoungeHomePage (RemoteWebDriver driver , ExtentTest test){
		
		this.driver = driver;
		this.test = test;
	}
	
	public LoungeHomePage switchToNextWindow(){
		switchToLastWindow();
		return this;
	}
	
	public HotelHomePage clickIrctcHotels(){
		
		return new HotelHomePage();
	}

	public LoungeHomePage clickOnMenu(){
		
		clickByXpath("/html/body/app-root/homeheader/nav/div/div[2]/a[3]/i");
		return this;
	}
	
	public FtrHomePage clickBookCoach() {
		
		clickByLink("Book Your Coach/Train");
		return new FtrHomePage();
	}
	
	public CharterHomePage clickCharter() {
		
		clickByLink("Charter");
		return new CharterHomePage(driver, test);
	}
	
	public HillRailwaysHomePage clickHillRailways() {
		
		clickByLink("//a[text() = 'Hill Railways']");
		return new HillRailwaysHomePage();
	}
	
	public LoungeHomePage selectStationName(String data){
		
		selectvaluebyXpath("//select[@name = 'city']", data);
//		selectValueByName("city", data);
		return this;	
	}
	
	public LoungeHomePage selectNoOfPassengers(String data){
		
		selectvaluebyXpath("//select[@name='selPassangers']/option[@value='3']", data);
//		selectValueByName("selPassangers", data);
		return this;
	}
	
	public LoungeHomePage clickCheckInDate(){
		clickByXpath("//*[@class='date-table']/tbody//following::*[contains(text(),'31')]");
		clickByName("acservicecheckindate");
		return this;
	}
	
	public LoungeHomePage selectCheckInDate(String date){
		
		//clickByXpath("/html/body/app-root/accommodation/div/div/div/div/div/div/div[2]/form/div/div[4]/div/div/table/tbody/tr[5]/td[3]/span");
		clickByXpath("//span[text()='"+date+"']");
		return this;
	}
	
	public LoungeHomePage selectCheckInTime(String data){
		
		clickByXpath("//select[@name='checkInTime' ]/option[contains(text(),'04:00')]");
//		selectVisibileTextByName("checkInTime", data);
		return this;
	}
	
	public LoungeHomePage selectDuration(String data){
		
		clickByXpath("//select[@name='checkOutTime' ]/option[contains(text(),'20:00')]");
//		selectVisibileTextByName("checkOutTime", data);
		return this;
	}
	 
	public LoungeLoginPage clickOnBook(){
		
		clickByXpath("//button[contains(text(),'Book')]");
//		clickByXpath("/html/body/app-root/accommodation/div/div/div/div/div/div/div[2]/form/div/div[12]/button[2]");
		return new LoungeLoginPage(driver, test);
		
	}
	
	public LoungeHomePage waitOperation(long a){		
		sleep(a);
		return this;
	}
	
	
	public LoungeHomePage keyboardOperation(String actionName){
		
		performKeyBoardOperationByXpath("//input[@formcontrolname = 'resPinCode']", actionName);
		return this;
		
	}
	
	
	

}
