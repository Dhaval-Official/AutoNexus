package testMethods;

import org.testng.annotations.Test;

public class MethodSet08 {

	@Test(groups= {"smoke","sanity","regression2"})
	public void S48_1() {
		System.out.println("This is S48 Method 8.1");
	}
	
	@Test(groups= {"sanity","sanity2","regression2"})
	public void S48_2() {
		System.out.println("This is S48 Method 8.2");
	}
	
	@Test(groups= {"sanity","regression2"})
	public void S48_3() {
		System.out.println("This is S48 Method 8.3");
	}
	
}
