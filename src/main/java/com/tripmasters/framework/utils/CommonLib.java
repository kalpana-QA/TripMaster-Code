package com.tripmasters.framework.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tripmasters.framework.base.TestBase;


public class CommonLib extends TestBase {


	private static WebElement element = null;
	//public static WebDriver driver = null;
	static String screenShotPath = "";
	
	public static WebElement FindElementByXpath(String xpath) throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
			Logs.info("Element Found");
		} catch (Exception e) {
			Logs.info("Element Not Found");
			Logs.error("e");
			element = null;
		}
		return element;
	}
	
	public static WebElement findElement(String locatorString, String typeOfLocator) {
		try {
			if (typeOfLocator.equalsIgnoreCase("xpath")) {
				element = driver.findElement(By.xpath(locatorString));
				highlightElement(element);
			} else if (typeOfLocator.equalsIgnoreCase("id")) {
				element = driver.findElement(By.id(locatorString));
				highlightElement(element);
			} else if (typeOfLocator.equalsIgnoreCase("cssSelector")) {
				element = driver.findElement(By.cssSelector(locatorString));
				highlightElement(element);
			} else if (typeOfLocator.equalsIgnoreCase("linkText")) {
				element = driver.findElement(By.linkText(locatorString));
				highlightElement(element);
			} else if (typeOfLocator.equalsIgnoreCase("name")) {
				element = driver.findElement(By.name(locatorString));
				highlightElement(element);
			} else if (typeOfLocator.equalsIgnoreCase("className")) {
				element = driver.findElement(By.className(locatorString));
				highlightElement(element);
			} else if (typeOfLocator.equalsIgnoreCase("tagName")) {
				element = driver.findElement(By.tagName(locatorString));
				highlightElement(element);
			} else if (typeOfLocator.equalsIgnoreCase("partialLinkText")) {
				element = driver.findElement(By.partialLinkText(locatorString));
				highlightElement(element);
			} else {
				Logs.info("Element Not Found");
			}
		} catch (Exception e) {
			Logs.info("Something wrong with element data passed because of which element not Found.");
			Logs.error("e");
			element = null;
		}
		return element;
	}
	
	public static void highlightElement(WebElement element) throws Exception {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element,
					"color: black; border: 2px solid red;");
		} catch (Exception e) {
			
		}
	}

	
	public static String TakeScreenShot() throws IOException {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy-h-mm-ss");
		String CurrentDate = sdf.format(date);
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			screenShotPath = System.getProperty("user.dir") + "\\" + "defectScreenShots\\" + CurrentDate + ".jpeg";
			FileUtils.copyFile(scrFile, new File(screenShotPath));
			String base = System.getProperty("user.dir") + "/defectScreenShots";
			screenShotPath = new File(base).toURI().relativize(new File(screenShotPath).toURI()).getPath();
			
		} catch (FileNotFoundException fnfe) {
			Logs.info("In takeScreenShot " + fnfe.getMessage());
			
			Logs.info("File not found" + fnfe);
		} catch (IOException e) {
			Logs.info("In takeScreenShot " + e.getMessage());
			
		} catch (Exception e) {
			Logs.info("In takeScreenShot " + e.getMessage());
			
		}
		return screenShotPath;
	}
	
	
	public static void ClearAndSetValues(By FieldElement, String StringToBeEntered)throws Exception {
		WebElement element=driver.findElement(FieldElement);
		try {
			highlightElement(element);
			element.clear();
			//element.sendKeys(StringToBeEntered);
			element.sendKeys(StringToBeEntered);//Keys.TAB);
			
		} catch (Exception e) {
			clickUsingJavaScript(FieldElement);
			element.sendKeys(StringToBeEntered);
			element.click();
		}	
	}

	public static void clickUsingJavaScript(By FieldElement){
		//WebElement element=
				driver.findElement(FieldElement).click();
		/*try {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);
		} catch (Exception e) {
			System.out.println("Unable to click on element");
		}*/
	}
	
	public static void checkPageIsReady() throws Exception {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		long wt = 3000;
		for (int i = 0; i < 30; i++) {
			try {
				Thread.sleep(wt);
			} catch (InterruptedException e) {
				
			}

			if (js.executeScript("return document.readyState").toString().equals("complete")) {
				System.out.println("Page is ready to work with");
				break;
			}
		}
	}
}
