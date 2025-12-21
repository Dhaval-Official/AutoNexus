package testMethods;

import org.testng.annotations.Test;

@Test(groups = "regression")
public class MethodSet07 {


	@Test(groups= {"smoke"})
	public void S48_1() {
		System.out.println("This is S48 Method 7.1");
	}
	
	@Test(groups= {"sanity","sanity2"})
	public void S48_2() {
		System.out.println("This is S48 Method 7.2");
	}
	
	@Test(groups= {"sanity"})
	public void S48_3() {
		System.out.println("This is S48 Method 7.3");
	}
	

}
