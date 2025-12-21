package testMethods;

import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.Test;

public class MethodSet14 implements IRetryAnalyzer{

	int counter = 0;
	int retryLimit = 3;
	
	//decides how many time test needs to be rerun
	@Override
	public boolean retry(ITestResult result) {
		
		if(counter < retryLimit) {
			counter++;
			return true; 
		}
		
		
		return false;
	}

}
