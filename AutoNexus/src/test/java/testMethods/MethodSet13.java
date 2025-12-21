package testMethods;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class MethodSet13 {
	@Test
	public void hasdAssert() {
		System.out.println("This is a Hard Assert Method");
		Assert.assertTrue(false);
		System.out.println("This line will not be called");
	}
	
	@Test
	public void softAssert() {
		SoftAssert sa = new SoftAssert();
		System.out.println("This is a Soft Assert Method");
		sa.assertTrue(false);
		System.out.println("This line will be called");
		sa.assertAll();
	}

}
