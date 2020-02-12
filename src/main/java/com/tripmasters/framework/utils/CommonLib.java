package com.tripmasters.framework.utils;

import java.awt.Toolkit;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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

import com.tripmasters.framework.base.TestBase;

import junit.framework.Assert;

public class CommonLib extends TestBase {

	// static Logs log;
	private static WebElement element = null;
	// public static WebDriver driver = null;
	static String screenShotPath = "";
	
	/**
	 * Scroll page down to full of its height.
	 * 
	 * @author Shivam Kashyap
	 * @throws Exception
	 **/
	public static WebElement FindElementByXpath(String xpath) throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
			Logs.info("Element Found");
		} catch (Exception e) {
			Logs.error("Element Not Found");
			//Logs.error("e");
		//	element = null;
		}
		return element;
	}

	
	/**
	 * It's find the element on current page.
	 * 
	 * @author Shivam Kashyap
	 * @throws Exception
	 * @version 1
	 **/
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
			Logs.error("Something wrong with element data passed because of which element not Found.");
			//Logs.error("e");
		//	element = null;
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
	
	/**
	 * Description: It's take the screenshot of current page.
	 * 
	 * @author Kalpana
	 * @throws IOException
	 * @Version 1
	 **/

	public static String TakeScreenShot() throws IOException {

		try {
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy-h-mm-ss");
			String CurrentDate = sdf.format(date);
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

	public static String ClearAndSetValues(By FieldElement, String StringToBeEntered) throws Exception {

		try {
			WebElement element = driver.findElement(FieldElement);
			highlightElement(element);
			element.clear();
			// element.sendKeys(StringToBeEntered);
			element.sendKeys(StringToBeEntered);// Keys.TAB);
			waitForElement(3);
		} catch (Exception e) {
			Logs.error("Unable to find the element on Page");

			// e.printStackTrace();
		}
		return StringToBeEntered;
	}
	
	/**
	 * It's click on the web element using JavascriptExecutor.
	 * 
	 * @author Shivam Kashyap
	 * @throws Exception
	 * @version 1
	 **/
	public static void ClickUsingJavaScript(By FieldElement) {

		try {
			WebElement element = driver.findElement(FieldElement);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);
			waitForElement(3);
		} catch (Exception e) {
			System.out.println("Unable to click on element");
		}
	}

	public static void ClickUsingJavaScript(WebElement element) {

		try {
			highlightElement(element);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);
			waitForElement(3);
		} catch (Exception e) {
			System.out.println("Unable to click on element using Javascript Executor");
		}
	}

	public static String SelectOptionByValue(By element, String valueOfOption) {

		try {
			WebElement selectField = driver.findElement(element);
			highlightElement(selectField);
			Select option = new Select(selectField);
			option.selectByValue(valueOfOption);
			waitForElement(2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return valueOfOption;
	}

	public static String SelectOptionByText(By element, String optionText) {

		try {
			WebElement selectField = driver.findElement(element);
			highlightElement(selectField);
			Select option = new Select(selectField);
			option.selectByVisibleText(optionText);
			waitForElement(2);
		} catch (Exception e) {
			Logs.error("Unable to select element by text");
		}
		return optionText;
	}

	public static void VerifyTravellerDetails(By element, List<String> expectedTravellerInfo) {
		try {
			List<String> actualTravellerInfo = new ArrayList<String>();
			List<WebElement> tempList = driver.findElements(element);
			for (WebElement list : tempList) {
				String text = list.getText();
				actualTravellerInfo.add(text);
			}
			System.out.println("actual List:" + actualTravellerInfo);
			Assert.assertEquals(expectedTravellerInfo, actualTravellerInfo);
		} catch (Exception e) {
			Logs.error("Traveller Details are not same as expected");
		}
	}

	/**
	 * 
	 * Description :: object is present or not :: Input Parameters : String
	 * String Return Type:: Void
	 * 
	 */

	public static boolean isElementDisplayed(By element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			WebElement waitElement = wait.until(ExpectedConditions.visibilityOf(driver.findElement((element))));
			highlightElement(waitElement);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",
					waitElement);
			waitElement.isDisplayed();

			return true;

		} catch (Exception e) {
			Logs.error("Element is not displayed");
			return false;
		}
	}

	/**
	 * 
	 * Description :: To click a Element using HTML method Input Parameters ::
	 * Input Parameters : String String Return Type:: Void
	 * 
	 */

	public static void clickOnElement(By element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement waitElement = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(element)));
			highlightElement(waitElement);
			waitElement.click();
		} catch (Exception e) {
			Logs.error("Unable to click on element even after specified time");
		}
	}

	public static String getPageTitle() {
		return driver.getTitle();
	}

	public static WebElement getText(By element) {

		WebElement text = driver.findElement(element);
		try {
			highlightElement(text);

		} catch (Exception e) {

			Logs.error("Unable to find element");
		}
		return text;

	}

	public static String selectNewDateFromCalendar() {
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		System.out.println(cal.getTime());
		cal.add(Calendar.DATE, 100);
		String newDate = dateFormat.format(cal.getTime());
		String[] newDateDay = newDate.split("/");
		return newDateDay[1];
	}

	/**
	 * Scroll page down to full of its hight
	 * 
	 * @author Mrinal
	 * @throws Exception
	 **/
	public static void scrollDown() throws Exception {
		try {
			waitForElement(3);
			java.awt.Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0," + screenSize.height + ")", "");
			System.out.println("scrolled down");
		} catch (Exception e) {
			throw new Exception("Unable to scroll page");
		}
	}
	
	/**
	 * It will wait for specific time.
	 * 
	 * @author Kalpana
	 * @throws Exception
	 * @version 1
	 **/
	
	public static void waitForElement(int time)throws Exception{
		Thread.sleep(time * 1000);
		}

}
