package gridTestCases2;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Driver {
	
	public RemoteWebDriver createDriver(String gridUrl) throws MalformedURLException {
		System.setProperty("webdriver.chrome.silentOutput", "true");

		ChromeOptions options = new ChromeOptions();
		options.setPlatformName("LINUX");
		return new RemoteWebDriver(new URL(gridUrl), options);
	}

}
