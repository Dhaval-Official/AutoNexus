package testMethods;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MethodSet09 {

	//here test2 is dependent on test1	
	
	@Test
	public void test1() {
		System.out.println("I am 1st I'll run 1st by default");
		Assert.assertEquals("Hi", "Ho");
	}
	
	@Test(dependsOnMethods = {"test1"})
	public void test2() {
		System.out.println("I am dependent on 1st, Ideally I should Not run");	
	}
	 
	@Test(dependsOnMethods = {"test1"}, alwaysRun=true)
	public void test3() {
		System.out.println("I am dependent on 1st, but i'll run anyways");
	}
	
	@Test 
	public void test4() {
		System.out.println("I will run any ways");
	}
	
}
