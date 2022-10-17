package seleniumtests.pageobjects;

import org.openqa.selenium.WebDriver;

public class CheckoutComplete {

	private WebDriver driver;
	
	public CheckoutComplete(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean isDisplayed() {
		return this.driver.getCurrentUrl().contains("https://www.saucedemo.com/checkout-complete.html");
	}
	
}
