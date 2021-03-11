package pom.irctc.pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.GenericWrappers;

public class HomePage extends GenericWrappers{
	
	
	public HomePage (RemoteWebDriver driver , ExtentTest test){
		
		this.driver = driver;
		this.test = test;
	}
	
	public RegistrationPage clickOnRegister(){
//		 clickByLink("REGISTER");	
		
		 clickByXpath(prop.getProperty("HomePage.Register.Xpath"));
		 return new RegistrationPage(driver, test); 
	}
	
	
	public HomePage clickOnStays(){
//		clickByLink("STAYS");
		
		clickByXpath(prop.getProperty("HomePage.Stays.Xpath"));
		return this;
	}
	
	
	public LoungeHomePage clickOnLounge(){
		
//		clickByXpath("/html/body/app-root/app-home/div[1]/app-header/div[2]/div[2]/div[2]/nav/ul/li[5]/ul/li[3]/a/span");
		
		clickByXpath(prop.getProperty("HomePage.Lounge.Xpath"));
		return new LoungeHomePage(driver, test);
	}
	
	
	
	
	

}
