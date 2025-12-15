package testSet;

import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import testBase.Base3;

public class RegistrationTest3 extends Base3 {
	// U15.107	
	// Using Logger in Base3
	
	@Test
	public void verify_registration() {
		
		HomePage hm2 = new HomePage(driver);
		
		hm2.clickMyAccount();
		hm2.clickRegister();
		
		RegistrationPage rg2 = new RegistrationPage(driver);
		
		rg2.setFirstName(getRandomString().toUpperCase());
		rg2.setlastName(getRandomString().toUpperCase());
		rg2.setEmail(getRandomString()+""+"@gmal3.1.com");
		rg2.setContact(getRandomNum());
		String pwdtemp = getRandomAlphaNumeric();
		rg2.setpwd(pwdtemp);
		rg2.setpwdConfrimation(pwdtemp);
		rg2.checkPolicy();
		rg2.clickContinue();
		
		String Actualmsg = rg2.getConfirmationMsg();

		if (Actualmsg.equalsIgnoreCase("Your Account Has Been Created!")) {
			AssertJUnit.assertTrue(true);
		} else {
			System.out.println("Test Failed");
			Assert.fail();
		}
					
	}
	
}

