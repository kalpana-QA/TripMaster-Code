package com.tripmasters.framework.testScript;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
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
		bookingPage.selectWithoutAir();
		test.log(LogStatus.INFO, "Select withOut Air Option on HomePage");
		logs.info("Select withOut Air Option on HomePage");
		bookingPage.fillGoingToCityDetails("San Francisco (USA)");
		String selectDate=bookingPage.selectValueFromCalendar(90,1);
		test.log(LogStatus.INFO,   "User selects '" + selectDate + "' from calendar");
		bookingPage.selectStayingTime("5");
		bookingPage.selectNoMoreCitiesBtn();
		bookingPage.selectGuestDetails("1|3");
		test.log(LogStatus.INFO, "User fills all the basic details of journey:Source,Destination & Staying Time");
		logs.info("User fills all the basic details of journey:Source,Destination & Staying Time");
		bookingPage.clickonContinueButton();
		test.log(LogStatus.INFO, "Click on Continue Button");
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
		test.log(LogStatus.INFO, "Verify that only particular selected hotel appears along with passenger details");
		logs.info("Verify that only particular selected hotel appears along with passenger details");
		logs.endTestCase(method.getName());
	}
	 
	@Test(groups= {"smoke"},priority=20)
	public void TC_0020_getWithoutAir(Method method) throws Exception {
		ExtentTest test=ExtentTestManager.startTest(method.getName(), "TC_0020_getWithoutAir");
		logs.startTestCase(method.getName());
		bookingPage.getWithoutButton();
		Thread.sleep(8000);
		test.log(LogStatus.INFO, "Click on WithOut Air Button");
		logs.info("Click on WithOut Air Button");
		bookingPage.fillLeavingFromDetails("New York, Newark, NJ");
		Thread.sleep(4000);
		bookingPage.fillGoingToCityDetails("Delhi (India)");
		Thread.sleep(4000);
		String selectDate=bookingPage.selectValueFromCalendar(100,1);
		test.log(LogStatus.INFO,   "User selects '" + selectDate + "' from calendar");
		bookingPage.clickOnAddCityBtn();
		Thread.sleep(4000);
		bookingPage.fillSecndAddedCityDetails("Mumbai (India)");
		Thread.sleep(4000);
		bookingPage.selectStayingTime("4");
		Thread.sleep(4000);
		bookingPage.selectNoMoreCitiesBtn();
		Thread.sleep(8000);
		bookingPage.selectGuestDetails("1|3");
		test.log(LogStatus.INFO, "Filled all the basic details of journey along with source & destination");
		logs.info("Filled all the basic details of journey along with source & destination");
		Thread.sleep(8000);
		bookingPage.clickonContinueButton();
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
		test.log(LogStatus.INFO, "Verify that only particular selected hotel appears along with passenger details");
		logs.info("Verify that only particular selected hotel appears along with passenger details");
		logs.endTestCase(method.getName());
	}



     @Test(groups= {"smoke"},priority=14)
	public void TC_0014_verifySpotlightLink(Method method) throws Exception {
    	String PageTitle=null;
		ExtentTest test=ExtentTestManager.startTest(method.getName(), "TC_0014_verifySpotlightLink");
		logs.startTestCase(method.getName());
		bookingPage.selectLatinAmericaLink();
		test.log(LogStatus.INFO, "Select Latin America Link");
		logs.info("Select Latin America Link");
		bookingPage.verifyLatinAmericPage();
		test.log(LogStatus.INFO, "User redirected to the Latin America Page");
		logs.info("User redirected to the Latin America Page");
		String title=bookingPage.clickOnFirstOptionUnderSpotlightForMob();
		test.log(LogStatus.INFO, "User clicks on Spotlight button");
		logs.info("User clicks on Spotlight button");
		bookingPage.verifyPageDisplayed(title);
		test.log(LogStatus.INFO, "Spotlight link verified!");
        logs.info("Spotlight link verified!");
        logs.endTestCase(method.getName());
	}
	
    @Test(groups= {"smoke"},priority=9)
	public void TC_0009_dateChanging(Method method) throws Exception {
		ExtentTest test=ExtentTestManager.startTest(method.getName(), "TC_0009_dateChanging");
		logs.startTestCase(method.getName());
		bookingPage.clickOnBuildYourVacationDropDown();
		bookingPage.fillLeavingFromDetails("New York, Newark, NJ");
		bookingPage.fillGoingToCityDetails("Berlin (Germany)");
		String selectDate=bookingPage.selectValueFromCalendar(90,1);
		test.log(LogStatus.INFO,   "User selects '" + selectDate + "' from calendar");
		bookingPage.selectStayingTime("12");
		bookingPage.selectNoMoreCitiesBtn();
		bookingPage.selectGuestDetails("1|Other");
		test.log(LogStatus.INFO, "Booking details Source & Destination filled successfully ");
		logs.info("Booking details Source & Destination filled successfully ");
		bookingPage.selectNumberOfAdult("1", BookingLocators.getselectAdultDrpdown());
		bookingPage.selectnumberofadultsRoom_1iOS();
		test.log(LogStatus.INFO, "User selects \"1\" Adult from Adult Drpdown");
		bookingPage.selectNumberOfChild("1", "9", "Child1");
		bookingPage.doneButtonMob();
		test.log(LogStatus.INFO, "User selects \"1\" Child,\"Age of Child:9\"");
		test.log(LogStatus.INFO, "No.of Child & Age of Child got selected successfully");
		logs.info("No.of Child & Age of Child got selected successfully");
		bookingPage.clickonContinueButton();
		test.log(LogStatus.INFO, "Click on Continue Button");
		bookingPage.clickChangedArriveDate();
		bookingPage.oldArriveDate();
		bookingPage.clickonContinueLink();
		bookingPage.getTripinclusionContinueButton();
		bookingPage.clicktoContinuePage();
		expectedFirstTravellerInfo = passengerInfoPage.fillFirstTravellerDetails("Morris", "Leo", "Male","01/01/1992", "237|US");
		test.log(LogStatus.INFO, "User enters \"Morris\" as First Traveller First Name");
		test.log(LogStatus.INFO, "User enters \"Mano\" as First Traveller Last Name");
		test.log(LogStatus.INFO, "User selects \"Gender:Male\" for First Traveller");
		test.log(LogStatus.INFO, "User selects \"DOB:01/01/1992\" for First Traveller's Date of Birth");
		test.log(LogStatus.INFO, "User selects \"Passport details as:US\" for First Traveller");
		expectedSecondTravellerInfo = passengerInfoPage.fillSecondTravellerDetails("Shally", "Leo", "Male","01/01/1994", "237|US", "Child");
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
		test.log(LogStatus.INFO, "Flights & passenger details verified successfully on PaymentPage");
		logs.info("Flights & passenger details verified successfully on PaymentPage");
		bookingPage.tripSummary();
		logs.endTestCase(method.getName());
	}

   @Test(groups= {"smoke"},priority=18)
		public void TC_0018_bookingDetailswithPremiumEcomomy(Method method) throws Exception {
			ExtentTest test =ExtentTestManager.startTest(method.getName(), "TC_0018_bookingDetailswithPremiumEcomomy");
			logs.startTestCase(method.getName());
			bookingPage.clickOnBuildYourVacationDropDown();
			bookingPage.selectCabinClass("Premium Economy");
			bookingPage.fillLeavingFromDetails("New York City (all Airports)");
			bookingPage.fillGoingToCityDetails("Delhi (India)");
			String selectDate=bookingPage.selectValueFromCalendar(100,1);
			test.log(LogStatus.INFO,   "User selects '" + selectDate + "' from calendar");
			bookingPage.selectStayingTime("4");
			bookingPage.selectNoMoreCitiesBtn();
			bookingPage.selectGuestDetails("1|1");
			bookingPage.selectPremiumEconomy();
			bookingPage.doneButtonMob();
			test.log(LogStatus.INFO, "Filled flights details with premium economy");
			logs.info("Filled flights details with premium economy");
			String actualcabin = bookingPage.selectedcabinAssert();
			System.out.println("This is for Actual "+actualcabin);
			test.log(LogStatus.INFO, "Select Cabin class");
			logs.info("Select Cabin class");
			if(TestBase.flag_Mob){
			  boolean cabinVerify = bookingPage.verifyCabin();
				   Assert.assertTrue(cabinVerify);
				   }
			test.log(LogStatus.INFO, "Selected Cabin class verified");
			logs.info("Selected Cabin class verified");
			bookingPage.clickonContinueButton();
//			bookingPage.selectCheaperFlights();
//			test.log(LogStatus.INFO, "Select Cheaper flights from flight options");
//			logs.info("Select Cheaper flights from flight options");
//			String expectedcabin = bookingPage.verifycabinAssert();
//			System.out.println("This is for Expected "+expectedcabin);
//			Assert.assertEquals(expectedcabin, actualcabin);
			test.log(LogStatus.INFO, "bookingDetailswithPremiumEcomomy passed");
			logs.info("bookingDetailswithPremiumEcomomy passed");
			logs.endTestCase(method.getName());
		}
		
	@Test(groups= {"smoke"},priority=21)
	public void TC_0021_multipleCities(Method method) throws Exception {
		ExtentTest test=ExtentTestManager.startTest(method.getName(), "TC_0021_multipleCities");
		logs.startTestCase(method.getName());
		bookingPage.clickOnBuildYourVacationDropDown();	
		bookingPage.fillLeavingFromDetails("Washington (all Airports), DC");		
		test.log(LogStatus.INFO, "User entered \"Washington (all Airports), DC\" into leaving from field");
		bookingPage.fillGoingToCityDetails("London (England)");		
		test.log(LogStatus.INFO, "User entered \"London (England)\" into Going to from field");
		String selectDate=bookingPage.selectValueFromCalendar(90,1);
		test.log(LogStatus.INFO,   "User selects '" + selectDate + "' from calendar");
		bookingPage.selectStayingTime("3");		
		bookingPage.clickOnAddCityBtn();
		bookingPage.fillSecndAddedCityDetails("Paris (France)");		
		test.log(LogStatus.INFO, "User entered \"Paris (France)\" into Going to from field");
		bookingPage.clickOnAddCityBtn();
		bookingPage.fillThirdAddedCityDetails("Rome (Italy)");		
		test.log(LogStatus.INFO, "User entered \"Rome (Italy)\" into Going to from field for adding second city");		
		bookingPage.selectStayingTimeThree("3");
		bookingPage.clickonContinue();
		Thread.sleep(6000);
		Thread.sleep(6000);
		bookingPage.selectGuestDetails("1|2");
		Thread.sleep(6000);
		bookingPage.clickonContinueButton();
		Thread.sleep(6000);
		bookingPage.selectCheaperFlights("Coach/Economy");
		test.log(LogStatus.INFO, "Select Cheaper flights from flight options");
		logs.info("Select Cheaper flights from flight options");
		test.log(LogStatus.INFO, "User selects cabin class:Coach/Economy");
		test.log(LogStatus.INFO, "User clicks on Continue button");
		bookingPage.validateTripPage();
		test.log(LogStatus.INFO, "Validate that user is on TripInclusion Page");
		logs.endTestCase(method.getName());
	}
	
	//new
	@Test(groups= {"smoke"},priority=17)
	public void TC_0017_validateTripSummarywithMultipleCitiesforAsianPacificPage(Method method) throws Exception {
		ExtentTest test=ExtentTestManager.startTest(method.getName(), "TC_0017_validateTripSummarywithMultipleCitiesforAsianPacificPage");
		logs.startTestCase(method.getName());
		bookingPage.clickOnBuildYourVacationDropDown();
		Thread.sleep(8000);
		bookingPage.clickonAsian_PacificLink();
		test.log(LogStatus.INFO, "User clicked on Asian,Pacific Link.");
		test.log(LogStatus.INFO, "User redirected to Asian Pacific Page");
		bookingPage.fillLeavingFromDetails("New York, Newark, NJ");
		test.log(LogStatus.INFO, "User leaving from: New York, Newark, NJ");
		Thread.sleep(4000);
		bookingPage.fillGoingToCityDetails("Delhi (India)");
		test.log(LogStatus.INFO, "User going to City: Delhi (India)");
		Thread.sleep(4000);
		String selectDate=bookingPage.selectValueFromCalendar(90,1);
		test.log(LogStatus.INFO,   "User selects '" + selectDate + "' from calendar");
		bookingPage.selectStayingTime("4");
		test.log(LogStatus.INFO, "Select staying time :4 nights");
		Thread.sleep(4000);
		bookingPage.clickOnAddCityBtn();
		test.log(LogStatus.INFO, "Click on Add City Button");
		Thread.sleep(4000);
		bookingPage.fillSecndAddedCityDetails("Mumbai (India)");
		test.log(LogStatus.INFO, "User select another city:Mumbai (India)");
		Thread.sleep(4000);
		bookingPage.selectStayingTimeTwo("1");
		test.log(LogStatus.INFO, "Select staying time :1 night");
		Thread.sleep(4000);
		bookingPage.clickOnAddCityBtn();
		test.log(LogStatus.INFO, "Click on Add City Button");
		Thread.sleep(4000);
		bookingPage.fillThirdAddedCityDetails("Chennai -Madras (India)");
		test.log(LogStatus.INFO, "User select another city:Chennai -Madras (India)");
		Thread.sleep(4000);
		bookingPage.selectStayingTimeThree("1");
		test.log(LogStatus.INFO, "Select staying time :1 night");
		Thread.sleep(4000);
		test.log(LogStatus.INFO, "Filled all the basic details for multiple cities");
		logs.info("Fill all the basic details for multiple cities");
		logs.info("Adding multiple cities in destinations");
		boolean actual = bookingPage.isremovecitydisplayed();
		Assert.assertTrue(actual);
		test.log(LogStatus.INFO,"Verify that multiple cities got selected as destinations");
		test.log(LogStatus.INFO, "Verify that RemoveCity Link is also displayed for added cities");
		logs.info("Verify that multiple cities got selected as destinations");
		logs.info("Verify that RemoveCity Link is also displayed for added cities");
		bookingPage.deleteAddedCities();
		Thread.sleep(4000);
		test.log(LogStatus.INFO, "Delete all the added cities");
		logs.info("Delete all the added cities");
		bookingPage.validateremovedcity();
		Thread.sleep(4000);
		test.log(LogStatus.INFO, "All the added cities removed successfully.Verified!");
		logs.info("All the added cities removed successfully.Verified!");
		bookingPage.getNoMoreCitiesButton();
		test.log(LogStatus.INFO, "User clicked on No More Cities,Continue button");
		Thread.sleep(4000);
		bookingPage.ValidateTravelByOption();
		test.log(LogStatus.INFO, "Travel By Option validated from one city to another");
		bookingPage.selectGuestDetails("1|1");
		test.log(LogStatus.INFO, "Select Guest Details");
		bookingPage.clickonContinueButton();
		Thread.sleep(4000);
		bookingPage.selectCheaperFlights("Coach/Economy");
		Thread.sleep(8000);
		test.log(LogStatus.INFO, "Select Cheaper flights from flight options");
		logs.info("Select Cheaper flights from flight options");
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
		bookingPage.clickOnBuildYourVacationDropDown();
		bookingPage.clickonEuropeLink();
		test.log(LogStatus.INFO, "User clicked on Europe Link.");
		test.log(LogStatus.INFO, "User redirected to Europe Page");
		bookingPage.fillLeavingFromDetails("New York City (all Airports),  NY");
		test.log(LogStatus.INFO, "User entered leaving from: New York City (all Airports),  NY");
		bookingPage.fillGoingToCityDetails("Rome (Italy)");
		test.log(LogStatus.INFO, "User entered Going to City:Rome (Italy)");
		String selectDate=bookingPage.selectValueFromCalendar(90,1);
		test.log(LogStatus.INFO,   "User selects '" + selectDate + "' from calendar");
		bookingPage.selectStayingTime("4");
		test.log(LogStatus.INFO, "Select staying time :4 nights");
		bookingPage.clickOnAddCityBtn();
		test.log(LogStatus.INFO, "Click on Add City Button");
		bookingPage.fillSecndAddedCityDetails("Florence (Italy)");
		test.log(LogStatus.INFO, "User select another city:Florence (Italy)");
		bookingPage.selectStayingTimeTwo("5");
		test.log(LogStatus.INFO, "Select staying time :5 nights");
		bookingPage.clickOnAddCityBtn();
		test.log(LogStatus.INFO, "Click on Add City Button");
		bookingPage.fillThirdAddedCityDetails("Venice (Italy)");
		test.log(LogStatus.INFO, "User select another city:Venice (Italy)");
		Thread.sleep(4000);
		bookingPage.selectStayingTimeThree("4");
		test.log(LogStatus.INFO, "Select staying time :4 nights");
		bookingPage.selectNoMoreCitiesBtn();
		test.log(LogStatus.INFO, "User clicked on No More Cities,Continue button");
		bookingPage.ValidateTravelByOption();
		test.log(LogStatus.INFO, "Travel By Option validated frrom one city to another");
		bookingPage.selectGuestDetails("1|Other");
		test.log(LogStatus.INFO, "User select \"1 Room With Other Options\" from Guest list");
		bookingPage.selectNumberOfAdult("2", BookingLocators.getselectAdultDrpdown());
		test.log(LogStatus.INFO, "User selects \"1\" Adult from Adult Drpdown");
		bookingPage.selectNumberOfChild("1", "11", "Child1");
		test.log(LogStatus.INFO, "User selects \"1\" Child,\"Age of Child:11\"");
		test.log(LogStatus.INFO, "Booking details filled successfully for multiple cities");
		logs.info("Booking details filled successfully for multiple cities");
		bookingPage.clickonContinueButton();
		test.log(LogStatus.INFO, "Click on Continue Button");
		logs.info("Click on Continue Button");
		//ActualHotel = bookingPage.browseHotelsButton();
		ActualHotel = bookingPage.browseHotelsButton_EuropePage();
		test.log(LogStatus.INFO, "Click on Browse Hotels Button");
		logs.info("Click on Browse Hotels Button");
		bookingPage.selectFirstHotel();
		PageBase.scrollDownForMob(1);
		ExpectedHotel = bookingPage.browseSelectHotel();
		test.log(LogStatus.INFO, "Select particular hotel from Hotel Options");
		logs.info("Select particular hotel from Hotel Options");
		//Assert.assertEquals(ActualHotel, ExpectedHotel);
		bookingPage.selectCheaperFlights("Business");
		test.log(LogStatus.INFO, "Select Cheaper flights from flight options");
		logs.info("Select Cheaper flights from flight options");
		test.log(LogStatus.INFO, "User selects cabin class:Business");
		bookingPage.getTripinclusionContinueButton();
		bookingPage.clicktoContinuePage();
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
		expectedThirdTravellerInfo = passengerInfoPage.fillThirdTravellerDetails_Child("Marie", "Leo", "Female","01/01/2009", "237|US");
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
		test.log(LogStatus.INFO, "Flights & passenger details verified successfully on PaymentPage");
		logs.info("Flights & passenger details verified successfully on PaymentPage");
		logs.endTestCase(method.getName());
	}
	
	//new
	@Test(groups = { "smoke" }, priority = 1)
	public void TC_0001_bookingJourneyWithOutAirForTwoRoomsPAXDetails(Method method) throws Exception {
	    ExtentTest test = ExtentTestManager.startTest(method.getName(), "TC_0001_bookingJourneyWithOutAirForTwoRoomsPAXDetails");
	    logs.startTestCase(method.getName());
	    bookingPage.clickOnBuildYourVacationDropDown();
		bookingPage.selectWithoutAir();
		test.log(LogStatus.INFO, "Select withOut Air Option on HomePage");
		logs.info("Select withOut Air Option on HomePage");
		bookingPage.fillGoingToCityDetails("Berlin (Germany)");
		test.log(LogStatus.INFO, "User entered \"Berlin (Germany)\" into Going to from field");
		String selectDate=bookingPage.selectValueFromCalendar(180,3);
		test.log(LogStatus.INFO,   "User selects '" + selectDate + "' from calendar");
		bookingPage.selectStayingTime("4");
		test.log(LogStatus.INFO, "User entered \"4\" nights staying time");	
		bookingPage.selectNoMoreCitiesBtn();
		test.log(LogStatus.INFO, "Click on No More Cities Button");
		bookingPage.selectGuestDetails("2|Other");
		bookingPage.select2NumberOfAdultForRoom1("1", BookingLocators.getselectAdultDrpdown());
		bookingPage.selectNumberOfChild("1", "3", "Child1");
		test.log(LogStatus.INFO, "No.of Child & Age of Child got selected successfully");
		bookingPage.select1NumberOfAdultForRoom2("3", BookingLocators.getselectAdultRoom2Drpdown());
		bookingPage.doneButtonMob();
		test.log(LogStatus.INFO, "User select \"2 Rooms:1Adult,1Child in Room1,3Adults in Room2\" from Guest list");
		test.log(LogStatus.INFO, "All the basic booking details Source & Destination filled successfully for 4 Adults_1Child_4nights");
		bookingPage.clickonContinueButton();
		test.log(LogStatus.INFO, "Click on \"Continue\" Button");
		bookingPage.browseHotelsButton();
		test.log(LogStatus.INFO, "Click to browse hotels");
		bookingPage.browseHotelsBy_Reviewscore();
		test.log(LogStatus.INFO, "browseHotelsBy_Reviewscore");
		bookingPage.browseHotelsBy_Price();
		test.log(LogStatus.INFO, "browseHotelsBy_Price");
		bookingPage.browseHotelsBy_Name();
		test.log(LogStatus.INFO, "browseHotelsBy_Name");
		test.log(LogStatus.INFO, "User validated all hotel options for defined PAX details");
		logs.endTestCase(method.getName());
	}
	
   //new 
	@Test(groups= {"smoke"},priority=2)
	public void TC_0002_bookingJourneyWithFlightAndTrain(Method method) throws Exception {
		ExtentTest test = ExtentTestManager.startTest(method.getName(), "TC_0002_bookingJourneyWithFlightAndTrain");
		logs.startTestCase(method.getName());
		bookingPage.clickOnBuildYourVacationDropDown();
		PageBase.waitForElement(3);
		bookingPage.fillLeavingFromDetails("New York City (all Airports),  NY");
		test.log(LogStatus.INFO, "User entered \"New York City (all Airports),  NY\" into Leaving from field");
		bookingPage.fillGoingToCityDetails("London (England)");
		test.log(LogStatus.INFO, "User entered \"London (England)\" into Going to from field");
		String selectDate=bookingPage.selectValueFromCalendar(90,1);
		test.log(LogStatus.INFO,   "User selects '" + selectDate + "' from calendar");
		bookingPage.selectStayingTime("6");
		test.log(LogStatus.INFO, "User entered \"6\" nights staying time");	
		bookingPage.clickOnAddCityBtn();
		test.log(LogStatus.INFO, "Click on Add City Button");
		bookingPage.fillSecndAddedCityDetails("Paris (France)");
		test.log(LogStatus.INFO, "User select another city:Paris (France)");
		bookingPage.selectStayingTimeTwo("5");
		test.log(LogStatus.INFO, "User entered \"5\" nights staying time");	
		bookingPage.selectNoMoreCitiesBtn();
		test.log(LogStatus.INFO, "Click on No More Cities Button");
		bookingPage.validateTravlByTrain();
		test.log(LogStatus.INFO, "Change default transportation & validate that it should be a Train");
		bookingPage.selectGuestDetails("1|Other");
		test.log(LogStatus.INFO, "User select \"1 Room With Other Options\" from Guest list");
		test.log(LogStatus.INFO, "All the basic booking details Source & Destination filled successfully for 2_Adult_1Child_With_SingleRoom");
		logs.info("All the basic booking details Source & Destination filled successfully for 2_Adult_1Child_With_SingleRoom");
		bookingPage.selectNumberOfAdult("2", BookingLocators.getselectAdultDrpdown());
		bookingPage.selectnumberofadultsRoom_1iOS();
		test.log(LogStatus.INFO, "User selects \"2\" Adult from Adult Drpdown");
		bookingPage.selectNumberOfChild("1", "11", "Child1");
		bookingPage.doneButtonMob();
		test.log(LogStatus.INFO, "User selects \"1\" Child,\"Age of Child:11\"");
		test.log(LogStatus.INFO, "No.of Child & Age of Child got selected successfully");
		logs.info("No.of Child & Age of Child got selected successfully");
		bookingPage.clickonContinueButton();
		test.log(LogStatus.INFO, "Click on Continue Button");
		logs.info("Click on Continue Button");
		bookingPage.selectCheaperFlights("Coach/Economy");
		test.log(LogStatus.INFO, "User clicks on Select Cheaper Flights Link");
		test.log(LogStatus.INFO, "User selects a particular flight from existing options");
		test.log(LogStatus.INFO, "User selects cabin class:Coach/Economy");
		test.log(LogStatus.INFO, "User clicks on Continue Link");
		logs.info("Select Cheaper flights from flight options");
		bookingPage.getTripinclusionContinueButton();
		bookingPage.clicktoContinuePage();
		test.log(LogStatus.INFO, "User clicks on Continue Link");
		test.log(LogStatus.INFO, "Validating flight at TripInclusion Page");
		logs.endTestCase(method.getName());
	}
	
	//new
	@Test(groups= {"smoke"},priority=7)
	public void TC_0007_bookingFlightAndHotelForSingleCitywithTopDealsValidation(Method method) throws Exception {
		ExtentTest test=ExtentTestManager.startTest(method.getName(), "TC_0007_bookingFlightAndHotelForSingleCitywithTopDealsValidation");
		logs.startTestCase(method.getName());
		bookingPage.clickOnBuildYourVacationDropDown();
		bookingPage.clickOnTopDealsLink();
		test.log(LogStatus.INFO, "User clicks on Top Deals Link");
		bookingPage.validateTopDealsPage();
		test.log(LogStatus.INFO, "User is redirected to Top Deals Page,Verified!");
		bookingPage.validateTopDealsList();
		test.log(LogStatus.INFO, "User validated that TopDeals List is available");
		String expectedVal=bookingPage.getFirstDealTxtclickonCustomize();
		test.log(LogStatus.INFO, "User clicks on customize button for first package");
		bookingPage.validateFirstDealPage(expectedVal);
		test.log(LogStatus.INFO, "User redirected to first deal of the week,Verified!");
		bookingPage.fillLeavingFromDetails_FirstPckg("New York, Newark, NJ - EWR");
		test.log(LogStatus.INFO, "User entered \"New York, Newark, NJ - EWR\" into leaving from field");
		String selectDate=bookingPage.selectValueFromCalendar_FirstPckg(90,1);	
		test.log(LogStatus.INFO,   "User selects '" + selectDate + "' from calendar");
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
		test.log(LogStatus.INFO, "Select Cheaper flights from flight options");
		logs.info("Select Cheaper flights from flight options");
		test.log(LogStatus.INFO, "Select Cheaper flights from flight options");
		test.log(LogStatus.INFO, "User selects cabin class:Mixed Cabin");
		bookingPage.clicktoContinuePage();
		test.log(LogStatus.INFO, "User clicks on Continue  to arrive in Pax Info Page");
		expectedFirstTravellerInfo = passengerInfoPage.fillTravellerDetailsForMultipleRooms("Room1Traveller1");
		test.log(LogStatus.INFO, "User enters \"yury\" as Traveller1 First Name");
		test.log(LogStatus.INFO, "User enters \"darwin\" as Traveller1 Last Name");
		test.log(LogStatus.INFO, "User selects \"Gender:Male\" for Traveller1 ");
		test.log(LogStatus.INFO, "User selects \"DOB:01/01/2000\" for Traveller1 Date of Birth");
		test.log(LogStatus.INFO, "User selects \"Passport details as:US\" for Traveller1");
		expectedSecondTravellerInfo = passengerInfoPage.fillTravellerDetailsForMultipleRooms("Room2Traveller1");
		test.log(LogStatus.INFO, "User enters \"Hanna\" as Traveller3 First Name");
		test.log(LogStatus.INFO, "User enters \"darwin\" as Traveller3 Last Name");
		test.log(LogStatus.INFO, "User selects \"Gender:Male\" for Traveller3 ");
		test.log(LogStatus.INFO, "User selects \"DOB:01/01/2000\" for Traveller3 Date of Birth");
		test.log(LogStatus.INFO, "User selects \"Passport details as:US\" for Traveller3");
		expectedThirdTravellerInfo = passengerInfoPage.fillTravellerDetailsForMultipleRooms("Room2Child1SingleTravlr");
		test.log(LogStatus.INFO, "User enters \"Erwin\" as Traveller4 First Name");
		test.log(LogStatus.INFO, "User enters \"George\" as Traveller4 Last Name");
		test.log(LogStatus.INFO, "User selects \"Gender:Male\" for Traveller4 ");
		test.log(LogStatus.INFO, "User selects \"DOB:01/01/2011\" for Traveller4 Date of Birth");
		test.log(LogStatus.INFO, "User selects \"Passport details as:US\" for Traveller4");
		test.log(LogStatus.INFO, "User filled all the passenger details successfully");
		logs.info("User filled all the passenger details successfully");
		bookingPage.clicktoContinuePage();
		test.log(LogStatus.INFO, "Click on Continue Button & User redirected to the Payment Page");
		PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler1Name(), expectedFirstTravellerInfo);
		PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler2Name(), expectedSecondTravellerInfo);
		PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler3Name(), expectedThirdTravellerInfo);
		test.log(LogStatus.INFO, "Flights & passenger details verified successfully on PaymentPage");
		logs.info("Flights & passenger details verified successfully on PaymentPage");
		logs.endTestCase(method.getName());
	}
	
	//new.
	@Test(groups= {"smoke"},priority=6)
	public void TC_0006_bookingFlightsWithmultipleCitieswithHighLightsValidation(Method method) throws Exception {
		ExtentTest test = ExtentTestManager.startTest(method.getName(), "TC_0006_bookingFlightsWithmultipleCitieswithHighLightsValidation");
		logs.startTestCase(method.getName());
		bookingPage.clickOnBuildYourVacationDropDown();				
		bookingPage.validateHighLights();
		test.log(LogStatus.INFO, "Highlights are available on Homepage,Validated!");	
		PageBase.clickUsingJavaScript(HomePageLocators.getmoreHighLightsBtn());
		test.log(LogStatus.INFO, "Click on More Highlights & Attractions link ");	
		String value=bookingPage.selectFirstHighLightOption();
		test.log(LogStatus.INFO, "Select First HighLight Option");	
		bookingPage.validateHighlightOption(value);
		test.log(LogStatus.INFO, "User redirected to the corresponding highlight page,Verified!");	
		bookingPage.fillLeavingFromDetails("New York City (all Airports),  NY");
		test.log(LogStatus.INFO, "User entered leaving from: New York City (all Airports),  NY");
		bookingPage.fillGoingToCityDetails("Berlin (Germany)");
		test.log(LogStatus.INFO, "User entered Going to City:Berlin (Germany)");
		test.log(LogStatus.INFO, "Select staying time for city1 :4 nights");
		bookingPage.clickOnAddCityBtn();
		test.log(LogStatus.INFO, "Click on Add City Button");
		bookingPage.fillSecndAddedCityDetails("Augsburg (Germany)");
		test.log(LogStatus.INFO, "User select another city:Augsburg (Germany)");
		String selectDate=bookingPage.selectValueFromCalendar(150,2);
		test.log(LogStatus.INFO,   "User selects '" + selectDate + "' from calendar");
		test.log(LogStatus.INFO, "Select staying time for city 2 :4 nights");
		bookingPage.selectNoMoreCitiesBtn();
		test.log(LogStatus.INFO, "Click on No More Cities Button");
		test.log(LogStatus.INFO, "User select \"1 Room With 1 Adult\" from Guest list");
		test.log(LogStatus.INFO, "All the basic booking details Source & Destination filled successfully for 1_Adult_With_SingleRoom");		
		bookingPage.doneButtonMob();
		bookingPage.clicktoContinuePage();
		test.log(LogStatus.INFO, "Click on Continue Button");
		bookingPage.selectCheaperFlights("Coach/Economy");
		test.log(LogStatus.INFO, "User clicks on Select Cheaper Flights Link");
		test.log(LogStatus.INFO, "User selects a particular flight from existing options");
		test.log(LogStatus.INFO, "User selects cabin class:Coach/Economy");
		test.log(LogStatus.INFO, "User clicks on Continue Link");
		bookingPage.getTripinclusionContinueButton();
		bookingPage.clicktoContinuePage();
		expectedFirstTravellerInfo = passengerInfoPage.fillFirstTravellerDetails("Morris", "Leo", "Male","01/01/1992", "237|US");
		test.log(LogStatus.INFO, "User enters \"Morris\" as First Traveller First Name");
		test.log(LogStatus.INFO, "User enters \"Mano\" as First Traveller Last Name");
		test.log(LogStatus.INFO, "User selects \"Gender:Male\" for First Traveller Last Name");
		test.log(LogStatus.INFO, "User selects \"DOB:01/01/1992\" for First Traveller's Date of Birth");
		test.log(LogStatus.INFO, "User selects \"Passport details as:US\" for First Traveller");
		expectedSecondTravellerInfo = passengerInfoPage.fillSecondTravellerDetails("Shally", "Leo", "Male","01/01/2011", "237|US", "Adult");
		test.log(LogStatus.INFO, "User enters \"Shally\" as Second Traveller First Name");
		test.log(LogStatus.INFO, "User enters \"Mano\" as Second Traveller Last Name");
		test.log(LogStatus.INFO, "User selects \"Female\" for Second Traveller Last Name");
		test.log(LogStatus.INFO, "User selects \"DOB:01/01/2011\" for Second Traveller's Date of Birth");
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
		test.log(LogStatus.INFO, "Flights & passenger details verified successfully on PaymentPage");
		logs.info("Flights & passenger details verified successfully on PaymentPage");
		logs.endTestCase(method.getName());
	}
	//new
	@Test(groups= {"smoke"},priority=5)
	public void TC_0005_FlightbookingjourneywithBYOPackage(Method method) throws Exception {
		ExtentTest test = ExtentTestManager.startTest(method.getName(), "TC_0005_FlightbookingjourneywithBYOPackage");
		logs.startTestCase(method.getName());
		bookingPage.selectFromVacationPackageIdeas();
		test.log(LogStatus.INFO, "User selects an option from Vacation Package Ideas");
		bookingPage.clicktoReorderCities();
		test.log(LogStatus.INFO, "User clicks on Reorder cities button");	
		bookingPage.fillLeavingFromDetails_BYOPage("Chicago (All Airports)");
		test.log(LogStatus.INFO, "User entered \"Chicago (All Airports)\" into leaving from field");
		String selectDate=bookingPage.selectValueFromCalendar_BYOPackage(120);
		test.log(LogStatus.INFO,   "User selects '" + selectDate + "' from calendar");	
		bookingPage.selectGuestDetails_BYOPage("2 rooms with children or other options");
		test.log(LogStatus.INFO, "User select \"2 Room With Other Options\" from Guest list");
		test.log(LogStatus.INFO, "User select \"1 Adult 1Child \" for Room1 ");
		test.log(LogStatus.INFO, "User select \"Age of Child:7 \" for Room1 ");
		test.log(LogStatus.INFO, "2 Adults selecetd for Room 2 ");
		bookingPage.clickToContinue_BYOPage();
		test.log(LogStatus.INFO, "User clicks on BYO Page");
		bookingPage.selectCheaperFlights("Coach/Economy");
		test.log(LogStatus.INFO, "User clicks on Select Cheaper Flights Link");
		test.log(LogStatus.INFO, "User selects a particular flight from existing options");
		test.log(LogStatus.INFO, "User selects cabin class:Coach/Economy");
		bookingPage.clicktoContinuePage();
		test.log(LogStatus.INFO, "User clicks on Continue Link to fill PAX details");
		bookingPage.clicktoContinuePage();
		test.log(LogStatus.INFO, "User clicks on continue Page Button");
		bookingPage.validateErrorMessage_MandatoryFields();
		test.log(LogStatus.INFO, "Validate error message for Mandatory Fields");
		logs.endTestCase(method.getName());
		
	}	
	//new
	@Test(groups= {"smoke"},priority=4)
	public void TC_0004_FirstPackageoptionalongwithRemoveHotelFunc(Method method) throws Exception {
		 ExtentTest test = ExtentTestManager.startTest(method.getName(), "TC_0004_FirstPackageoptionalongwithRemoveHotelFunc");
		 logs.startTestCase(method.getName());
		 bookingPage.selectFromVacationPackageIdeas();
		 test.log(LogStatus.INFO, "User selects an option from Vacation Package Ideas");
		bookingPage.fillLeavingFromDetails_FirstPckg("Washington (all Airports), DC");
		test.log(LogStatus.INFO, "User entered \"Washington (all Airports), DC\" into leaving from field");
		String selectDate=bookingPage.selectValueFromCalendar_FirstPckg(90,1);
		test.log(LogStatus.INFO,   "User selects '" + selectDate + "' from calendar");		
		bookingPage.selectGuestDetails_FirstPckgOneRoom("1|2");
		test.log(LogStatus.INFO, "User selects 1 Room with two Adults");
		bookingPage.clickOnViewPrice();
		test.log(LogStatus.INFO, "User clicks on View Price Button");
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
		test.log(LogStatus.INFO, "Click to Continue & User redirected to Payment Page");
		PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler1Name(), expectedFirstTravellerInfo);
		PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler2Name(), expectedSecondTravellerInfo);
		bookingPage.tripSummary();
		test.log(LogStatus.INFO, "Removed Hotel is not available for second City,Verified!");
		test.log(LogStatus.INFO, "Flights & passenger details verified successfully on PaymentPage");
		logs.endTestCase(method.getName());
	}
	
	//new
		@Test(groups= {"smoke"},priority=3)
		public void TC_0003_bookingTwoRoomTwoAdult(Method method) throws Exception {
			ExtentTest test = ExtentTestManager.startTest(method.getName(), "TC_0003_bookingTwoRoomTwoAdult");
			logs.startTestCase(method.getName());
			bookingPage.clickOnBuildYourVacationDropDown();
			PageBase.waitForElement(3);
			bookingPage.fillLeavingFromDetails("Seattle, WA");
			test.log(LogStatus.INFO, "User entered \"Seattle, WA\" into Leaving from field");
			bookingPage.fillGoingToCityDetails("Dublin (Ireland)");
			test.log(LogStatus.INFO, "User entered \"Dublin (Ireland)\" into Going to from field");
			String selectDate=bookingPage.selectValueFromCalendar(150,2);
			test.log(LogStatus.INFO,   "User selects '" + selectDate + "' from calendar");	
			bookingPage.selectStayingTime("4");
			test.log(LogStatus.INFO, "User entered \"4\" nights staying time");	
			bookingPage.clickOnAddCityBtn();
			test.log(LogStatus.INFO, "User clicks on Add City Button");
			bookingPage.fillSecndAddedCityDetails("Galway (Ireland)");
			test.log(LogStatus.INFO, "User entered another city:Galway (Ireland)");
			bookingPage.selectStayingTimeTwo("4");
			test.log(LogStatus.INFO, "User entered \"4\" nights staying time");	
			bookingPage.clickOnAddCityBtn();
			test.log(LogStatus.INFO, "User clicks on Add City Button");
			bookingPage.fillThirdAddedCityDetails("Limerick (Ireland)");
			test.log(LogStatus.INFO, "User select another city:Limerick (Ireland)");
			Thread.sleep(4000);
			bookingPage.selectStayingTimeThree("4");
			test.log(LogStatus.INFO, "Select staying time :4 nights");
			bookingPage.selectNoMoreCitiesBtn();
			test.log(LogStatus.INFO, "User clicked on No More Cities,Continue button");
			bookingPage.clickOnRemoveBtnScndCity();
			test.log(LogStatus.INFO, "User click on Edit/Remove option corresponding to GalWay");
			bookingPage.deleteSecondCity();
			test.log(LogStatus.INFO, "User clicked on Remove Second City");
			bookingPage.selectNoMoreCitiesBtn();
			test.log(LogStatus.INFO, "User clicked on No More Cities,Continue button");
			boolean status=bookingPage.isSecondremovecitydisplayed();
			System.out.println("Print the status"+status);
			Assert.assertFalse(status);
			test.log(LogStatus.INFO, "Verified that Galway is removed successfully");
			bookingPage.clickOnRemoveBtnScndCity();
			test.log(LogStatus.INFO, "Click on edit/Remove option corresponding to LimeRick");
			bookingPage.deleteSecondCity();
			test.log(LogStatus.INFO, "User clicked to remove Limerick");
			bookingPage.clickOnAddCityBtn();
			test.log(LogStatus.INFO, "User clicks on Add City Button to re-add Galway");
			bookingPage.fillSecndAddedCityDetails("Galway (Ireland)");
			test.log(LogStatus.INFO, "User entered another city:Galway (Ireland)");
			bookingPage.selectStayingTimeTwo("4");
			test.log(LogStatus.INFO, "User entered \"4\" nights staying time");	
			bookingPage.clickOnAddCityBtn();
			test.log(LogStatus.INFO, "User clicks on Add City Button to re-add Limerick");
			bookingPage.fillThirdAddedCityDetails("Limerick (Ireland)");
			test.log(LogStatus.INFO, "User select another city:Limerick (Ireland)");			
			Thread.sleep(4000);
			bookingPage.selectStayingTimeThree("4");
			test.log(LogStatus.INFO, "Select staying time :4 nights");
			bookingPage.selectNoMoreCitiesBtn();
			test.log(LogStatus.INFO, "User clicked on No More Cities,Continue button");
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
			bookingPage.selectCheaperFlights("Coach/Economy");
			test.log(LogStatus.INFO, "User clicks on Select Cheaper Flights Link");
			test.log(LogStatus.INFO, "User selects a particular flight from existing options");
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
			test.log(LogStatus.INFO, "User enters \"Erwin\" as Traveller2 First Name");
			test.log(LogStatus.INFO, "User enters \"George\" as Traveller2 Last Name");
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
			logs.info("User filled all the passenger details successfully");
			bookingPage.clicktoContinuePage();
			test.log(LogStatus.INFO, "Click on Continue Button & User redirected to the Payment Page");
			PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler1Name(), expectedFirstTravellerInfo);
			PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler2Name(), expectedSecondTravellerInfo);
			PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler3Name(), expectedThirdTravellerInfo);
			PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler4Name(), expectedFourthTravellerInfo);
			test.log(LogStatus.INFO, "Flights & passenger details verified successfully on PaymentPage");
			logs.info("Flights & passenger details verified successfully on PaymentPage");
			logs.endTestCase(method.getName());
		}
}

