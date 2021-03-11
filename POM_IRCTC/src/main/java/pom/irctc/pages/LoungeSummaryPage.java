package pom.irctc.pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.GenericWrappers;

public class LoungeSummaryPage extends GenericWrappers {

	public LoungeSummaryPage (RemoteWebDriver driver, ExtentTest test) {
		
		this.driver = driver;
		this.test = test;
	}
	
	public LoungeSummaryPage getTotalAmount(){
		
		getTextByXpath("//span[contains(text(), ' /- (Incl. of GST)')]");
//		getTextByXpath("/html/body/app-root/acsummery/main/div/section/div/div/div/div[5]/div[4]/span");
		return this;
		
	}
	
	public LoungeSummaryPage clickTermsAndConditons(){
		
		clickByXpath("//label[@class='form-check-label']");
//		clickByXpath("/html/body/app-root/acsummery/main/div/section/div/div/div/div[7]/div/label/span");
		return this;
		
	}
	
	public PaymentPage clickOnMakePayment() {
		
		clickByXpath("//button[contains(text(),'Make Payment')]");
//		clickByXpath("/html/body/app-root/acsummery/main/div/section/div/div/div/div[8]/button");
		return new PaymentPage();
	}
	
	
	
	
	
	
	
	
	
	
	
}
