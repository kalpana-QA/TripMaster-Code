package com.tripmasters.framework.testScript;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.tripmasters.framework.actions.BookingPageAction;
import com.tripmasters.framework.actions.PassengerInfoPageAction;
import com.tripmasters.framework.base.TestBase;
import com.tripmasters.framework.pages.BookingLocators;
import com.tripmasters.framework.utils.CommonLib;
import com.tripmasters.framework.utils.ExtentTestManager;
import com.tripmasters.framework.utils.Logs;

public class BookingPageTestScript extends TestBase {

	List<String> expectedFirstTravellerInfo = new ArrayList<String>();
	List<String> expectedSecondTravellerInfo = new ArrayList<String>();
	List<String> expectedThirdTravellerInfo = new ArrayList<String>();
	List<String> expectedFourthTravellerInfo = new ArrayList<String>();
	List<String> expectedFlightDetails = new ArrayList<String>();

	private static String actualHotel;
	private static String expectedHotel;

	private final Logs log = new Logs();
	
	/**
	* @author Kalpana Kaushik
	* * @method bookingSingleRoomWithThreeAdults_TC_1
	* @description Flight booking journey without multiple cities with Single Room for 3 Adults.
	* * @param (method)we are using this parameter to getting the method name
	*/

	@Test(groups = { "smoke" }, priority = 1)
	public void bookingSingleRoomWithThreeAdults_TC_1(Method method) throws Exception {
		ExtentTest test = ExtentTestManager.startTest(method.getName(), "bookingSingleRoomWith3Adults");
		BookingPageAction.FillBasicBookingDetails("New York  La Guardia, NY", "Berlin (Germany)", "4", "1|3");
		test.log(LogStatus.INFO, "Booking details Source & Destination filled successfully for 3 Adults_4nights");
		log.info("Booking details Source & Destination filled successfully for 3 Adults_4nights");
		BookingPageAction.ClickonContinueButton();
		BookingPageAction.SelectCheaperFlights();
		test.log(LogStatus.INFO, "User select cheaper flight option");
		log.info("User select cheaper flight option");
		BookingPageAction.ClicktoContinuePage();
		// Put assertion before selecting continue image...
		expectedFirstTravellerInfo = PassengerInfoPageAction.FillFirstTravellerDetails("John", "Leo", "Male",
				"01/01/1992", "237|US");
		expectedSecondTravellerInfo = PassengerInfoPageAction.FillSecondTravellerDetails("Elvin", "Leo", "Male",
				"01/01/1994", "237|US", "Adult");
		expectedThirdTravellerInfo = PassengerInfoPageAction.FillThirdTravellerDetails("Marie", "Leo", "Female",
				"01/01/1996", "237|US");
		test.log(LogStatus.INFO, "User filled all the passenger details successfully");
		log.info("User fills all the 3 passenger details");
		BookingPageAction.ClicktoContinuePage();
		CommonLib.VerifyTravellerDetails(BookingLocators.getverifyTraveler1Name(), expectedFirstTravellerInfo);
		CommonLib.VerifyTravellerDetails(BookingLocators.getverifyTraveler2Name(), expectedSecondTravellerInfo);
		CommonLib.VerifyTravellerDetails(BookingLocators.getverifyTraveler3Name(), expectedThirdTravellerInfo);
		test.log(LogStatus.INFO, "Flights & passenger details verified successfully on PaymentPage");
		log.info("Flights & passenger details verified successfully on PaymentPage");
	}
	
	
	/**
	* @author Kalpana Kaushik
	* * @method bookingSingleRoom1AdultOneChild_TC_2
	* @description Flight booking journey without multiple cities with Single Room with 1 Adult and 1 Child
	* * @param (method)we are using this parameter to getting the method name
	*/

	// @Test(groups= {"smoke"},priority=2)
	public void bookingSingleRoom1AdultOneChild_TC_2(Method method) throws Exception {

		ExtentTest test = ExtentTestManager.startTest(method.getName(), "bookingSingleRoom1Adult1Child");
		BookingPageAction.FillBasicBookingDetails("San Jose, CALIFORNIA", "Osaka (Japan)", "6", "1|Other");
		test.log(LogStatus.INFO,
				"Booking details Source & Destination filled successfully for 1 Adults_1Child_6nights");
		BookingPageAction.SelectNumberOfAdult("1", BookingLocators.getselectAdultDrpdown());
		BookingPageAction.SelectNumberOfChild("1", "9", "Child1");
		test.log(LogStatus.INFO, "No.of Child & Age of Child got selected successfully");
		BookingPageAction.ClickonContinueButton();
		BookingPageAction.SelectCheaperFlights();
		test.log(LogStatus.INFO, "User select cheaper flight option");
		BookingPageAction.ClicktoContinuePage();
		expectedFirstTravellerInfo = PassengerInfoPageAction.FillFirstTravellerDetails("Morris", "Leo", "Male",
				"01/01/1992", "237|US");
		expectedSecondTravellerInfo = PassengerInfoPageAction.FillSecondTravellerDetails("Shally", "Leo", "Male",
				"01/01/1994", "237|US", "Child");
		BookingPageAction.ClicktoContinuePage();
		test.log(LogStatus.INFO, "User filled all the passenger details successfully");
		CommonLib.VerifyTravellerDetails(BookingLocators.getverifyTraveler1Name(), expectedFirstTravellerInfo);
		CommonLib.VerifyTravellerDetails(BookingLocators.getverifyTraveler2Name(), expectedSecondTravellerInfo);
		test.log(LogStatus.INFO, "Flights & passenger details verified successfully on PaymentPage");
	}
	

	/**
	* @author Kalpana Kaushik
	* * @method bookingTwoRoomTwoAdult_TC_3
	* @description Flight booking journey without multiple cities, with 2 Rooms for 2 and 2 Adults 
	* * @param (method)we are using this parameter to getting the method name
	*/

	// @Test(groups= {"smoke"},priority=3)
	public void bookingTwoRoomTwoAdult_TC_3(Method method) throws Exception {
		ExtentTest test = ExtentTestManager.startTest(method.getName(), "bookingTwoRoom2Adult");
		BookingPageAction.FillBasicBookingDetails("New York, Newark, NJ", "Berlin (Germany)", "6", "2|2-2");
		BookingPageAction.ClickonContinueButton();
		BookingPageAction.SelectCheaperFlights();
		BookingPageAction.ClicktoContinuePage();
		expectedFirstTravellerInfo = PassengerInfoPageAction.FillTravellerDetailsForMultipleRooms("Room1Traveller1");
		expectedSecondTravellerInfo = PassengerInfoPageAction.FillTravellerDetailsForMultipleRooms("Room1Traveller2");
		expectedThirdTravellerInfo = PassengerInfoPageAction.FillTravellerDetailsForMultipleRooms("Room2Traveller1");
		expectedFourthTravellerInfo = PassengerInfoPageAction.FillTravellerDetailsForMultipleRooms("Room2Traveller2");
		BookingPageAction.ClicktoContinuePage();
		CommonLib.VerifyTravellerDetails(BookingLocators.getverifyTraveler1Name(), expectedFirstTravellerInfo);
		CommonLib.VerifyTravellerDetails(BookingLocators.getverifyTraveler2Name(), expectedSecondTravellerInfo);
		CommonLib.VerifyTravellerDetails(BookingLocators.getverifyTraveler3Name(), expectedThirdTravellerInfo);
		CommonLib.VerifyTravellerDetails(BookingLocators.getverifyTraveler4Name(), expectedFourthTravellerInfo);
		test.log(LogStatus.INFO, "Flights & passenger details verified successfully on PaymentPage");
	}
	
	/**
	* @author Kalpana Kaushik
	* * @method bookingTwoRoom3Adult1Child_TC_4
	* @description Flight booking journey without multiple cities, with 2 Rooms for 3 Adults and 1 Child 
	* * @param (method)we are using this parameter to getting the method name
	*/

	// @Test(groups= {"smoke"},priority=4)
	public void bookingTwoRoom3Adult1Child_TC_4(Method method) throws Exception {
		ExtentTestManager.startTest(method.getName(), "bookingTwoRoom3Adult1Child");
		BookingPageAction.FillBasicBookingDetails("New York, Newark, NJ", "Berlin (Germany)", "6", "2|Other");
		BookingPageAction.SelectNumberOfAdult("2", BookingLocators.getselectAdultDrpdown());
		BookingPageAction.SelectNumberOfChild("1", "9", "Child1");
		BookingPageAction.SelectNumberOfAdult("1", BookingLocators.getselectAdultRoom2Drpdown());
		BookingPageAction.ClickonContinueButton();
		BookingPageAction.SelectCheaperFlights();
		BookingPageAction.ClicktoContinuePage();
		BookingPageAction.ClicktoContinuePage();
		expectedFirstTravellerInfo = PassengerInfoPageAction.FillTravellerDetailsForMultipleRooms("Room1Traveller1");
		expectedSecondTravellerInfo = PassengerInfoPageAction.FillTravellerDetailsForMultipleRooms("Room1Traveller2");
		// expectedThirdTravellerInfo=PassengerInfoPageAction.FillSecondTravellerDetails("Shally","Leo","Male","01/01/1994","237|US","Child");
		expectedThirdTravellerInfo = PassengerInfoPageAction.FillTravellerDetailsForMultipleRooms("Room1Child1");
		expectedFourthTravellerInfo = PassengerInfoPageAction.FillTravellerDetailsForMultipleRooms("Room2Traveller1");
		BookingPageAction.ClicktoContinuePage();
		CommonLib.VerifyTravellerDetails(BookingLocators.getverifyTraveler1Name(), expectedFirstTravellerInfo);
		CommonLib.VerifyTravellerDetails(BookingLocators.getverifyTraveler2Name(), expectedSecondTravellerInfo);
		CommonLib.VerifyTravellerDetails(BookingLocators.getverifyTraveler3Name(), expectedThirdTravellerInfo);
		CommonLib.VerifyTravellerDetails(BookingLocators.getverifyTraveler4Name(), expectedFourthTravellerInfo);

	}
	

	/**
	* @author Kalpana Kaushik
	* * @method booking2Room2Adult2Child_TC_5
	* @description Flight booking journey without multiple cities, with Two Room for 1 Adult and 1 Child in each Room
	* * @param (method)we are using this parameter to getting the method name
	*/

	// @Test(groups= {"smoke"},priority=5)
	public void booking2Room2Adult2Child_TC_5(Method method) throws Exception {
		ExtentTestManager.startTest(method.getName(), "booking2Room2Adult2Child");
		BookingPageAction.FillBasicBookingDetails("New York, Newark, NJ", "Berlin (Germany)", "6", "2|Other");
		BookingPageAction.SelectNumberOfAdult("1", BookingLocators.getselectAdultDrpdown());
		BookingPageAction.SelectNumberOfChild("1", "9", "Child1");
		BookingPageAction.SelectNumberOfAdult("1", BookingLocators.getselectAdultRoom2Drpdown());
		BookingPageAction.SelectNumberOfChild("1", "9", "Child2");
		BookingPageAction.ClickonContinueButton();
		BookingPageAction.SelectCheaperFlights();
		BookingPageAction.ClicktoContinuePage();
		BookingPageAction.ClicktoContinuePage();
		expectedFirstTravellerInfo = PassengerInfoPageAction.FillTravellerDetailsForMultipleRooms("Room1Traveller1");
		expectedSecondTravellerInfo = PassengerInfoPageAction.FillTravellerDetailsForMultipleRooms("Room1Child1");
		expectedThirdTravellerInfo = PassengerInfoPageAction.FillTravellerDetailsForMultipleRooms("Room2Traveller1");
		expectedFourthTravellerInfo = PassengerInfoPageAction.FillTravellerDetailsForMultipleRooms("Room2Child1");
		BookingPageAction.ClicktoContinuePage();
		CommonLib.VerifyTravellerDetails(BookingLocators.getverifyTraveler1Name(), expectedFirstTravellerInfo);
		CommonLib.VerifyTravellerDetails(BookingLocators.getverifyTraveler2Name(), expectedSecondTravellerInfo);
		CommonLib.VerifyTravellerDetails(BookingLocators.getverifyTraveler3Name(), expectedThirdTravellerInfo);
		CommonLib.VerifyTravellerDetails(BookingLocators.getverifyTraveler4Name(), expectedFourthTravellerInfo);

	}
	
	
	/**
	* @author Kalpana Kaushik
	* * @method bookingFlightsWithmultipleCities_TC_6
	* @description Flight booking journey with multiple cities, with one Room for one Adult and one Child
	* * @param (method)we are using this parameter to getting the method name
	*/
	
	// @Test(groups= {"smoke"},priority=6)
	public void bookingFlightsWithmultipleCities_TC_6(Method method) throws Exception {
		ExtentTestManager.startTest(method.getName(), "bookingFlightsWithmultipleCities");
		BookingPageAction.fillBasicBookingDetailForMultipleCities("WithAir", "Berlin (Germany)", "4",
				"Augsburg (Germany)", "1|Other");
		BookingPageAction.SelectNumberOfAdult("1", BookingLocators.getselectAdultDrpdown());
		BookingPageAction.SelectNumberOfChild("1", "9", "Child1");
		BookingPageAction.ClickonContinueButton();
		BookingPageAction.SelectCheaperFlights();
		BookingPageAction.ClicktoContinuePage();
		BookingPageAction.ClicktoContinuePage();
		expectedFirstTravellerInfo = PassengerInfoPageAction.FillFirstTravellerDetails("Morris", "Leo", "Male",
				"01/01/1992", "237|US");
		expectedSecondTravellerInfo = PassengerInfoPageAction.FillSecondTravellerDetails("Shally", "Leo", "Male",
				"01/01/1994", "237|US", "Child");
		BookingPageAction.ClicktoContinuePage();
		CommonLib.VerifyTravellerDetails(BookingLocators.getverifyTraveler1Name(), expectedFirstTravellerInfo);
		CommonLib.VerifyTravellerDetails(BookingLocators.getverifyTraveler2Name(), expectedSecondTravellerInfo);

	}
	
	/**
	* @author Kalpana Kaushik
	* * @method bookingFlightAndHotelForSingleCity_TC_7
	* @description Flight and Hotel booking journey with single city ,with two Room for two Adult and one Child
	* * @param (method)we are using this parameter to getting the method name
	*/

	// @Test(groups= {"smoke"},priority=7)
	public void bookingFlightAndHotelForSingleCity_TC_7(Method method) throws Exception {
		ExtentTestManager.startTest(method.getName(), "bookingFlightAndHotelForSingleCity");
		BookingPageAction.FillBasicBookingDetails("New York, Newark, NJ", "Berlin (Germany)", "6", "2|Other");
		BookingPageAction.SelectNumberOfAdult("1", BookingLocators.getselectAdultDrpdown());
		BookingPageAction.SelectNumberOfChild("1", "9", "Child1");
		BookingPageAction.SelectNumberOfAdult("1", BookingLocators.getselectAdultRoom2Drpdown());
		BookingPageAction.ClickonContinueButton();
		actualHotel = BookingPageAction.browseHotelsButton();
		expectedHotel = BookingPageAction.browseSelectHotel();
		BookingPageAction.getContinueLink();
		String expected = BookingPageAction.SelectCheaperFlights();
		String actualFlightDetails = BookingPageAction.GetActualFlight();
		System.out.println(expected);
		System.out.println(actualFlightDetails);
		Assert.assertTrue(expected.contains(actualFlightDetails));
		Assert.assertEquals(actualHotel, expectedHotel);

	}
	
	/**
	* @author Kalpana Kaushik
	* * @method bookingFlightAndHotelForMultipleCity_TC_8
	* @description Flight and Hotel booking journey with multiple cities, with one Room for one Adult and one Child
	* * @param (method)we are using this parameter to getting the method name
	*/

	// @Test(groups= {"smoke"},priority=8)
	public void bookingFlightAndHotelForMultipleCity_TC_8(Method method) throws Exception {
		ExtentTestManager.startTest(method.getName(), "bookingFlightAndHotelForMultipleCity");
		BookingPageAction.fillBasicBookingDetailForMultipleCities("WithAir", "Berlin (Germany)", "4",
				"Augsburg (Germany)", "1|Other");
		BookingPageAction.SelectNumberOfAdult("1", BookingLocators.getselectAdultDrpdown());
		BookingPageAction.SelectNumberOfChild("1", "9", "Child1");
		BookingPageAction.ClickonContinueButton();
		BookingPageAction.SelectCheaperFlights();
		BookingPageAction.ClicktoContinuePage();
		BookingPageAction.ClicktoContinuePage();
		expectedFirstTravellerInfo = PassengerInfoPageAction.FillFirstTravellerDetails("Morris", "Leo", "Male",
				"01/01/1992", "237|US");
		expectedSecondTravellerInfo = PassengerInfoPageAction.FillSecondTravellerDetails("Shally", "Leo", "Male",
				"01/01/1994", "237|US", "Child");
		BookingPageAction.ClicktoContinuePage();
		CommonLib.VerifyTravellerDetails(BookingLocators.getverifyTraveler1Name(), expectedFirstTravellerInfo);
		CommonLib.VerifyTravellerDetails(BookingLocators.getverifyTraveler2Name(), expectedSecondTravellerInfo);

	}
	

	/**
	* @author Vaishali Saini
	* * @method withoutAirBookingForSingleCity_TC_19
	* @description To verify WithoutAir booking journey for Single City and Hotel name
	* * @param (method)we are using this parameter to getting the method name
	*/

	// @Test(groups= {"regression"},priority=9)
	public void withoutAirBookingForSingleCity_TC_19(Method method) throws Exception {
		ExtentTestManager.startTest(method.getName(), "withoutAirBookingForSingleCity_TC_19");
		BookingPageAction.SelectWithoutAir();
		BookingPageAction.FillBasicBookingDetails2("San Francisco (USA)", "5", "1|3");
		BookingPageAction.ClickonContinueButton();
		String Actualresult = BookingPageAction.browseHotelsButton();
		String expectedresult = BookingPageAction.browseSelectHotel();
		Assert.assertEquals(Actualresult, expectedresult);
		BookingPageAction.ClickonContinueLink();

	}
	
	/**
	* @author Satyam Sharma
	* * @method getWithoutAir_TC_20
	* @description To verify WithoutAir booking journey for Multiple Cities and Hotel name
	* * @param (method)we are using this parameter to getting the method name
	*/

	// @Test(groups= {"regression"},priority=10)
	public void getWithoutAir_TC_20(Method method) throws Exception {
		ExtentTestManager.startTest(method.getName(), "getWithoutAir");
		BookingPageAction.getWithoutButton();
		BookingPageAction.fillBasicBookingDetailForMultipleCities("WithOutAir", "Delhi (India)", "4", "Mumbai (India)",
				"1|3");
		BookingPageAction.ClickonContinueButton();
		actualHotel = BookingPageAction.browseHotelsButton();
		expectedHotel = BookingPageAction.browseSelectHotel();
		Assert.assertEquals(actualHotel, expectedHotel);
		BookingPageAction.getContinueLink();
		System.out.println("passed");
	}
	
	/**
	* @author Satyam Sharma
	* * @method removeAddedCity_TC_17
	* @description To verify user is able to Remove Added Cities and redirecetd to the "Trip Inclusion Details" page
	* * @param (method)we are using this parameter to getting the method name
	*/

	// @Test(groups= {"regression"},priority=11)
	public void removeAddedCity_TC_17(Method method) throws Exception {
		BookingPageAction.fillBasicDetails("New York, Newark, NJ", "Delhi (India)", "4", "Mumbai (India)", "1",
				"Chennai -Madras (India)", "1");
		boolean actual = BookingPageAction.isremovecitydisplayed();
		Assert.assertTrue(actual);
		BookingPageAction.deleteAddedCities();
		boolean expected = BookingPageAction.validateremovedcity();
		Assert.assertTrue(expected);
		BookingPageAction.getNoMoreCitiesButton();
		BookingPageAction.SelectGuestDetails("1|1");
		BookingPageAction.ClickonContinueButton();
		BookingPageAction.SelectCheaperFlights();
		boolean tripinclusion = BookingPageAction.validateTripIncluisonPage();
		Assert.assertTrue(tripinclusion);
	}
	
	/**
	* @author Vaishali Saini
	* * @method premiumEconomy_TC_18
	* @description To verify Flight booking journey form Premium Economy Class and verify Cabin class is selected as "Premium Economy".
	* * @param (method)we are using this parameter to getting the method name
	*/

	 @Test(groups= {"regression"},priority=12)
	public void premiumEconomy_TC_18(Method method) throws Exception {
		ExtentTestManager.startTest(method.getName(), "premiumEconomy_TC_18");
		BookingPageAction.BookingDetailswithPremiumEcomomy("New York City (all Airports),  NY", "Delhi (India)",
				"Premium Economy", "4", "1|1");
		String actualcabin = BookingPageAction.selectedcabinAssert();
		String expectedcabin = BookingPageAction.verifycabinAssert();
		Assert.assertEquals(expectedcabin, actualcabin);
		BookingPageAction.ClickonContinueButton();
		BookingPageAction.SelectCheaperFlights();
		BookingPageAction.ClicktoContinuePage();
	}
	
	/**
	* @author Vaishali Saini
	* * @method verifySpotlightLink_TC_14
	* @description To verify "In the Spotlight" link.
	* * @param (method)we are using this parameter to getting the method name
	*/

	// @Test(groups= {"regression"},priority=13)
	public void verifySpotlightLink_TC_14(Method method) throws Exception {
		ExtentTestManager.startTest(method.getName(), "verifySpotlightLink");
		BookingPageAction.selectLatinAmericaLink();
		BookingPageAction.verifyLatinAmericPage();
	}
	
	/**
	* @author Vaishali Saini
	* * @method dateChanging_TC_9
	* @description Flight booking by Changing Date,verify Hotel name and booking details
	* * @param (method)we are using this parameter to getting the method name
	*/

	// @Test(groups= {"regression"},priority=14)
	public void dateChanging_TC_9() throws Exception {
		BookingPageAction.FillBasicBookingDetails("New York, Newark, NJ", "Berlin (Germany)", "12", "1|2");
		BookingPageAction.SelectNumberOfAdult("2", BookingLocators.getselectAdultDrpdown());
		BookingPageAction.ClickonContinueButton();
		BookingPageAction.ClickChangedArriveDate();
		BookingPageAction.OldArriveDate();
		actualHotel = BookingPageAction.browseHotelsButton();
		expectedHotel = BookingPageAction.browseSelectHotel();
		Assert.assertEquals(actualHotel, expectedHotel);
		BookingPageAction.ClickonContinueLink();
		BookingPageAction.ClicktoContinuePage();
		expectedFirstTravellerInfo = PassengerInfoPageAction.FillFirstTravellerDetails("Morris", "Leo", "Male",
				"01/01/1992", "237|US");
		expectedSecondTravellerInfo = PassengerInfoPageAction.FillSecondTravellerDetails("Shally", "Leo", "Male",
				"01/01/1994", "237|US", "Adult");
		BookingPageAction.ClicktoContinuePage();
		CommonLib.VerifyTravellerDetails(BookingLocators.getverifyTraveler1Name(), expectedFirstTravellerInfo);
		CommonLib.VerifyTravellerDetails(BookingLocators.getverifyTraveler2Name(), expectedSecondTravellerInfo);
		BookingPageAction.TripSummary();
	}

}
