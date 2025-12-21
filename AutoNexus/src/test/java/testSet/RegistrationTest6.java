package testSet;

import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import testBase.Base5;
import testBase.Base6;

public class RegistrationTest6 extends Base6 {
	// U16.115	
	// Using Logger from Base5 
	//
	
	@Test(groups= {"Regression", "Sanity","Smoke"})
	public void verify_registration() {
		
		logger.info("****Starting Registration Test****");
		
		HomePage hm3 = new HomePage(driver);
		
		logger.info("****Clicking my account Test****");
		hm3.clickMyAccount();
		
		logger.info("****Clicking register link Test****");
		hm3.clickRegister();
		
		RegistrationPage rg3 = new RegistrationPage(driver);
		
		logger.info("****Entering Registraton Details Test****");
		rg3.setFirstName(getRandomString().toUpperCase());
		rg3.setlastName(getRandomString().toUpperCase());
		rg3.setEmail(getRandomString()+""+"@gmal3.1.com");
		rg3.setContact(getRandomNum());
		String pwdtemp = getRandomAlphaNumeric();
		rg3.setpwd(pwdtemp);
		rg3.setpwdConfrimation(pwdtemp);
		rg3.checkPolicy();
		rg3.clickContinue();
		
		String Actualmsg = rg3.getConfirmationMsg();

		logger.info("****Verify Account Created Test****");
		if (Actualmsg.equalsIgnoreCase("Your Account Has Been Created!")) {
			AssertJUnit.assertTrue(true);
		} else {
			System.out.println("Test Failed");
			Assert.fail();
		}
					
	}
	
}

