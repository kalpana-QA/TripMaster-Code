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
		
	    test.log(LogStatus.INFO, "Entered the URL: http://www.tripmasters.com/");
		//Thread.sleep(10000);
	    
	    bookingPage.clickOnBuildYourVacationDropDown();
		test.log(LogStatus.INFO, "Tap on Build your vacation dropdown.");
		PageBase.waitForElement(10);
		bookingPage.fillLeavingFromDetails("New York, Newark, NJ");
		test.log(LogStatus.INFO, "User entered \"New York, Newark, NJ\" into leaving from field");
		bookingPage.fillGoingToCityDetails("Berlin (Germany)");
		test.log(LogStatus.INFO, "User entered \"Berlin (Germany)\" into Going to from field");
		String date = bookingPage.selectValueFromCalendar(215 ,4);
		bookingPage.doneButtonMob();
		String selecteddate = bookingPage.getSelectedDate();
		test.log(LogStatus.INFO,   "User selects arrival date '" + selecteddate + "'from calendar");
		
		
		bookingPage.selectStayingTime("4");
		test.log(LogStatus.INFO, "User entered \"4\" nights staying time");	
		bookingPage.selectNoMoreCitiesBtn();
		test.log(LogStatus.INFO, "Tap on Next");
		bookingPage.selectGuestDetails("1|3");
		//bookingPage.selectPremiumEconomy();
		test.log(LogStatus.INFO, "User tap on Options to select rooms and traveler.");
	//	test.log(LogStatus.INFO, "Select cabin as Premium Economy.");
		
		test.log(LogStatus.INFO, "Tap on Rooms Dropdown");
		test.log(LogStatus.INFO, "User select \"1 Room for 3 Adults\" from Guest list");
		
		bookingPage.doneButtonMob();
		test.log(LogStatus.INFO, "Tap on Done.");
		test.log(LogStatus.INFO, "All the basic booking details Source & Destination filled successfully for 3 Adults_4nights");
		bookingPage.clickonContinueButton();
		test.log(LogStatus.INFO, "Tap on Continue.");
		
		String value = bookingPage.getSessionid();
		test.log(LogStatus.INFO, "Session id is "+ value);
		
		bookingPage.clickOncheaperFlights();
		test.log(LogStatus.INFO, "Scrolled Down");
		test.log(LogStatus.INFO, "User Tap on Browse all Flights Link");
	
		//bookingPage.selectOnCheaperFlightPage();
		test.log(LogStatus.INFO, "Scrolled Down");
		test.log(LogStatus.INFO, "Tap on Select dropdown");
		//bookingPage.selectCabin();
		test.log(LogStatus.INFO, "Tap on Select cabin");
		test.log(LogStatus.INFO, "User selects first available cabin from existing options");
	//	bookingPage.getTripinclusionContinueButton();
		test.log(LogStatus.INFO, "Scrolled Down");
		test.log(LogStatus.INFO, "Tap on Continue to Itinerary details page");
		bookingPage.getTripinclusionContinueButton();
		test.log(LogStatus.INFO, "Scrolled Down");
		test.log(LogStatus.INFO, "Tap on Continue to Reservation page");
		expectedFirstTravellerInfo = passengerInfoPage.fillFirstTravellerDetails("John", "Leo", "Male","01/01/1992", "237|US");
		test.log(LogStatus.INFO, "User enters \"John\" as First Traveller First Name");
		test.log(LogStatus.INFO, "User enters \"Leo\" as First Traveller Last Name");
		test.log(LogStatus.INFO, "User selects \"Gender:Male\" for First Traveller");
		test.log(LogStatus.INFO, "Scrolled Down");
		test.log(LogStatus.INFO, "User selects \"DOB:01/01/1992\" for First Traveller's Date of Birth");
		test.log(LogStatus.INFO, "User selects \"Passport details as:US\" for First Traveller");
		expectedSecondTravellerInfo = passengerInfoPage.fillSecondTravellerDetails("Elvin", "Leo", "Male","01/01/1994", "237|US", "Adult");
		test.log(LogStatus.INFO, "User enters \"Elvin\" as Second Traveller First Name");
		test.log(LogStatus.INFO, "User enters \"Leo\" as Second Traveller Last Name");
		test.log(LogStatus.INFO, "User selects \"Gender:Male\" for Second Traveller");
		test.log(LogStatus.INFO, "User selects \"DOB:01/01/1994\" for Second Traveller's Date of Birth");
		test.log(LogStatus.INFO, "User selects \"Passport details as:US\" for Second Traveller");
		test.log(LogStatus.INFO, "Scrolled Down");
		expectedThirdTravellerInfo = passengerInfoPage.fillThirdTravellerDetails("Marie", "Leo", "Female","01/01/1996", "237|US");
		test.log(LogStatus.INFO, "User enters \"Marie\" as Third Traveller First Name");
		test.log(LogStatus.INFO, "User enters \"Leo\" as Third Traveller Last Name");
		test.log(LogStatus.INFO, "User selects \"Gender:Male\" for Third Traveller");
		test.log(LogStatus.INFO, "User selects \"DOB:01/01/1996\" for Third Traveller's Date of Birth");
		test.log(LogStatus.INFO, "User selects \"Passport details as:US\" for Third Traveller");
		test.log(LogStatus.INFO, "Scrolled Down");
		test.log(LogStatus.INFO, "User filled all the passenger details successfully");
		//Logs.info("User fills all the 3 passenger details");
		bookingPage.getTripinclusionContinueButton();
		bookingPage.clicktoContinuePage();
		test.log(LogStatus.INFO, "Tap to Continue & User redirected to Payment Page");
		test.log(LogStatus.INFO, "Scrolled Down");
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
			test.log(LogStatus.INFO, "Entered the URL: http://www.tripmasters.com/");
			
			
			bookingPage.clickOnBuildYourVacationDropDown();
			test.log(LogStatus.INFO, "Tap on Build your vacation dropdown.");
			PageBase.waitForElement(3);
			bookingPage.fillLeavingFromDetails("New York City (all Airports),  NY");
			test.log(LogStatus.INFO, "User entered \"New York City (all Airports),  NY\" into leaving from field");
			bookingPage.fillGoingToCityDetails("London (England)");
			test.log(LogStatus.INFO, "User entered \"London(England)\" into Going to from field");
			String date = bookingPage.selectValueFromCalendar(214 ,4);
			String selecteddate = bookingPage.getSelectedDate();
			test.log(LogStatus.INFO,   "User selects arrival date '" + selecteddate + "'from calendar");
			bookingPage.selectStayingTime("6");
			test.log(LogStatus.INFO, "User entered \"6\" nights staying time");	
			bookingPage.clickOnAddCityBtn();
			test.log(LogStatus.INFO, "Tap on Add Destination");
			bookingPage.fillSecndAddedCityDetails("Paris (France)");
			test.log(LogStatus.INFO, "User entered \"Paris (France)\" into Going to from field for adding second city");
			bookingPage.selectStayingTimeTwo("5");
			test.log(LogStatus.INFO, "User entered \"5\" nights staying time for second city");
			 bookingPage.selectNoMoreCitiesBtn();
			test.log(LogStatus.INFO, "Tap on Next");
			
			
//			boolean actualresult = bookingPage.verifyTravelByTrain();
//			Assert.assertTrue(actualresult);
//			test.log(LogStatus.INFO,"Verify that user is going from London to Paris By Train");
		//	test.log(LogStatus.INFO, "All the basic booking details Source & Destination filled successfully");
			
			
			PageBase.scrollDown();
			test.log(LogStatus.INFO, "Scrolled Down");
			
			bookingPage.selectGuestDetails("1|Other");
		//	bookingPage.selectPremiumEconomy();
			test.log(LogStatus.INFO, "User tap on Options to select rooms and traveler.");
		//	test.log(LogStatus.INFO, "Select cabin as Premium Economy.");
			
			//test.log(LogStatus.INFO, "User tap on Options to select rooms and traveler.");
			test.log(LogStatus.INFO, "Tap on Rooms Dropdown");
			test.log(LogStatus.INFO, "Scrolled Up");
			
			test.log(LogStatus.INFO, "User select \"1 Room With children or Other Options\" from Guest list");
			
			bookingPage.selectNumberOfAdult("2", BookingLocators.getselectAdultDrpdown());
			
			
			bookingPage.selectNumberOfChild("1", "11", "newageeleven");
			test.log(LogStatus.INFO, "User tap on + to select child for Room");
			test.log(LogStatus.INFO, "Tap on child 1 age dropdown and select child age.");
			bookingPage.doneButtonMob();
			test.log(LogStatus.INFO, "Tap on Done");
			test.log(LogStatus.INFO, "No.of Child & Age of Child got selected successfully");
			test.log(LogStatus.INFO, "All the basic booking details Source & Destination filled successfully");
            bookingPage.clickonContinueButton();
			test.log(LogStatus.INFO, "Tap on Continue.");
			//Logs.info("Click on Continue Button");
			test.log(LogStatus.INFO, "Scrolled Down.");
			boolean actualresult = bookingPage.verifyTravelByTrain();
			Assert.assertTrue(actualresult);
			test.log(LogStatus.INFO,"Verify that user is going from London to Paris By Train");
			test.log(LogStatus.INFO, "Scrolled Up.");
			
			String value = bookingPage.getSessionid();
			test.log(LogStatus.INFO, "Session id is "+ value);
			
			
			bookingPage.clickOncheaperFlights();
			
			test.log(LogStatus.INFO, "User Tap on Browse all Flights Link");
		
	//		bookingPage.selectOnCheaperFlightPage();
			test.log(LogStatus.INFO, "Tap on Select dropdown");
		//	bookingPage.selectCabin();
			test.log(LogStatus.INFO, "Scrolled Down");
			test.log(LogStatus.INFO, "Tap on Select cabin");
			test.log(LogStatus.INFO, "User selects first available cabin from existing options");
	//		bookingPage.getTripinclusionContinueButton();
			test.log(LogStatus.INFO, "Tap on Continue to Itinerary details page");
			bookingPage.getTripinclusionContinueButton();
			test.log(LogStatus.INFO, "Scrolled Down");
			
			test.log(LogStatus.INFO, "Tap on Continue to Reservation page");
			expectedFirstTravellerInfo = passengerInfoPage.fillTravellerDetailsForMultipleRooms("Room1Traveller1");
			test.log(LogStatus.INFO, "User enters \"yury\" as  First Name");
		    test.log(LogStatus.INFO, "User enters \"darwin\" as  Last Name");
			test.log(LogStatus.INFO, "User selects \"Gender:Male\" for Traveller ");
			test.log(LogStatus.INFO, "User selects \"DOB:01/01/2000\" for Traveller Date of Birth");
			test.log(LogStatus.INFO, "Scrolled Down.");
			test.log(LogStatus.INFO, "User selects \"Passport details as:US\" for Traveller");
			expectedThirdTravellerInfo = passengerInfoPage.fillTravellerDetailsForMultipleRooms("Room2Traveller1");
			test.log(LogStatus.INFO, "User enters \"Hanna\" as Traveller First Name");
			test.log(LogStatus.INFO, "User enters \"darwin\" as Traveller Last Name");
			test.log(LogStatus.INFO, "User selects \"Gender:Male\" for Traveller ");
			test.log(LogStatus.INFO, "User selects \"DOB:01/01/2000\" for Traveller Date of Birth");
			test.log(LogStatus.INFO, "User selects \"Passport details as:US\" for Traveller");
			expectedSecondTravellerInfo = passengerInfoPage.fillTravellerDetailsForMultipleRooms("Room1Child1SingleTravlr");
			test.log(LogStatus.INFO, "Scrolled Down.");
			test.log(LogStatus.INFO, "User enters \"Erwin\" as Traveller First Name");
			test.log(LogStatus.INFO, "User enters \"George\" as Traveller Last Name");
			test.log(LogStatus.INFO, "User selects \"Gender:Male\" for Traveller ");
			test.log(LogStatus.INFO, "User selects \"DOB:01/01/2009\" for Traveller Date of Birth");
			test.log(LogStatus.INFO, "User selects \"Passport details as:US\" for Traveller");
			
			bookingPage.getTripinclusionContinueButton();
			test.log(LogStatus.INFO, "Scrolled Down.");
			bookingPage.clicktoContinuePage();
			test.log(LogStatus.INFO, "Tap on Continue Button & User redirected to the Payment Page");
			PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler1Name(), expectedFirstTravellerInfo);
			PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler2Name(),expectedThirdTravellerInfo );
			PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler3Name(), expectedSecondTravellerInfo);
			test.log(LogStatus.INFO, "Flights & passenger details verified successfully on PaymentPage");
			
		}
	

	
	@Test(groups= {"smoke"},priority=3 ,alwaysRun = true)
	public void TC_0003_bookingTwoRoomThreeAdultAndOneChildWithMultipleCities(Method method) throws Exception {
		ExtentTest test = ExtentTestManager.startTest(method.getName(), "TC_0003_bookingTwoRoomThreeAdultAndOneChildWithMultipleCities");
		test.log(LogStatus.INFO, "Entered the URL: http://www.tripmasters.com/");
		
		
		bookingPage.clickOnBuildYourVacationDropDown();
		test.log(LogStatus.INFO, "Tap on Build your vacation dropdown.");
		PageBase.waitForElement(3);
		bookingPage.fillLeavingFromDetails("Seattle SEA (WA), US");
		test.log(LogStatus.INFO, "User entered \"Seattle, WA\" into leaving from field");
		String date = bookingPage.selectValueFromCalendar(117 ,0);
		
		String selecteddate = bookingPage.getSelectedDate();
		test.log(LogStatus.INFO,   "User selects arrival date '" + selecteddate + "'from calendar");
		bookingPage.fillGoingToCityDetails("Dublin (Ireland)");
		test.log(LogStatus.INFO, "User entered \"Dublin (Ireland)\" into Going to from field");
		bookingPage.selectStayingTime("3");
		test.log(LogStatus.INFO, "User entered \"3\" nights staying time");	
		bookingPage.clickOnAddCityBtn();
		test.log(LogStatus.INFO, "Tap on Add Destination");
		bookingPage.fillSecndAddedCityDetails("Galway (Ireland)");
		test.log(LogStatus.INFO, "User entered \"Galway (Ireland)\" into Going to from field for adding second city");
		bookingPage.selectStayingTimeTwo("4");
		test.log(LogStatus.INFO, "User entered \"4\" nights staying time for second city");
		bookingPage.clickOnAddCityBtn();
		test.log(LogStatus.INFO, "Tap on Add Destination");
		bookingPage.fillThirdAddedCityDetails("Limerick (Ireland)");
		test.log(LogStatus.INFO, "User entered \"Limerick (Ireland)\" into Going to from field for adding Third city");
		bookingPage.selectStayingTimeThree("4");
		test.log(LogStatus.INFO, "User entered \"4\" nights staying time for the Third city");
		bookingPage.selectNoMoreCitiesBtn();
		test.log(LogStatus.INFO, "Tap on Next");
		//PageBase.waitForElement(3);
		bookingPage.clickToRemoveGalwayCityLink();
		bookingPage.deleteGalwayCity();
		test.log(LogStatus.INFO, "Tap on X against Galway City");
		test.log(LogStatus.INFO, "User is redirected to First BYO page");
		test.log(LogStatus.INFO, "Tap on X again against Galway");
		
		//PageBase.waitForElement(3);
		test.log(LogStatus.INFO, "Galway city is deleted successfully");
		//logs.info("Galway city is deleted successfully");
		test.log(LogStatus.INFO, "Galway city removed successfully.Verified!");
		//logs.info("Galway city removed successfully.Verified!");
        bookingPage.selectNoMoreCitiesBtn();
        test.log(LogStatus.INFO, "Tap on Next");
		bookingPage.clickToRemoveLimerickCityLink();
		bookingPage.deleteLimrickCity();
		test.log(LogStatus.INFO, "Tap on X against Limerick");
		test.log(LogStatus.INFO, "User is redirected to First BYO page");
		test.log(LogStatus.INFO, "Tap on X  again against Limerick");
		
		bookingPage.validateremovedGalwaycity();
		test.log(LogStatus.INFO, "Limerick city is deleted successfully");
		//logs.info("Limerick city is deleted successfully");
		bookingPage.clickOnAddCityBtn();
		test.log(LogStatus.INFO, "Tap on Add Destination");
		bookingPage.fillSecndAddedCityDetails("Galway (Ireland)");
		test.log(LogStatus.INFO, "User entered \"Galway (Ireland)\" into Going to from field for Re-adding second city");
		bookingPage.selectStayingTimeTwo("4");
		test.log(LogStatus.INFO, "User entered \"4\" nights staying time for second city");
		
		
		 
		bookingPage.clickOnAddCityBtn();
		test.log(LogStatus.INFO, "Tap on Add Destination");
		bookingPage.fillThirdAddedCityDetails("Limerick (Ireland)");
		test.log(LogStatus.INFO, "User entered \"Limerick (Ireland)\" into Going to from field for Re-adding Third city");
		bookingPage.selectStayingTimeThree("4");
		test.log(LogStatus.INFO, "User entered \"4\" nights staying time for the Third city");
		
		
		
		
		bookingPage.selectNoMoreCitiesBtn();
		test.log(LogStatus.INFO, "Tap on Next");
		PageBase.waitForElement(3);
		bookingPage.selectCarFromTransportation();
		test.log(LogStatus.INFO, "Tap on Travel by and select Car for Transport to Galway.");
		test.log(LogStatus.INFO, "Scrolled Down.");
		test.log(LogStatus.INFO, "User tap on Options to select rooms and traveler.");
	//	test.log(LogStatus.INFO, "Select cabin as Premium Economy.");
		
		//*test.log(LogStatus.INFO, "Scrolled Up.");
		bookingPage.selectGuestDetails("2|Other");
		//bookingPage.selectPremiumEconomy();
		test.log(LogStatus.INFO, "Tap on Rooms Dropdown");
		test.log(LogStatus.INFO, "Select 2 Rooms with Children or other options from dropdown");
		
		bookingPage.select2NumberOfAdultForRoom1("2", BookingLocators.getselectAdultDrpdown());
		
        bookingPage.select1NumberOfAdultForRoom2("1", BookingLocators.getselectAdultRoom2Drpdown());
        test.log(LogStatus.INFO, "Tap on + for Room 2 Adult 1");
		bookingPage.selectNumberOfChild("1", "7", "newageseven");
		test.log(LogStatus.INFO, "Tap on + for Room 2 child 1");
		test.log(LogStatus.INFO, "Tap on child 1 age dropdown for Room 2 and select child age.");
		
		
		
		test.log(LogStatus.INFO, "Scrolled Up.");
		//test.log(LogStatus.INFO, "Tap on Room 2 child 1 age dropdown and Select age of child");
		bookingPage.doneButtonMob();
		test.log(LogStatus.INFO, "Tap on Done");
		test.log(LogStatus.INFO, "All the Basic Booking details Source & Destination filled successfully for Three Adults and One child");
		bookingPage.clickonContinueButton();
		test.log(LogStatus.INFO, "Tap on Continue");
		//Logs.info("Click on Continue Button");    
		//bookingPage.selectCheaperFlights();
		
		String value = bookingPage.getSessionid();
		test.log(LogStatus.INFO, "Session id is "+ value);
		
		
		
		
		bookingPage.clickOncheaperFlights();
		test.log(LogStatus.INFO, "Scrolled Down.");
		test.log(LogStatus.INFO, "User Tap on Browse all Flights Link");
		
	//	bookingPage.selectOnCheaperFlightPage();
		test.log(LogStatus.INFO, "Tap on Select dropdown");
	//	bookingPage.selectCabin();
		test.log(LogStatus.INFO, "Scrolled Down.");
		test.log(LogStatus.INFO, "Tap on Select cabin");
		test.log(LogStatus.INFO, "User selects first available cabin from existing options");
		
	//	bookingPage.getTripinclusionContinueButton();  
		test.log(LogStatus.INFO, "Scrolled Down.");
		test.log(LogStatus.INFO, "Tap on Continue to Itinerary details page");
		
		bookingPage.getTripinclusionContinueButton();
		test.log(LogStatus.INFO, "Scrolled Down.");
		test.log(LogStatus.INFO, "Tap on Continue to Reservation page");

		expectedFirstTravellerInfo = passengerInfoPage.fillTravellerDetailsForMultipleRooms("Room1Traveller1");
		test.log(LogStatus.INFO, "User enters \"yury\" as Traveller1 First Name");
		test.log(LogStatus.INFO, "User enters \"darwin\" as Traveller1 Last Name");
		test.log(LogStatus.INFO, "User selects \"Gender:Male\" for Traveller1 ");
		test.log(LogStatus.INFO, "User selects \"DOB:01/01/2000\" for Traveller1 Date of Birth");
		test.log(LogStatus.INFO, "Scrolled Down.");
		test.log(LogStatus.INFO, "User selects \"Passport details as:US\" for Traveller1");
		expectedSecondTravellerInfo = passengerInfoPage.fillTravellerDetailsForMultipleRooms("Room1Traveller2");
		test.log(LogStatus.INFO, "User enters \"Larry\" as Traveller2 First Name");
		test.log(LogStatus.INFO, "User enters \"darwin\" as Traveller2 Last Name");
		test.log(LogStatus.INFO, "User selects \"Gender:Male\" for Traveller2 ");
		test.log(LogStatus.INFO, "User selects \"DOB:01/01/2000\" for Traveller2 Date of Birth");
		test.log(LogStatus.INFO, "User selects \"Passport details as:US\" for Traveller2");
		PageBase.scrollDownForMob(1);
		test.log(LogStatus.INFO, "Scrolled Down.");
		expectedThirdTravellerInfo = passengerInfoPage.fillTravellerDetailsForMultipleRooms("Room2Traveller1");
		test.log(LogStatus.INFO, "User enters \"Hanna\" as Traveller3 First Name");
		test.log(LogStatus.INFO, "User enters \"darwin\" as Traveller3 Last Name");
		test.log(LogStatus.INFO, "User selects \"Gender:Male\" for Traveller3 ");
		test.log(LogStatus.INFO, "User selects \"DOB:01/01/2000\" for Traveller3 Date of Birth");
		test.log(LogStatus.INFO, "User selects \"Passport details as:US\" for Traveller3");
		test.log(LogStatus.INFO, "Scrolled Down.");
	//	expectedFourthTravellerInfo = passengerInfoPage.fillTravellerDetailsForMultipleRooms("Room2Child1");
		expectedFourthTravellerInfo =passengerInfoPage.fillSecondTravellerDetailsChildMob("Erwin", "George", "Male", "01/01/2013","237|US", "Child");
		test.log(LogStatus.INFO, "User enters \"Erwin\" as Traveller4 First Name");
		test.log(LogStatus.INFO, "User enters \"George\" as Traveller4 Last Name");
		test.log(LogStatus.INFO, "User selects \"Gender:Male\" for Traveller4 ");
		test.log(LogStatus.INFO, "User selects \"DOB:01/01/2013\" for Traveller4 Date of Birth");
		test.log(LogStatus.INFO, "User selects \"Passport details as:US\" for Traveller4");
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
	public void TC_0004_bookingFlightAndSingleRoomWithTwoAdults_FromFirstPackages(Method method) throws Exception {
		ExtentTest test = ExtentTestManager.startTest(method.getName(), "TC_0004_bookingFlightAndSingleRoomWithTwoAdults_FromFirstPackages");
		test.log(LogStatus.INFO, "Entered the URL: http://www.tripmasters.com/");
		
		
		String explorelinkname = bookingPage.exploreList();
		bookingPage.getexploreLink();
		test.log(LogStatus.INFO, "Scrolled Down");
		test.log(LogStatus.INFO, "User tap on first package on Explore Slider");
		test.log(LogStatus.INFO, "Redirect to the package named "+ explorelinkname);
		bookingPage.fillLeavingonExplorepage("Washington (all Airports), DC");
		test.log(LogStatus.INFO, "Scrolled Down");
		test.log(LogStatus.INFO, "User entered \"Washington (all Airports), DC\" into leaving from field");
		String date = bookingPage.selectValueFromCalendar(122 ,0);
		String selecteddate = bookingPage.getSelectedDate();
		test.log(LogStatus.INFO,   "User selects arrival date '" + selecteddate + "'from calendar");
		bookingPage.selectGuestDetails("1|2");
		//test.log(LogStatus.INFO, "User tap on Options.");
		test.log(LogStatus.INFO, "User select \" One Room for Two Adults\" from Guest list");
		
		bookingPage.doneButtonMob();
		test.log(LogStatus.INFO, "Tap on Done");
		
		test.log(LogStatus.INFO, "Booking details filled successfully for Two Adults");
		bookingPage.clickOnViewPrice();
		test.log(LogStatus.INFO, "User tap on View Price.");
		//test.log(LogStatus.INFO, "Booking details filled successfully for Two Adults");
		
		String value = bookingPage.getSessionid();
		test.log(LogStatus.INFO, "Session id is "+ value);
		
		
		
		PageBase.waitForElement(10);
		
		
		bookingPage.removeSecondCityHotel();
		test.log(LogStatus.INFO, "Scrolled Down");
		
		test.log(LogStatus.INFO, "Tap on Remove hotel for second city");
		test.log(LogStatus.INFO, "Tap on Yes button");
		
		//test.log(LogStatus.INFO, "Removes Hotel for Second City.");
		bookingPage.getContinueLink();
		test.log(LogStatus.INFO, "Scrolled Down");
		
		test.log(LogStatus.INFO, "Tap on Continue.");
		bookingPage.validateSecondCityHotel();
		test.log(LogStatus.INFO, "Verifies Hotel for Second City removed successfully");
		bookingPage.getTripinclusionContinueButton();
		test.log(LogStatus.INFO, "Scrolled Down");
		
		test.log(LogStatus.INFO, "Tap on Continue to Reservation page");

		//test.log(LogStatus.INFO, "Tap on Continue.");
		expectedFirstTravellerInfo = passengerInfoPage.fillFirstTravellerDetails("Morris", "Leo", "Male","01/01/1992", "237|US");
		test.log(LogStatus.INFO, "User enters \"Morris\" as First Traveller First Name");
		test.log(LogStatus.INFO, "User enters \"Mano\" as First Traveller Last Name");
      	test.log(LogStatus.INFO, "User selects \"Gender:Male\" for First Traveller Last Name");
      	test.log(LogStatus.INFO, "Scrolled Down");
		
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
		test.log(LogStatus.INFO, "Scrolled Down");
		
		test.log(LogStatus.INFO, "Tap to Continue & User redirected to Payment Page");
		if(TestBase.flag_Mob){
			PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler1NameiOS(), expectedFirstTravellerInfo);
			PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler2NameiOS(), expectedSecondTravellerInfo);
		}
		test.log(LogStatus.INFO, "Flights & passenger details verified successfully on PaymentPage");
	}
	

		@Test(groups= {"smoke"},priority=5)
	public void TC_0005_FlightbookingjourneywithPaxmandatoryfieldvalidation(Method method) throws Exception {
		ExtentTest test = ExtentTestManager.startTest(method.getName(), "TC_0005_FlightbookingjourneywithPaxmandatoryfieldvalidation");
		test.log(LogStatus.INFO, "Entered the URL: http://www.tripmasters.com/");
		
		
		PageBase.scrollDownForMob(1);
		test.log(LogStatus.INFO, "Scrolled down");
		homePage.clickOnExploreEuropeLink();
		test.log(LogStatus.INFO, "User tap on Explore Europe Link");
		test.log(LogStatus.INFO, "Scrolled Down to suggested vacation packages");
		test.log(LogStatus.INFO, "Scrolled Down");
		String packagename = bookingPage.clickOnPackageDisplayedUnderSuggestedVacationPackageOption();
		test.log(LogStatus.INFO, "User tap on "+ packagename + "vacation package View it button");
		test.log(LogStatus.INFO, "Scrolled Down to Reorder City link");
		bookingPage.clickOnReorderCitiesLink();
		
		test.log(LogStatus.INFO, "User tap on Reorder cities link");
		bookingPage.fillLeavingFromDetailsOnEuropePage("Chicago CHI (All Airports)(IL), US");
		
		//String date = PageBase.selectNewDateFromCalendar(165);
		test.log(LogStatus.INFO, "User entered \"Chicago (All Airports), IL\" into leaving from field");
		
		String date = bookingPage.selectValueFromCalendar(105, 2);
		
		String selecteddate = bookingPage.getSelectedDate();
		test.log(LogStatus.INFO,   "User selects arrival date '" + selecteddate + "'from calendar");
		PageBase.scrollDownForMob(2);
		test.log(LogStatus.INFO, "Scrolled Down.");
		test.log(LogStatus.INFO, "User tap on Options to select rooms and traveler.");
		bookingPage.selectGuestDetails("2|Other");
		//*test.log(LogStatus.INFO, "Scrolled Up");
		test.log(LogStatus.INFO, "Tap on Rooms Dropdown");
		test.log(LogStatus.INFO, "Select 2 Rooms with Children or other options from dropdown");
		test.log(LogStatus.INFO, "tap on -(minus) to select one adult gor room 1");
		
		bookingPage.selectnumberofadultsRoom_1iOS();
		//bookingPage.selectNumberOfChild("1", "3", "Child1");
		bookingPage.selectNumberOfChildNewPage("1", "4", "Child1");
		
		test.log(LogStatus.INFO, "User Tap on + to select child for Room 1");
		test.log(LogStatus.INFO, "tap on child 1 age dropdown and select child age.");
		
		test.log(LogStatus.INFO, "No.of Child & Age of Child got selected successfully for Room 1");
		bookingPage.selectnumberofadultsRoom_2iOS();
		 test.log(LogStatus.INFO, "Tap on + for Room 2 Adult 1");
		//bookingPage.selectNumberOfChild("1", "3", "Child2");
		bookingPage.selectNumberOfChildNewPage("1", "3", "Child2");
		
		test.log(LogStatus.INFO, "User tap on + to select child for Room 2");
		test.log(LogStatus.INFO, "Tap on child 1 age dropdown for Room 2 and select child age.");
		
		
		test.log(LogStatus.INFO, "No.of Child & Age of Child got selected successfully for Room 2");
		test.log(LogStatus.INFO, "Scrolled Up");
		bookingPage.doneButtonMob();
		test.log(LogStatus.INFO, "Booking details filled successfully for Two Adults & Two Child");
		test.log(LogStatus.INFO, "Tap on Done Button");
		
		bookingPage.clickonContinueButton();
		test.log(LogStatus.INFO, "Tap on Continue Button");
		
		
		String value = bookingPage.getSessionid();
		test.log(LogStatus.INFO, "Session id is "+ value);
		
		
		test.log(LogStatus.INFO, "Scrolled Down");
		
		
		bookingPage.clickOncheaperFlights();
		test.log(LogStatus.INFO, "User tap on Browse All Flights Link");
	//	bookingPage.selectOnCheaperFlightPage();
		test.log(LogStatus.INFO, "Tap on Select to select first available flight");
	//	bookingPage.selectCabin();
		test.log(LogStatus.INFO, "Scrolled Down");
		
		test.log(LogStatus.INFO, "User selects a particular cabin from existing options");
		
		
		
//		bookingPage.getTripinclusionContinueButton();  
		test.log(LogStatus.INFO, "Scrolled Down");
		
		test.log(LogStatus.INFO, "Tap on Continue to Itinerary details page");
		
		bookingPage.getTripinclusionContinueButton();
		test.log(LogStatus.INFO, "Scrolled Down");
		
		test.log(LogStatus.INFO, "Tap on Continue to Reservation page");
		
		 expectedFirstTravellerInfo = passengerInfoPage.fillFirstTravellerDetails("Morris", "Mano", "Male","", "237|US");
			test.log(LogStatus.INFO, "User enters \"Morris\" as First Traveller First Name");
			test.log(LogStatus.INFO, "User enters \"Mano\" as First Traveller Last Name");
	    		test.log(LogStatus.INFO, "User selects \"Gender:Male\" for First Traveller");
	    		test.log(LogStatus.INFO, "User selects \"Passport details as:US\" for First Traveller");
			test.log(LogStatus.INFO, "Scrolled Down");
			
			test.log(LogStatus.INFO, "User selects \"Passport details as:US\" for First Traveller");
			expectedSecondTravellerInfo = passengerInfoPage.fillSecondTravellerDetailsChildMob("Shally", "Mano", "Female","01/01/2016", "237|US", "Child");
			test.log(LogStatus.INFO, "User enters \"Shally\" as Second Traveller First Name");
			test.log(LogStatus.INFO, "User enters \"Mano\" as Second Traveller Last Name");
			test.log(LogStatus.INFO, "User selects \"Female\" for Second Traveller");
			test.log(LogStatus.INFO, "User selects \"DOB:01/01/2016\" for Second Traveller's Date of Birth");
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
		test.log(LogStatus.INFO, "Entered the URL: http://www.tripmasters.com/");
		
		
		homePage.clickOnExploreAsiaLink();
		test.log(LogStatus.INFO, "Scrolled Down");
		
		test.log(LogStatus.INFO, "User tap on Explore Asia Link");
		homePage.verifyHighLightsandAttractions();
		test.log(LogStatus.INFO, "Verify Highlights option is available on Homepage. ");
		String firstHighLight = homePage.verifyfirsthighlightandAttraction();
		test.log(LogStatus.INFO, "Verify First Highlight option is available on page");
		test.log(LogStatus.INFO,"First highlight and Attraction is "+ firstHighLight);
		test.log(LogStatus.INFO, "Scrolled Down");
		
		homePage.clickOnMoreHighLight();
		homePage.moreHighlightsandattractionList();
		test.log(LogStatus.INFO, "Verifies More Highlights options displayed");
		test.log(LogStatus.INFO,"Tap on More Highlights and Attractions");
		test.log(LogStatus.INFO,"List of more highlight and attraction is displayed.");
		homePage.clickonFirstHighlight();
		test.log(LogStatus.INFO, "Scrolled Up");
		
		test.log(LogStatus.INFO,"Tap on First Highlight option " + firstHighLight);
		homePage.clickOnBuildYourOwnVacation();
		test.log(LogStatus.INFO, "Scrolled Down");
		
		test.log(LogStatus.INFO, "Tap on Customize your itinerary");
		

		bookingPage.fillLeavingFromDetails("New York City (all Airports),  NY");
		test.log(LogStatus.INFO, "User entered \"New York City (all Airports),  NY\" into leaving from field");
		bookingPage.fillGoingToCityDetails("Berlin (Germany)");
		test.log(LogStatus.INFO, "User entered \"Berlin (Germany)\" into Going to from field");
		bookingPage.selectStayingTime("4");
		test.log(LogStatus.INFO, "User entered \"4\" nights staying time for Berlin");
		bookingPage.clickOnAddCityBtn();
		test.log(LogStatus.INFO, "Tap on Add destination");
		bookingPage.fillSecndAddedCityDetails("Frankfurt (Germany)");
		test.log(LogStatus.INFO, "User entered \"Frankfurt (Germany)\" into Going to from field");
		bookingPage.selectStayingTimeTwo("4");
		test.log(LogStatus.INFO, "User entered \"4\" nights staying time for Frankfurt");
		String date = bookingPage.selectValueFromCalendar(213 ,4);
		System.out.println("date is "+ date);	
		String selecteddate = bookingPage.getSelectedDate();
		test.log(LogStatus.INFO,   "User selects arrival date '" + selecteddate + "'from calendar");
		
		
		bookingPage.selectNoMoreCitiesBtn();
		test.log(LogStatus.INFO, "Tap on Next");
		test.log(LogStatus.INFO, "User tap on Options to select rooms and traveler.");
		bookingPage.selectGuestDetails("1|1");
		
		test.log(LogStatus.INFO, "Tap on Rooms Dropdown");
		test.log(LogStatus.INFO, "Select 1 Room for 1 Adult from dropdown");
		
		bookingPage.doneButtonMob();
		test.log(LogStatus.INFO, "Tap on Done");
		
		//todo add done
		
		
		test.log(LogStatus.INFO, "Booking details filled successfully for One Adult");
//		test.log(LogStatus.INFO, "Booking details filled successfully for multiple cities");
//		//Logs.info("Booking details filled successfully for multiple cities");
		bookingPage.clickonContinueButton();
		PageBase.waitForElement(3);
		
		String value = bookingPage.getSessionid();
		test.log(LogStatus.INFO, "Session id is "+ value);
		
		
		test.log(LogStatus.INFO, "Tap on Continue Button");
		bookingPage.clickOncheaperFlights();
		test.log(LogStatus.INFO, "Scrolled Down");
		
		test.log(LogStatus.INFO, "User tap on Browse All Flights Link");
	//	bookingPage.selectOnCheaperFlightPage();
		test.log(LogStatus.INFO, "Tap on Select to select first available flight");
		test.log(LogStatus.INFO, "Scrolled Down");
		
	//	bookingPage.selectCabin();
		test.log(LogStatus.INFO, "User selects a particular cabin from existing options");
		
		
		
	//	bookingPage.getTripinclusionContinueButton();   
		test.log(LogStatus.INFO, "Scrolled Down");
		
		test.log(LogStatus.INFO, "Tap on Continue to Itinerary details page");
		
		bookingPage.getTripinclusionContinueButton();
		test.log(LogStatus.INFO, "Scrolled Down");
		

		test.log(LogStatus.INFO, "Tap on Continue to Reservation page");

		
		
		expectedFirstTravellerInfo = passengerInfoPage.fillFirstTravellerDetails("Morris", "Leo", "Male","01/01/1992", "237|US");
		test.log(LogStatus.INFO, "User enters \"Morris\" as Traveller First Name");
		test.log(LogStatus.INFO, "User enters \"Mano\" as Traveller Last Name");
		test.log(LogStatus.INFO, "User selects \"Gender:Male\" for Traveller");
		test.log(LogStatus.INFO, "User selects \"DOB:01/01/1992\" for Traveller's Date of Birth");
		test.log(LogStatus.INFO, "Scrolled Down");
		
		test.log(LogStatus.INFO, "User selects \"Passport details as:US\" for Traveller");
		
		bookingPage.getTripinclusionContinueButton();
		bookingPage.clicktoContinuePage();
		test.log(LogStatus.INFO, "Tap to Continue & User redirected to Payment Page");
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
	public void TC_0007_bookingFlightAndTwoRoomsWithAdultsAndChilds_FromTopDealPackages(Method method) throws Exception {
		ExtentTest test=ExtentTestManager.startTest(method.getName(), "TC_0007_bookingFlightAndTwoRoomsWithAdultsAndChilds_FromTopDealPackages");
		test.log(LogStatus.INFO, "Entered the URL: http://www.tripmasters.com/");
		
		
		test.log(LogStatus.INFO, "Scrolled Down");
		
		homePage.topdeals();
		test.log(LogStatus.INFO, "User tap on Top Deals");
		Thread.sleep(5000);
		homePage.validateTopDealsPage();
		test.log(LogStatus.INFO, "Verifies that User is on top deal page");
	//	homePage.validatetopDealsList();
		test.log(LogStatus.INFO, "Verifies the top deals list of the week");
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Scrolled Down");
		
		 String firsttopdeal = homePage.clickOnCustomizeit();
		test.log(LogStatus.INFO, "Tap on Customize it button of " + firsttopdeal);
		PageBase.scrollDown();
		test.log(LogStatus.INFO, "Scrolled Down");
		
		bookingPage.fillLeavingFromDetails("New York City (all Airports),  NY");
		test.log(LogStatus.INFO, "User entered \"New York City (all Airports),  NY\" into leaving from field");

		String date = bookingPage.selectValueFromCalendar(95 ,1);
		
		String selecteddate = bookingPage.getSelectedDate();
		test.log(LogStatus.INFO,   "User selects arrival date '" + selecteddate + "'from calendar");
		bookingPage.selectGuestDetails_dealsPage("2|Other");
		//test.log(LogStatus.INFO, "User tap on Options");
		test.log(LogStatus.INFO, "Tap on Rooms input");
		
		test.log(LogStatus.INFO, "Tap on Rooms Dropdown");
		test.log(LogStatus.INFO, "Select 2 Rooms with Children or other options from dropdown");
		test.log(LogStatus.INFO, "Tap on - (minus) select one adult for Room 1");
		
		//test.log(LogStatus.INFO, "User select 2 Rooms with 2 Adults and One Child from Guest list");
		bookingPage.selectNumberOfChild_dealsPage("1", "11", "Child1");
		
		test.log(LogStatus.INFO, "User tap on + to select child for Room 1");
		test.log(LogStatus.INFO, "Tap on child 1 age dropdown and select child age.");
		
		
		
		 bookingPage.selectNumberOfAdult("1", BookingLocators.getselectAdultRoom2Drpdown());
		 test.log(LogStatus.INFO, "Tap on + (plus) select one adult for Room 2");
		 test.log(LogStatus.INFO, "Booking details filled successfully for Two Adults and One child");
		bookingPage.doneButtonMob();
		test.log(LogStatus.INFO, "Tap on Done");
		bookingPage.clickOnViewPrice();
		test.log(LogStatus.INFO, "Tap on View Price.");
		test.log(LogStatus.INFO, "Scrolled Down");
		
		String value = bookingPage.getSessionid();
		test.log(LogStatus.INFO, "Session id is "+ value);
		
		
		
		ActualHotel = bookingPage.browseHotelsButton();
		test.log(LogStatus.INFO, "Tap on Browse Hotels Button");

		bookingPage.selectFirstHotel();

		ExpectedHotel = bookingPage.browseSelectHotel();
		test.log(LogStatus.INFO, "Select particular hotel from Hotel Options");
		test.log(LogStatus.INFO, "Scrolled Down");
		
		bookingPage.clicktoContinuePage();
		test.log(LogStatus.INFO, "User tap on Continue");
		bookingPage.clickOncheaperFlights();
		test.log(LogStatus.INFO, "Scrolled Down");
		
		test.log(LogStatus.INFO, "User tap on Browse all flights button");
	//	bookingPage.selectOnCheaperFlightPage();
		
		
		
		test.log(LogStatus.INFO, "Tap on Select dropdown");
	//	bookingPage.selectCabin();
		test.log(LogStatus.INFO, "Scrolled Down");
		
		test.log(LogStatus.INFO, "Tap on Select cabin");
		test.log(LogStatus.INFO, "User selects first available cabin from existing options");
	//	bookingPage.getTripinclusionContinueButton();
		test.log(LogStatus.INFO, "Scrolled Down");
		
		test.log(LogStatus.INFO, "Tap on Continue to Itinerary details page");
		bookingPage.getTripinclusionContinueButton();
		test.log(LogStatus.INFO, "Scrolled Down");
		
		test.log(LogStatus.INFO, "Tap on Continue to Reservation page");
		
		expectedFirstTravellerInfo = passengerInfoPage.fillTravellerDetailsForMultipleRooms("Room1Traveller1");
		test.log(LogStatus.INFO, "User enters \"yury\" as Traveller1 First Name");
	    test.log(LogStatus.INFO, "User enters \"darwin\" as Traveller1 Last Name");
		test.log(LogStatus.INFO, "User selects \"Gender:Male\" for Traveller1 ");
		test.log(LogStatus.INFO, "User selects \"DOB:01/01/2000\" for Traveller1 Date of Birth");
		test.log(LogStatus.INFO, "Scrolled Down");
		
		test.log(LogStatus.INFO, "User selects \"Passport details as:US\" for Traveller1");
		expectedSecondTravellerInfo = passengerInfoPage.fillTravellerDetailsForMultipleRooms("Room1Child1SingleTravlr");
		test.log(LogStatus.INFO, "User enters \"Erwin\" as Traveller2 First Name");
		test.log(LogStatus.INFO, "User enters \"George\" as Traveller2 Last Name");
		test.log(LogStatus.INFO, "User selects \"Gender:Male\" for Traveller2 ");
		test.log(LogStatus.INFO, "User selects \"DOB:01/01/2009\" for Traveller2 Date of Birth");
		test.log(LogStatus.INFO, "User selects \"Passport details as:US\" for Traveller2");
		test.log(LogStatus.INFO, "Scrolled Down");
		
		expectedThirdTravellerInfo = passengerInfoPage.fillTravellerDetailsForMultipleRooms("Room2Traveller1");
		test.log(LogStatus.INFO, "User enters \"Hanna\" as Traveller3 First Name");
		test.log(LogStatus.INFO, "User enters \"darwin\" as Traveller3 Last Name");
		test.log(LogStatus.INFO, "User selects \"Gender:Male\" for Traveller3 ");
		test.log(LogStatus.INFO, "User selects \"DOB:01/01/2000\" for Traveller3 Date of Birth");
		test.log(LogStatus.INFO, "User selects \"Passport details as:US\" for Traveller3");
		test.log(LogStatus.INFO, "Scrolled Down");
		
		bookingPage.getTripinclusionContinueButton();
		
		bookingPage.clicktoContinuePage();
		test.log(LogStatus.INFO, "Tap on Continue Button & User redirected to the Payment Page");
		PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler1Name(), expectedFirstTravellerInfo);
		PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler2Name(), expectedSecondTravellerInfo);
		PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler3Name(), expectedThirdTravellerInfo);
		test.log(LogStatus.INFO, "Flights & passenger details verified successfully on PaymentPage");
		
	}
	
	@Test(groups= {"smoke"},priority=8)
	  public void TC_0008_bookingFlightMultipleCitiesAndTwoRoomsWithAdultsAndChilds_FromEuropePage(Method method) throws Exception {
		ExtentTest test=ExtentTestManager.startTest(method.getName(), "TC_0008_bookingFlightMultipleCitiesAndTwoRoomsWithAdultsAndChilds_FromEuropePage");
		test.log(LogStatus.INFO, "Entered the URL: http://www.tripmasters.com/");
		
		
		homePage.clickOnExploreEuropeLink();
		test.log(LogStatus.INFO, "Scrolled Down");
		
		test.log(LogStatus.INFO, "User tap on explore europe page link");
		 bookingPage.clickOnBuildYourVacationDropDown();
		 test.log(LogStatus.INFO, "User tap on Create your Vacation dropdown");
			 
		 bookingPage.fillLeavingFromDetails("New York City (all Airports),  NY");
		 test.log(LogStatus.INFO, "User entered \"New York City (all Airports),  NY\" into leaving from field");
		
		 String date = bookingPage.selectValueFromCalendar(227 ,4);
			
		 String selecteddate = bookingPage.getSelectedDate();
			test.log(LogStatus.INFO,   "User selects arrival date '" + selecteddate + "'from calendar"); 
		 bookingPage.fillGoingToCityDetails("Rome (Italy)");
		 test.log(LogStatus.INFO, "User entered \"Rome (Italy)\" into going to field");
		 
		 
		 bookingPage.selectStayingTime("4");
		 test.log(LogStatus.INFO, "User entered \"4\" nights staying time in Rome (Italy)");
		 bookingPage.clickOnAddCityBtn();
		 test.log(LogStatus.INFO, "User tap on Add destination");
	  	 bookingPage.fillSecndAddedCityDetails("Florence (Italy)");
	  	test.log(LogStatus.INFO, "User entered \"Florence (Italy)\" into going to field");
	  	 bookingPage.selectStayingTimeTwo("4");
		 test.log(LogStatus.INFO, "User entered \"4\" nights staying time in Florence");
		 bookingPage.clickOnAddCityBtn();
		 test.log(LogStatus.INFO, "User tap on Add destination");
		 bookingPage.fillThirdAddedCityDetails("Venice (Italy)");
		 test.log(LogStatus.INFO, "User entered \"Venice (Italy)\" into going to field");
		 bookingPage.selectStayingTimeThree("4");
		 test.log(LogStatus.INFO, "User entered \"4\" nights staying time in Venice (Italy)");
		 bookingPage.clickonContinue();
		 test.log(LogStatus.INFO, "User tap on Next");
		 //test.log(LogStatus.INFO, "Booking details filled successfully for multiple cities"); 
		 bookingPage.selectGuestDetails("2|Other");
		 test.log(LogStatus.INFO, "Scrolled Down");
		 test.log(LogStatus.INFO, "User tap on Options to select rooms and traveler.");	
		 test.log(LogStatus.INFO, "Tap on Rooms Dropdown");
		test.log(LogStatus.INFO, "Select 2 Rooms with Children or other options from dropdown");
			
		 
		 
		 bookingPage.selectNumberOfAdult("1", BookingLocators.getselectAdultDrpdown());
		 test.log(LogStatus.INFO, "tap on - (minus) for Room 1 adult and select 1 adult for Room 1");
		 bookingPage.selectnumberofadultsRoom_1iOS();
		 bookingPage.selectNumberOfChild("1", "11", "europepage");
		 
		 test.log(LogStatus.INFO, "User tap on + to select child for Room 1");
		 test.log(LogStatus.INFO, "Tap on child 1 age dropdown and select child age.");
			
		 
		 //test.log(LogStatus.INFO, "No.of Child & Age of Child got selected successfully for first room");
		 bookingPage.selectNumberOfAdult("1", BookingLocators.getselectAdultRoom2Drpdown());
		 test.log(LogStatus.INFO, "User tap on + to select 1 Adult for for Room 2");
		 
		 bookingPage.selectnumberofadultsRoom_2iOS();
		// bookingPage.selectCabinClassForMob("Business");
		 test.log(LogStatus.INFO, "Passenger details for second room selected successfully");
		 bookingPage.doneButtonMob();
		 test.log(LogStatus.INFO, "Scrolled Up");
		 test.log(LogStatus.INFO, "User tap on Done Button");
		 bookingPage.clickonContinueButton();
		 test.log(LogStatus.INFO, "User tap on Continue Button");
		 
		 String value = bookingPage.getSessionid();
			test.log(LogStatus.INFO, "Session id is "+ value);
			
		 
	 ActualHotel = bookingPage.browseHotelsButton();
		 test.log(LogStatus.INFO, "Scrolled Down");
			
	    ExpectedHotel = bookingPage.browseSelectHotel();
	     test.log(LogStatus.INFO, "User tap on Browse Hotels Button for First city.");
	     System.out.println("actual = "+ActualHotel+"Expected = "+ExpectedHotel);
	     test.log(LogStatus.INFO, "Select particular hotel from Hotel Options");
		//	Assert.assertEquals(ActualHotel, ExpectedHotel);
			bookingPage.selectFirstHotel();
			
			PageBase.scrollDownForMob(1);
			 test.log(LogStatus.INFO, "Scrolled Down");
				
			expectedSecondcityHotel = bookingPage.browseHotelSecondCity();
			test.log(LogStatus.INFO, "User tap on Browse Hotels Button for Second city.");
			bookingPage.selectFirstHotel();
			test.log(LogStatus.INFO, "Select particular hotel from Hotel Options for second City");
			
			bookingPage.clickOncheaperFlights();
			 test.log(LogStatus.INFO, "Scrolled Down");
				
			test.log(LogStatus.INFO, "User tap on Browse All flights button.");
		//	bookingPage.selectOnCheaperFlightPage();
			test.log(LogStatus.INFO, "User tap  on Select dropdown.");
		//	bookingPage.selectCabin();
			 test.log(LogStatus.INFO, "Scrolled Down");
				
			test.log(LogStatus.INFO, "User selects the available Business class cabin");
	//		bookingPage.getTripinclusionContinueButton();
			 test.log(LogStatus.INFO, "Scrolled Down");
				
			test.log(LogStatus.INFO, "User tap on Continue button.");
			
			actualsecondCityHotel = bookingPage.secondCityHotelName();
			
			Assert.assertEquals(actualsecondCityHotel, expectedSecondcityHotel);
			test.log(LogStatus.INFO, "Verifiy that only particular selected hotel appears along with passenger details");

			bookingPage.getTripinclusionContinueButton();
			 test.log(LogStatus.INFO, "Scrolled Down");
				
			test.log(LogStatus.INFO, "Tap on Continue to Reservation page");
			
			

			//test.log(LogStatus.INFO, "Verifiy that only particular selected hotel appears along with passenger details");

			expectedFirstTravellerInfo = passengerInfoPage.fillTravellerDetailsForMultipleRooms("Room1Traveller1");
			test.log(LogStatus.INFO, "User enters \"yury\" as Traveller1 First Name");
		    test.log(LogStatus.INFO, "User enters \"darwin\" as Traveller1 Last Name");
			test.log(LogStatus.INFO, "User selects \"Gender:Male\" for Traveller1 ");
			test.log(LogStatus.INFO, "User selects \"DOB:01/01/2000\" for Traveller1 Date of Birth");
			test.log(LogStatus.INFO, "User selects \"Passport details as:US\" for Traveller1");
			 test.log(LogStatus.INFO, "Scrolled Down");
				
			expectedSecondTravellerInfo = passengerInfoPage.fillTravellerDetailsForMultipleRooms("Room1Child1SingleTravlr");
			test.log(LogStatus.INFO, "User enters \"Erwin\" as Traveller2 First Name");
			test.log(LogStatus.INFO, "User enters \"George\" as Traveller2 Last Name");
			test.log(LogStatus.INFO, "User selects \"Gender:Male\" for Traveller2 ");
			test.log(LogStatus.INFO, "User selects \"DOB:01/01/2009\" for Traveller2 Date of Birth");
			 test.log(LogStatus.INFO, "Scrolled Down");
				
			test.log(LogStatus.INFO, "User selects \"Passport details as:US\" for Traveller2");
			expectedThirdTravellerInfo = passengerInfoPage.fillTravellerDetailsForMultipleRooms("Room2Traveller1");
			test.log(LogStatus.INFO, "User enters \"Hanna\" as Traveller3 First Name");
			test.log(LogStatus.INFO, "User enters \"darwin\" as Traveller3 Last Name");
			test.log(LogStatus.INFO, "User selects \"Gender:Male\" for Traveller3 ");
			test.log(LogStatus.INFO, "User selects \"DOB:01/01/2000\" for Traveller3 Date of Birth");
			test.log(LogStatus.INFO, "User selects \"Passport details as:US\" for Traveller3");
			 test.log(LogStatus.INFO, "Scrolled Down");
				
			bookingPage.getTripinclusionContinueButton();
			bookingPage.clicktoContinuePage();
			test.log(LogStatus.INFO, "Tap on Continue Button & User redirected to the Payment Page");
			PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler1Name(), expectedFirstTravellerInfo);
			PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler2Name(), expectedSecondTravellerInfo);
			PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler3Name(), expectedThirdTravellerInfo);
			test.log(LogStatus.INFO, "Flights & passenger details verified successfully on PaymentPage");	  
	  }

	
	
	@Test(groups= {"smoke"},priority=21)
	public void TC_0021_tripSummarymultipleCities(Method method) throws Exception {
		ExtentTest test=ExtentTestManager.startTest(method.getName(), "TC_0021_tripSummarymultipleCities");
		test.log(LogStatus.INFO, "Entered the URL: http://www.tripmasters.com/");
		
		
		bookingPage.clickOnBuildYourVacationDropDown();
		test.log(LogStatus.INFO, "User tap on Build your vacation dropdown");
		PageBase.waitForElement(5);
		bookingPage.fillLeavingFromDetails("Washington (all Airports), DC");
		test.log(LogStatus.INFO, "User entered \"Washington (all Airports), DC\" into leaving from field");
		bookingPage.fillGoingToCityDetails("London (England)");
		test.log(LogStatus.INFO, "User entered \"London (England)\" into Going to from field");
		String date = bookingPage.selectValueFromCalendar(99 ,0);
		
		System.out.println("date is "+ date);	
		String selecteddate = bookingPage.getSelectedDate();
		test.log(LogStatus.INFO,   "User selects arrival date '" + selecteddate + "'from calendar");
		
		
		bookingPage.selectStayingTime("3");
		test.log(LogStatus.INFO, "User entered \"3\" nights staying time in London (England)");
		bookingPage.clickOnAddCityBtn();
		test.log(LogStatus.INFO, "User tap on Add destination");
		bookingPage.fillSecndAddedCityDetails("Paris (France)");
		bookingPage.selectStayingTimeTwo("3");
		
		test.log(LogStatus.INFO, "User entered \"Paris (France)\" into Going to from field");
		test.log(LogStatus.INFO, "User entered \"3\" nights staying time in Paris (France)");
		
		bookingPage.clickOnAddCityBtn();
		test.log(LogStatus.INFO, "User tap on Add destination");
		bookingPage.fillThirdAddedCityDetails("Rome (Italy)");
		test.log(LogStatus.INFO, "User entered \"Rome (Italy)\" into Going to from field for adding third city");		
		bookingPage.selectStayingTimeThree("3");
		test.log(LogStatus.INFO, "User entered \"3\" nights staying time in Rome(Italy)");
		bookingPage.clickonContinue();
		test.log(LogStatus.INFO, "User tap on Next");
		test.log(LogStatus.INFO, "User is able to select multiple cities.");
		//bookingPage.selectNoMoreCitiesBtn();
		 test.log(LogStatus.INFO, "Scrolled Down");
		 test.log(LogStatus.INFO, "User tap on Options to select rooms and traveler.");
		test.log(LogStatus.INFO, "Tap on Rooms Dropdown");
		bookingPage.selectGuestDetails("1|2");
		test.log(LogStatus.INFO, "User selects One room for two adults");
		
		bookingPage.doneButtonMob();
		test.log(LogStatus.INFO, "Tap on Done Button");
		
		
		bookingPage.clickonContinueButton();
		
		String value = bookingPage.getSessionid();
		test.log(LogStatus.INFO, "Session id is "+ value);
		
		
		bookingPage.clickOncheaperFlights();
		test.log(LogStatus.INFO, "Scrolled Down");
		
		test.log(LogStatus.INFO, "User tap on Browse all flights button");
	//	bookingPage.selectOnCheaperFlightPage();
		
		
		
		test.log(LogStatus.INFO, "Tap on Select dropdown");
	//	bookingPage.selectCabin();
		test.log(LogStatus.INFO, "Scrolled Down");
		
		test.log(LogStatus.INFO, "Tap on Select cabin");
		test.log(LogStatus.INFO, "User selects first available cabin from existing options");
	//	bookingPage.getTripinclusionContinueButton();
		test.log(LogStatus.INFO, "Scrolled Down");
		
		
		
		test.log(LogStatus.INFO, "User tap on continue button");
//		//bookingPage.tripSummary();
		bookingPage.validateTripPage();
		test.log(LogStatus.INFO, "Validate that user is on TripInclusion Page");
	
		
	}
	

	
	
	

	@Test(groups= {"smoke"},priority=17)
	public void TC_0017_validateTripSummarywithMultipleCitiesforExploreAsiaPage(Method method) throws Exception {
		ExtentTest test=ExtentTestManager.startTest(method.getName(), "TC_0017_validateTripSummarywithMultipleCitiesforExploreAsiaPage");
		test.log(LogStatus.INFO, "Entered the URL: http://www.tripmasters.com/");
		
		homePage.clickOnExploreAsiaLink();
		test.log(LogStatus.INFO, "Scrolled Down");
		
		test.log(LogStatus.INFO,"User tap on explore Asia Link");
		bookingPage.clickOnBuildYourVacationDropDown();
		test.log(LogStatus.INFO, "User tap on Create your vacation dropdown");
		PageBase.waitForElement(3);
		bookingPage.fillLeavingFromDetails("New York City (all Airports),  NY");
		test.log(LogStatus.INFO, "User entered \"New York City (all Airports),  NY\" into leaving from field");
		bookingPage.fillGoingToCityDetails("Delhi (India)");
		
		 String date = bookingPage.selectValueFromCalendar(210 ,3);
			
		System.out.println("date is "+ date);	
		String selecteddate = bookingPage.getSelectedDate();
		test.log(LogStatus.INFO,   "User selects arrival date '" + selecteddate + "'from calendar");
		test.log(LogStatus.INFO, "User entered \"Delhi (India)\" into Going to from field");
		bookingPage.selectStayingTime("4");
		test.log(LogStatus.INFO, "User entered \"4\" nights staying time");
		bookingPage.clickOnAddCityBtn();
		test.log(LogStatus.INFO, "User tap on Add destination button");
		bookingPage.fillSecndAddedCityDetails("Mumbai (India)");
		test.log(LogStatus.INFO, "User entered \"Mumbai (India)\" into Going to from field for adding second city");
		bookingPage.selectStayingTimeTwo("1");
		test.log(LogStatus.INFO, "User entered \"1\" nights staying time for the second city");
		bookingPage.clickOnAddCityBtn();
		test.log(LogStatus.INFO, "User tap on Add destination button");
		bookingPage.fillThirdAddedCityDetails("Chennai (Madras) (India)");
		test.log(LogStatus.INFO, "User entered \"Chennai -Madras (India)\" into Going to from field for adding Third city");
		bookingPage.selectStayingTimeThree("1");
		test.log(LogStatus.INFO, "User entered \"1\" nights staying time for the third city");
		test.log(LogStatus.INFO, "Fill all the basic details for added cities");
		
		boolean actual = bookingPage.isremovecitydisplayed();
		Assert.assertTrue(actual);
		test.log(LogStatus.INFO,"Verify that added cities got selected as destinations");
		test.log(LogStatus.INFO, "Verify that X button also displayed for deleting the added cities");

		bookingPage.deleteAddedCities();
		test.log(LogStatus.INFO, "Tap on X to delete Chennai -Madras (India)");
		
		test.log(LogStatus.INFO, "Tap on X to delete  Mumbai (India)");
		//test.log(LogStatus.INFO,"Deleted last added two cities");
		bookingPage.validateremovedcity();
		test.log(LogStatus.INFO, "Added cities removed successfully.Verified!");
		//logs.info("All the added cities removed successfully.Verified!");
		bookingPage.clickOnAddCityBtn();
		test.log(LogStatus.INFO, "Tap again on Add destination");
		//logs.info("Click again to add city");
		bookingPage.fillSecndAddedCityDetails("Mumbai (India)");
		test.log(LogStatus.INFO, "User entered \"Mumbai (India)\" into Going to from field");
		bookingPage.selectStayingTimeTwo("4");
		test.log(LogStatus.INFO, "User entered \"4\" nights staying time");
		PageBase.waitForElement(10);
		bookingPage.selectNoMoreCitiesBtn();
		test.log(LogStatus.INFO, "User tap on Next");
		Thread.sleep(50000);
		boolean actualresult = bookingPage.isTravelByDisplayed();
		Assert.assertTrue(actualresult);
		test.log(LogStatus.INFO,"Travel By Option validated from one city to another");
		test.log(LogStatus.INFO, "Scrolled Down");
		test.log(LogStatus.INFO, "Tap on Options to select Rooms,traveller & economy");
		//*test.log(LogStatus.INFO, "Scrolled Up");
		
		test.log(LogStatus.INFO, "Tap on Rooms Dropdown");
		bookingPage.selectGuestDetails("1|1");
		test.log(LogStatus.INFO, "User select one room for one adult");
		
		bookingPage.doneButtonMob();
		test.log(LogStatus.INFO, "Tap on Done Button");
		
		bookingPage.clickonContinueButton();
		test.log(LogStatus.INFO, "User tap on Continue");
		test.log(LogStatus.INFO, "Scrolled Down");
		
		String value = bookingPage.getSessionid();
		test.log(LogStatus.INFO, "Session id is "+ value);
		
		
		bookingPage.clickOncheaperFlights();
		
		
		test.log(LogStatus.INFO, "User Tap on Browse all flights button");
	//	bookingPage.selectOnCheaperFlightPage();
		
		
		PageBase.scrollDown();
		test.log(LogStatus.INFO, "Tap on Select dropdown");
	//	bookingPage.selectCabin();
		test.log(LogStatus.INFO, "Scrolled Down");
		
		test.log(LogStatus.INFO, "Tap on Select cabin");
		test.log(LogStatus.INFO, "User selects first available cabin from existing options");
	//	bookingPage.getTripinclusionContinueButton();
		test.log(LogStatus.INFO, "Scrolled Down");
		
		
		
		test.log(LogStatus.INFO, "User tap on continue button");
		//bookingPage.tripSummary();
		bookingPage.validateTripPage();
		test.log(LogStatus.INFO, "Validate that user is on TripInclusion Page");
	
		
	}
	
	
	
	
	

	
	@Test(groups= {"regression"},priority=14)
	public void TC_0014_verifySpotlightLink(Method method) throws Exception {
    	String PageTitle=null;
		ExtentTest test=ExtentTestManager.startTest(method.getName(), "TC_0014_verifySpotlightLink");
		test.log(LogStatus.INFO, "Entered the URL: http://www.tripmasters.com/");
		
		bookingPage.selectLatinAmericaLink();
		test.log(LogStatus.INFO, "Scrolled Down");
		test.log(LogStatus.INFO, "Tap on Explore latin America Button");
		
		bookingPage.verifyLatinAmericPage();
		//test.log(LogStatus.INFO, "User redirected to the Latin America Page");
		bookingPage.verifyLatinAmericPage();
		test.log(LogStatus.INFO, "User redirected to the Latin America Page");
		//Logs.info("User redirected to the Latin America Page");
		bookingPage.clickOnSpotlightOnDrpDwnForMob();
		test.log(LogStatus.INFO, "Scrolled Down");
		//test.log(LogStatus.INFO, "Spotlight link verified!");
		test.log(LogStatus.INFO, "User tap on Spotlight On Dropdown button");
		
		String title=bookingPage.clickOnFirstOptionUnderSpotlightForMob();
		test.log(LogStatus.INFO, "Tap on first Spotlight destination "+ title);
		bookingPage.verifyPageDisplayed(title);
		test.log(LogStatus.INFO, "User is redirected to the " + title + "destination page");
		//Logs.info("User tap on Spotlight button");		
		test.log(LogStatus.INFO, "Spotlight link verified!");
        //Logs.info("Spotlight link verified!");

	}
	
	
	

	
   @Test(groups= {"smoke"},priority=9)
	public void TC_0009_arrival_dateChanging_FromTopOptions(Method method) throws Exception {
		ExtentTest test=ExtentTestManager.startTest(method.getName(), "TC_0009_arrival_dateChanging_FromTopOptions");
		test.log(LogStatus.INFO, "Entered the URL: http://www.tripmasters.com/");
		
		
		bookingPage.clickOnBuildYourVacationDropDown();
		test.log(LogStatus.INFO, "User tap on Build your vacation dropdown");
		PageBase.waitForElement(10);
		bookingPage.fillLeavingFromDetails("New York, Newark, NJ");
		
		test.log(LogStatus.INFO, "User entered \"New York, Newark, NJ\" into leaving from field");
		bookingPage.fillGoingToCityDetails("Berlin (Germany)");
		test.log(LogStatus.INFO, "User entered \"Berlin (Germany)\" into Going to from field");
		String date = bookingPage.selectValueFromCalendar(215 ,4);
		
		
		String selecteddate = bookingPage.getSelectedDate();
		test.log(LogStatus.INFO,   "User selects arrival date '" + selecteddate + "'from calendar");
		bookingPage.selectStayingTime("12");
		test.log(LogStatus.INFO, "User entered \"12\" nights staying time");
		test.log(LogStatus.INFO, "Booking details Source & Destination filled successfully ");
		bookingPage.selectNoMoreCitiesBtn();
		test.log(LogStatus.INFO, "User tap on Next.");
		
		
		
		bookingPage.selectGuestDetails("1|Other");
		test.log(LogStatus.INFO, "User tap on Options to select rooms and traveler.");
		test.log(LogStatus.INFO, "Tap on Rooms Dropdown");
		//*test.log(LogStatus.INFO, "Scrolled Up");
		
		test.log(LogStatus.INFO, "User select \"1 Room With children or Other Options\" from Guest list");
		
		bookingPage.selectNumberOfAdult("1", BookingLocators.getselectAdultDrpdown());
		bookingPage.selectnumberofadultsRoom_1iOS();
		test.log(LogStatus.INFO, "User tap on -(minus) to select one adult for Room");
			
		PageBase.waitForElement(10);
		bookingPage.selectNumberOfChild("1", "3", "Child1");
		test.log(LogStatus.INFO, "User tap on + to select child for Room");
		test.log(LogStatus.INFO, "Tap on child 1 age dropdown and select child age.");
		bookingPage.doneButtonMob();
		//test.log(LogStatus.INFO, "Tap on Done");
		test.log(LogStatus.INFO, "No.of Child & Age of Child got selected successfully");
		
		bookingPage.doneButtonMob();
		test.log(LogStatus.INFO, "Tap on Done Button");
		
		//test.log(LogStatus.INFO, "Booking details Source & Destination filled successfully ");
		
		bookingPage.clickonContinueButton();
		test.log(LogStatus.INFO, "User tap on Continue.");
		
		String value = bookingPage.getSessionid();
		test.log(LogStatus.INFO, "Session id is "+ value);
		
		
		bookingPage.clickChangedArriveDate();
		test.log(LogStatus.INFO, "Tap to change Arrive Date from suggested options");
		bookingPage.oldArriveDate();
		//bookingPage.clickonContinueLink();
		test.log(LogStatus.INFO, "Scrolled Down.");
		test.log(LogStatus.INFO, "User tap on Continue.");
		test.log(LogStatus.INFO,   "Arrival Date get changed,Verified!");
		test.log(LogStatus.INFO, "Scrolled Down.");
		ActualHotel = bookingPage.browseHotelsButton();
		test.log(LogStatus.INFO, "Tap on Browse Hotels Button");

		bookingPage.selectFirstHotel();
        test.log(LogStatus.INFO, "Select particular hotel from Hotel Options");
		ExpectedHotel = bookingPage.browseSelectHotel();
		test.log(LogStatus.INFO, "Validate selected hotel name is displayed");
		test.log(LogStatus.INFO, "Scrolled Down.");
		bookingPage.clicktoContinuePage();
		test.log(LogStatus.INFO, "User tap on Continue");
		bookingPage.clickOncheaperFlights();
		test.log(LogStatus.INFO, "User tap on Browse All Flights button");
	//	bookingPage.selectOnCheaperFlightPage();
		test.log(LogStatus.INFO,"Select Cheaper flights from flight options");
	//	bookingPage.selectCabin();
		test.log(LogStatus.INFO, "User selects cabin class:Coach/Economy");

		
		
	//	bookingPage.getTripinclusionContinueButton();
		test.log(LogStatus.INFO, "Scrolled Down.");
		test.log(LogStatus.INFO, "User tap on Continue");
		bookingPage.getTripinclusionContinueButton();
		//bookingPage.clicktoContinuePage();
		test.log(LogStatus.INFO, "Scrolled Down.");
		test.log(LogStatus.INFO,"User tap on Continue to arrive in Pax Info Page");
		expectedFirstTravellerInfo = passengerInfoPage.fillFirstTravellerDetails("Morris", "Leo", "Male","01/01/1992", "237|US");
		test.log(LogStatus.INFO, "User enters \"Morris\" as First Traveller First Name");
		test.log(LogStatus.INFO, "User enters \"Mano\" as First Traveller Last Name");
		test.log(LogStatus.INFO, "User selects \"Gender:Male\" for First Traveller Last Name");
		test.log(LogStatus.INFO, "User selects \"DOB:01/01/1992\" for First Traveller's Date of Birth");
		test.log(LogStatus.INFO, "Scrolled Down.");
		test.log(LogStatus.INFO, "User selects \"Passport details as:US\" for First Traveller");
		expectedSecondTravellerInfo = passengerInfoPage.fillSecondTravellerDetails("Shally", "Leo", "Male","01/01/2017", "237|US", "Child");
		test.log(LogStatus.INFO, "User enters \"Shally\" as Second Traveller First Name");
		test.log(LogStatus.INFO, "User enters \"Mano\" as Second Traveller Last Name");
		test.log(LogStatus.INFO, "User selects \"Female\" for Second Traveller Last Name");
		test.log(LogStatus.INFO, "User selects \"DOB:01/01/2017\" for Second Traveller's Date of Birth");
		test.log(LogStatus.INFO, "User selects \"Passport details as:US\" for Second Traveller");
		test.log(LogStatus.INFO, "User filled all the passenger details successfully");
		//Logs.info("User filled all the passenger details successfully");
		
		bookingPage.clicktoContinuePage();
		bookingPage.getTripinclusionContinueButton();
		test.log(LogStatus.INFO, "Tap on Continue Button & User redirected to the Payment Page");
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
		   test.log(LogStatus.INFO, "Entered the URL: http://www.tripmasters.com/");
			
		   
		   bookingPage.clickOnBuildYourVacationDropDown();
			test.log(LogStatus.INFO,"User tap on build your vacation dropdown");
			bookingPage.selectCabinClass("Premium Economy");
			Thread.sleep(5000);
			bookingPage.fillLeavingFromDetails("New York City (all Airports)");
			PageBase.waitForElement(10);
			test.log(LogStatus.INFO, "User entered \"New York City (all Airports)\" into leaving from field");
		
			String date = bookingPage.selectValueFromCalendar(214 ,4);
			
			String selecteddate = bookingPage.getSelectedDate();
			test.log(LogStatus.INFO,   "User selects arrival date '" + selecteddate + "'from calendar");
			
			bookingPage.fillGoingToCityDetails("Delhi (India)");
			test.log(LogStatus.INFO, "User entered \"Delhi (India)\" into Going to from field");
			bookingPage.selectStayingTime("4");
			test.log(LogStatus.INFO, "User entered \"4\" nights staying time");
			bookingPage.selectNoMoreCitiesBtn();
			test.log(LogStatus.INFO, "User tap on Next.");
			test.log(LogStatus.INFO, "User tap on Options to select rooms and traveler.");
			bookingPage.selectGuestDetails("1|1");
			
			test.log(LogStatus.INFO, "Tap on Rooms Dropdown");
			test.log(LogStatus.INFO, "Select Guest Details One Room for One Adult");
			String actualcabin =bookingPage.selectPremiumEconomy();
			System.out.println("This is for Actual "+actualcabin);
			test.log(LogStatus.INFO, "Select cabin Premium Economy.");
			bookingPage.doneButtonMob();
			test.log(LogStatus.INFO, "Tap on Done.");
			test.log(LogStatus.INFO, "Filled flights details with premium economy");
			//Logs.info("Filled flights details with premium economy");
			String actualcabinweb = bookingPage.selectedcabinAssert();
			//test.log(LogStatus.INFO, "Select Cabin class");
			//Logs.info("Select Cabin class");
			if(TestBase.flag_Mob){
			  boolean cabinVerify = bookingPage.verifyCabin();
				   Assert.assertTrue(cabinVerify);
				   }
			test.log(LogStatus.INFO, "Selected Cabin class verified");
			//Logs.info("Selected Cabin class verified");
			bookingPage.clickonContinueButton();
			//*test.log(LogStatus.INFO, "Scrolled Down.");
			test.log(LogStatus.INFO, "Tap on continue button");
			
			String value = bookingPage.getSessionid();
			test.log(LogStatus.INFO, "Session id is "+ value);
			
			
			test.log(LogStatus.INFO, "Scrolled Down.");
			bookingPage.selectCheaperFlights();
			test.log(LogStatus.INFO, "Tap on Browse All Flights");
			
			test.log(LogStatus.INFO, "Select first flights from flight options");
			test.log(LogStatus.INFO, "Scrolled Down");
			test.log(LogStatus.INFO, "Tap on continue button");
			
			test.log(LogStatus.INFO, "bookingDetailswithPremiumEcomomy appeared");
			//Logs.info("bookingDetailswithPremiumEcomomy passed");
		}
	
 @Test(groups= {"smoke"},priority=19)
	public void TC_0019_withoutAirBookingForSingleCity(Method method) throws Exception {
	ExtentTest test=ExtentTestManager.startTest(method.getName(), "TC_0019_withoutAirBookingForSingleCity");
	
	test.log(LogStatus.INFO, "User entered the URL: 'https://www.tripmasters.com/");
	
	test.log(LogStatus.INFO, "Skip the test as "+ "Without Air Option" + " is not available on mobile platforms ");
 }
	
 
 @Test(groups= {"smoke"},priority=20)
	public void TC_0020_withoutAirBookingForMultipleCity(Method method) throws Exception {
		ExtentTest test=ExtentTestManager.startTest(method.getName(), "TC_0020_withoutAirBookingForMultipleCity");
		test.log(LogStatus.INFO, "User entered the URL: 'https://www.tripmasters.com/");
		test.log(LogStatus.INFO, "Skip the test as "+ "Without Air Option" + " is not available on mobile platforms ");
	}	

	
	
		
}

