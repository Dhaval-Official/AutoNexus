package pom.withoutPageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;





public class LoginPage {
	//S58: we try to login with dummny name & pwd and recevied & verify login failed error
	//without page factory approach
	
	WebDriver driver;
	
	
	//1. constructor
	LoginPage(WebDriver driver) {
		this.driver = driver;
	
	}
		
	
	//2. locators
		//input-email
		//input-password
		//value="Login"
		//.alert
		//tagName("a")
	
	By email = By.id("input-email");
	By pass = By.id("input-password");
	By login = By.xpath("//input[@value='Login']");
	By warning = By.cssSelector(".alert");
	By links = By.tagName("a");
	
	
	//3. Action Methods
	
	public void setEmail(String userEmail) {
		driver.findElement(email).sendKeys(userEmail);
	}
	
	public void setPass(String userPass) {
		driver.findElement(pass).sendKeys(userPass);
	}
	
	public void clickOnLoginBtn() {
		driver.findElement(login).click();
	}
	
	public String getWarning() { 
		return driver.findElement(warning).getText();
	}
	
	public int getLinks() {
		return driver.findElements(links).size(); 
	}
	
	
	
}
	