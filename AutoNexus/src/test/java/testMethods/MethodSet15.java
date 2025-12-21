package testMethods;

import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.Test;

public class MethodSet15 {

	@Test
	public void test1() {
		System.out.println("I will not fail");
		
	}
	
	@Test(retryAnalyzer=testMethods.MethodSet14.class)
	public void test2() {
		System.out.println("I will fail the number limit mentioned in retryAnalyzer");
		Assert.assertEquals("Hi", "Ho");
	}
	
	 	
}
