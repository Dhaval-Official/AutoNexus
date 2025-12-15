package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BaseComponent{
	//U15.104	
		WebDriver driver;
		// Constructor
		public RegistrationPage(WebDriver driver) {
			super(driver);
		}

		// Locators
		@FindBy(xpath = "//input[@id='input-firstname']")
		WebElement firstName;

		@FindBy(xpath = "//input[@id='input-lastname']")
		WebElement lastName;

		@FindBy(xpath = "//input[@id='input-email']")
		WebElement email;

		@FindBy(xpath = "//input[@id='input-telephone']")
		WebElement telephone;

		@FindBy(xpath = "//input[@id='input-password']")
		WebElement pwd;

		@FindBy(xpath = "//input[@id='input-confirm']")
		WebElement cpwd;

		@FindBy(xpath = "//input[@name='agree']")
		WebElement policy;

		@FindBy(xpath = "//input[@value='Continue']")
		WebElement continueBtn;

		@FindBy(xpath = "//h1[text()='Your Account Has Been Created!']")
		WebElement msgConfirmation;

		// Action Methods

		public void setFirstName(String myFname) {
			firstName.sendKeys(myFname);
		}

		public void setlastName(String myLname) {
			lastName.sendKeys(myLname);
		}

		public void setEmail(String myEmail) {
			email.sendKeys(myEmail);
		}

		public void setContact(String myNumber) {
			telephone.sendKeys(myNumber);
		}

		public void setpwd(String mypwd) {
			pwd.sendKeys(mypwd);
		}

		public void setpwdConfrimation(String mypwd) {
			cpwd.sendKeys(mypwd);
		}

		public void checkPolicy() {
			policy.click();
		}

		public void clickContinue() {
			continueBtn.click();
		}

		public String getConfirmationMsg() {
			try {
				return msgConfirmation.getText();
			} catch (Exception e) {
				return e.getMessage();
			}
		}
	}
