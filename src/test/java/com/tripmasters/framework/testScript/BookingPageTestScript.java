	package com.tripmasters.framework.testScript;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
//import com.tripmasters.framework.actions.BookingPageAction;
import com.tripmasters.framework.base.PageBase;
import com.tripmasters.framework.base.TestBase;
import com.tripmasters.framework.pageLocators.BookingLocators;
import com.tripmasters.framework.reports.ExtentTestManager;

public class BookingPageTestScript extends TestBase {

	List<String> expectedFirstTravellerInfo = new ArrayList<String>();
	List<String> expectedSecondTravellerInfo = new ArrayList<String>();
	List<String> expectedThirdTravellerInfo = new ArrayList<String>();
	List<String> expectedFourthTravellerInfo = new ArrayList<String>();
	List<String> expectedFlightDetails = new ArrayList<String>();
	
	
	private static String ActualHotel;
	private static String ExpectedHotel;
	private static String expectedSecondcityHotel;
	private static String actualsecondCityHotel;

	
	@Test(groups = { "smoke" }, priority = 1)
	public void TC_0001_bookingSingleRoomWithThreeAdults(Method method) throws Exception {
	    ExtentTest test = ExtentTestManager.startTest(method.getName(), "TC_0001_bookingSingleRoomWithThreeAdults");
		bookingPage.clickOnBuildYourVacationDropDown();
		bookingPage.fillLeavingFromDetails("New York, Newark, NJ");
		test.log(LogStatus.INFO, "User entered \"New York, Newark, NJ\" into leaving from field");
		bookingPage.fillGoingToCityDetails("Berlin (Germany)");
		test.log(LogStatus.INFO, "User entered \"Berlin (Germany)\" into Going to from field");
		String date = bookingPage.selectValueFromCalendar(180 ,3);
		
	
		test.log(LogStatus.INFO,   "User selects '" + date + "'from calendar");
		bookingPage.selectStayingTime("4");
		test.log(LogStatus.INFO, "User entered \"4\" nights staying time");	
		bookingPage.selectNoMoreCitiesBtn();
		test.log(LogStatus.INFO, "Click on No More Cities Button");
		bookingPage.selectGuestDetails("1|3");
		test.log(LogStatus.INFO, "User select \"1 Room With 3 Adults\" from Guest list");
		test.log(LogStatus.INFO, "All the basic booking details Source & Destination filled successfully for 3 Adults_4nights");
		bookingPage.clickonContinueButton();
		test.log(LogStatus.INFO, "Click on \"Continue\" Button");
		bookingPage.selectCheaperFlights();
		test.log(LogStatus.INFO, "User clicks on Select Cheaper Flights Link");
		test.log(LogStatus.INFO, "User selects a particular flight from existing options");
		test.log(LogStatus.INFO, "User clicks on Continue Link");
		//Logs.info("Select Cheaper flights from flight options");
	    bookingPage.getTripinclusionContinueButton();
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
		//Logs.info("User fills all the 3 passenger details");
		bookingPage.getTripinclusionContinueButton();
		bookingPage.clicktoContinuePage();
		test.log(LogStatus.INFO, "Click to Continue & User redirected to Payment Page");
		if(TestBase.flag_Mob){
			PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler1NameiOS(), expectedFirstTravellerInfo);
			PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler2NameiOS(), expectedSecondTravellerInfo);
			PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler3NameiOS(), expectedThirdTravellerInfo);
			
		}else{
		PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler1Name(), expectedFirstTravellerInfo);
		PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler2Name(), expectedSecondTravellerInfo);
		PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler3Name(), expectedThirdTravellerInfo);
		}
		bookingPage.tripSummary();
		test.log(LogStatus.INFO, "Flights & passenger details verified successfully on PaymentPage");
		//Logs.info("Flights & passenger details verified successfully on PaymentPage");
	}
	
	
		@Test(groups= {"smoke"},priority = 2,alwaysRun = true)
		public void TC_0002_bookingSingleRoomtwoAdultOneChild(Method method) throws Exception {
			ExtentTest test = ExtentTestManager.startTest(method.getName(), "TC_0002_bookingSingleRoomtwoAdultOneChild");
			bookingPage.clickOnBuildYourVacationDropDown();
			PageBase.waitForElement(3);
			bookingPage.fillLeavingFromDetails("New York City (all Airports),  NY");
			test.log(LogStatus.INFO, "User entered \"New York City (all Airports),  NY\" into leaving from field");
			bookingPage.fillGoingToCityDetails("London (England)");
			test.log(LogStatus.INFO, "User entered \"London(England)\" into Going to from field");
			String date = bookingPage.selectValueFromCalendar(180 ,2);
			
			
			test.log(LogStatus.INFO,   "User selects '" + date + "'from calendar");
			bookingPage.selectStayingTime("6");
			test.log(LogStatus.INFO, "User entered \"6\" nights staying time");	
			bookingPage.clickOnAddCityBtn();
			bookingPage.fillSecndAddedCityDetails("Paris (France)");
			test.log(LogStatus.INFO, "User entered \"Paris (France)\" into Going to from field for adding second city");
			bookingPage.selectStayingTimeTwo("5");
			test.log(LogStatus.INFO, "User entered \"5\" nights staying time for second city");
			 bookingPage.selectNoMoreCitiesBtn();
			test.log(LogStatus.INFO, "Click on No More Cities Button");
			bookingPage.selectGuestDetails("1|Other");
			test.log(LogStatus.INFO, "User select \"1 Room With Other Options\" from Guest list");
			
			bookingPage.selectNumberOfAdult("2", BookingLocators.getselectAdultDrpdown());
			
			test.log(LogStatus.INFO, "User selects \"2\" Adult from Adult Drpdown");
			bookingPage.selectNumberOfChild("1", "11", "Child1");
			test.log(LogStatus.INFO, "No.of Child & Age of Child got selected successfully");
		    bookingPage.doneButtonMob();
			test.log(LogStatus.INFO, "User selects \"1\" Child,\"Age of Child:11\"");
			test.log(LogStatus.INFO, "No.of Child & Age of Child got selected successfully");
            bookingPage.clickonContinueButton();
			test.log(LogStatus.INFO, "Click on Continue Button");
			//Logs.info("Click on Continue Button");
			boolean actualresult = bookingPage.verifyTravelByTrain();
			Assert.assertTrue(actualresult);
			test.log(LogStatus.INFO,"Verify that user is going from London to Paris By Train");
			test.log(LogStatus.INFO, "All the basic booking details Source & Destination filled successfully");
			bookingPage.clickOncheaperFlights();
			
			test.log(LogStatus.INFO, "User clicks on Select Cheaper Flights Link");
			test.log(LogStatus.INFO, "User selects a particular flight from existing options");
			test.log(LogStatus.INFO, "User clicks on Continue Link");
			bookingPage.selectOnCheaperFlightPage();
			bookingPage.selectCabin();
			test.log(LogStatus.INFO, "User selects an available cabin");
			test.log(LogStatus.INFO, "User selects a particular flight from existing options");
			bookingPage.getTripinclusionContinueButton();
			bookingPage.getTripinclusionContinueButton();
			
			expectedFirstTravellerInfo = passengerInfoPage.fillTravellerDetailsForMultipleRooms("Room1Traveller1");
			test.log(LogStatus.INFO, "User enters \"yury\" as  First Name");
		    test.log(LogStatus.INFO, "User enters \"darwin\" as  Last Name");
			test.log(LogStatus.INFO, "User selects \"Gender:Male\" for Traveller ");
			test.log(LogStatus.INFO, "User selects \"DOB:01/01/2000\" for Traveller Date of Birth");
			test.log(LogStatus.INFO, "User selects \"Passport details as:US\" for Traveller");
			expectedThirdTravellerInfo = passengerInfoPage.fillTravellerDetailsForMultipleRooms("Room2Traveller1");
			test.log(LogStatus.INFO, "User enters \"Hanna\" as Traveller First Name");
			test.log(LogStatus.INFO, "User enters \"darwin\" as Traveller Last Name");
			test.log(LogStatus.INFO, "User selects \"Gender:Male\" for Traveller ");
			test.log(LogStatus.INFO, "User selects \"DOB:01/01/2000\" for Traveller Date of Birth");
			test.log(LogStatus.INFO, "User selects \"Passport details as:US\" for Traveller");
			expectedSecondTravellerInfo = passengerInfoPage.fillTravellerDetailsForMultipleRooms("Room1Child1SingleTravlr");
			test.log(LogStatus.INFO, "User enters \"Erwin\" as Traveller First Name");
			test.log(LogStatus.INFO, "User enters \"George\" as Traveller Last Name");
			test.log(LogStatus.INFO, "User selects \"Gender:Male\" for Traveller ");
			test.log(LogStatus.INFO, "User selects \"DOB:01/01/2000\" for Traveller Date of Birth");
			test.log(LogStatus.INFO, "User selects \"Passport details as:US\" for Traveller");
			
			bookingPage.getTripinclusionContinueButton();
			bookingPage.clicktoContinuePage();
			test.log(LogStatus.INFO, "Click on Continue Button & User redirected to the Payment Page");
			PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler1Name(), expectedFirstTravellerInfo);
			PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler2Name(),expectedThirdTravellerInfo );
			PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler3Name(), expectedSecondTravellerInfo);
			test.log(LogStatus.INFO, "Flights & passenger details verified successfully on PaymentPage");
			
		}
	

	
	  @Test(groups= {"smoke"},priority=3 ,alwaysRun = true)
	public void TC_0003_bookingTwoRoomThreeAdultAndOneChildWithMultipleCities(Method method) throws Exception {
		ExtentTest test = ExtentTestManager.startTest(method.getName(), "TC_0003_bookingTwoRoomThreeAdultAndOneChildWithMultipleCities");
		bookingPage.clickOnBuildYourVacationDropDown();
		PageBase.waitForElement(3);
		bookingPage.fillLeavingFromDetails("Seattle, WA");
		test.log(LogStatus.INFO, "User entered \"Seattle, WA\" into leaving from field");
		String date = bookingPage.selectValueFromCalendar(175 ,0);
		
		
		test.log(LogStatus.INFO,   "User selects '" + date + "'from calendar");
		bookingPage.fillGoingToCityDetails("Dublin (Ireland)");
		test.log(LogStatus.INFO, "User entered \"Dublin (Ireland)\" into Going to from field");
		bookingPage.selectStayingTime("3");
		test.log(LogStatus.INFO, "User entered \"3\" nights staying time");	
		bookingPage.clickOnAddCityBtn();
		bookingPage.fillSecndAddedCityDetails("Galway (Ireland)");
		test.log(LogStatus.INFO, "User entered \"Galway (Ireland)\" into Going to from field for adding second city");
		bookingPage.selectStayingTimeTwo("4");
		test.log(LogStatus.INFO, "User entered \"4\" nights staying time for second city");
		bookingPage.clickOnAddCityBtn();
		bookingPage.fillThirdAddedCityDetails("Limerick (Ireland)");
		test.log(LogStatus.INFO, "User entered \"Limerick (Ireland)\" into Going to from field for adding Third city");
		bookingPage.selectStayingTimeThree("4");
		test.log(LogStatus.INFO, "User entered \"4\" nights staying time for the Third city");
		bookingPage.selectNoMoreCitiesBtn();
		//PageBase.waitForElement(3);
		bookingPage.clickToRemoveGalwayCityLink();
		bookingPage.deleteGalwayCity();
		//PageBase.waitForElement(3);
		test.log(LogStatus.INFO, "Galway city is deleted successfully");
		//logs.info("Galway city is deleted successfully");
		test.log(LogStatus.INFO, "Galway city removed successfully.Verified!");
		//logs.info("Galway city removed successfully.Verified!");
        bookingPage.selectNoMoreCitiesBtn();
		bookingPage.clickToRemoveLimerickCityLink();
		bookingPage.deleteLimrickCity();
		bookingPage.validateremovedGalwaycity();
		test.log(LogStatus.INFO, "Limerick city is deleted successfully");
		//logs.info("Limerick city is deleted successfully");
		bookingPage.clickOnAddCityBtn();
		bookingPage.fillSecndAddedCityDetails("Galway (Ireland)");
		test.log(LogStatus.INFO, "User entered \"Galway (Ireland)\" into Going to from field for Re-adding second city");
		bookingPage.selectStayingTimeTwo("4");
		test.log(LogStatus.INFO, "User entered \"4\" nights staying time for second city");
		bookingPage.selectNoMoreCitiesBtn();
		PageBase.waitForElement(3);
		bookingPage.selectCarFromTransportation();
		test.log(LogStatus.INFO, "Travel By Car option is selected successfully");
		bookingPage.selectGuestDetails("2|Other");
		test.log(LogStatus.INFO, "User select \"2 Room For three Adults and one child \" from Guest list");
		test.log(LogStatus.INFO, "All the Basic Booking details Source & Destination filled successfully for Two Adults");
		//Logs.info("All the Basic Booking details Source & Destination filled successfully for Two Adults");
		bookingPage.select2NumberOfAdultForRoom1("2", BookingLocators.getselectAdultDrpdown());
		test.log(LogStatus.INFO, "No. of adults selected for Room1");
        bookingPage.select1NumberOfAdultForRoom2("1", BookingLocators.getselectAdultRoom2Drpdown());
        test.log(LogStatus.INFO, "No. of adults selected for Room2");
		bookingPage.selectNumberOfChild("1", "9", "Child2");
		test.log(LogStatus.INFO, "No.of Child & Age of Child for Room2 got selected successfully");
		bookingPage.doneButtonMob();
		bookingPage.clickonContinueButton();
		test.log(LogStatus.INFO, "Click on Continue Button");
		//Logs.info("Click on Continue Button");
		//bookingPage.selectCheaperFlights();
		
		bookingPage.clickOncheaperFlights();
		test.log(LogStatus.INFO, "User clicks on Select Cheaper Flights Link");
		bookingPage.selectOnCheaperFlightPage();
		bookingPage.selectCabin();
		bookingPage.getTripinclusionContinueButton();

		
		
		
		
		test.log(LogStatus.INFO, "User selects a particular flight from existing options");
		test.log(LogStatus.INFO, "User clicks on Continue Link");
		//PageBase.waitForElement(10);
		bookingPage.getTripinclusionContinueButton();
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
		PageBase.scrollDownForMob(1);
		expectedThirdTravellerInfo = passengerInfoPage.fillTravellerDetailsForMultipleRooms("Room2Traveller1");
		test.log(LogStatus.INFO, "User enters \"Hanna\" as Traveller3 First Name");
		test.log(LogStatus.INFO, "User enters \"darwin\" as Traveller3 Last Name");
		test.log(LogStatus.INFO, "User selects \"Gender:Male\" for Traveller3 ");
		test.log(LogStatus.INFO, "User selects \"DOB:01/01/2000\" for Traveller3 Date of Birth");
		test.log(LogStatus.INFO, "User selects \"Passport details as:US\" for Traveller3");
	//	expectedFourthTravellerInfo = passengerInfoPage.fillTravellerDetailsForMultipleRooms("Room2Child1");
		expectedFourthTravellerInfo =passengerInfoPage.fillSecondTravellerDetailsChildMob("Erwin", "George", "Male", "01/01/2000","237|US", "Child");
		test.log(LogStatus.INFO, "User enters \"Erwin\" as Traveller3 First Name");
		test.log(LogStatus.INFO, "User enters \"George\" as Traveller3 Last Name");
		test.log(LogStatus.INFO, "User selects \"Gender:Male\" for Traveller3 ");
		test.log(LogStatus.INFO, "User selects \"DOB:01/01/2002\" for Traveller3 Date of Birth");
		test.log(LogStatus.INFO, "User selects \"Passport details as:US\" for Traveller3");
		bookingPage.getTripinclusionContinueButton();
		test.log(LogStatus.INFO, "User filled all the passenger details successfully");

		if(TestBase.flag_Mob) {
			PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler1NameiOS(), expectedFirstTravellerInfo);
			PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler2NameiOS(), expectedSecondTravellerInfo);
			PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler3NameiOS(), expectedThirdTravellerInfo);
			PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler4NameiOS(), expectedFourthTravellerInfo);
		}else {
			PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler1Name(), expectedFirstTravellerInfo);
			PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler2Name(), expectedSecondTravellerInfo);
			PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler3Name(), expectedThirdTravellerInfo);
			PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler4Name(), expectedFourthTravellerInfo);
		}
		test.log(LogStatus.INFO, "Flights & passenger details verified successfully on PaymentPage");
	}
	
	
	@Test(groups= {"smoke"},priority=4)
	public void TC_0004_flightBookingWithFirstPackage(Method method) throws Exception {
		ExtentTest test = ExtentTestManager.startTest(method.getName(), "TC_0004_flightBookingWithFirstPackage");
		bookingPage.getexploreLink();
		test.log(LogStatus.INFO, "User clicks on Explore link");
		bookingPage.fillLeavingFromDetails("Washington (all Airports), DC");
		test.log(LogStatus.INFO, "User entered \"Washington (all Airports), DC\" into leaving from field");
		
		String date = bookingPage.selectValueFromCalendar(180 ,0);
		
		
		test.log(LogStatus.INFO,   "User selects '" + date + "'from calendar");

		
		bookingPage.selectGuestDetails("1|2");
		test.log(LogStatus.INFO, "User select \"Two Adults\" from Guest list");
		test.log(LogStatus.INFO, "Booking details filled successfully for Two Adults");
		bookingPage.clickOnViewPrice();
		//test.log(LogStatus.INFO, "Booking details filled successfully for Two Adults");
		PageBase.waitForElement(10);
		bookingPage.removeSecondCityHotel();
		test.log(LogStatus.INFO, "Removes Hotel for Second City.");
		bookingPage.getContinueLink();
		bookingPage.validateSecondCityHotel();
		test.log(LogStatus.INFO, "Verifies Hotel for Second City removed successfully");
		bookingPage.getTripinclusionContinueButton();
		expectedFirstTravellerInfo = passengerInfoPage.fillFirstTravellerDetails("Morris", "Leo", "Male","01/01/1992", "237|US");
		test.log(LogStatus.INFO, "User enters \"Morris\" as First Traveller First Name");
		test.log(LogStatus.INFO, "User enters \"Mano\" as First Traveller Last Name");
      	test.log(LogStatus.INFO, "User selects \"Gender:Male\" for First Traveller Last Name");
		test.log(LogStatus.INFO, "User selects \"DOB:01/01/1992\" for First Traveller's Date of Birth");
		test.log(LogStatus.INFO, "User selects \"Passport details as:US\" for First Traveller");
		expectedSecondTravellerInfo = passengerInfoPage.fillSecondTravellerDetails("Elvin", "Leo", "Male","01/01/1994", "237|US", "Adult");
		test.log(LogStatus.INFO, "User enters \"Elvin\" as Second Traveller First Name");
		test.log(LogStatus.INFO, "User enters \"Leo\" as Second Traveller Last Name");
		test.log(LogStatus.INFO, "User selects \"Gender:Male\" for Second Traveller Last Name");
		test.log(LogStatus.INFO, "User selects \"DOB:01/01/1994\" for Second Traveller's Date of Birth");
		test.log(LogStatus.INFO, "User selects \"Passport details as:US\" for Second Traveller");
		bookingPage.getTripinclusionContinueButton();
		bookingPage.clicktoContinuePage();
		test.log(LogStatus.INFO, "Click to Continue & User redirected to Payment Page");
		if(TestBase.flag_Mob){
			PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler1NameiOS(), expectedFirstTravellerInfo);
			PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler2NameiOS(), expectedSecondTravellerInfo);
		}
		test.log(LogStatus.INFO, "Flights & passenger details verified successfully on PaymentPage");
	}
	

		@Test(groups= {"smoke"},priority=5)
	public void TC_0005_bookingwithoutmultiplecityOneAdultOneChild(Method method) throws Exception {
		ExtentTest test = ExtentTestManager.startTest(method.getName(), "TC_0005_bookingwithoutmultiplecityOneAdultOneChild");
		PageBase.scrollDownForMob(1);
		homePage.clickOnExploreEuropeLink();
		test.log(LogStatus.INFO, "User clicked on Explore Europe Link");
		bookingPage.clickOnPackageDisplayedUnderSuggestedVacationPackageOption();
		test.log(LogStatus.INFO, "User clicked on particular vacation package");
		bookingPage.clickOnReorderCitiesLink();
		test.log(LogStatus.INFO, "User clicked on Reorder cities link");
		bookingPage.fillLeavingFromDetailsOnEuropePage("Chicago (All Airports)");
		
		String date = bookingPage.selectValueFromCalendar(90 ,0);
		
		
		test.log(LogStatus.INFO,   "User selects '" + date + "'from calendar");
		
		test.log(LogStatus.INFO, "User entered \"Chicago (All Airports)\" into leaving from field");
		PageBase.scrollDownForMob(2);
		bookingPage.selectGuestDetails("2|Other");
		test.log(LogStatus.INFO, "User select \"Two Adults & Two Child\" from Guest list");
		test.log(LogStatus.INFO, "Booking details filled successfully for Two Adults & Two Child");
		bookingPage.selectnumberofadultsRoom_1iOS();
		//bookingPage.selectNumberOfChild("1", "3", "Child1");
		bookingPage.selectNumberOfChildNewPage("1", "4", "Child1");
		test.log(LogStatus.INFO, "No.of Child & Age of Child got selected successfully");
		bookingPage.selectnumberofadultsRoom_2iOS();
		//bookingPage.selectNumberOfChild("1", "3", "Child2");
		bookingPage.selectNumberOfChildNewPage("1", "3", "Child2");
		test.log(LogStatus.INFO, "No.of Child & Age of Child got selected successfully");
		test.log(LogStatus.INFO, "Booking details filled successfully for Two Adults & Two Child");
		bookingPage.doneButtonMob();
		bookingPage.clickonContinueButton();
		test.log(LogStatus.INFO, "Click on Continue Button");
		//Logs.info("Click on Continue Button");
		bookingPage.selectCheaperFlights();
		test.log(LogStatus.INFO, "User clicks on Select Cheaper Flights Link");
		test.log(LogStatus.INFO, "User selects a particular flight from existing options");
		test.log(LogStatus.INFO, "User clicks on Continue Link");
		PageBase.waitForElement(10);
		bookingPage.getTripinclusionContinueButton();
		 expectedFirstTravellerInfo = passengerInfoPage.fillFirstTravellerDetails("Morris", "Mano", "Male","", "237|US");
			test.log(LogStatus.INFO, "User enters \"Morris\" as First Traveller First Name");
			test.log(LogStatus.INFO, "User enters \"Mano\" as First Traveller Last Name");
	    	test.log(LogStatus.INFO, "User selects \"Gender:Male\" for First Traveller Last Name");
			test.log(LogStatus.INFO, "User selects \"DOB:01/01/1992\" for First Traveller's Date of Birth");
			test.log(LogStatus.INFO, "User selects \"Passport details as:US\" for First Traveller");
			expectedSecondTravellerInfo = passengerInfoPage.fillSecondTravellerDetailsChildMob("Shally", "Mano", "Female","01/01/1994", "237|US", "Child");
			test.log(LogStatus.INFO, "User enters \"Shally\" as Second Traveller First Name");
			test.log(LogStatus.INFO, "User enters \"Mano\" as Second Traveller Last Name");
			test.log(LogStatus.INFO, "User selects \"Female\" for Second Traveller Last Name");
			test.log(LogStatus.INFO, "User selects \"DOB:01/01/1994\" for Second Traveller's Date of Birth");
			test.log(LogStatus.INFO, "User selects \"Passport details as:US\" for Second Traveller");
			bookingPage.getTripinclusionContinueButton();
			boolean actual = passengerInfoPage.isErrorMessageDisplayed();
			Assert.assertTrue(actual);
			test.log(LogStatus.INFO, "User is not able to proceed with empty field in passenger details");
			//logs.info("User is not able to proceed with empty field in passenger details");
				
		
		
	}


	@Test(groups= {"smoke"},priority=6)
	public void TC_0006_bookingFlightsWithmultipleCities(Method method) throws Exception {
		ExtentTest test = ExtentTestManager.startTest(method.getName(), "bookingFlightsWithmultipleCities_TC_6");
		homePage.clickOnExploreAsiaLink();
		test.log(LogStatus.INFO, "User Clicks on Explore Asia Link");
		homePage.verifyHighLightsandAttractions();
		test.log(LogStatus.INFO, "Verify Highlights option is available");
		homePage.verifyfirsthighlightandAttraction();
		homePage.clickonFirstHighlight();
		homePage.clickOnMoreHighLight();
		test.log(LogStatus.INFO, "Verify First Highlight option available on page");
		homePage.clickonFirstHighlight();
		homePage.clickOnBuildYourOwnVacation();
		
		

		bookingPage.fillLeavingFromDetails("New York City (all Airports),  NY");
//		test.log(LogStatus.INFO, "User entered \"New York, Newark, NJ\" into leaving from field");
		bookingPage.fillGoingToCityDetails("Berlin (Germany)");
//		test.log(LogStatus.INFO, "User entered \"Berlin (Germany)\" into Going to from field");
		bookingPage.selectStayingTime("4");
		bookingPage.clickOnAddCityBtn();
		bookingPage.fillSecndAddedCityDetails("Frankfurt (Germany)");
		test.log(LogStatus.INFO, "User entered \"Frankfurt (Germany)\" into Going to from field");
		bookingPage.selectStayingTime("4");
		String date = bookingPage.selectValueFromCalendar(90 ,0);
		System.out.println("date is "+ date);
//		
		test.log(LogStatus.INFO,   "User selects '" + date + "'from calendar");

		bookingPage.selectNoMoreCitiesBtn();
		bookingPage.selectGuestDetails("1|1");
		
//		test.log(LogStatus.INFO, "Booking details filled successfully for multiple cities");
//		//Logs.info("Booking details filled successfully for multiple cities");
		bookingPage.clickonContinueButton();
		PageBase.waitForElement(3);
	//	test.log(LogStatus.INFO, "Click on Continue Button");
		bookingPage.clickOncheaperFlights();
		test.log(LogStatus.INFO, "User clicks on Select Cheaper Flights Link");
		bookingPage.selectOnCheaperFlightPage();
		bookingPage.selectCabin();
		test.log(LogStatus.INFO, "User selects a particular cabin from existing options");
		bookingPage.getTripinclusionContinueButton();
		bookingPage.getTripinclusionContinueButton();
		test.log(LogStatus.INFO, "User clicks on Continue Link");
		expectedFirstTravellerInfo = passengerInfoPage.fillFirstTravellerDetails("Morris", "Leo", "Male","01/01/1992", "237|US");
		test.log(LogStatus.INFO, "User enters \"Morris\" as First Traveller First Name");
		test.log(LogStatus.INFO, "User enters \"Mano\" as First Traveller Last Name");
		test.log(LogStatus.INFO, "User selects \"Gender:Male\" for First Traveller Last Name");
		test.log(LogStatus.INFO, "User selects \"DOB:01/01/1992\" for First Traveller's Date of Birth");
		test.log(LogStatus.INFO, "User selects \"Passport details as:US\" for First Traveller");
		
		bookingPage.getTripinclusionContinueButton();
		bookingPage.clicktoContinuePage();
				if(TestBase.flag_Mob){
			PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler1NameiOS(), expectedFirstTravellerInfo);
			//PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler2NameiOS(), expectedSecondTravellerInfo);
		}else{
			//PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler1Name(), expectedFirstTravellerInfo);
			//PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler2Name(), expectedSecondTravellerInfo);
		}
		test.log(LogStatus.INFO, "Flights & passenger details verified successfully on PaymentPage");
		
	}

	@Test(groups= {"smoke"},priority=7)
	public void TC_0007_bookingFlightAndHotelForSingleCity(Method method) throws Exception {
		ExtentTest test=ExtentTestManager.startTest(method.getName(), "TC_0007_bookingFlightAndHotelForSingleCity");
		homePage.topdeals();
		test.log(LogStatus.INFO, "User clicks on Top Deals");
		Thread.sleep(5000);
		homePage.validateTopDealsPage();
		test.log(LogStatus.INFO, "Verifies that User is on top deal page");
		homePage.validatetopDealsList();
		test.log(LogStatus.INFO, "Verifies the top deals list of the week");
		Thread.sleep(5000);
		homePage.clickOnCustomizeit();
		PageBase.scrollDown();

		bookingPage.fillLeavingFromDetails("New York City (all Airports),  NY");
		test.log(LogStatus.INFO, "User entered \"New York City (all Airports),  NY\" into leaving from field");

		String date = bookingPage.selectValueFromCalendar(180 ,1);
		
		
		test.log(LogStatus.INFO,   "User selects '" + date + "'from calendar");

		bookingPage.selectGuestDetails_dealsPage("2|Other");
		
		bookingPage.selectNumberOfChild_dealsPage("1", "11", "Child1");
		 bookingPage.selectNumberOfAdult("1", BookingLocators.getselectAdultRoom2Drpdown());
		 test.log(LogStatus.INFO, "Booking details filled successfully for Two Adults and One child");
		bookingPage.doneButtonMob();
		bookingPage.clickOnViewPrice();

		ActualHotel = bookingPage.browseHotelsButton();
		test.log(LogStatus.INFO, "Click on Browse Hotels Button");

		bookingPage.selectFirstHotel();

		ExpectedHotel = bookingPage.browseSelectHotel();
		test.log(LogStatus.INFO, "Select particular hotel from Hotel Options");

		bookingPage.clicktoContinuePage();
		
		bookingPage.clickOncheaperFlights();
		test.log(LogStatus.INFO, "User clicks on cheaper flight button");
		bookingPage.selectOnCheaperFlightPage();
		
		bookingPage.selectCabin();
		test.log(LogStatus.INFO, "User select the available cabin.");
		bookingPage.getTripinclusionContinueButton();

		
		
		bookingPage.getTripinclusionContinueButton();
		
		
		expectedFirstTravellerInfo = passengerInfoPage.fillTravellerDetailsForMultipleRooms("Room1Traveller1");
		test.log(LogStatus.INFO, "User enters \"yury\" as Traveller1 First Name");
	    test.log(LogStatus.INFO, "User enters \"darwin\" as Traveller1 Last Name");
		test.log(LogStatus.INFO, "User selects \"Gender:Male\" for Traveller1 ");
		test.log(LogStatus.INFO, "User selects \"DOB:01/01/2000\" for Traveller1 Date of Birth");
		test.log(LogStatus.INFO, "User selects \"Passport details as:US\" for Traveller1");
		expectedSecondTravellerInfo = passengerInfoPage.fillTravellerDetailsForMultipleRooms("Room1Child1SingleTravlr");
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
		bookingPage.getTripinclusionContinueButton();
		bookingPage.clicktoContinuePage();
		test.log(LogStatus.INFO, "Click on Continue Button & User redirected to the Payment Page");
		PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler1Name(), expectedFirstTravellerInfo);
		PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler2Name(), expectedSecondTravellerInfo);
		PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler3Name(), expectedThirdTravellerInfo);
		test.log(LogStatus.INFO, "Flights & passenger details verified successfully on PaymentPage");
		
		
		
		
		
		
		
	}
	
	@Test(groups= {"smoke"},priority=8)
	  public void TC_0008_europePageBookingForMultipleCities(Method method) throws Exception {
		ExtentTest test=ExtentTestManager.startTest(method.getName(), "europePageBookingForMultipleCities_TC_8");
		homePage.clickOnExploreEuropeLink();
		test.log(LogStatus.INFO, "User clicks on explore europe page link");
		 bookingPage.clickOnBuildYourVacationDropDown();
		 bookingPage.fillLeavingFromDetails("New York City (all Airports),  NY");
		 test.log(LogStatus.INFO, "User entered \"New York City (all Airports),  NY\" into leaving from field");
		
		 String date = bookingPage.selectValueFromCalendar(90 ,0);
			
			
			test.log(LogStatus.INFO,   "User selects '" + date + "'from calendar");
		 
		 bookingPage.fillGoingToCityDetails("Rome (Italy)");
		 test.log(LogStatus.INFO, "User entered \"Rome (Italy)\" into going to field");
		 
		 
		 bookingPage.selectStayingTime("4");
		 test.log(LogStatus.INFO, "User entered \"4\" nights staying time in Rome (Italy)");
		 bookingPage.clickOnAddCityBtn();
		 test.log(LogStatus.INFO, "User clicks on add city button for second city");
	  	 bookingPage.fillSecndAddedCityDetails("Florence (Italy)");
	  	test.log(LogStatus.INFO, "User entered \"Florence (Italy)\" into going to field");
	  	 bookingPage.selectStayingTimeTwo("4");
		 test.log(LogStatus.INFO, "User entered \"4\" nights staying time in Florence");
		 bookingPage.clickOnAddCityBtn();
		 bookingPage.fillThirdAddedCityDetails("Venice (Italy)");
		 test.log(LogStatus.INFO, "User entered \"Venice (Italy)\" into going to field");
		 bookingPage.selectStayingTimeThree("4");
		 test.log(LogStatus.INFO, "User entered \"4\" nights staying time in Venice (Italy)");
		 bookingPage.clickonContinue();
		 test.log(LogStatus.INFO, "Booking details filled successfully for multiple cities"); 
		 bookingPage.selectGuestDetails("2|Other");
		 bookingPage.selectNumberOfAdult("1", BookingLocators.getselectAdultDrpdown());
		 bookingPage.selectnumberofadultsRoom_1iOS();
		 bookingPage.selectNumberOfChild("1", "11", "Child1");
		 test.log(LogStatus.INFO, "No.of Child & Age of Child got selected successfully for first room");
		 bookingPage.selectNumberOfAdult("1", BookingLocators.getselectAdultRoom2Drpdown());
		 bookingPage.selectnumberofadultsRoom_2iOS();
		 test.log(LogStatus.INFO, "Passenger details for second room selected successfully");
		 bookingPage.doneButtonMob();
		 bookingPage.clickonContinueButton();
		 test.log(LogStatus.INFO, "User clicks on Continue Button");
		 ActualHotel = bookingPage.browseHotelsButton();
		 
	     ExpectedHotel = bookingPage.browseSelectHotel();
	     test.log(LogStatus.INFO, "User clicks on Browse Hotels Button for First city.");
	     System.out.println("actual = "+ActualHotel+"Expected = "+ExpectedHotel);
	     test.log(LogStatus.INFO, "Select particular hotel from Hotel Options");
			Assert.assertEquals(ActualHotel, ExpectedHotel);
			bookingPage.selectFirstHotel();
			PageBase.scrollDownForMob(1);
			
			expectedSecondcityHotel = bookingPage.browseHotelSecondCity();
			test.log(LogStatus.INFO, "User clicks on Browse Hotels Button for Second city.");
			bookingPage.selectFirstHotel();
			test.log(LogStatus.INFO, "Select particular hotel from Hotel Options for second City");
			
			bookingPage.clickOncheaperFlights();
			bookingPage.selectOnCheaperFlightPage();
			bookingPage.selectCabin();
			test.log(LogStatus.INFO, "User selects the available cabin");
			bookingPage.getTripinclusionContinueButton();

			actualsecondCityHotel = bookingPage.secondCityHotelName();
			PageBase.waitForElement(10);
			Assert.assertEquals(actualsecondCityHotel, expectedSecondcityHotel);
			bookingPage.getTripinclusionContinueButton();
			
			

			test.log(LogStatus.INFO, "Verifiy that only particular selected hotel appears along with passenger details");

			expectedFirstTravellerInfo = passengerInfoPage.fillTravellerDetailsForMultipleRooms("Room1Traveller1");
			test.log(LogStatus.INFO, "User enters \"yury\" as Traveller1 First Name");
		    test.log(LogStatus.INFO, "User enters \"darwin\" as Traveller1 Last Name");
			test.log(LogStatus.INFO, "User selects \"Gender:Male\" for Traveller1 ");
			test.log(LogStatus.INFO, "User selects \"DOB:01/01/2000\" for Traveller1 Date of Birth");
			test.log(LogStatus.INFO, "User selects \"Passport details as:US\" for Traveller1");
			expectedSecondTravellerInfo = passengerInfoPage.fillTravellerDetailsForMultipleRooms("Room1Child1SingleTravlr");
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
			bookingPage.getTripinclusionContinueButton();
			bookingPage.clicktoContinuePage();
			test.log(LogStatus.INFO, "Click on Continue Button & User redirected to the Payment Page");
			PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler1Name(), expectedFirstTravellerInfo);
			PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler2Name(), expectedSecondTravellerInfo);
			PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler3Name(), expectedThirdTravellerInfo);
			test.log(LogStatus.INFO, "Flights & passenger details verified successfully on PaymentPage");	  
	  }
	
	@Test(groups= {"smoke"},priority=21)
	public void TC_0021_tripSummarymultipleCities(Method method) throws Exception {
		ExtentTest test=ExtentTestManager.startTest(method.getName(), "TC_0021_tripSummarymultipleCities");
		bookingPage.clickOnBuildYourVacationDropDown();
		bookingPage.fillLeavingFromDetails("Washington (all Airports), DC");
		test.log(LogStatus.INFO, "User entered \"Washington (all Airports), DC\" into leaving from field");
		bookingPage.fillGoingToCityDetails("London (England)");
		test.log(LogStatus.INFO, "User entered \"London (England)\" into Going to from field");
		String date = bookingPage.selectValueFromCalendar(90 ,0);
		
		System.out.println("date is "+ date);	
			test.log(LogStatus.INFO,   "User selects '" + date + "'from calendar");
		
		
		
		bookingPage.selectStayingTime("3");
		bookingPage.clickOnAddCityBtn();
		bookingPage.fillSecndAddedCityDetails("Paris (France)");
		test.log(LogStatus.INFO, "User entered \"Paris (France)\" into Going to from field");
		bookingPage.clickOnAddCityBtn();
		bookingPage.fillThirdAddedCityDetails("Rome (Italy)");
		test.log(LogStatus.INFO, "User entered \"Rome (Italy)\" into Going to from field for adding third city");		
		bookingPage.selectStayingTimeThree("3");
		bookingPage.clickonContinue();
		test.log(LogStatus.INFO, "User is able to select multiple cities.");
		//bookingPage.selectNoMoreCitiesBtn();
		bookingPage.selectGuestDetails("1|2");
		bookingPage.clickonContinueButton();
		bookingPage.selectCheaperFlights();
		//bookingPage.tripSummary();
		bookingPage.validateTripPage();
		test.log(LogStatus.INFO, "Validate that user is on TripInclusion Page");
	
		
	}
	

	@Test(groups= {"smoke"},priority=17)
	public void TC_0017_removeAddedCity_WithAdditonalChanges(Method method) throws Exception {
		ExtentTest test=ExtentTestManager.startTest(method.getName(), "TC_0017_removeAddedCity_WithAdditonalChanges");
		homePage.clickOnExploreAsiaLink();
		
		bookingPage.clickOnBuildYourVacationDropDown();
		PageBase.waitForElement(3);
		bookingPage.fillLeavingFromDetails("New York City (all Airports),  NY");
		test.log(LogStatus.INFO, "User entered \"New York, Newark, NJ\" into leaving from field");
		bookingPage.fillGoingToCityDetails("Delhi (India)");
		
		 String date = bookingPage.selectValueFromCalendar(90 ,0);
			
		System.out.println("date is "+ date);	
			test.log(LogStatus.INFO,   "User selects '" + date + "'from calendar");
		
		
		
		test.log(LogStatus.INFO, "User entered \"Delhi (India)\" into Going to from field");
		bookingPage.selectStayingTime("4");
		test.log(LogStatus.INFO, "User entered \"4\" nights staying time");
		bookingPage.clickOnAddCityBtn();
		bookingPage.fillSecndAddedCityDetails("Mumbai (India)");
		test.log(LogStatus.INFO, "User entered \"Mumbai (India)\" into Going to from field for adding second city");
		bookingPage.selectStayingTimeTwo("1");
		test.log(LogStatus.INFO, "User entered \"1\" nights staying time for the second city");
		bookingPage.clickOnAddCityBtn();
		bookingPage.fillThirdAddedCityDetails("Chennai -Madras (India)");
		test.log(LogStatus.INFO, "User entered \"Chennai -Madras (India)\" into Going to from field for adding Third city");
		bookingPage.selectStayingTimeThree("1");
		test.log(LogStatus.INFO, "User entered \"1\" nights staying time for the third city");
		test.log(LogStatus.INFO, "Fill all the basic details for multiple cities");
		test.log(LogStatus.INFO, "Adding multiple cities in destinations");
		
		boolean actual = bookingPage.isremovecitydisplayed();
		Assert.assertTrue(actual);
		test.log(LogStatus.INFO,"Verify that multiple cities got selected as destinations");
		test.log(LogStatus.INFO, "Verify that RemoveCity Link is also displayed for added cities");

		bookingPage.deleteAddedCities();
		test.log(LogStatus.INFO, "Delete all the added cities");
		
		bookingPage.validateremovedcity();
		test.log(LogStatus.INFO, "All the added cities removed successfully.Verified!");
		//logs.info("All the added cities removed successfully.Verified!");
		bookingPage.clickOnAddCityBtn();
		test.log(LogStatus.INFO, "Click again to add city");
		//logs.info("Click again to add city");
		bookingPage.fillSecndAddedCityDetails("Mumbai (India)");
		test.log(LogStatus.INFO, "User entered \"Mumbai (India)\" into Going to from field");
		bookingPage.selectStayingTimeTwo("4");
		test.log(LogStatus.INFO, "User entered \"4\" nights staying time");
		PageBase.waitForElement(10);
		bookingPage.selectNoMoreCitiesBtn();
		Thread.sleep(50000);
		boolean actualresult = bookingPage.isTravelByDisplayed();
		Assert.assertTrue(actualresult);
		test.log(LogStatus.INFO,"Verify that Travel By option from one destination to other is displayed");
		bookingPage.selectGuestDetails("1|1");
		test.log(LogStatus.INFO, "Select Guest Details");
		bookingPage.clickonContinueButton();
		bookingPage.selectCheaperFlights();
		test.log(LogStatus.INFO, "Select Cheaper flights from flight options");
		//logs.info("Select Cheaper flights from flight options");
		bookingPage.validateTripPage();
		test.log(LogStatus.INFO, "Validate that user is on TripInclusion Page");
		//logs.info("Validate that user is on TripInclusion Page");
	}
	
	
	
	
	

	
	@Test(groups= {"regression"},priority=14)
	public void TC_0014_verifySpotlightLink(Method method) throws Exception {
    	String PageTitle=null;
		ExtentTest test=ExtentTestManager.startTest(method.getName(), "TC_0014_verifySpotlightLink");
		bookingPage.selectLatinAmericaLink();
		test.log(LogStatus.INFO, "Select Latin America Link");
		
		bookingPage.verifyLatinAmericPage();
		test.log(LogStatus.INFO, "User redirected to the Latin America Page");
		bookingPage.verifyLatinAmericPage();
		test.log(LogStatus.INFO, "User redirected to the Latin America Page");
		//Logs.info("User redirected to the Latin America Page");
		bookingPage.clickOnSpotlightOnDrpDwnForMob();
		test.log(LogStatus.INFO, "Spotlight link verified!");
		test.log(LogStatus.INFO, "User clicks on Spotlight button");
		
		String title=bookingPage.clickOnFirstOptionUnderSpotlightForMob();
		test.log(LogStatus.INFO, "User clicks on Spotlight button");
		bookingPage.verifyPageDisplayed(title);
		//Logs.info("User clicks on Spotlight button");		
		test.log(LogStatus.INFO, "Spotlight link verified!");
        //Logs.info("Spotlight link verified!");

	}
	
	
	

	
    @Test(groups= {"regression"},priority=9)
	public void TC_0009_arrival_dateChanging(Method method) throws Exception {
		ExtentTest test=ExtentTestManager.startTest(method.getName(), "verify DateChanging functionality");
		bookingPage.clickOnBuildYourVacationDropDown();
		bookingPage.fillLeavingFromDetails("New York, Newark, NJ");
		test.log(LogStatus.INFO, "User entered \"New York, Newark, NJ\" into leaving from field");
		bookingPage.fillGoingToCityDetails("Berlin (Germany)");
		test.log(LogStatus.INFO, "User entered \"Berlin (Germany)\" into Going to from field");
		String date = bookingPage.selectValueFromCalendar(180 ,2);
		
		
		test.log(LogStatus.INFO,   "User selects '" + date + "'from calendar");
		bookingPage.selectStayingTime("12");
		bookingPage.selectNoMoreCitiesBtn();
		bookingPage.selectGuestDetails("1|Other");
		test.log(LogStatus.INFO, "Booking details Source & Destination filled successfully ");
		
		bookingPage.clickonContinueButton();
		bookingPage.clickChangedArriveDate();
		bookingPage.oldArriveDate();
		bookingPage.clickonContinueLink();
		test.log(LogStatus.INFO,   "Arrival date changes successfully.");
		bookingPage.getTripinclusionContinueButton();
		bookingPage.clicktoContinuePage();
		expectedFirstTravellerInfo = passengerInfoPage.fillFirstTravellerDetails("Morris", "Leo", "Male","01/01/1992", "237|US");
		test.log(LogStatus.INFO, "User enters \"Morris\" as First Traveller First Name");
		test.log(LogStatus.INFO, "User enters \"Mano\" as First Traveller Last Name");
		test.log(LogStatus.INFO, "User selects \"Gender:Male\" for First Traveller Last Name");
		test.log(LogStatus.INFO, "User selects \"DOB:01/01/1992\" for First Traveller's Date of Birth");
		test.log(LogStatus.INFO, "User selects \"Passport details as:US\" for First Traveller");
		expectedSecondTravellerInfo = passengerInfoPage.fillSecondTravellerDetails("Shally", "Leo", "Male","01/01/1994", "237|US", "Child");
		test.log(LogStatus.INFO, "User enters \"Shally\" as Second Traveller First Name");
		test.log(LogStatus.INFO, "User enters \"Mano\" as Second Traveller Last Name");
		test.log(LogStatus.INFO, "User selects \"Female\" for Second Traveller Last Name");
		test.log(LogStatus.INFO, "User selects \"DOB:01/01/1994\" for Second Traveller's Date of Birth");
		test.log(LogStatus.INFO, "User selects \"Passport details as:US\" for Second Traveller");
		test.log(LogStatus.INFO, "User filled all the passenger details successfully");
		//Logs.info("User filled all the passenger details successfully");
		
		bookingPage.clicktoContinuePage();
		bookingPage.getTripinclusionContinueButton();
		if(TestBase.flag_Mob){
			PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler1NameiOS(), expectedFirstTravellerInfo);
			PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler2NameiOS(), expectedSecondTravellerInfo);
		}else{
		PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler1Name(), expectedFirstTravellerInfo);
		PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler2Name(), expectedSecondTravellerInfo);
		}
		test.log(LogStatus.INFO, "Flights & passenger details verified successfully on PaymentPage");
		//Logs.info("Flights & passenger details verified successfully on PaymentPage");
		bookingPage.tripSummary();
	}

  @Test(groups= {"smoke"},priority=18)
		public void TC_0018_bookingDetailswithPremiumEcomomy(Method method) throws Exception {
		   ExtentTest test =ExtentTestManager.startTest(method.getName(), "TC_0018_bookingDetailswithPremiumEcomomy");
			bookingPage.clickOnBuildYourVacationDropDown();
			bookingPage.selectCabinClass("Premium Economy");
			bookingPage.fillLeavingFromDetails("New York City (all Airports)");
			test.log(LogStatus.INFO, "User entered \"New York City (all Airports)\" into leaving from field");
			bookingPage.fillGoingToCityDetails("Delhi (India)");
			test.log(LogStatus.INFO, "User entered \"Delhi (India)\" into Going to from field");
			bookingPage.selectStayingTime("4");
			bookingPage.selectNoMoreCitiesBtn();
			bookingPage.selectGuestDetails("1|1");
			String actualcabin =bookingPage.selectPremiumEconomy();
			System.out.println("This is for Actual "+actualcabin);
			bookingPage.doneButtonMob();
			test.log(LogStatus.INFO, "Filled flights details with premium economy");
			//Logs.info("Filled flights details with premium economy");
			String actualcabinweb = bookingPage.selectedcabinAssert();
			test.log(LogStatus.INFO, "Select Cabin class");
			//Logs.info("Select Cabin class");
			if(TestBase.flag_Mob){
			  boolean cabinVerify = bookingPage.verifyCabin();
				   Assert.assertTrue(cabinVerify);
				   }
			test.log(LogStatus.INFO, "Selected Cabin class verified");
			//Logs.info("Selected Cabin class verified");
			bookingPage.clickonContinueButton();
			bookingPage.selectCheaperFlights();
			test.log(LogStatus.INFO, "Select Cheaper flights from flight options");
			
			test.log(LogStatus.INFO, "bookingDetailswithPremiumEcomomy passed");
			//Logs.info("bookingDetailswithPremiumEcomomy passed");
		}
		
}
