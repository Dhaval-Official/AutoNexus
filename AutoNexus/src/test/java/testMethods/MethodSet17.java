package testMethods;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MethodSet17 {
	@Test
	public void test1() {
		System.out.println("I will not fail");
		
	}
	
	@Test(retryAnalyzer=testMethods.MethodSet14.class)
	public void test2() {
		System.out.println("This is test2 (Suppose to fail)");
		Assert.assertEquals("Hi", "Ho");
	}
	
	
	//if u have 100 methods you could NOT annotate all methods with  (retryAnalyzer=test.MethodSet14.class)
	
	
	@Test
	public void test3() {
		System.out.println("This is test3");
		
	}
	
	@Test
	public void test4() {
		System.out.println("This is test4 (Suppose to fail)");
		Assert.assertEquals("Hi", "Ho");
		
	}
	
	@Test
	public void test5() {
		System.out.println("This is test5 (Suppose to fail)");
		Assert.assertEquals("Hi", "Ho");
		
	}
}
