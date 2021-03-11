package utils;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class SampleReport {
	
	@Test
	public void generateReport(){
		
		
		ExtentReports report = new ExtentReports("./reports/result.html",false);
		
		ExtentTest test=report.startTest("TC001", "To verify irctc sign up");
		
		test.assignAuthor("Jaya Bharati");
		test.assignCategory("smoke");
		
		
		test.log(LogStatus.PASS, "Application launched successfully");
		test.log(LogStatus.PASS, "Application launched successfully");
		test.log(LogStatus.PASS, "Application launched successfully");
		test.log(LogStatus.PASS, "Application launched successfully");
		test.log(LogStatus.PASS, "Application launched successfully");
		test.log(LogStatus.PASS, "Application launched successfully");
		test.log(LogStatus.PASS, "Application launched successfully");
		test.log(LogStatus.PASS, "Application launched successfully");
		test.log(LogStatus.PASS, "Application launched successfully");
		test.log(LogStatus.PASS, "Application launched successfully");
		test.log(LogStatus.PASS, "Application launched successfully");
		test.log(LogStatus.PASS, "Application launched successfully");
		test.log(LogStatus.PASS, "Application launched successfully");
		test.log(LogStatus.PASS, "Application launched successfully");
		
		report.endTest(test);
		
		report.flush();
		
		
	}

}
