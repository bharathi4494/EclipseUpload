package pom.irctc.pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.GenericWrappers;

public class LoungeLoginPage extends GenericWrappers {
	
	public LoungeLoginPage (RemoteWebDriver driver, ExtentTest test) {
	
		this.driver = driver;
		this.test = test;
	}
	
	public LoungeLoginPage waitOperation(long a){		
		sleep(a);
		return this;
	}
	
	
	public LoungeLoginPage keyboardOperation(String actionName){
		
		performKeyBoardOperationByXpath("//input[@formcontrolname = 'resPinCode']", actionName);
		return this;
		
	}

	public LoungeLoginPage clickGuestUserLogin (){
		
		clickByXpath("//*[contains(@id,'sign-in')]//following::a[contains(text(),'Guest User Login')]");
//		clickByXpath("/html/body/app-root/acbooklogin/main/div/section/div/div/div/div[2]/div/div/div/ul/li[2]/a");
		return this;
	}
	
	public LoungeLoginPage enterEmailId(String data){
		
		enterByXpath("//input[@name='username']//preceding::label[contains(text(),'User Name')]", data);
//		enterByXpath("//*[@id='gulogin-form']/div/div[1]/input", data);
		return this;
	}
	
	public LoungeLoginPage enterMobileNo(String data){
		
		enterByXpath("//input[@name='password']//preceding::label[contains(text(),'Your password')]", data);
		enterByName("mobileNo", data);
		return this;
		
	}

	public LoungePassengerDetailsPage clickLogInButton(){
		
		clickByXpath("//*[@id='gulogin-form']//button[@type='submit']");
		clickByXpath("//*[@id='gulogin-form']/div/div[3]/button");
		return new LoungePassengerDetailsPage(driver, test);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
