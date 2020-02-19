package com.tripmasters.framework.pageActions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
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

	public  void fillBasicBookingDetails(String leavingFrom, String destination, String stayingTime,
			String guestInfo) throws Exception {
		clearAndSetValues(BookingLocators.getLeavingTxtbox(), leavingFrom);
		Logs.info("User entered '" + leavingFrom + "' into leaving from field");
		clearAndSetValues(BookingLocators.getgoingToTextbox(), destination);
		Logs.info("User entered '" + destination + "' into Going to from field");
		selectValueFromCalendar();
		selectStayingTime(stayingTime);
		clickUsingJavaScript(BookingLocators.getnoMoreCitiesBtn());
		selectGuestDetails(guestInfo);
		Logs.info("User entered guest info '" + guestInfo + "'");
	}

	public  void selectStayingTime(String stayingTime) {

		selectOptionByValue(BookingLocators.getstayingDrpdown(), stayingTime);
		Logs.info("User entered '" + stayingTime + "' nights staying time");
	}

	/**
	 * Select guest details
	 * 
	 * @param guestInfo
	 * @throws Exception 
	 */
	public  void selectGuestDetails(String guestInfo) throws Exception {

		if (TestBase.flag_Mob) {
			clickUsingJavaScript(BookingLocators.getselectGuestRoomOptions());
			clickUsingJavaScript(BookingLocators.getselectGuestRoomOptionsDrpdown());
			WebElement wb = driver.findElement(BookingLocators.getoptionListForGuestsAndRooms())
					.findElement(By.xpath(".//li[@id='" + guestInfo + "']"));
			clickUsingJavaScript(wb);
			clickUsingJavaScript(HomePageLocators.getSelectPremiumEconomy());
			clickUsingJavaScript(BookingLocators.getdoneButton());
			Logs.info("User select '" + guestInfo + "' from Guest list");
		} else {
			selectOptionByValue(BookingLocators.getselectGuestDrpdown(), guestInfo);
			Logs.info("User select '" + guestInfo + "' from Guest list");
		}
	}
//	-----------------Method for Android--------------
	public static boolean verifyCabin()
	{
		clickUsingJavaScript(HomePageLocators.getSelectPremiumEconomy());
		boolean verifycabin = driver.findElement(HomePageLocators.getSelectPremiumEconomy()).isEnabled();
		return verifycabin;
	}
	/**
	 * 
	 * @param guestInfo
	 */
	public  void selectGuestDetailsOnMob(String guestInfo) {
		selectOptionByValue(BookingLocators.getselectGuestDrpdown(), guestInfo);
		Logs.info("User select '" + guestInfo + "' from Guest list");
	}

	public void clickonContinueButton() {

		clickUsingJavaScript(BookingLocators.getcontinueBtn());
	}

	public  void clickonContinueLink() {
		clickUsingJavaScript(BookingLocators.getcontinueLink());
	}

	public String selectCheaperFlights() throws Exception {
		String flightvalue = null;
		if (TestBase.flag_Mob) {
			selectCheaperFlights_Mob();
		} else {

			clickUsingJavaScript(BookingLocators.getcheaperFlightsLink());

			flightvalue = driver.findElement(BookingLocators.getexpectedFlight()).getText();

			clickUsingJavaScript(BookingLocators.getselectFlightOption());
			clickUsingJavaScript(BookingLocators.getselectButtonInFlightOption1());

			clickUsingJavaScript(BookingLocators.getcontinueLink());

		}
		return flightvalue;

	}

	public  void selectCheaperFlights_Mob() throws Exception {
		isElementDisplayed(BookingLocators.getcheaperFlightsLink());
		scrollDown();
		clickUsingJavaScript(BookingLocators.getcheaperFlightsLink());
		clickUsingJavaScript(BookingLocators.getselectFlightOption());
		clickUsingJavaScript(BookingLocators.getselectbutton());
		isElementDisplayed(BookingLocators.getcontinueLink());
		scrollDown();
		scrollDown();
		clickUsingJavaScript(BookingLocators.getcontinueLink());
	}

	public  void clicktoContinuePage() {

		clickUsingJavaScript(BookingLocators.getcontinueImage());
	}

	public  void selectNumberOfAdult(String numOfAdults, By element) {

		selectOptionByValue(element, numOfAdults);
	}

	public  void ClickOnWithoutAir() {

		BookingLocators.getWithoutAirButton();

	}

	//TODO:this method need some modifications.
	public  void selectNumberOfChild(String numOfChild, String ageOfChild, String childType) {
		if (childType.equals("Child1")) {
			selectOptionByValue(BookingLocators.getselectChildDrpdown(), numOfChild);
			Logs.info("User entered number of child'" + numOfChild + "' ");
			Select option = new Select(driver.findElement(By.xpath("//select[@id='xiChild1']")));
			option.selectByValue(ageOfChild);
			//selectOptionByValue(BookingLocators.getselectChildAgeDrpdown(), ageOfChild);
			Logs.info("User entered number of child'" + ageOfChild + "' ");
		} else {
			selectOptionByValue(BookingLocators.getselectChildRoom2Drpdown(), numOfChild);
			Logs.info("User entered number of child'" + numOfChild + "' ");
			Select option = new Select(driver.findElement(By.xpath("//select[@id='xRoom2_iChild1']")));
			option.selectByValue(ageOfChild);
			//selectOptionByValue(BookingLocators.getselectChildAgeRoom2Drpdown(), ageOfChild);
			Logs.info("User entered number of child'" + numOfChild + "' ");
		}
	}

	public  void fillBasicBookingDetailForMultipleCities(String flightType, String destination,
			String stayingTime, String destination_second, String guestinfo) throws Exception {
		if (flightType.equalsIgnoreCase("WithAir")) {
			clearAndSetValues(BookingLocators.getLeavingTxtbox(), "New York, Newark, NJ");
			Logs.info("User entered New York, Newark, NJ into leaving from field");
		}
		clearAndSetValues(BookingLocators.getgoingToTextbox(), destination);
		Logs.info("User entered '" + destination + "' into Going to from field");
		clickUsingJavaScript(BookingLocators.getaddCityBtn());
		clearAndSetValues(BookingLocators.getgoingToTextboxSecond(), destination_second);
		Logs.info("User entered '" + destination_second + "' into Second Going to field");
		selectStayingTime(stayingTime);
		clickUsingJavaScript(BookingLocators.getnoMoreCitiesBtn());
		selectGuestDetails(guestinfo);
	}

	public  void getWithoutButton() {

		clickUsingJavaScript(BookingLocators.getWithoutAirButton());
	}

	public  void fillBasicBookingDetailWithoutAir(String destination, String stayingTime,
			String destination_second, String guestinfo) throws Exception {

		clearAndSetValues(BookingLocators.getgoingToTextbox(), destination);

		clickUsingJavaScript(BookingLocators.getaddCityBtn());
		clearAndSetValues(BookingLocators.getgoingToTextboxSecond(), destination_second);

		selectStayingTime(stayingTime);
		clickUsingJavaScript(BookingLocators.getnoMoreCitiesBtn());

		selectGuestDetails(guestinfo);

	}

	public  String browseHotelsButton() {
		clickUsingJavaScript(BookingLocators.getBrowseHotelsLink());
		String actualhotel = driver.findElement(BookingLocators.getFirstHotel()).getText();
		return actualhotel;
	}

	public  String browseSelectHotel() {
		clickUsingJavaScript(BookingLocators.getselectFirstHotel());
		String expectedhotel = driver.findElement(BookingLocators.getExpectedHotel()).getText();
		return expectedhotel;
	}

	public  void getContinueLink() {
		clickUsingJavaScript(BookingLocators.getcontinueLink());
	}

	public  List<String> getSelectedFlightsDetails() {
		List<String> actualFlightdetails = new ArrayList<String>();

		List<WebElement> actualFlight = driver.findElements(BookingLocators.getactualFlightDetails());

		for (WebElement details : actualFlight) {
			actualFlightdetails.add(details.getText());
		}
		return actualFlightdetails;
	}

	public  String getActualFlight() {
		String flightvalue = driver.findElement(BookingLocators.getactualFlightDetails()).getText();
		return flightvalue;
	}

	public  void selectWithoutAir() {
		clickUsingJavaScript(BookingLocators.getwithoutAir());

	}

	public  void fillBasicBookingDetails2(String destination, String stayingTime, String guestInfo)
			throws Exception {
		clearAndSetValues(BookingLocators.getgoingToTextbox(), destination);
		selectStayingTime(stayingTime);
		clickUsingJavaScript(BookingLocators.getnoMoreCitiesBtn());
		selectGuestDetails(guestInfo);
	}

	public  void clickChangedArriveDate() {
		clickUsingJavaScript(BookingLocators.getChangedArriveDate());
		boolean expecteddate = driver.findElement(BookingLocators.getChangedArriveDate()).isEnabled();
		Assert.assertTrue(expecteddate);
	}

	public  void fillBasicDetails(String leavefrom, String firstdestination, String stayingTime,
			String seconddestination, String seconddrop, String thirddestination, String thirddrop) throws Exception {

		clearAndSetValues(BookingLocators.getLeavingTxtbox(), leavefrom);
		clearAndSetValues(BookingLocators.getgoingToTextbox(), firstdestination);
		selectStayingTime(stayingTime);
		clickUsingJavaScript(BookingLocators.getaddCityBtn());
		clearAndSetValues(BookingLocators.getgoingToTextboxSecond(), seconddestination);
		selectStayingTimeTwo(seconddrop);
		clickUsingJavaScript(BookingLocators.getaddCityBtn());
		clearAndSetValues(BookingLocators.getgoingToTextboxThird(), thirddestination);
		selectStayingTimeThree(thirddrop);

	}

	public  void deleteAddedCities() {
		clickUsingJavaScript(BookingLocators.getthirdremoveCitylink());
		clickUsingJavaScript(BookingLocators.getsecondremovecitylink());

	}

	public  void getNoMoreCitiesButton() {
		clickUsingJavaScript(BookingLocators.getnoMoreCitiesBtn());
	}

	public  void selectguesdetatils(String guestinfo) throws Exception {
		selectGuestDetails(guestinfo);
	}

	public  boolean isremovecitydisplayed() {
		boolean result = false;
		if (driver.findElement(BookingLocators.getsecondremovecitylink()).isDisplayed()) {
			result = true;

		}
		return result;
	}

	public  void selectStayingTimeTwo(String stayingTimeTwo) {

		selectOptionByValue(BookingLocators.getstayingDrpdowntwo(), stayingTimeTwo);
	}

	public  void selectValueFromCalendar() {
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

	public  void selectCabinClass(String cabinclass) {
		selectOptionByText(BookingLocators.getCabinClassDropdown(), cabinclass);
	}

	/**
	 * Select Cabin Class For Mobile
	 * 
	 * @param cabinclass
	 * @throws Exception 
	 * @author Mrinal
	 */
	public  void selectCabinClassForMob(String cabinclass) throws Exception {
		if (TestBase.flag_Mob) {
			WebElement wb = driver.findElement(BookingLocators.getcabinSectionMob())
					.findElement(By.xpath(".//span[text()='" + cabinclass + "']/parent::p"));
			clickUsingJavaScript(wb);
		} else {
			selectOptionByText(BookingLocators.getCabinClassDropdown(), cabinclass);
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

	public  void bookingDetailswithPremiumEcomomy(String leavingFrom, String destination, String cabinclass,
			String stayingTime, String guestInfo) throws Exception {
		selectCabinClass(cabinclass);
		clearAndSetValues(BookingLocators.getLeavingTxtbox(), leavingFrom);
		clearAndSetValues(BookingLocators.getgoingToTextbox(), destination);
		selectStayingTime(stayingTime);
		clickUsingJavaScript(BookingLocators.getnoMoreCitiesBtn());
		selectGuestDetails(guestInfo);

	}

	public static String selectedcabinAssert() {

		if (TestBase.flag_Mob)
		{
			String expectedcabin = driver.findElement(HomePageLocators.getSelectPremiumEconomy()).getText();
			return expectedcabin;
		}
		else
		{ 
			String selectedcabin = driver.findElement(BookingLocators.getFirstpremiumOption()).getText();
		    return selectedcabin;
		}
	}
	public static String verifycabinAssert() {
		if(TestBase.flag_Mob)
		{
			String expectedcabin = driver.findElement(BookingLocators.getVerifyPremiumEconomy()).getText();
			return expectedcabin;
		}
		else
		{
		     String expectedcabin = driver.findElement(BookingLocators.getSecondpremiumOption()).getText();
		      return expectedcabin;
		}
	}

	public  void selectLatinAmericaLink() {
		clickUsingJavaScript(HomePageLocators.getExploreLatinAmericaLnk());
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
			clickUsingJavaScript(HomePageLocators.getSpotlightOnDrpDwn());
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
			clickUsingJavaScript(HomePageLocators.getfirstOptionUnderSpotlightDrpDwn());
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

	public  void oldArriveDate() {
		boolean actualdate = driver.findElement(BookingLocators.getArriveDate()).isEnabled();
		Assert.assertTrue(actualdate);
	}

	public  void tripSummary() {
		clickUsingJavaScript(BookingLocators.getTripSummaryButton());
	}

	public  void validateTripIncluisonPage() {
		boolean flag = false;
		if (driver.getTitle().contains("ItineraryDetails"))
			flag = true;
		else
			flag = false;

		Assert.assertTrue(flag);
	}

	public  void selectStayingTimeThree(String stayingTimeThree) {

		selectOptionByValue(BookingLocators.getstayingDrpdownthree(), stayingTimeThree);
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
