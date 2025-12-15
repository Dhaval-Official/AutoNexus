package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends BaseComponent{
	// Constructor
	public HomePage(WebDriver driver) {
		super(driver);
			
	}

	// Locators
	@FindBy(xpath = "//span[normalize-space()='My Account']")
	WebElement myAccount;

	@FindBy(xpath = "//a[text()='Register']")
	WebElement register;
	
	@FindBy(xpath = "(//a[text()='Login'])[1]")		//new addition for login
	WebElement login;

	// Action Methods
	public void clickMyAccount() {
		//old ways
		//driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		myAccount.click();
	}

	public void clickRegister() {
		register.click();
	}
	
	public void clickLogin() {						//new addition for login
		login.click();
	}
}
