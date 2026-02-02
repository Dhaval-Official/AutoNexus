package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BaseComponent {

	WebDriver driver;
	public BaseComponent (WebDriver dirver) {
		PageFactory.initElements(dirver, this);
	}
	
}
