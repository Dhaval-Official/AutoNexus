package testMethods;

import org.testng.annotations.Test;

public class MethodSet04 {
//S42	
	@Test (priority = 10)
	public void S42_First() {
		System.out.println("my 1st test method");
	}
	
	@Test (priority = -2147483648)
	public void S42_Last() {
		System.out.println("my 2nd test method");
	}
	
	@Test (priority = 0)
	public void S42_Mid() { 
		System.out.println("my last test method");
	}

}