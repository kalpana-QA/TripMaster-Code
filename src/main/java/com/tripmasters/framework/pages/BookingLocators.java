package com.tripmasters.framework.pages;

import org.openqa.selenium.WebElement;

import com.tripmasters.framework.utils.CommonLib;

public class BookingLocators {

	public static WebElement leavingTextbox() throws Exception {
		return CommonLib.FindElementByXpath("//input[@id='qLeaveNA']");
	}

	public static WebElement goingToTextbox() throws Exception {
		return CommonLib.FindElementByXpath("//input[contains(@id,'qNACity')]");
	}

	public static WebElement goingToTextboxSecond() throws Exception {
		return CommonLib.FindElementByXpath("//*[@id='qNACity2']");
	}

	public static WebElement addCityBtn() throws Exception {
		return CommonLib.FindElementByXpath("//span[contains(.,'Add City')]");
	}

	public static WebElement noMoreCitiesBtn() throws Exception {
		return CommonLib.FindElementByXpath("//span[contains(.,'No more cities. Continue')]");
	}

	public static WebElement continueBtn() throws Exception {
		return CommonLib.FindElementByXpath("//div[@class='dvContinueButton']//span[contains(.,'Continue')]");
	}

	public static WebElement paymentContinueBtn() throws Exception {
		return CommonLib.FindElementByXpath("//a[contains(@id,'PriceValidation')]");
	}

	public static WebElement validatingPricesPopupText() throws Exception {
		return CommonLib.FindElementByXpath("//div[@id='divLoading']//div[contains(.,'Validating prices...')]");
	}

	public static WebElement tripInclusionDetailsHeader() throws Exception {
		return CommonLib.FindElementByXpath("//span[contains(.,'TRIP INCLUSION DETAILS')]");
	}

	public static WebElement EditContinueBtn() throws Exception {
		return CommonLib.FindElementByXpath("//div[a[contains(.,'Edit Itinerary')]]//a[contains(@id,'Continue')]");
	}

	public static WebElement FirstTravelerFirstNameTxtbox() throws Exception {
		return CommonLib.FindElementByXpath(
				"//div[div[span[contains(.,'Traveler 1:')]]]//input[contains(@placeholder,'First and Middle Name')]");
	}

	public static WebElement FirstTravelerLastNameTxtbox() throws Exception {
		return CommonLib.FindElementByXpath(
				"//div[div[span[contains(.,'Traveler 1:')]]]//input[contains(@placeholder,'Last Name')]");
	}

	public static WebElement SecondTravelerFirstNameTxtbox() throws Exception {
		return CommonLib.FindElementByXpath(
				"//div[div[span[contains(.,'Traveler 2:')]]]//input[contains(@placeholder,'First and Middle Name')]");
	}

	public static WebElement SecondTravelerLastNameTxtbox() throws Exception {
		return CommonLib.FindElementByXpath(
				"//div[div[span[contains(.,'Traveler 2:')]]]//input[contains(@placeholder,'Last Name')]");
	}

	public static WebElement FirstTravelerGenderDropdown() throws Exception {
		return CommonLib.FindElementByXpath(
				"//div[div[div[span[contains(.,'Traveler 1:')]]]]//div[contains(@class,'Gender')]//select");
	}

	public static WebElement FirstTravelerDOB() throws Exception {
		return CommonLib.FindElementByXpath(
				"//div[div[div[span[contains(.,'Traveler 1:')]]]]//input[contains(@id,'txtPAX_DOB')]");
	}

	public static WebElement SecondTravelerGenderDropdown() throws Exception {
		return CommonLib.FindElementByXpath(
				"//div[div[div[span[contains(.,'Traveler 2:')]]]]//div[contains(@class,'Gender')]//select");
	}

	public static WebElement SecondTravelerDOB() throws Exception {
		return CommonLib.FindElementByXpath(
				"//div[div[div[span[contains(.,'Traveler 2:')]]]]//input[contains(@id,'txtPAX_DOB')]");
	}

	public static WebElement FormContinueBtn() throws Exception {
		return CommonLib.FindElementByXpath("//div[a[img[@name='continue_btn']]]//a");
	}

	public static WebElement USAndCanadaCreditCardsTxt() throws Exception {
		return CommonLib.FindElementByXpath("//strong[contains(.,'We only accept US and Canada credit cards')]");
	}

	public static WebElement europBestSellerslnk() throws Exception {
		return CommonLib.FindElementByXpath(
				"//div[a[div[contains(@class,'dvEachHighImg')]/following-sibling::h3[contains(.,'European BestSellers')]]]//a");
	}

	public static WebElement europBestSellerslink() {
		return CommonLib.findElement(
				"//div[a[div[contains(@class,'dvEachHighImg')]/following-sibling::h3[contains(.,'European BestSellers')]]]//a",
				"xpath");
	}

	public static WebElement europeanBestsellersHeader() throws Exception {
		return CommonLib.FindElementByXpath(
				"//div[contains(@class,'pageTitle')]/div[contains(.,'Europe - European Bestsellers')]");
	}
}
