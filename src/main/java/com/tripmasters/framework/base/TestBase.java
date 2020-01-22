package com.tripmasters.framework.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static WebDriver driver;
	
	
	
	@BeforeMethod
	@Parameters(value={"browser"})
	public void setUp(String browser){
		try {
			switch (browser) {
			case "Chrome": {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
			}
			case "Firefox": {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
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

			System.out.println("browser launched with url launched");
		}

	}

}
