package com.tripmasters.framework.pages;

import org.openqa.selenium.By;

public class BookingLocators {
	private static By emailId = By.id("username");
    private static By leavingTextbox=By.xpath("//input[@id='qLeaveNA']");
    private static By goingToTextbox=By.xpath("//input[contains(@id,'qNACity')]");
    private static By stayingDrpdown=By.xpath("//select[@id='qSTCity1']");
    private static By selectGuestDrpdown=By.xpath("//select[@id='xiRoomsAndPax']");
    private static By selectChildDrpdown=By.xpath("//select[@id='xiChildren']");
    private static By selectAdultDrpdown=By.xpath("//select[@id='xiAdults']");
    public static By selectChildAgeDrpdown=By.xpath("//select[@id='xiChild1']");
    private static By cheaperFlightsLink=By.xpath("//a[contains(.,'Find cheaper flights')]");
    private static By selectFlightOption=By.xpath("(//img[contains(@src,'https://www.tripmasters.com/general/tripmasters/DefaultImages/Select1.png')])[1]");
    private static By goingToTextboxSecond=By.xpath("//*[@id='qNACity2']");
    private static By addCityBtn=By.xpath("//span[contains(.,'Add City')]");
    private static By noMoreCitiesBtn=By.xpath("//span[contains(.,'No more cities. Continue')]");
    private static By continueBtn=By.xpath("//div[@class='dvContinueButton']//span[contains(.,'Continue')]");
    private static By continueLink=By.xpath("//a[@id='aContWithPriceValidation']");
    private static By continueImage=By.xpath("//img[contains(@src,'https://www.tripmasters.com/general/tripmasters/DefaultImages/btn_continue.png')]");
    private static By paymentContinueBtn=By.xpath("//a[contains(@id,'PriceValidation')]");
    private static By validatingPricesPopupText=By.xpath("//div[@id='divLoading']//div[contains(.,'Validating prices...')]");
    private static By tripInclusionDetailsHeader=By.xpath("//span[contains(.,'TRIP INCLUSION DETAILS')]");
    private static By EditContinueBtn=By.xpath("//div[a[contains(.,'Edit Itinerary')]]//a[contains(@id,'Continue')]");
    private static By FirstTravelerFirstNameTxtbox=By.xpath("//div[div[span[contains(.,'Traveler 1:')]]]//input[contains(@placeholder,'First and Middle Name')]");
    private static By FirstTravelerLastNameTxtbox=By.xpath("//div[div[span[contains(.,'Traveler 1:')]]]//input[contains(@placeholder,'Last Name')]");
    private static By SecondTravelerFirstNameTxtbox=By.xpath("//div[div[span[contains(.,'Traveler 2:')]]]//input[contains(@placeholder,'First and Middle Name')]");
    private static By SecondTravelerLastNameTxtbox=By.xpath("//div[div[span[contains(.,'Traveler 2:')]]]//input[contains(@placeholder,'Last Name')]");
    private static By FirstTravelerGenderDropdown=By.xpath("//div[div[div[span[contains(.,'Traveler 1:')]]]]//div[contains(@class,'Gender')]//select");
    private static By FirstTravelerDOB=By.xpath("//div[div[div[span[contains(.,'Traveler 1:')]]]]//input[contains(@id,'txtPAX_DOB')]");
    private static By SecondTravelerGenderDropdown = By.xpath("//div[div[div[span[contains(.,'Traveler 2:')]]]]//div[contains(@class,'Gender')]//select");
    private static By SecondTravelerDOB = By.xpath("//div[div[div[span[contains(.,'Traveler 2:')]]]]//input[contains(@id,'txtPAX_DOB')]");
    private static By FormContinueBtn = By.xpath("//div[a[img[@name='continue_btn']]]//a");
    private static By USAndCanadaCreditCardsTxt = By.xpath("//strong[contains(.,'We only accept US and Canada credit cards')]");
    private static By europBestSellerslnk = By.xpath("//div[a[div[contains(@class,'dvEachHighImg')]/following-sibling::h3[contains(.,'European BestSellers')]]]//a");
    private static By europeanBestsellersHeader = By.xpath("//div[contains(@class,'pageTitle')]/div[contains(.,'Europe - European Bestsellers')]");
    private static By passportDrpdownFirstTraveller = By.xpath("//select[@id='txtPAX_Nationality1']");
    private static By passportDrpdownSecondTraveller = By.xpath("//select[@id='txtPAX_Nationality2']");
    private static By passportDrpdownThirdTraveller = By.xpath("//select[@id='txtPAX_Nationality3']");
    private static By thirdTravelerFirstNameTxtbox=By.xpath("//div[div[span[contains(.,'Traveler 3:')]]]//input[contains(@placeholder,'First and Middle Name')]");
    private static By thirdTravelerLastNameTxtbox=By.xpath("//div[div[span[contains(.,'Traveler 3:')]]]//input[contains(@placeholder,'Last Name')]");
    private static By thirdTravelerGenderDropdown = By.xpath("//div[div[div[span[contains(.,'Traveler 3:')]]]]//div[contains(@class,'Gender')]//select");
    private static By thirdTravelerDOB = By.xpath("//div[div[div[span[contains(.,'Traveler 3:')]]]]//input[contains(@id,'txtPAX_DOB')]");
    private static By verifyTraveler1Name=By.xpath("//div[@id='TravelerR1']//div[@class='cel-name' or contains(text(),'Male') or contains(text(),'01/01/1992')]");
    private static By verifyTraveler2Name=By.xpath("//div[@id='TravelerR2']//div[@class='cel-name' or contains(text(),'Male') or contains(text(),'01/01/1994')]");
    private static By verifyTraveler3Name=By.xpath("//div[@id='TravelerR3']//div[@class='cel-name' or contains(text(),'Female') or contains(text(),'01/01/1996')]");
    private static By selectChildTravelerDOB=By.xpath("//div[div[div[span[contains(.,'Traveler 2:')]]]]//input[contains(@id,'txtCPAX_DOB2')]");
    private static By selectChildTraveleraPassport=By.xpath("//select[@id='txtCPAX_Nationality2']");
    private static By selectWithoutAirButton=By.xpath("//*[@class='dvIntlFly']/child::span[text()='Without Air *']");
    private static By browseHotelslink=By.xpath("//a[contains(.,' Browse ')]");
    private static By selectFirstHotel=By.xpath("//img[contains(@src,'https://www.tripmasters.com/general/tripmasters/DefaultImages/ui-select-btn-95x25.png')][1]");
    private static By verifyTripinclusionPage=By.xpath("//div[@class='mainDiv']//span[contains(text(),'TRIP INCLUSION DETAILS')]");
    private static By firstHotel=By.xpath("(//a[@class='hotelHeadTitle'])[1]");
    private static By verifyHotel=By.xpath("//div[@id='toResize440']//a");
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
	
	public static By getstayingDrpdown(){
		return stayingDrpdown;
	}
	
	
	public static By getselectGuestDrpdown(){
		return selectGuestDrpdown;
	}
	
	public static By getcheaperFlightsLink(){
		return cheaperFlightsLink;
	}
	
	public static By getselectFlightOption(){
		return selectFlightOption;
	}
	
	public static By getgoingToTextboxSecond(){
		return goingToTextboxSecond;
	}

	public static By getpassportDrpdownFirstTraveller(){
		return passportDrpdownFirstTraveller;
	}
	
	public static By getpassportDrpdownSecondTraveller(){
		return passportDrpdownSecondTraveller;
	}
	
	public static By getpassportDrpdownThirdTraveller(){
		return passportDrpdownThirdTraveller;
	}
	public static By getaddCityBtn(){
		return addCityBtn;
	}

	public static By getnoMoreCitiesBtn(){
		return noMoreCitiesBtn;
	}
	
	public static By getthirdTravelerFirstNameTxtbox(){
		return thirdTravelerFirstNameTxtbox;
	}
	
	public static By getthirdTravelerLastNameTxtbox(){
		return thirdTravelerLastNameTxtbox;
	}
	
	public static By getthirdTravelerGenderDropdown(){
		return thirdTravelerGenderDropdown;
	}
	
	public static By getthirdTravelerDOB(){
		return thirdTravelerDOB;
	}
	public static By getcontinueImage(){
		return continueImage;
	}

	public static By getcontinueBtn(){
		return continueBtn;
	}
	
	public static By getcontinueLink(){
		return continueLink;
	}
	
	public static By getpaymentContinueBtn(){
		return paymentContinueBtn;
	}

	public static By getvalidatingPricesPopupText(){
		return validatingPricesPopupText;
	}

	public static By gettripInclusionDetailsHeader(){
		return tripInclusionDetailsHeader; 
	}

	public static By getEditContinueBtn(){
		return EditContinueBtn;
	}

	public static By getFirstTravelerFirstNameTxtbox(){
		return FirstTravelerFirstNameTxtbox;
	}

	public static By getFirstTravelerLastNameTxtbox(){
		return FirstTravelerLastNameTxtbox;
	}

	public static By getSecondTravelerFirstNameTxtbox(){
		return SecondTravelerFirstNameTxtbox;
	}

	public static By getSecondTravelerLastNameTxtbox(){
		return SecondTravelerLastNameTxtbox;
	}

	public static By getFirstTravelerGenderDropdown(){
		return FirstTravelerGenderDropdown;
	}

	public static By getFirstTravelerDOB(){
		return FirstTravelerDOB;
	}

	public static By getSecondTravelerGenderDropdown(){
		return SecondTravelerGenderDropdown;
	}

	public static By getSecondTravelerDOB(){
		return SecondTravelerDOB;
	}

	public static By getFormContinueBtn(){
		return FormContinueBtn;
	}

	public static By getUSAndCanadaCreditCardsTxt(){
		return USAndCanadaCreditCardsTxt;
	}

	public static By geteuropBestSellerslnk(){
		return europBestSellerslnk;
	}

	public static By geteuropeanBestsellersHeader(){
		return europeanBestsellersHeader;
	}

	public static By getverifyTraveler1Name(){
		return verifyTraveler1Name;
	}
	public static By getverifyTraveler2Name(){
		return verifyTraveler2Name;
	}
	public static By getverifyTraveler3Name(){
		return verifyTraveler3Name;
	}
	
	public static By getselectAdultDrpdown(){
		return selectAdultDrpdown;
	}
	public static By getselectChildDrpdown(){
		return selectChildDrpdown;
	}
	public static By getselectChildAgeDrpdown(){
		return selectChildAgeDrpdown;
	}
	public static By getselectChildTravelerDOB(){
		return selectChildTravelerDOB;
	}
	
	public static By getpassportDrpdownSecondChildTraveller(){
		return selectChildTraveleraPassport;
	}
	

	public static By getWithoutAirButton() {
		return selectWithoutAirButton;
	}
	public static By getBrowseHotelsLink() {
		return browseHotelslink;
	}
	public static By getselectFirstHotel() {
		return selectFirstHotel;
	}
	public static By toVerifyTripinclusionPage() {
		return  verifyTripinclusionPage;
	}
	public static By getFirstHotel() {
		return firstHotel;
	}
	public static By getExpectedHotel() {
		return verifyHotel;
	}
}
