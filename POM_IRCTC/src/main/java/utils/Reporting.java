package utils;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public abstract class Reporting {
	
	public static ExtentReports report;
	public ExtentTest test;
	
	public String testCaseName,testCaseDescription;
	
	public String author,category;
	
	public void startReport(){
		report = new ExtentReports("./reports/result.html",false);
	}
	
	public void startTest(String testName,String description){
		test=report.startTest(testName, description);
		test.assignAuthor(author);
		test.assignCategory(category);
	}
	
	public abstract long takeSnap();
	
	public void reportStep(String details, String status, boolean snap){
		long snapNumber=1;
		if(snap){
		snapNumber=takeSnap();
		
		if(status.equalsIgnoreCase("pass")){
			test.log(LogStatus.PASS, details+test.addScreenCapture(".././reports/Screenshots/"+snapNumber+".png"));
		}else if(status.equalsIgnoreCase("fail")){
			test.log(LogStatus.FAIL, details+test.addScreenCapture(".././reports/Screenshots/"+snapNumber+".png"));
		}else if(status.equalsIgnoreCase("info")){
			test.log(LogStatus.INFO, details+test.addScreenCapture(".././reports/Screenshots/"+snapNumber+".png"));
		}else if(status.equalsIgnoreCase("WARN")){
			test.log(LogStatus.WARNING, details+test.addScreenCapture(".././reports/Screenshots/"+snapNumber+".png"));
		}
		}else{
			if(status.equalsIgnoreCase("pass")){
				test.log(LogStatus.PASS, details);
			}else if(status.equalsIgnoreCase("fail")){
				test.log(LogStatus.FAIL, details);
			}else if(status.equalsIgnoreCase("info")){
				test.log(LogStatus.INFO, details);
			}else if(status.equalsIgnoreCase("WARN")){
				test.log(LogStatus.WARNING, details);
			}
		}
	}
	
	public void reportStep(String details, String status){
		
		reportStep(details, status, true);
		
	}
	
	
	
	public void endTest(){
		report.endTest(test);
	}
	
	public void endReport(){
		report.flush();
	}
	
}
