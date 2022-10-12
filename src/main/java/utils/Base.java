package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.HasFullPageScreenshot;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners({ AllureReportListeners.class })

public class Base {

	public static WebDriver driver;
	public Properties prop;
	public static Logger log = LogManager.getLogger(Base.class.getName());
	public static ThreadLocal<WebDriver> thisdriver = new ThreadLocal<WebDriver>();
	// K8
	// public String gridUrl="http://52.186.164.69:4444";
	// On prem Selnium 4
	public String gridUrl = "http://10.62.234.23:4444";

	@BeforeSuite
	public void cleanup() throws IOException {
		deleteFolder("allure-results");
	}

	@AfterSuite
	public void teadDownTasks() throws Exception {
		// runCMDAllure();
	}

	@BeforeMethod
	public void setup(ITestContext context) throws IOException {
		driver = initializeDriver();
		// driver.get(prop.getProperty("url"));
		context.setAttribute("WebDriver", driver);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	/**
	 * Method to initialize Driver
	 * 
	 * @return
	 * @throws IOException
	 */
	public WebDriver initializeDriver() throws IOException {

		prop = new Properties();
		String filepath = System.getProperty("user.dir") + "/src/main/resources/data.properties";
		FileInputStream fis = new FileInputStream(filepath);
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		String browserRun = prop.getProperty("browserRun");
		log.info("Browser for Test :" + browserName);
		log.info("Browser to Run :" + browserRun);
		if (browserName.equals("chrome")) {

			if (browserRun.equals("headless")) {
				WebDriverManager.chromedriver().setup();
				ChromeOptions options = new ChromeOptions();
				options.addArguments("headless");
				driver = new ChromeDriver(options);
			} else if (browserRun.equals("grid")) {
				ChromeOptions options = new ChromeOptions();
				driver = new RemoteWebDriver(new URL(gridUrl), options);
			} else {
				WebDriverManager.chromedriver().setup();

				driver = new ChromeDriver();
			}
		} else if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			if (browserRun.equals("headless")) {
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless");
				driver = new FirefoxDriver(options);
			} else if (browserRun.equals("grid")) {
				FirefoxOptions options = new FirefoxOptions();
				driver = new RemoteWebDriver(new URL(gridUrl), options);
			} else {
				driver = new FirefoxDriver();
			}
		} else if (browserName.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			if (browserRun.equals("headless")) {
				EdgeOptions options = new EdgeOptions();
				options.addArguments("headless");
				driver = new EdgeDriver(options);
			} else if (browserRun.equals("grid")) {
				EdgeOptions options = new EdgeOptions();
				driver = new RemoteWebDriver(new URL(gridUrl), options);
			} else {
				driver = new EdgeDriver();
			}

		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		thisdriver.set(driver);
		return getDriver();

	}

	public static synchronized WebDriver getDriver() {
		return thisdriver.get();
	}

	/**
	 * Method to load custom url
	 * 
	 * @param url
	 */
	public void getCustomUrl(String url) {
		driver.get(url);
	}

	/**
	 * Method to Highlight an element
	 * 
	 * @param ele
	 * @param driver
	 */
	public static void highlightElement(WebElement ele, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='2px solid red'", ele);

	}

	/**
	 * Method to take take screen shot of the page
	 * 
	 * @param testCaseName
	 * @param driver
	 * @throws IOException
	 */
	public void getElementScreenShot(String testCaseName, WebDriver driver, WebElement element) throws IOException {
		File source = element.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";
		FileUtils.copyFile(source, new File(destinationFile));

	}

	/**
	 * Method to take take screen shot of the page
	 * 
	 * @param testCaseName
	 * @param driver
	 * @throws IOException
	 */
	public void getScreenShot(String testCaseName, WebDriver driver) throws IOException {

		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";
		FileUtils.copyFile(source, new File(destinationFile));

	}

	/**
	 * Method to take take full page screen shot of the page
	 * 
	 * @param testCaseName
	 * @param driver
	 * @throws IOException
	 */
	public void getFullPageScreenShot(String testCaseName, WebDriver driver) throws IOException {
		// this is only implemented for firefox and has not yet implemented for chrom
		File source = ((HasFullPageScreenshot) driver).getFullPageScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";
		FileUtils.copyFile(source, new File(destinationFile));

	}

	/**
	 * Method to take take screen of the page and return the path of it
	 * 
	 * @param testCaseName
	 * @param driver
	 * @throws IOException
	 */
	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {

		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;

	}

	/*
	 * Method to get title
	 */
	public String getPageTitle() {
		return driver.getTitle();
	}

	/**
	 * Method to delete Folder
	 * 
	 * @param pathToDelete
	 * @throws IOException
	 */
	public void deleteFolder(String pathToDelete) throws IOException {
		String destinationFile = System.getProperty("user.dir") + "\\" + pathToDelete + "\\";
		FileUtils.deleteDirectory(new File(destinationFile));
	}

	/**
	 * Method to run CMD for Allure
	 * 
	 * @throws Exception
	 */
	public void runCMDAllure() throws Exception {
		ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c",
				"allure serve C:\\Users\\Kiran\\Documents\\AutomationProjects\\Selenium4Features\\allure-results");
		builder.redirectErrorStream(true);
		Process p = builder.start();
		BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
		String line;
		while (true) {
			line = r.readLine();
			if (line == null) {
				break;
			}
			log.info(line);
		}
	}

	/**
	 * Method to perform intentionalDelay
	 * 
	 * @param waitdelay
	 * @param count
	 * @throws Exception
	 */
	public static void intentionalWait(int waitdelay, int count) throws Exception {

		for (int i = 1; i <= count; i++) {
			Thread.sleep(waitdelay);
			log.info("Intention wait for " + i + " time");
			scrollUpDown();
		}

	}

	/**
	 * Method to perform intentionalDelay
	 * 
	 * @param waitdelay
	 * @param count
	 * @throws Exception
	 */
	public static void intentionalWaitValue() throws Exception {

		int count = 2;
		int waitDelay = 30000;
		for (int i = 1; i <= count; i++) {
			Thread.sleep(waitDelay);
			log.info("Intention wait for " + i + " time for " + waitDelay + " mili seconds");
			// scrollUpDown();
		}

	}

	public static void intentionalsleep() throws Exception {

		Thread.sleep(30000);

	}

	public static void scrollUpDown() throws Exception {
		Actions a = new Actions(driver);
		// scroll down a page
		a.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(3000);
		// scroll up a page
		a.sendKeys(Keys.PAGE_UP).build().perform();
	}

}
