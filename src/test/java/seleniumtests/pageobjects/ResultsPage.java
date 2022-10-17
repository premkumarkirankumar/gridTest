package seleniumtests.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import seleniumtests.framework.Pause;

public class ResultsPage {

	private WebDriver driver;
	
	private By addToCartBackPackId    = By.id("add-to-cart-sauce-labs-backpack");
	private By addToCartBikeId        = By.id("add-to-cart-sauce-labs-bike-light");
	private By addToCartTeaShirtId    = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
	private By addToCartJacketId      = By.id("add-to-cart-sauce-labs-fleece-jacket");
	
	private By shoppingCartXpath      = By.xpath("//a[@class = 'shopping_cart_link']");
	
	private By shoppingCartCountXpath = By.xpath("//span[@class = 'shopping_cart_badge']");
	
	private Pause pause;
	
	public ResultsPage(WebDriver driver) {
		this.driver = driver;
		
		this.pause = new Pause();
	}
	
	public boolean isDisplayed() {
		return driver.getCurrentUrl().contains("https://www.saucedemo.com/inventory.html");
	}
	
	public void addBackPackToCart() {
		
		pause.forTimeout(1);
		
		WebDriverWait wait = wait(10);
		
		WebElement addToCartBackPackButton = wait.until(ExpectedConditions.elementToBeClickable(addToCartBackPackId));
		addToCartBackPackButton.click();
		
		pause.forTimeout(1);
		
	}
	
	public void addBikeToCart() {
		
		pause.forTimeout(1);
		
		WebDriverWait wait = wait(10);
		
		WebElement addToCartBikeButton = wait.until(ExpectedConditions.elementToBeClickable(addToCartBikeId));
		addToCartBikeButton.click();
		
		pause.forTimeout(1);
		
	}
	
	public void addTeaShirtToCart() {
		
		pause.forTimeout(1);
		
		WebDriverWait wait = wait(10);
		
		WebElement addToCartTeaShirtButton = wait.until(ExpectedConditions.elementToBeClickable(addToCartTeaShirtId));
		addToCartTeaShirtButton.click();
		
		pause.forTimeout(1);
		
	}
	
	public void addJacketToCart() {
		
		pause.forTimeout(1);
		
		WebDriverWait wait = wait(10);
		
		WebElement addToCartJacketButton = wait.until(ExpectedConditions.elementToBeClickable(addToCartJacketId));
		addToCartJacketButton.click();
		
		pause.forTimeout(1);
		
	}
	
	public void goToShoppingCart() {
		
		pause.forTimeout(1);
		
		WebDriverWait wait = wait(10);
		
		WebElement shoppingCartLink = wait.until(ExpectedConditions.elementToBeClickable(shoppingCartXpath));
		shoppingCartLink.click();
		
		pause.forTimeout(1);
		
	}
	
	public int productCount() {

		pause.forTimeout(1);
		
		WebDriverWait wait = wait(10);
		
		WebElement shoppingCartLabel = wait.until(ExpectedConditions.elementToBeClickable(shoppingCartCountXpath));
		String shoppingCartText = shoppingCartLabel.getText();
		
		pause.forTimeout(1);
		
		return Integer.parseInt(shoppingCartText);
	}
	
	private WebDriverWait wait(int seconds) {
		return new WebDriverWait(driver, Duration.ofSeconds(seconds));
	}
	
	
}
