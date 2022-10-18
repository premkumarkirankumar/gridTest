package seleniumtests.framework;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.http.ClientConfig;

public class Driver {
	
	public WebDriver createDriver(String gridUrl) throws Exception {
		
		System.setProperty("webdriver.chrome.silentOutput", "true");

		ClientConfig config = ClientConfig.defaultConfig().readTimeout(Duration.ofMinutes(20))
														  .connectionTimeout(Duration.ofMinutes(20));
		 
		ChromeOptions options = new ChromeOptions();
		options.setPlatformName("LINUX");

		try {
			WebDriver driver = RemoteWebDriver.builder()																  	
											  .oneOf(options)
											  .address(gridUrl)
											  .config(config)
											  .build();
		
			return driver;
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			
			throw new RuntimeException(e);
		}
		
	}

}
