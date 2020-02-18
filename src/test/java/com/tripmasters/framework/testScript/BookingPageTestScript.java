package com.tripmasters.framework.testScript;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.tripmasters.framework.actions.BookingPageAction;
import com.tripmasters.framework.actions.HomePageAction;
import com.tripmasters.framework.actions.PassengerInfoPageAction;
import com.tripmasters.framework.base.TestBase;
import com.tripmasters.framework.pages.BookingLocators;
import com.tripmasters.framework.pages.HomePageLocators;
import com.tripmasters.framework.utils.CommonLib;
import com.tripmasters.framework.utils.ExtentTestManager;
import com.tripmasters.framework.utils.Logs;

public class BookingPageTestScript extends TestBase {

	List<String> expectedFirstTravellerInfo = new ArrayList<String>();
	List<String> expectedSecondTravellerInfo = new ArrayList<String>();
	List<String> expectedThirdTravellerInfo = new ArrayList<String>();
	List<String> expectedFourthTravellerInfo = new ArrayList<String>();
	List<String> expectedFlightDetails = new ArrayList<String>();

	private static String ActualHotel;
	private static String ExpectedHotel;

	@Test(groups = { "smoke" }, priority = 1)
	public void bookingSingleRoomWithThreeAdults_TC_1(Method method) throws Exception {
		ExtentTest test = ExtentTestManager.startTest(method.getName(), "bookingSingleRoomWith3Adults");
		BookingPageAction.fillBasicBookingDetails("New York, Newark, NJ", "Berlin (Germany)", "4", "1|3");
		test.log(LogStatus.INFO, "Booking details Source & Destination filled successfully for 3 Adults_4nights");
		Logs.info("Booking details Source & Destination filled successfully for 3 Adults_4nights");
		BookingPageAction.clickonContinueButton();
		test.log(LogStatus.INFO, "Click on Continue Button");
		BookingPageAction.selectCheaperFlights();
		test.log(LogStatus.INFO, "Select Cheaper flights from flight options");
		BookingPageAction.clicktoContinuePage();
		expectedFirstTravellerInfo = PassengerInfoPageAction.fillFirstTravellerDetails("John", "Leo", "Male",
				"01/01/1992", "237|US");
		expectedSecondTravellerInfo = PassengerInfoPageAction.fillSecondTravellerDetails("Elvin", "Leo", "Male",
				"01/01/1994", "237|US", "Adult");
		expectedThirdTravellerInfo = PassengerInfoPageAction.fillThirdTravellerDetails("Marie", "Leo", "Female",
				"01/01/1996", "237|US");
		test.log(LogStatus.INFO, "User filled all the passenger details successfully");
		Logs.info("User fills all the 3 passenger details");
		BookingPageAction.clicktoContinuePage();
		CommonLib.verifyTravellerDetails(BookingLocators.getverifyTraveler1Name(), expectedFirstTravellerInfo);
		CommonLib.verifyTravellerDetails(BookingLocators.getverifyTraveler2Name(), expectedSecondTravellerInfo);
		CommonLib.verifyTravellerDetails(BookingLocators.getverifyTraveler3Name(), expectedThirdTravellerInfo);
		test.log(LogStatus.INFO, "Flights & passenger details verified successfully on PaymentPage");
		Logs.info("Flights & passenger details verified successfully on PaymentPage");
	}

	@Test(groups= {"regression"},priority=2)
	public void bookingSingleRoomOneAdultOneChild_TC_2(Method method) throws Exception {
		ExtentTest test = ExtentTestManager.startTest(method.getName(), "bookingSingleRoom1Adult1Child");
		BookingPageAction.fillBasicBookingDetails("Philadelphia, PA", "Berlin (Germany)", "4", "1|Other");
		test.log(LogStatus.INFO,"Booking details Source & Destination filled successfully for 1 Adults_1Child_4nights");
		Logs.info("Booking details Source & Destination filled successfully for 1 Adults_1Child_4nights");
		BookingPageAction.selectNumberOfAdult("1", BookingLocators.getselectAdultDrpdown());
		BookingPageAction.selectNumberOfChild("1", "9", "Child1");
		test.log(LogStatus.INFO, "No.of Child & Age of Child got selected successfully");
		Logs.info("No.of Child & Age of Child got selected successfully");
		BookingPageAction.clickonContinueButton();
		test.log(LogStatus.INFO, "Click on Continue Button");
		Logs.info("Click on Continue Button");
		BookingPageAction.selectCheaperFlights();
		test.log(LogStatus.INFO, "Select Cheaper flights from flight options");
		Logs.info("Select Cheaper flights from flight options");
		BookingPageAction.clicktoContinuePage();
		expectedFirstTravellerInfo = PassengerInfoPageAction.fillFirstTravellerDetails("Morris", "Leo", "Male",
				"01/01/1992", "237|US");
		expectedSecondTravellerInfo = PassengerInfoPageAction.fillSecondTravellerDetails("Shally", "Leo", "Male",
				"01/01/1994", "237|US", "Child");
		BookingPageAction.clicktoContinuePage();
		test.log(LogStatus.INFO, "User filled all the passenger details successfully");
		Logs.info("User filled all the passenger details successfully");
		CommonLib.verifyTravellerDetails(BookingLocators.getverifyTraveler1Name(), expectedFirstTravellerInfo);
		CommonLib.verifyTravellerDetails(BookingLocators.getverifyTraveler2Name(), expectedSecondTravellerInfo);
		test.log(LogStatus.INFO, "Flights & passenger details verified successfully on PaymentPage");
		Logs.info("Flights & passenger details verified successfully on PaymentPage");
	}

    @Test(groups= {"smoke"},priority=3)
	public void bookingTwoRoomTwoAdult_TC_3(Method method) throws Exception {
		ExtentTest test = ExtentTestManager.startTest(method.getName(), "bookingTwoRoom2Adult");
		BookingPageAction.fillBasicBookingDetails("New York, Newark, NJ", "Berlin (Germany)", "6", "2|2-2");
		test.log(LogStatus.INFO, "Booking details Source & Destination filled successfully for Two Adults");
		Logs.info("Booking details Source & Destination filled successfully for Two Adults");
		BookingPageAction.clickonContinueButton();
		test.log(LogStatus.INFO, "Click on Continue Button");
		Logs.info("Click on Continue Button");
		BookingPageAction.selectCheaperFlights();
		test.log(LogStatus.INFO, "Select Cheaper flights from flight options");
		Logs.info("Select Cheaper flights from flight options");
		BookingPageAction.clicktoContinuePage();
		expectedFirstTravellerInfo = PassengerInfoPageAction.fillTravellerDetailsForMultipleRooms("Room1Traveller1");
		expectedSecondTravellerInfo = PassengerInfoPageAction.fillTravellerDetailsForMultipleRooms("Room1Traveller2");
		expectedThirdTravellerInfo = PassengerInfoPageAction.fillTravellerDetailsForMultipleRooms("Room2Traveller1");
		expectedFourthTravellerInfo = PassengerInfoPageAction.fillTravellerDetailsForMultipleRooms("Room2Traveller2");
		BookingPageAction.clicktoContinuePage();
		test.log(LogStatus.INFO, "User filled all the passenger details successfully");
		Logs.info("User filled all the passenger details successfully");
		CommonLib.verifyTravellerDetails(BookingLocators.getverifyTraveler1Name(), expectedFirstTravellerInfo);
		CommonLib.verifyTravellerDetails(BookingLocators.getverifyTraveler2Name(), expectedSecondTravellerInfo);
		CommonLib.verifyTravellerDetails(BookingLocators.getverifyTraveler3Name(), expectedThirdTravellerInfo);
		CommonLib.verifyTravellerDetails(BookingLocators.getverifyTraveler4Name(), expectedFourthTravellerInfo);
		test.log(LogStatus.INFO, "Flights & passenger details verified successfully on PaymentPage");
		Logs.info("Flights & passenger details verified successfully on PaymentPage");
	}

	@Test(groups= {"smoke"},priority=4)
	public void bookingTwoRoomThreeAdultOneChild_TC_4(Method method) throws Exception {
		ExtentTest test = ExtentTestManager.startTest(method.getName(), "bookingTwoRoom3Adult1Child");
		BookingPageAction.fillBasicBookingDetails("New York, Newark, NJ", "Berlin (Germany)", "4", "2|Other");
		test.log(LogStatus.INFO, "Booking details filled successfully for Three Adults & One Child");
		Logs.info("Booking details filled successfully for Three Adults & One Child");
		BookingPageAction.selectNumberOfAdult("2", BookingLocators.getselectAdultDrpdown());
		BookingPageAction.selectNumberOfChild("1", "9", "Child1");
		test.log(LogStatus.INFO, "No.of Child & Age of Child got selected successfully");
		Logs.info("No.of Child & Age of Child got selected successfully");
		BookingPageAction.selectNumberOfAdult("1", BookingLocators.getselectAdultRoom2Drpdown());
		BookingPageAction.clickonContinueButton();
		test.log(LogStatus.INFO, "Click on Continue Button");
		Logs.info("Click on Continue Button");
		BookingPageAction.selectCheaperFlights();
		test.log(LogStatus.INFO, "Select Cheaper flights from flight options");
		Logs.info("Select Cheaper flights from flight options");
		BookingPageAction.clicktoContinuePage();
		expectedFirstTravellerInfo = PassengerInfoPageAction.fillTravellerDetailsForMultipleRooms("Room1Traveller1");
		expectedSecondTravellerInfo = PassengerInfoPageAction.fillTravellerDetailsForMultipleRooms("Room1Traveller2");
		expectedThirdTravellerInfo = PassengerInfoPageAction.fillTravellerDetailsForMultipleRooms("Room1Child1");
		expectedFourthTravellerInfo = PassengerInfoPageAction.fillTravellerDetailsForMultipleRooms("Room2Traveller1");
		BookingPageAction.clicktoContinuePage();
		test.log(LogStatus.INFO, "User filled all the passenger details successfully");
		Logs.info("User filled all the passenger details successfully");
		CommonLib.verifyTravellerDetails(BookingLocators.getverifyTraveler1Name(), expectedFirstTravellerInfo);
		CommonLib.verifyTravellerDetails(BookingLocators.getverifyTraveler2Name(), expectedSecondTravellerInfo);
		CommonLib.verifyTravellerDetails(BookingLocators.getverifyTraveler3Name(), expectedThirdTravellerInfo);
		CommonLib.verifyTravellerDetails(BookingLocators.getverifyTraveler4Name(), expectedFourthTravellerInfo);
		test.log(LogStatus.INFO, "Flights & passenger details verified successfully on PaymentPage");
		Logs.info("Flights & passenger details verified successfully on PaymentPage");
	}

	@Test(groups= {"smoke"},priority=5)
	public void bookingTwoRoomTwoAdultTwoChild_TC_5(Method method) throws Exception {
		ExtentTest test = ExtentTestManager.startTest(method.getName(), "booking2Room2Adult2Child");
		BookingPageAction.fillBasicBookingDetails("New York, Newark, NJ", "Berlin (Germany)", "6", "2|Other");
		test.log(LogStatus.INFO, "Booking details filled successfully for Two Adults & Two Child");
		Logs.info("Booking details filled successfully for Two Adults & Two Child");
		BookingPageAction.selectNumberOfAdult("1", BookingLocators.getselectAdultDrpdown());
		BookingPageAction.selectNumberOfChild("1", "9", "Child1");
		test.log(LogStatus.INFO, "No.of Child & Age of Child got selected successfully");
		Logs.info("No.of Child & Age of Child got selected successfully");
		BookingPageAction.selectNumberOfAdult("1", BookingLocators.getselectAdultRoom2Drpdown());
		BookingPageAction.selectNumberOfChild("1", "9", "Child2");
		BookingPageAction.clickonContinueButton();
		test.log(LogStatus.INFO, "Click on Continue Button");
		Logs.info("Click on Continue Button");
		BookingPageAction.selectCheaperFlights();
		test.log(LogStatus.INFO, "Select Cheaper flights from flight options");
		Logs.info("Select Cheaper flights from flight options");
		BookingPageAction.clicktoContinuePage();
		//BookingPageAction.clicktoContinuePage();
		expectedFirstTravellerInfo = PassengerInfoPageAction.fillTravellerDetailsForMultipleRooms("Room1Traveller1");
		expectedSecondTravellerInfo = PassengerInfoPageAction.fillTravellerDetailsForMultipleRooms("Room1Child1SingleTravlr");
		expectedThirdTravellerInfo = PassengerInfoPageAction.fillTravellerDetailsForMultipleRooms("Room2Traveller1");
		expectedFourthTravellerInfo = PassengerInfoPageAction.fillTravellerDetailsForMultipleRooms("Room2Child1SingleTravlr");
		test.log(LogStatus.INFO, "User filled all the passenger details successfully");
		Logs.info("User filled all the passenger details successfully");
		BookingPageAction.clicktoContinuePage();
		test.log(LogStatus.INFO, "Click on Continue Button & User redirected to the Payment Page");
		CommonLib.verifyTravellerDetails(BookingLocators.getverifyTraveler1Name(), expectedFirstTravellerInfo);
		CommonLib.verifyTravellerDetails(BookingLocators.getverifyTraveler2Name(), expectedSecondTravellerInfo);
		CommonLib.verifyTravellerDetails(BookingLocators.getverifyTraveler3Name(), expectedThirdTravellerInfo);
		CommonLib.verifyTravellerDetails(BookingLocators.getverifyTraveler4Name(), expectedFourthTravellerInfo);
		test.log(LogStatus.INFO, "Flights & passenger details verified successfully on PaymentPage");
		Logs.info("Flights & passenger details verified successfully on PaymentPage");
	}

	@Test(groups= {"smoke"},priority=6)
	public void bookingFlightsWithmultipleCities_TC_6(Method method) throws Exception {
		ExtentTest test = ExtentTestManager.startTest(method.getName(), "bookingFlightsWithmultipleCities");
		BookingPageAction.fillBasicBookingDetailForMultipleCities("WithAir", "Berlin (Germany)", "4",
				"Augsburg (Germany)", "1|Other");
		test.log(LogStatus.INFO, "Booking details filled successfully for multiple cities");
		Logs.info("Booking details filled successfully for multiple cities");
		BookingPageAction.selectNumberOfAdult("1", BookingLocators.getselectAdultDrpdown());
		BookingPageAction.selectNumberOfChild("1", "9", "Child1");
		test.log(LogStatus.INFO, "No.of Child & Age of Child got selected successfully");
		Logs.info("No.of Child & Age of Child got selected successfully");
		BookingPageAction.clickonContinueButton();
		test.log(LogStatus.INFO, "Click on Continue Button");
		Logs.info("Click on Continue Button");
		BookingPageAction.selectCheaperFlights();
		test.log(LogStatus.INFO, "Select Cheaper flights from flight options");
		Logs.info("Select Cheaper flights from flight options");
		BookingPageAction.clicktoContinuePage();
		BookingPageAction.clicktoContinuePage();
		expectedFirstTravellerInfo = PassengerInfoPageAction.fillFirstTravellerDetails("Morris", "Leo", "Male",
				"01/01/1992", "237|US");
		expectedSecondTravellerInfo = PassengerInfoPageAction.fillSecondTravellerDetails("Shally", "Leo", "Male",
				"01/01/1994", "237|US", "Child");
		test.log(LogStatus.INFO, "User filled all the passenger details successfully");
		Logs.info("User filled all the passenger details successfully");
		BookingPageAction.clicktoContinuePage();
		CommonLib.verifyTravellerDetails(BookingLocators.getverifyTraveler1Name(), expectedFirstTravellerInfo);
		CommonLib.verifyTravellerDetails(BookingLocators.getverifyTraveler2Name(), expectedSecondTravellerInfo);
		test.log(LogStatus.INFO, "Flights & passenger details verified successfully on PaymentPage");
		Logs.info("Flights & passenger details verified successfully on PaymentPage");
	}

	@Test(groups= {"smoke"},priority=7)
	public void bookingFlightAndHotelForSingleCity_TC_7(Method method) throws Exception {
		ExtentTest test=ExtentTestManager.startTest(method.getName(), "bookingFlightAndHotelForSingleCity");
		BookingPageAction.fillBasicBookingDetails("New York, Newark, NJ", "Delhi (India)", "6", "2|Other");
		test.log(LogStatus.INFO, "Booking details filled successfully for single city");
		Logs.info("Booking details filled successfully for single city");
		BookingPageAction.selectNumberOfAdult("1", BookingLocators.getselectAdultDrpdown());
		BookingPageAction.selectNumberOfChild("1", "9", "Child1");
		test.log(LogStatus.INFO, "No.of Child & Age of Child got selected successfully");
		Logs.info("No.of Child & Age of Child got selected successfully");
		BookingPageAction.selectNumberOfAdult("1", BookingLocators.getselectAdultRoom2Drpdown());
		BookingPageAction.clickonContinueButton();
		test.log(LogStatus.INFO, "Click on Continue Button");
		Logs.info("Click on Continue Button");
		ActualHotel = BookingPageAction.browseHotelsButton();
		test.log(LogStatus.INFO, "Click on Browse Hotels Button");
		Logs.info("Click on Browse Hotels Button");
		ExpectedHotel = BookingPageAction.browseSelectHotel();
		test.log(LogStatus.INFO, "Select particular hotel from Hotel Options");
		Logs.info("Select particular hotel from Hotel Options");
		BookingPageAction.clicktoContinuePage();
		String expected = BookingPageAction.selectCheaperFlights();
		test.log(LogStatus.INFO, "Select Cheaper flights from flight options");
		Logs.info("Select Cheaper flights from flight options");
		String actualFlightDetails = BookingPageAction.getActualFlight();
		System.out.println("Actual is:" +actualFlightDetails   + " "+ "Expected is :"+expected);
		Assert.assertTrue(actualFlightDetails.contains(expected));
		test.log(LogStatus.INFO, "Verify that only selected flight appears along with passenger details");
		Logs.info("Verify that only selected flight appears along with passenger details");
		Assert.assertEquals(ActualHotel, ExpectedHotel);
		test.log(LogStatus.INFO, "Verify that only particular selected hotel appears along with passenger details");
		Logs.info("Verify that only particular selected hotel appears along with passenger details");
	}

	@Test(groups= {"smoke"},priority=8)
	public void bookingFlightAndHotelForMultipleCity_TC_8(Method method) throws Exception {
		ExtentTest test=ExtentTestManager.startTest(method.getName(), "bookingFlightAndHotelForMultipleCity");
		BookingPageAction.fillBasicBookingDetailForMultipleCities("WithAir", "Berlin (Germany)", "4","Augsburg (Germany)", "1|Other");
		test.log(LogStatus.INFO, "Booking details filled successfully for multiple cities");
		Logs.info("Booking details filled successfully for multiple cities");
		BookingPageAction.selectNumberOfAdult("1", BookingLocators.getselectAdultDrpdown());
		BookingPageAction.selectNumberOfChild("1", "9", "Child1");
		test.log(LogStatus.INFO, "No.of Child & Age of Child got selected successfully");
		Logs.info("No.of Child & Age of Child got selected successfully");
		BookingPageAction.clickonContinueButton();
		test.log(LogStatus.INFO, "Click on Continue Button");
		Logs.info("Click on Continue Button");
		BookingPageAction.selectCheaperFlights();
		test.log(LogStatus.INFO, "Select Cheaper flights from flight options");
		Logs.info("Select Cheaper flights from flight options");
		BookingPageAction.clicktoContinuePage();
		BookingPageAction.clicktoContinuePage();
		expectedFirstTravellerInfo = PassengerInfoPageAction.fillFirstTravellerDetails("Morris", "Leo", "Male","01/01/1992", "237|US");
		expectedSecondTravellerInfo = PassengerInfoPageAction.fillSecondTravellerDetails("Shally", "Leo", "Male","01/01/1994", "237|US", "Child");
		test.log(LogStatus.INFO, "User filled all the passenger details successfully");
		Logs.info("User filled all the passenger details successfully");
		BookingPageAction.clicktoContinuePage();
		CommonLib.verifyTravellerDetails(BookingLocators.getverifyTraveler1Name(), expectedFirstTravellerInfo);
		CommonLib.verifyTravellerDetails(BookingLocators.getverifyTraveler2Name(), expectedSecondTravellerInfo);
		test.log(LogStatus.INFO, "Flights & passenger details verified successfully on PaymentPage");
		Logs.info("Flights & passenger details verified successfully on PaymentPage");
	}

	 @Test(groups= {"regression"},priority=9)
	public void withoutAirBookingForSingleCity_TC_19(Method method) throws Exception {
		ExtentTest test=ExtentTestManager.startTest(method.getName(), "withoutAirBookingForSingleCity_TC_19");
		BookingPageAction.selectWithoutAir();
		test.log(LogStatus.INFO, "Select withOut Air Option on HomePage");
		Logs.info("Select withOut Air Option on HomePage");
		BookingPageAction.fillBasicBookingDetails2("San Francisco (USA)", "5", "1|3");
		test.log(LogStatus.INFO, "User fills all the basic details of journey:Source,Destination & Staying Time");
		Logs.info("User fills all the basic details of journey:Source,Destination & Staying Time");
		BookingPageAction.clickonContinueButton();
		test.log(LogStatus.INFO, "Click on Continue Button");
		Logs.info("Click on Continue Button");
		String Actualresult = BookingPageAction.browseHotelsButton();
		test.log(LogStatus.INFO, "Click on Browse Hotels Button");
		Logs.info("Click on Browse Hotels Button");
		String expectedresult = BookingPageAction.browseSelectHotel();
		test.log(LogStatus.INFO, "Select particular hotel from Hotel Options");
		Logs.info("Select particular hotel from Hotel Options");
		Assert.assertEquals(Actualresult, expectedresult);
		test.log(LogStatus.INFO, "Verify that only particular selected hotel appears along with passenger details");
		Logs.info("Verify that only particular selected hotel appears along with passenger details");
	}

	@Test(groups= {"regression"},priority=10)
	public void getWithoutAir_TC_20(Method method) throws Exception {
		ExtentTest test=ExtentTestManager.startTest(method.getName(), "getWithoutAir");
		BookingPageAction.getWithoutButton();
		test.log(LogStatus.INFO, "Click on WithOut Air Button");
		Logs.info("Click on WithOut Air Button");
		BookingPageAction.fillBasicBookingDetailForMultipleCities("WithOutAir", "Delhi (India)", "4", "Mumbai (India)","1|3");
		test.log(LogStatus.INFO, "Filled all the basic details of journey along with source & destination");
		Logs.info("Filled all the basic details of journey along with source & destination");
		BookingPageAction.clickonContinueButton();
		ActualHotel = BookingPageAction.browseHotelsButton();
		test.log(LogStatus.INFO, "Click on Browse Hotels Button");
		Logs.info("Click on Browse Hotels Button");
		ExpectedHotel = BookingPageAction.browseSelectHotel();
		test.log(LogStatus.INFO, "Select particular hotel from Hotel Options");
		Logs.info("Select particular hotel from Hotel Options");
		Assert.assertEquals(ActualHotel, ExpectedHotel);
		test.log(LogStatus.INFO, "Verify that only particular selected hotel appears along with passenger details");
		Logs.info("Verify that only particular selected hotel appears along with passenger details");
	}

	@Test(groups= {"regression"},priority=11)
	public void removeAddedCity_TC_17(Method method) throws Exception {
		ExtentTest test=ExtentTestManager.startTest(method.getName(), "removeAddedCity");
		BookingPageAction.fillBasicDetails("New York, Newark, NJ", "Delhi (India)", "4", "Mumbai (India)", "1","Chennai -Madras (India)", "1");
		test.log(LogStatus.INFO, "Fill all the basic details for multiple cities");
		test.log(LogStatus.INFO, "Adding multiple cities in destinations");
		Logs.info("Fill all the basic details for multiple cities");
		Logs.info("Adding multiple cities in destinations");
		boolean actual = BookingPageAction.isremovecitydisplayed();
		Assert.assertTrue(actual);
		test.log(LogStatus.INFO,"Verify that multiple cities got selected as destinations");
		test.log(LogStatus.INFO, "Verify that RemoveCity Link is also displayed for added cities");
		Logs.info("Verify that multiple cities got selected as destinations");
		Logs.info("Verify that RemoveCity Link is also displayed for added cities");
		BookingPageAction.deleteAddedCities();
		test.log(LogStatus.INFO, "Delete all the added cities");
		Logs.info("Delete all the added cities");
		BookingPageAction.validateremovedcity();
		test.log(LogStatus.INFO, "All the added cities removed successfully.Verified!");
		Logs.info("All the added cities removed successfully.Verified!");
		BookingPageAction.getNoMoreCitiesButton();
		BookingPageAction.selectGuestDetails("1|1");
		test.log(LogStatus.INFO, "Select Guest Details");
		BookingPageAction.clickonContinueButton();
		BookingPageAction.selectCheaperFlights();
		test.log(LogStatus.INFO, "Select Cheaper flights from flight options");
		Logs.info("Select Cheaper flights from flight options");
		BookingPageAction.validateTripIncluisonPage();
		test.log(LogStatus.INFO, "Validate that user is on TripInclusion Page");
		Logs.info("Validate that user is on TripInclusion Page");
	}

	@Test(groups= {"smoke"},priority=12)
	public void bookingDetailswithPremiumEcomomy_TC_18(Method method) throws Exception {
		ExtentTest test =ExtentTestManager.startTest(method.getName(), "bookingDetailswithPremiumEcomomy");
		BookingPageAction.bookingDetailswithPremiumEcomomy("New York City (all Airports),  NY", "Delhi (India)","Premium Economy", "4", "1|1");
		test.log(LogStatus.INFO, "Filled flights details with premium economy");
		Logs.info("Filled flights details with premium economy");
		String actualcabin = BookingPageAction.selectedcabinAssert();
		test.log(LogStatus.INFO, "Select Cabin class");
		Logs.info("Select Cabin class");
		String expectedcabin = BookingPageAction.verifycabinAssert();
		Assert.assertEquals(expectedcabin, actualcabin);
		test.log(LogStatus.INFO, "Selected Cabin class verified");
		Logs.info("Selected Cabin class verified");
		BookingPageAction.clickonContinueButton();
		BookingPageAction.selectCheaperFlights();
		test.log(LogStatus.INFO, "Select Cheaper flights from flight options");
		Logs.info("Select Cheaper flights from flight options");
		BookingPageAction.clicktoContinuePage();
		test.log(LogStatus.INFO, "bookingDetailswithPremiumEcomomy passed");
		Logs.info("bookingDetailswithPremiumEcomomy passed");
	}

    @Test(groups= {"regression"},priority=13)
	public void verifySpotlightLink_TC_14(Method method) throws Exception {
		ExtentTest test=ExtentTestManager.startTest(method.getName(), "verifySpotlightLink");
		BookingPageAction.selectLatinAmericaLink();
		test.log(LogStatus.INFO, "Select Latin America Link");
		Logs.info("Select Latin America Link");
		BookingPageAction.verifyLatinAmericPage();
		test.log(LogStatus.INFO, "User redirected to the Latin America Page");
		Logs.info("User redirected to the Latin America Page");
		BookingPageAction.clickOnSpotlightOnDrpDwnForMob();
		test.log(LogStatus.INFO, "User clicks on Spotlight button");
		Logs.info("User clicks on Spotlight button");
		BookingPageAction.verifyPageDisplayed();
		test.log(LogStatus.INFO, "Spotlight link verified!");
        Logs.info("Spotlight link verified!");
	}

	
    @Test(groups= {"regression"},priority=14)
	public void dateChanging_TC_9(Method method) throws Exception {
		ExtentTest test=ExtentTestManager.startTest(method.getName(), "verify DateChanging functionality");
		BookingPageAction.fillBasicBookingDetails("New York, Newark, NJ", "Berlin (Germany)", "12", "1|2");
		test.log(LogStatus.INFO, "Booking details Source & Destination filled successfully ");
		Logs.info("Booking details Source & Destination filled successfully ");
		BookingPageAction.selectNumberOfAdult("2", BookingLocators.getselectAdultDrpdown());
		test.log(LogStatus.INFO, "Select number of Adults");
		Logs.info("Select number of Adults");
		BookingPageAction.clickonContinueButton();
		BookingPageAction.clickChangedArriveDate();
		BookingPageAction.oldArriveDate();
		BookingPageAction.clickonContinueLink();
		BookingPageAction.clicktoContinuePage();
		expectedFirstTravellerInfo = PassengerInfoPageAction.fillFirstTravellerDetails("Morris", "Leo", "Male","01/01/1992", "237|US");
		expectedSecondTravellerInfo = PassengerInfoPageAction.fillSecondTravellerDetails("Shally", "Leo", "Male","01/01/1994", "237|US", "Adult");
		test.log(LogStatus.INFO, "User filled all the passenger details successfully");
		Logs.info("User filled all the passenger details successfully");
		BookingPageAction.clicktoContinuePage();
		CommonLib.verifyTravellerDetails(BookingLocators.getverifyTraveler1Name(), expectedFirstTravellerInfo);
		CommonLib.verifyTravellerDetails(BookingLocators.getverifyTraveler2Name(), expectedSecondTravellerInfo);
		test.log(LogStatus.INFO, "Flights & passenger details verified successfully on PaymentPage");
		Logs.info("Flights & passenger details verified successfully on PaymentPage");
		BookingPageAction.tripSummary();
	}
}
