package seleniumtests.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import seleniumtests.framework.Pause;

import static seleniumtests.framework.Constants.*;

public class LoginPage {
	
	private WebDriver driver;
	
	private static String URL = "https://www.saucedemo.com/";
	
	private By usernameId = By.id("user-name");
	private By passwordId = By.id("password");
	private By loginId    = By.id("login-button");
		
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void open() {
		driver.get(URL);
	}
	
	public boolean isDisplayed() {
		return driver.getTitle().contains("Swag Labs");
	}
	
	public void logInWith(String username, String password) {
		
		Pause pause = new Pause();
		pause.forTimeout(TIMEOUT);
		
		WebDriverWait wait = wait(10);
		
		WebElement userNameTextBox = wait.until(ExpectedConditions.elementToBeClickable(usernameId));
		userNameTextBox.sendKeys(username);
		
		pause.forTimeout(TIMEOUT);
		
		WebElement passwordTextBox = wait.until(ExpectedConditions.elementToBeClickable(passwordId));
		passwordTextBox.sendKeys(password);
		
		pause.forTimeout(TIMEOUT);
		
		WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(loginId));
		loginButton.click();
		
		pause.forTimeout(TIMEOUT);
		
	}
	
	private WebDriverWait wait(int seconds) {
		return new WebDriverWait(driver, Duration.ofSeconds(seconds));
	}
	
}
