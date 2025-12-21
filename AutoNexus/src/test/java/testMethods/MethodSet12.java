package testMethods;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MethodSet12 implements ITestListener{
	

	@Override  
	public void onTestStart(ITestResult result) {  
	// TODO Auto-generated method stub  
//		System.out.println("Test Started for "+result.getName());
	}  
	  
	@Override  
	public void onTestSuccess(ITestResult result) {  
	// TODO Auto-generated method stub  
		System.out.println("Pass Cases From Listener MethodSet12: "+result.getName());  
	}  
	  
	@Override  
	public void onTestFailure(ITestResult result) {  
	// TODO Auto-generated method stub  
		System.out.println("Fail Cases From Listener MethodSet12: "+result.getName());  
	}  
	  
	@Override  
	public void onTestSkipped(ITestResult result) {  
	// TODO Auto-generated method stub  
		System.out.println("Skip cases From Listener MethodSet12: "+result.getName());  
	}  
	  
	@Override  
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {  
	// TODO Auto-generated method stub  
	System.out.println("Failure of test cases and its details are : "+result.getName());  
	}  
	  
	@Override  
	public void onStart(ITestContext context) {  
	// TODO Auto-generated method stub  
		System.out.println("Starting Listeners");  
	}  
	  
	@Override  
	public void onFinish(ITestContext context) {  
	// TODO Auto-generated method stub  
		System.out.println("Finishing Listeners");
	}  
	
	
}
