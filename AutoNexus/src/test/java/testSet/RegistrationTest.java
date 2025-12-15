package testSet;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegistrationPage;

public class RegistrationTest {
	// U15.105	
	// Most baseline Test case with hard coded values
	
		public WebDriver driver;
		
		@BeforeClass
		public void setup() {
			
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.get("https://tutorialsninja.com/demo/");
			driver.manage().window().maximize();
			
		}
		
		@Test
		public void verify_registration() {
			
			HomePage hm = new HomePage(driver);
			
			hm.clickMyAccount();
			hm.clickRegister();
			
			RegistrationPage rg = new RegistrationPage(driver);
			
			rg.setFirstName("Justin");
			rg.setlastName("Barber");				
			rg.setEmail("Justin@gmal3.111.com");				//change me every time before running
			rg.setContact("123456789");
			rg.setpwd("12345");
			rg.setpwdConfrimation("12345");
			rg.checkPolicy();
			rg.clickContinue();
			
			String Actualmsg = rg.getConfirmationMsg();

			if (Actualmsg.equalsIgnoreCase("Your Account Has Been Created!")) {
				AssertJUnit.assertTrue(true);
			} else {
				System.out.println("Test Failed");
				Assert.fail();
			}
					
			
		}

	}
