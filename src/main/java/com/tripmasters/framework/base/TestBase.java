package com.tripmasters.framework.base;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static WebDriver driver;
	public static AppiumDriver<WebElement> appium_driver;

	@BeforeMethod
	// @Parameters(value = { "browser" })
	public void setUp() {
		String platform = "Windows";
		String browser = "Chrome";
		try {
			switch (browser) {
			case "Chrome": {
				
				
				DesiredCapabilities capabilities = new DesiredCapabilities();
				
				capabilities.setCapability("chromedriverExecutable","C:\\Users\\Admin\\Downloads\\Appium\\chromedriver_win32\\chromedriver_win32 (1)\\chromedriver.exe");
				
				capabilities.setCapability("platformName", "Android");
				capabilities.setCapability("deviceName", "One Plus");
				capabilities.setCapability("browserName", "Chrome");

				// URL url = new URL("http://0.0.0.0:4723/wb/hub");
				URL url = new URL("http:127.0.1.1:4723/wd/hub");
				// appium_driver = new
				// AppiumDriver<WebElement>(url,capabilities);
				driver = new AndroidDriver(url, capabilities);

				// driver = new AndroidDriver<WebElement>(new
				// URL("http://127.0.0.1:4723/wd/hub"), capabilities);
				// System.out.println("driver : "+driver);

				driver.get("https://www.tripmasters.com/");

				System.out.println(driver.getCurrentUrl());
				break;
			}
			case "Firefox": {
				WebDriverManager.firefoxdriver().setup();
			//	driver = new FirefoxDriver();
				break;
			}
			default: {
				System.out.println("Browser not met!!!!");
			}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			 driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get("https://www.tripmasters.com");

			System.out.println("browser launched with given url");
		}
		

		
	}

}
