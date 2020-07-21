package com.tripmasters.framework.testScript;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.tripmasters.framework.Listeners.Retry;
import com.tripmasters.framework.Listeners.RetryCountIfFailed;
import com.tripmasters.framework.base.PageBase;
import com.tripmasters.framework.base.TestBase;
import com.tripmasters.framework.pageLocators.BookingLocators;
import com.tripmasters.framework.pageLocators.HomePageLocators;
import com.tripmasters.framework.reports.ExtentTestManager;
import com.tripmasters.framework.reports.Logs;

public class BookingPageTestScript extends TestBase {

	static Logs logs=new Logs();
	
	List<String> expectedFirstTravellerInfo = new ArrayList<String>();
	List<String> expectedSecondTravellerInfo = new ArrayList<String>();
	List<String> expectedThirdTravellerInfo = new ArrayList<String>();
	List<String> expectedFourthTravellerInfo = new ArrayList<String>();
	List<String> expectedFlightDetails = new ArrayList<String>();
	
	
	private static String ActualHotel;
	private static String ExpectedHotel;

	
	 @Test(groups= {"smoke"},priority=19)
	public void TC_0019_withoutAirBookingForSingleCity(Method method) throws Exception {
		ExtentTest test=ExtentTestManager.startTest(method.getName(), "TC_0019_withoutAirBookingForSingleCity");
		logs.startTestCase(method.getName());
		test.log(LogStatus.INFO, "User entered the URL: 'https://www.tripmasters.com/");
		bookingPage.selectWithoutAir();
		test.log(LogStatus.INFO, "Select withOut Air Option on HomePage");
		logs.info("Select withOut Air Option on HomePage");
		bookingPage.fillGoingToCityDetails("Delhi (India)");
		test.log(LogStatus.INFO, "User entered \"Delhi (India)\" into Going To City field");
		String selectDate=bookingPage.selectValueFromCalendar(99,1);
		System.out.println("date is "+ selectDate);	
		String selecteddate = bookingPage.getSelectedDate();
		test.log(LogStatus.INFO,   "User selects arrival date '" + selecteddate + "'from calendar");
		bookingPage.selectStayingTime("5");
		test.log(LogStatus.INFO,   "Select staying time 5 nights");
		bookingPage.selectNoMoreCitiesBtn();
		test.log(LogStatus.INFO,   "Click on Next Button");
		bookingPage.selectGuestDetails("1|3");
		test.log(LogStatus.INFO,   "Select 1 Room for 3 Adults");
		test.log(LogStatus.INFO, "User fills all the basic details of journey:Source,Destination & Staying Time");
		logs.info("User fills all the basic details of journey:Source,Destination & Staying Time");
		bookingPage.clickonContinueButton();
		test.log(LogStatus.INFO, "Click on Continue Button");
		String sessionID=bookingPage.getSessionID();
		test.log(LogStatus.INFO, "Session ID is: '"+sessionID+"'");
		logs.info("Click on Continue Button");
		String Actualresult = bookingPage.browseHotelsButton();
		test.log(LogStatus.INFO, "Click on Browse Hotels Button");
		logs.info("Click on Browse Hotels Button");
		bookingPage.selectFirstHotel();
		PageBase.scrollDownForMob(1);
		String expectedresult = bookingPage.browseSelectHotel();
		test.log(LogStatus.INFO, "Select particular hotel from Hotel Options");
		logs.info("Select particular hotel from Hotel Options");
		Assert.assertEquals(Actualresult, expectedresult);
		test.log(LogStatus.INFO, "Verify that only selected hotel appears");
		logs.info("Verify that only  selected hotel appears ");
		logs.endTestCase(method.getName());
	}
	 
	@Test(groups= {"smoke"},priority=20)
	public void TC_0020_withoutAirBookingForMultipleCity(Method method) throws Exception {
		ExtentTest test=ExtentTestManager.startTest(method.getName(), "TC_0020_withoutAirBookingForMultipleCity");
		logs.startTestCase(method.getName());
		test.log(LogStatus.INFO, "User entered the URL: 'https://www.tripmasters.com/");
		bookingPage.getWithoutButton();
		Thread.sleep(8000);
		test.log(LogStatus.INFO, "Click on WithOut Air Button");
		logs.info("Click on WithOut Air Button");
		bookingPage.fillGoingToCityDetails("Delhi (India)");
		test.log(LogStatus.INFO,   "User entered \"Delhi (India)\" into Going To City field");
		Thread.sleep(4000);
		bookingPage.selectStayingTime("4");
		test.log(LogStatus.INFO,   "Select staying time 4 nights");
		Thread.sleep(4000);
		String selectDate=bookingPage.selectValueFromCalendar(100,1);
		System.out.println("date is "+ selectDate);	
		String selecteddate = bookingPage.getSelectedDate();
		test.log(LogStatus.INFO,   "User selects arrival date '" + selecteddate + "'from calendar");
		bookingPage.clickOnAddCityBtn();
		test.log(LogStatus.INFO,   "Click on + Add Destination button");
		Thread.sleep(4000);
		bookingPage.fillSecndAddedCityDetails("Mumbai (India)");
		test.log(LogStatus.INFO,   "User entered \"Mumbai (India)\" into Going To City field");
		bookingPage.selectStayingTimeTwo("1");
		test.log(LogStatus.INFO, "Select staying time :1 night");
		Thread.sleep(4000);
		bookingPage.selectNoMoreCitiesBtn();
		test.log(LogStatus.INFO,   "Click on Next Button");
		Thread.sleep(8000);
		bookingPage.selectGuestDetails("1|3");
		test.log(LogStatus.INFO,   "User selects 1 Room for 3 Adults");
		test.log(LogStatus.INFO, "Filled all the basic details of journey along with source & destination");
		logs.info("Filled all the basic details of journey along with source & destination");
		Thread.sleep(8000);
		bookingPage.clickonContinueButton();
		test.log(LogStatus.INFO,   "Click on Continue Button");
		String sessionID=bookingPage.getSessionID();
		test.log(LogStatus.INFO, "Session ID is: '"+sessionID+"'");

		ActualHotel = bookingPage.browseHotelsButton();
		test.log(LogStatus.INFO, "Click on Browse Hotels Button");
		Thread.sleep(8000);
		logs.info("Click on Browse Hotels Button");
		bookingPage.selectFirstHotel();
		Thread.sleep(8000);
		PageBase.scrollDownForMob(1);
		ExpectedHotel = bookingPage.browseSelectHotel();
		test.log(LogStatus.INFO, "Select particular hotel from Hotel Options");
		logs.info("Select particular hotel from Hotel Options");
		Assert.assertEquals(ActualHotel, ExpectedHotel);
		test.log(LogStatus.INFO, "Verify that only particular selected hotel appears along with selected cities");
		logs.info("Verify that only particular selected hotel appears along with selected cities");
		
	
	
	}

     @Test(groups= {"smoke"},priority=14)
	public void TC_0014_verifySpotlightLink(Method method) throws Exception {
    	String PageTitle=null;
		ExtentTest test=ExtentTestManager.startTest(method.getName(), "TC_0014_verifySpotlightLink");
		logs.startTestCase(method.getName());
		test.log(LogStatus.INFO, "User entered the URL: 'https://www.tripmasters.com/");
		test.log(LogStatus.INFO, "User validates that In the Spotlight heading is available on homepage");
		bookingPage.selectLatinAmericaLink();
		test.log(LogStatus.INFO, "Select Latin America Link from Spotlight section");
		logs.info("Select Latin America Link");
		bookingPage.verifyLatinAmericPage();
		test.log(LogStatus.INFO, "User redirected to the Latin America Page");
		logs.info("User redirected to the Latin America Page");
		String title=bookingPage.clickOnFirstOptionUnderSpotlightForMob();
		bookingPage.verifyPageDisplayed(title);
		test.log(LogStatus.INFO, "Spotlight link verified!");
        logs.info("Spotlight link verified!");
        logs.endTestCase(method.getName());
	}
	
    
    @Test(groups= {"smoke"},priority=9)
	public void TC_0009_dateChanging(Method method) throws Exception {
		ExtentTest test=ExtentTestManager.startTest(method.getName(), "TC_0009_dateChanging");
		logs.startTestCase(method.getName());
		test.log(LogStatus.INFO, "User entered the URL: 'https://www.tripmasters.com/");
		bookingPage.clickOnBuildYourVacationDropDown();
		bookingPage.fillLeavingFromDetails("New York, Newark, NJ");
		test.log(LogStatus.INFO, "User entered \"New York, Newark, NJ - EWR\" into leaving from field");
		bookingPage.fillGoingToCityDetails("Berlin (Germany)");
		test.log(LogStatus.INFO, "User entered \"Berlin (Germany)\" into Going to from field");
		String selectDate=bookingPage.selectValueFromCalendar(91,1);
		System.out.println("date is "+ selectDate);	
		String selecteddate = bookingPage.getSelectedDate();
		test.log(LogStatus.INFO,   "User selects arrival date '" + selecteddate + "'from calendar");
		bookingPage.selectStayingTime("12");
		test.log(LogStatus.INFO, "Select staying time :12 nights");
		bookingPage.selectNoMoreCitiesBtn();
		test.log(LogStatus.INFO,   "Click on Next Button");
		bookingPage.selectGuestDetails("1|2");
		test.log(LogStatus.INFO, "User select 1 Room with 2 Adults");
		test.log(LogStatus.INFO, "Booking details Source & Destination filled successfully ");
		logs.info("Booking details Source & Destination filled successfully ");
		bookingPage.clickonContinueButton();
		test.log(LogStatus.INFO, "Click on Continue Button");
		String sessionID=bookingPage.getSessionID();
		test.log(LogStatus.INFO, "Session ID is: '"+sessionID+"'");
		bookingPage.clickChangedArriveDate();
		test.log(LogStatus.INFO, "Click to change Arrive Date from suggested options");
		bookingPage.oldArriveDate();
		test.log(LogStatus.INFO, "Arrival Date get changed,Verified!");
		ActualHotel = bookingPage.browseHotelsButton_EuropePage();
		test.log(LogStatus.INFO, "Click on Browse Hotels Button");
		logs.info("Click on Browse Hotels Button");
		bookingPage.selectFirstHotel();
		PageBase.scrollDownForMob(1);
		ExpectedHotel = bookingPage.browseSelectHotel();
		test.log(LogStatus.INFO, "Select particular hotel from Hotel Options");
		logs.info("Select particular hotel from Hotel Options");
		Assert.assertEquals(ActualHotel, ExpectedHotel);
		test.log(LogStatus.INFO, "Validate selected hotel name is displayed");
		bookingPage.selectCheaperFlights("Coach/Economy");
		test.log(LogStatus.INFO, "User clicks on Browse all Flights link");
		test.log(LogStatus.INFO, "User selects a particular flight from existing options");
		logs.info("Select Cheaper flights from flight options");
		test.log(LogStatus.INFO, "User clicks on Select button");
		test.log(LogStatus.INFO, "User selects cabin class:Coach/Economy");
		test.log(LogStatus.INFO, "click to continue button");
		bookingPage.getTripinclusionContinueButton();
		bookingPage.clicktoContinuePage();
		test.log(LogStatus.INFO, "User clicks on Continue  to arrive in Pax Info Page");
		expectedFirstTravellerInfo = passengerInfoPage.fillFirstTravellerDetails("Morris", "Leo", "Male","01/01/1992", "237|US");
		
		test.log(LogStatus.INFO, "User enters \"Morris\" as First Traveller First Name");
		test.log(LogStatus.INFO, "User enters \"Mano\" as First Traveller Last Name");
		test.log(LogStatus.INFO, "User selects \"Gender:Male\" for First Traveller");
		test.log(LogStatus.INFO, "User selects \"DOB:01/01/1992\" for First Traveller's Date of Birth");
		test.log(LogStatus.INFO, "User selects \"Passport details as:US\" for First Traveller");
		
		
		expectedSecondTravellerInfo = passengerInfoPage.fillSecondTravellerDetails("Shally", "Leo", "Male","01/01/1994", "237|US", "Adult");
	
		test.log(LogStatus.INFO, "User enters \"Shally\" as Second Traveller First Name");
		test.log(LogStatus.INFO, "User enters \"Mano\" as Second Traveller Last Name");
		test.log(LogStatus.INFO, "User selects \"Female\" for Second Traveller Last Name");
		test.log(LogStatus.INFO, "User selects \"DOB:01/01/1994\" for Second Traveller's Date of Birth");
		test.log(LogStatus.INFO, "User selects \"Passport details as:US\" for Second Traveller");
		test.log(LogStatus.INFO, "User filled all the passenger details successfully");
		
		
		logs.info("User filled all the passenger details successfully");
		bookingPage.getTripinclusionContinueButton();
		bookingPage.clicktoContinuePage();
		if(TestBase.flag_Mob){
			PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler1NameiOS(), expectedFirstTravellerInfo);
			PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler2NameiOS(), expectedSecondTravellerInfo);
		}else{
		PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler1Name(), expectedFirstTravellerInfo);
		PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler2Name(), expectedSecondTravellerInfo);
		}
		
		
		
		test.log(LogStatus.INFO, "Click on Continue button to validate trip summary on Payment page");
		
		
		test.log(LogStatus.INFO, "Flights & passenger details verified successfully on PaymentPage");
		logs.info("Flights & passenger details verified successfully on PaymentPage");
		bookingPage.tripSummary();
		logs.endTestCase(method.getName());
	}

   @Test(groups= {"smoke"},priority=18)
		public void TC_0018_bookingDetailswithPremiumEcomomy(Method method) throws Exception {
			ExtentTest test =ExtentTestManager.startTest(method.getName(), "TC_0018_bookingDetailswithPremiumEcomomy");
			logs.startTestCase(method.getName());
			test.log(LogStatus.INFO, "User entered the URL: 'https://www.tripmasters.com/");
			bookingPage.clickOnBuildYourVacationDropDown();
			bookingPage.fillLeavingFromDetails("New York City (all Airports)");
			test.log(LogStatus.INFO, "User entered \"New York City (all Airports)\" into leaving from field");
			bookingPage.fillGoingToCityDetails("Delhi (India)");
			test.log(LogStatus.INFO, "User entered \"Delhi (India)\" into Going To City field");
			String selectDate=bookingPage.selectValueFromCalendar(103,1);
			System.out.println("date is "+ selectDate);	
			String selecteddate = bookingPage.getSelectedDate();
			test.log(LogStatus.INFO,   "User selects arrival date '" + selecteddate + "'from calendar");
			bookingPage.selectCabinClass("Premium Economy");
			test.log(LogStatus.INFO, "Select Cabin Class:Premium");
			bookingPage.selectStayingTime("4");
			test.log(LogStatus.INFO, "Select staying time :4 nights");
			bookingPage.selectNoMoreCitiesBtn();
			test.log(LogStatus.INFO,   "Click on Next Button");
			bookingPage.selectGuestDetails("1|1");
			test.log(LogStatus.INFO, "Select 1 Room for 1 Adult");
			bookingPage.selectPremiumEconomy();
			bookingPage.doneButtonMob();
			test.log(LogStatus.INFO, "Filled flights details with premium economy");
			logs.info("Filled flights details with premium economy");
			String actualcabin = bookingPage.selectedcabinAssert();
			System.out.println("This is for Actual "+actualcabin);
			logs.info("Select Cabin class");
			if(TestBase.flag_Mob){
			  boolean cabinVerify = bookingPage.verifyCabin();
				   Assert.assertTrue(cabinVerify);
				   }
			bookingPage.clickonContinueButton();
			test.log(LogStatus.INFO, "Click on Continue Button");
			String sessionID=bookingPage.getSessionID();
			test.log(LogStatus.INFO, "Session ID is: '"+sessionID+"'");
			bookingPage.getContinueLink();
			test.log(LogStatus.INFO, "Click on Continue link to navigate to Trip Inclusion Page");
			Thread.sleep(4000);
			String expectedcabin = bookingPage.verifycabinAssert();
			System.out.println("This is for Expected "+expectedcabin);
			Assert.assertEquals(expectedcabin, actualcabin);
			test.log(LogStatus.INFO, "Selected Cabin class:Premium Economy verified");
			logs.info("Selected Cabin class verified");
			test.log(LogStatus.INFO, "bookingDetailswithPremiumEcomomy verified on Trip Inclusion Page");
			logs.info("bookingDetailswithPremiumEcomomy passed");
			logs.endTestCase(method.getName());
		}
		
	@Test(groups= {"smoke"},priority=21)
	public void TC_0021_FlightbookingJourneywithmultipleCities(Method method) throws Exception {
		ExtentTest test=ExtentTestManager.startTest(method.getName(), "TC_0021_FlightbookingJourneywithmultipleCities");
		logs.startTestCase(method.getName());
		test.log(LogStatus.INFO, "User entered the URL: 'https://www.tripmasters.com/");
		bookingPage.clickOnBuildYourVacationDropDown();	
		bookingPage.fillLeavingFromDetails("Washington DC (all Airports), US");		
		test.log(LogStatus.INFO, "User entered \"Washington DC (all Airports), US\" into leaving from field");
		bookingPage.fillGoingToCityDetails("London (England)");		
		test.log(LogStatus.INFO, "User entered \"London (England)\" into Going to from field");
		String selectDate=bookingPage.selectValueFromCalendar(90,1);
		System.out.println("date is "+ selectDate);	
		String selecteddate = bookingPage.getSelectedDate();
		test.log(LogStatus.INFO,   "User selects arrival date '" + selecteddate + "'from calendar");
		bookingPage.selectStayingTime("3");		
		test.log(LogStatus.INFO, "Select staying time :3 nights");
		bookingPage.clickOnAddCityBtn();
		test.log(LogStatus.INFO, "Click on + Add Destination button");
		bookingPage.fillSecndAddedCityDetails("Paris (France)");		
		test.log(LogStatus.INFO, "User entered \"Paris (France)\" into Going to from field");
		bookingPage.selectStayingTimeTwo("1");
		test.log(LogStatus.INFO, "Select staying time :1 night");
		bookingPage.clickOnAddCityBtn();
		test.log(LogStatus.INFO, "Click on + Add Destination button");
		bookingPage.fillThirdAddedCityDetails("Rome (Italy)");		
		test.log(LogStatus.INFO, "User entered \"Rome (Italy)\" into Going to from field for adding second city");		
		bookingPage.selectStayingTimeThree("3");
		test.log(LogStatus.INFO, "Select staying time :3 nights");
		bookingPage.clickonContinue();
		test.log(LogStatus.INFO,   "Click on Next Button");
		Thread.sleep(6000);
		Thread.sleep(6000);
		bookingPage.selectGuestDetails("1|2");
		test.log(LogStatus.INFO, "User select \"1 Room With 2 Adults\" from Guest list");
		Thread.sleep(6000);
		bookingPage.clickonContinueButton();
		test.log(LogStatus.INFO, "Click on Continue button");
		Thread.sleep(6000);
		String sessionID=bookingPage.getSessionID();
		test.log(LogStatus.INFO, "Session ID is: '"+sessionID+"'");
		bookingPage.selectCheaperFlights("Coach/Economy");
		test.log(LogStatus.INFO, "User clicks on Browse all Flights link");
		test.log(LogStatus.INFO, "User selects a particular flight from existing options");
		logs.info("Select Cheaper flights from flight options");
		test.log(LogStatus.INFO, "User clicks on Select button");
		test.log(LogStatus.INFO, "User selects cabin class:Coach/Economy");
		test.log(LogStatus.INFO, "User clicks on Continue button");
		bookingPage.validateTripPage();
		test.log(LogStatus.INFO, "Validate trip summary along with multiple cities on TripInclusion Page");
		logs.endTestCase(method.getName());
	}
	
	//new
	@Test(groups= {"smoke"},priority=17)
	public void TC_0017_validateTripSummarywithMultipleCitiesforAsianPacificPage(Method method) throws Exception {
		ExtentTest test=ExtentTestManager.startTest(method.getName(), "TC_0017_validateTripSummarywithMultipleCitiesforAsianPacificPage");
		logs.startTestCase(method.getName());
		test.log(LogStatus.INFO, "User entered the URL: 'https://www.tripmasters.com/");
		bookingPage.clickOnBuildYourVacationDropDown();
		//Thread.sleep(8000);
		bookingPage.clickonAsian_PacificLink();
		test.log(LogStatus.INFO, "User clicked on Asian,Pacific Link.");
		test.log(LogStatus.INFO, "User redirected to Asian Pacific Page");
		bookingPage.fillLeavingFromDetails("New York, Newark, NJ");
		test.log(LogStatus.INFO, "User leaving from: New York, Newark, NJ");
	//	Thread.sleep(4000);
		bookingPage.fillGoingToCityDetails("Delhi (India)");
		test.log(LogStatus.INFO, "User going to City: Delhi (India)");
		//Thread.sleep(4000);
		String selectDate=bookingPage.selectValueFromCalendar(185,3);
		
		test.log(LogStatus.INFO,   "User selects arrival date '" + selectDate + "' from calendar");
		System.out.println("date is "+selectDate);
		bookingPage.selectStayingTime("4");
		test.log(LogStatus.INFO, "Select staying time :4 nights");
		//Thread.sleep(4000);
		bookingPage.clickOnAddCityBtn();
		test.log(LogStatus.INFO, "Click on + Add Destination Button");
		//Thread.sleep(4000);
		bookingPage.fillSecndAddedCityDetails("Mumbai (India)");
		test.log(LogStatus.INFO, "User select another city:Mumbai (India)");
	//	Thread.sleep(4000);
		bookingPage.selectStayingTimeTwo("1");
		test.log(LogStatus.INFO, "Select staying time :1 night");
	//	Thread.sleep(4000);
		bookingPage.clickOnAddCityBtn();
		test.log(LogStatus.INFO, "Click on + Add Destination Button");
	//	Thread.sleep(4000);
		bookingPage.fillThirdAddedCityDetails("Chennai -Madras (India)");
		test.log(LogStatus.INFO, "User select another city:Chennai -Madras (India)");
	//	Thread.sleep(4000);
		bookingPage.selectStayingTimeThree("1");
		test.log(LogStatus.INFO, "Select staying time :1 night");
	//	Thread.sleep(4000);
		test.log(LogStatus.INFO, "Filled all the basic details for multiple cities");
		logs.info("Fill all the basic details for multiple cities");
		logs.info("Adding multiple cities in destinations");
		test.log(LogStatus.INFO,"Verify that multiple cities got selected as destinations");
		bookingPage.selectNoMoreCitiesBtn();
		test.log(LogStatus.INFO, "Click on Next Button");
		bookingPage.clickOnRemoveBtnThirdCity();
		test.log(LogStatus.INFO, "Click on edit/Remove option corresponding to Chennai -Madras (India)");
		boolean actual = bookingPage.isremovecitydisplayed();
		Assert.assertTrue(actual);
		bookingPage.deleteAddedCities();
	//	Thread.sleep(4000);
		test.log(LogStatus.INFO, "User click on Remove City Button corresponding to Chennai-Madras(India)");
		bookingPage.validateremovedcity();
	//	Thread.sleep(4000);
		test.log(LogStatus.INFO, "Last added city Chennai-Madras(India) removed successfully.Verified!");
		logs.info("Last added cities removed successfully.Verified!");
		bookingPage.getNoMoreCitiesButton();
		test.log(LogStatus.INFO, "Click on Next Button");
	//	Thread.sleep(4000);
	String travel =	bookingPage.ValidateTravelByOption();
		test.log(LogStatus.INFO, "Travel By " +travel+ " Option validated from one city to another");
		bookingPage.selectGuestDetails("1|Other");
		test.log(LogStatus.INFO, "User select \"1 Room With Other Options\" from Guest list");
		bookingPage.selectNumberOfAdult("2", BookingLocators.getselectAdultDrpdown());
		test.log(LogStatus.INFO, "User selects \"2\" Adult from Adult Drpdown");
		bookingPage.selectNumberOfChild("1", "11", "Child1");
		test.log(LogStatus.INFO, "User selects \"1\" Child,\"Age of Child:11\"");
		bookingPage.clickonContinueButton();
		test.log(LogStatus.INFO, "User clicks on Continue button");
	//	Thread.sleep(4000);
		String sessionID=bookingPage.getSessionID();
		test.log(LogStatus.INFO, "Session ID is: '"+sessionID+"'");
		bookingPage.selectCheaperFlights("Coach/Economy");
		Thread.sleep(10000);
		test.log(LogStatus.INFO, "User clicks on Browse all Flights link");
		test.log(LogStatus.INFO, "User selects a particular flight from existing options");
		logs.info("Select Cheaper flights from flight options");
		test.log(LogStatus.INFO, "User clicks on Select button");
		test.log(LogStatus.INFO, "User selects cabin class:Coach/Economy");
		test.log(LogStatus.INFO, "User clicks on Continue button");
		bookingPage.validateTripIncluisonPage();
		Thread.sleep(4000);
		test.log(LogStatus.INFO, "Validate that selected flight on Review & Customize Package Page");
		logs.info("Validate that selected flight on Review & Customize Package Page");
		logs.endTestCase(method.getName());
	}

	//new
	@Test(groups= {"smoke"},priority=8)
	public void TC_0008_bookingFlightAndHotelwithMultipleCitiesForEuropePage(Method method) throws Exception {
		ExtentTest test=ExtentTestManager.startTest(method.getName(), "TC_0008_bookingFlightAndHotelwithMultipleCitiesForEuropePage");
		logs.startTestCase(method.getName());
		test.log(LogStatus.INFO, "User entered the URL: 'https://www.tripmasters.com/");
		bookingPage.clickOnBuildYourVacationDropDown();
		bookingPage.clickonEuropeLink();
		test.log(LogStatus.INFO, "User clicked on Europe Link.");
		test.log(LogStatus.INFO, "User redirected to Europe Page");
		bookingPage.fillLeavingFromDetails("New York City (all Airports),  NY");
		test.log(LogStatus.INFO, "User entered leaving from: New York City (all Airports),  NY");
		bookingPage.fillGoingToCityDetails("Rome (Italy)");
		test.log(LogStatus.INFO, "User entered Going to City:Rome (Italy)");
		String selectDate=bookingPage.selectValueFromCalendar(220,4);
		System.out.println("date is "+ selectDate);
		test.log(LogStatus.INFO,   "User selects arrival date '" + selectDate + "' from calendar");
		bookingPage.selectStayingTime("4");
		test.log(LogStatus.INFO, "Select staying time :4 nights");
		bookingPage.clickOnAddCityBtn();
		test.log(LogStatus.INFO, "Click on + Add Destination Button");
		bookingPage.fillSecndAddedCityDetails("Florence (Italy)");
		test.log(LogStatus.INFO, "User select another city:Florence (Italy)");
		bookingPage.selectStayingTimeTwo("5");
		test.log(LogStatus.INFO, "Select staying time :5 nights");
		bookingPage.clickOnAddCityBtn();
		test.log(LogStatus.INFO, "Click on + Add Destination Button");
		bookingPage.fillThirdAddedCityDetails("Venice (Italy)");
		test.log(LogStatus.INFO, "User select another city:Venice (Italy)");
		Thread.sleep(4000);
		bookingPage.selectStayingTimeThree("4");
		test.log(LogStatus.INFO, "Select staying time :4 nights");
		bookingPage.selectNoMoreCitiesBtn();
		test.log(LogStatus.INFO,   "Click on Next Button");
		bookingPage.ValidateTravelByOption();
		test.log(LogStatus.INFO, "Travel By Option validated from one city to another");
		bookingPage.selectGuestDetails("1|Other");
		test.log(LogStatus.INFO, "User select \"1 Room With Other Options\" from Guest list");
		bookingPage.selectNumberOfAdult("2", BookingLocators.getselectAdultDrpdown());
		test.log(LogStatus.INFO, "User selects \"2\" Adult from Adult Drpdown");
		bookingPage.selectNumberOfChild("1", "11", "Child1");
		test.log(LogStatus.INFO, "User selects \"1\" Child,\"Age of Child:11\"");
		test.log(LogStatus.INFO, "Booking details filled successfully for multiple cities");
		logs.info("Booking details filled successfully for multiple cities");
		bookingPage.clickonContinueButton();
		test.log(LogStatus.INFO, "Click on Continue Button");
		String sessionID=bookingPage.getSessionID();
		test.log(LogStatus.INFO, "Session ID is: '"+sessionID+"'");
		logs.info("Click on Continue Button");
		ActualHotel = bookingPage.browseHotelsButton_EuropePage();
		test.log(LogStatus.INFO, "Click on Browse Hotels Button");
		logs.info("Click on Browse Hotels Button");
		bookingPage.selectFirstHotel();
		PageBase.scrollDownForMob(1);
		ExpectedHotel = bookingPage.browseSelectHotel();
		test.log(LogStatus.INFO, "Select particular hotel from Hotel Options");
		logs.info("Select particular hotel from Hotel Options");
		//Assert.assertEquals(ActualHotel, ExpectedHotel);
		test.log(LogStatus.INFO, "Validate selected hotel name is displayed");
		bookingPage.selectCheaperFlights("Business");
		test.log(LogStatus.INFO, "User clicks on Browse all Flights link");
		test.log(LogStatus.INFO, "User selects a particular flight from existing options");
		logs.info("Select Cheaper flights from flight options");
		test.log(LogStatus.INFO, "User clicks on Select button");
		test.log(LogStatus.INFO, "User selects cabin class:Business");
		bookingPage.getTripinclusionContinueButton();
		bookingPage.clicktoContinuePage();
		test.log(LogStatus.INFO, "User clicks on Continue  to arrive in Pax Info Page");
		expectedFirstTravellerInfo = passengerInfoPage.fillFirstTravellerDetails("Morris", "Leo", "Male","01/01/1992", "237|US");
	
		test.log(LogStatus.INFO, "User enters \"Morris\" as First Traveller First Name");
		test.log(LogStatus.INFO, "User enters \"Mano\" as First Traveller Last Name");
		test.log(LogStatus.INFO, "User selects \"Gender:Male\" for First Traveller");
		test.log(LogStatus.INFO, "User selects \"DOB:01/01/1992\" for First Traveller's Date of Birth");
		test.log(LogStatus.INFO, "User selects \"Passport details as:US\" for First Traveller");
		
		
		
		expectedSecondTravellerInfo = passengerInfoPage.fillSecondTravellerDetails("Shally", "Leo", "Male","01/01/1994", "237|US", "Adult");
		
		test.log(LogStatus.INFO, "User enters \"Shally\" as Second Traveller First Name");
		test.log(LogStatus.INFO, "User enters \"Mano\" as Second Traveller Last Name");
		test.log(LogStatus.INFO, "User selects \"Female\" for Second Traveller");
		test.log(LogStatus.INFO, "User selects \"DOB:01/01/1994\" for Second Traveller's Date of Birth");
		test.log(LogStatus.INFO, "User selects \"Passport details as:US\" for Second Traveller");
		
		
		
		expectedThirdTravellerInfo = passengerInfoPage.fillThirdTravellerDetails_Child("Marie", "Mano", "Female","01/01/2009", "237|US");
		

		test.log(LogStatus.INFO, "User enters \"Marie\" as Third Traveller First Name");
		test.log(LogStatus.INFO, "User enters \"Mano\" as Third Traveller Last Name");
		test.log(LogStatus.INFO, "User selects \"Female\" for Third Traveller");
		test.log(LogStatus.INFO, "User selects \"DOB:01/01/2009\" for Third Traveller's Date of Birth");
		test.log(LogStatus.INFO, "User selects \"Passport details as:US\" for Third Traveller");
		test.log(LogStatus.INFO, "User filled all the passenger details successfully");
		
		
		
		logs.info("User filled all the passenger details successfully");
		bookingPage.getTripinclusionContinueButton();
		bookingPage.clicktoContinuePage();
		if(TestBase.flag_Mob){
			PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler1NameiOS(), expectedFirstTravellerInfo);
		}else{
			PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler1Name(), expectedFirstTravellerInfo);
			PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler2Name(), expectedSecondTravellerInfo);
			PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler3Name(), expectedThirdTravellerInfo);
			}
		
		
		
		
		
		test.log(LogStatus.INFO, "Click on Continue Button & User redirected to the Payment Page");
		
		test.log(LogStatus.INFO, "Flights & passenger details verified successfully on PaymentPage");
		logs.info("Flights & passenger details verified successfully on PaymentPage");
		logs.endTestCase(method.getName());
	}
	
	//new
	@Test(groups = { "smoke" }, priority = 1)
	public void TC_0001_bookingJourneyWithOutAirForTwoRoomsPAXDetails(Method method) throws Exception {
	    ExtentTest test = ExtentTestManager.startTest(method.getName(), "TC_0001_bookingJourneyWithOutAirForTwoRoomsPAXDetails");
	    logs.startTestCase(method.getName());
	    test.log(LogStatus.INFO, "User entered the URL: 'https://www.tripmasters.com/");
	    bookingPage.clickOnBuildYourVacationDropDown();
		bookingPage.selectWithoutAir();
		test.log(LogStatus.INFO, "Select withOut Air Option on HomePage");
		logs.info("Select withOut Air Option on HomePage");
		bookingPage.fillGoingToCityDetails("Berlin (Germany)");
		test.log(LogStatus.INFO, "User entered \"Berlin (Germany)\" into Going to from field");
		String selectDate=bookingPage.selectValueFromCalendar(118,1);
		System.out.println("date is "+ selectDate);	
		String selecteddate = bookingPage.getSelectedDate();
		test.log(LogStatus.INFO,   "User selects arrival date '" + selecteddate + "'from calendar");
		//System.out.println(selectDate);
		bookingPage.selectStayingTime("4");
		test.log(LogStatus.INFO, "User entered \"4\" nights staying time");	
		bookingPage.selectNoMoreCitiesBtn();
		test.log(LogStatus.INFO,   "Click on Next Button");
		bookingPage.selectGuestDetails("2|Other");
		test.log(LogStatus.INFO, "User selects 2 Rooms with other options");
		bookingPage.select2NumberOfAdultForRoom1("1", BookingLocators.getselectAdultDrpdown());
		test.log(LogStatus.INFO, "User selects \"1\" Adult from Adult Drpdown for Room 1");
		bookingPage.selectNumberOfChild("1", "3", "Child1");
		test.log(LogStatus.INFO, "User selects \"1\" child from Child Drpdown for Room 1");
		test.log(LogStatus.INFO, "User selects, Age of Child:3");
		bookingPage.select1NumberOfAdultForRoom2("3", BookingLocators.getselectAdultRoom2Drpdown());
		test.log(LogStatus.INFO, "User selects \"3\" Adults from Adult Drpdown for Room2 ");
		bookingPage.doneButtonMob();
		test.log(LogStatus.INFO, "All the basic booking details Source & Destination filled successfully for 4 Adults_1Child_4nights");
		bookingPage.clickonContinueButton();
		test.log(LogStatus.INFO, "Click on \"Continue\" Button");
		String sessionID=bookingPage.getSessionID();
		test.log(LogStatus.INFO, "Session ID is: '"+sessionID+"'");
		bookingPage.browseHotelsButton();
		test.log(LogStatus.INFO, "Click to browse hotels");
		bookingPage.browseHotelsBy_Reviewscore();
		test.log(LogStatus.INFO, "browseHotelsBy_Reviewscore");
		bookingPage.browseHotelsBy_Price();
		test.log(LogStatus.INFO, "browseHotelsBy_Price");
		bookingPage.browseHotelsBy_Name();
		test.log(LogStatus.INFO, "browseHotelsBy_Name");
		bookingPage.browseHotelsBy_Star();
		test.log(LogStatus.INFO, "browseHotelsBy_Stars");
		test.log(LogStatus.INFO, "User validated all hotel options for defined PAX details");
		logs.endTestCase(method.getName());
	}
	
   //new 
	@Test(groups= {"smoke"},priority=2)
	public void TC_0002_bookingJourneyWithFlightAndTrain(Method method) throws Exception {
		ExtentTest test = ExtentTestManager.startTest(method.getName(), "TC_0002_bookingJourneyWithFlightAndTrain");
		logs.startTestCase(method.getName());
		test.log(LogStatus.INFO, "User entered the URL: 'https://www.tripmasters.com/");
		bookingPage.clickOnBuildYourVacationDropDown();
		PageBase.waitForElement(3);
		bookingPage.fillLeavingFromDetails("New York City (all Airports),  NY");
		test.log(LogStatus.INFO, "User entered \"New York City (all Airports),  NY\" into Leaving from field");
		bookingPage.fillGoingToCityDetails("London (England)");
		test.log(LogStatus.INFO, "User entered \"London (England)\" into Going to from field");
		String selectDate=bookingPage.selectValueFromCalendar(90,1);
		System.out.println("date is "+ selectDate);	
		String selecteddate = bookingPage.getSelectedDate();
		test.log(LogStatus.INFO,   "User selects arrival date '" + selecteddate + "'from calendar");
			bookingPage.selectStayingTime("6");
		test.log(LogStatus.INFO, "User entered \"6\" nights staying time");	
		bookingPage.clickOnAddCityBtn();
		test.log(LogStatus.INFO, "Click on + Add Destination Button");
		bookingPage.fillSecndAddedCityDetails("Paris (France)");
		test.log(LogStatus.INFO, "User select another city:Paris (France)");
		bookingPage.selectStayingTimeTwo("5");
		test.log(LogStatus.INFO, "User entered \"5\" nights staying time");	
		bookingPage.selectNoMoreCitiesBtn();
		test.log(LogStatus.INFO,   "Click on Next Button");
		bookingPage.validateTravlByTrain();
		test.log(LogStatus.INFO, "Change default transportation & validate that it should be a Train");
		bookingPage.selectGuestDetails("1|Other");
		test.log(LogStatus.INFO, "User select \"1 Room With Other Options\" from Guest list");
		bookingPage.selectNumberOfAdult("2", BookingLocators.getselectAdultDrpdown());
		bookingPage.selectnumberofadultsRoom_1iOS();
		test.log(LogStatus.INFO, "User selects \"2\" Adults from Adult Drpdown");
		bookingPage.selectNumberOfChild("1", "11", "Child1");
		bookingPage.doneButtonMob();
		test.log(LogStatus.INFO, "User selects \"1\" Child,\"Age of Child:11\"");
		test.log(LogStatus.INFO, "No.of Child & Age of Child got selected successfully");
		logs.info("No.of Child & Age of Child got selected successfully");
		test.log(LogStatus.INFO, "All the basic booking details Source & Destination filled successfully for 2_Adult_1Child_With_SingleRoom");
		logs.info("All the basic booking details Source & Destination filled successfully for 2_Adult_1Child_With_SingleRoom");
		bookingPage.clickonContinueButton();
		test.log(LogStatus.INFO, "Click on Continue Button");
		logs.info("Click on Continue Button");
		String sessionID=bookingPage.getSessionID();
		test.log(LogStatus.INFO, "Session ID is: '"+sessionID+"'");
		bookingPage.selectCheaperFlights("Coach/Economy");
		test.log(LogStatus.INFO, "User clicks on Browse all Flights link");
		test.log(LogStatus.INFO, "User selects a particular flight from existing options");
		test.log(LogStatus.INFO, "User clicks on Select button");
		test.log(LogStatus.INFO, "User selects cabin class:Coach/Economy");
		test.log(LogStatus.INFO, "User clicks to Continue");
		logs.info("Select Cheaper flights from flight options");
		bookingPage.getTripinclusionContinueButton();
		bookingPage.clicktoContinuePage();
		test.log(LogStatus.INFO, "User clicks on Continue Link for naviagting to TripInclusion Page");
		test.log(LogStatus.INFO, "Validating flight at TripInclusion Page");
		logs.endTestCase(method.getName());
	}
	
	//new
	@Test(groups= {"smoke"},priority=7)
	public void TC_0007_bookingFlightAndHotelForSingleCitywithTopDealsValidation(Method method) throws Exception {
		ExtentTest test=ExtentTestManager.startTest(method.getName(), "TC_0007_bookingFlightAndHotelForSingleCitywithTopDealsValidation");
		logs.startTestCase(method.getName());
		test.log(LogStatus.INFO, "User entered the URL: 'https://www.tripmasters.com/");
		bookingPage.clickOnBuildYourVacationDropDown();
		bookingPage.clickOnTopDealsLink();
		test.log(LogStatus.INFO, "User clicks on Top Deals Link");
		bookingPage.validateTopDealsPage();
		test.log(LogStatus.INFO, "User is redirected to Top Deals Page,Verified!");
		bookingPage.validateTopDealsList();
		test.log(LogStatus.INFO, "User validated that TopDeals List is available");
		String expectedVal=bookingPage.getFirstDealTxtclickonCustomize();
		test.log(LogStatus.INFO, "User clicks on customize button for first package:'"+expectedVal+"'");
		bookingPage.validateFirstDealPage(expectedVal);
		test.log(LogStatus.INFO, "User redirected to first deal of the week,Verified!");
		bookingPage.fillLeavingFromDetails_FirstPckg("New York, Newark, NJ - EWR");
		test.log(LogStatus.INFO, "User entered \"New York, Newark, NJ - EWR\" into leaving from field");
		String selectDate=bookingPage.selectValueFromCalendar_FirstPckg(94,0);	
		System.out.println("date is "+ selectDate);	
		String selecteddate = bookingPage.getSelectedDate();
		test.log(LogStatus.INFO,   "User selects arrival date '" + selecteddate + "'from calendar");
		bookingPage.selectGuestDetails_FirstPckgOneRoom("2|Other");
		test.log(LogStatus.INFO, "User selects 2 Rooms with other options");
		bookingPage.select2NumberOfAdultForRoom1("1", BookingLocators.getselectAdultDrpdown());
		test.log(LogStatus.INFO, "User select \"1 Adult\" for Room1");			
		bookingPage.select1NumberOfAdultForRoom2("1", BookingLocators.getselectAdultRoom2Drpdown());
		test.log(LogStatus.INFO, "User select \"1 Adult\" in  Room2");	
		bookingPage.selectNumberOfChild_TopDealPage("1", "9", "Child2");
		test.log(LogStatus.INFO, "User select \"1 Child\" in  Room2,Age of Child: 9");	
		bookingPage.clickOnViewPrice();
		test.log(LogStatus.INFO, "User clicks on View Price Button");
		//ActualHotel = bookingPage.browseHotelsButton();
		String sessionID=bookingPage.getSessionID();
		test.log(LogStatus.INFO, "Session ID is: '"+sessionID+"'");
		ActualHotel = bookingPage.browseHotelsButton_EuropePage();
		System.out.println("Actual:"+ ActualHotel);
		test.log(LogStatus.INFO, "Click on Browse Hotels Button");
		logs.info("Click on Browse Hotels Button");
		bookingPage.selectFirstHotel_SingleCity();
		PageBase.scrollDownForMob(1);
		test.log(LogStatus.INFO, "Select particular hotel from Hotel Options");
		logs.info("Select particular hotel from Hotel Options");
		test.log(LogStatus.INFO, "Validate selected hotel name is displayed");
		bookingPage.selectCheaperFlights("Mixed");
		Thread.sleep(4000);
		test.log(LogStatus.INFO, "User clicks on Browse all Flights link");
		logs.info("Select Cheaper flights from flight options");
		test.log(LogStatus.INFO, "User selects a particular flight from existing options");
		test.log(LogStatus.INFO, "User clicks on Select button");
		test.log(LogStatus.INFO, "User selects cabin class:Mixed Cabin");
		bookingPage.clicktoContinuePage();
		test.log(LogStatus.INFO, "User clicks on Continue  to arrive in Pax Info Page");
		expectedFirstTravellerInfo = passengerInfoPage.fillTravellerDetailsForMultipleRooms("Room1Traveller1");
		
		test.log(LogStatus.INFO, "User enters \"yury\" as Traveller1 First Name");
		test.log(LogStatus.INFO, "User enters \"darwin\" as Traveller1 Last Name");
		test.log(LogStatus.INFO, "User selects \"Gender:Male\" for Traveller1");
		test.log(LogStatus.INFO, "User selects \"DOB:01/01/2000\" for Traveller1 Date of Birth");
		test.log(LogStatus.INFO, "User selects \"Passport details as:US\" for Traveller1");
		
		
		
		expectedSecondTravellerInfo = passengerInfoPage.fillTravellerDetailsForMultipleRooms("Room2Traveller1");
		
		test.log(LogStatus.INFO, "User enters \"Hanna\" as Traveller2 First Name");
		test.log(LogStatus.INFO, "User enters \"darwin\" as Traveller2 Last Name");
		test.log(LogStatus.INFO, "User selects \"Gender:Male\" for Traveller2 ");
		test.log(LogStatus.INFO, "User selects \"DOB:01/01/2000\" for Traveller2 Date of Birth");
		test.log(LogStatus.INFO, "User selects \"Passport details as:US\" for Traveller2");
		
		
		expectedThirdTravellerInfo = passengerInfoPage.fillTravellerDetailsForMultipleRooms("Room2Child1SingleTravlr");
		test.log(LogStatus.INFO, "User enters \"Erwin\" as Traveller3 First Name");
		test.log(LogStatus.INFO, "User enters \"George\" as Travelle3 Last Name");
		test.log(LogStatus.INFO, "User selects \"Gender:Male\" for Traveller3 ");
		test.log(LogStatus.INFO, "User selects \"DOB:01/01/2011\" for Traveller3 Date of Birth");
		test.log(LogStatus.INFO, "User selects \"Passport details as:US\" for Traveller3");
	
		
		
		
		logs.info("User filled all the passenger details successfully");
		bookingPage.clicktoContinuePage();
		PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler1Name(), expectedFirstTravellerInfo);
		PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler2Name(), expectedSecondTravellerInfo);
		PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler3Name(), expectedThirdTravellerInfo);
		
		
		
		
		
		
		
			test.log(LogStatus.INFO, "User filled all the passenger details successfully");

		test.log(LogStatus.INFO, "Click on Continue Button & User redirected to the Payment Page");
		
		
		
		
		
		
		
		
		
		
		test.log(LogStatus.INFO, "Flights & passenger details verified successfully on PaymentPage");
		logs.info("Flights & passenger details verified successfully on PaymentPage");
		logs.endTestCase(method.getName());
	}
	
	//new.
	@Test(groups= {"smoke"},priority=6)
	public void TC_0006_bookingFlightsWithmultipleCitieswithHighLightsValidation(Method method) throws Exception {
		ExtentTest test = ExtentTestManager.startTest(method.getName(), "TC_0006_bookingFlightsWithmultipleCitieswithHighLightsValidation");
		logs.startTestCase(method.getName());
		test.log(LogStatus.INFO, "User entered the URL: 'https://www.tripmasters.com/");
		bookingPage.clickOnBuildYourVacationDropDown();				
		bookingPage.validateHighLights();
		test.log(LogStatus.INFO, "Highlights are available on Homepage,Validated!");	
		PageBase.clickUsingJavaScript(HomePageLocators.getmoreHighLightsBtn());
		test.log(LogStatus.INFO, "Click on More Highlights & Attractions link ");	
		String value=bookingPage.selectFirstHighLightOption();
		test.log(LogStatus.INFO, "Select First HighLight Option: '"+value+"'");	
		bookingPage.validateHighlightOption(value);
		test.log(LogStatus.INFO, "User redirected to the corresponding highlight page,Verified!");	
		bookingPage.fillLeavingFromDetails("New York City (all Airports),  NY");
		test.log(LogStatus.INFO, "User entered leaving from: New York City (all Airports),  NY");
		bookingPage.fillGoingToCityDetails("Berlin (Germany)");
		
		String selectDate=bookingPage.selectValueFromCalendar(220,4);
		
		
		test.log(LogStatus.INFO,   "User selects arrival date '" + selectDate + "' from calendar");
		System.out.println("date is "+ selectDate);
		
		test.log(LogStatus.INFO, "User entered Going to City:Berlin (Germany)");
	//	bookingPage.selectStayingTime_EuropePage();
		bookingPage.selectStayingTime("4");
		
		test.log(LogStatus.INFO, "Select staying time for city1 :4 nights");
		bookingPage.clickOnAddCityBtn();
		test.log(LogStatus.INFO, "Click on Add City Button");
		bookingPage.fillSecndAddedCityDetails("Augsburg (Germany)");
		//bookingPage.selectStayingTimeTwo_EuropePage();
	
		bookingPage.selectStayingTimeTwo("4");
		
		test.log(LogStatus.INFO, "User select another city:Augsburg (Germany)");
		test.log(LogStatus.INFO, "Select staying time for city 2 :4 nights");
		bookingPage.selectNoMoreCitiesBtn();
		test.log(LogStatus.INFO,   "Click on No more cities,Continue Button");
		test.log(LogStatus.INFO, "User select \"1 Room With 2 Adults\" from Guest list");
		test.log(LogStatus.INFO, "All the basic booking details Source & Destination filled successfully for 2_Adult_With_SingleRoom");		
		bookingPage.doneButtonMob();
		bookingPage.clicktoContinuePage();
		test.log(LogStatus.INFO, "Click on Continue Button");
		PageBase.waitForElement(5);
		String sessionID=bookingPage.getSessionID();
		test.log(LogStatus.INFO, "Session ID is: '"+sessionID+"'");
		bookingPage.selectCheaperFlights("Coach/Economy");
		test.log(LogStatus.INFO, "User clicks on Browse all Flights link");
		test.log(LogStatus.INFO, "User selects a particular flight from existing options");
		test.log(LogStatus.INFO, "User clicks on Select button");
		test.log(LogStatus.INFO, "User selects cabin class:Coach/Economy");
		test.log(LogStatus.INFO, "User clicks on Continue Link");
		bookingPage.getTripinclusionContinueButton();
		bookingPage.clicktoContinuePage();
		test.log(LogStatus.INFO, "User clicks on Continue  to arrive in Pax Info Page");
		expectedFirstTravellerInfo = passengerInfoPage.fillFirstTravellerDetails("Morris", "Mano", "Male","01/01/1992", "237|US");
	
		test.log(LogStatus.INFO, "User enters \"Morris\" as First Traveller First Name");
		test.log(LogStatus.INFO, "User enters \"Mano\" as First Traveller Last Name");
		test.log(LogStatus.INFO, "User selects \"Gender:Male\" for First Traveller Last Name");
		test.log(LogStatus.INFO, "User selects \"DOB:01/01/1992\" for First Traveller's Date of Birth");
		test.log(LogStatus.INFO, "User selects \"Passport details as:US\" for First Traveller");
		
		
		expectedSecondTravellerInfo = passengerInfoPage.fillSecondTravellerDetails("Shally", "Mano", "Male","01/01/2000", "237|US", "Adult");
		test.log(LogStatus.INFO, "User enters \"Shally\" as Second Traveller First Name");
		test.log(LogStatus.INFO, "User enters \"Mano\" as Second Traveller Last Name");
		test.log(LogStatus.INFO, "User selects \"Female\" for Second Traveller Last Name");
		test.log(LogStatus.INFO, "User selects \"DOB:01/01/2000\" for Second Traveller's Date of Birth");
		test.log(LogStatus.INFO, "User selects \"Passport details as:US\" for Second Traveller");
		test.log(LogStatus.INFO, "User filled all the passenger details successfully");
		
		
		
		
		logs.info("User filled all the passenger details successfully");
		bookingPage.getTripinclusionContinueButton();
		bookingPage.clicktoContinuePage();
		if(TestBase.flag_Mob){
			PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler1NameiOS(), expectedFirstTravellerInfo);
			PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler2NameiOS(), expectedSecondTravellerInfo);
		}else{
			PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler1Name(), expectedFirstTravellerInfo);
			PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler2Name(), expectedSecondTravellerInfo);
		}
		
		
		
		
		
		
		
		
		test.log(LogStatus.INFO, "Click on Continue Button & User redirected to the Payment Page");
		
		
		
		
		
		test.log(LogStatus.INFO, "Flights & passenger details verified successfully on PaymentPage");
		logs.info("Flights & passenger details verified successfully on PaymentPage");
		logs.endTestCase(method.getName());
	}
	//new
	@Test(groups= {"smoke"},priority=5)
	public void TC_0005_FlightbookingjourneywithBuyYourOwnPackage(Method method) throws Exception {
		ExtentTest test = ExtentTestManager.startTest(method.getName(), "TC_0005_FlightbookingjourneywithBuyYourOwnPackage");
		logs.startTestCase(method.getName());
		test.log(LogStatus.INFO, "User entered the URL: 'https://www.tripmasters.com/");
		String selectedPackage=bookingPage.selectFromVacationPackageIdeas();	
		test.log(LogStatus.INFO, "User selects '"+selectedPackage+"' option from Vacation Package Ideas");
		bookingPage.clicktoReorderCities();
		test.log(LogStatus.INFO, "User clicks on Reorder cities button");	
		bookingPage.fillLeavingFromDetails_BYOPage("Chicago CHI (All Airports)(IL), US");
		test.log(LogStatus.INFO, "User entered \"Chicago (All Airports)\" into leaving from field");
	
		String defaultdate = bookingPage.getdefaultDate();
		
		//	String selectDate=bookingPage.selectValueFromCalendar_BYOPackage(90);
		test.log(LogStatus.INFO,   "User selects default date " + defaultdate + " from calendar as per the package");	
		bookingPage.selectGuestDetails_BYOPage("2 rooms with children or other options");
		test.log(LogStatus.INFO, "User select \"2 Room With Other Options\" from Guest list");
		bookingPage.selectAdultForRoom1_BYOPage("1");
		bookingPage.selectChildForRoom1_BYOPage("1");
		bookingPage.enterChildAge_BYOPage("7");
		test.log(LogStatus.INFO, "User select \"1 Adult 1Child \" for Room1 ");
		test.log(LogStatus.INFO, "User select \"Age of Child:7 \" for Room1 ");
		test.log(LogStatus.INFO, "2 Adults selected for Room 2(default selected) ");
		bookingPage.clickToContinue_BYOPage();
		test.log(LogStatus.INFO, "User clicks to continue");
		String sessionID=bookingPage.getSessionID();
		test.log(LogStatus.INFO, "Session ID is: '"+sessionID+"'");
		bookingPage.selectCheaperFlights("Coach/Economy");
		test.log(LogStatus.INFO, "User clicks on Browse all Flights link");
		test.log(LogStatus.INFO, "User selects a particular flight from existing options");
		test.log(LogStatus.INFO, "User clicks on Select button");
		test.log(LogStatus.INFO, "User selects cabin class:Coach/Economy");
		bookingPage.clicktoContinuePage();
		test.log(LogStatus.INFO, "User clicks on Continue Link to fill PAX details");
		expectedFirstTravellerInfo = passengerInfoPage.fillTravellerDetailsForMultipleRooms("Room1Traveller1");
		
		test.log(LogStatus.INFO, "User enters \"yury\" as Traveller1 First Name,Room1");
		test.log(LogStatus.INFO, "User enters \"darwin\" as Traveller1 Last Name,Room1");
		test.log(LogStatus.INFO, "User selects \"Gender:Male\" for Traveller1,Room1 ");
		test.log(LogStatus.INFO, "User selects \"DOB:01/01/2000\" for Traveller1 Date of Birth,Room1");
		test.log(LogStatus.INFO, "User selects \"Passport details as:US\" for Traveller1,Room1");
		
		
		
		expectedFirstTravellerInfo = passengerInfoPage.fillTravellerDetailsForMultipleRooms("Room1Traveller2Child");
		test.log(LogStatus.INFO, "User enters \"George\" as Traveller2 First Name,Room1");
		test.log(LogStatus.INFO, "User enters \"darwin\" as Traveller2 Last Name,Room1");
		test.log(LogStatus.INFO, "User selects \"Gender:Male\" for Traveller2,Room1 ");
		test.log(LogStatus.INFO, "User selects \"DOB:01/01/2013\" for Traveller2 Date of Birth,Room1");
		test.log(LogStatus.INFO, "User selects \"Passport details as:US\" for Traveller2,Room1");
		
		bookingPage.clicktoContinuePage();
		bookingPage.validateErrorMessage_MandatoryFields();
		
		
		
		
		
		test.log(LogStatus.INFO, "User clicks on continue Page Button");
		
		test.log(LogStatus.INFO, "User is not able to proceed with empty fields in passenger details");
		test.log(LogStatus.INFO, "Error Message Validated for unfilled fields - This field is required.");
		logs.endTestCase(method.getName());
		
	}	
	//new
	@Test(groups= {"smoke"},priority=4)
	public void TC_0004_FirstPackageoptionalongwithRemoveHotelFunc(Method method) throws Exception {
		 ExtentTest test = ExtentTestManager.startTest(method.getName(), "TC_0004_FirstPackageoptionalongwithRemoveHotelFunc");
		 logs.startTestCase(method.getName());
		 test.log(LogStatus.INFO, "User entered the URL: 'https://www.tripmasters.com/");
		 String selectedPackage=bookingPage.selectFromVacationPackageIdeas();
		 test.log(LogStatus.INFO, "User selects '"+selectedPackage+"' option from Vacation Package Ideas");
		bookingPage.fillLeavingFromDetails_FirstPckg("Washington DC (all Airports), US");
		test.log(LogStatus.INFO, "User entered \"Washington DC (all Airports), US\" into leaving from field");
		String selectDate=bookingPage.selectValueFromCalendar_FirstPckg(172,1);
		System.out.println("date is "+ selectDate);	
		String selecteddate = bookingPage.getSelectedDate();
		test.log(LogStatus.INFO,   "User selects arrival date '" + selecteddate + "'from calendar");
		bookingPage.selectGuestDetails_FirstPckgOneRoom("1|2");
		test.log(LogStatus.INFO, "User selects 1 Room with two Adults");
		bookingPage.clickOnViewPrice();
		test.log(LogStatus.INFO, "User clicks on View Price Button");
		String sessionID=bookingPage.getSessionID();
		test.log(LogStatus.INFO, "Session ID is: '"+sessionID+"'");
		bookingPage.clickToRemoveSecondCityHotel();
		test.log(LogStatus.INFO, "User clicks on remove second city button");
		bookingPage.clickToYesOnDialogBox();
		test.log(LogStatus.INFO, "User clicks to Yes button on Dialog Box");
		bookingPage.getContinueLink();
		test.log(LogStatus.INFO, "User clicks on Continue Button");
		test.log(LogStatus.INFO, "User validates that the hotel name is removed for second city ");
		bookingPage.clicktoContinuePage();
		test.log(LogStatus.INFO, "User clicks on Continue Page to fill PAX details");
		expectedFirstTravellerInfo = passengerInfoPage.fillFirstTravellerDetails("John", "Leo", "Male","01/01/1992", "237|US");
		
		test.log(LogStatus.INFO, "User enters \"John\" as First Traveller First Name");
		test.log(LogStatus.INFO, "User enters \"Leo\" as First Traveller Last Name");
		test.log(LogStatus.INFO, "User selects \"Gender:Male\" for First Traveller ");
		test.log(LogStatus.INFO, "User selects \"DOB:01/01/1992\" for First Traveller's Date of Birth");
		test.log(LogStatus.INFO, "User selects \"Passport details as:US\" for First Traveller");
		
		
		
		expectedSecondTravellerInfo = passengerInfoPage.fillSecondTravellerDetails("Elvin", "Leo", "Male","01/01/1994", "237|US", "Adult");
		

		test.log(LogStatus.INFO, "User enters \"Elvin\" as Second Traveller First Name");
		test.log(LogStatus.INFO, "User enters \"Leo\" as Second Traveller Last Name");
		test.log(LogStatus.INFO, "User selects \"Gender:Male\" for Second Traveller");
		test.log(LogStatus.INFO, "User selects \"DOB:01/01/1994\" for Second Traveller's Date of Birth");
		test.log(LogStatus.INFO, "User selects \"Passport details as:US\" for Second Traveller");
		
		
		
		bookingPage.getTripinclusionContinueButton();
		bookingPage.clicktoContinuePage();
		PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler1Name(), expectedFirstTravellerInfo);
		PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler2Name(), expectedSecondTravellerInfo);
		bookingPage.tripSummary();
		
		
		
		
		
		test.log(LogStatus.INFO, "Click to Continue & User redirected to Payment Page");
		
		
		
		
		
		test.log(LogStatus.INFO, "Removed Hotel is not available for second City,Verified!");
		test.log(LogStatus.INFO, "Flights & passenger details verified successfully on PaymentPage");
		logs.endTestCase(method.getName());
	}
	
	//new
		@Test(groups= {"smoke"},priority=3)
		public void TC_3_bookingTwoRoomTwoAdult(Method method) throws Exception {
			ExtentTest test = ExtentTestManager.startTest(method.getName(), "TC_0003_bookingTwoRoomTwoAdult");
			logs.startTestCase(method.getName());
			test.log(LogStatus.INFO, "User entered the URL: 'https://www.tripmasters.com/");
			bookingPage.clickOnBuildYourVacationDropDown();
			PageBase.waitForElement(3);
			bookingPage.fillLeavingFromDetails("Seattle SEA (WA), US");
			test.log(LogStatus.INFO, "User entered \"Seattle, WA\" into Leaving from field");
			bookingPage.fillGoingToCityDetails("Dublin (Ireland)");
			test.log(LogStatus.INFO, "User entered \"Dublin (Ireland)\" into Going to from field");
			String selectDate=bookingPage.selectValueFromCalendar(210,3);
			System.out.println("date is "+ selectDate);	
			String selecteddate = bookingPage.getSelectedDate();
			test.log(LogStatus.INFO,   "User selects arrival date '" + selecteddate + "'from calendar");
			bookingPage.selectStayingTime("4");
			test.log(LogStatus.INFO, "User entered \"4\" nights staying time");	
			bookingPage.clickOnAddCityBtn();
			test.log(LogStatus.INFO, "User clicks on + Add Destination Button");
			bookingPage.fillSecndAddedCityDetails("Galway (Ireland)");
			test.log(LogStatus.INFO, "User entered another city:Galway (Ireland)");
			bookingPage.selectStayingTimeTwo("4");
			test.log(LogStatus.INFO, "User entered \"4\" nights staying time");	
			bookingPage.clickOnAddCityBtn();
			test.log(LogStatus.INFO, "User clicks on + Add Destination Button");
			bookingPage.fillThirdAddedCityDetails("Limerick (Ireland)");
			test.log(LogStatus.INFO, "User select another city:Limerick (Ireland)");
			Thread.sleep(4000);
			bookingPage.selectStayingTimeThree("4");
			test.log(LogStatus.INFO, "Select staying time :4 nights");
			bookingPage.selectNoMoreCitiesBtn();
			test.log(LogStatus.INFO,   "Click on Next Button");
			bookingPage.clickOnRemoveBtnScndCity();
			test.log(LogStatus.INFO, "User click on Edit/Remove option corresponding to GalWay");
			bookingPage.deleteSecondCity();
			test.log(LogStatus.INFO, "User clicked on Remove Second City");
			bookingPage.selectNoMoreCitiesBtn();
			test.log(LogStatus.INFO,   "Click on Next Button");
			boolean status=bookingPage.isSecondremovecitydisplayed();
			System.out.println("Print the status"+status);
			Assert.assertFalse(status);
			test.log(LogStatus.INFO, "Verified that Galway is removed successfully");
			bookingPage.clickOnRemoveBtnScndCity();
			test.log(LogStatus.INFO, "Click on edit/Remove option corresponding to LimeRick");
			bookingPage.deleteSecondCity();
			test.log(LogStatus.INFO, "User clicked to remove Limerick");
			bookingPage.clickOnAddCityBtn();
			test.log(LogStatus.INFO, "User clicks on + Add Destination Button to re-add Galway");
			bookingPage.fillSecndAddedCityDetails("Galway (Ireland)");
			test.log(LogStatus.INFO, "User entered another city:Galway (Ireland)");
			bookingPage.selectStayingTimeTwo("4");
			test.log(LogStatus.INFO, "User entered \"4\" nights staying time");	
			bookingPage.clickOnAddCityBtn();
			test.log(LogStatus.INFO, "User clicks on + Add Destination Button to re-add Limerick");
			bookingPage.fillThirdAddedCityDetails("Limerick (Ireland)");
			test.log(LogStatus.INFO, "User select another city:Limerick (Ireland)");			
			Thread.sleep(4000);
			bookingPage.selectStayingTimeThree("4");
			test.log(LogStatus.INFO, "Select staying time :4 nights");
			bookingPage.selectNoMoreCitiesBtn();
			test.log(LogStatus.INFO,   "Click on Next Button");
			bookingPage.selectChngeTransByCar();
			test.log(LogStatus.INFO, "User selects Car from Transportation Option");
			bookingPage.selectGuestDetails("2|Other");
			test.log(LogStatus.INFO, "User select \"2 Rooms with other Options\" from Guest list");			
			bookingPage.select2NumberOfAdultForRoom1("2", BookingLocators.getselectAdultDrpdown());
			test.log(LogStatus.INFO, "User select \"2 Adult\" for Room1");			
			bookingPage.select1NumberOfAdultForRoom2("1", BookingLocators.getselectAdultRoom2Drpdown());
			test.log(LogStatus.INFO, "User select \"1 Adult\" in  Room2");	
			bookingPage.selectNumberOfChild("1", "7", "Child2");
			test.log(LogStatus.INFO, "User select \"1 Child\" in Room2,Age of Child:7");	
			bookingPage.clickonContinueButton();
			test.log(LogStatus.INFO, "Click on Continue Button");
			String sessionID=bookingPage.getSessionID();
			test.log(LogStatus.INFO, "Session ID is: '"+sessionID+"'");
			bookingPage.selectCheaperFlights("Coach/Economy");
			test.log(LogStatus.INFO, "User clicks on Browse all Flights link");
			test.log(LogStatus.INFO, "User selects a particular flight from existing options");
			test.log(LogStatus.INFO, "User clicks on Select button");
			test.log(LogStatus.INFO, "User selects cabin class Coach/Economy");
			test.log(LogStatus.INFO, "User clicks on Continue Link");
			bookingPage.clicktoContinuePage();
			test.log(LogStatus.INFO, "User clicks on Continue  to arrive in Pax Info Page");
			expectedFirstTravellerInfo = passengerInfoPage.fillTravellerDetailsForMultipleRooms("Room1Traveller1");
			test.log(LogStatus.INFO, "User enters \"yury\" as Traveller1 First Name");
			test.log(LogStatus.INFO, "User enters \"darwin\" as Traveller1 Last Name");
			test.log(LogStatus.INFO, "User selects \"Gender:Male\" for Traveller1 ");
			test.log(LogStatus.INFO, "User selects \"DOB:01/01/2000\" for Traveller1 Date of Birth");
			test.log(LogStatus.INFO, "User selects \"Passport details as:US\" for Traveller1");
			
			
			
			
			expectedSecondTravellerInfo = passengerInfoPage.fillTravellerDetailsForMultipleRooms("Room1Traveller2");
			
			test.log(LogStatus.INFO, "User enters \"Larry\" as Traveller2 First Name");
			test.log(LogStatus.INFO, "User enters \"darwin\" as Traveller2 Last Name");
			test.log(LogStatus.INFO, "User selects \"Gender:Male\" for Traveller2 ");
			test.log(LogStatus.INFO, "User selects \"DOB:01/01/2000\" for Traveller2 Date of Birth");
			test.log(LogStatus.INFO, "User selects \"Passport details as:US\" for Traveller2");
			
			
			
			expectedThirdTravellerInfo = passengerInfoPage.fillTravellerDetailsForMultipleRooms("Room2Traveller1");
			test.log(LogStatus.INFO, "User enters \"Hanna\" as Traveller3 First Name");
			test.log(LogStatus.INFO, "User enters \"darwin\" as Traveller3 Last Name");
			test.log(LogStatus.INFO, "User selects \"Gender:Male\" for Traveller3 ");
			test.log(LogStatus.INFO, "User selects \"DOB:01/01/2000\" for Traveller3 Date of Birth");
			test.log(LogStatus.INFO, "User selects \"Passport details as:US\" for Traveller3");
			
			
			
			
			expectedFourthTravellerInfo = passengerInfoPage.fillTravellerDetailsForMultipleRooms("Room2Child1SingleTravlr");
			

			test.log(LogStatus.INFO, "User enters \"Erwin\" as Traveller4 First Name");
			test.log(LogStatus.INFO, "User enters \"George\" as Traveller4 Last Name");
			test.log(LogStatus.INFO, "User selects \"Gender:Male\" for Traveller4 ");
			test.log(LogStatus.INFO, "User selects \"DOB:01/01/2011\" for Traveller4 Date of Birth");
			test.log(LogStatus.INFO, "User selects \"Passport details as:US\" for Traveller4");
			test.log(LogStatus.INFO, "User filled all the passenger details successfully");
		
			
			
			bookingPage.clicktoContinuePage();
			PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler1Name(), expectedFirstTravellerInfo);
			PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler2Name(), expectedSecondTravellerInfo);
			PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler3Name(), expectedThirdTravellerInfo);
			PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler4Name(), expectedFourthTravellerInfo);
		
			
			
			
			
			
			
				logs.info("User filled all the passenger details successfully");
			
			test.log(LogStatus.INFO, "Click on Continue Button & User redirected to the Payment Page");
			
			
			
			test.log(LogStatus.INFO, "Flights & passenger details verified successfully on PaymentPage");
			logs.info("Flights & passenger details verified successfully on PaymentPage");
			logs.endTestCase(method.getName());
		}
}

