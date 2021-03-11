package pom.irctc.pages;

import wrappers.GenericWrappers;

public class PaymentPage extends GenericWrappers {

	public String transactionID=null;
	
	public PaymentPage getTransactionId(){
		transactionID=getAttributeByXpath("//*[contains(text(),'Transaction ID :')]//following::input[1]");
		return this;
		
		
	}
	
}
