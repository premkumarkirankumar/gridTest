package gridTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import utils.Base;

public class TestSeleniumSite2 extends Base  {
	
	@Description("Test to verify HomePage")
	@Test
	public void testHomePage() throws Exception {
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
	}

}
