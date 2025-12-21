package testMethods;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MethodSet01 {
//Extra for Priority check
	
	@Test (priority = 10)
	public void hello2() {
		System.out.println("my 1st test method");
	}
	
	@Test (priority = -2147483648)
	public void demo2() {
		System.out.println("my 2nd test method");
	}
	
	@Test (priority = 0)
	public void demo3() { 
		System.out.println("my last test method");
	}
	
	@BeforeTest
	public void beforeAlltest() {
		System.out.println("I am before Test");
	}
	
	@AfterTest
	public void aftertests() {
		System.out.println("I am after the Test");
	}
	
}
