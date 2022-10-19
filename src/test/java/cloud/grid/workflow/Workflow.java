package cloud.grid.workflow;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import cloud.grid.pageobjects.CheckoutComplete;
import cloud.grid.pageobjects.CheckoutInformation;
import cloud.grid.pageobjects.CheckoutOverview;
import cloud.grid.pageobjects.LoginPage;
import cloud.grid.pageobjects.ResultsPage;
import cloud.grid.pageobjects.ShoppingCart;

public class Workflow {
	
	private WebDriver driver;
	
	public Workflow(WebDriver driver) {
		this.driver = driver;
	}
	
	public void purchaseProducts() {

		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.open();
		assertTrue(loginPage.isDisplayed());
		
		loginPage.logInWith("standard_user", "secret_sauce");
		
		ResultsPage resultsPage = new ResultsPage(driver);
		assertTrue(resultsPage.isDisplayed());
		
		resultsPage.addBackPackToCart();
		resultsPage.addBikeToCart();
		resultsPage.addTeaShirtToCart();
		resultsPage.addJacketToCart();
		
		assertEquals(resultsPage.productCount(), 4);
		
		resultsPage.goToShoppingCart();
		
		ShoppingCart cart = new ShoppingCart(driver);
		assertTrue(cart.isDisplayed());
		
		cart.goToCheckoutInformation();
		
		CheckoutInformation checkoutInformation = new CheckoutInformation(driver);

		checkoutInformation.enterFirstName("first name");
		checkoutInformation.enterLastName("last name");
		checkoutInformation.enterPostalCode("v1a2a2");
		checkoutInformation.goToCheckoutOverview();
		
		CheckoutOverview checkoutOverview = new CheckoutOverview(driver);
		assertTrue(checkoutOverview.isDisplayed());
		
		checkoutOverview.finishCheckout();
		
		CheckoutComplete checkoutComplete = new CheckoutComplete(driver);
		assertTrue(checkoutComplete.isDisplayed());
		
		System.out.println("\n" + methodName() + "\n");
		
	}
	
	private String methodName() {
		StackTraceElement stackTraceElement = new Throwable().getStackTrace()[2];
		
        return stackTraceElement.getClassName() + " - " + stackTraceElement.getMethodName(); 
	}

}

