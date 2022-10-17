package seleniumtests;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import seleniumtests.framework.Driver;

public class BaseTest {

	protected WebDriver driver;
	
	private static String gridUrl = "http://52.226.210.47:4444";
	
	@BeforeMethod
	public void setup() throws MalformedURLException {
		driver = new Driver().createDriver(gridUrl);
		driver.manage().window().maximize();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
