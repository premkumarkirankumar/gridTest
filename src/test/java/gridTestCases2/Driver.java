package gridTestCases2;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.http.ClientConfig;

public class Driver {
	
	public WebDriver createDriver(String gridUrl) throws MalformedURLException {
		System.setProperty("webdriver.chrome.silentOutput", "true");

		ClientConfig config = ClientConfig.defaultConfig().readTimeout(Duration.ofMinutes(10))
														  .connectionTimeout(Duration.ofMinutes(10));
		 
		ChromeOptions options = new ChromeOptions();
		options.setPlatformName("LINUX");
		
		//return new RemoteWebDriver(new URL(gridUrl), options);
		
		WebDriver driver = RemoteWebDriver.builder()																  	
				 			   		      .oneOf(options)
				 						  .address(gridUrl)
				 						  .config(config)
				 						  .build();
		
		return driver;
	}

}
