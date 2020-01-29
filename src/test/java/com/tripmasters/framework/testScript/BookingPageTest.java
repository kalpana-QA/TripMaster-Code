package com.tripmasters.framework.testScript;

import java.util.ArrayList;
import java.util.List;
import org.testng.annotations.Test;

import com.tripmasters.framework.actions.BookingPageAction;
import com.tripmasters.framework.actions.PassengerInfoPageAction;
import com.tripmasters.framework.base.TestBase2;
import com.tripmasters.framework.pages.BookingLocators;
import com.tripmasters.framework.utils.CommonLib;

public class BookingPageTest extends TestBase2 {
    
	List<String>expectedFirstTravellerInfo=new ArrayList<String>();
	List<String>expectedSecondTravellerInfo=new ArrayList<String>();
	List<String>expectedThirdTravellerInfo=new ArrayList<String>();
   
	//@Test
	public void bookingSingleRoomWith3Adults() throws Exception
	{
		BookingPageAction.FillBasicBookingDetails("New York  La Guardia, NY","Berlin (Germany)","4","1|3");
		BookingPageAction.ClickonContinueButton();
		BookingPageAction.SelectCheaperFlights();
		BookingPageAction.ClicktoContinuePage();
		//Put assertion before selecting continue image....
		expectedFirstTravellerInfo=PassengerInfoPageAction.FillFirstTravellerDetails("John","Leo","Male","01/01/1992","237|US");
		expectedSecondTravellerInfo=PassengerInfoPageAction.FillSecondTravellerDetails("Elvin","Leo","Male","01/01/1994","237|US","Adult");
		expectedThirdTravellerInfo=PassengerInfoPageAction.FillThirdTravellerDetails("Marie","Leo","Female","01/01/1996","237|US");
		BookingPageAction.ClicktoContinuePage();
		CommonLib.VerifyTravellerDetails(BookingLocators.getverifyTraveler1Name(),expectedFirstTravellerInfo);
		CommonLib.VerifyTravellerDetails(BookingLocators.getverifyTraveler2Name(),expectedSecondTravellerInfo);
		CommonLib.VerifyTravellerDetails(BookingLocators.getverifyTraveler3Name(),expectedThirdTravellerInfo);
	}
	
	//@Test
	public void bookingSingleRoom1Adult1Child() throws Exception{
		BookingPageAction.FillBasicBookingDetails("San Jose, CALIFORNIA","Osaka (Japan)","6","1|Other");
		BookingPageAction.SelectNumberOfAdult("1");
		BookingPageAction.SelectNumberOfChild("1","9");
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
	public void bookingTwoRoom2Adult() throws Exception{
		BookingPageAction.FillBasicBookingDetails("New York, Newark, NJ","Berlin (Germany)","6","1|Other");
		BookingPageAction.SelectNumberOfAdult("1");
		BookingPageAction.SelectNumberOfChild("1","9");
		BookingPageAction.ClickonContinueButton();
		BookingPageAction.SelectCheaperFlights();
		BookingPageAction.ClicktoContinuePage();
		expectedFirstTravellerInfo=PassengerInfoPageAction.FillFirstTravellerDetails("Morris","Leo","Male","01/01/1992","237|US");
		expectedSecondTravellerInfo=PassengerInfoPageAction.FillSecondTravellerDetails("Shally","Leo","Male","01/01/1994","237|US","Child");
		BookingPageAction.ClicktoContinuePage();
		CommonLib.VerifyTravellerDetails(BookingLocators.getverifyTraveler1Name(),expectedFirstTravellerInfo);
		CommonLib.VerifyTravellerDetails(BookingLocators.getverifyTraveler2Name(),expectedSecondTravellerInfo);
	}
}
