package com.tripmasters.framework.pageActions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.tripmasters.framework.base.PageBase;
import com.tripmasters.framework.base.TestBase;
import com.tripmasters.framework.pageLocators.BookingLocators;
import com.tripmasters.framework.pageLocators.HomePageLocators;
import com.tripmasters.framework.reports.Logs;

public class BookingPageAction extends PageBase {

	public BookingPageAction(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public  void FillBasicBookingDetails(String leavingFrom, String destination, String stayingTime,
			String guestInfo) throws Exception {
		ClearAndSetValues(BookingLocators.getLeavingTxtbox(), leavingFrom);
		Logs.info("User entered '" + leavingFrom + "' into leaving from field");
		ClearAndSetValues(BookingLocators.getgoingToTextbox(), destination);
		Logs.info("User entered '" + destination + "' into Going to from field");
		SelectValueFromCalendar();
		SelectStayingTime(stayingTime);
		ClickUsingJavaScript(BookingLocators.getnoMoreCitiesBtn());
		SelectGuestDetails(guestInfo);
		Logs.info("User entered guest info '" + guestInfo + "'");
	}

	public  void SelectStayingTime(String stayingTime) {

		SelectOptionByValue(BookingLocators.getstayingDrpdown(), stayingTime);
		Logs.info("User entered '" + stayingTime + "' nights staying time");
	}

	/**
	 * Select guest details
	 * 
	 * @param guestInfo
	 * @throws Exception 
	 */
	public  void SelectGuestDetails(String guestInfo) throws Exception {

		if (TestBase.flag_Mob) {
			ClickUsingJavaScript(BookingLocators.getselectGuestRoomOptions());
			ClickUsingJavaScript(BookingLocators.getselectGuestRoomOptionsDrpdown());
			WebElement wb = driver.findElement(BookingLocators.getoptionListForGuestsAndRooms())
					.findElement(By.xpath(".//li[@id='" + guestInfo + "']"));
			ClickUsingJavaScript(wb);
			ClickUsingJavaScript(BookingLocators.getdoneButton());
			Logs.info("User select '" + guestInfo + "' from Guest list");
		} else {
			SelectOptionByValue(BookingLocators.getselectGuestDrpdown(), guestInfo);
			Logs.info("User select '" + guestInfo + "' from Guest list");
		}
	}

	/**
	 * 
	 * @param guestInfo
	 */
	public  void SelectGuestDetailsOnMob(String guestInfo) {
		SelectOptionByValue(BookingLocators.getselectGuestDrpdown(), guestInfo);
		Logs.info("User select '" + guestInfo + "' from Guest list");
	}

	public  void ClickonContinueButton() {

		ClickUsingJavaScript(BookingLocators.getcontinueBtn());
	}

	public  void ClickonContinueLink() {
		ClickUsingJavaScript(BookingLocators.getcontinueLink());
	}

	public  String SelectCheaperFlights() throws Exception {
		String flightvalue = null;
		if (TestBase.flag_Mob) {
			SelectCheaperFlights_Mob();
		} else {

			ClickUsingJavaScript(BookingLocators.getcheaperFlightsLink());

			flightvalue = driver.findElement(BookingLocators.getexpectedFlight()).getText();

			ClickUsingJavaScript(BookingLocators.getselectFlightOption());
			ClickUsingJavaScript(BookingLocators.getselectButtonInFlightOption1());

			ClickUsingJavaScript(BookingLocators.getcontinueLink());

		}
		return flightvalue;

	}

	public  void SelectCheaperFlights_Mob() throws Exception {
		isElementDisplayed(BookingLocators.getcheaperFlightsLink());
		scrollDown();
		ClickUsingJavaScript(BookingLocators.getcheaperFlightsLink());
		ClickUsingJavaScript(BookingLocators.getselectFlightOption());
		ClickUsingJavaScript(BookingLocators.getselectbutton());
		isElementDisplayed(BookingLocators.getcontinueLink());
		scrollDown();
		scrollDown();
		ClickUsingJavaScript(BookingLocators.getcontinueLink());
	}

	public  void ClicktoContinuePage() {

		ClickUsingJavaScript(BookingLocators.getcontinueImage());
	}

	public  void SelectNumberOfAdult(String numOfAdults, By element) {

		SelectOptionByValue(element, numOfAdults);
	}

	public  void ClickOnWithoutAir() {

		BookingLocators.getWithoutAirButton();

	}

	public  void SelectNumberOfChild(String numOfChild, String ageOfChild, String childType) {
		if (childType.equals("Child1")) {
			SelectOptionByValue(BookingLocators.getselectChildDrpdown(), numOfChild);
			Logs.info("User entered number of child'" + numOfChild + "' ");
			SelectOptionByValue(BookingLocators.getselectChildAgeDrpdown(), ageOfChild);
			Logs.info("User entered number of child'" + ageOfChild + "' ");
		} else {
			SelectOptionByValue(BookingLocators.getselectChildRoom2Drpdown(), numOfChild);
			Logs.info("User entered number of child'" + numOfChild + "' ");
			SelectOptionByValue(BookingLocators.getselectChildAgeRoom2Drpdown(), ageOfChild);
			Logs.info("User entered number of child'" + numOfChild + "' ");
		}
	}

	public  void fillBasicBookingDetailForMultipleCities(String flightType, String destination,
			String stayingTime, String destination_second, String guestinfo) throws Exception {
		if (flightType.equalsIgnoreCase("WithAir")) {
			ClearAndSetValues(BookingLocators.getLeavingTxtbox(), "New York, Newark, NJ");
			Logs.info("User entered New York, Newark, NJ into leaving from field");
		}
		ClearAndSetValues(BookingLocators.getgoingToTextbox(), destination);
		Logs.info("User entered '" + destination + "' into Going to from field");
		ClickUsingJavaScript(BookingLocators.getaddCityBtn());
		ClearAndSetValues(BookingLocators.getgoingToTextboxSecond(), destination_second);
		Logs.info("User entered '" + destination_second + "' into Second Going to field");
		SelectStayingTime(stayingTime);
		ClickUsingJavaScript(BookingLocators.getnoMoreCitiesBtn());
		SelectGuestDetails(guestinfo);
	}

	public  void getWithoutButton() {

		ClickUsingJavaScript(BookingLocators.getWithoutAirButton());
	}

	public  void fillBasicBookingDetailWithoutAir(String destination, String stayingTime,
			String destination_second, String guestinfo) throws Exception {

		ClearAndSetValues(BookingLocators.getgoingToTextbox(), destination);

		ClickUsingJavaScript(BookingLocators.getaddCityBtn());
		ClearAndSetValues(BookingLocators.getgoingToTextboxSecond(), destination_second);

		SelectStayingTime(stayingTime);
		ClickUsingJavaScript(BookingLocators.getnoMoreCitiesBtn());

		SelectGuestDetails(guestinfo);

	}

	public  String browseHotelsButton() {
		ClickUsingJavaScript(BookingLocators.getBrowseHotelsLink());
		String actualhotel = driver.findElement(BookingLocators.getFirstHotel()).getText();
		return actualhotel;
	}

	public  String browseSelectHotel() {
		ClickUsingJavaScript(BookingLocators.getselectFirstHotel());
		String expectedhotel = driver.findElement(BookingLocators.getExpectedHotel()).getText();
		return expectedhotel;
	}

	public  void getContinueLink() {
		ClickUsingJavaScript(BookingLocators.getcontinueLink());
	}

	public  List<String> GetSelectedFlightsDetails() {
		List<String> actualFlightdetails = new ArrayList<String>();

		List<WebElement> actualFlight = driver.findElements(BookingLocators.getactualFlightDetails());

		for (WebElement details : actualFlight) {
			actualFlightdetails.add(details.getText());
		}
		return actualFlightdetails;
	}

	public  String GetActualFlight() {
		String flightvalue = driver.findElement(BookingLocators.getactualFlightDetails()).getText();
		return flightvalue;
	}

	public  void SelectWithoutAir() {
		ClickUsingJavaScript(BookingLocators.getwithoutAir());

	}

	public  void FillBasicBookingDetails2(String destination, String stayingTime, String guestInfo)
			throws Exception {
		ClearAndSetValues(BookingLocators.getgoingToTextbox(), destination);
		SelectStayingTime(stayingTime);
		ClickUsingJavaScript(BookingLocators.getnoMoreCitiesBtn());
		SelectGuestDetails(guestInfo);
	}

	public  void ClickChangedArriveDate() {
		ClickUsingJavaScript(BookingLocators.getChangedArriveDate());
		boolean expecteddate = driver.findElement(BookingLocators.getChangedArriveDate()).isEnabled();
		Assert.assertTrue(expecteddate);
	}

	public  void fillBasicDetails(String leavefrom, String firstdestination, String stayingTime,
			String seconddestination, String seconddrop, String thirddestination, String thirddrop) throws Exception {

		ClearAndSetValues(BookingLocators.getLeavingTxtbox(), leavefrom);
		ClearAndSetValues(BookingLocators.getgoingToTextbox(), firstdestination);
		SelectStayingTime(stayingTime);
		ClickUsingJavaScript(BookingLocators.getaddCityBtn());
		ClearAndSetValues(BookingLocators.getgoingToTextboxSecond(), seconddestination);
		SelectStayingTimeTwo(seconddrop);
		ClickUsingJavaScript(BookingLocators.getaddCityBtn());
		ClearAndSetValues(BookingLocators.getgoingToTextboxThird(), thirddestination);
		SelectStayingTimeThree(thirddrop);

	}

	public  void deleteAddedCities() {
		ClickUsingJavaScript(BookingLocators.getthirdremoveCitylink());
		ClickUsingJavaScript(BookingLocators.getsecondremovecitylink());

	}

	public  void getNoMoreCitiesButton() {
		ClickUsingJavaScript(BookingLocators.getnoMoreCitiesBtn());
	}

	public  void selectguesdetatils(String guestinfo) throws Exception {
		SelectGuestDetails(guestinfo);
	}

	public  boolean isremovecitydisplayed() {
		boolean result = false;
		if (driver.findElement(BookingLocators.getsecondremovecitylink()).isDisplayed()) {
			result = true;

		}
		return result;
	}

	public  void SelectStayingTimeTwo(String stayingTimeTwo) {

		SelectOptionByValue(BookingLocators.getstayingDrpdowntwo(), stayingTimeTwo);
	}

	public  void SelectValueFromCalendar() {
		clickOnElement(BookingLocators.getArriveDateDropdown());
		String newDate = selectNewDateFromCalendar();
		List<WebElement> columns = driver.findElements(BookingLocators.getArriveDateCalender());
		for (WebElement cell : columns) {
			if (cell.getText().equals(newDate)) {
				cell.findElement(By.linkText(newDate)).click();
				break;
			}
		}
	}

	public  void SelectCabinClass(String cabinclass) {
		SelectOptionByText(BookingLocators.getCabinClassDropdown(), cabinclass);
	}

	/**
	 * Select Cabin Class For Mobile
	 * 
	 * @param cabinclass
	 * @throws Exception 
	 * @author Mrinal
	 */
	public  void SelectCabinClassForMob(String cabinclass) throws Exception {
		if (TestBase.flag_Mob) {
			WebElement wb = driver.findElement(BookingLocators.getcabinSectionMob())
					.findElement(By.xpath(".//span[text()='" + cabinclass + "']/parent::p"));
			ClickUsingJavaScript(wb);
		} else {
			SelectOptionByText(BookingLocators.getCabinClassDropdown(), cabinclass);
		}
	}

	public  void validateremovedcity() {
		boolean flag = false;
		try {
			driver.findElement(BookingLocators.getthirdremoveCitylink());
			flag = false;
		} catch (Exception NoSuchElementException) {
			flag = true;
		}
		Assert.assertTrue(flag);
	}

	public  void BookingDetailswithPremiumEcomomy(String leavingFrom, String destination, String cabinclass,
			String stayingTime, String guestInfo) throws Exception {
		SelectCabinClass(cabinclass);
		ClearAndSetValues(BookingLocators.getLeavingTxtbox(), leavingFrom);
		ClearAndSetValues(BookingLocators.getgoingToTextbox(), destination);
		SelectStayingTime(stayingTime);
		ClickUsingJavaScript(BookingLocators.getnoMoreCitiesBtn());
		SelectGuestDetails(guestInfo);

	}

	public  String selectedcabinAssert() {

		String selectedcabin = driver.findElement(BookingLocators.getFirstpremiumOption()).getText();
		return selectedcabin;
	}

	public  String verifycabinAssert() {

		String expectedcabin = driver.findElement(BookingLocators.getSecondpremiumOption()).getText();
		return expectedcabin;
	}

	public  void selectLatinAmericaLink() {
		ClickUsingJavaScript(HomePageLocators.getExploreLatinAmericaLnk());
		boolean actuallink = (getPageTitle().contains("Vacation Packages"));
		Assert.assertTrue(actuallink);
	}

	public  void verifyLatinAmericPage() {
		boolean expectedlink = (getPageTitle().contains("Latin America Vacations"));
		Assert.assertTrue(expectedlink);
	}

	/**
	 * click On Spot light On DrpDwn for mobile
	 * 
	 * @throws Exception
	 * @author Mrinal
	 */
	public  void clickOnSpotlightOnDrpDwnForMob() throws Exception {
		if (TestBase.flag_Mob) {
			scrollDownForMob(4);
			ClickUsingJavaScript(HomePageLocators.getSpotlightOnDrpDwn());
		}
	}

	/**
	 * click On First Option Under Spot light On DrpDwn for mobile
	 * 
	 * @throws Exception
	 * @author Mrinal
	 * @return
	 */
	public  String clickOnFirstOptionUnderSpotlightForMob() throws Exception {
		String title = null;
		if (TestBase.flag_Mob) {
			title = getText(HomePageLocators.getfirstOptionUnderSpotlightDrpDwn());
			ClickUsingJavaScript(HomePageLocators.getfirstOptionUnderSpotlightDrpDwn());
		}
		return title;
	}

	/**
	 * verify Page Displayed
	 * 
	 * @throws Exception
	 * @author Mrinal
	 */
	public  void verifyPageDisplayed(String PageTitle) {
		Assert.assertTrue(getPageTitle().contains(PageTitle.trim()));
	}

	public  void OldArriveDate() {
		boolean actualdate = driver.findElement(BookingLocators.getArriveDate()).isEnabled();
		Assert.assertTrue(actualdate);
	}

	public  void TripSummary() {
		ClickUsingJavaScript(BookingLocators.getTripSummaryButton());
	}

	public  void validateTripIncluisonPage() {
		boolean flag = false;
		if (driver.getTitle().contains("ItineraryDetails"))
			flag = true;
		else
			flag = false;

		Assert.assertTrue(flag);
	}

	public  void SelectStayingTimeThree(String stayingTimeThree) {

		SelectOptionByValue(BookingLocators.getstayingDrpdownthree(), stayingTimeThree);
	}

	/**
	 * click On Build Your Vacation Drop Down on mobile browser
	 * 
	 * @author Mrinal
	 */
	public  void clickOnBuildYourVacationDropDown() {
		if (TestBase.flag_Mob)
			clickOnElement(BookingLocators.getBuildYourVacationDropDown());
	}

}
