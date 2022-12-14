package cloud.grid.pageobjects;

import static cloud.grid.framework.Constants.*;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cloud.grid.framework.Pause;

public class ShoppingCart {
	
	private WebDriver driver;
	
	private By checkoutId = By.id("checkout");
	
	private Pause pause;
	
	public ShoppingCart(WebDriver driver) {
		this.driver = driver;
		
		this.pause  = new Pause();
	}
	
	public boolean isDisplayed() {
		return driver.getCurrentUrl().contains("https://www.saucedemo.com/cart.html");
	}
	
	public void goToCheckoutInformation() {
		
		pause.forTimeout(TIMEOUT);
		
		WebDriverWait wait = wait(10);
		
		WebElement checkoutButton = wait.until(ExpectedConditions.elementToBeClickable(checkoutId));
		checkoutButton.click();
		
		pause.forTimeout(TIMEOUT);
		
	}
	
	private WebDriverWait wait(int seconds) {
		return new WebDriverWait(driver, Duration.ofSeconds(seconds));
	}

}
