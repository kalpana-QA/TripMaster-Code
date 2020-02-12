package com.tripmasters.framework.base;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.tripmasters.framework.utils.JsonDataReader;
import com.tripmasters.framework.utils.Logs;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase2 {
	private static String chromeDriverFilePath = System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe";
	public static WebDriver driver;
	private DesiredCapabilities capabilities;
	private URL url;
	private boolean flag = false;
	private static Logs log = new Logs();
	protected static String platform;

	//GenerateReport gn;
	//@BeforeClass
	@BeforeMethod(alwaysRun=true)
	// @Parameters(value = { "browser" })
	public void setUp() throws FileNotFoundException, IOException, ParseException {
		//gn = new GenerateReport();
		 platform = JsonDataReader.getJSONData("Platform");
		String browser = JsonDataReader.getJSONData("Browser");
		try {
			switch (platform) {
			case "Windows":
				if (browser.equalsIgnoreCase(("Chrome"))) {
					System.out.println("chromeDriverFilePath : "+ chromeDriverFilePath);
					System.setProperty("webdriver.chrome.driver", chromeDriverFilePath);
					//WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
					driver.manage().window().maximize();
					log.info("ChromeDriver instantiated for " + platform + " platform.");
					flag = true;

				} else if (browser.equalsIgnoreCase("Firefox")) {

					WebDriverManager.firefoxdriver().setup();
					//driver = new FirefoxDriver();
					log.info("FirefoxDriver instantiated for " + platform + " platform.");
					flag = true;

				} else {
					log.error("Browser doesn't found!!!! for " + platform + " platfrom");
					System.err.println("Browser doesn't found!!!! for windows platfrom");
				}
				break;
			case "Mobile":
				if (browser.equalsIgnoreCase("Chrome")) {
					capabilities = new DesiredCapabilities();

					
					System.out.println("chromeDriverFilePath : "+chromeDriverFilePath);
					capabilities.setCapability("chromedriverExecutable", chromeDriverFilePath);
					capabilities.setCapability("platformName", "Android");
					capabilities.setCapability("platformVersion", "10");
					capabilities.setCapability("deviceName", "One Plus");
					capabilities.setCapability("browserName", "Chrome");

					url = new URL("http:127.0.1.1:4723/wd/hub");

					driver = new AndroidDriver<MobileElement>(url, capabilities);
					
					log.info(browser + " AndroidDriver instantiated for " + platform + " platform.");
					flag = true;

				} else {
					log.error("Browser doesn't found!!!! for mobile platform");
					System.err.println("Browser doesn't found!!!! for mobile platform");
				}
				break;
			case "iOS":
				if (browser.equalsIgnoreCase("Safari")) {
					capabilities = new DesiredCapabilities();
					capabilities.setCapability("deviceName", "iPhone");
					capabilities.setCapability("platformName", "iOS");
					capabilities.setCapability("platfromVersion", "9.1");
					capabilities.setCapability(CapabilityType.BROWSER_NAME, "Safari");
					//IOSDriver
					url = new URL("http:127.0.1.1:4723/wd/hub");
					driver = new IOSDriver<IOSElement> (url,capabilities);
					System.out.println("Safari browser launched on iOS");
					flag=true;

				} else {
					log.error("browser doesn't found!!!!!!!!!!!");
					System.err.println("browser doesn't found!!!!!!!!");
				}
				break;

			default:
				log.error("Platform doesn't found!!!!!!!!!!!");
				System.err.println("Platform doesn't found!!!!!!!!!!!");
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				driver.manage().deleteAllCookies();
				driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				driver.get(JsonDataReader.getJSONData("URL"));
				log.info("The given URL launch successfully for " + platform + " platform and " + browser
						+ " browser!!!!!!!!!!!!");
				System.out.println("browser launched with given url");
			//	driver.quit();
				int time = (int) System.nanoTime();
				System.out.println("nano time is: " + time);
			}

		}

		/*
		 * if (platform.equals("Windows")) { if (browser.equals("Chrome")) {
		 * 
		 * WebDriverManager.chromedriver().setup(); driver = new ChromeDriver();
		 * 
		 * } else if (browser.equals("Firefox")) {
		 * 
		 * WebDriverManager.firefoxdriver().setup(); driver = new
		 * FirefoxDriver();
		 * 
		 * } else { System.out.println("Browser doesn't found!!!!"); } } else if
		 * (platform.equals("Mobile")) {
		 * 
		 * if (browser.equals("Chrome")) { DesiredCapabilities capabilities =
		 * new DesiredCapabilities();
		 * 
		 * capabilities.setCapability("chromedriverExecutable",
		 * "/TripMasters/Drivers/chromedriver.exe");
		 * 
		 * capabilities.setCapability("platformName", "Android");
		 * capabilities.setCapability("deviceName", "One Plus");
		 * capabilities.setCapability("browserName", "Chrome");
		 * 
		 * url = new URL("http:127.0.1.1:4723/wd/hub");
		 * 
		 * driver = new AndroidDriver<MobileElement>(url, capabilities);
		 * 
		 * driver.get("https://www.tripmasters.com/");
		 * 
		 * System.out.println(driver.getCurrentUrl()); }
		 * 
		 * } else if (platform.equals("IOS")) { if (browser.equals("Safari")) {
		 * 
		 * } } else { System.out.println("Platform doesn't found!!!!!!!!"); }
		 */

	}
	
	


	@AfterMethod(alwaysRun=true)
	public static  void tearDown() {
		//gn.extent.flush();
		//driver.quit();
		//GenerateReport2.startReport(null, null);
		//GenerateReport2.getResult(null);
		if(driver != null){
			log.info("Closing browser after TestClass");
//            driver.close();
        }else{
        	log.error("Driver is null at AfterClass (TestBase)");
        }

	}

}
