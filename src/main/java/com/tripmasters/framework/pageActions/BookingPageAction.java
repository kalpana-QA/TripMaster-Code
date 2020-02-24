package com.tripmasters.framework.pageActions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.tripmasters.framework.base.PageBase;
import com.tripmasters.framework.base.TestBase;
import com.tripmasters.framework.pageLocators.BookingLocators;
import com.tripmasters.framework.pageLocators.HomePageLocators;
import com.tripmasters.framework.reports.Logs;


public class BookingPageAction extends PageBase {

	ExtentTest test;
	
	public BookingPageAction(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void fillLeavingFromDetails(String leavingFrom) throws Exception{
		clearAndSetValues(BookingLocators.getLeavingTxtbox(), leavingFrom);
		Logs.info("User entered '" + leavingFrom + "' into leaving from field");
		//test.log(LogStatus.INFO, "User entered '" + leavingFrom + "' into leaving from field");
	}
	
	public void fillGoingToCityDetails(String destination) throws Exception{
		clearAndSetValues(BookingLocators.getgoingToTextbox(), destination);
		Logs.info("User entered '" + destination + "' into Going to from field");
		//test.log(LogStatus.INFO, "User entered '" + destination + "' into Going to from field");
	}
	
	public  void selectStayingTime(String stayingTime) {
		selectOptionByValue(BookingLocators.getstayingDrpdown(), stayingTime);
		Logs.info("User entered '" + stayingTime + "' nights staying time");
		//test.log(LogStatus.INFO, "User entered '" + stayingTime + "' nights staying time");
	}
	
	public void selectNoMoreCitiesBtn(){
		clickUsingJavaScript(BookingLocators.getnoMoreCitiesBtn());
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
		//	clickUsingJavaScript(HomePageLocators.getSelectPremiumEconomy());
		//	clickUsingJavaScript(BookingLocators.getdoneButton());
			Logs.info("User select '" + guestInfo + "' from Guest list");
			//test.log(LogStatus.INFO, "User select '" + guestInfo + "' from Guest list");
		} else {
			selectOptionByValue(BookingLocators.getselectGuestDrpdown(), guestInfo);
			Logs.info("User select '" + guestInfo + "' from Guest list");
			//test.log(LogStatus.INFO, "User select '" + guestInfo + "' from Guest list");
		}
	}
	
	public void selectPremiumEconomy()
	{
		if(TestBase.flag_Mob)
	{
		clickUsingJavaScript(HomePageLocators.getSelectPremiumEconomy());
	}
	}
	
	public void doneButtonMob() throws Exception
	{
	if(TestBase.flag_Mob){
		clickUsingJavaScript(BookingLocators.getdoneButton());
	   }
	}
	/*
	 * public void selectGuestDetailsForOneandOther(String guestInfo) {
	 * clickUsingJavaScript(BookingLocators.getselectGuestRoomOptions());
	 * clickUsingJavaScript(BookingLocators.getselectGuestRoomOptionsDrpdown());
	 * WebElement wb =
	 * driver.findElement(BookingLocators.getoptionListForGuestsAndRooms())
	 * .findElement(By.xpath(".//li[@id='" + guestInfo + "']"));
	 * clickUsingJavaScript(wb);
	 * clickUsingJavaScript(BookingLocators.getselectNumberOfAdults) }
	 */

	/**
	 * 
	 * @param guestInfo
	 */
	public  void selectGuestDetailsOnMob(String guestInfo) {
		selectOptionByValue(BookingLocators.getselectGuestDrpdown(), guestInfo);
		Logs.info("User select '" + guestInfo + "' from Guest list");
	}

	public  void clickonContinueButton() {

		clickUsingJavaScript(BookingLocators.getcontinueBtn());
	}

	public  void clickonContinueLink() throws Exception {
		if(TestBase.flag_Mob) {
			scrollDown();
			scrollDown();
			clickUsingJavaScript(BookingLocators.getcontinueLink());
		}
		else {
		clickUsingJavaScript(BookingLocators.getcontinueLink());
		}
	}

	public  String selectCheaperFlights() throws Exception {
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

	public  String selectCheaperFlights_Mob() throws Exception {
		
		isElementDisplayed(BookingLocators.getcheaperFlightsLink());
		scrollDown();
		clickUsingJavaScript(BookingLocators.getcheaperFlightsLink());
		String expectflightvalue = driver.findElement(BookingLocators.getexpectedFlight()).getText();
		System.out.println(expectflightvalue);
		clickUsingJavaScript(BookingLocators.getselectFlightOption());
		clickUsingJavaScript(BookingLocators.getselectbutton());
		isElementDisplayed(BookingLocators.getcontinueLink());
		scrollDown();
		scrollDown();
		clickUsingJavaScript(BookingLocators.getcontinueLink());
		return expectflightvalue;
	}

	public  void clicktoContinuePage() {
     if(!TestBase.flag_Mob){
			clickUsingJavaScript(BookingLocators.getcontinueImage());
     }
	}

	public  void selectNumberOfAdult(String numOfAdults, By element) throws Exception
	{
	if(TestBase.flag_Mob)
	{
		PageBase.waitForElement(3);
		
        clickUsingJavaScript(BookingLocators.getselectNumberOfAdultMob());
	}
	else
	{
		selectOptionByValue(element, numOfAdults);
	}
	}

	public  void ClickOnWithoutAir() {

		BookingLocators.getWithoutAirButton();

	}

	//TODO:this method need some modifications.
	public  void selectNumberOfChild(String numOfChild, String ageOfChild, String childType) throws Exception
	{
		
		if(TestBase.flag_Mob)
		{
			if(childType.equals("Child1"))
			{
				clickUsingJavaScript(BookingLocators.getselectNumberOfChildMob());
				PageBase.waitForElement(3);
				driver.findElement(BookingLocators.getclickChildDropdownMob()).click();
				driver.findElement(BookingLocators.getselectChildAgeDropdownMob()).click();
				PageBase.waitForElement(2);
				 
			  }
			
		   	else
			{
				//----------child for room 2---------
			}
		}
	else
		{
			if (childType.equals("Child1")) {
		
			selectOptionByValue(BookingLocators.getselectChildDrpdown(), numOfChild);
			Logs.info("User entered number of child'" + numOfChild + "' ");
			Select option = new Select(driver.findElement(By.xpath("//select[@id='xiChild1']")));
			option.selectByValue(ageOfChild);
			//selectOptionByValue(BookingLocators.getselectChildAgeDrpdown(), ageOfChild);
			Logs.info("User entered age of child'" + ageOfChild + "' ");
		} else {
			selectOptionByValue(BookingLocators.getselectChildRoom2Drpdown(), numOfChild);
			Logs.info("User entered number of child'" + numOfChild + "' ");
			Select option = new Select(driver.findElement(By.xpath("//select[@id='xRoom2_iChild1']")));
			option.selectByValue(ageOfChild);
			//selectOptionByValue(BookingLocators.getselectChildAgeRoom2Drpdown(), ageOfChild);
			Logs.info("User entered age of child'" + ageOfChild + "' ");
		}
		}
	}
	

//	public  void fillBasicBookingDetailForMultipleCities(String flightType, String destination,String stayingTime, String destination_second, String guestinfo) throws Exception {
//		if (flightType.equalsIgnoreCase("WithAir")) {
//			clearAndSetValues(BookingLocators.getLeavingTxtbox(), "New York, Newark, NJ");
//			Logs.info("User entered New York, Newark, NJ into leaving from field");
//		}
//		clearAndSetValues(BookingLocators.getgoingToTextbox(), destination);
//		Logs.info("User entered '" + destination + "' into Going to from field");
//		clickUsingJavaScript(BookingLocators.getaddCityBtn());
//		clearAndSetValues(BookingLocators.getgoingToTextboxSecond(), destination_second);
//		Logs.info("User entered '" + destination_second + "' into Second Going to field");
//		selectStayingTime(stayingTime);
//		clickUsingJavaScript(BookingLocators.getnoMoreCitiesBtn());
//		selectGuestDetails(guestinfo);
//	}
	
	private Select Select(WebElement findElement) {
		// TODO Auto-generated method stub
		return null;
	}

	public  void fillBasicDetatilsForMultipleCities(String leavefrom, String firstdestination,String stayingTime,String seconddestination,String seconddrop) throws Exception {
		clearAndSetValues(BookingLocators.getLeavingTxtbox(), leavefrom);
		clearAndSetValues(BookingLocators.getgoingToTextbox(), firstdestination);
		selectStayingTime(stayingTime);
		clickUsingJavaScript(BookingLocators.getaddCityBtn());
		clearAndSetValues(BookingLocators.getgoingToTextboxSecond(), seconddestination);
		selectStayingTimeTwo(seconddrop);
		
	}
	public void getTripinclusionContinueButton() throws Exception {
		if(TestBase.flag_Mob){
		scrollDown();
		scrollDown();
		clickUsingJavaScript(BookingLocators.getTripInclusionContinueButtonmob());
		}
	}

	public  void getWithoutButton() {

		clickUsingJavaScript(BookingLocators.getWithoutAirButton());
	}

//	public  void fillBasicBookingDetailWithoutAir(String destination, String stayingTime,
//			String destination_second, String guestinfo) throws Exception {
//
//		clearAndSetValues(BookingLocators.getgoingToTextbox(), destination);
//
//		clickUsingJavaScript(BookingLocators.getaddCityBtn());
//		clearAndSetValues(BookingLocators.getgoingToTextboxSecond(), destination_second);
//
//		selectStayingTime(stayingTime);
//		clickUsingJavaScript(BookingLocators.getnoMoreCitiesBtn());
//
//		selectGuestDetails(guestinfo);
//
//	}

	public  String browseHotelsButton() {
		clickUsingJavaScript(BookingLocators.getBrowseHotelsLink());
		String actualhotel = driver.findElement(BookingLocators.getFirstHotel()).getText();
		return actualhotel;
	}
	//satyam
	public String browseHoteliOS() throws Exception {
		scrollDown();
		scrollDown();
		clickUsingJavaScript(BookingLocators.getBrowseHotelsLink());
		String actualhotel = driver.findElement(BookingLocators.getfirstHoteliOS()).getText();
		System.out.println(actualhotel);
		return actualhotel;
	}
	
	

	public  String browseSelectHotel() {
		clickUsingJavaScript(BookingLocators.getselectFirstHotel());
		String expectedhotel = driver.findElement(BookingLocators.getExpectedHotel()).getText();
		return expectedhotel;
	}
	
	public String browseSelectHoteliOS() throws Exception {
		clickUsingJavaScript(BookingLocators.getselectFirstHotel());
		scrollDown();
		String expectedhotel = driver.findElement(BookingLocators.getExpectedHotel()).getText();
		System.out.println(expectedhotel);
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
				//test.log(LogStatus.INFO, "User selects '" + newDate + "' as Arriving_On Date");
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

	public  void bookingDetailswithPremiumEcomomy(String leavingFrom, String destination, String cabinclass,String stayingTime, String guestInfo) throws Exception {
		selectCabinClass(cabinclass);
		clearAndSetValues(BookingLocators.getLeavingTxtbox(), leavingFrom);
		clearAndSetValues(BookingLocators.getgoingToTextbox(), destination);
		selectStayingTime(stayingTime);
		clickUsingJavaScript(BookingLocators.getnoMoreCitiesBtn());
		selectGuestDetails(guestInfo);
	}

	public  String selectedcabinAssert() {

		if (TestBase.flag_Mob)
		{
			clickUsingJavaScript(HomePageLocators.getSelectPremiumEconomy());
		String expectedcabin = driver.findElement(HomePageLocators.getSelectPremiumEconomy()).getText();
		return expectedcabin;
		}
		else
		{
		String selectedcabin = driver.findElement(BookingLocators.getFirstpremiumOption()).getText();
		   return selectedcabin;
		}
		}
	
	    public String verifycabinAssert() {
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
	    
	    public  static boolean verifyCabin()
		{
		clickUsingJavaScript(HomePageLocators.getSelectPremiumEconomy());
		boolean verifycabin = driver.findElement(HomePageLocators.getSelectPremiumEconomy()).isEnabled();
		return verifycabin;
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

	public  void tripSummary() throws Exception 
	{
		if(TestBase.flag_Mob)
		{
			scrollDownForMob(4);
			clickUsingJavaScript(BookingLocators.getTripSummaryButton());
		   
         }
		else
		{
			clickUsingJavaScript(BookingLocators.getTripSummaryButton());
		}
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

	
	
	public void clickOnAddCityBtn(){
		clickUsingJavaScript(BookingLocators.getaddCityBtn());
	}

	public void fillSecndAddedCityDetails(String destination_second) throws Exception {
		clearAndSetValues(BookingLocators.getgoingToTextboxSecond(), destination_second);
		Logs.info("User entered '" + destination_second + "' into Second Going to field");
	}

	public void fillThirdAddedCityDetails(String destination_third) throws Exception {
		clearAndSetValues(BookingLocators.getgoingToTextboxThird(), destination_third);
		Logs.info("User entered '" + destination_third + "' into Second Going to field");
	}
}
