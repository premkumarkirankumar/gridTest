package seleniumtests.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import seleniumtests.framework.Pause;

public class CheckoutInformation {

	private WebDriver driver;
	
	private Pause pause;
	
	private By firstNameId  = By.id("first-name");
	private By lastNameId   = By.id("last-name");
	private By postalCodeId = By.id("postal-code");
	
	private By continueId   = By.id("continue");
	
	private static int TIMEOUT = 2;
	
	public CheckoutInformation(WebDriver driver) {
		this.driver = driver;
		
		this.pause = new Pause();
	}
	
	public boolean isDisplayed() {
		return driver.getCurrentUrl().contains("https://www.saucedemo.com/checkout-step-one.html");
	}
	
	public void enterFirstName(String firstName) {
		
		pause.forTimeout(TIMEOUT);
		
		WebDriverWait wait = wait(10);
		
		WebElement firstNameBox = wait.until(ExpectedConditions.elementToBeClickable(firstNameId));
		firstNameBox.sendKeys(firstName);
		
		pause.forTimeout(TIMEOUT);
		
	}
	
	public void enterLastName(String lastName) {
		
		pause.forTimeout(TIMEOUT);
		
		WebDriverWait wait = wait(10);
		
		WebElement lastNameBox = wait.until(ExpectedConditions.elementToBeClickable(lastNameId));
		lastNameBox.sendKeys(lastName);
		
		pause.forTimeout(TIMEOUT);
		
	}
	
	public void enterPostalCode(String postalCode) {
		
		pause.forTimeout(TIMEOUT);
		
		WebDriverWait wait = wait(10);
		
		WebElement postalCodeBox = wait.until(ExpectedConditions.elementToBeClickable(postalCodeId));
		postalCodeBox.sendKeys(postalCode);
		
		pause.forTimeout(TIMEOUT);
		
	}
	
	public void goToCheckoutOverview() {
		
		pause.forTimeout(TIMEOUT);
		
		WebDriverWait wait = wait(10);
		
		WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(continueId));
		continueButton.click();
		
		pause.forTimeout(TIMEOUT);
		
	}

	private WebDriverWait wait(int seconds) {
		return new WebDriverWait(driver, Duration.ofSeconds(seconds));
	}

}
