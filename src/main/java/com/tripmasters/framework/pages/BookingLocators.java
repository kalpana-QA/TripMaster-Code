package com.tripmasters.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.tripmasters.framework.utils.CommonLib;

public class BookingLocators {
	private static By emailId = By.id("username");
    private static By leavingTextbox=By.xpath("//input[@id='qLeaveNA']");
    private static By goingToTextbox=By.xpath("//input[contains(@id,'qNACity')]");
    private By goingToTextboxSecond=By.xpath("//*[@id='qNACity2']");
    private By addCityBtn=By.xpath("//span[contains(.,'Add City')]");
    private static By noMoreCitiesBtn=By.xpath("//span[contains(.,'No more cities. Continue')]");
    private static By continueBtn=By.xpath("//div[@class='dvContinueButton']//span[contains(.,'Continue')]");
    private static By paymentContinueBtn=By.xpath("//a[contains(@id,'PriceValidation')]");
    private By validatingPricesPopupText=By.xpath("//div[@id='divLoading']//div[contains(.,'Validating prices...')]");
    private By tripInclusionDetailsHeader=By.xpath("//span[contains(.,'TRIP INCLUSION DETAILS')]");
    private static By EditContinueBtn=By.xpath("//div[a[contains(.,'Edit Itinerary')]]//a[contains(@id,'Continue')]");
    private By FirstTravelerFirstNameTxtbox=By.xpath("//div[div[span[contains(.,'Traveler 1:')]]]//input[contains(@placeholder,'First and Middle Name')]");
    private By FirstTravelerLastNameTxtbox=By.xpath("//div[div[span[contains(.,'Traveler 1:')]]]//input[contains(@placeholder,'Last Name')]");
    private By SecondTravelerFirstNameTxtbox=By.xpath("//div[div[span[contains(.,'Traveler 2:')]]]//input[contains(@placeholder,'First and Middle Name')]");
    private By SecondTravelerLastNameTxtbox=By.xpath("//div[div[span[contains(.,'Traveler 2:')]]]//input[contains(@placeholder,'Last Name')]");
    private By FirstTravelerGenderDropdown=By.xpath("//div[div[div[span[contains(.,'Traveler 1:')]]]]//div[contains(@class,'Gender')]//select");
    private By FirstTravelerDOB=By.xpath("//div[div[div[span[contains(.,'Traveler 1:')]]]]//input[contains(@id,'txtPAX_DOB')]");
    private By SecondTravelerGenderDropdown = By.xpath("//div[div[div[span[contains(.,'Traveler 2:')]]]]//div[contains(@class,'Gender')]//select");
    private By SecondTravelerDOB = By.xpath("//div[div[div[span[contains(.,'Traveler 2:')]]]]//input[contains(@id,'txtPAX_DOB')]");
    private By FormContinueBtn = By.xpath("//div[a[img[@name='continue_btn']]]//a");
    private By USAndCanadaCreditCardsTxt = By.xpath("//strong[contains(.,'We only accept US and Canada credit cards')]");
    private By europBestSellerslnk = By.xpath("//div[a[div[contains(@class,'dvEachHighImg')]/following-sibling::h3[contains(.,'European BestSellers')]]]//a");
    private By europeanBestsellersHeader = By.xpath("//div[contains(@class,'pageTitle')]/div[contains(.,'Europe - European Bestsellers')]");
    
	/**
	 * @return the emailId
	 */
	public static By getEmailId() {
		return emailId;
	}
	
	public static By getLeavingTxtbox(){
		return leavingTextbox;
	}

	public static By getgoingToTextbox(){
		return goingToTextbox;
	}

	public By getgoingToTextboxSecond(){
		return goingToTextboxSecond;
	}

	public By getaddCityBtn(){
		return addCityBtn;
	}

	public static By getnoMoreCitiesBtn(){
		return noMoreCitiesBtn;
	}

	public static By getcontinueBtn(){
		return continueBtn;
	}

	public static By getpaymentContinueBtn(){
		return paymentContinueBtn;
	}

	public By getvalidatingPricesPopupText(){
		return validatingPricesPopupText;
	}

	public By gettripInclusionDetailsHeader(){
		return tripInclusionDetailsHeader;
	}

	public static By getEditContinueBtn(){
		return EditContinueBtn;
	}

	public By getFirstTravelerFirstNameTxtbox(){
		return FirstTravelerFirstNameTxtbox;
	}

	public By getFirstTravelerLastNameTxtbox(){
		return FirstTravelerLastNameTxtbox;
	}

	public By getSecondTravelerFirstNameTxtbox(){
		return SecondTravelerFirstNameTxtbox;
	}

	public By getSecondTravelerLastNameTxtbox(){
		return SecondTravelerLastNameTxtbox;
	}

	public By getFirstTravelerGenderDropdown(){
		return FirstTravelerGenderDropdown;
	}

	public By getFirstTravelerDOB(){
		return FirstTravelerDOB;
	}

	public By getSecondTravelerGenderDropdown(){
		return SecondTravelerGenderDropdown;
	}

	public By getSecondTravelerDOB(){
		return SecondTravelerDOB;
	}

	public By getFormContinueBtn(){
		return FormContinueBtn;
	}

	public By getUSAndCanadaCreditCardsTxt(){
		return USAndCanadaCreditCardsTxt;
	}

	public By geteuropBestSellerslnk(){
		return europBestSellerslnk;
	}

	public By geteuropeanBestsellersHeader(){
		return europeanBestsellersHeader;
	}

	
}
