package com.tripmasters.framework.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



import com.tripmasters.framework.base.TestBase2;
import com.tripmasters.framework.pages.BookingLocators;

import junit.framework.Assert;


public class CommonLib extends TestBase2{

	static Logs log;
	private static WebElement element = null;
	//public static WebDriver driver = null;
	static String screenShotPath = "";
	
	public static WebElement FindElementByXpath(String xpath) throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
			log.info("Element Found");
		} catch (Exception e) {
			log.info("Element Not Found");
			log.error("e");
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
				log.info("Element Not Found");
			}
		} catch (Exception e) {
			log.info("Something wrong with element data passed because of which element not Found.");
			log.error("e");
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
			log.info("In takeScreenShot " + fnfe.getMessage());
			
			log.info("File not found" + fnfe);
		} catch (IOException e) {
			log.info("In takeScreenShot " + e.getMessage());
			
		} catch (Exception e) {
			log.info("In takeScreenShot " + e.getMessage());
			
		}
		return screenShotPath;
	}
	
	
	public static String ClearAndSetValues(By FieldElement, String StringToBeEntered)throws Exception {
		WebElement element=driver.findElement(FieldElement);
		try {
			highlightElement(element);
			element.clear();
			//element.sendKeys(StringToBeEntered);
			element.sendKeys(StringToBeEntered);//Keys.TAB);
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return StringToBeEntered;
	}

	public static void ClickUsingJavaScript(By FieldElement){
		WebElement element=driver.findElement(FieldElement);;
		try {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);
			Thread.sleep(4000);
		} catch (Exception e) {
			System.out.println("Unable to click on element");
		}
	}
	
	public static String SelectOptionByValue(By element, String valueOfOption) {
		WebElement selectField=driver.findElement(element);
		try {
			Select option = new Select(selectField);
			option.selectByValue(valueOfOption);
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return valueOfOption;
	}
	
	public static String SelectOptionByText(By element, String optionText) {
		WebElement selectField=driver.findElement(element);
		try {
			Select option = new Select(selectField);
			option.selectByVisibleText(optionText);
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return optionText;
	}
	
	public static void VerifyTravellerDetails(By element,List<String> expectedTravellerInfo){
		List<String>actualTravellerInfo=new ArrayList<String>();
		List<WebElement>tempList=driver.findElements(element);
		for(WebElement list:tempList){
			String text=list.getText();
			actualTravellerInfo.add(text);
		}
		System.out.println("actual List:"+ actualTravellerInfo);
		Assert.assertEquals(expectedTravellerInfo, actualTravellerInfo);
		
     	//Assert.assertTrue(expectedTravellerInfo.contains(actualTravellerInfo));
	}
	
}
