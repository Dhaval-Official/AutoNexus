package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BaseComponent {

	WebDriver driver;
	public BaseComponent (WebDriver dirver) {
		this.driver = driver;
		PageFactory.initElements(dirver, this);
	}
	
}
