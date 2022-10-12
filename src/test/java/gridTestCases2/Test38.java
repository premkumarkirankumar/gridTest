package gridTestCases2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test38 {
	
	private WebDriver driver;

	@Parameters("gridUrl")
	@Test
	public void testSeleniumPage(String gridUrl) throws Exception {
		
		driver = new Driver().createDriver(gridUrl);
		driver.manage().window().maximize();

		driver.get("https://selenium.dev/");
		
		WebElement l = driver.findElement(By.tagName("body"));
		
		System.out.println("Text content: " + l.getText());
		
		driver.quit();

	}

	

}
