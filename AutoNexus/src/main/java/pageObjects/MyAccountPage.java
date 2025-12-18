package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BaseComponent {
	// U15.110

	WebDriver driver;

	// Constructors
	public MyAccountPage(WebDriver dirver) {
		super(dirver);
	}

	// Locators
	@FindBy(xpath = "//h2[text()='My Account']")
	WebElement myAccountText;

	@FindBy(xpath = "(//a[text()='Logout'])[2]")
	WebElement logoutBtn;

	// methods
	public boolean isMyAccountExist() {
		try {
			return myAccountText.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public void clickLogoutBtn() {
		logoutBtn.click();
	}
}
