package pom.irctc.pages;

public class HotelBookingDetailsSummary {
	
	public HotelBookingDetailsSummary clickTermsAndConditions(){
		return this;
	}
	
	public HotelBookingDetailsSummary  clickPaymentPage() {
		return this;
	}
	
	public HotelBookingDetailsSummary enterOtpNo(String data) {
		return this;
	}
	
	public PaymentPage  clickOtpVerify() {
		return new PaymentPage();
	}
	
	

}
