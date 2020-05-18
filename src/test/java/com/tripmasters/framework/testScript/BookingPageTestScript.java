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
	public void bookingSingleRoomWithThreeAdults_TC_1(Method method) throws Exception {
	    ExtentTest test = ExtentTestManager.startTest(method.getName(), "bookingSingleRoomWith3Adults");
		bookingPage.clickOnBuildYourVacationDropDown();
		bookingPage.fillLeavingFromDetails("New York, Newark, NJ");
		test.log(LogStatus.INFO, "User entered \"New York, Newark, NJ\" into leaving from field");
		bookingPage.fillGoingToCityDetails("Berlin (Germany)");
		test.log(LogStatus.INFO, "User entered \"Berlin (Germany)\" into Going to from field");
		bookingPage.selectValueFromCalendar(180);
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
	
	//vaishali
	
	 @Test(groups= {"smoke"},priority=2)
		public void bookingSingleRoomOneAdultOneChild_WithAdditionalChangesTC_2(Method method) throws Exception {
			ExtentTest test = ExtentTestManager.startTest(method.getName(), "bookingSingleRoom1Adult1Child");
			bookingPage.clickOnBuildYourVacationDropDown();
			PageBase.waitForElement(3);
			bookingPage.fillLeavingFromDetails("New York, Newark, NJ");
			test.log(LogStatus.INFO, "User entered \"New York, Newark, NJ\" into leaving from field");
			bookingPage.fillGoingToCityDetails("London (England)");
			test.log(LogStatus.INFO, "User entered \"London(England)\" into Going to from field");
			bookingPage.selectValueFromCalendar(90);
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
			test.log(LogStatus.INFO, "All the basic booking details Source & Destination filled successfully for 1_Adult_1Child_With_SingleRoom");
			bookingPage.selectNumberOfAdult("1", BookingLocators.getselectAdultDrpdown());
			bookingPage.selectnumberofadultsRoom_1iOS();
			test.log(LogStatus.INFO, "User selects \"1\" Adult from Adult Drpdown");
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
           bookingPage.selectCheaperFlights();
			test.log(LogStatus.INFO, "User clicks on Select Cheaper Flights Link");
			test.log(LogStatus.INFO, "User selects a particular flight from existing options");
			test.log(LogStatus.INFO, "User clicks on Continue Link");
			bookingPage.getTripinclusionContinueButton();
			bookingPage.clicktoContinuePage();
		    expectedFirstTravellerInfo = passengerInfoPage.fillFirstTravellerDetails("Morris", "Mano", "Male","01/01/1992", "237|US");
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
			test.log(LogStatus.INFO, "User filled all the passenger details successfully");
			//logs.info("User filled all the passenger details successfully");
			PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler1Name(), expectedFirstTravellerInfo);
			PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler2Name(), expectedSecondTravellerInfo);
			test.log(LogStatus.INFO, "Flights & passenger details verified successfully on PaymentPage");
			//logs.info("Flights & passenger details verified successfully on PaymentPage");
			
		}
//
//	
//
////@Test(groups= {"smoke"},priority=2)
//	public void bookingSingleRoomOneAdultOneChild_TC_2(Method method) throws Exception {
//		ExtentTest test = ExtentTestManager.startTest(method.getName(), "bookingSingleRoom1Adult1Child");
//		bookingPage.clickOnBuildYourVacationDropDown();
//		PageBase.waitForElement(3);
//		bookingPage.fillLeavingFromDetails("New York, Newark, NJ");
//		test.log(LogStatus.INFO, "User entered \"New York, Newark, NJ\" into leaving from field");
//		bookingPage.fillGoingToCityDetails("Berlin (Germany)");
//		test.log(LogStatus.INFO, "User entered \"Berlin (Germany)\" into Going to from field");
//		bookingPage.selectValueFromCalendar();
//		bookingPage.selectStayingTime("6");
//		test.log(LogStatus.INFO, "User entered \"6\" nights staying time");	
//		 bookingPage.selectNoMoreCitiesBtn();
//		test.log(LogStatus.INFO, "Click on No More Cities Button");
//		bookingPage.selectGuestDetails("1|Other");
//		test.log(LogStatus.INFO, "User select \"1 Room With Other Options\" from Guest list");
//		test.log(LogStatus.INFO, "All the basic booking details Source & Destination filled successfully for 1_Adult_1Child_With_SingleRoom");
//		
//		//Logs.info("All the basic booking details Source & Destination filled successfully for 1_Adult_1Child_With_SingleRoom");
//		bookingPage.selectNumberOfAdult("1", BookingLocators.getselectAdultDrpdown());
//		bookingPage.selectnumberofadultsRoom_1iOS();
//		test.log(LogStatus.INFO, "User selects \"1\" Adult from Adult Drpdown");
//		bookingPage.selectNumberOfChild("1", "9", "Child1");
//		bookingPage.doneButtonMob();
//		test.log(LogStatus.INFO, "User selects \"1\" Child,\"Age of Child:9\"");
//		test.log(LogStatus.INFO, "No.of Child & Age of Child got selected successfully");
//		//Logs.info("No.of Child & Age of Child got selected successfully");
//		bookingPage.clickonContinueButton();
//		test.log(LogStatus.INFO, "Click on Continue Button");
//		//Logs.info("Click on Continue Button");
//		bookingPage.selectCheaperFlights();
//		test.log(LogStatus.INFO, "User clicks on Select Cheaper Flights Link");
//		test.log(LogStatus.INFO, "User selects a particular flight from existing options");
//		test.log(LogStatus.INFO, "User clicks on Continue Link");
//		//Logs.info("Select Cheaper flights from flight options");
//		bookingPage.clicktoContinuePage();
//		bookingPage.getTripinclusionContinueButton();
//	    expectedFirstTravellerInfo = passengerInfoPage.fillFirstTravellerDetails("Morris", "Mano", "Male","01/01/1992", "237|US");
//		test.log(LogStatus.INFO, "User enters \"Morris\" as First Traveller First Name");
//		test.log(LogStatus.INFO, "User enters \"Mano\" as First Traveller Last Name");
//      	test.log(LogStatus.INFO, "User selects \"Gender:Male\" for First Traveller Last Name");
//		test.log(LogStatus.INFO, "User selects \"DOB:01/01/1992\" for First Traveller's Date of Birth");
//		test.log(LogStatus.INFO, "User selects \"Passport details as:US\" for First Traveller");
//		expectedSecondTravellerInfo = passengerInfoPage.fillSecondTravellerDetails("Shally", "Mano", "Female","01/01/1994", "237|US", "Child");
//		test.log(LogStatus.INFO, "User enters \"Shally\" as Second Traveller First Name");
//		test.log(LogStatus.INFO, "User enters \"Mano\" as Second Traveller Last Name");
//		test.log(LogStatus.INFO, "User selects \"Female\" for Second Traveller Last Name");
//		test.log(LogStatus.INFO, "User selects \"DOB:01/01/1994\" for Second Traveller's Date of Birth");
//		test.log(LogStatus.INFO, "User selects \"Passport details as:US\" for Second Traveller");
//		bookingPage.getTripinclusionContinueButton();
//		bookingPage.clicktoContinuePage();
//		test.log(LogStatus.INFO, "User filled all the passenger details successfully");
//		//Logs.info("User filled all the passenger details successfully");
//		PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler1Name(), expectedFirstTravellerInfo);
//		PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler2Name(), expectedSecondTravellerInfo);
//		test.log(LogStatus.INFO, "Flights & passenger details verified successfully on PaymentPage");
//		//Logs.info("Flights & passenger details verified successfully on PaymentPage");
//		
//	}
//	//vaishali
	  @Test(groups= {"smoke"},priority=3 ,alwaysRun = true)
	public void bookingTwoRoomThreeAdultAndOneChildWithMultipleCities_AdditionalChanges_TC_3(Method method) throws Exception {
		ExtentTest test = ExtentTestManager.startTest(method.getName(), "bookingTwoRoomThreeAdultAndOneChildWithMultipleCities_AdditionalChanges_TC_3");
		bookingPage.clickOnBuildYourVacationDropDown();
		PageBase.waitForElement(3);
		bookingPage.fillLeavingFromDetails("Seattle, WA");
		test.log(LogStatus.INFO, "User entered \"Seattle, WA\" into leaving from field");
		bookingPage.selectValueFromCalendar(75);
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
		bookingPage.selectCheaperFlights();
		test.log(LogStatus.INFO, "User clicks on Select Cheaper Flights Link");
		test.log(LogStatus.INFO, "User selects a particular flight from existing options");
		test.log(LogStatus.INFO, "User clicks on Continue Link");
		PageBase.waitForElement(10);
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
// 
//	
//	
//
////@Test(groups= {"smoke"},priority=3)
//	public void bookingTwoRoomTwoAdult_TC_3(Method method) throws Exception {
//		ExtentTest test = ExtentTestManager.startTest(method.getName(), "bookingTwoRoom2Adult");
//		bookingPage.clickOnBuildYourVacationDropDown();
//		bookingPage.fillLeavingFromDetails("San Jose SJC (CA), US");
//		
//		test.log(LogStatus.INFO, "User entered \"San Jose SJC (CA), US\" into leaving from field");
//		bookingPage.fillGoingToCityDetails("Osaka (Japan)");
//		test.log(LogStatus.INFO, "User entered \"Osaka (Japan)\" into Going to from field");
//		bookingPage.selectValueFromCalendar();
//		bookingPage.selectStayingTime("6");
//		test.log(LogStatus.INFO, "User entered \"6\" nights staying time");	
//		bookingPage.selectNoMoreCitiesBtn();
//		test.log(LogStatus.INFO, "Click on No More Cities Button");
//		bookingPage.selectGuestDetails("2|2-2");
//		test.log(LogStatus.INFO, "User select \"2 Room For Two Adults\" from Guest list");
//		test.log(LogStatus.INFO, "All the Basic Booking details Source & Destination filled successfully for Two Adults");
//		//Logs.info("All the Basic Booking details Source & Destination filled successfully for Two Adults");
//		bookingPage.clickonContinueButton();
//		test.log(LogStatus.INFO, "Click on Continue Button");
//		//Logs.info("Click on Continue Button");
//		bookingPage.selectCheaperFlights();
//		test.log(LogStatus.INFO, "User clicks on Select Cheaper Flights Link");
//		test.log(LogStatus.INFO, "User selects a particular flight from existing options");
//		test.log(LogStatus.INFO, "User clicks on Continue Link");
//		//Logs.info("Select Cheaper flights from flight options");
//		bookingPage.getTripinclusionContinueButton();
//		bookingPage.clicktoContinuePage();
//		expectedFirstTravellerInfo = passengerInfoPage.fillTravellerDetailsForMultipleRooms("Room1Traveller1");
//		test.log(LogStatus.INFO, "User enters \"yury\" as Traveller1 First Name");
//		test.log(LogStatus.INFO, "User enters \"darwin\" as Traveller1 Last Name");
//		test.log(LogStatus.INFO, "User selects \"Gender:Male\" for Traveller1 ");
//		test.log(LogStatus.INFO, "User selects \"DOB:01/01/2000\" for Traveller1 Date of Birth");
//		test.log(LogStatus.INFO, "User selects \"Passport details as:US\" for Traveller1");
//		expectedSecondTravellerInfo = passengerInfoPage.fillTravellerDetailsForMultipleRooms("Room1Traveller2");
//		test.log(LogStatus.INFO, "User enters \"Larry\" as Traveller2 First Name");
//		test.log(LogStatus.INFO, "User enters \"darwin\" as Traveller2 Last Name");
//		test.log(LogStatus.INFO, "User selects \"Gender:Male\" for Traveller2 ");
//		test.log(LogStatus.INFO, "User selects \"DOB:01/01/2000\" for Traveller2 Date of Birth");
//		test.log(LogStatus.INFO, "User selects \"Passport details as:US\" for Traveller2");
//		PageBase.scrollDown();
//		expectedThirdTravellerInfo = passengerInfoPage.fillTravellerDetailsForMultipleRooms("Room2Traveller1");
//		test.log(LogStatus.INFO, "User enters \"Hanna\" as Traveller3 First Name");
//		test.log(LogStatus.INFO, "User enters \"darwin\" as Traveller3 Last Name");
//		test.log(LogStatus.INFO, "User selects \"Gender:Male\" for Traveller3 ");
//		test.log(LogStatus.INFO, "User selects \"DOB:01/01/2000\" for Traveller3 Date of Birth");
//		test.log(LogStatus.INFO, "User selects \"Passport details as:US\" for Traveller3");
//		expectedFourthTravellerInfo = passengerInfoPage.fillTravellerDetailsForMultipleRooms("Room2Traveller2");
//		test.log(LogStatus.INFO, "User enters \"Erwin\" as Traveller3 First Name");
//		test.log(LogStatus.INFO, "User enters \"George\" as Traveller3 Last Name");
//		test.log(LogStatus.INFO, "User selects \"Gender:Male\" for Traveller3 ");
//		test.log(LogStatus.INFO, "User selects \"DOB:01/01/2002\" for Traveller3 Date of Birth");
//		test.log(LogStatus.INFO, "User selects \"Passport details as:US\" for Traveller3");
//		bookingPage.getTripinclusionContinueButton();
//		bookingPage.clicktoContinuePage();
//		test.log(LogStatus.INFO, "User filled all the passenger details successfully");
//		//Logs.info("User filled all the passenger details successfully");
//		if(TestBase.flag_Mob) {
//			PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler1NameiOS(), expectedFirstTravellerInfo);
//			PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler2NameiOS(), expectedSecondTravellerInfo);
//			PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler3NameiOS(), expectedThirdTravellerInfo);
//			PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler4NameiOS(), expectedFourthTravellerInfo);
//		}else {
//			PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler1Name(), expectedFirstTravellerInfo);
//			PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler2Name(), expectedSecondTravellerInfo);
//			PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler3Name(), expectedThirdTravellerInfo);
//			PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler4Name(), expectedFourthTravellerInfo);
//		}
//		test.log(LogStatus.INFO, "Flights & passenger details verified successfully on PaymentPage");
//		//Logs.info("Flights & passenger details verified successfully on PaymentPage");
//	}
//
//	//@Test(groups= {"smoke"},priority=4)
//	public void bookingTwoRoomThreeAdultOneChild_TC_4(Method method) throws Exception {
//		 ExtentTest test = ExtentTestManager.startTest(method.getName(), "bookingTwoRoom3Adult1Child");
//		bookingPage.clickOnBuildYourVacationDropDown();
//		PageBase.waitForElement(3);
//		bookingPage.fillLeavingFromDetails("New York, Newark, NJ");
//		test.log(LogStatus.INFO, "User entered \"New York, Newark, NJ\" into leaving from field");
//		bookingPage.fillGoingToCityDetails("Berlin (Germany)");
//		test.log(LogStatus.INFO, "User entered \"Berlin (Germany)\" into Going to from field");
//		bookingPage.selectValueFromCalendar();
//		bookingPage.selectStayingTime("4");
//		test.log(LogStatus.INFO, "User entered \"4\" nights staying time");	
//		bookingPage.selectNoMoreCitiesBtn();
//		test.log(LogStatus.INFO, "Click on No More Cities Button");
//		bookingPage.selectGuestDetails("2|Other");
//		test.log(LogStatus.INFO, "User select \"Three Adults & One Child\" from Guest list");
//		test.log(LogStatus.INFO, "Booking details filled successfully for Three Adults & One Child");
//		//Logs.info("Booking details filled successfully for Three Adults & One Child");
//		bookingPage.select2NumberOfAdultForRoom1("2", BookingLocators.getselectAdultDrpdown());
//		bookingPage.selectNumberOfChild("1", "9", "Child1");
//		test.log(LogStatus.INFO, "No.of Child & Age of Child got selected successfully");
//		//Logs.info("No.of Child & Age of Child got selected successfully");
//		bookingPage.select1NumberOfAdultForRoom2("1", BookingLocators.getselectAdultRoom2Drpdown());
//		bookingPage.doneButtonMob();
//		bookingPage.clickonContinueButton();
//		test.log(LogStatus.INFO, "Click on Continue Button");
//		//Logs.info("Click on Continue Button");
//		bookingPage.selectCheaperFlights();
//		test.log(LogStatus.INFO, "User clicks on Select Cheaper Flights Link");
//		test.log(LogStatus.INFO, "User selects a particular flight from existing options");
//		test.log(LogStatus.INFO, "User clicks on Continue Link");
//		//Logs.info("Select Cheaper flights from flight options");
//		bookingPage.getTripinclusionContinueButton();
//		bookingPage.clicktoContinuePage();
//		expectedFirstTravellerInfo = passengerInfoPage.fillTravellerDetailsForMultipleRooms("Room1Traveller1");
//		test.log(LogStatus.INFO, "User enters \"yury\" as Traveller1 First Name");
//		test.log(LogStatus.INFO, "User enters \"darwin\" as Traveller1 Last Name");
//		test.log(LogStatus.INFO, "User selects \"Gender:Male\" for Traveller1 ");
//		test.log(LogStatus.INFO, "User selects \"DOB:01/01/2000\" for Traveller1 Date of Birth");
//		test.log(LogStatus.INFO, "User selects \"Passport details as:US\" for Traveller1");
//		expectedSecondTravellerInfo = passengerInfoPage.fillTravellerDetailsForMultipleRooms("Room1Traveller2");
//		test.log(LogStatus.INFO, "User enters \"Larry\" as Traveller2 First Name");
//		test.log(LogStatus.INFO, "User enters \"darwin\" as Traveller2 Last Name");
//		test.log(LogStatus.INFO, "User selects \"Gender:Male\" for Traveller2 ");
//		test.log(LogStatus.INFO, "User selects \"DOB:01/01/2000\" for Traveller2 Date of Birth");
//		test.log(LogStatus.INFO, "User selects \"Passport details as:US\" for Traveller2");
//		expectedThirdTravellerInfo = passengerInfoPage.fillTravellerDetailsForMultipleRooms("Room1Child1");
//		test.log(LogStatus.INFO, "User enters \"Hanna\" as Traveller3 First Name");
//		test.log(LogStatus.INFO, "User enters \"darwin\" as Traveller3 Last Name");
//		test.log(LogStatus.INFO, "User selects \"Gender:Male\" for Traveller3 ");
//		test.log(LogStatus.INFO, "User selects \"DOB:01/01/2000\" for Traveller3 Date of Birth");
//		test.log(LogStatus.INFO, "User selects \"Passport details as:US\" for Traveller3");
//		expectedFourthTravellerInfo = passengerInfoPage.fillTravellerDetailsForMultipleRooms("Room2Traveller1");
//		test.log(LogStatus.INFO, "User enters \"Erwin\" as Traveller4 First Name");
//		test.log(LogStatus.INFO, "User enters \"George\" as Traveller4 Last Name");
//		test.log(LogStatus.INFO, "User selects \"Gender:Male\" for Traveller4 ");
//		test.log(LogStatus.INFO, "User selects \"DOB:01/01/2002\" for Traveller4 Date of Birth");
//		test.log(LogStatus.INFO, "User selects \"Passport details as:US\" for Traveller4");
//		bookingPage.clicktoContinuePage();
//		test.log(LogStatus.INFO, "User filled all the passenger details successfully");
//		//Logs.info("User filled all the passenger details successfully");
//		bookingPage.getTripinclusionContinueButton();
//		if(TestBase.flag_Mob)
//		{
//			PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler1NameiOS(), expectedFirstTravellerInfo);
//			PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler2NameiOS(), expectedSecondTravellerInfo);
//			PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler3NameMob(), expectedThirdTravellerInfo);
//			PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler4NameiOS(), expectedFourthTravellerInfo);
//			
//			}
//		else
//		{
//			PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler1Name(), expectedFirstTravellerInfo);
//			PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler2Name(), expectedSecondTravellerInfo);
//			PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler3Name(), expectedThirdTravellerInfo);
//			PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler4Name(), expectedFourthTravellerInfo);
//		}
//		test.log(LogStatus.INFO, "Flights & passenger details verified successfully on PaymentPage");
//		//Logs.info("Flights & passenger details verified successfully on PaymentPage");
//	}
//	
//	//4
	@Test(groups= {"smoke"},priority=4)
	public void flightBookingWithFirstPackage_TC_4_Additional_changes(Method method) throws Exception {
		ExtentTest test = ExtentTestManager.startTest(method.getName(), "flightBookingWithFirstPackage_TC_4_Additional_changes");
		bookingPage.getexploreLink();
		test.log(LogStatus.INFO, "User clicks on Explore link");
		bookingPage.fillLeavingFromDetails("Washington (all Airports), DC");
		test.log(LogStatus.INFO, "User entered \"Washington (all Airports), DC\" into leaving from field");
		bookingPage.selectGuestDetails("1|2");
		test.log(LogStatus.INFO, "User select \"Two Adults\" from Guest list");
		test.log(LogStatus.INFO, "Booking details filled successfully for Two Adults");
		bookingPage.clickOnViewPrice();
		test.log(LogStatus.INFO, "Booking details filled successfully for Two Adults");
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
//	
//	//vaishali
		@Test(groups= {"smoke"},priority=5)
	public void bookingTwoRoomTwoAdultTwoChild_WithChanges_TC_5(Method method) throws Exception {
		ExtentTest test = ExtentTestManager.startTest(method.getName(), "bookingTwoRoomTwoAdultTwoChild_WithChanges_TC_5");
		PageBase.scrollDownForMob(1);
		homePage.clickOnExploreEuropeLink();
		test.log(LogStatus.INFO, "User clicked on Explore Europe Link");
		bookingPage.clickOnPackageDisplayedUnderSuggestedVacationPackageOption();
		test.log(LogStatus.INFO, "User clicked on particular vacation package");
		bookingPage.clickOnReorderCitiesLink();
		test.log(LogStatus.INFO, "User clicked on Reorder cities link");
		bookingPage.fillLeavingFromDetailsOnEuropePage("Chicago (All Airports)");
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
//	
//	
//	
//	
//	
//	
//	
//
//	//@Test(groups= {"smoke"},priority=5)
//	public void bookingTwoRoomTwoAdultTwoChild_TC_5(Method method) throws Exception {
//		ExtentTest test = ExtentTestManager.startTest(method.getName(), "booking2Room2Adult2Child");
//		bookingPage.clickOnBuildYourVacationDropDown();
//		bookingPage.fillLeavingFromDetails("New York, Newark, NJ");
//		test.log(LogStatus.INFO, "User entered \"New York, Newark, NJ\" into leaving from field");
//		bookingPage.fillGoingToCityDetails("Berlin (Germany)");
//		test.log(LogStatus.INFO, "User entered \"Berlin (Germany)\" into Going to from field");
//		bookingPage.selectValueFromCalendar();
//		bookingPage.selectStayingTime("5");
//		test.log(LogStatus.INFO, "User entered \"5\" nights staying time");	
//		bookingPage.selectNoMoreCitiesBtn();
//		test.log(LogStatus.INFO, "Click on No More Cities Button");
//		bookingPage.selectGuestDetails("2|Other");
//		test.log(LogStatus.INFO, "User select \"Two Adults & Two Child\" from Guest list");
//		test.log(LogStatus.INFO, "Booking details filled successfully for Two Adults & Two Child");
//		//Logs.info("Booking details filled successfully for Two Adults & Two Child");
//		//bookingPage.selectNumberOfAdult("1", BookingLocators.getselectAdultDrpdown());
//		bookingPage.selectnumberofadultsRoom_1iOS();
//		bookingPage.selectNumberOfChild("1", "9", "Child1");
//		test.log(LogStatus.INFO, "No.of Child & Age of Child got selected successfully");
//		//Logs.info("No.of Child & Age of Child got selected successfully");
//		bookingPage.selectNumberOfAdult("1", BookingLocators.getselectAdultRoom2Drpdown());
//		bookingPage.selectnumberofadultsRoom_2iOS();
//		bookingPage.selectNumberOfChild("1", "9", "Child2");
//		bookingPage.doneButtonMob();
//		bookingPage.clickonContinueButton();
//		PageBase.waitForElement(3);
//		test.log(LogStatus.INFO, "Click on Continue Button");
//		//Logs.info("Click on Continue Button");
//		bookingPage.selectCheaperFlights();
//		test.log(LogStatus.INFO, "User clicks on Select Cheaper Flights Link");
//		test.log(LogStatus.INFO, "User selects a particular flight from existing options");
//		test.log(LogStatus.INFO, "User clicks on Continue Link");
//		//Logs.info("Select Cheaper flights from flight options");
//		bookingPage.clicktoContinuePage();
//		bookingPage.getTripinclusionContinueButton();
//		expectedFirstTravellerInfo = passengerInfoPage.fillTravellerDetailsForMultipleRooms("Room1Traveller1");
//		test.log(LogStatus.INFO, "User enters \"yury\" as Traveller1 First Name");
//		test.log(LogStatus.INFO, "User enters \"darwin\" as Traveller1 Last Name");
//		test.log(LogStatus.INFO, "User selects \"Gender:Male\" for Traveller1 ");
//		test.log(LogStatus.INFO, "User selects \"DOB:01/01/2000\" for Traveller1 Date of Birth");
//		test.log(LogStatus.INFO, "User selects \"Passport details as:US\" for Traveller1");
//		expectedSecondTravellerInfo = passengerInfoPage.fillTravellerDetailsForMultipleRooms("Room1Child1SingleTravlr");
//		test.log(LogStatus.INFO, "User enters \"Erwin\" as Traveller2 First Name");
//		test.log(LogStatus.INFO, "User enters \"George\" as Traveller2 Last Name");
//		test.log(LogStatus.INFO, "User selects \"Gender:Male\" for Traveller2 ");
//		test.log(LogStatus.INFO, "User selects \"DOB:01/01/2000\" for Traveller2 Date of Birth");
//		test.log(LogStatus.INFO, "User selects \"Passport details as:US\" for Traveller2");
//		expectedThirdTravellerInfo = passengerInfoPage.fillTravellerDetailsForMultipleRooms("Room2Traveller1");
//		test.log(LogStatus.INFO, "User enters \"Hanna\" as Traveller3 First Name");
//		test.log(LogStatus.INFO, "User enters \"darwin\" as Traveller3 Last Name");
//		test.log(LogStatus.INFO, "User selects \"Gender:Male\" for Traveller3 ");
//		test.log(LogStatus.INFO, "User selects \"DOB:01/01/2000\" for Traveller3 Date of Birth");
//		test.log(LogStatus.INFO, "User selects \"Passport details as:US\" for Traveller3");
//		expectedFourthTravellerInfo = passengerInfoPage.fillTravellerDetailsForMultipleRooms("Room2Child1SingleTravlr");
//		test.log(LogStatus.INFO, "User enters \"Erwin\" as Traveller3 First Name");
//		test.log(LogStatus.INFO, "User enters \"George\" as Traveller3 Last Name");
//		test.log(LogStatus.INFO, "User selects \"Gender:Male\" for Traveller3 ");
//		test.log(LogStatus.INFO, "User selects \"DOB:01/01/2002\" for Traveller3 Date of Birth");
//		test.log(LogStatus.INFO, "User selects \"Passport details as:US\" for Traveller3");
//		test.log(LogStatus.INFO, "User filled all the passenger details successfully");
//		//Logs.info("User filled all the passenger details successfully");
//		bookingPage.getTripinclusionContinueButton();
//		bookingPage.clicktoContinuePage();
//		test.log(LogStatus.INFO, "Click on Continue Button & User redirected to the Payment Page");
//		PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler1Name(), expectedFirstTravellerInfo);
//		PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler2Name(), expectedSecondTravellerInfo);
//		PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler3Name(), expectedThirdTravellerInfo);
//		PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler4Name(), expectedFourthTravellerInfo);
//		test.log(LogStatus.INFO, "Flights & passenger details verified successfully on PaymentPage");
//		//Logs.info("Flights & passenger details verified successfully on PaymentPage");
//	}
//	
//	
//	
//	
//	
//	
//	
//	
////6
	@Test(groups= {"smoke"},priority=6)
	public void bookingFlightsWithmultipleCities_TC_6(Method method) throws Exception {
		ExtentTest test = ExtentTestManager.startTest(method.getName(), "bookingFlightsWithmultipleCities_TC_6");
		homePage.clickOnExploreAsiaLink();
		test.log(LogStatus.INFO, "User Clicks on Explore Asia Link");
		homePage.verifyHighLightsandAttractions();
		test.log(LogStatus.INFO, "Verify Highlights option is available");
		homePage.verifyfirsthighlightandAttraction();
		test.log(LogStatus.INFO, "Verify First Highlight option available on page");
		homePage.clickOntitle();
		bookingPage.clickOnBuildYourVacationDropDown();
		PageBase.waitForElement(3);
		bookingPage.fillLeavingFromDetails("New York, Newark, NJ");
		test.log(LogStatus.INFO, "User entered \"New York, Newark, NJ\" into leaving from field");
		bookingPage.fillGoingToCityDetails("Berlin (Germany)");
		test.log(LogStatus.INFO, "User entered \"Berlin (Germany)\" into Going to from field");
		bookingPage.clickOnAddCityBtn();
		bookingPage.fillSecndAddedCityDetails("Augsburg (Germany)");
		test.log(LogStatus.INFO, "User entered \"Augsburg (Germany)\" into Going to from field");
		bookingPage.selectStayingTime("4");
		bookingPage.selectNoMoreCitiesBtn();
		bookingPage.selectGuestDetails("1|Other");
		//bookingPage.fillBasicBookingDetailForMultipleCities("WithAir", "Berlin (Germany)", "4", "Augsburg (Germany)","1|Other");
		test.log(LogStatus.INFO, "Booking details filled successfully for multiple cities");
		//Logs.info("Booking details filled successfully for multiple cities");
		bookingPage.clickonContinueButton();
		PageBase.waitForElement(3);
		test.log(LogStatus.INFO, "Click on Continue Button");
		//Logs.info("Click on Continue Button");
		bookingPage.selectCheaperFlights();
		test.log(LogStatus.INFO, "User clicks on Select Cheaper Flights Link");
		test.log(LogStatus.INFO, "User selects a particular flight from existing options");
		test.log(LogStatus.INFO, "User clicks on Continue Link");
		//Logs.info("Select Cheaper flights from flight options");
		bookingPage.getTripinclusionContinueButton();
		bookingPage.clicktoContinuePage();
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
	}
//	//7
	@Test(groups= {"smoke"},priority=7)
	public void bookingFlightAndHotelForSingleCity_TC_7(Method method) throws Exception {
		ExtentTest test=ExtentTestManager.startTest(method.getName(), "bookingFlightAndHotelForSingleCity_TC_7");
		homePage.topdeals();
		test.log(LogStatus.INFO, "User clicks on Top Deals");
		Thread.sleep(5000);
		homePage.validateTopDealsPage();
		test.log(LogStatus.INFO, "Verifies that User is on top deal page");
		homePage.validatetopDealsList();
		test.log(LogStatus.INFO, "Verifies the top deals list of the week");
		Thread.sleep(5000);
		homePage.clickOntitle();
		test.log(LogStatus.INFO, "User clicks on Homepage link");
		bookingPage.clickOnBuildYourVacationDropDown();
		bookingPage.fillLeavingFromDetails("New York, Newark, NJ");
		test.log(LogStatus.INFO, "User entered \"New York, Newark, NJ\" into leaving from field");
		bookingPage.fillGoingToCityDetails("Delhi (India)");
		test.log(LogStatus.INFO, "User entered \"Delhi (India)\" into Going to from field");
		bookingPage.selectValueFromCalendar(180);
		bookingPage.selectStayingTime("6");
		test.log(LogStatus.INFO, "User entered \"6\" nights staying time");	
		bookingPage.selectNoMoreCitiesBtn();
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Click on No More Cities Button");
		bookingPage.selectGuestDetails("2|Other");
		test.log(LogStatus.INFO, "User select \"3 Adults_4nights\" from Guest list");
		test.log(LogStatus.INFO, "All the basic booking details Source & Destination filled successfully for 3 Adults_4nights");
		test.log(LogStatus.INFO, "Booking details filled successfully for single city");
		//Logs.info("Booking details filled successfully for single city");
		bookingPage.selectNumberOfAdult("1", BookingLocators.getselectAdultDrpdown());
		bookingPage.selectnumberofadultsRoom_1iOS();
		bookingPage.selectNumberOfChild("1", "9", "Child1");
		test.log(LogStatus.INFO, "No.of Child & Age of Child got selected successfully");
		//Logs.info("No.of Child & Age of Child got selected successfully");
		bookingPage.selectNumberOfAdult("1", BookingLocators.getselectAdultRoom2Drpdown());
		bookingPage.selectnumberofadultsRoom_2iOS();
		bookingPage.clickonContinueButton();
		test.log(LogStatus.INFO, "Click on Continue Button");
		//Logs.info("Click on Continue Button");
		PageBase.scrollDownForMob(2);
		ActualHotel = bookingPage.browseHotelsButton();
		test.log(LogStatus.INFO, "Click on Browse Hotels Button");
		//Logs.info("Click on Browse Hotels Button");
		bookingPage.selectFirstHotel();
		PageBase.scrollDownForMob(1);
		ExpectedHotel = bookingPage.browseSelectHotel();
		test.log(LogStatus.INFO, "Select particular hotel from Hotel Options");
		//Logs.info("Select particular hotel from Hotel Options");
		bookingPage.clicktoContinuePage();
		PageBase.waitForElement(3);
		String expected = bookingPage.selectCheaperFlights();
		test.log(LogStatus.INFO, "Select Cheaper flights from flight options");
		//Logs.info("Select Cheaper flights from flight options");
		String actualFlightDetails = bookingPage.getActualFlight();
		System.out.println("Actual is:" +actualFlightDetails   + " "+ "Expected is :"+expected);
		Assert.assertTrue(expected.contains(actualFlightDetails));
		test.log(LogStatus.INFO, "Verify that only selected flight appears along with passenger details");
		//Logs.info("Verify that only selected flight appears along with passenger details");
		Assert.assertEquals(ActualHotel, ExpectedHotel);
		test.log(LogStatus.INFO, "Verify that only particular selected hotel appears along with passenger details");
		//Logs.info("Verify that only particular selected hotel appears along with passenger details");
	}
//	
//	
//	
	//8
	@Test(groups= {"smoke"},priority=8)
	  public void europePageBookingForMultipleCities_TC_8(Method method) throws Exception {
		ExtentTest test=ExtentTestManager.startTest(method.getName(), "europePageBookingForMultipleCities_TC_8");
		homePage.clickOnExploreEuropeLink();
		test.log(LogStatus.INFO, "User clicks on explore europe page link");
		 bookingPage.clickOnBuildYourVacationDropDown();
		 bookingPage.fillLeavingFromDetails("New York City (all Airports),  NY");
		 test.log(LogStatus.INFO, "User entered \"New York City (all Airports),  NY\" into leaving from field");
		 bookingPage.fillGoingToCityDetails("Rome (Italy)");
		 test.log(LogStatus.INFO, "User entered \"Rome (Italy)\" into going to field");
		 //bookingPage.selectValueFromCalendar(90);
		 String selectDate=bookingPage.selectValueFromCalendar(90);
		 test.log(LogStatus.INFO,   "User selects '" + selectDate + "'from calendar");
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
			bookingPage.cheaperFlightbutton();
			actualsecondCityHotel = bookingPage.secondCityHotelName();
			PageBase.waitForElement(10);
			Assert.assertEquals(actualsecondCityHotel, expectedSecondcityHotel);
			test.log(LogStatus.INFO, "Verifiy that only particular selected hotel appears along with passenger details");
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
//	
//	
//	
//	
//		
//	//@Test(groups= {"smoke"},priority=8)
//	public void bookingFlightAndHotelForMultipleCity_TC_8(Method method) throws Exception {
//		ExtentTest test=ExtentTestManager.startTest(method.getName(), "bookingFlightAndHotelForMultipleCity");
//		bookingPage.clickOnBuildYourVacationDropDown();
//		bookingPage.fillLeavingFromDetails("New York, Newark, NJ");
//		bookingPage.fillGoingToCityDetails("Berlin (Germany)");
//		bookingPage.selectStayingTime("4");
//		bookingPage.clickOnAddCityBtn();
//		bookingPage.fillSecndAddedCityDetails("Augsburg (Germany)");
//		bookingPage.selectStayingTimeTwo("5");
//		bookingPage.selectNoMoreCitiesBtn();
//		bookingPage.selectGuestDetails("1|2");
//		test.log(LogStatus.INFO, "Booking details filled successfully for multiple cities");
//		//Logs.info("Booking details filled successfully for multiple cities");
//		bookingPage.clickonContinueButton();
//		test.log(LogStatus.INFO, "Click on Continue Button");
//		//Logs.info("Click on Continue Button");
//		ActualHotel = bookingPage.browseHotelsButton();
//		test.log(LogStatus.INFO, "Click on Browse Hotels Button");
//		//Logs.info("Click on Browse Hotels Button");
//		
//		ExpectedHotel = bookingPage.browseSelectHotel();
//		test.log(LogStatus.INFO, "Select particular hotel from Hotel Options");
//		//Logs.info("Select particular hotel from Hotel Options");
//		System.out.println("actual = "+ActualHotel+"Expected = "+ExpectedHotel);
//		Assert.assertEquals(ActualHotel, ExpectedHotel);
//		bookingPage.selectFirstHotel();
//		PageBase.scrollDownForMob(1);
//		bookingPage.selectCheaperFlights();
//		test.log(LogStatus.INFO, "Select Cheaper flights from flight options");
//		//Logs.info("Select Cheaper flights from flight options");
//		bookingPage.getTripinclusionContinueButton();
//		bookingPage.clicktoContinuePage();
//		bookingPage.clicktoContinuePage();
//		expectedFirstTravellerInfo = passengerInfoPage.fillFirstTravellerDetails("Morris", "Leo", "Male","01/01/1992", "237|US");
//		expectedSecondTravellerInfo = passengerInfoPage.fillSecondTravellerDetails("Shally", "Leo", "Male","01/01/1994", "237|US", "Adult");
//		test.log(LogStatus.INFO, "User filled all the passenger details successfully");
//		//Logs.info("User filled all the passenger details successfully");
//		
//		bookingPage.clicktoContinuePage();
//		bookingPage.getTripinclusionContinueButton();
//		if(TestBase.flag_Mob){
//			PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler1NameiOS(), expectedFirstTravellerInfo);
//			PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler2NameiOS(), expectedSecondTravellerInfo);
//		}else{
//		PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler1Name(), expectedFirstTravellerInfo);
//		PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler2Name(), expectedSecondTravellerInfo);
//		}
//		test.log(LogStatus.INFO, "Flights & passenger details verified successfully on PaymentPage");
//		//Logs.info("Flights & passenger details verified successfully on PaymentPage");
//	}
//	
//
//	// @Test(groups= {"regression"},priority=9)
//	public void withoutAirBookingForSingleCity_TC_19(Method method) throws Exception {
//		ExtentTest test=ExtentTestManager.startTest(method.getName(), "withoutAirBookingForSingleCity_TC_19");
//		bookingPage.selectWithoutAir();
//		test.log(LogStatus.INFO, "Select withOut Air Option on HomePage");
//		//Logs.info("Select withOut Air Option on HomePage");
//		bookingPage.fillLeavingFromDetails("San Francisco (USA)");
//		bookingPage.selectStayingTime("5");
//		bookingPage.selectNoMoreCitiesBtn();
//		bookingPage.selectGuestDetails("1|3");
//		test.log(LogStatus.INFO, "User fills all the basic details of journey:Source,Destination & Staying Time");
//		//Logs.info("User fills all the basic details of journey:Source,Destination & Staying Time");
//		bookingPage.clickonContinueButton();
//		test.log(LogStatus.INFO, "Click on Continue Button");
//		//Logs.info("Click on Continue Button");
//		String Actualresult = bookingPage.browseHotelsButton();
//		test.log(LogStatus.INFO, "Click on Browse Hotels Button");
//		//Logs.info("Click on Browse Hotels Button");
//		String expectedresult = bookingPage.browseSelectHotel();
//		test.log(LogStatus.INFO, "Select particular hotel from Hotel Options");
//		//Logs.info("Select particular hotel from Hotel Options");
//		Assert.assertEquals(Actualresult, expectedresult);
//		test.log(LogStatus.INFO, "Verify that only particular selected hotel appears along with passenger details");
//		//Logs.info("Verify that only particular selected hotel appears along with passenger details");
//	}
//	 
//	 //@Test(groups= {"regression"},priority=10)
//	public void getWithoutAir_TC_20(Method method) throws Exception {
//		ExtentTest test=ExtentTestManager.startTest(method.getName(), "getWithoutAir");
//		bookingPage.getWithoutButton();
//		test.log(LogStatus.INFO, "Click on WithOut Air Button");
//		//Logs.info("Click on WithOut Air Button");
//		bookingPage.fillLeavingFromDetails("New York, Newark, NJ");
//		bookingPage.fillGoingToCityDetails("Delhi (India)");
//		bookingPage.clickOnAddCityBtn();
//		bookingPage.fillSecndAddedCityDetails("Mumbai (India)");
//		bookingPage.selectStayingTime("4");
//		bookingPage.selectNoMoreCitiesBtn();
//		bookingPage.selectGuestDetails("1|3");
//		//bookingPage.fillBasicBookingDetailForMultipleCities("WithOutAir", "Delhi (India)", "4", "Mumbai (India)","1|3");
//		test.log(LogStatus.INFO, "Filled all the basic details of journey along with source & destination");
//		//Logs.info("Filled all the basic details of journey along with source & destination");
//		bookingPage.clickonContinueButton();
//		ActualHotel = bookingPage.browseHotelsButton();
//		test.log(LogStatus.INFO, "Click on Browse Hotels Button");
//		//Logs.info("Click on Browse Hotels Button");
//		ExpectedHotel = bookingPage.browseSelectHotel();
//		test.log(LogStatus.INFO, "Select particular hotel from Hotel Options");
//		//Logs.info("Select particular hotel from Hotel Options");
//		Assert.assertEquals(ActualHotel, ExpectedHotel);
//		test.log(LogStatus.INFO, "Verify that only particular selected hotel appears along with passenger details");
//		//Logs.info("Verify that only particular selected hotel appears along with passenger details");
//
//	}
//	
//	
	@Test(groups= {"smoke"},priority=10)
	public void multipleCities_TC_21(Method method) throws Exception {
		ExtentTest test=ExtentTestManager.startTest(method.getName(), "multipleCities");
		bookingPage.clickOnBuildYourVacationDropDown();
		bookingPage.fillLeavingFromDetails("Washington (all Airports), DC");
		test.log(LogStatus.INFO, "User entered \"Washington (all Airports), DC\" into leaving from field");
		bookingPage.fillGoingToCityDetails("London (England)");
		test.log(LogStatus.INFO, "User entered \"London (England)\" into Going to from field");
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
	
	
//	
//	
//
//	//@Test(groups= {"regression"},priority=11)
//	public void removeAddedCity_TC_17(Method method) throws Exception {
//		ExtentTest test=ExtentTestManager.startTest(method.getName(), "removeAddedCity");
//		bookingPage.clickOnBuildYourVacationDropDown();
//		bookingPage.fillLeavingFromDetails("New York, Newark, NJ");
//		bookingPage.fillGoingToCityDetails("Delhi (India)");
//		bookingPage.selectStayingTime("4");
//		bookingPage.clickOnAddCityBtn();
//		bookingPage.fillSecndAddedCityDetails("Mumbai (India)");
//		bookingPage.selectStayingTimeTwo("1");
//		bookingPage.clickOnAddCityBtn();
//		bookingPage.fillThirdAddedCityDetails("Bangalore (India)");
//		bookingPage.selectStayingTimeThree("1");
//		//bookingPage.fillBasicDetails("New York, Newark, NJ", "Delhi (India)", "4", "Mumbai (India)", "1","Chennai -Madras (India)", "1");
//		test.log(LogStatus.INFO, "Fill all the basic details for multiple cities");
//		test.log(LogStatus.INFO, "Adding multiple cities in destinations");
//		//Logs.info("Fill all the basic details for multiple cities");
//		//Logs.info("Adding multiple cities in destinations");
//
//		boolean actual = bookingPage.isremovecitydisplayed();
//		Assert.assertTrue(actual);
//		test.log(LogStatus.INFO,"Verify that multiple cities got selected as destinations");
//		test.log(LogStatus.INFO, "Verify that RemoveCity Link is also displayed for added cities");
//		//Logs.info("Verify that multiple cities got selected as destinations");
//		//Logs.info("Verify that RemoveCity Link is also displayed for added cities");
//		bookingPage.deleteAddedCities();
//		test.log(LogStatus.INFO, "Delete all the added cities");
//		//Logs.info("Delete all the added cities");
//		bookingPage.validateremovedcity();
//		test.log(LogStatus.INFO, "All the added cities removed successfully.Verified!");
//		//Logs.info("All the added cities removed successfully.Verified!");
//		bookingPage.getNoMoreCitiesButton();
//		bookingPage.selectGuestDetails("1|1");
//		test.log(LogStatus.INFO, "Select Guest Details");
//		bookingPage.clickonContinueButton();
//		bookingPage.selectCheaperFlights();
//		test.log(LogStatus.INFO, "Select Cheaper flights from flight options");
//		//Logs.info("Select Cheaper flights from flight options");
//		bookingPage.validateTripIncluisonPage();
//		test.log(LogStatus.INFO, "Validate that user is on TripInclusion Page");
//		//Logs.info("Validate that user is on TripInclusion Page");
//	}
////	//Vaishali
	@Test(groups= {"smoke"},priority=11)
	public void removeAddedCity_WithAdditonalChanges_TC_17(Method method) throws Exception {
		ExtentTest test=ExtentTestManager.startTest(method.getName(), "removeAddedCity_WithAdditonalChanges_TC_17");
		homePage.clickOnExploreAsiaLink();
		bookingPage.clickOnBuildYourVacationDropDown();
		PageBase.waitForElement(3);
		bookingPage.fillLeavingFromDetails("New York City (all Airports),  NY");
		test.log(LogStatus.INFO, "User entered \"New York, Newark, NJ\" into leaving from field");
		bookingPage.fillGoingToCityDetails("Delhi (India)");
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
		//test.log(LogStatus.INFO, "User entered \"4\" nights staying time for the Third city");
		//bookingPage.fillBasicDetails("New York, Newark, NJ", "Delhi (India)", "4", "Mumbai (India)", "1","Chennai -Madras (India)", "1");

		test.log(LogStatus.INFO, "Fill all the basic details for multiple cities");
		test.log(LogStatus.INFO, "Adding multiple cities in destinations");
		//logs.info("Fill all the basic details for multiple cities");
		//logs.info("Adding multiple cities in destinations");

		boolean actual = bookingPage.isremovecitydisplayed();
		Assert.assertTrue(actual);
		test.log(LogStatus.INFO,"Verify that multiple cities got selected as destinations");
		test.log(LogStatus.INFO, "Verify that RemoveCity Link is also displayed for added cities");

		//logs.info("Verify that multiple cities got selected as destinations");
		//logs.info("Verify that RemoveCity Link is also displayed for added cities");
		bookingPage.deleteAddedCities();
		test.log(LogStatus.INFO, "Delete all the added cities");
		//logs.info("Delete all the added cities");
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
		PageBase.waitForElement(3);
		bookingPage.selectNoMoreCitiesBtn();
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
//	
//	
//	
//	
//	
//
//	
	@Test(groups= {"regression"},priority=13)
	public void verifySpotlightLink_TC_14(Method method) throws Exception {
    	String PageTitle=null;
		ExtentTest test=ExtentTestManager.startTest(method.getName(), "verifySpotlightLink");
		bookingPage.selectLatinAmericaLink();
		test.log(LogStatus.INFO, "Select Latin America Link");
		//logs.info("Select Latin America Link");
		bookingPage.verifyLatinAmericPage();
		test.log(LogStatus.INFO, "User redirected to the Latin America Page");
		//logs.info("User redirected to the Latin America Page");
		
		
		//logs.info("User clicks on Spotlight button");
		//bookingPage.verifyPageDisplayed(title);
		//test.log(LogStatus.INFO, "Spotlight link verified!");
       // logs.info("Spotlight link verified!");

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
	
	
	

	
    @Test(groups= {"regression"},priority=14)
	public void dateChanging_TC_9(Method method) throws Exception {
		ExtentTest test=ExtentTestManager.startTest(method.getName(), "verify DateChanging functionality");
		bookingPage.clickOnBuildYourVacationDropDown();
		bookingPage.fillLeavingFromDetails("New York, Newark, NJ");
		bookingPage.fillGoingToCityDetails("Berlin (Germany)");
		bookingPage.selectStayingTime("12");
		bookingPage.selectNoMoreCitiesBtn();
		bookingPage.selectGuestDetails("1|Other");
		test.log(LogStatus.INFO, "Booking details Source & Destination filled successfully ");
		//Logs.info("Booking details Source & Destination filled successfully ");
		bookingPage.clickonContinueButton();
		bookingPage.clickChangedArriveDate();
		bookingPage.oldArriveDate();
		bookingPage.clickonContinueLink();
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

  @Test(groups= {"smoke"},priority=12)
		public void bookingDetailswithPremiumEcomomy_TC_18(Method method) throws Exception {
		   ExtentTest test =ExtentTestManager.startTest(method.getName(), "bookingDetailswithPremiumEcomomy");
			bookingPage.clickOnBuildYourVacationDropDown();
			bookingPage.selectCabinClass("Premium Economy");
			bookingPage.fillLeavingFromDetails("New York City (all Airports)");
			bookingPage.fillGoingToCityDetails("Delhi (India)");
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
			//Logs.info("Select Cheaper flights from flight options");
			//String expectedcabin = bookingPage.verifycabinAssert();
			//System.out.println("This is for Expected "+expectedcabin);
			/*if(TestBase.flag_Mob)
			{
				Assert.assertEquals(expectedcabin, actualcabin);
			}
			else {
			Assert.assertEquals(expectedcabin, actualcabinweb);
			}*/
			test.log(LogStatus.INFO, "bookingDetailswithPremiumEcomomy passed");
			//Logs.info("bookingDetailswithPremiumEcomomy passed");
		}
//  
// 
//  
  
//		
}
//
