package gridTestCases3;

import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import utils.Base;
import utils.RetryCommand;

public class Test2SeleniumSite1   {
	public static WebDriver driver;
	//public String gridUrl="http://10.62.234.23:4444";
	
	@Description("Test to verify HomePage")
	@Parameters("gridUrl")
	@Test
	public void testSeleniumPage(String gridUrl) throws Exception {
		ChromeOptions options = new ChromeOptions();
		//RetryCommand retryCommand = new RetryCommand(5, 10);
		//RemoteWebDriver driver = retryCommand.execute(() -> new RemoteWebDriver(new URL(gridUrl), options));
		for ( int i = 1; i<=10; i++ ) {		
		    System.out.println("Checking for Driver Instance in : "+i+" Iteration");
			driver = new RemoteWebDriver(new URL(gridUrl), options);
			System.out.println(driver.toString());
			if (driver!=null) {
				break;
			}
			Base.intentionalsleep();
		}
		
		driver = new RemoteWebDriver(new URL(gridUrl), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));		
		driver.manage().timeouts().setScriptTimeout(Duration.ofSeconds(300));

		System.setProperty("webdriver.chrome.silentOutput", "true");
		driver.get("https://selenium.dev/");
		System.out.println("Url loaded");
		System.out.println("Intentional Wait");
		Base.intentionalWaitValue();
	    WebElement l =driver.findElement(By.tagName("body"));
	    System.out.println("Intentional Wait");
	    Base.intentionalWaitValue();
	    System.out.println("Text content: "+ l.getText());
	    driver.manage().window().maximize();
	    System.out.println("Intentional Wait");
	    Base.intentionalWaitValue();
	    driver.quit();
	}

}