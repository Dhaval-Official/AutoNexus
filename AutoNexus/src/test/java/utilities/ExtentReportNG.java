package utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.Base7;


public class ExtentReportNG extends Base7 implements ITestListener{
	String reportName;
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	@Override
	public void onStart(ITestContext context) {
		
		//gets current time Stamp in String
		String currentTimeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		
		//setting reportName (FileName) & Location
		reportName= "Test Summary Report-" +currentTimeStamp+".html";
		sparkReporter=new ExtentSparkReporter("./reports/"+reportName); //location of the	report
		
		//setting Title of the Report & IO Look of report
		sparkReporter.config().setReportName("Codenbox Web Test Summary");
		sparkReporter.config().setTheme(Theme.DARK); //select UI look or theme type
		
		//Attaching sparkReporter to ExtentReport
		extent=new ExtentReports();
		extent.attachReporter(sparkReporter);
		
		//getting OS Info
		String osName=context.getCurrentXmlTest().getParameter("OS");
		//getting Browser Info
		String browserName=context.getCurrentXmlTest().getParameter("Browser");
		
		// generate common info in to the report. Ex: application+module+tester+environment	name,
//		extent.setSystemInfo("Key", "Value");
		extent.setSystemInfo("Application", "My Own test");
		extent.setSystemInfo("Module", "Admin");
		extent.setSystemInfo("Environment", "PRE PROD");
		extent.setSystemInfo("User Name", System.getProperty("user.name"));
		//Adding Info on OS & Browser in extent file
		extent.setSystemInfo("Operating System", osName);
		extent.setSystemInfo("Browser Name", browserName);
		
		//add groups name into the report if AVAILABLE in testng.xml file
		List <String>includedGroups=context.getCurrentXmlTest().getIncludedGroups();
		if(!includedGroups.isEmpty()) {
			extent.setSystemInfo("Groups Name", includedGroups.toString());
		
		}
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		// creating test case entries & update status of the test method
		// in to the report using ExtentTest class
		test=extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups()); 				//display groups in report IF groups exists
		test.log(Status.PASS, result.getName()+"_"+"got successfully executed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test=extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());				//display groups in report IF groups exists
		test.log(Status.FAIL, result.getName()+"_"+"got failed.The error is_"+result.getThrowable());
		try {
			String screenPath=getScreenshot(result.getName());
			test.addScreenCaptureFromPath(screenPath);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test=extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());				//display groups in report IF groups exists
		test.log(Status.SKIP, result.getName()+"_"+"got skipped");
		test.log(Status.INFO, result.getThrowable().getMessage());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onFinish(ITestContext context) {

//Build the final report
		extent.flush();														
		String reportPath=System.getProperty("./reports/")+reportName;
		File extentReport=new File(reportPath);

		try {
//			Desktop.getDesktop().browse(extentReport.toURI());				//this does NOT work on linux
			System.out.println("Extent Report generated successfully.");
		}catch (Exception e) {
			e.printStackTrace();
		}
	} 
}
