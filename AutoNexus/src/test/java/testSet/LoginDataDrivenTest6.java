package testSet;

import java.io.IOException;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.Base6;
import utilities.DataProviders;

public class LoginDataDrivenTest6 extends Base6 {
	
	
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class,groups= {"Regression","Smoke"})
	public void verify_login_DDT(String userName, String password, String expectedResult) throws IOException {
		
		//	Landing Page
		logger.info("Clicking on Login");
		
		HomePage hm7 = new HomePage(driver);
		hm7.clickMyAccount();
		hm7.clickLogin();
		
		
//		Login Page
		logger.info("Entering Login Details");
		
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(userName);
		lp.setPassword(password);
		lp.clickLoginBtn();
		

//		My Account Page		
		logger.info("Verifying Logged In in Account Page");
		
		MyAccountPage ap = new MyAccountPage(driver);

		boolean targetPageReached = ap.isMyAccountExist();
		
		logger.info("Verifying for Invalid Result");
		if(expectedResult.equalsIgnoreCase("invalid")) {
			if(targetPageReached == true) {
				ap.clickLogoutBtn();
				AssertJUnit.assertTrue(false);
			} else {
				AssertJUnit.assertTrue(true);
			}
		}
		
		
		logger.info("Verifying for Valid Result");
		if(expectedResult.equalsIgnoreCase("valid")) {
			if(targetPageReached == true) {
				ap.clickLogoutBtn();
				AssertJUnit.assertTrue(true);
			} else {
				AssertJUnit.assertTrue(false);
			}
		}
		
		//		SoftAssert sa = new SoftAssert();
//		sa.assertTrue(ap.isMyAccountExist());		
//		//logger.info("Login Failed badlyyyyyyyyyyyyyyyyyy");
//		sa.assertAll(); 
		

		logger.info("Logged Out");
	}

}
