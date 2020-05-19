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

//	@Test(groups = { "smoke" }, priority = 11)
//	public void bookingSingleRoomWithThreeAdults_TC_1(Method method) throws Exception {
//	    ExtentTest test = ExtentTestManager.startTest(method.getName(), "bookingSingleRoomWith3Adults");
//		bookingPage.clickOnBuildYourVacationDropDown();
//		bookingPage.fillLeavingFromDetails("New York, Newark, NJ");
//		test.log(LogStatus.INFO, "User entered \"New York, Newark, NJ\" into leaving from field");
//		bookingPage.fillGoingToCityDetails("Berlin (Germany)");
//		test.log(LogStatus.INFO, "User entered \"Berlin (Germany)\" into Going to from field");
//         bookingPage.selectValueFromCalendar(180);
//		bookingPage.selectStayingTime("4");
//		test.log(LogStatus.INFO, "User entered \"4\" nights staying time");	
//		bookingPage.selectNoMoreCitiesBtn();
//		test.log(LogStatus.INFO, "Click on No More Cities Button");
//		bookingPage.selectGuestDetails("1|3");
//		bookingPage.doneButtonMob();
//		test.log(LogStatus.INFO, "User select \"1 Room With 3 Adults\" from Guest list");
//		test.log(LogStatus.INFO, "All the basic booking details Source & Destination filled successfully for 3 Adults_4nights");
//		bookingPage.clickonContinueButton();
//		test.log(LogStatus.INFO, "Click on \"Continue\" Button");
//		bookingPage.selectCheaperFlights();
//		test.log(LogStatus.INFO, "User clicks on Select Cheaper Flights Link");
//		test.log(LogStatus.INFO, "User selects a particular flight from existing options");
//		test.log(LogStatus.INFO, "User clicks on Continue Link");
//		//logs.info("Select Cheaper flights from flight options");
//		bookingPage.getTripinclusionContinueButton();
//		bookingPage.clicktoContinuePage();
//		test.log(LogStatus.INFO, "Click to Continue & User redirected to Fill Passenger Details Page");
//		expectedFirstTravellerInfo = passengerInfoPage.fillFirstTravellerDetails("John", "Leo", "Male","01/01/1992", "237|US");
//		test.log(LogStatus.INFO, "User enters \"John\" as First Traveller First Name");
//		test.log(LogStatus.INFO, "User enters \"Leo\" as First Traveller Last Name");
//		test.log(LogStatus.INFO, "User selects \"Gender:Male\" for First Traveller Last Name");
//		test.log(LogStatus.INFO, "User selects \"DOB:01/01/1992\" for First Traveller's Date of Birth");
//		test.log(LogStatus.INFO, "User selects \"Passport details as:US\" for First Traveller");
//		expectedSecondTravellerInfo = passengerInfoPage.fillSecondTravellerDetails("Elvin", "Leo", "Male","01/01/1994", "237|US", "Adult");
//		test.log(LogStatus.INFO, "User enters \"Elvin\" as Second Traveller First Name");
//		test.log(LogStatus.INFO, "User enters \"Leo\" as Second Traveller Last Name");
//		test.log(LogStatus.INFO, "User selects \"Gender:Male\" for Second Traveller Last Name");
//		test.log(LogStatus.INFO, "User selects \"DOB:01/01/1994\" for Second Traveller's Date of Birth");
//		test.log(LogStatus.INFO, "User selects \"Passport details as:US\" for Second Traveller");
//		expectedThirdTravellerInfo = passengerInfoPage.fillThirdTravellerDetails("Marie", "Leo", "Female","01/01/1996", "237|US");
//		test.log(LogStatus.INFO, "User enters \"Marie\" as Third Traveller First Name");
//		test.log(LogStatus.INFO, "User enters \"Leo\" as Third Traveller Last Name");
//		test.log(LogStatus.INFO, "User selects \"Gender:Male\" for Third Traveller Last Name");
//		test.log(LogStatus.INFO, "User selects \"DOB:01/01/1996\" for Third Traveller's Date of Birth");
//		test.log(LogStatus.INFO, "User selects \"Passport details as:US\" for Third Traveller");
//		test.log(LogStatus.INFO, "User filled all the passenger details successfully");
//		//logs.info("User fills all the 3 passenger details");
//		bookingPage.getTripinclusionContinueButton();
//		bookingPage.clicktoContinuePage();
//		test.log(LogStatus.INFO, "Click to Continue & User redirected to Payment Page");
//		if(TestBase.flag_Mob){
//			PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler1NameiOS(), expectedFirstTravellerInfo);
//			PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler2NameiOS(), expectedSecondTravellerInfo);
//			PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler3NameiOS(), expectedThirdTravellerInfo);
//			
//		}else{
//		PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler1Name(), expectedFirstTravellerInfo);
//		PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler2Name(), expectedSecondTravellerInfo);
//		PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler3Name(), expectedThirdTravellerInfo);
//		}
//		bookingPage.tripSummary();
//		test.log(LogStatus.INFO, "Flights & passenger details verified successfully on PaymentPage");
//		//logs.info("Flights & passenger details verified successfully on PaymentPage");
//	}
//	

//	@Test(groups= {"smoke"},priority=2)
//	public void bookingSingleRoomOneAdultOneChild_TC_2(Method method) throws Exception {
//		ExtentTest test = ExtentTestManager.startTest(method.getName(), "bookingSingleRoom1Adult1Child");
//		bookingPage.clickOnBuildYourVacationDropDown();
//		PageBase.waitForElement(3);
//		bookingPage.fillLeavingFromDetails("New York, Newark, NJ");
//		test.log(LogStatus.INFO, "User entered \"Philadelphia, PA\" into leaving from field");
//		bookingPage.fillGoingToCityDetails("Berlin (Germany)");
//		test.log(LogStatus.INFO, "User entered \"Berlin (Germany)\" into Going to from field");
//		bookingPage.selectValueFromCalendar(90);
//		bookingPage.selectStayingTime("6");
//		test.log(LogStatus.INFO, "User entered \"6\" nights staying time");	
//		 bookingPage.selectNoMoreCitiesBtn();
//		test.log(LogStatus.INFO, "Click on No More Cities Button");
//		bookingPage.selectGuestDetails("1|Other");
//		test.log(LogStatus.INFO, "User select \"1 Room With Other Options\" from Guest list");
//		test.log(LogStatus.INFO, "All the basic booking details Source & Destination filled successfully for 1_Adult_1Child_With_SingleRoom");
//		//logs.info("All the basic booking details Source & Destination filled successfully for 1_Adult_1Child_With_SingleRoom");
//		bookingPage.selectNumberOfAdult("1", BookingLocators.getselectAdultDrpdown());
//		bookingPage.selectnumberofadultsRoom_1iOS();
//		test.log(LogStatus.INFO, "User selects \"1\" Adult from Adult Drpdown");
//		bookingPage.selectNumberOfChild("1", "9", "Child1");
//		bookingPage.doneButtonMob();
//		test.log(LogStatus.INFO, "User selects \"1\" Child,\"Age of Child:9\"");
//		test.log(LogStatus.INFO, "No.of Child & Age of Child got selected successfully");
//		//logs.info("No.of Child & Age of Child got selected successfully");
//		bookingPage.clickonContinueButton();
//		test.log(LogStatus.INFO, "Click on Continue Button");
//		//logs.info("Click on Continue Button");
//		bookingPage.selectCheaperFlights();
//		test.log(LogStatus.INFO, "User clicks on Select Cheaper Flights Link");
//		test.log(LogStatus.INFO, "User selects a particular flight from existing options");
//		test.log(LogStatus.INFO, "User clicks on Continue Link");
//		//logs.info("Select Cheaper flights from flight options");
//		bookingPage.getTripinclusionContinueButton();
//		bookingPage.clicktoContinuePage();
//	    expectedFirstTravellerInfo = passengerInfoPage.fillFirstTravellerDetails("Morris", "Mano", "Male","01/01/1992", "237|US");
//		test.log(LogStatus.INFO, "User enters \"Morris\" as First Traveller First Name");
//		test.log(LogStatus.INFO, "User enters \"Mano\" as First Traveller Last Name");
//    	test.log(LogStatus.INFO, "User selects \"Gender:Male\" for First Traveller Last Name");
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
//		//logs.info("User filled all the passenger details successfully");
//		PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler1Name(), expectedFirstTravellerInfo);
//		PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler2Name(), expectedSecondTravellerInfo);
//		test.log(LogStatus.INFO, "Flights & passenger details verified successfully on PaymentPage");
//		//logs.info("Flights & passenger details verified successfully on PaymentPage");
//		
//	}

// @Test(groups= {"smoke"},priority=3)
//	public void bookingTwoRoomTwoAdult_TC_3(Method method) throws Exception {
//		ExtentTest test = ExtentTestManager.startTest(method.getName(), "bookingTwoRoom2Adult");
//		Thread.sleep(8000);
//
//		bookingPage.clickOnBuildYourVacationDropDown();
//		bookingPage.fillLeavingFromDetails("New York, Newark, NJ");
//		Thread.sleep(8000);
//		test.log(LogStatus.INFO, "User entered \"San Jose, CALIFORNIA\" into leaving from field");
//		bookingPage.fillGoingToCityDetails("Osaka (Japan)");
//		test.log(LogStatus.INFO, "User entered \"Osaka (Japan)\" into Going to from field");
//		Thread.sleep(4000);
//
//		bookingPage.selectValueFromCalendar(75);
//		Thread.sleep(4000);
//
//		bookingPage.selectStayingTime("6");
//		test.log(LogStatus.INFO, "User entered \"6\" nights staying time");	
//		Thread.sleep(4000);
//
//		bookingPage.selectNoMoreCitiesBtn();
//		test.log(LogStatus.INFO, "Click on No More Cities Button");
//		Thread.sleep(4000);
//
//		bookingPage.selectGuestDetails("2|2-2");
//		test.log(LogStatus.INFO, "User select \"2 Room For Two Adults\" from Guest list");
//		test.log(LogStatus.INFO, "All the Basic Booking details Source & Destination filled successfully for Two Adults");
//		//logs.info("All the Basic Booking details Source & Destination filled successfully for Two Adults");
//		Thread.sleep(4000);
//
//		bookingPage.clickonContinueButton();
//		test.log(LogStatus.INFO, "Click on Continue Button");
//		//logs.info("Click on Continue Button");
//		Thread.sleep(4000);
//
//		bookingPage.selectCheaperFlights();
//		test.log(LogStatus.INFO, "User clicks on Select Cheaper Flights Link");
//		test.log(LogStatus.INFO, "User selects a particular flight from existing options");
//		test.log(LogStatus.INFO, "User clicks on Continue Link");
//		//logs.info("Select Cheaper flights from flight options");
//		Thread.sleep(4000);
//
//		bookingPage.getTripinclusionContinueButton();
//		Thread.sleep(4000);
//
//		Thread.sleep(4000);
//
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
//		PageBase.scrollDownForMob(1);
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
//		Thread.sleep(4000);
//
//		test.log(LogStatus.INFO, "User selects \"Passport details as:US\" for Traveller3");
//		Thread.sleep(4000);
//
//		bookingPage.getTripinclusionContinueButton();
//		Thread.sleep(4000);
//
//		bookingPage.clicktoContinuePage();
//		test.log(LogStatus.INFO, "User filled all the passenger details successfully");
//	//	logs.info("User filled all the passenger details successfully");
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
//	//	logs.info("Flights & passenger details verified successfully on PaymentPage");
//	}

//	@Test(groups= {"smoke"},priority=4)
//	public void bookingTwoRoomThreeAdultOneChild_TC_4(Method method) throws Exception {
//		 ExtentTest test = ExtentTestManager.startTest(method.getName(), "bookingTwoRoom3Adult1Child");
//		bookingPage.clickOnBuildYourVacationDropDown();
//		PageBase.waitForElement(3);
//		bookingPage.fillLeavingFromDetails("New York, Newark, NJ");
//		test.log(LogStatus.INFO, "User entered \"New York, Newark, NJ\" into leaving from field");
//		bookingPage.fillGoingToCityDetails("Berlin (Germany)");
//		test.log(LogStatus.INFO, "User entered \"Berlin (Germany)\" into Going to from field");
//		bookingPage.selectValueFromCalendar(90);
//		bookingPage.selectStayingTime("4");
//		test.log(LogStatus.INFO, "User entered \"4\" nights staying time");	
//		bookingPage.selectNoMoreCitiesBtn();
//		test.log(LogStatus.INFO, "Click on No More Cities Button");
//		bookingPage.selectGuestDetails("2|Other");
//		test.log(LogStatus.INFO, "User select \"Three Adults & One Child\" from Guest list");
//		test.log(LogStatus.INFO, "Booking details filled successfully for Three Adults & One Child");
//		//logs.info("Booking details filled successfully for Three Adults & One Child");
//		bookingPage.select2NumberOfAdultForRoom1("2", BookingLocators.getselectAdultDrpdown());
//		bookingPage.selectNumberOfChild("1", "9", "Child1");
//		test.log(LogStatus.INFO, "No.of Child & Age of Child got selected successfully");
//		//logs.info("No.of Child & Age of Child got selected successfully");
//		bookingPage.select1NumberOfAdultForRoom2("1", BookingLocators.getselectAdultRoom2Drpdown());
//		//bookingPage.selectNumberOfChild("1", "9", "Child2");
//		bookingPage.doneButtonMob();
//		bookingPage.clickonContinueButton();
//		test.log(LogStatus.INFO, "Click on Continue Button");
//		//logs.info("Click on Continue Button");
//		bookingPage.selectCheaperFlights();
//		test.log(LogStatus.INFO, "User clicks on Select Cheaper Flights Link");
//		test.log(LogStatus.INFO, "User selects a particular flight from existing options");
//		test.log(LogStatus.INFO, "User clicks on Continue Link");
//		//logs.info("Select Cheaper flights from flight options");
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
//		//logs.info("User filled all the passenger details successfully");
//		bookingPage.getTripinclusionContinueButton();
//		if(TestBase.flag_Mob)
//		{
//			PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler1NameiOS(), expectedFirstTravellerInfo);
//			PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler2NameiOS(), expectedSecondTravellerInfo);
//			PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler3NameMob(), expectedThirdTravellerInfo);
//			PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler4NameiOS(), expectedFourthTravellerInfo);
//			}
//		else
//		{
//			PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler1Name(), expectedFirstTravellerInfo);
//			PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler2Name(), expectedSecondTravellerInfo);
//			PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler3Name(), expectedThirdTravellerInfo);
//			PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler4Name(), expectedFourthTravellerInfo);
//		}
//		test.log(LogStatus.INFO, "Flights & passenger details verified successfully on PaymentPage");
//		//logs.info("Flights & passenger details verified successfully on PaymentPage");
//	}

//	@Test(groups= {"smoke"},priority=5)
//	public void bookingTwoRoomTwoAdultTwoChild_TC_5(Method method) throws Exception {
//		ExtentTest test = ExtentTestManager.startTest(method.getName(), "booking2Room2Adult2Child");
//		bookingPage.clickOnBuildYourVacationDropDown();
//		bookingPage.fillLeavingFromDetails("New York, Newark, NJ");
//		test.log(LogStatus.INFO, "User entered \"San Francisco', CA\" into leaving from field");
//		bookingPage.fillGoingToCityDetails("Berlin (Germany)");
//		test.log(LogStatus.INFO, "User entered \"Berlin (Germany)\" into Going to from field");
//		bookingPage.selectValueFromCalendar(120);
//		bookingPage.selectStayingTime("5");
//		test.log(LogStatus.INFO, "User entered \"5\" nights staying time");	
//		bookingPage.selectNoMoreCitiesBtn();
//		test.log(LogStatus.INFO, "Click on No More Cities Button");
//		bookingPage.selectGuestDetails("2|Other");
//		test.log(LogStatus.INFO, "User select \"Two Adults & Two Child\" from Guest list");
//		test.log(LogStatus.INFO, "Booking details filled successfully for Two Adults & Two Child");
//		//logs.info("Booking details filled successfully for Two Adults & Two Child");
//		bookingPage.selectNumberOfAdult("1", BookingLocators.getselectAdultDrpdown());
//		bookingPage.selectnumberofadultsRoom_1iOS();
//		bookingPage.selectNumberOfChild("1", "9", "Child1");
//		test.log(LogStatus.INFO, "No.of Child & Age of Child got selected successfully");
//		//logs.info("No.of Child & Age of Child got selected successfully");
//		bookingPage.selectNumberOfAdult("1", BookingLocators.getselectAdultRoom2Drpdown());
//		bookingPage.selectnumberofadultsRoom_2iOS();
//		bookingPage.selectNumberOfChild("1", "9", "Child2");
//		bookingPage.doneButtonMob();
//		bookingPage.clickonContinueButton();
//		PageBase.waitForElement(3);
//		test.log(LogStatus.INFO, "Click on Continue Button");
//		//logs.info("Click on Continue Button");
//		bookingPage.selectCheaperFlights();
//		test.log(LogStatus.INFO, "User clicks on Select Cheaper Flights Link");
//		test.log(LogStatus.INFO, "User selects a particular flight from existing options");
//		test.log(LogStatus.INFO, "User clicks on Continue Link");
//		//logs.info("Select Cheaper flights from flight options");
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
//		//logs.info("User filled all the passenger details successfully");
//		bookingPage.clicktoContinuePage();
//		test.log(LogStatus.INFO, "Click on Continue Button & User redirected to the Payment Page");
//		PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler1Name(), expectedFirstTravellerInfo);
//		PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler2Name(), expectedSecondTravellerInfo);
//		PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler3Name(), expectedThirdTravellerInfo);
//		PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler4Name(), expectedFourthTravellerInfo);
//		test.log(LogStatus.INFO, "Flights & passenger details verified successfully on PaymentPage");
//		//logs.info("Flights & passenger details verified successfully on PaymentPage");
//	}

//	@Test(groups= {"smoke"},priority=6)
//	public void bookingFlightsWithmultipleCities_TC_6(Method method) throws Exception {
//		ExtentTest test = ExtentTestManager.startTest(method.getName(), "bookingFlightsWithmultipleCities");
//		bookingPage.clickOnBuildYourVacationDropDown();
//		bookingPage.fillLeavingFromDetails("New York, Newark, NJ");
//		bookingPage.fillGoingToCityDetails("Berlin (Germany)");
//		bookingPage.clickOnAddCityBtn();
//		bookingPage.fillSecndAddedCityDetails("Augsburg (Germany)");
//		bookingPage.selectStayingTime("4");
//		bookingPage.selectNoMoreCitiesBtn();
//		bookingPage.selectGuestDetails("1|Other");
//		test.log(LogStatus.INFO, "User select \"1 Room With Other Options\" from Guest list");
//		test.log(LogStatus.INFO, "All the basic booking details Source & Destination filled successfully for 1_Adult_1Child_With_SingleRoom");
//		//logs.info("All the basic booking details Source & Destination filled successfully for 1_Adult_1Child_With_SingleRoom");
//		bookingPage.selectNumberOfAdult("1", BookingLocators.getselectAdultDrpdown());
//		bookingPage.selectnumberofadultsRoom_1iOS();
//		test.log(LogStatus.INFO, "User selects \"1\" Adult from Adult Drpdown");
//		bookingPage.selectNumberOfChild("1", "9", "Child1");
//		bookingPage.doneButtonMob();
//		test.log(LogStatus.INFO, "User selects \"1\" Child,\"Age of Child:9\"");
//		test.log(LogStatus.INFO, "No.of Child & Age of Child got selected successfully");
//		//logs.info("No.of Child & Age of Child got selected successfully");
//		bookingPage.clickonContinueButton();
//		test.log(LogStatus.INFO, "Click on Continue Button");
//		//logs.info("Click on Continue Button");
//		bookingPage.selectCheaperFlights();
//		test.log(LogStatus.INFO, "User clicks on Select Cheaper Flights Link");
//		test.log(LogStatus.INFO, "User selects a particular flight from existing options");
//		test.log(LogStatus.INFO, "User clicks on Continue Link");
//		//logs.info("Select Cheaper flights from flight options");
//		bookingPage.getTripinclusionContinueButton();
//		bookingPage.clicktoContinuePage();
//		//bookingPage.clicktoContinuePage();
//		expectedFirstTravellerInfo = passengerInfoPage.fillFirstTravellerDetails("Morris", "Leo", "Male","01/01/1992", "237|US");
//		test.log(LogStatus.INFO, "User enters \"Morris\" as First Traveller First Name");
//		test.log(LogStatus.INFO, "User enters \"Mano\" as First Traveller Last Name");
//		test.log(LogStatus.INFO, "User selects \"Gender:Male\" for First Traveller Last Name");
//		test.log(LogStatus.INFO, "User selects \"DOB:01/01/1992\" for First Traveller's Date of Birth");
//		test.log(LogStatus.INFO, "User selects \"Passport details as:US\" for First Traveller");
//		expectedSecondTravellerInfo = passengerInfoPage.fillSecondTravellerDetails("Shally", "Leo", "Male","01/01/1994", "237|US", "Child");
//		test.log(LogStatus.INFO, "User enters \"Shally\" as Second Traveller First Name");
//		test.log(LogStatus.INFO, "User enters \"Mano\" as Second Traveller Last Name");
//		test.log(LogStatus.INFO, "User selects \"Female\" for Second Traveller Last Name");
//		test.log(LogStatus.INFO, "User selects \"DOB:01/01/1994\" for Second Traveller's Date of Birth");
//		test.log(LogStatus.INFO, "User selects \"Passport details as:US\" for Second Traveller");
//		test.log(LogStatus.INFO, "User filled all the passenger details successfully");
//		//logs.info("User filled all the passenger details successfully");
//		bookingPage.getTripinclusionContinueButton();
//		bookingPage.clicktoContinuePage();
//		if(TestBase.flag_Mob){
//			PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler1NameiOS(), expectedFirstTravellerInfo);
//			PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler2NameiOS(), expectedSecondTravellerInfo);
//		}else{
//			PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler1Name(), expectedFirstTravellerInfo);
//			PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler2Name(), expectedSecondTravellerInfo);
//		}
//		test.log(LogStatus.INFO, "Flights & passenger details verified successfully on PaymentPage");
//		logs.info("Flights & passenger details verified successfully on PaymentPage");
//	}
	
//	@Test(groups= {"smoke"},priority=7)
//	public void bookingFlightAndHotelForSingleCity_TC_7(Method method) throws Exception {
//		ExtentTest test=ExtentTestManager.startTest(method.getName(), "bookingFlightAndHotelForSingleCity");
//		bookingPage.clickOnBuildYourVacationDropDown();
//		bookingPage.fillLeavingFromDetails("New York, Newark, NJ");
//		test.log(LogStatus.INFO, "User entered \"New York, Newark, NJ\" into leaving from field");
//		bookingPage.fillGoingToCityDetails("Delhi (India)");
//		test.log(LogStatus.INFO, "User entered \"Delhi (India)\" into Going to from field");
//		bookingPage.selectValueFromCalendar(90);
//		bookingPage.selectStayingTime("6");
//		test.log(LogStatus.INFO, "User entered \"6\" nights staying time");	
//		bookingPage.selectNoMoreCitiesBtn();
//		test.log(LogStatus.INFO, "Click on No More Cities Button");
//		bookingPage.selectGuestDetails("2|Other");
//		test.log(LogStatus.INFO, "User select \"3 Adults_4nights\" from Guest list");
//		test.log(LogStatus.INFO, "All the basic booking details Source & Destination filled successfully for 3 Adults_4nights");
//		test.log(LogStatus.INFO, "Booking details filled successfully for single city");
//		logs.info("Booking details filled successfully for single city");
//		bookingPage.selectNumberOfAdult("1", BookingLocators.getselectAdultDrpdown());
//		bookingPage.selectnumberofadultsRoom_1iOS();
//		bookingPage.selectNumberOfChild("1", "9", "Child1");
//		test.log(LogStatus.INFO, "No.of Child & Age of Child got selected successfully");
//		logs.info("No.of Child & Age of Child got selected successfully");
//		bookingPage.selectNumberOfAdult("1", BookingLocators.getselectAdultRoom2Drpdown());
//		bookingPage.selectnumberofadultsRoom_2iOS();
//		bookingPage.clickonContinueButton();
//		test.log(LogStatus.INFO, "Click on Continue Button");
//		logs.info("Click on Continue Button");
//		PageBase.scrollDownForMob(2);
//		ActualHotel = bookingPage.browseHotelsButton();
//		System.out.println("Actual:"+ ActualHotel);
//		test.log(LogStatus.INFO, "Click on Browse Hotels Button");
//		logs.info("Click on Browse Hotels Button");
//		bookingPage.selectFirstHotel_SingleCity();
//		PageBase.scrollDownForMob(1);
//
//		//ExpectedHotel = bookingPage.browseSelectHotel();
//		//System.out.println("Expected:"+ ExpectedHotel);
//
//		test.log(LogStatus.INFO, "Select particular hotel from Hotel Options");
//		logs.info("Select particular hotel from Hotel Options");
//		
//		//Assert.assertEquals(ActualHotel, ExpectedHotel);
//		bookingPage.clicktoContinuePage();
//		//bookingPage.selectCheaperFlights();
//		//String expected = bookingPage.selectCheaperFlights();
//		test.log(LogStatus.INFO, "Select Cheaper flights from flight options");
//		logs.info("Select Cheaper flights from flight options");
//		//String actualFlightDetails = bookingPage.getActualFlight();
//		//System.out.println("Actual is:" +actualFlightDetails   + " "+ "Expected is :"+expected);
//		//Assert.assertTrue(expected.contains(actualFlightDetails));
//		test.log(LogStatus.INFO, "Verify that only selected flight appears along with passenger details");
//		logs.info("Verify that only selected flight appears along with passenger details");
//	
//		test.log(LogStatus.INFO, "Verify that only particular selected hotel appears along with passenger details");
//		logs.info("Verify that only particular selected hotel appears along with passenger details");
//	}
		
//	@Test(groups= {"smoke"},priority=8)
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
//		bookingPage.selectGuestDetails("1|1");
//		test.log(LogStatus.INFO, "Booking details filled successfully for multiple cities");
//		logs.info("Booking details filled successfully for multiple cities");
//		bookingPage.clickonContinueButton();
//		test.log(LogStatus.INFO, "Click on Continue Button");
//		logs.info("Click on Continue Button");
//		ActualHotel = bookingPage.browseHotelsButton();
//		test.log(LogStatus.INFO, "Click on Browse Hotels Button");
//		logs.info("Click on Browse Hotels Button");
//		bookingPage.selectFirstHotel();
//		PageBase.scrollDownForMob(1);
//		ExpectedHotel = bookingPage.browseSelectHotel();
//		test.log(LogStatus.INFO, "Select particular hotel from Hotel Options");
//		logs.info("Select particular hotel from Hotel Options");
//		Assert.assertEquals(ActualHotel, ExpectedHotel);
//		bookingPage.selectCheaperFlights();
//		test.log(LogStatus.INFO, "Select Cheaper flights from flight options");
//		logs.info("Select Cheaper flights from flight options");
//		bookingPage.getTripinclusionContinueButton();
//		bookingPage.clicktoContinuePage();
//		expectedFirstTravellerInfo = passengerInfoPage.fillFirstTravellerDetails("Morris", "Leo", "Male","01/01/1992", "237|US");
//		test.log(LogStatus.INFO, "User filled all the passenger details successfully");
//		logs.info("User filled all the passenger details successfully");
//		bookingPage.getTripinclusionContinueButton();
//		bookingPage.clicktoContinuePage();
//		if(TestBase.flag_Mob){
//			PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler1NameiOS(), expectedFirstTravellerInfo);
//			//PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler2NameiOS(), expectedSecondTravellerInfo);
//		}else{
//		PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler1Name(), expectedFirstTravellerInfo);
//		//PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler2Name(), expectedSecondTravellerInfo);
//		}
//		test.log(LogStatus.INFO, "Flights & passenger details verified successfully on PaymentPage");
//		logs.info("Flights & passenger details verified successfully on PaymentPage");
//	}
//	

	 @Test(groups= {"smoke"},priority=1)
	public void withoutAirBookingForSingleCity_TC_19(Method method) throws Exception {
		ExtentTest test=ExtentTestManager.startTest(method.getName(), "withoutAirBookingForSingleCity_TC_19");
		bookingPage.selectWithoutAir();
		test.log(LogStatus.INFO, "Select withOut Air Option on HomePage");
		logs.info("Select withOut Air Option on HomePage");
		bookingPage.fillGoingToCityDetails("San Francisco (USA)");
		bookingPage.selectStayingTime("5");
		bookingPage.selectNoMoreCitiesBtn();
		Thread.sleep(8000);
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
		Thread.sleep(8000);
		PageBase.scrollDownForMob(1);
		String expectedresult = bookingPage.browseSelectHotel();
		test.log(LogStatus.INFO, "Select particular hotel from Hotel Options");
		logs.info("Select particular hotel from Hotel Options");
		Assert.assertEquals(Actualresult, expectedresult);
		test.log(LogStatus.INFO, "Verify that only particular selected hotel appears along with passenger details");
		logs.info("Verify that only particular selected hotel appears along with passenger details");
	}
	 
	@Test(groups= {"smoke"},priority=2)
	public void getWithoutAir_TC_20(Method method) throws Exception {
		ExtentTest test=ExtentTestManager.startTest(method.getName(), "getWithoutAir");
		bookingPage.getWithoutButton();
		Thread.sleep(8000);
		test.log(LogStatus.INFO, "Click on WithOut Air Button");
		logs.info("Click on WithOut Air Button");
		bookingPage.fillLeavingFromDetails("New York, Newark, NJ");
		Thread.sleep(4000);
		bookingPage.fillGoingToCityDetails("Delhi (India)");
		Thread.sleep(4000);
		bookingPage.clickOnAddCityBtn();
		Thread.sleep(4000);
		bookingPage.fillSecndAddedCityDetails("Mumbai (India)");
		Thread.sleep(4000);
		bookingPage.selectStayingTime("4");
		Thread.sleep(4000);
		bookingPage.selectNoMoreCitiesBtn();
		Thread.sleep(8000);
		bookingPage.selectGuestDetails("1|3");
		//bookingPage.fillBasicBookingDetailForMultipleCities("WithOutAir", "Delhi (India)", "4", "Mumbai (India)","1|3");
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

	}

	@Test(groups= {"smoke"},priority=3)
	public void removeAddedCity_TC_17(Method method) throws Exception {
		ExtentTest test=ExtentTestManager.startTest(method.getName(), "removeAddedCity");
		bookingPage.clickOnBuildYourVacationDropDown();
		Thread.sleep(8000);
		bookingPage.fillLeavingFromDetails("New York, Newark, NJ");
		Thread.sleep(4000);
		bookingPage.fillGoingToCityDetails("Delhi (India)");
		Thread.sleep(4000);
		bookingPage.selectStayingTime("4");
		Thread.sleep(4000);
		bookingPage.clickOnAddCityBtn();
		Thread.sleep(4000);
		bookingPage.fillSecndAddedCityDetails("Mumbai (India)");
		Thread.sleep(4000);
		bookingPage.selectStayingTimeTwo("1");
		Thread.sleep(4000);
		bookingPage.clickOnAddCityBtn();
		Thread.sleep(4000);
		bookingPage.fillThirdAddedCityDetails("");
		Thread.sleep(4000);
		bookingPage.selectStayingTimeThree("1");
		Thread.sleep(4000);
		//bookingPage.fillBasicDetails("New York, Newark, NJ", "Delhi (India)", "4", "Mumbai (India)", "1","Chennai -Madras (India)", "1");
		test.log(LogStatus.INFO, "Fill all the basic details for multiple cities");
		test.log(LogStatus.INFO, "Adding multiple cities in destinations");
		logs.info("Fill all the basic details for multiple cities");
		logs.info("Adding multiple cities in destinations");
		boolean actual = bookingPage.isremovecitydisplayed();
		Assert.assertTrue(actual);
		test.log(LogStatus.INFO,"Verify that multiple cities got selected as destinations");
		test.log(LogStatus.INFO, "Verify that RemoveCity Link is also displayed for added cities");
		logs.info("Verify that multiple cities got selected as destinations");
		logs.info("Verify that RemoveCity Link is also displayed for added cities");
		bookingPage.deleteAddedCities();
		Thread.sleep(8000);
		test.log(LogStatus.INFO, "Delete all the added cities");
		logs.info("Delete all the added cities");
		bookingPage.validateremovedcity();
		Thread.sleep(8000);
		test.log(LogStatus.INFO, "All the added cities removed successfully.Verified!");
		logs.info("All the added cities removed successfully.Verified!");
		bookingPage.getNoMoreCitiesButton();
		Thread.sleep(16000);
		bookingPage.selectGuestDetails("1|1");
		test.log(LogStatus.INFO, "Select Guest Details");
		bookingPage.clickonContinueButton();
		Thread.sleep(16000);
		bookingPage.selectCheaperFlights();
		Thread.sleep(16000);
		test.log(LogStatus.INFO, "Select Cheaper flights from flight options");
		logs.info("Select Cheaper flights from flight options");
		bookingPage.validateTripIncluisonPage();
		Thread.sleep(4000);
		test.log(LogStatus.INFO, "Validate that user is on TripInclusion Page");
		logs.info("Validate that user is on TripInclusion Page");
	}

     @Test(groups= {"smoke"},priority=4)
	public void verifySpotlightLink_TC_14(Method method) throws Exception {
    	String PageTitle=null;
		ExtentTest test=ExtentTestManager.startTest(method.getName(), "verifySpotlightLink");
		Thread.sleep(8000);
		bookingPage.selectLatinAmericaLink();
		test.log(LogStatus.INFO, "Select Latin America Link");
		logs.info("Select Latin America Link");
		Thread.sleep(8000);
		bookingPage.verifyLatinAmericPage();
		test.log(LogStatus.INFO, "User redirected to the Latin America Page");
		logs.info("User redirected to the Latin America Page");
		String title=bookingPage.clickOnFirstOptionUnderSpotlightForMob();
		test.log(LogStatus.INFO, "User clicks on Spotlight button");
		logs.info("User clicks on Spotlight button");
		Thread.sleep(8000);
		bookingPage.verifyPageDisplayed(title);
		test.log(LogStatus.INFO, "Spotlight link verified!");
        logs.info("Spotlight link verified!");
	}
	
    @Test(groups= {"smoke"},priority=5)
	public void dateChanging_TC_9(Method method) throws Exception {
		ExtentTest test=ExtentTestManager.startTest(method.getName(), "verify DateChanging functionality");
		Thread.sleep(8000);
		bookingPage.clickOnBuildYourVacationDropDown();
		bookingPage.fillLeavingFromDetails("New York, Newark, NJ");
		bookingPage.fillGoingToCityDetails("Berlin (Germany)");
		Thread.sleep(8000);
		bookingPage.selectStayingTime("12");
		Thread.sleep(8000);
		bookingPage.selectNoMoreCitiesBtn();
		bookingPage.selectGuestDetails("1|Other");
		test.log(LogStatus.INFO, "Booking details Source & Destination filled successfully ");
		logs.info("Booking details Source & Destination filled successfully ");
		Thread.sleep(8000);
		bookingPage.selectNumberOfAdult("1", BookingLocators.getselectAdultDrpdown());
		bookingPage.selectnumberofadultsRoom_1iOS();
		test.log(LogStatus.INFO, "User selects \"1\" Adult from Adult Drpdown");
		bookingPage.selectNumberOfChild("1", "9", "Child1");
		Thread.sleep(8000);
		bookingPage.doneButtonMob();
		test.log(LogStatus.INFO, "User selects \"1\" Child,\"Age of Child:9\"");
		test.log(LogStatus.INFO, "No.of Child & Age of Child got selected successfully");
		logs.info("No.of Child & Age of Child got selected successfully");
		Thread.sleep(8000);
		bookingPage.clickonContinueButton();
		test.log(LogStatus.INFO, "Click on Continue Button");
		Thread.sleep(8000);
		bookingPage.clickChangedArriveDate();
		Thread.sleep(8000);
		bookingPage.oldArriveDate();
		Thread.sleep(16000);
		bookingPage.clickonContinueLink();
		Thread.sleep(8000);
		bookingPage.getTripinclusionContinueButton();
		Thread.sleep(8000);
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
		logs.info("User filled all the passenger details successfully");
		Thread.sleep(8000);
		bookingPage.getTripinclusionContinueButton();
		Thread.sleep(8000);
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
	}

   @Test(groups= {"smoke"},priority=6)
		public void bookingDetailswithPremiumEcomomy_TC_18(Method method) throws Exception {
			ExtentTest test =ExtentTestManager.startTest(method.getName(), "bookingDetailswithPremiumEcomomy");
			Thread.sleep(8000);
			bookingPage.clickOnBuildYourVacationDropDown();
			Thread.sleep(8000);
			bookingPage.selectCabinClass("Premium Economy");
			bookingPage.fillLeavingFromDetails("New York City (all Airports)");
			bookingPage.fillGoingToCityDetails("Delhi (India)");
			Thread.sleep(8000);
			bookingPage.selectStayingTime("4");
			bookingPage.selectNoMoreCitiesBtn();
			Thread.sleep(8000);
			bookingPage.selectGuestDetails("1|1");
			bookingPage.selectPremiumEconomy();
			Thread.sleep(8000);
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
		}
		
	@Test(groups= {"smoke"},priority=7)
	public void multipleCities_TC_21(Method method) throws Exception {
		ExtentTest test=ExtentTestManager.startTest(method.getName(), "multipleCities");
		Thread.sleep(8000);
		bookingPage.clickOnBuildYourVacationDropDown();
		Thread.sleep(6000);
		bookingPage.fillLeavingFromDetails("Washington (all Airports), DC");
		//Thread.sleep(6000);
		test.log(LogStatus.INFO, "User entered \"Washington (all Airports), DC\" into leaving from field");
		bookingPage.fillGoingToCityDetails("London (England)");
		//Thread.sleep(6000);
		test.log(LogStatus.INFO, "User entered \"London (England)\" into Going to from field");
		bookingPage.selectStayingTime("3");
		Thread.sleep(6000);
		bookingPage.clickOnAddCityBtn();
		bookingPage.fillSecndAddedCityDetails("Paris (France)");
		Thread.sleep(6000);
		test.log(LogStatus.INFO, "User entered \"Paris (France)\" into Going to from field");
		bookingPage.clickOnAddCityBtn();
		bookingPage.fillThirdAddedCityDetails("Rome (Italy)");
		//Thread.sleep(6000);
		test.log(LogStatus.INFO, "User entered \"Rome (Italy)\" into Going to from field for adding second city");		
		bookingPage.selectStayingTimeThree("3");
		bookingPage.clickonContinue();
		Thread.sleep(6000);
		//bookingPage.selectNoMoreCitiesBtn();
		Thread.sleep(6000);
		bookingPage.selectGuestDetails("1|2");
		Thread.sleep(6000);
		bookingPage.clickonContinueButton();
		Thread.sleep(6000);
		bookingPage.selectCheaperFlights();
		//bookingPage.tripSummary();
		bookingPage.validateTripPage();
		test.log(LogStatus.INFO, "Validate that user is on TripInclusion Page");
		
	}
	
	//new
	@Test(groups= {"smoke"},priority=9)
	public void validateTripSummarywithMultipleCitiesforAsianPacificPage_TC_17(Method method) throws Exception {
		ExtentTest test=ExtentTestManager.startTest(method.getName(), "Validate TripSummary along with Multiple Cities for Asian Pacific Page");
		bookingPage.clickOnBuildYourVacationDropDown();
		Thread.sleep(8000);
		bookingPage.clickonAsian_PacificLink();
		test.log(LogStatus.INFO, "User clicked on Asian,Pacific Link.");
		test.log(LogStatus.INFO, "User redirected to Asian Pacific Page");
		bookingPage.fillLeavingFromDetails("New York, Newark, NJ");
		test.log(LogStatus.INFO, "User leaving from: New York, Newark, NJ");
		Thread.sleep(8000);
		bookingPage.fillGoingToCityDetails("Delhi (India)");
		test.log(LogStatus.INFO, "User going to City: Delhi (India)");
		Thread.sleep(8000);
		String selectDate=bookingPage.selectValueFromCalendar(90);
		test.log(LogStatus.INFO,   "User selects '" + selectDate + "'from calendar");
		bookingPage.selectStayingTime("4");
		test.log(LogStatus.INFO, "Select staying time :4 nights");
		Thread.sleep(8000);
		bookingPage.clickOnAddCityBtn();
		test.log(LogStatus.INFO, "Click on Add City Button");
		Thread.sleep(8000);
		bookingPage.fillSecndAddedCityDetails("Mumbai (India)");
		test.log(LogStatus.INFO, "User select another city:Mumbai (India)");
		Thread.sleep(8000);
		bookingPage.selectStayingTimeTwo("1");
		test.log(LogStatus.INFO, "Select staying time :1 night");
		Thread.sleep(8000);
		bookingPage.clickOnAddCityBtn();
		test.log(LogStatus.INFO, "Click on Add City Button");
		Thread.sleep(8000);
		bookingPage.fillThirdAddedCityDetails("Chennai -Madras (India)");
		test.log(LogStatus.INFO, "User select another city:Chennai -Madras (India)");
		Thread.sleep(8000);
		bookingPage.selectStayingTimeThree("1");
		test.log(LogStatus.INFO, "Select staying time :1 night");
		Thread.sleep(8000);
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
		Thread.sleep(8000);
		test.log(LogStatus.INFO, "Delete all the added cities");
		logs.info("Delete all the added cities");
		bookingPage.validateremovedcity();
		Thread.sleep(8000);
		test.log(LogStatus.INFO, "All the added cities removed successfully.Verified!");
		logs.info("All the added cities removed successfully.Verified!");
		bookingPage.getNoMoreCitiesButton();
		test.log(LogStatus.INFO, "User clicked on No More Cities,Continue button");
		Thread.sleep(8000);
		bookingPage.ValidateTravelByOption();
		Thread.sleep(8000);
		test.log(LogStatus.INFO, "Travel By Option validated from one city to another");
		bookingPage.selectGuestDetails("1|1");
		test.log(LogStatus.INFO, "Select Guest Details");
		Thread.sleep(8000);
		bookingPage.clickonContinueButton();
		Thread.sleep(8000);
		bookingPage.selectCheaperFlights();
		Thread.sleep(8000);
		test.log(LogStatus.INFO, "Select Cheaper flights from flight options");
		logs.info("Select Cheaper flights from flight options");
		test.log(LogStatus.INFO, "User clicks on Continue button");
		Thread.sleep(20000);
		bookingPage.validateTripIncluisonPage();
		Thread.sleep(8000);
		test.log(LogStatus.INFO, "Validate that selected flight on Review & Customize Package Page");
		logs.info("Validate that selected flight on Review & Customize Package Page");
	}

	//new
	@Test(groups= {"smoke"},priority=10)
	public void bookingFlightAndHotelwithMultipleCitiesForEuropePage_TC_8(Method method) throws Exception {
		ExtentTest test=ExtentTestManager.startTest(method.getName(), "Flight and hotel booking journey with multiple cities for Europe Page");
		Thread.sleep(8000);
		bookingPage.clickOnBuildYourVacationDropDown();
		Thread.sleep(8000);
		bookingPage.clickonEuropeLink();
		test.log(LogStatus.INFO, "User clicked on Europe Link.");
		test.log(LogStatus.INFO, "User redirected to Europe Page");
		bookingPage.fillLeavingFromDetails("New York City (all Airports),  NY");
		test.log(LogStatus.INFO, "User entered leaving from: New York City (all Airports),  NY");
		bookingPage.fillGoingToCityDetails("Rome (Italy)");
		test.log(LogStatus.INFO, "User entered Going to City:Rome (Italy)");
		String selectDate=bookingPage.selectValueFromCalendar(90);
		test.log(LogStatus.INFO,   "User selects '" + selectDate + "'from calendar");
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
		ActualHotel = bookingPage.browseHotelsButton();
		test.log(LogStatus.INFO, "Click on Browse Hotels Button");
		logs.info("Click on Browse Hotels Button");
		Thread.sleep(8000);
		bookingPage.selectFirstHotel();
		Thread.sleep(8000);
		PageBase.scrollDownForMob(1);
		ExpectedHotel = bookingPage.browseSelectHotel();
		test.log(LogStatus.INFO, "Select particular hotel from Hotel Options");
		logs.info("Select particular hotel from Hotel Options");
		Assert.assertEquals(ActualHotel, ExpectedHotel);
		bookingPage.selectCheaperFlights();
		test.log(LogStatus.INFO, "Select Cheaper flights from flight options");
		logs.info("Select Cheaper flights from flight options");
		Thread.sleep(8000);
		bookingPage.getTripinclusionContinueButton();
		Thread.sleep(8000);
		bookingPage.clicktoContinuePage();
		expectedFirstTravellerInfo = passengerInfoPage.fillFirstTravellerDetails("Morris", "Leo", "Male","01/01/1992", "237|US");
		test.log(LogStatus.INFO, "User enters \"Morris\" as First Traveller First Name");
		test.log(LogStatus.INFO, "User enters \"Mano\" as First Traveller Last Name");
		test.log(LogStatus.INFO, "User selects \"Gender:Male\" for First Traveller Last Name");
		test.log(LogStatus.INFO, "User selects \"DOB:01/01/1992\" for First Traveller's Date of Birth");
		test.log(LogStatus.INFO, "User selects \"Passport details as:US\" for First Traveller");
		expectedSecondTravellerInfo = passengerInfoPage.fillSecondTravellerDetails("Shally", "Leo", "Male","01/01/1994", "237|US", "Adult");
		test.log(LogStatus.INFO, "User enters \"Shally\" as Second Traveller First Name");
		test.log(LogStatus.INFO, "User enters \"Mano\" as Second Traveller Last Name");
		test.log(LogStatus.INFO, "User selects \"Female\" for Second Traveller Last Name");
		test.log(LogStatus.INFO, "User selects \"DOB:01/01/1994\" for Second Traveller's Date of Birth");
		test.log(LogStatus.INFO, "User selects \"Passport details as:US\" for Second Traveller");
		expectedThirdTravellerInfo = passengerInfoPage.fillThirdTravellerDetails_Child("Marie", "Leo", "Female","01/01/2009", "237|US");
		test.log(LogStatus.INFO, "User enters \"Marie\" as Second Traveller First Name");
		test.log(LogStatus.INFO, "User enters \"Mano\" as Second Traveller Last Name");
		test.log(LogStatus.INFO, "User selects \"Female\" for Second Traveller Last Name");
		test.log(LogStatus.INFO, "User selects \"DOB:01/01/2009\" for Second Traveller's Date of Birth");
		test.log(LogStatus.INFO, "User selects \"Passport details as:US\" for Second Traveller");
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
	}
	
	//new
	@Test(groups = { "smoke" }, priority = 11)
	public void bookingJourneyWithOutAirForTwoRoomsPAXDetails_TC_1(Method method) throws Exception {
	    ExtentTest test = ExtentTestManager.startTest(method.getName(), "Flight booking journey without multiple cities with Two Room (1 adult+ 1 child for Room1 & 3Adults for Room2) without Air");
	    Thread.sleep(8000);
	    bookingPage.clickOnBuildYourVacationDropDown();
		bookingPage.selectWithoutAir();
		test.log(LogStatus.INFO, "Select withOut Air Option on HomePage");
		logs.info("Select withOut Air Option on HomePage");
		bookingPage.fillGoingToCityDetails("Berlin (Germany)");
		test.log(LogStatus.INFO, "User entered \"Berlin (Germany)\" into Going to from field");
		String selectDate=bookingPage.selectValueFromCalendar(180);
		Thread.sleep(8000);
		test.log(LogStatus.INFO,   "User selects '" + selectDate + "'from calendar");
		bookingPage.selectStayingTime("4");
		Thread.sleep(8000);
		test.log(LogStatus.INFO, "User entered \"4\" nights staying time");	
		bookingPage.selectNoMoreCitiesBtn();
		Thread.sleep(8000);
		test.log(LogStatus.INFO, "Click on No More Cities Button");
		
		bookingPage.selectGuestDetails("2|Other");
		
		Thread.sleep(8000);
		bookingPage.select2NumberOfAdultForRoom1("1", BookingLocators.getselectAdultDrpdown());
		Thread.sleep(8000);
		bookingPage.selectNumberOfChild("1", "3", "Child1");
		test.log(LogStatus.INFO, "No.of Child & Age of Child got selected successfully");
		bookingPage.select1NumberOfAdultForRoom2("3", BookingLocators.getselectAdultRoom2Drpdown());
		Thread.sleep(8000);
		bookingPage.doneButtonMob();
		test.log(LogStatus.INFO, "User select \"2 Rooms:1Adult,1Child in Room1,3Adults in Room2\" from Guest list");
		test.log(LogStatus.INFO, "All the basic booking details Source & Destination filled successfully for 4 Adults_1Child_4nights");
		bookingPage.clickonContinueButton();
		test.log(LogStatus.INFO, "Click on \"Continue\" Button");
		Thread.sleep(8000);
		bookingPage.browseHotelsButton();
		test.log(LogStatus.INFO, "Click to browse hotels");
		Thread.sleep(8000);
		bookingPage.browseHotelsBy_Reviewscore();
		test.log(LogStatus.INFO, "browseHotelsBy_Reviewscore");
		Thread.sleep(8000);
		bookingPage.browseHotelsBy_Price();
		test.log(LogStatus.INFO, "browseHotelsBy_Price");
		Thread.sleep(8000);
		bookingPage.browseHotelsBy_Name();
		test.log(LogStatus.INFO, "browseHotelsBy_Name");
		test.log(LogStatus.INFO, "User validated all hotel options for defined PAX details");
	}
	
   //new 
	@Test(groups= {"smoke"},priority=12)
	public void bookingJourneyWithFlightAndTrain_TC_2(Method method) throws Exception {
		ExtentTest test = ExtentTestManager.startTest(method.getName(), "Booking journey for multiple cities with Train & Flight");
		Thread.sleep(8000);
		bookingPage.clickOnBuildYourVacationDropDown();
		Thread.sleep(8000);
		PageBase.waitForElement(3);
		Thread.sleep(8000);
		bookingPage.fillLeavingFromDetails("New York City (all Airports),  NY");
		test.log(LogStatus.INFO, "User entered \"New York City (all Airports),  NY\" into Leaving from field");
		bookingPage.fillGoingToCityDetails("London (England)");
		test.log(LogStatus.INFO, "User entered \"London (England)\" into Going to from field");
		String selectDate=bookingPage.selectValueFromCalendar(90);
		Thread.sleep(8000);
		test.log(LogStatus.INFO,   "User selects '" + selectDate + "'from calendar");
		bookingPage.selectStayingTime("6");
		test.log(LogStatus.INFO, "User entered \"6\" nights staying time");	
		Thread.sleep(8000);
		bookingPage.clickOnAddCityBtn();
		
		Thread.sleep(8000);
		bookingPage.fillSecndAddedCityDetails("Paris (France)");
		bookingPage.selectStayingTimeTwo("5");
		test.log(LogStatus.INFO, "User entered \"5\" nights staying time");	
		bookingPage.selectNoMoreCitiesBtn();
		test.log(LogStatus.INFO, "Click on No More Cities Button");
		Thread.sleep(8000);
		bookingPage.validateTravlByTrain();
		test.log(LogStatus.INFO, "Change default transportation & validate that it should be a Train");
		bookingPage.selectGuestDetails("1|Other");
		test.log(LogStatus.INFO, "User select \"1 Room With Other Options\" from Guest list");
		test.log(LogStatus.INFO, "All the basic booking details Source & Destination filled successfully for 1_Adult_1Child_With_SingleRoom");
		logs.info("All the basic booking details Source & Destination filled successfully for 1_Adult_1Child_With_SingleRoom");
		bookingPage.selectNumberOfAdult("2", BookingLocators.getselectAdultDrpdown());
		bookingPage.selectnumberofadultsRoom_1iOS();
		test.log(LogStatus.INFO, "User selects \"2\" Adult from Adult Drpdown");
		Thread.sleep(8000);
		bookingPage.selectNumberOfChild("1", "11", "Child1");
		Thread.sleep(8000);
		bookingPage.doneButtonMob();
		test.log(LogStatus.INFO, "User selects \"1\" Child,\"Age of Child:11\"");
		test.log(LogStatus.INFO, "No.of Child & Age of Child got selected successfully");
		logs.info("No.of Child & Age of Child got selected successfully");
		Thread.sleep(8000);
		bookingPage.clickonContinueButton();
		test.log(LogStatus.INFO, "Click on Continue Button");
		logs.info("Click on Continue Button");
		bookingPage.selectCheaperFlights();
		test.log(LogStatus.INFO, "User clicks on Select Cheaper Flights Link");
		test.log(LogStatus.INFO, "User selects a particular flight from existing options");
		test.log(LogStatus.INFO, "User clicks on Continue Link");
		logs.info("Select Cheaper flights from flight options");
		Thread.sleep(8000);
		bookingPage.getTripinclusionContinueButton();
		Thread.sleep(8000);
		bookingPage.clicktoContinuePage();
		test.log(LogStatus.INFO, "User clicks on Continue Link");
		test.log(LogStatus.INFO, "Validating flight at TripInclusion Page");
	}
	
	//new
	@Test(groups= {"smoke"},priority=13)
	public void bookingFlightAndHotelForSingleCitywithTopDealsValidation_TC_7(Method method) throws Exception {
		ExtentTest test=ExtentTestManager.startTest(method.getName(), "Flight and hotel booking journey with single city along with Top Deal Validation");
		Thread.sleep(8000);
		bookingPage.clickOnBuildYourVacationDropDown();
		Thread.sleep(8000);
		bookingPage.clickOnTopDealsLink();
		test.log(LogStatus.INFO, "User clicks on Top Deals Link");
		Thread.sleep(8000);
		bookingPage.validateTopDealsPage();
		test.log(LogStatus.INFO, "User is redirected to Top Deals Page,Verified!");
		Thread.sleep(8000);
		bookingPage.validateTopDealsList();
		test.log(LogStatus.INFO, "User validated that TopDeals List is available");
		test.log(LogStatus.INFO, "User return to homepage after top deals verification");
		bookingPage.fillLeavingFromDetails("New York, Newark, NJ");
		test.log(LogStatus.INFO, "User entered \"New York, Newark, NJ\" into leaving from field");
		Thread.sleep(8000);
		bookingPage.fillGoingToCityDetails("Delhi (India)");
		test.log(LogStatus.INFO, "User entered \"Delhi (India)\" into Going to from field");
		String selectDate=bookingPage.selectValueFromCalendar(180);	
		test.log(LogStatus.INFO,   "User selects '" + selectDate + "'from calendar");
		Thread.sleep(8000);
		bookingPage.selectStayingTime("6");
		test.log(LogStatus.INFO, "User entered \"6\" nights staying time");	
		bookingPage.selectNoMoreCitiesBtn();
		test.log(LogStatus.INFO, "Click on No More Cities Button");
		Thread.sleep(8000);
		bookingPage.selectGuestDetails("2|Other");
		test.log(LogStatus.INFO, "User select \"3 Adults_4nights\" from Guest list");
		test.log(LogStatus.INFO, "All the basic booking details Source & Destination filled successfully for 3 Adults_4nights");
		test.log(LogStatus.INFO, "Booking details filled successfully for single city");
		logs.info("Booking details filled successfully for single city");
		Thread.sleep(8000);
		bookingPage.selectNumberOfAdult("1", BookingLocators.getselectAdultDrpdown());
		Thread.sleep(8000);
		bookingPage.selectnumberofadultsRoom_1iOS();
		bookingPage.selectNumberOfChild("1", "9", "Child1");
		test.log(LogStatus.INFO, "No.of Child & Age of Child got selected successfully");
		logs.info("No.of Child & Age of Child got selected successfully");
		Thread.sleep(8000);
		bookingPage.selectNumberOfAdult("1", BookingLocators.getselectAdultRoom2Drpdown());
		Thread.sleep(8000);
		bookingPage.selectnumberofadultsRoom_2iOS();
		bookingPage.clickonContinueButton();
		test.log(LogStatus.INFO, "Click on Continue Button");
		logs.info("Click on Continue Button");
		Thread.sleep(8000);
		PageBase.scrollDownForMob(2);
		ActualHotel = bookingPage.browseHotelsButton();
		System.out.println("Actual:"+ ActualHotel);
		test.log(LogStatus.INFO, "Click on Browse Hotels Button");
		logs.info("Click on Browse Hotels Button");
		Thread.sleep(8000);
		bookingPage.selectFirstHotel_SingleCity();
		PageBase.scrollDownForMob(1);
		test.log(LogStatus.INFO, "Select particular hotel from Hotel Options");
		logs.info("Select particular hotel from Hotel Options");
		//Assert.assertEquals(ActualHotel, ExpectedHotel);
		Thread.sleep(8000);
		bookingPage.clicktoContinuePage();
		//bookingPage.selectCheaperFlights();
		//String expected = bookingPage.selectCheaperFlights();
		test.log(LogStatus.INFO, "Select Cheaper flights from flight options");
		logs.info("Select Cheaper flights from flight options");
		//String actualFlightDetails = bookingPage.getActualFlight();
		//System.out.println("Actual is:" +actualFlightDetails   + " "+ "Expected is :"+expected);
		//Assert.assertTrue(expected.contains(actualFlightDetails));
		test.log(LogStatus.INFO, "Verify that only selected flight appears along with passenger details");
		logs.info("Verify that only selected flight appears along with passenger details");
		test.log(LogStatus.INFO, "Verify that only particular selected hotel appears along with passenger details");
		logs.info("Verify that only particular selected hotel appears along with passenger details");
	}
	
	//new...Check Highlight option?
	@Test(groups= {"smoke"},priority=14)
	public void bookingFlightsWithmultipleCitieswithHighLightsValidation_TC_6(Method method) throws Exception {
		ExtentTest test = ExtentTestManager.startTest(method.getName(), "bookingFlightsWithmultipleCitieswithHighLightsValidation");
		Thread.sleep(8000);
		bookingPage.clickOnBuildYourVacationDropDown();				
		bookingPage.fillLeavingFromDetails("New York, Newark, NJ");
		test.log(LogStatus.INFO, "User entered \"New York, Newark, NJ\" into leaving from field");
		Thread.sleep(8000);
		bookingPage.fillGoingToCityDetails("Berlin (Germany)");
		test.log(LogStatus.INFO, "User entered \"Berlin (Germany)\" into Going to from field");
		String selectDate=bookingPage.selectValueFromCalendar(150);	
		test.log(LogStatus.INFO,   "User selects '" + selectDate + "'from calendar");
		Thread.sleep(8000);
		bookingPage.clickOnAddCityBtn();
		test.log(LogStatus.INFO, "User clicks on Add City Button");
		bookingPage.fillSecndAddedCityDetails("Augsburg (Germany)");
		test.log(LogStatus.INFO, "User entered another city:Augsburg (Germany)");
		Thread.sleep(8000);
		bookingPage.selectStayingTime("4");
		test.log(LogStatus.INFO, "User entered \"4\" nights staying time");		
		bookingPage.validateHighLights();
		test.log(LogStatus.INFO, "Highlights are available on Homepage,Validated!");	
		Thread.sleep(8000);
		bookingPage.selectNoMoreCitiesBtn();
		test.log(LogStatus.INFO, "Click on No More Cities Button");
		bookingPage.selectGuestDetails("1|Other");
		test.log(LogStatus.INFO, "User select \"1 Room With Other Options\" from Guest list");
		test.log(LogStatus.INFO, "All the basic booking details Source & Destination filled successfully for 1_Adult_1Child_With_SingleRoom");		
		bookingPage.selectNumberOfAdult("1", BookingLocators.getselectAdultDrpdown());
		bookingPage.selectnumberofadultsRoom_1iOS();
		test.log(LogStatus.INFO, "User selects \"1\" Adult from Adult Drpdown");
		bookingPage.selectNumberOfChild("1", "9", "Child1");
		Thread.sleep(8000);
		bookingPage.doneButtonMob();
		test.log(LogStatus.INFO, "User selects \"1\" Child,\"Age of Child:9\"");
		test.log(LogStatus.INFO, "No.of Child & Age of Child got selected successfully");
		//logs.info("No.of Child & Age of Child got selected successfully");
		Thread.sleep(8000);
		bookingPage.clickonContinueButton();
		test.log(LogStatus.INFO, "Click on Continue Button");
		//logs.info("Click on Continue Button");
		bookingPage.selectCheaperFlights();
		test.log(LogStatus.INFO, "User clicks on Select Cheaper Flights Link");
		test.log(LogStatus.INFO, "User selects a particular flight from existing options");
		test.log(LogStatus.INFO, "User clicks on Continue Link");
		//logs.info("Select Cheaper flights from flight options");
		Thread.sleep(8000);
		bookingPage.getTripinclusionContinueButton();
		Thread.sleep(8000);
		bookingPage.clicktoContinuePage();
		//bookingPage.clicktoContinuePage();
		expectedFirstTravellerInfo = passengerInfoPage.fillFirstTravellerDetails("Morris", "Leo", "Male","01/01/1992", "237|US");
		test.log(LogStatus.INFO, "User enters \"Morris\" as First Traveller First Name");
		test.log(LogStatus.INFO, "User enters \"Mano\" as First Traveller Last Name");
		test.log(LogStatus.INFO, "User selects \"Gender:Male\" for First Traveller Last Name");
		test.log(LogStatus.INFO, "User selects \"DOB:01/01/1992\" for First Traveller's Date of Birth");
		test.log(LogStatus.INFO, "User selects \"Passport details as:US\" for First Traveller");
		expectedSecondTravellerInfo = passengerInfoPage.fillSecondTravellerDetails("Shally", "Leo", "Male","01/01/2011", "237|US", "Child");
		test.log(LogStatus.INFO, "User enters \"Shally\" as Second Traveller First Name");
		test.log(LogStatus.INFO, "User enters \"Mano\" as Second Traveller Last Name");
		test.log(LogStatus.INFO, "User selects \"Female\" for Second Traveller Last Name");
		test.log(LogStatus.INFO, "User selects \"DOB:01/01/2011\" for Second Traveller's Date of Birth");
		test.log(LogStatus.INFO, "User selects \"Passport details as:US\" for Second Traveller");
		test.log(LogStatus.INFO, "User filled all the passenger details successfully");
		//logs.info("User filled all the passenger details successfully");
		Thread.sleep(8000);
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
	}
	//new
	@Test(groups= {"smoke"},priority=15)
	public void FlightbookingjourneywithBYOPackage_TC_5(Method method) throws Exception {
		ExtentTest test = ExtentTestManager.startTest(method.getName(), "Flight booking journey with BYO Package along with Pax mandatory field validation");
		Thread.sleep(8000);
		bookingPage.selectFromVacationPackageIdeas();
		test.log(LogStatus.INFO, "User selects an option from Vacation Package Ideas");
		
		Thread.sleep(8000);
		bookingPage.clicktoReorderCities();
		test.log(LogStatus.INFO, "User clicks on Reorder cities button");	
		Thread.sleep(8000);
		bookingPage.fillLeavingFromDetails_BYOPage("Chicago (All Airports)");
		test.log(LogStatus.INFO, "User entered \"Chicago (All Airports)\" into leaving from field");
		String selectDate=bookingPage.selectValueFromCalendar_BYOPackage(120);
		test.log(LogStatus.INFO,   "User selects '" + selectDate + "'from calendar");	
		Thread.sleep(8000);
		bookingPage.selectGuestDetails_BYOPage("2 rooms with children or other options");
		test.log(LogStatus.INFO, "User select \"2 Room With Other Options\" from Guest list");
//		bookingPage.selectAdultForRoom1_BYOPage("1");
//		bookingPage.selectChildForRoom1_BYOPage("1");
		test.log(LogStatus.INFO, "User select \"1 Adult 1Child \" for Room1 ");
//		bookingPage.enterChildAge_BYOPage("7");
		test.log(LogStatus.INFO, "User select \"Age of Child:7 \" for Room1 ");
		Thread.sleep(8000);
		bookingPage.clickToContinue_BYOPage();
		test.log(LogStatus.INFO, "User clicks on BYO Page");
		bookingPage.selectCheaperFlights();
		test.log(LogStatus.INFO, "User clicks on Select Cheaper Flights Link");
		test.log(LogStatus.INFO, "User selects a particular flight from existing options");
		test.log(LogStatus.INFO, "User selects cabin class:Coach/Economy");
		Thread.sleep(8000);
		bookingPage.clicktoContinuePage();
		test.log(LogStatus.INFO, "User clicks on Continue Link to fill PAX details");
		Thread.sleep(8000);
		bookingPage.clicktoContinuePage();
		test.log(LogStatus.INFO, "User clicks on continue Page Button");
		bookingPage.validateErrorMessage_MandatoryFields();
		test.log(LogStatus.INFO, "Validate error message for Mandatory Fields");
	}	
	//new
	@Test(groups= {"smoke"},priority=16)
	public void FirstPackageoptionalongwithRemoveHotelFunc_TC_4(Method method) throws Exception {
		 ExtentTest test = ExtentTestManager.startTest(method.getName(), "Flight booking journey with for First Package option along with Remove Hotel Functionality ");
		 Thread.sleep(8000);
		 bookingPage.selectFromVacationPackageIdeas();
		 test.log(LogStatus.INFO, "User selects an option from Vacation Package Ideas");
		bookingPage.fillLeavingFromDetails_FirstPckg("Washington (all Airports), DC");
		test.log(LogStatus.INFO, "User entered \"Washington (all Airports), DC\" into leaving from field");
		Thread.sleep(8000);
		String selectDate=bookingPage.selectValueFromCalendar_FirstPckg(90);
		test.log(LogStatus.INFO,   "User selects '" + selectDate + "'from calendar");		
		Thread.sleep(8000);
		bookingPage.selectGuestDetails_FirstPckgOneRoom("1|2");
		test.log(LogStatus.INFO, "User selects 1 Room with two Adults");
		Thread.sleep(8000);
		bookingPage.clickOnViewPrice();
		test.log(LogStatus.INFO, "User clicks on View Price Button");
		bookingPage.clickToRemoveSecondCityHotel();
		test.log(LogStatus.INFO, "User clicks on remove second city button");
		Thread.sleep(8000);
		bookingPage.clickToYesOnDialogBox();
		Thread.sleep(8000);
		test.log(LogStatus.INFO, "User clicks to Yes button on Dialog Box");
		bookingPage.getContinueLink();
		test.log(LogStatus.INFO, "User clicks on Continue Button");
		test.log(LogStatus.INFO, "User validates that the hotel name is removed for second city ");
		Thread.sleep(8000);
		bookingPage.clicktoContinuePage();
		test.log(LogStatus.INFO, "User clicks on Continue Page to fill PAX details");
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
		Thread.sleep(8000);
		bookingPage.getTripinclusionContinueButton();
		Thread.sleep(8000);
		bookingPage.clicktoContinuePage();
		test.log(LogStatus.INFO, "Click to Continue & User redirected to Payment Page");
		PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler1Name(), expectedFirstTravellerInfo);
		PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler2Name(), expectedSecondTravellerInfo);
		Thread.sleep(8000);
		bookingPage.tripSummary();
		test.log(LogStatus.INFO, "Removed Hotel is not available for second City,Verified!");
		test.log(LogStatus.INFO, "Flights & passenger details verified successfully on PaymentPage");
	}
	
	//new
		@Test(groups= {"smoke"},priority=17)
		public void bookingTwoRoomTwoAdult_TC_3(Method method) throws Exception {
			ExtentTest test = ExtentTestManager.startTest(method.getName(), "bookingTwoRoom2Adult");
			Thread.sleep(8000);
			bookingPage.clickOnBuildYourVacationDropDown();
			PageBase.waitForElement(3);
			bookingPage.fillLeavingFromDetails("Seattle, WA");
			test.log(LogStatus.INFO, "User entered \"Seattle, WA\" into Leaving from field");
			Thread.sleep(8000);
			bookingPage.fillGoingToCityDetails("Dublin (Ireland)");
			test.log(LogStatus.INFO, "User entered \"Dublin (Ireland)\" into Going to from field");
			Thread.sleep(8000);
			String selectDate=bookingPage.selectValueFromCalendar(75);
			test.log(LogStatus.INFO,   "User selects '" + selectDate + "'from calendar");	
			Thread.sleep(8000);
			bookingPage.selectStayingTime("4");
			test.log(LogStatus.INFO, "User entered \"4\" nights staying time");	
			Thread.sleep(8000);
			bookingPage.clickOnAddCityBtn();
			test.log(LogStatus.INFO, "User clicks on Add City Button");
			Thread.sleep(8000);
			bookingPage.fillSecndAddedCityDetails("Galway (Ireland)");
			test.log(LogStatus.INFO, "User entered another city:Galway (Ireland)");
			Thread.sleep(8000);
			bookingPage.selectStayingTimeTwo("4");
			test.log(LogStatus.INFO, "User entered \"4\" nights staying time");	
			bookingPage.clickOnAddCityBtn();
			test.log(LogStatus.INFO, "User clicks on Add City Button");
			Thread.sleep(8000);
			bookingPage.fillThirdAddedCityDetails("Limerick (Ireland)");
			test.log(LogStatus.INFO, "User select another city:Limerick (Ireland)");
			Thread.sleep(4000);
			
			bookingPage.selectStayingTimeThree("4");
			test.log(LogStatus.INFO, "Select staying time :4 nights");
			Thread.sleep(8000);
			bookingPage.selectNoMoreCitiesBtn();
			test.log(LogStatus.INFO, "User clicked on No More Cities,Continue button");
			bookingPage.clickOnRemoveBtnScndCity();
			test.log(LogStatus.INFO, "User click on Edit/Remove option corresponding to GalWay");
			Thread.sleep(8000);
			bookingPage.deleteSecondCity();
			test.log(LogStatus.INFO, "User clicked on Remove Second City");
			bookingPage.selectNoMoreCitiesBtn();
			test.log(LogStatus.INFO, "User clicked on No More Cities,Continue button");
			boolean status=bookingPage.isSecondremovecitydisplayed();
			System.out.println("Print the status"+status);
			Assert.assertFalse(status);
			test.log(LogStatus.INFO, "Verified that Galway is removed successfully");
			Thread.sleep(8000);
			bookingPage.clickOnRemoveBtnScndCity();
			test.log(LogStatus.INFO, "Click on edit/Remove option corresponding to LimeRick");
			Thread.sleep(8000);
			bookingPage.deleteSecondCity();
			test.log(LogStatus.INFO, "User clicked to remove Limerick");
			Thread.sleep(8000);
			bookingPage.clickOnAddCityBtn();
			test.log(LogStatus.INFO, "User clicks on Add City Button to re-add Galway");
			bookingPage.fillSecndAddedCityDetails("Galway (Ireland)");
			test.log(LogStatus.INFO, "User entered another city:Galway (Ireland)");
			bookingPage.selectStayingTimeTwo("4");
			test.log(LogStatus.INFO, "User entered \"4\" nights staying time");	
			Thread.sleep(8000);
			bookingPage.clickOnAddCityBtn();
			test.log(LogStatus.INFO, "User clicks on Add City Button to re-add Limerick");
			bookingPage.fillThirdAddedCityDetails("Limerick (Ireland)");
			test.log(LogStatus.INFO, "User select another city:Limerick (Ireland)");			
			Thread.sleep(4000);
			Thread.sleep(8000);
			bookingPage.selectStayingTimeThree("4");
			test.log(LogStatus.INFO, "Select staying time :4 nights");
			Thread.sleep(8000);
			bookingPage.selectNoMoreCitiesBtn();
			test.log(LogStatus.INFO, "User clicked on No More Cities,Continue button");
			bookingPage.selectChngeTransByCar();
			test.log(LogStatus.INFO, "User selects Car from Transportation Option");
			bookingPage.selectGuestDetails("2|Other");
			test.log(LogStatus.INFO, "User select \"2 Rooms with other Options\" from Guest list");			
			Thread.sleep(8000);
			bookingPage.select2NumberOfAdultForRoom1("2", BookingLocators.getselectAdultDrpdown());
			test.log(LogStatus.INFO, "User select \"2 Adult\" for Room1");			
			bookingPage.select1NumberOfAdultForRoom2("1", BookingLocators.getselectAdultRoom2Drpdown());
			test.log(LogStatus.INFO, "User select \"1 Adult\" in  Room2");	
			Thread.sleep(8000);
			bookingPage.selectNumberOfChild("1", "7", "Child2");
			test.log(LogStatus.INFO, "User select \"1 Child\" in Room2,Age of Child:7");	
			bookingPage.clickonContinueButton();
			test.log(LogStatus.INFO, "Click on Continue Button");
			Thread.sleep(8000);
			bookingPage.selectCheaperFlights();
			test.log(LogStatus.INFO, "User clicks on Select Cheaper Flights Link");
			test.log(LogStatus.INFO, "User selects a particular flight from existing options");
			test.log(LogStatus.INFO, "User selects cabin class Coach/Economy");
			test.log(LogStatus.INFO, "User clicks on Continue Link");
			Thread.sleep(8000);
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
			test.log(LogStatus.INFO, "User enters \"Erwin\" as Traveller3 First Name");
			test.log(LogStatus.INFO, "User enters \"George\" as Traveller3 Last Name");
			test.log(LogStatus.INFO, "User selects \"Gender:Male\" for Traveller3 ");
			test.log(LogStatus.INFO, "User selects \"DOB:01/01/2011\" for Traveller3 Date of Birth");
			test.log(LogStatus.INFO, "User selects \"Passport details as:US\" for Traveller3");
			test.log(LogStatus.INFO, "User filled all the passenger details successfully");
			logs.info("User filled all the passenger details successfully");
			Thread.sleep(8000);
			bookingPage.clicktoContinuePage();
			test.log(LogStatus.INFO, "Click on Continue Button & User redirected to the Payment Page");
			PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler1Name(), expectedFirstTravellerInfo);
			PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler2Name(), expectedSecondTravellerInfo);
			PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler3Name(), expectedThirdTravellerInfo);
			PageBase.verifyTravellerDetails(BookingLocators.getverifyTraveler4Name(), expectedFourthTravellerInfo);
			test.log(LogStatus.INFO, "Flights & passenger details verified successfully on PaymentPage");
			logs.info("Flights & passenger details verified successfully on PaymentPage");
		}
}

