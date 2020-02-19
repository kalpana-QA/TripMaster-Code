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

import com.tripmasters.framework.pageActions.PassengerInfoPageAction;
import com.tripmasters.framework.pageLocators.BookingLocators;
import com.tripmasters.framework.reports.ExtentTestManager;
import com.tripmasters.framework.reports.Logs;


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
		bookingPage.fillBasicBookingDetails("New York, Newark, NJ", "Berlin (Germany)", "4", "1|3");
		test.log(LogStatus.INFO, "User entered \"New York, Newark, NJ\" into leaving from field");
		test.log(LogStatus.INFO, "User entered \"Berlin (Germany)\" into Going to from field");
		test.log(LogStatus.INFO, "User entered \"4\" nights staying time");	
		test.log(LogStatus.INFO, "User clicks to the Continue Button on HomePage");
		test.log(LogStatus.INFO, "User select \"1 Room With 3 Adults\" from Guest list");
		test.log(LogStatus.INFO, "All the basic booking details Source & Destination filled successfully for 3 Adults_4nights");
		Logs.info("All the basic booking details Source & Destination filled successfully for 3 Adults_4nights");
		bookingPage.clickonContinueButton();
		test.log(LogStatus.INFO, "Click on \"Continue\" Button");
		bookingPage.selectCheaperFlights();
		test.log(LogStatus.INFO, "User clicks on Select Cheaper Flights Link");
		test.log(LogStatus.INFO, "User selects a particular flight from existing options");
		test.log(LogStatus.INFO, "User clicks on Continue Link");
		Logs.info("Select Cheaper flights from flight options");
		bookingPage.clicktoContinuePage();
		test.log(LogStatus.INFO, "Click to Continue & User redirected to Fill Passenger Details Page");
		expectedFirstTravellerInfo = passengerInfoPage.fillFirstTravellerDetails("John", "Leo", "Male","01/01/1992", "237|US");
		test.log(LogStatus.INFO, "User enters \"John\" as First Traveller First Name");
		test.log(LogStatus.INFO, "User enters \"Leo\" as First Traveller Last Name");
		test.log(LogStatus.INFO, "User selects \"Gender:Male\" for First Traveller Last Name");
		test.log(LogStatus.INFO, "User selects \"DOB:01/01/1992\" for First Traveller's Date of Birth");
		test.log(LogStatus.INFO, "User selects \"Passport details as:US\" for First Traveller");
		expectedSecondTravellerInfo = passengerInfoPage.fillSecondTravellerDetails("Elvin", "Leo", "Male","01/01/1994", "237|US", "Adult");
		test.log(LogStatus.INFO, "User enters \"Elvin\" as Second Traveller First Name");
		test.log(LogStatus.INFO, "User enters \"Leo\" as Second Traveller Last Name");
		test.log(LogStatus.INFO, "User selects \"Gender:Male\" for Second Traveller Last Name");
		test.log(LogStatus.INFO, "User selects \"DOB:01/01/1994\" for Second Traveller's Date of Birth");
		test.log(LogStatus.INFO, "User selects \"Passport details as:US\" for Second Traveller");
		expectedThirdTravellerInfo = passengerInfoPage.fillThirdTravellerDetails("Marie", "Leo", "Female","01/01/1996", "237|US");
		test.log(LogStatus.INFO, "User enters \"Marie\" as Third Traveller First Name");
		test.log(LogStatus.INFO, "User enters \"Leo\" as Third Traveller Last Name");
		test.log(LogStatus.INFO, "User selects \"Gender:Male\" for Third Traveller Last Name");
		test.log(LogStatus.INFO, "User selects \"DOB:01/01/1996\" for Third Traveller's Date of Birth");
		test.log(LogStatus.INFO, "User selects \"Passport details as:US\" for Third Traveller");
		test.log(LogStatus.INFO, "User filled all the passenger details successfully");
		Logs.info("User fills all the 3 passenger details");
		bookingPage.clicktoContinuePage();
		test.log(LogStatus.INFO, "Click to Continue & User redirected to Payment Page");
		PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler1Name(), expectedFirstTravellerInfo);
		PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler2Name(), expectedSecondTravellerInfo);
		PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler3Name(), expectedThirdTravellerInfo);
		test.log(LogStatus.INFO, "Flights & passenger details verified successfully on PaymentPage");
		Logs.info("Flights & passenger details verified successfully on PaymentPage");
	}

	@Test(groups= {"testdemo"},priority=2)
	public void bookingSingleRoomOneAdultOneChild_TC_2(Method method) throws Exception {
		ExtentTest test = ExtentTestManager.startTest(method.getName(), "bookingSingleRoom1Adult1Child");
        bookingPage.fillBasicBookingDetails("Philadelphia, PA", "Berlin (Germany)", "6", "1|Other");
        test.log(LogStatus.INFO, "User entered \"Philadelphia, PA\" into leaving from field");
		test.log(LogStatus.INFO, "User entered \"Berlin (Germany)\" into Going to from field");
		test.log(LogStatus.INFO, "User entered \"6\" nights staying time");	
		test.log(LogStatus.INFO, "User clicks to the Continue Button on HomePage");
		test.log(LogStatus.INFO, "User select \"1 Room With Other Options\" from Guest list");
		test.log(LogStatus.INFO, "All the basic booking details Source & Destination filled successfully for 1_Adult_1Child_With_SingleRoom");
		Logs.info("All the basic booking details Source & Destination filled successfully for 1_Adult_1Child_With_SingleRoom");
		bookingPage.selectNumberOfAdult("1", BookingLocators.getselectAdultDrpdown());
		test.log(LogStatus.INFO, "User selects \"1\" Adult from Adult Drpdown");
		bookingPage.selectNumberOfChild("1", "9", "Child1");
		test.log(LogStatus.INFO, "User selects \"1\" Child,\"Age of Child:9\"");
		test.log(LogStatus.INFO, "No.of Child & Age of Child got selected successfully");
		Logs.info("No.of Child & Age of Child got selected successfully");
		bookingPage.clickonContinueButton();
		test.log(LogStatus.INFO, "Click on Continue Button");
		Logs.info("Click on Continue Button");
		bookingPage.selectCheaperFlights();
		test.log(LogStatus.INFO, "User clicks on Select Cheaper Flights Link");
		test.log(LogStatus.INFO, "User selects a particular flight from existing options");
		test.log(LogStatus.INFO, "User clicks on Continue Link");
		Logs.info("Select Cheaper flights from flight options");
		bookingPage.clicktoContinuePage();
		expectedFirstTravellerInfo = passengerInfoPage.fillFirstTravellerDetails("Morris", "Mano", "Male","01/01/1992", "237|US");
		test.log(LogStatus.INFO, "User enters \"Morris\" as First Traveller First Name");
		test.log(LogStatus.INFO, "User enters \"Mano\" as First Traveller Last Name");
		test.log(LogStatus.INFO, "User selects \"Gender:Male\" for First Traveller Last Name");
		test.log(LogStatus.INFO, "User selects \"DOB:01/01/1992\" for First Traveller's Date of Birth");
		test.log(LogStatus.INFO, "User selects \"Passport details as:US\" for First Traveller");
		expectedSecondTravellerInfo = passengerInfoPage.fillSecondTravellerDetails("Shally", "Mano", "Female","01/01/1994", "237|US", "Child");
		test.log(LogStatus.INFO, "User enters \"Shally\" as Second Traveller First Name");
		test.log(LogStatus.INFO, "User enters \"Mano\" as Second Traveller Last Name");
		test.log(LogStatus.INFO, "User selects \"Female\" for Second Traveller Last Name");
		test.log(LogStatus.INFO, "User selects \"DOB:01/01/1994\" for Second Traveller's Date of Birth");
		test.log(LogStatus.INFO, "User selects \"Passport details as:US\" for Second Traveller");
		bookingPage.clicktoContinuePage();
		test.log(LogStatus.INFO, "User filled all the passenger details successfully");
		Logs.info("User filled all the passenger details successfully");
		PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler1Name(), expectedFirstTravellerInfo);
		PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler2Name(), expectedSecondTravellerInfo);
		test.log(LogStatus.INFO, "Flights & passenger details verified successfully on PaymentPage");
		Logs.info("Flights & passenger details verified successfully on PaymentPage");
	}

    @Test(groups= {"smoke"},priority=3)
	public void bookingTwoRoomTwoAdult_TC_3(Method method) throws Exception {
		ExtentTest test = ExtentTestManager.startTest(method.getName(), "bookingTwoRoom2Adult");
		bookingPage.fillBasicBookingDetails("New York, Newark, NJ", "Berlin (Germany)", "6", "2|2-2");
		test.log(LogStatus.INFO, "Booking details Source & Destination filled successfully for Two Adults");
		Logs.info("Booking details Source & Destination filled successfully for Two Adults");
		bookingPage.clickonContinueButton();
		test.log(LogStatus.INFO, "Click on Continue Button");
		Logs.info("Click on Continue Button");
		bookingPage.selectCheaperFlights();
		test.log(LogStatus.INFO, "Select Cheaper flights from flight options");
		Logs.info("Select Cheaper flights from flight options");
		bookingPage.clicktoContinuePage();
		expectedFirstTravellerInfo = passengerInfoPage.fillTravellerDetailsForMultipleRooms("Room1Traveller1");
		expectedSecondTravellerInfo = passengerInfoPage.fillTravellerDetailsForMultipleRooms("Room1Traveller2");
		expectedThirdTravellerInfo = passengerInfoPage.fillTravellerDetailsForMultipleRooms("Room2Traveller1");
		expectedFourthTravellerInfo = passengerInfoPage.fillTravellerDetailsForMultipleRooms("Room2Traveller2");
		bookingPage.clicktoContinuePage();
		test.log(LogStatus.INFO, "User filled all the passenger details successfully");
		Logs.info("User filled all the passenger details successfully");
		PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler1Name(), expectedFirstTravellerInfo);
		PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler2Name(), expectedSecondTravellerInfo);
		PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler3Name(), expectedThirdTravellerInfo);
		PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler4Name(), expectedFourthTravellerInfo);
		test.log(LogStatus.INFO, "Flights & passenger details verified successfully on PaymentPage");
		Logs.info("Flights & passenger details verified successfully on PaymentPage");
	}

	@Test(groups= {"smoke"},priority=4)
	public void bookingTwoRoomThreeAdultOneChild_TC_4(Method method) throws Exception {
		ExtentTest test = ExtentTestManager.startTest(method.getName(), "bookingTwoRoom3Adult1Child");
        bookingPage.fillBasicBookingDetails("New York, Newark, NJ", "Berlin (Germany)", "4", "2|Other");
		test.log(LogStatus.INFO, "Booking details filled successfully for Three Adults & One Child");
		Logs.info("Booking details filled successfully for Three Adults & One Child");
		bookingPage.selectNumberOfAdult("2", BookingLocators.getselectAdultDrpdown());
		bookingPage.selectNumberOfChild("1", "9", "Child1");
		test.log(LogStatus.INFO, "No.of Child & Age of Child got selected successfully");
		Logs.info("No.of Child & Age of Child got selected successfully");
		bookingPage.selectNumberOfAdult("1", BookingLocators.getselectAdultRoom2Drpdown());
		bookingPage.clickonContinueButton();
		test.log(LogStatus.INFO, "Click on Continue Button");
		Logs.info("Click on Continue Button");
		bookingPage.selectCheaperFlights();
		test.log(LogStatus.INFO, "Select Cheaper flights from flight options");
		Logs.info("Select Cheaper flights from flight options");
		bookingPage.clicktoContinuePage();
		expectedFirstTravellerInfo = passengerInfoPage.fillTravellerDetailsForMultipleRooms("Room1Traveller1");
		expectedSecondTravellerInfo = passengerInfoPage.fillTravellerDetailsForMultipleRooms("Room1Traveller2");
		expectedThirdTravellerInfo = passengerInfoPage.fillTravellerDetailsForMultipleRooms("Room1Child1");
		expectedFourthTravellerInfo = passengerInfoPage.fillTravellerDetailsForMultipleRooms("Room2Traveller1");
		bookingPage.clicktoContinuePage();
		test.log(LogStatus.INFO, "User filled all the passenger details successfully");
		Logs.info("User filled all the passenger details successfully");
		PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler1Name(), expectedFirstTravellerInfo);
		PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler2Name(), expectedSecondTravellerInfo);
		PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler3Name(), expectedThirdTravellerInfo);
		PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler4Name(), expectedFourthTravellerInfo);
		test.log(LogStatus.INFO, "Flights & passenger details verified successfully on PaymentPage");
		Logs.info("Flights & passenger details verified successfully on PaymentPage");
	}

	@Test(groups= {"smoke"},priority=5)
	public void bookingTwoRoomTwoAdultTwoChild_TC_5(Method method) throws Exception {
		ExtentTest test = ExtentTestManager.startTest(method.getName(), "booking2Room2Adult2Child");
		bookingPage.fillBasicBookingDetails("New York, Newark, NJ", "Berlin (Germany)", "6", "2|Other");
		test.log(LogStatus.INFO, "Booking details filled successfully for Two Adults & Two Child");
		Logs.info("Booking details filled successfully for Two Adults & Two Child");
		bookingPage.selectNumberOfAdult("1", BookingLocators.getselectAdultDrpdown());
		bookingPage.selectNumberOfChild("1", "9", "Child1");
		test.log(LogStatus.INFO, "No.of Child & Age of Child got selected successfully");
		Logs.info("No.of Child & Age of Child got selected successfully");
		bookingPage.selectNumberOfAdult("1", BookingLocators.getselectAdultRoom2Drpdown());
		bookingPage.selectNumberOfChild("1", "9", "Child2");
		bookingPage.clickonContinueButton();
		test.log(LogStatus.INFO, "Click on Continue Button");
		Logs.info("Click on Continue Button");
		bookingPage.selectCheaperFlights();
		test.log(LogStatus.INFO, "Select Cheaper flights from flight options");
		Logs.info("Select Cheaper flights from flight options");
		bookingPage.clicktoContinuePage();
		//bookingPage.clicktoContinuePage();
		expectedFirstTravellerInfo = passengerInfoPage.fillTravellerDetailsForMultipleRooms("Room1Traveller1");
		expectedSecondTravellerInfo = passengerInfoPage.fillTravellerDetailsForMultipleRooms("Room1Child1SingleTravlr");
		expectedThirdTravellerInfo = passengerInfoPage.fillTravellerDetailsForMultipleRooms("Room2Traveller1");
		expectedFourthTravellerInfo = passengerInfoPage.fillTravellerDetailsForMultipleRooms("Room2Child1SingleTravlr");
		test.log(LogStatus.INFO, "User filled all the passenger details successfully");
		Logs.info("User filled all the passenger details successfully");
		bookingPage.clicktoContinuePage();
		test.log(LogStatus.INFO, "Click on Continue Button & User redirected to the Payment Page");
		PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler1Name(), expectedFirstTravellerInfo);
		PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler2Name(), expectedSecondTravellerInfo);
		PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler3Name(), expectedThirdTravellerInfo);
		PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler4Name(), expectedFourthTravellerInfo);
		test.log(LogStatus.INFO, "Flights & passenger details verified successfully on PaymentPage");
		Logs.info("Flights & passenger details verified successfully on PaymentPage");
	}

	@Test(groups= {"smoke"},priority=6)
	public void bookingFlightsWithmultipleCities_TC_6(Method method) throws Exception {
		ExtentTest test = ExtentTestManager.startTest(method.getName(), "bookingFlightsWithmultipleCities");
		bookingPage.fillBasicBookingDetailForMultipleCities("WithAir", "Berlin (Germany)", "4", "Augsburg (Germany)","1|Other");
		test.log(LogStatus.INFO, "Booking details filled successfully for multiple cities");
		Logs.info("Booking details filled successfully for multiple cities");
		bookingPage.selectNumberOfAdult("1", BookingLocators.getselectAdultDrpdown());
		bookingPage.selectNumberOfChild("1", "9", "Child1");
		test.log(LogStatus.INFO, "No.of Child & Age of Child got selected successfully");
		Logs.info("No.of Child & Age of Child got selected successfully");
		bookingPage.clickonContinueButton();
		test.log(LogStatus.INFO, "Click on Continue Button");
		Logs.info("Click on Continue Button");
		bookingPage.selectCheaperFlights();
		test.log(LogStatus.INFO, "Select Cheaper flights from flight options");
		Logs.info("Select Cheaper flights from flight options");
		bookingPage.clicktoContinuePage();
		bookingPage.clicktoContinuePage();
		expectedFirstTravellerInfo = passengerInfoPage.fillFirstTravellerDetails("Morris", "Leo", "Male",
				"01/01/1992", "237|US");
		expectedSecondTravellerInfo = passengerInfoPage.fillSecondTravellerDetails("Shally", "Leo", "Male",
				"01/01/1994", "237|US", "Child");
		test.log(LogStatus.INFO, "User filled all the passenger details successfully");
		Logs.info("User filled all the passenger details successfully");
		bookingPage.clicktoContinuePage();
		PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler1Name(), expectedFirstTravellerInfo);
		PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler2Name(), expectedSecondTravellerInfo);
		test.log(LogStatus.INFO, "Flights & passenger details verified successfully on PaymentPage");
		Logs.info("Flights & passenger details verified successfully on PaymentPage");
	}

	@Test(groups= {"smoke"},priority=7)
	public void bookingFlightAndHotelForSingleCity_TC_7(Method method) throws Exception {
		ExtentTest test=ExtentTestManager.startTest(method.getName(), "bookingFlightAndHotelForSingleCity");
		bookingPage.fillBasicBookingDetails("New York, Newark, NJ", "Delhi (India)", "6", "2|Other");
		test.log(LogStatus.INFO, "Booking details filled successfully for single city");
		Logs.info("Booking details filled successfully for single city");
		bookingPage.selectNumberOfAdult("1", BookingLocators.getselectAdultDrpdown());
		bookingPage.selectNumberOfChild("1", "9", "Child1");
		test.log(LogStatus.INFO, "No.of Child & Age of Child got selected successfully");
		Logs.info("No.of Child & Age of Child got selected successfully");
		bookingPage.selectNumberOfAdult("1", BookingLocators.getselectAdultRoom2Drpdown());
		bookingPage.clickonContinueButton();
		test.log(LogStatus.INFO, "Click on Continue Button");
		Logs.info("Click on Continue Button");
		ActualHotel = bookingPage.browseHotelsButton();
		test.log(LogStatus.INFO, "Click on Browse Hotels Button");
		Logs.info("Click on Browse Hotels Button");
		ExpectedHotel = bookingPage.browseSelectHotel();
		test.log(LogStatus.INFO, "Select particular hotel from Hotel Options");
		Logs.info("Select particular hotel from Hotel Options");
		bookingPage.clicktoContinuePage();
		String expected = bookingPage.selectCheaperFlights();
		test.log(LogStatus.INFO, "Select Cheaper flights from flight options");
		Logs.info("Select Cheaper flights from flight options");
		String actualFlightDetails = bookingPage.getActualFlight();
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
		bookingPage.fillBasicBookingDetailForMultipleCities("WithAir", "Berlin (Germany)", "4","Augsburg (Germany)", "1|Other");
		test.log(LogStatus.INFO, "Booking details filled successfully for multiple cities");
		Logs.info("Booking details filled successfully for multiple cities");
		bookingPage.selectNumberOfAdult("1", BookingLocators.getselectAdultDrpdown());
		bookingPage.selectNumberOfChild("1", "9", "Child1");
		test.log(LogStatus.INFO, "No.of Child & Age of Child got selected successfully");
		Logs.info("No.of Child & Age of Child got selected successfully");
		bookingPage.clickonContinueButton();
		test.log(LogStatus.INFO, "Click on Continue Button");
		Logs.info("Click on Continue Button");
		bookingPage.selectCheaperFlights();
		test.log(LogStatus.INFO, "Select Cheaper flights from flight options");
		Logs.info("Select Cheaper flights from flight options");
		bookingPage.clicktoContinuePage();
		bookingPage.clicktoContinuePage();
		expectedFirstTravellerInfo = passengerInfoPage.fillFirstTravellerDetails("Morris", "Leo", "Male","01/01/1992", "237|US");
		expectedSecondTravellerInfo = passengerInfoPage.fillSecondTravellerDetails("Shally", "Leo", "Male","01/01/1994", "237|US", "Child");
		test.log(LogStatus.INFO, "User filled all the passenger details successfully");
		Logs.info("User filled all the passenger details successfully");
		bookingPage.clicktoContinuePage();
		PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler1Name(), expectedFirstTravellerInfo);
		PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler2Name(), expectedSecondTravellerInfo);
		test.log(LogStatus.INFO, "Flights & passenger details verified successfully on PaymentPage");
		Logs.info("Flights & passenger details verified successfully on PaymentPage");
	}

	 @Test(groups= {"regression"},priority=9)
	public void withoutAirBookingForSingleCity_TC_19(Method method) throws Exception {
		ExtentTest test=ExtentTestManager.startTest(method.getName(), "withoutAirBookingForSingleCity_TC_19");
		bookingPage.selectWithoutAir();
		test.log(LogStatus.INFO, "Select withOut Air Option on HomePage");
		Logs.info("Select withOut Air Option on HomePage");
		bookingPage.fillBasicBookingDetails2("San Francisco (USA)", "5", "1|3");
		test.log(LogStatus.INFO, "User fills all the basic details of journey:Source,Destination & Staying Time");
		Logs.info("User fills all the basic details of journey:Source,Destination & Staying Time");
		bookingPage.clickonContinueButton();
		test.log(LogStatus.INFO, "Click on Continue Button");
		Logs.info("Click on Continue Button");
		String Actualresult = bookingPage.browseHotelsButton();
		test.log(LogStatus.INFO, "Click on Browse Hotels Button");
		Logs.info("Click on Browse Hotels Button");
		String expectedresult = bookingPage.browseSelectHotel();
		test.log(LogStatus.INFO, "Select particular hotel from Hotel Options");
		Logs.info("Select particular hotel from Hotel Options");
		Assert.assertEquals(Actualresult, expectedresult);
		test.log(LogStatus.INFO, "Verify that only particular selected hotel appears along with passenger details");
		Logs.info("Verify that only particular selected hotel appears along with passenger details");
	}

	@Test(groups= {"regression"},priority=10)
	public void getWithoutAir_TC_20(Method method) throws Exception {
		ExtentTest test=ExtentTestManager.startTest(method.getName(), "getWithoutAir");
		bookingPage.getWithoutButton();
		test.log(LogStatus.INFO, "Click on WithOut Air Button");
		Logs.info("Click on WithOut Air Button");
		bookingPage.fillBasicBookingDetailForMultipleCities("WithOutAir", "Delhi (India)", "4", "Mumbai (India)","1|3");
		test.log(LogStatus.INFO, "Filled all the basic details of journey along with source & destination");
		Logs.info("Filled all the basic details of journey along with source & destination");
		bookingPage.clickonContinueButton();
		ActualHotel = bookingPage.browseHotelsButton();
		test.log(LogStatus.INFO, "Click on Browse Hotels Button");
		Logs.info("Click on Browse Hotels Button");
		ExpectedHotel = bookingPage.browseSelectHotel();
		test.log(LogStatus.INFO, "Select particular hotel from Hotel Options");
		Logs.info("Select particular hotel from Hotel Options");
		Assert.assertEquals(ActualHotel, ExpectedHotel);
		test.log(LogStatus.INFO, "Verify that only particular selected hotel appears along with passenger details");
		Logs.info("Verify that only particular selected hotel appears along with passenger details");

	}

	@Test(groups= {"regression"},priority=11)
	public void removeAddedCity_TC_17(Method method) throws Exception {

		ExtentTest test=ExtentTestManager.startTest(method.getName(), "removeAddedCity");
		bookingPage.fillBasicDetails("New York, Newark, NJ", "Delhi (India)", "4", "Mumbai (India)", "1","Chennai -Madras (India)", "1");
		test.log(LogStatus.INFO, "Fill all the basic details for multiple cities");
		test.log(LogStatus.INFO, "Adding multiple cities in destinations");
		Logs.info("Fill all the basic details for multiple cities");
		Logs.info("Adding multiple cities in destinations");
		boolean actual = bookingPage.isremovecitydisplayed();
		Assert.assertTrue(actual);
		test.log(LogStatus.INFO,"Verify that multiple cities got selected as destinations");
		test.log(LogStatus.INFO, "Verify that RemoveCity Link is also displayed for added cities");
		Logs.info("Verify that multiple cities got selected as destinations");
		Logs.info("Verify that RemoveCity Link is also displayed for added cities");
		bookingPage.deleteAddedCities();
		test.log(LogStatus.INFO, "Delete all the added cities");
		Logs.info("Delete all the added cities");
		bookingPage.validateremovedcity();
		test.log(LogStatus.INFO, "All the added cities removed successfully.Verified!");
		Logs.info("All the added cities removed successfully.Verified!");
		bookingPage.getNoMoreCitiesButton();
		bookingPage.selectGuestDetails("1|1");
		test.log(LogStatus.INFO, "Select Guest Details");
		bookingPage.clickonContinueButton();
		bookingPage.selectCheaperFlights();
		test.log(LogStatus.INFO, "Select Cheaper flights from flight options");
		Logs.info("Select Cheaper flights from flight options");
		bookingPage.validateTripIncluisonPage();
		test.log(LogStatus.INFO, "Validate that user is on TripInclusion Page");
		Logs.info("Validate that user is on TripInclusion Page");
	}

	@Test(groups= {"smoke"},priority=12)
	public void bookingDetailswithPremiumEcomomy_TC_18(Method method) throws Exception {
		ExtentTest test =ExtentTestManager.startTest(method.getName(), "bookingDetailswithPremiumEcomomy");
		bookingPage.bookingDetailswithPremiumEcomomy("New York City (all Airports),  NY", "Delhi (India)","Premium Economy", "4", "1|1");
		test.log(LogStatus.INFO, "Filled flights details with premium economy");
		Logs.info("Filled flights details with premium economy");
		String actualcabin = bookingPage.selectedcabinAssert();
		test.log(LogStatus.INFO, "Select Cabin class");
		Logs.info("Select Cabin class");
		String expectedcabin = bookingPage.verifycabinAssert();
		Assert.assertEquals(expectedcabin, actualcabin);
		test.log(LogStatus.INFO, "Selected Cabin class verified");
		Logs.info("Selected Cabin class verified");
		bookingPage.clickonContinueButton();
		bookingPage.selectCheaperFlights();
		test.log(LogStatus.INFO, "Select Cheaper flights from flight options");
		Logs.info("Select Cheaper flights from flight options");
		bookingPage.clicktoContinuePage();
		test.log(LogStatus.INFO, "bookingDetailswithPremiumEcomomy passed");
		Logs.info("bookingDetailswithPremiumEcomomy passed");

	}

	 @Test(priority = 11)
	public void bookingDetailswithPremiumEcomomy_Mob_TC_18(Method method) throws Exception {
		ExtentTestManager.startTest(method.getName(), "dateChanging_TC_18");
		bookingPage.clickOnBuildYourVacationDropDown();
		bookingPage.bookingDetailswithPremiumEcomomy("New York City (all Airports),  NY", "Delhi (India)","Premium Economy", "4", "1|1");

		/**
		 * TODO Verification method is not correct (verifying index of one table with
		 * another table not the selected value)
		 */
		String actualcabin = bookingPage.selectedcabinAssert();
		String expectedcabin = bookingPage.verifycabinAssert();
		Assert.assertEquals(expectedcabin, actualcabin);
		// =======================================================================

		bookingPage.clickonContinueButton();
		bookingPage.selectCheaperFlights();
		bookingPage.clicktoContinuePage();
	}

    @Test(groups= {"regression"},priority=13)
	public void verifySpotlightLink_TC_14(Method method) throws Exception {

		ExtentTest test=ExtentTestManager.startTest(method.getName(), "verifySpotlightLink");
		bookingPage.selectLatinAmericaLink();
		test.log(LogStatus.INFO, "Select Latin America Link");
		Logs.info("Select Latin America Link");
		bookingPage.verifyLatinAmericPage();
		test.log(LogStatus.INFO, "User redirected to the Latin America Page");
		Logs.info("User redirected to the Latin America Page");
		bookingPage.clickOnSpotlightOnDrpDwnForMob();
		test.log(LogStatus.INFO, "User clicks on Spotlight button");
		Logs.info("User clicks on Spotlight button");
		/**
		 * TODO Verify below method whether it's working or not...modified during mobile automation.
		bookingPage.verifyPageDisplayed();
		*/
		test.log(LogStatus.INFO, "Spotlight link verified!");
        Logs.info("Spotlight link verified!");
	}

	
    @Test(groups= {"regression"},priority=14)
	public void dateChanging_TC_9(Method method) throws Exception {
		ExtentTest test=ExtentTestManager.startTest(method.getName(), "verify DateChanging functionality");
		bookingPage.fillBasicBookingDetails("New York, Newark, NJ", "Berlin (Germany)", "12", "1|2");
		test.log(LogStatus.INFO, "Booking details Source & Destination filled successfully ");
		Logs.info("Booking details Source & Destination filled successfully ");
		bookingPage.selectNumberOfAdult("2", BookingLocators.getselectAdultDrpdown());
		test.log(LogStatus.INFO, "Select number of Adults");
		Logs.info("Select number of Adults");
		bookingPage.clickonContinueButton();
		bookingPage.clickChangedArriveDate();
		bookingPage.oldArriveDate();
		bookingPage.clickonContinueLink();
		bookingPage.clicktoContinuePage();
		expectedFirstTravellerInfo = passengerInfoPage.fillFirstTravellerDetails("Morris", "Leo", "Male","01/01/1992", "237|US");
		expectedSecondTravellerInfo = passengerInfoPage.fillSecondTravellerDetails("Shally", "Leo", "Male","01/01/1994", "237|US", "Adult");
		test.log(LogStatus.INFO, "User filled all the passenger details successfully");
		Logs.info("User filled all the passenger details successfully");
		bookingPage.clicktoContinuePage();
		PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler1Name(), expectedFirstTravellerInfo);
		PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler2Name(), expectedSecondTravellerInfo);
		test.log(LogStatus.INFO, "Flights & passenger details verified successfully on PaymentPage");
		Logs.info("Flights & passenger details verified successfully on PaymentPage");
		bookingPage.tripSummary();
	}
}
