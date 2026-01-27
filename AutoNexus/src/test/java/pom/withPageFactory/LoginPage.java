package pom.withPageFactory;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	//S59: we try to login with dummny name & pwd and recevied & verify login failed error
	//with page factory approach
	
	WebDriver driver;
	
	
	//1 constructor
	LoginPage(WebDriver driver) {  
		this.driver = driver;
		PageFactory.initElements(driver, this);				//this is new
	}
	
	
	//2. locators
		//input-email
		//input-password
		//value="Login"
		//.alert
		//tagName("a")
	
	@FindBy(xpath="//input[@id='input-email']")	WebElement email;
	@FindBy(xpath="//input[@id='input-password']") WebElement pass;	
	@FindBy(xpath="//input[@value='Login']") WebElement loginBtn;	
	@FindBy(css=".alert") WebElement warning;	
	@FindBy(tagName="a") List <WebElement> links;
	
	
	//3. Action Methods
	
	public void setEmail(String userEmail) {
		email.sendKeys(userEmail);
	}
	
	public void setPass(String userPass) {
		pass.sendKeys(userPass);
	}
	
	public void clickOnLoginBtn() {
		loginBtn.click();
	}
	
	public String getWarning() { 
		return warning.getText();
	}
	
	public int getLinks() {
		return links.size();  
	}
	
	
	
	
	
}