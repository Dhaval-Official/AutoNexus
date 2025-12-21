package testMethods;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MethodSet05 {
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("I am before Suite");	
	}
	
	@AfterSuite
	public void afterallSuite() {
		System.out.println("I am after all Suite");	
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("I am before Test");	
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("I am after Test");	
	}
	
	@BeforeClass
	public void beforeclass() {
		System.out.println("I am before all Class here");	
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("I am after all Class here");	
	}
	
	@BeforeMethod 
	public void beforMyyMethods() {
		System.out.println("I will be before everyone in my class------------------");	
	}
	
	@AfterMethod
	public void afterMyyMethods() {
		System.out.println("I will be After everyone in my class-------------------");	
	}
	
//these methods make BAClass & BAMethod run if these are gone (@Test) BAClass & BAMethod makes no sense
	@Test
	public void S44_47() {
		System.out.println("This is a Dummy Method1");
	}
	
	@Test
	public void Extra() {
		System.out.println("This is a Dummy Method2");
	}
	
}
