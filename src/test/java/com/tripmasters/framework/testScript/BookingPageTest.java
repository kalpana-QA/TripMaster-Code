package com.tripmasters.framework.testScript;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tripmasters.framework.actions.BookingPageAction;
import com.tripmasters.framework.actions.PassengerInfoPageAction;
import com.tripmasters.framework.base.TestBase2;
import com.tripmasters.framework.pages.BookingLocators;
import com.tripmasters.framework.utils.CommonLib;
import com.tripmasters.framework.utils.ExtentTestManager;


public class BookingPageTest extends TestBase2 {
    
	List<String>expectedFirstTravellerInfo=new ArrayList<String>();
	List<String>expectedSecondTravellerInfo=new ArrayList<String>();
	List<String>expectedThirdTravellerInfo=new ArrayList<String>();
	List<String>expectedFourthTravellerInfo=new ArrayList<String>();
	List<String>expectedFlightDetails=new ArrayList<>();
	
	public static String actualHotel;
	public static String expectedHotel;
   
	@Test
	public void bookingSingleRoomWith3Adults(Method method) throws Exception
	{
		ExtentTestManager.startTest(method.getName(), "bookingSingleRoomWith3Adults");
		BookingPageAction.FillBasicBookingDetails("New York  La Guardia, NY","Berlin (Germany)","4","1|3");
		BookingPageAction.ClickonContinueButton();
		BookingPageAction.SelectCheaperFlights();
		BookingPageAction.ClicktoContinuePage();
		//Put assertion before selecting continue image...
		expectedFirstTravellerInfo=PassengerInfoPageAction.FillFirstTravellerDetails("John","Leo","Male","01/01/1992","237|US");
		expectedSecondTravellerInfo=PassengerInfoPageAction.FillSecondTravellerDetails("Elvin","Leo","Male","01/01/1994","237|US","Adult");
		expectedThirdTravellerInfo=PassengerInfoPageAction.FillThirdTravellerDetails("Marie","Leo","Female","01/01/1996","237|US");
		BookingPageAction.ClicktoContinuePage();
		CommonLib.VerifyTravellerDetails(BookingLocators.getverifyTraveler1Name(),expectedFirstTravellerInfo);
		CommonLib.VerifyTravellerDetails(BookingLocators.getverifyTraveler2Name(),expectedSecondTravellerInfo);
		CommonLib.VerifyTravellerDetails(BookingLocators.getverifyTraveler3Name(),expectedThirdTravellerInfo);
  }
	
	@Test
	public void bookingSingleRoom1Adult1Child(Method method) throws Exception{
		
		ExtentTestManager.startTest(method.getName(), "bookingSingleRoom1Adult1Child");
		BookingPageAction.FillBasicBookingDetails("San Jose, CALIFORNIA","Osaka (Japan)","6","1|Other");
		BookingPageAction.SelectNumberOfAdult("1",BookingLocators.getselectAdultDrpdown());
		BookingPageAction.SelectNumberOfChild("1","9","Child1");
		BookingPageAction.ClickonContinueButton();
		BookingPageAction.SelectCheaperFlights();
		BookingPageAction.ClicktoContinuePage();
		expectedFirstTravellerInfo=PassengerInfoPageAction.FillFirstTravellerDetails("Morris","Leo","Male","01/01/1992","237|US");
		expectedSecondTravellerInfo=PassengerInfoPageAction.FillSecondTravellerDetails("Shally","Leo","Male","01/01/1994","237|US","Child");
		BookingPageAction.ClicktoContinuePage();
		CommonLib.VerifyTravellerDetails(BookingLocators.getverifyTraveler1Name(),expectedFirstTravellerInfo);
		CommonLib.VerifyTravellerDetails(BookingLocators.getverifyTraveler2Name(),expectedSecondTravellerInfo);
	}
	
	@Test
	public void bookingTwoRoom2Adult(Method method) throws Exception{
		ExtentTestManager.startTest(method.getName(), "bookingTwoRoom2Adult");
		BookingPageAction.FillBasicBookingDetails("New York, Newark, NJ","Berlin (Germany)","6","2|2-2");
		BookingPageAction.ClickonContinueButton();
		BookingPageAction.SelectCheaperFlights();
		BookingPageAction.ClicktoContinuePage();
		expectedFirstTravellerInfo=PassengerInfoPageAction.FillTravellerDetailsForMultipleRooms("Room1Traveller1");
		expectedSecondTravellerInfo=PassengerInfoPageAction.FillTravellerDetailsForMultipleRooms("Room1Traveller2");
		expectedThirdTravellerInfo=PassengerInfoPageAction.FillTravellerDetailsForMultipleRooms("Room2Traveller1");
		expectedFourthTravellerInfo=PassengerInfoPageAction.FillTravellerDetailsForMultipleRooms("Room2Traveller2");
		BookingPageAction.ClicktoContinuePage();
		CommonLib.VerifyTravellerDetails(BookingLocators.getverifyTraveler1Name(),expectedFirstTravellerInfo);
		CommonLib.VerifyTravellerDetails(BookingLocators.getverifyTraveler2Name(),expectedSecondTravellerInfo);
		CommonLib.VerifyTravellerDetails(BookingLocators.getverifyTraveler3Name(),expectedThirdTravellerInfo);
		CommonLib.VerifyTravellerDetails(BookingLocators.getverifyTraveler4Name(),expectedFourthTravellerInfo);
		
	}
	
	@Test
	public void bookingTwoRoom3Adult1Child(Method method) throws Exception{
		ExtentTestManager.startTest(method.getName(), "bookingTwoRoom3Adult1Child");
		BookingPageAction.FillBasicBookingDetails("New York, Newark, NJ","Berlin (Germany)","6","2|Other");
		BookingPageAction.SelectNumberOfAdult("2",BookingLocators.getselectAdultDrpdown());
		BookingPageAction.SelectNumberOfChild("1","9","Child1");
		BookingPageAction.SelectNumberOfAdult("1",BookingLocators.getselectAdultRoom2Drpdown());
		BookingPageAction.ClickonContinueButton();
		BookingPageAction.SelectCheaperFlights();
		BookingPageAction.ClicktoContinuePage();
		BookingPageAction.ClicktoContinuePage();
		expectedFirstTravellerInfo=PassengerInfoPageAction.FillTravellerDetailsForMultipleRooms("Room1Traveller1");
		expectedSecondTravellerInfo=PassengerInfoPageAction.FillTravellerDetailsForMultipleRooms("Room1Traveller2");
		//expectedThirdTravellerInfo=PassengerInfoPageAction.FillSecondTravellerDetails("Shally","Leo","Male","01/01/1994","237|US","Child");
		expectedThirdTravellerInfo=PassengerInfoPageAction.FillTravellerDetailsForMultipleRooms("Room1Child1");
		expectedFourthTravellerInfo=PassengerInfoPageAction.FillTravellerDetailsForMultipleRooms("Room2Traveller1");
		BookingPageAction.ClicktoContinuePage();
		CommonLib.VerifyTravellerDetails(BookingLocators.getverifyTraveler1Name(),expectedFirstTravellerInfo);
		CommonLib.VerifyTravellerDetails(BookingLocators.getverifyTraveler2Name(),expectedSecondTravellerInfo);
		CommonLib.VerifyTravellerDetails(BookingLocators.getverifyTraveler3Name(),expectedThirdTravellerInfo);
		CommonLib.VerifyTravellerDetails(BookingLocators.getverifyTraveler4Name(),expectedFourthTravellerInfo);
	
	}
	
	@Test
	public void booking2Room2Adult2Child(Method method) throws Exception{
		ExtentTestManager.startTest(method.getName(), "booking2Room2Adult2Child");
		BookingPageAction.FillBasicBookingDetails("New York, Newark, NJ","Berlin (Germany)","6","2|Other");
		BookingPageAction.SelectNumberOfAdult("1",BookingLocators.getselectAdultDrpdown());
		BookingPageAction.SelectNumberOfChild("1","9","Child1");
		BookingPageAction.SelectNumberOfAdult("1",BookingLocators.getselectAdultRoom2Drpdown());
		BookingPageAction.SelectNumberOfChild("1","9","Child2");
		BookingPageAction.ClickonContinueButton();
		BookingPageAction.SelectCheaperFlights();
		BookingPageAction.ClicktoContinuePage();
		BookingPageAction.ClicktoContinuePage();
		expectedFirstTravellerInfo=PassengerInfoPageAction.FillTravellerDetailsForMultipleRooms("Room1Traveller1");
		expectedSecondTravellerInfo=PassengerInfoPageAction.FillTravellerDetailsForMultipleRooms("Room1Child1");
		expectedThirdTravellerInfo=PassengerInfoPageAction.FillTravellerDetailsForMultipleRooms("Room2Traveller1");
		expectedFourthTravellerInfo=PassengerInfoPageAction.FillTravellerDetailsForMultipleRooms("Room2Child1");
		BookingPageAction.ClicktoContinuePage();
		CommonLib.VerifyTravellerDetails(BookingLocators.getverifyTraveler1Name(),expectedFirstTravellerInfo);
		CommonLib.VerifyTravellerDetails(BookingLocators.getverifyTraveler2Name(),expectedSecondTravellerInfo);
		CommonLib.VerifyTravellerDetails(BookingLocators.getverifyTraveler3Name(),expectedThirdTravellerInfo);
		CommonLib.VerifyTravellerDetails(BookingLocators.getverifyTraveler4Name(),expectedFourthTravellerInfo);
		
	}
	@Test
	public void getWithoutAir(Method method) throws Exception  {
		ExtentTestManager.startTest(method.getName(), "getWithoutAir");
		BookingPageAction.getWithoutButton();
		BookingPageAction.fillBasicBookingDetailForMultipleCities("WithOutAir","Delhi (India)","4","Mumbai (India)","1|3");
		BookingPageAction.ClickonContinueButton();
		actualHotel = BookingPageAction.browseHotelsButton();
	    expectedHotel = BookingPageAction.browseSelectHotel();
		Assert.assertEquals(actualHotel, expectedHotel);
		BookingPageAction.getContinueLink();
		System.out.println("passed");
	}
	
	@Test
	public void bookingFlightsWithmultipleCities(Method method) throws Exception{
		ExtentTestManager.startTest(method.getName(), "bookingFlightsWithmultipleCities");
		BookingPageAction.fillBasicBookingDetailForMultipleCities("WithAir","Berlin (Germany)","4","Augsburg (Germany)","1|Other");
		BookingPageAction.SelectNumberOfAdult("1",BookingLocators.getselectAdultDrpdown());
		BookingPageAction.SelectNumberOfChild("1","9","Child1");
		BookingPageAction.ClickonContinueButton();
		BookingPageAction.SelectCheaperFlights();
		BookingPageAction.ClicktoContinuePage();
		BookingPageAction.ClicktoContinuePage();
		expectedFirstTravellerInfo=PassengerInfoPageAction.FillFirstTravellerDetails("Morris","Leo","Male","01/01/1992","237|US");
		expectedSecondTravellerInfo=PassengerInfoPageAction.FillSecondTravellerDetails("Shally","Leo","Male","01/01/1994","237|US","Child");
		BookingPageAction.ClicktoContinuePage();
		CommonLib.VerifyTravellerDetails(BookingLocators.getverifyTraveler1Name(),expectedFirstTravellerInfo);
		CommonLib.VerifyTravellerDetails(BookingLocators.getverifyTraveler2Name(),expectedSecondTravellerInfo);
	}
	
	@Test
	public void bookingFlightAndHotelForSingleCity(Method method) throws Exception{
		ExtentTestManager.startTest(method.getName(), "bookingFlightAndHotelForSingleCity");
		BookingPageAction.FillBasicBookingDetails("New York, Newark, NJ","Berlin (Germany)","6","2|Other");
		BookingPageAction.SelectNumberOfAdult("1",BookingLocators.getselectAdultDrpdown());
		BookingPageAction.SelectNumberOfChild("1","9","Child1");
		BookingPageAction.SelectNumberOfAdult("1",BookingLocators.getselectAdultRoom2Drpdown());
		BookingPageAction.ClickonContinueButton();
		actualHotel = BookingPageAction.browseHotelsButton();
		expectedHotel = BookingPageAction.browseSelectHotel();
		BookingPageAction.getContinueLink();
		String expected=BookingPageAction.SelectCheaperFlights();
		String actualFlightDetails=BookingPageAction.GetActualFlight();
		System.out.println(expected);
		System.out.println(actualFlightDetails);
		Assert.assertTrue(expected.contains(actualFlightDetails));
		Assert.assertEquals(actualHotel, expectedHotel);
	}
	
}
