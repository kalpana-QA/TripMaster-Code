package com.tripmasters.framework.actions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.tripmasters.framework.base.TestBase;
import com.tripmasters.framework.pages.BookingLocators;
import com.tripmasters.framework.pages.HomePageLocators;
import com.tripmasters.framework.utils.CommonLib;
import com.tripmasters.framework.utils.Logs;

public class BookingPageAction extends TestBase {

	public static void FillBasicBookingDetails(String leavingFrom, String destination, String stayingTime,
			String guestInfo) throws Exception {
		CommonLib.ClearAndSetValues(BookingLocators.getLeavingTxtbox(), leavingFrom);
		Logs.info("User entered '" + leavingFrom + "' into leaving from field");
		CommonLib.ClearAndSetValues(BookingLocators.getgoingToTextbox(), destination);
		Logs.info("User entered '" + destination + "' into Going to from field");
		SelectValueFromCalendar();
		SelectStayingTime(stayingTime);
		CommonLib.ClickUsingJavaScript(BookingLocators.getnoMoreCitiesBtn());
		SelectGuestDetails(guestInfo);
		Logs.info("User entered guest info '" + guestInfo + "'");
	}

	public static void SelectStayingTime(String stayingTime) {

		CommonLib.SelectOptionByValue(BookingLocators.getstayingDrpdown(), stayingTime);
		Logs.info("User entered '" + stayingTime + "' nights staying time");
	}

	public static void SelectGuestDetails(String guestInfo) {

		if (platform.equalsIgnoreCase("Mobile")) {
			CommonLib.ClickUsingJavaScript(BookingLocators.getselectGuestRoomOptions());
			CommonLib.ClickUsingJavaScript(BookingLocators.getselectGuestRoomOptionsDrpdown());
			WebElement wb = driver.findElement(BookingLocators.getoptionListForGuestsAndRooms())
					.findElement(By.xpath(".//li[@id='" + guestInfo + "']"));
			CommonLib.ClickUsingJavaScript(wb);
			CommonLib.ClickUsingJavaScript(BookingLocators.getdoneButton());
			Logs.info("User select '" + guestInfo + "' from Guest list");
		} else {
			CommonLib.SelectOptionByValue(BookingLocators.getselectGuestDrpdown(), guestInfo);
			Logs.info("User select '" + guestInfo + "' from Guest list");
		}
	}

	/**
	 * 
	 * @param guestInfo
	 */
	public static void SelectGuestDetailsOnMob(String guestInfo) {
		CommonLib.SelectOptionByValue(BookingLocators.getselectGuestDrpdown(), guestInfo);
		Logs.info("User select '" + guestInfo + "' from Guest list");
	}

	public static void ClickonContinueButton() {

		CommonLib.ClickUsingJavaScript(BookingLocators.getcontinueBtn());
	}

	public static void ClickonContinueLink() {
		CommonLib.ClickUsingJavaScript(BookingLocators.getcontinueLink());
	}

	public static String SelectCheaperFlights() throws Exception {
		String flightvalue = null;
		if (platform.equalsIgnoreCase("Mobile")) {
			SelectCheaperFlights_Mob();
		} else {

			CommonLib.ClickUsingJavaScript(BookingLocators.getcheaperFlightsLink());

			flightvalue = driver.findElement(BookingLocators.getexpectedFlight()).getText();

			CommonLib.ClickUsingJavaScript(BookingLocators.getselectFlightOption());
			CommonLib.ClickUsingJavaScript(BookingLocators.getselectButtonInFlightOption1());

			CommonLib.ClickUsingJavaScript(BookingLocators.getcontinueLink());

		}
		return flightvalue;

	}

	public static void SelectCheaperFlights_Mob() throws Exception {
		CommonLib.isElementDisplayed(BookingLocators.getcheaperFlightsLink());
		CommonLib.scrollDown();
		CommonLib.ClickUsingJavaScript(BookingLocators.getcheaperFlightsLink());
		CommonLib.ClickUsingJavaScript(BookingLocators.getselectFlightOption());
		CommonLib.ClickUsingJavaScript(BookingLocators.getselectbutton());
		CommonLib.isElementDisplayed(BookingLocators.getcontinueLink());
		CommonLib.scrollDown();
		CommonLib.scrollDown();
		CommonLib.ClickUsingJavaScript(BookingLocators.getcontinueLink());
	}

	public static void ClicktoContinuePage() {

		CommonLib.ClickUsingJavaScript(BookingLocators.getcontinueImage());
	}

	public static void SelectNumberOfAdult(String numOfAdults, By element) {

		CommonLib.SelectOptionByValue(element, numOfAdults);
	}

	public static void ClickOnWithoutAir() {

		BookingLocators.getWithoutAirButton();

	}

	public static void SelectNumberOfChild(String numOfChild, String ageOfChild, String childType) {
		if (childType.equals("Child1")) {
			CommonLib.SelectOptionByValue(BookingLocators.getselectChildDrpdown(), numOfChild);
			Logs.info("User entered number of child'" + numOfChild + "' ");
			CommonLib.SelectOptionByValue(BookingLocators.getselectChildAgeDrpdown(), ageOfChild);
			Logs.info("User entered number of child'" + ageOfChild + "' ");
		} else {
			CommonLib.SelectOptionByValue(BookingLocators.getselectChildRoom2Drpdown(), numOfChild);
			Logs.info("User entered number of child'" + numOfChild + "' ");
			CommonLib.SelectOptionByValue(BookingLocators.getselectChildAgeRoom2Drpdown(), ageOfChild);
			Logs.info("User entered number of child'" + numOfChild + "' ");
		}
	}

	public static void fillBasicBookingDetailForMultipleCities(String flightType, String destination,
			String stayingTime, String destination_second, String guestinfo) throws Exception {
		if (flightType.equalsIgnoreCase("WithAir")) {
			CommonLib.ClearAndSetValues(BookingLocators.getLeavingTxtbox(), "New York, Newark, NJ");
			Logs.info("User entered New York, Newark, NJ into leaving from field");
		}
		CommonLib.ClearAndSetValues(BookingLocators.getgoingToTextbox(), destination);
		Logs.info("User entered '" + destination + "' into Going to from field");
		CommonLib.ClickUsingJavaScript(BookingLocators.getaddCityBtn());
		CommonLib.ClearAndSetValues(BookingLocators.getgoingToTextboxSecond(), destination_second);
		Logs.info("User entered '" + destination_second + "' into Second Going to field");
		SelectStayingTime(stayingTime);
		CommonLib.ClickUsingJavaScript(BookingLocators.getnoMoreCitiesBtn());
		SelectGuestDetails(guestinfo);
	}

	public static void getWithoutButton() {

		CommonLib.ClickUsingJavaScript(BookingLocators.getWithoutAirButton());
	}

	public static void fillBasicBookingDetailWithoutAir(String destination, String stayingTime,
			String destination_second, String guestinfo) throws Exception {

		CommonLib.ClearAndSetValues(BookingLocators.getgoingToTextbox(), destination);

		CommonLib.ClickUsingJavaScript(BookingLocators.getaddCityBtn());
		CommonLib.ClearAndSetValues(BookingLocators.getgoingToTextboxSecond(), destination_second);

		SelectStayingTime(stayingTime);
		CommonLib.ClickUsingJavaScript(BookingLocators.getnoMoreCitiesBtn());

		SelectGuestDetails(guestinfo);

	}

	public static String browseHotelsButton() {
		CommonLib.ClickUsingJavaScript(BookingLocators.getBrowseHotelsLink());
		String actualhotel = driver.findElement(BookingLocators.getFirstHotel()).getText();
		return actualhotel;
	}

	public static String browseSelectHotel() {
		CommonLib.ClickUsingJavaScript(BookingLocators.getselectFirstHotel());
		String expectedhotel = driver.findElement(BookingLocators.getExpectedHotel()).getText();
		return expectedhotel;
	}

	public static void getContinueLink() {
		CommonLib.ClickUsingJavaScript(BookingLocators.getcontinueLink());
	}

	public static List<String> GetSelectedFlightsDetails() {
		List<String> actualFlightdetails = new ArrayList<String>();

		List<WebElement> actualFlight = driver.findElements(BookingLocators.getactualFlightDetails());

		for (WebElement details : actualFlight) {
			actualFlightdetails.add(details.getText());
		}
		return actualFlightdetails;
	}

	public static String GetActualFlight() {
		String flightvalue = driver.findElement(BookingLocators.getactualFlightDetails()).getText();
		return flightvalue;
	}

	public static void SelectWithoutAir() {
		CommonLib.ClickUsingJavaScript(BookingLocators.getwithoutAir());

	}

	public static void FillBasicBookingDetails2(String destination, String stayingTime, String guestInfo)
			throws Exception {
		CommonLib.ClearAndSetValues(BookingLocators.getgoingToTextbox(), destination);
		SelectStayingTime(stayingTime);
		CommonLib.ClickUsingJavaScript(BookingLocators.getnoMoreCitiesBtn());
		SelectGuestDetails(guestInfo);
	}

	public static void ClickChangedArriveDate() {
		CommonLib.ClickUsingJavaScript(BookingLocators.getChangedArriveDate());
		boolean expecteddate = driver.findElement(BookingLocators.getChangedArriveDate()).isEnabled();
		Assert.assertTrue(expecteddate);
	}

	public static void fillBasicDetails(String leavefrom, String firstdestination, String stayingTime,
			String seconddestination, String seconddrop, String thirddestination, String thirddrop) throws Exception {

		CommonLib.ClearAndSetValues(BookingLocators.getLeavingTxtbox(), leavefrom);
		CommonLib.ClearAndSetValues(BookingLocators.getgoingToTextbox(), firstdestination);
		SelectStayingTime(stayingTime);
		CommonLib.ClickUsingJavaScript(BookingLocators.getaddCityBtn());
		CommonLib.ClearAndSetValues(BookingLocators.getgoingToTextboxSecond(), seconddestination);
		SelectStayingTimeTwo(seconddrop);
		CommonLib.ClickUsingJavaScript(BookingLocators.getaddCityBtn());
		CommonLib.ClearAndSetValues(BookingLocators.getgoingToTextboxThird(), thirddestination);
		SelectStayingTimeThree(thirddrop);

	}

	public static void deleteAddedCities() {
		CommonLib.ClickUsingJavaScript(BookingLocators.getthirdremoveCitylink());
		CommonLib.ClickUsingJavaScript(BookingLocators.getsecondremovecitylink());

	}

	public static void getNoMoreCitiesButton() {
		CommonLib.ClickUsingJavaScript(BookingLocators.getnoMoreCitiesBtn());
	}

	public static void selectguesdetatils(String guestinfo) {
		SelectGuestDetails(guestinfo);
	}

	public static boolean isremovecitydisplayed() {
		boolean result = false;
		if (driver.findElement(BookingLocators.getsecondremovecitylink()).isDisplayed()) {
			result = true;

		}
		return result;
	}

	public static void SelectStayingTimeTwo(String stayingTimeTwo) {

		CommonLib.SelectOptionByValue(BookingLocators.getstayingDrpdowntwo(), stayingTimeTwo);
	}

	public static void SelectValueFromCalendar() {
		CommonLib.clickOnElement(BookingLocators.getArriveDateDropdown());
		String newDate = CommonLib.selectNewDateFromCalendar();
		List<WebElement> columns = driver.findElements(BookingLocators.getArriveDateCalender());
		for (WebElement cell : columns) {
			if (cell.getText().equals(newDate)) {
				cell.findElement(By.linkText(newDate)).click();
				break;
			}
		}
	}

	public static void SelectCabinClass(String cabinclass) {
		CommonLib.SelectOptionByText(BookingLocators.getCabinClassDropdown(), cabinclass);
	}

	public static void validateremovedcity() {
		boolean flag = false;
		try {
			driver.findElement(BookingLocators.getthirdremoveCitylink());
			flag = false;
		} catch (Exception NoSuchElementException) {
			flag = true;
		}
		Assert.assertTrue(flag);
	}

	public static void BookingDetailswithPremiumEcomomy(String leavingFrom, String destination, String cabinclass,
			String stayingTime, String guestInfo) throws Exception {
		SelectCabinClass(cabinclass);
		CommonLib.ClearAndSetValues(BookingLocators.getLeavingTxtbox(), leavingFrom);
		CommonLib.ClearAndSetValues(BookingLocators.getgoingToTextbox(), destination);
		SelectStayingTime(stayingTime);
		CommonLib.ClickUsingJavaScript(BookingLocators.getnoMoreCitiesBtn());
		SelectGuestDetails(guestInfo);

	}

	public static String selectedcabinAssert() {

		String selectedcabin = driver.findElement(BookingLocators.getFirstpremiumOption()).getText();
		return selectedcabin;
	}

	public static String verifycabinAssert() {

		String expectedcabin = driver.findElement(BookingLocators.getSecondpremiumOption()).getText();
		return expectedcabin;
	}

	public static void selectLatinAmericaLink() {
		CommonLib.ClickUsingJavaScript(HomePageLocators.getExploreLatinAmericaLnk());
		boolean actuallink = (CommonLib.getPageTitle().contains("Vacation Packages"));
		Assert.assertTrue(actuallink);
	}

	public static void verifyLatinAmericPage() {
		boolean expectedlink = (CommonLib.getPageTitle().contains("Latin America Vacations"));
		Assert.assertTrue(expectedlink);
	}

	/**
	 * click On Spot light On DrpDwn for mobile
	 * 
	 * @throws Exception
	 * @author Mrinal
	 */
	public static void clickOnSpotlightOnDrpDwnForMob() throws Exception {
		if (platform.equalsIgnoreCase("Mobile")) {
			CommonLib.scrollDownForMob(4);
			CommonLib.ClickUsingJavaScript(HomePageLocators.getSpotlightOnDrpDwn());
		}
	}

	/**
	 * click On First Option Under Spot light On DrpDwn for mobile
	 * 
	 * @throws Exception
	 * @author Mrinal
	 * @return
	 */
	public static String clickOnFirstOptionUnderSpotlightForMob() throws Exception {
		String title = null;
		if (platform.equalsIgnoreCase("Mobile")) {
			title = CommonLib.getText(HomePageLocators.getfirstOptionUnderSpotlightDrpDwn());
			CommonLib.ClickUsingJavaScript(HomePageLocators.getfirstOptionUnderSpotlightDrpDwn());
		}
		return title;
	}

	/**
	 * verify Page Displayed
	 * 
	 * @throws Exception
	 * @author Mrinal
	 */
	public static void verifyPageDisplayed(String PageTitle) {
		Assert.assertTrue(CommonLib.getPageTitle().contains(PageTitle.trim()));
	}

	public static void OldArriveDate() {
		boolean actualdate = driver.findElement(BookingLocators.getArriveDate()).isEnabled();
		Assert.assertTrue(actualdate);
	}

	public static void TripSummary() {
		CommonLib.ClickUsingJavaScript(BookingLocators.getTripSummaryButton());
	}

	public static void validateTripIncluisonPage() {
		boolean flag = false;
		if (driver.getTitle().contains("ItineraryDetails"))
			flag = true;
		else
			flag = false;

		Assert.assertTrue(flag);
	}

	public static void SelectStayingTimeThree(String stayingTimeThree) {

		CommonLib.SelectOptionByValue(BookingLocators.getstayingDrpdownthree(), stayingTimeThree);
	}

	/**
	 * click On Build Your Vacation Drop Down on mobile browser
	 * 
	 * @author Mrinal
	 */
	public static void clickOnBuildYourVacationDropDown() {
		if (platform.equalsIgnoreCase("Mobile"))
			CommonLib.clickOnElement(BookingLocators.getBuildYourVacationDropDown());
	}

}
