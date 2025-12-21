package testBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Base5 {
	

	public WebDriver driver;
	public Logger logger;								
	public Properties prop;											//U15.109	//Data.properties
	public FileInputStream fs;										//U15.109	//Data.properties
	
	
	@BeforeClass
	public void setup() throws IOException{
		
		prop = new Properties();														//U15.109	//Data.properties
		fs = new FileInputStream("./src//test//resources//data.properties");			//U15.109	//Data.properties
		prop.load(fs); 																	//U15.109	//Data.properties
		
		logger = LogManager.getLogger(this.getClass());	
		
		ChromeOptions options = new ChromeOptions();

	    // Disable Chrome password manager & breach detection					//Added for DDT
	    options.addArguments("--disable-notifications");
	    options.addArguments("--disable-save-password-bubble");
	    options.setExperimentalOption("prefs", Map.of(
	            "credentials_enable_service", false,
	            "profile.password_manager_enabled", false
	    ));
		
	    driver = new ChromeDriver(options);
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(prop.getProperty("baseURL"));
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
