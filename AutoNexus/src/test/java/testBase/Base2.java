package testBase;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Base2 {
	
	//Base1 or Base DOES NOT EXIST
	
	public WebDriver driver;
	public Logger logger;
	
	@BeforeClass
	public void setup() {
		
//		logger = LogManager.getLogger();				//U15.107	//loads log4j from xml
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
		
	}
	
	public String getRandomString() {					//comes from commons-lang3 library
		return RandomStringUtils.randomAlphabetic(6);
	}
	
	public String getRandomNum() {						//comes from commons-lang3 library
		return RandomStringUtils.randomNumeric(10);
	}
	
	public String getRandomAlphaNumeric() {				//comes from commons-lang3 library
		return RandomStringUtils.randomAlphabetic(4) +"@"+ RandomStringUtils.randomNumeric(4);
	}
	

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
