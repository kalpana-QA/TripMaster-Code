package com.tripmasters.framework.actions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.tripmasters.framework.base.TestBase;
import com.tripmasters.framework.pages.BookingLocators;
import com.tripmasters.framework.pages.HomePageLocators;
import com.tripmasters.framework.utils.CommonLib;
import com.tripmasters.framework.utils.Logs;

public class BookingPageAction extends TestBase {

	public static void fillBasicBookingDetails(String leavingFrom, String destination, String stayingTime,
			String guestInfo) throws Exception {
		CommonLib.clearAndSetValues(BookingLocators.getLeavingTxtbox(), leavingFrom);
		Logs.info("User entered '" + leavingFrom + "' into leaving from field");
		CommonLib.clearAndSetValues(BookingLocators.getgoingToTextbox(), destination);
		Logs.info("User entered '" + destination + "' into Going to from field");
		//selectValueFromCalendar();
		selectStayingTime(stayingTime);
		CommonLib.clickUsingJavaScript(BookingLocators.getnoMoreCitiesBtn());
		selectGuestDetails(guestInfo);
		Logs.info("User entered guest info '" + guestInfo + "'");
	}

	public static void selectStayingTime(String stayingTime) {

		CommonLib.selectOptionByValue(BookingLocators.getstayingDrpdown(), stayingTime);
		Logs.info("User entered '" + stayingTime + "' nights staying time");
	}

	public static void selectGuestDetails(String guestInfo) {

		if (platform.equalsIgnoreCase("Mobile")) {
			CommonLib.clickUsingJavaScript(BookingLocators.getselectGuestRoomOptions());
			CommonLib.clickUsingJavaScript(BookingLocators.getselectGuestRoomOptionsDrpdown());
			WebElement wb = driver.findElement(BookingLocators.getoptionListForGuestsAndRooms())
					.findElement(By.xpath(".//li[@id='" + guestInfo + "']"));
			CommonLib.clickUsingJavaScript(wb);
			CommonLib.clickUsingJavaScript(BookingLocators.getdoneButton());
			Logs.info("User select '" + guestInfo + "' from Guest list");
		} else {
			CommonLib.selectOptionByValue(BookingLocators.getselectGuestDrpdown(), guestInfo);
			Logs.info("User select '" + guestInfo + "' from Guest list");
		}
	}

	/**
	 * 
	 * @param guestInfo
	 */
	public static void selectGuestDetailsOnMob(String guestInfo) {
		CommonLib.selectOptionByValue(BookingLocators.getselectGuestDrpdown(), guestInfo);
		Logs.info("User select '" + guestInfo + "' from Guest list");
	}

	public static void clickonContinueButton() {

		CommonLib.clickUsingJavaScript(BookingLocators.getcontinueBtn());
	}

	public static void clickonContinueLink() {
		CommonLib.clickUsingJavaScript(BookingLocators.getcontinueLink());
		
	}

	public static String selectCheaperFlights() throws Exception {
		String flightvalue = null;
		if (platform.equalsIgnoreCase("Mobile")) {
			selectCheaperFlights_Mob();
		} else {

			CommonLib.clickUsingJavaScript(BookingLocators.getcheaperFlightsLink());

			flightvalue = driver.findElement(BookingLocators.getexpectedFlight()).getText();

			CommonLib.clickUsingJavaScript(BookingLocators.getselectFlightOption());
			CommonLib.clickUsingJavaScript(BookingLocators.getselectButtonInFlightOption1());

			CommonLib.clickUsingJavaScript(BookingLocators.getcontinueLink());

		}
		return flightvalue;

	}

	public static void selectCheaperFlights_Mob() throws Exception {
		CommonLib.isElementDisplayed(BookingLocators.getcheaperFlightsLink());
		CommonLib.scrollDown();
		CommonLib.clickUsingJavaScript(BookingLocators.getcheaperFlightsLink());
		CommonLib.clickUsingJavaScript(BookingLocators.getselectFlightOption());
		CommonLib.clickUsingJavaScript(BookingLocators.getselectbutton());
		CommonLib.isElementDisplayed(BookingLocators.getcontinueLink());
		CommonLib.scrollDown();
		CommonLib.scrollDown();
		CommonLib.clickUsingJavaScript(BookingLocators.getcontinueLink());
	}


	public static void clicktoContinuePage() {
		CommonLib.clickUsingJavaScript(BookingLocators.getcontinueImage());
	}
	public static void selectNumberOfAdult(String numOfAdults, By element) {

		CommonLib.selectOptionByValue(element, numOfAdults);
	}

	public static void clickOnWithoutAir() {

		BookingLocators.getWithoutAirButton();
	}

	//Fix this method for selecting age of child...
	public static void selectNumberOfChild(String numOfChild, String ageOfChild, String childType) {
		if (childType.equals("Child1")) {
			CommonLib.selectOptionByValue(BookingLocators.getselectChildDrpdown(), numOfChild);
			Logs.info("User entered number of child'" + numOfChild + "' ");
			Select option = new Select(driver.findElement(By.xpath("//select[@id='xiChild1']")));
			option.selectByValue(ageOfChild);
			//CommonLib.selectOptionByText(BookingLocators.getselectChildAgeDrpdown(), ageOfChild);
			Logs.info("User entered age of child'" + ageOfChild + "' ");
		} else {
			CommonLib.selectOptionByValue(BookingLocators.getselectChildRoom2Drpdown(), numOfChild);
			Logs.info("User entered number of child'" + numOfChild + "' ");
			Select option = new Select(driver.findElement(By.xpath("//select[@id='xRoom2_iChild1']")));
			option.selectByValue(ageOfChild);
			//CommonLib.selectOptionByValue(BookingLocators.getselectChildAgeRoom2Drpdown(), ageOfChild);
			Logs.info("User entered age of child'" + numOfChild + "' ");
		}
	}

	public static void fillBasicBookingDetailForMultipleCities(String flightType, String destination,
			String stayingTime, String destination_second, String guestinfo) throws Exception {
		if (flightType.equalsIgnoreCase("WithAir")) {
			CommonLib.clearAndSetValues(BookingLocators.getLeavingTxtbox(), "New York, Newark, NJ");
			Logs.info("User entered New York, Newark, NJ into leaving from field");
		}
		CommonLib.clearAndSetValues(BookingLocators.getgoingToTextbox(), destination);
		Logs.info("User entered '" + destination + "' into Going to from field");
		CommonLib.clickUsingJavaScript(BookingLocators.getaddCityBtn());
		CommonLib.clearAndSetValues(BookingLocators.getgoingToTextboxSecond(), destination_second);
		Logs.info("User entered '" + destination_second + "' into Second Going to field");
		selectStayingTime(stayingTime);
		CommonLib.clickUsingJavaScript(BookingLocators.getnoMoreCitiesBtn());
		selectGuestDetails(guestinfo);
	}

	public static void getWithoutButton() {

		CommonLib.clickUsingJavaScript(BookingLocators.getWithoutAirButton());
	}

	public static void fillBasicBookingDetailWithoutAir(String destination, String stayingTime,
			String destination_second, String guestinfo) throws Exception {

		CommonLib.clearAndSetValues(BookingLocators.getgoingToTextbox(), destination);

		CommonLib.clickUsingJavaScript(BookingLocators.getaddCityBtn());
		CommonLib.clearAndSetValues(BookingLocators.getgoingToTextboxSecond(), destination_second);

		selectStayingTime(stayingTime);
		CommonLib.clickUsingJavaScript(BookingLocators.getnoMoreCitiesBtn());

		selectGuestDetails(guestinfo);

	}

	public static String browseHotelsButton() {
		CommonLib.clickUsingJavaScript(BookingLocators.getBrowseHotelsLink());
		String actualhotel = driver.findElement(BookingLocators.getFirstHotel()).getText();
		return actualhotel;
	}

	public static String browseSelectHotel() {
		CommonLib.clickUsingJavaScript(BookingLocators.getselectFirstHotel());
		String expectedhotel = driver.findElement(BookingLocators.getExpectedHotel()).getText();
		return expectedhotel;
	}

	public static void getContinueLink() {
		CommonLib.clickUsingJavaScript(BookingLocators.getcontinueLink());
	}

	public static List<String> getSelectedFlightsDetails() {
		List<String> actualFlightdetails = new ArrayList<String>();

		List<WebElement> actualFlight = driver.findElements(BookingLocators.getactualFlightDetails());

		for (WebElement details : actualFlight) {
			actualFlightdetails.add(details.getText());
		}
		return actualFlightdetails;
	}

	public static String getActualFlight() {
		String flightvalue = driver.findElement(BookingLocators.getactualFlightDetails()).getText();
		return flightvalue;
	}

	public static void selectWithoutAir() {
		CommonLib.clickUsingJavaScript(BookingLocators.getwithoutAir());
	}

	public static void fillBasicBookingDetails2(String destination, String stayingTime, String guestInfo)
			throws Exception {
		CommonLib.clearAndSetValues(BookingLocators.getgoingToTextbox(), destination);
		selectStayingTime(stayingTime);
		CommonLib.clickUsingJavaScript(BookingLocators.getnoMoreCitiesBtn());
		selectGuestDetails(guestInfo);
	}

	public static void clickChangedArriveDate() {
		CommonLib.clickUsingJavaScript(BookingLocators.getChangedArriveDate());
		boolean expecteddate = driver.findElement(BookingLocators.getChangedArriveDate()).isEnabled();
		Assert.assertTrue(expecteddate);
	}

	public static void fillBasicDetails(String leavefrom, String firstdestination, String stayingTime,
			String seconddestination, String seconddrop, String thirddestination, String thirddrop) throws Exception {

		CommonLib.clearAndSetValues(BookingLocators.getLeavingTxtbox(), leavefrom);
		CommonLib.clearAndSetValues(BookingLocators.getgoingToTextbox(), firstdestination);
		selectStayingTime(stayingTime);
		CommonLib.clickUsingJavaScript(BookingLocators.getaddCityBtn());
		CommonLib.clearAndSetValues(BookingLocators.getgoingToTextboxSecond(), seconddestination);
		selectStayingTimeTwo(seconddrop);
		CommonLib.clickUsingJavaScript(BookingLocators.getaddCityBtn());
		CommonLib.clearAndSetValues(BookingLocators.getgoingToTextboxThird(), thirddestination);
		selectStayingTimeThree(thirddrop);

	}

	public static void deleteAddedCities() {
		CommonLib.clickUsingJavaScript(BookingLocators.getthirdremoveCitylink());
		CommonLib.clickUsingJavaScript(BookingLocators.getsecondremovecitylink());

	}

	public static void getNoMoreCitiesButton() {
		CommonLib.clickUsingJavaScript(BookingLocators.getnoMoreCitiesBtn());
	}

	public static void selectguesdetatils(String guestinfo) {
		selectGuestDetails(guestinfo);
	}

	public static boolean isremovecitydisplayed() {
		boolean result = false;
		if (driver.findElement(BookingLocators.getsecondremovecitylink()).isDisplayed()) {
			result = true;

		}
		return result;
	}

	public static void selectStayingTimeTwo(String stayingTimeTwo) {

		CommonLib.selectOptionByValue(BookingLocators.getstayingDrpdowntwo(), stayingTimeTwo);
	}

	public static void selectValueFromCalendar() {
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

	public static void selectCabinClass(String cabinclass) {
		CommonLib.selectOptionByText(BookingLocators.getCabinClassDropdown(), cabinclass);
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

	public static void bookingDetailswithPremiumEcomomy(String leavingFrom, String destination, String cabinclass,
			String stayingTime, String guestInfo) throws Exception {
		selectCabinClass(cabinclass);
		CommonLib.clearAndSetValues(BookingLocators.getLeavingTxtbox(), leavingFrom);
		CommonLib.clearAndSetValues(BookingLocators.getgoingToTextbox(), destination);
		selectStayingTime(stayingTime);
		CommonLib.clickUsingJavaScript(BookingLocators.getnoMoreCitiesBtn());
		selectGuestDetails(guestInfo);

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
		CommonLib.clickUsingJavaScript(HomePageLocators.getExploreLatinAmericaLnk());
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
			CommonLib.clickUsingJavaScript(HomePageLocators.getSpotlightOnDrpDwn());
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
		
			title = CommonLib.getText(HomePageLocators.getfirstOptionUnderSpotlightDrpDwn());
			CommonLib.clickUsingJavaScript(HomePageLocators.getfirstOptionUnderSpotlightDrpDwn());
		
		return title;
	}

	/**
	 * verify Page Displayed
	 * 
	 * @throws Exception
	 * @author Mrinal
	 */
	public static void verifyPageDisplayed() throws Exception {
		if (platform.equalsIgnoreCase("Mobile")) {
		String PageTitle =clickOnFirstOptionUnderSpotlightForMob();
		Assert.assertTrue(CommonLib.getPageTitle().contains(PageTitle.split("\n")[0].trim()));
	}
	}

	public static void oldArriveDate() {
		boolean actualdate = driver.findElement(BookingLocators.getArriveDate()).isEnabled();
		Assert.assertTrue(actualdate);
	}

	public static void tripSummary() {
		CommonLib.clickUsingJavaScript(BookingLocators.getTripSummaryButton());
	}

	public static void validateTripIncluisonPage() {
		boolean flag = false;
		System.out.println(driver.getTitle());
		if (driver.getTitle().contains("Itinerary - Review"))
			flag = true;
		else
			flag = false;

		Assert.assertTrue(flag);
	}

	public static void selectStayingTimeThree(String stayingTimeThree) {

		CommonLib.selectOptionByValue(BookingLocators.getstayingDrpdownthree(), stayingTimeThree);
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
