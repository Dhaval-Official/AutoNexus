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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Base6 {
	

	public WebDriver driver;
	public Logger logger;								
	public Properties prop;											
	public FileInputStream fs;										
	
	
	@BeforeMethod(groups= {"Regression", "Sanity","Smoke"})						//OR alwaysRun = true
	public void setup() throws IOException{
		
		prop = new Properties();														
		fs = new FileInputStream("./src//test//resources//data.properties");			
		prop.load(fs); 																	
		
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
	

	@AfterMethod(alwaysRun = true)												//OR groups= {"Regression", "Sanity","Smoke"}
	public void tearDown() {
		driver.quit();
	}
}
