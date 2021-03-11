package pom.irctc.pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.GenericWrappers;

public class LoungePassengerDetailsPage extends GenericWrappers {
	
	public LoungePassengerDetailsPage(RemoteWebDriver driver, ExtentTest test) {
		
		this.driver = driver;
		this.test = test;
	}

	public LoungePassengerDetailsPage selectGst(String data){
		
		selectvaluebyXpath("//select[@name='gstGet']/option[@value='No']", data);
//		selectValueByName("gstGet", data);
		return this;
	}
	
	public LoungePassengerDetailsPage enterGstNo(String data){
		
		enterByXpath("//*[@name='gstNo']", data);
	//	enterByName("gstNo", data);
		return this;
	}
	
	public LoungePassengerDetailsPage enterPassengerOneName(String data){
		
		enterByXpath("//*[contains(text(),'Passenger Details')]//following::tbody/tr[1]/td[2]", data);
//		enterByXpath("/html/body/app-root/acpassangers/main/div/section/form/div/div/div/div[4]/div[2]/table/tbody/tr[1]/td[2]/input", data);
		return this;
	}
	
	public LoungePassengerDetailsPage enterPassengerOneAge(String data){
		
		enterByXpath("//*[contains(text(),'Passenger Details')]//following::tbody/tr[1]/td[3]", data);
//		enterByXpath("/html/body/app-root/acpassangers/main/div/section/form/div/div/div/div[4]/div[2]/table/tbody/tr[1]/td[3]/input", data);
		return this;
	}
	
	public LoungePassengerDetailsPage selectPassengerOneGender(String data){
		
		selectvaluebyXpath("//*[contains(text(),'Passenger Details')]//following::tbody/tr[1]/td[4]//select/option[@value='Female']", data);
//		enterByXpath("//*[contains(text(),'Passenger Details')]//following::tbody/tr[1]/td[4]//select/option[@value='Female']", data);
//		selectvaluebyXpath("/html/body/app-root/acpassangers/main/div/section/form/div/div/div/div[4]/div[2]/table/tbody/tr[1]/td[4]/select", data);
		return this;
	}
	
	public LoungePassengerDetailsPage enterPassengerTwoName(String data){
		enterByXpath("//*[contains(text(),'Passenger Details')]//following::tbody/tr[2]/td[2]", data);
//		enterByXpath("/html/body/app-root/acpassangers/main/div/section/form/div/div/div/div[4]/div[2]/table/tbody/tr[2]/td[2]/input", data);
		return this;
	}
	
	public LoungePassengerDetailsPage enterPassengerTwoAge(String data){
		
		enterByXpath("//*[contains(text(),'Passenger Details')]//following::tbody/tr[2]/td[3]", data);
//		enterByXpath("/html/body/app-root/acpassangers/main/div/section/form/div/div/div/div[4]/div[2]/table/tbody/tr[2]/td[3]/input", data);
		return this;
	}
	
	public LoungePassengerDetailsPage selectPassengerTwoGender(String data) {

		selectvaluebyXpath("//*[contains(text(),'Passenger Details')]//following::tbody/tr[2]/td[4]//select/option[@value='Male']", data);
//		selectvaluebyXpath("/html/body/app-root/acpassangers/main/div/section/form/div/div/div/div[4]/div[2]/table/tbody/tr[2]/td[4]/select", data);
		return this;
	}
	
	public LoungePassengerDetailsPage enterPassengerThreeName(String data){
		
		enterByXpath("//*[contains(text(),'Passenger Details')]//following::tbody/tr[3]/td[2]", data);
//		enterByXpath("/html/body/app-root/acpassangers/main/div/section/form/div/div/div/div[4]/div[2]/table/tbody/tr[3]/td[2]/input",data);
		return this;
	}
	
	public LoungePassengerDetailsPage enterPassengerThreeAge(String data){
		
		enterByXpath("//*[contains(text(),'Passenger Details')]//following::tbody/tr[3]/td[3]", data);
//		enterByXpath("/html/body/app-root/acpassangers/main/div/section/form/div/div/div/div[4]/div[2]/table/tbody/tr[3]/td[3]/input", data);
		return this;
	}
	
	public LoungePassengerDetailsPage selectPassengerThreeGender(String data) {

		selectvaluebyXpath("//*[contains(text(),'Passenger Details')]//following::tbody/tr[3]/td[4]//select/option[@value='Female']", data);
//		selectvaluebyXpath("/html/body/app-root/acpassangers/main/div/section/form/div/div/div/div[4]/div[2]/table/tbody/tr[3]/td[4]/select", data);
		return this;
	}
	
	public LoungePassengerDetailsPage selectState(String data) {
	
		selectvaluebyXpath("//select[@name='state' ]/option[@value='TAMIL NADU'] ", data);
//		selectvaluebyXpath("/html/body/app-root/acpassangers/main/div/section/form/div/div/div/div[5]/div[4]/select", data);
		return this;
	
	}

	
	public LoungeSummaryPage clickSubmit(){
		
		clickByXpath("//*[@type='submit'][1]");
		return new LoungeSummaryPage(driver, test) ;
	}







}