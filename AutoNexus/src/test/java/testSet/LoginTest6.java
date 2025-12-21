package testSet;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.Base6;

public class LoginTest6 extends Base6 {
	// U16.115
	// Using Logger from Base6 
	// 
	@Test(groups= {"Regression"})
	public void verifyLogin() throws IOException {
		
		logger.info("Clicking on Login");
		HomePage hm6 = new HomePage(driver);
		
		hm6.clickMyAccount();
		hm6.clickLogin();
		
		
		logger.info("Entering Login Details");
		LoginPage lp = new LoginPage(driver);
		
		prop = new Properties();
		fs = new FileInputStream("./src//test//resources//data.properties");			//will connect with file
		prop.load(fs); 	
		
		lp.setEmail(prop.getProperty("myEmail"));
		lp.setPassword(prop.getProperty("myPassword"));
		lp.clickLoginBtn();
		
		
		logger.info("Verifying Logged In in Account Page");
		MyAccountPage ap = new MyAccountPage(driver);
		
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(ap.isMyAccountExist());		
		//logger.info("Login Failed badlyyyyyyyyyyyyyyyyyy");
		sa.assertAll(); 
		
		ap.clickLogoutBtn();
		logger.info("Logged Out");
			
		
	}
	
}

