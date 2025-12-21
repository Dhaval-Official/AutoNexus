package testMethods;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MethodSet10 {

	//here test2 is dependent on test1	
	
	@Test
	public void test1() {
		System.out.println("I am 1st I'll run 1st by default");
		Assert.assertEquals("Hi", "Ho");
	}
	
	@Test(enabled=true)
	public void test2() {
		System.out.println("I will run based on enabled being true/false");	
	}
	 	
	
	//timeOut stuff
	@Test() 
	public void test3() {
		System.out.println("I will fail instant");
		Assert.assertEquals("Hi", "Ho");
	}
	
	@Test(timeOut = 2000)
	public void test4() throws InterruptedException {

		System.out.println("I will be shown");
		Thread.sleep(5000);
		System.out.println("Due to total time space being 2000 i will not be shown");
		
	}
	
}
