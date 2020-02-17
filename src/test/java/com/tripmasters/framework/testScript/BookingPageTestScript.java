package com.tripmasters.framework.testScript;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.tripmasters.framework.base.TestBase;
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

	// @Test(groups = { "smoke" }, priority = 1)
	public void bookingSingleRoomWithThreeAdults_TC_1(Method method) throws Exception {
		ExtentTest test = ExtentTestManager.startTest(method.getName(), "bookingSingleRoomWith3Adults");
		bookingPage.FillBasicBookingDetails("New York  La Guardia, NY", "Berlin (Germany)", "4", "1|3");
		test.log(LogStatus.INFO, "Booking details Source & Destination filled successfully for 3 Adults_4nights");
		Logs.info("Booking details Source & Destination filled successfully for 3 Adults_4nights");
		bookingPage.ClickonContinueButton();
		test.log(LogStatus.INFO, "Click on Continue Button");
		bookingPage.SelectCheaperFlights();
		test.log(LogStatus.INFO, "Select Cheaper flights from flight options");
		bookingPage.ClicktoContinuePage();
		expectedFirstTravellerInfo = passengerInfoPage.FillFirstTravellerDetails("John", "Leo", "Male", "01/01/1992",
				"237|US");
		expectedSecondTravellerInfo = passengerInfoPage.FillSecondTravellerDetails("Elvin", "Leo", "Male", "01/01/1994",
				"237|US", "Adult");
		expectedThirdTravellerInfo = passengerInfoPage.FillThirdTravellerDetails("Marie", "Leo", "Female", "01/01/1996",
				"237|US");
		test.log(LogStatus.INFO, "User filled all the passenger details successfully");
		Logs.info("User fills all the 3 passenger details");
		bookingPage.ClicktoContinuePage();
		bookingPage.VerifyTravellerDetails(BookingLocators.getverifyTraveler1Name(), expectedFirstTravellerInfo);
		bookingPage.VerifyTravellerDetails(BookingLocators.getverifyTraveler2Name(), expectedSecondTravellerInfo);
		bookingPage.VerifyTravellerDetails(BookingLocators.getverifyTraveler3Name(), expectedThirdTravellerInfo);
		test.log(LogStatus.INFO, "Flights & passenger details verified successfully on PaymentPage");
		Logs.info("Flights & passenger details verified successfully on PaymentPage");
	}

	// @Test(groups= {"smoke"},priority=2)
	public void bookingSingleRoomOneAdultOneChild_TC_2(Method method) throws Exception {
		ExtentTest test = ExtentTestManager.startTest(method.getName(), "bookingSingleRoom1Adult1Child");
		bookingPage.FillBasicBookingDetails("San Jose, CALIFORNIA", "Osaka (Japan)", "4", "1|Other");
		test.log(LogStatus.INFO,
				"Booking details Source & Destination filled successfully for 1 Adults_1Child_4nights");
		Logs.info("Booking details Source & Destination filled successfully for 1 Adults_1Child_4nights");
		bookingPage.SelectNumberOfAdult("1", BookingLocators.getselectAdultDrpdown());
		bookingPage.SelectNumberOfChild("1", "9", "Child1");
		test.log(LogStatus.INFO, "No.of Child & Age of Child got selected successfully");
		Logs.info("No.of Child & Age of Child got selected successfully");
		bookingPage.ClickonContinueButton();
		test.log(LogStatus.INFO, "Click on Continue Button");
		Logs.info("Click on Continue Button");
		bookingPage.SelectCheaperFlights();
		test.log(LogStatus.INFO, "Select Cheaper flights from flight options");
		Logs.info("Select Cheaper flights from flight options");
		bookingPage.ClicktoContinuePage();
		expectedFirstTravellerInfo = passengerInfoPage.FillFirstTravellerDetails("Morris", "Leo", "Male", "01/01/1992",
				"237|US");
		expectedSecondTravellerInfo = passengerInfoPage.FillSecondTravellerDetails("Shally", "Leo", "Male",
				"01/01/1994", "237|US", "Child");
		bookingPage.ClicktoContinuePage();
		test.log(LogStatus.INFO, "User filled all the passenger details successfully");
		Logs.info("User filled all the passenger details successfully");
		bookingPage.VerifyTravellerDetails(BookingLocators.getverifyTraveler1Name(), expectedFirstTravellerInfo);
		bookingPage.VerifyTravellerDetails(BookingLocators.getverifyTraveler2Name(), expectedSecondTravellerInfo);
		test.log(LogStatus.INFO, "Flights & passenger details verified successfully on PaymentPage");
		Logs.info("Flights & passenger details verified successfully on PaymentPage");
	}

	// @Test(groups= {"smoke"},priority=3)
	public void bookingTwoRoomTwoAdult_TC_3(Method method) throws Exception {
		ExtentTest test = ExtentTestManager.startTest(method.getName(), "bookingTwoRoom2Adult");
		bookingPage.FillBasicBookingDetails("New York, Newark, NJ", "Berlin (Germany)", "6", "2|2-2");
		test.log(LogStatus.INFO, "Booking details Source & Destination filled successfully for Two Adults");
		Logs.info("Booking details Source & Destination filled successfully for Two Adults");
		bookingPage.ClickonContinueButton();
		test.log(LogStatus.INFO, "Click on Continue Button");
		Logs.info("Click on Continue Button");
		bookingPage.SelectCheaperFlights();
		test.log(LogStatus.INFO, "Select Cheaper flights from flight options");
		Logs.info("Select Cheaper flights from flight options");
		bookingPage.ClicktoContinuePage();
		expectedFirstTravellerInfo = passengerInfoPage.FillTravellerDetailsForMultipleRooms("Room1Traveller1");
		expectedSecondTravellerInfo = passengerInfoPage.FillTravellerDetailsForMultipleRooms("Room1Traveller2");
		expectedThirdTravellerInfo = passengerInfoPage.FillTravellerDetailsForMultipleRooms("Room2Traveller1");
		expectedFourthTravellerInfo = passengerInfoPage.FillTravellerDetailsForMultipleRooms("Room2Traveller2");
		bookingPage.ClicktoContinuePage();
		test.log(LogStatus.INFO, "User filled all the passenger details successfully");
		Logs.info("User filled all the passenger details successfully");
		bookingPage.VerifyTravellerDetails(BookingLocators.getverifyTraveler1Name(), expectedFirstTravellerInfo);
		bookingPage.VerifyTravellerDetails(BookingLocators.getverifyTraveler2Name(), expectedSecondTravellerInfo);
		bookingPage.VerifyTravellerDetails(BookingLocators.getverifyTraveler3Name(), expectedThirdTravellerInfo);
		bookingPage.VerifyTravellerDetails(BookingLocators.getverifyTraveler4Name(), expectedFourthTravellerInfo);
		test.log(LogStatus.INFO, "Flights & passenger details verified successfully on PaymentPage");
		Logs.info("Flights & passenger details verified successfully on PaymentPage");
	}

	// @Test(groups= {"smoke"},priority=4)
	public void bookingTwoRoomThreeAdultOneChild_TC_4(Method method) throws Exception {
		ExtentTest test = ExtentTestManager.startTest(method.getName(), "bookingTwoRoom3Adult1Child");
		bookingPage.FillBasicBookingDetails("New York, Newark, NJ", "Berlin (Germany)", "4", "2|Other");
		test.log(LogStatus.INFO, "Booking details filled successfully for Three Adults & One Child");
		Logs.info("Booking details filled successfully for Three Adults & One Child");
		bookingPage.SelectNumberOfAdult("2", BookingLocators.getselectAdultDrpdown());
		bookingPage.SelectNumberOfChild("1", "9", "Child1");
		test.log(LogStatus.INFO, "No.of Child & Age of Child got selected successfully");
		Logs.info("No.of Child & Age of Child got selected successfully");
		bookingPage.SelectNumberOfAdult("1", BookingLocators.getselectAdultRoom2Drpdown());
		bookingPage.ClickonContinueButton();
		test.log(LogStatus.INFO, "Click on Continue Button");
		Logs.info("Click on Continue Button");
		bookingPage.SelectCheaperFlights();
		test.log(LogStatus.INFO, "Select Cheaper flights from flight options");
		Logs.info("Select Cheaper flights from flight options");
		bookingPage.ClicktoContinuePage();
		expectedFirstTravellerInfo = passengerInfoPage.FillTravellerDetailsForMultipleRooms("Room1Traveller1");
		expectedSecondTravellerInfo = passengerInfoPage.FillTravellerDetailsForMultipleRooms("Room1Traveller2");
		// expectedThirdTravellerInfo=passengerInfoPage.FillSecondTravellerDetails("Shally","Leo","Male","01/01/1994","237|US","Child");
		expectedThirdTravellerInfo = passengerInfoPage.FillTravellerDetailsForMultipleRooms("Room1Child1");
		expectedFourthTravellerInfo = passengerInfoPage.FillTravellerDetailsForMultipleRooms("Room2Traveller1");
		bookingPage.ClicktoContinuePage();
		test.log(LogStatus.INFO, "User filled all the passenger details successfully");
		Logs.info("User filled all the passenger details successfully");
		bookingPage.VerifyTravellerDetails(BookingLocators.getverifyTraveler1Name(), expectedFirstTravellerInfo);
		bookingPage.VerifyTravellerDetails(BookingLocators.getverifyTraveler2Name(), expectedSecondTravellerInfo);
		bookingPage.VerifyTravellerDetails(BookingLocators.getverifyTraveler3Name(), expectedThirdTravellerInfo);
		bookingPage.VerifyTravellerDetails(BookingLocators.getverifyTraveler4Name(), expectedFourthTravellerInfo);
		test.log(LogStatus.INFO, "Flights & passenger details verified successfully on PaymentPage");
		Logs.info("Flights & passenger details verified successfully on PaymentPage");
	}

	// @Test(groups= {"smoke"},priority=5)
	public void bookingTwoRoomTwoAdultTwoChild_TC_5(Method method) throws Exception {
		ExtentTest test = ExtentTestManager.startTest(method.getName(), "booking2Room2Adult2Child");
		bookingPage.FillBasicBookingDetails("New York, Newark, NJ", "Berlin (Germany)", "6", "2|Other");
		test.log(LogStatus.INFO, "Booking details filled successfully for Two Adults & Two Child");
		Logs.info("Booking details filled successfully for Two Adults & Two Child");
		bookingPage.SelectNumberOfAdult("1", BookingLocators.getselectAdultDrpdown());
		bookingPage.SelectNumberOfChild("1", "9", "Child1");
		test.log(LogStatus.INFO, "No.of Child & Age of Child got selected successfully");
		Logs.info("No.of Child & Age of Child got selected successfully");
		bookingPage.SelectNumberOfAdult("1", BookingLocators.getselectAdultRoom2Drpdown());
		bookingPage.SelectNumberOfChild("1", "9", "Child2");
		bookingPage.ClickonContinueButton();
		test.log(LogStatus.INFO, "Click on Continue Button");
		Logs.info("Click on Continue Button");
		bookingPage.SelectCheaperFlights();
		test.log(LogStatus.INFO, "Select Cheaper flights from flight options");
		Logs.info("Select Cheaper flights from flight options");
		bookingPage.ClicktoContinuePage();
		bookingPage.ClicktoContinuePage();
		expectedFirstTravellerInfo = passengerInfoPage.FillTravellerDetailsForMultipleRooms("Room1Traveller1");
		expectedSecondTravellerInfo = passengerInfoPage.FillTravellerDetailsForMultipleRooms("Room1Child1");
		expectedThirdTravellerInfo = passengerInfoPage.FillTravellerDetailsForMultipleRooms("Room2Traveller1");
		expectedFourthTravellerInfo = passengerInfoPage.FillTravellerDetailsForMultipleRooms("Room2Child1");
		test.log(LogStatus.INFO, "User filled all the passenger details successfully");
		Logs.info("User filled all the passenger details successfully");
		bookingPage.ClicktoContinuePage();
		test.log(LogStatus.INFO, "Click on Continue Button & User redirected to the Payment Page");
		bookingPage.VerifyTravellerDetails(BookingLocators.getverifyTraveler1Name(), expectedFirstTravellerInfo);
		bookingPage.VerifyTravellerDetails(BookingLocators.getverifyTraveler2Name(), expectedSecondTravellerInfo);
		bookingPage.VerifyTravellerDetails(BookingLocators.getverifyTraveler3Name(), expectedThirdTravellerInfo);
		bookingPage.VerifyTravellerDetails(BookingLocators.getverifyTraveler4Name(), expectedFourthTravellerInfo);
		test.log(LogStatus.INFO, "Flights & passenger details verified successfully on PaymentPage");
		Logs.info("Flights & passenger details verified successfully on PaymentPage");
	}

	// @Test(groups= {"smoke"},priority=6)
	public void bookingFlightsWithmultipleCities_TC_6(Method method) throws Exception {
		ExtentTest test = ExtentTestManager.startTest(method.getName(), "bookingFlightsWithmultipleCities");
		bookingPage.fillBasicBookingDetailForMultipleCities("WithAir", "Berlin (Germany)", "4", "Augsburg (Germany)",
				"1|Other");
		test.log(LogStatus.INFO, "Booking details filled successfully for multiple cities");
		Logs.info("Booking details filled successfully for multiple cities");
		bookingPage.SelectNumberOfAdult("1", BookingLocators.getselectAdultDrpdown());
		bookingPage.SelectNumberOfChild("1", "9", "Child1");
		test.log(LogStatus.INFO, "No.of Child & Age of Child got selected successfully");
		Logs.info("No.of Child & Age of Child got selected successfully");
		bookingPage.ClickonContinueButton();
		test.log(LogStatus.INFO, "Click on Continue Button");
		Logs.info("Click on Continue Button");
		bookingPage.SelectCheaperFlights();
		test.log(LogStatus.INFO, "Select Cheaper flights from flight options");
		Logs.info("Select Cheaper flights from flight options");
		bookingPage.ClicktoContinuePage();
		bookingPage.ClicktoContinuePage();
		expectedFirstTravellerInfo = passengerInfoPage.FillFirstTravellerDetails("Morris", "Leo", "Male", "01/01/1992",
				"237|US");
		expectedSecondTravellerInfo = passengerInfoPage.FillSecondTravellerDetails("Shally", "Leo", "Male",
				"01/01/1994", "237|US", "Child");
		bookingPage.ClicktoContinuePage();
		bookingPage.VerifyTravellerDetails(BookingLocators.getverifyTraveler1Name(), expectedFirstTravellerInfo);
		bookingPage.VerifyTravellerDetails(BookingLocators.getverifyTraveler2Name(), expectedSecondTravellerInfo);
		test.log(LogStatus.INFO, "Flights & passenger details verified successfully on PaymentPage");
		Logs.info("Flights & passenger details verified successfully on PaymentPage");
	}

	// @Test(groups= {"smoke"},priority=7)
	public void bookingFlightAndHotelForSingleCity_TC_7(Method method) throws Exception {
		ExtentTestManager.startTest(method.getName(), "bookingFlightAndHotelForSingleCity");
		bookingPage.FillBasicBookingDetails("New York, Newark, NJ", "Berlin (Germany)", "6", "2|Other");
		bookingPage.SelectNumberOfAdult("1", BookingLocators.getselectAdultDrpdown());
		bookingPage.SelectNumberOfChild("1", "9", "Child1");
		bookingPage.SelectNumberOfAdult("1", BookingLocators.getselectAdultRoom2Drpdown());
		bookingPage.ClickonContinueButton();
		ActualHotel = bookingPage.browseHotelsButton();
		ExpectedHotel = bookingPage.browseSelectHotel();
		bookingPage.getContinueLink();
		String expected = bookingPage.SelectCheaperFlights();
		String actualFlightDetails = bookingPage.GetActualFlight();
		System.out.println(expected);
		System.out.println(actualFlightDetails);
		Assert.assertTrue(expected.contains(actualFlightDetails));
		Assert.assertEquals(ActualHotel, ExpectedHotel);

	}

	// @Test(groups= {"smoke"},priority=8)
	public void bookingFlightAndHotelForMultipleCity_TC_8(Method method) throws Exception {
		ExtentTestManager.startTest(method.getName(), "bookingFlightAndHotelForMultipleCity");
		bookingPage.fillBasicBookingDetailForMultipleCities("WithAir", "Berlin (Germany)", "4", "Augsburg (Germany)",
				"1|Other");
		bookingPage.SelectNumberOfAdult("1", BookingLocators.getselectAdultDrpdown());
		bookingPage.SelectNumberOfChild("1", "9", "Child1");
		bookingPage.ClickonContinueButton();
		bookingPage.SelectCheaperFlights();
		bookingPage.ClicktoContinuePage();
		bookingPage.ClicktoContinuePage();
		expectedFirstTravellerInfo = passengerInfoPage.FillFirstTravellerDetails("Morris", "Leo", "Male", "01/01/1992",
				"237|US");
		expectedSecondTravellerInfo = passengerInfoPage.FillSecondTravellerDetails("Shally", "Leo", "Male",
				"01/01/1994", "237|US", "Child");
		bookingPage.ClicktoContinuePage();
		bookingPage.VerifyTravellerDetails(BookingLocators.getverifyTraveler1Name(), expectedFirstTravellerInfo);
		bookingPage.VerifyTravellerDetails(BookingLocators.getverifyTraveler2Name(), expectedSecondTravellerInfo);

	}

	@Test(groups = { "regression" }, priority = 9)
	public void withoutAirBookingForSingleCity_TC_19(Method method) throws Exception {
		ExtentTestManager.startTest(method.getName(), "withoutAirBookingForSingleCity_TC_19");
		bookingPage.SelectWithoutAir();
		bookingPage.FillBasicBookingDetails2("San Francisco (USA)", "5", "1|3");
		bookingPage.ClickonContinueButton();
		String Actualresult = bookingPage.browseHotelsButton();
		String expectedresult = bookingPage.browseSelectHotel();
		Assert.assertEquals(Actualresult, expectedresult);
		bookingPage.ClickonContinueLink();

	}

	// @Test(groups= {"regression"},priority=10)
	public void getWithoutAir_TC_20(Method method) throws Exception {
		ExtentTestManager.startTest(method.getName(), "getWithoutAir");
		bookingPage.getWithoutButton();
		bookingPage.fillBasicBookingDetailForMultipleCities("WithOutAir", "Delhi (India)", "4", "Mumbai (India)",
				"1|3");
		bookingPage.ClickonContinueButton();
		ActualHotel = bookingPage.browseHotelsButton();
		ExpectedHotel = bookingPage.browseSelectHotel();
		Assert.assertEquals(ActualHotel, ExpectedHotel);
		bookingPage.getContinueLink();
		System.out.println("passed");
	}

	// @Test(groups= {"regression"},priority=11)
	public void removeAddedCity_TC_17(Method method) throws Exception {
		bookingPage.fillBasicDetails("New York, Newark, NJ", "Delhi (India)", "4", "Mumbai (India)", "1",
				"Chennai -Madras (India)", "1");
		boolean actual = bookingPage.isremovecitydisplayed();
		Assert.assertTrue(actual);
		bookingPage.deleteAddedCities();
		bookingPage.validateremovedcity();
		bookingPage.getNoMoreCitiesButton();
		bookingPage.SelectGuestDetails("1|1");
		bookingPage.ClickonContinueButton();
		bookingPage.SelectCheaperFlights();
		bookingPage.validateTripIncluisonPage();
	}

	// @Test(groups= {"regression"},priority=12)
	public void verifyCity_TC_10() throws Exception {
		homePage.clickSearch();
		homePage.fillSearch("Berlin");
		boolean actual = homePage.validateURL();
		Assert.assertTrue(actual);
	}

	// @Test(priority = 10)
	public void removeAddedCity_TC_17() throws Exception {
		bookingPage.clickOnBuildYourVacationDropDown();
		bookingPage.fillBasicDetails("New York, Newark, NJ", "Delhi (India)", "4", "Mumbai (India)", "1",
				"Chennai -Madras (India)", "1");
		bookingPage.isremovecitydisplayed();
		bookingPage.deleteAddedCities();
		bookingPage.validateremovedcity();
		bookingPage.getNoMoreCitiesButton();
		bookingPage.SelectGuestDetails("1|1");
		bookingPage.ClickonContinueButton();
		bookingPage.SelectCheaperFlights_Mob();
		bookingPage.validateTripIncluisonPage();
	}

	// @Test(priority = 11)
	public void dateChanging_TC_18(Method method) throws Exception {
		ExtentTestManager.startTest(method.getName(), "dateChanging_TC_18");
		bookingPage.clickOnBuildYourVacationDropDown();
		bookingPage.BookingDetailswithPremiumEcomomy("New York City (all Airports),  NY", "Delhi (India)",
				"Premium Economy", "4", "1|1");

		/**
		 * TODO Verification method is not correct (verifying index of one table with
		 * another table not the selected value)
		 */
		String actualcabin = bookingPage.selectedcabinAssert();
		String expectedcabin = bookingPage.verifycabinAssert();
		Assert.assertEquals(expectedcabin, actualcabin);
		// =======================================================================

		bookingPage.ClickonContinueButton();
		bookingPage.SelectCheaperFlights();
		bookingPage.ClicktoContinuePage();
	}

	// @Test(groups= {"regression"},priority=13)
	public void verifySpotlightLink_TC_14(Method method) throws Exception {
		ExtentTestManager.startTest(method.getName(), "verifySpotlightLink");
		bookingPage.selectLatinAmericaLink();
		bookingPage.verifyLatinAmericPage();
		bookingPage.clickOnSpotlightOnDrpDwnForMob();
		String PageTitle = bookingPage.clickOnFirstOptionUnderSpotlightForMob();
		bookingPage.verifyPageDisplayed(PageTitle.split("\n")[0]);

	}

	// @Test(groups= {"regression"},priority=14)
	public void dateChanging_TC_9() throws Exception {
		bookingPage.FillBasicBookingDetails("New York, Newark, NJ", "Berlin (Germany)", "12", "1|2");
		bookingPage.SelectNumberOfAdult("2", BookingLocators.getselectAdultDrpdown());
		bookingPage.ClickonContinueButton();
		bookingPage.ClickChangedArriveDate();
		bookingPage.OldArriveDate();
		ActualHotel = bookingPage.browseHotelsButton();
		ExpectedHotel = bookingPage.browseSelectHotel();
		Assert.assertEquals(ActualHotel, ExpectedHotel);
		bookingPage.ClickonContinueLink();
		bookingPage.ClicktoContinuePage();
		expectedFirstTravellerInfo = passengerInfoPage.FillFirstTravellerDetails("Morris", "Leo", "Male", "01/01/1992",
				"237|US");
		expectedSecondTravellerInfo = passengerInfoPage.FillSecondTravellerDetails("Shally", "Leo", "Male",
				"01/01/1994", "237|US", "Adult");
		bookingPage.ClicktoContinuePage();
		bookingPage.VerifyTravellerDetails(BookingLocators.getverifyTraveler1Name(), expectedFirstTravellerInfo);
		bookingPage.VerifyTravellerDetails(BookingLocators.getverifyTraveler2Name(), expectedSecondTravellerInfo);
		bookingPage.TripSummary();
	}

}
