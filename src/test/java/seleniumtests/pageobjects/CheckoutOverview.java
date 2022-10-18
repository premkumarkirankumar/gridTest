package seleniumtests.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import seleniumtests.framework.Pause;

public class CheckoutOverview {
	
	private WebDriver driver;
	
	private Pause pause;
	
	private By finishId = By.id("finish");
	
	private static int TIMEOUT = 2;
	
	public CheckoutOverview(WebDriver driver) {
		this.driver = driver;
		
		this.pause = new Pause();
	}
	
	public boolean isDisplayed() {
		return driver.getCurrentUrl().contains("https://www.saucedemo.com/checkout-step-two.html");
	}
	
	public void finishCheckout() {
		
		pause.forTimeout(TIMEOUT);
		
		WebDriverWait wait = wait(10);
		
		WebElement finishButton = wait.until(ExpectedConditions.elementToBeClickable(finishId));
		finishButton.click();
		
		pause.forTimeout(TIMEOUT);
		
	}

	private WebDriverWait wait(int seconds) {
		return new WebDriverWait(driver, Duration.ofSeconds(seconds));
	}

}
 