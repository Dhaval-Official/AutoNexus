package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BaseComponent {
	// U15.110

	WebDriver driver;

	// Constructors
	public LoginPage(WebDriver dirver) {
		super(dirver);

	}

	// Locators
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement email;

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement pass;

	@FindBy(xpath = "//input[@value='Login']")
	WebElement loginBtn;

	// methods
	public void setEmail(String userEmail) {
		email.sendKeys(userEmail);
	}

	public void setPassword(String userPass) {
		pass.sendKeys(userPass);
	}

	public void clickLoginBtn() {
		loginBtn.click();
	}

}
