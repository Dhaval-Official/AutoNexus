package testBase;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Base3 {
	
	//Using Logger
	
	public WebDriver driver;
	public Logger logger;
	
	@BeforeClass
	public void setup() {
		
		logger = LogManager.getLogger();				//U15.107	//loads log4j from xml
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
		
	}
	
	public String getRandomString() {					
		return RandomStringUtils.randomAlphabetic(6);
	}
	
	public String getRandomNum() {						
		return RandomStringUtils.randomNumeric(10);
	}
	
	public String getRandomAlphaNumeric() {				
		return RandomStringUtils.randomAlphabetic(4) +"@"+ RandomStringUtils.randomNumeric(4);
	}
	

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
