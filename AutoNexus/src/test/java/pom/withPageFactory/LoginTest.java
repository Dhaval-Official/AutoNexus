package pom.withPageFactory;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class LoginTest {
	
	WebDriver driver;
	
	@BeforeClass
	public void setUp () {

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize(); 		
		driver.get("https://google.com");

	}
	
	@Test
	public void doLogin () {
		LoginPage l = new LoginPage(driver);
		l.setEmail("dhasval.8499.study@gmail.com");
		l.setPass("1234");
		l.clickOnLoginBtn();
		AssertJUnit.assertEquals(l.getWarning(), "Warning: No match for E-Mail Address and/or Password.");
		System.out.println("login Undone");
		
		
	}
	
	@Test
	public void getLinkCount() {
		LoginPage l = new LoginPage(driver);
		System.out.println("Total Links are: "+l.getLinks());
	}
	 
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
}
