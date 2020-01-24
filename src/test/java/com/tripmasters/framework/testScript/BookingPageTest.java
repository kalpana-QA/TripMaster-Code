package com.tripmasters.framework.testScript;

import org.testng.annotations.Test;

import com.tripmasters.framework.actions.BookingPageAction;
import com.tripmasters.framework.actions.ConfirmationPageAction;
import com.tripmasters.framework.actions.PassengerInfoPageAction;
import com.tripmasters.framework.base.TestBase;

public class BookingPageTest extends TestBase {
	public static String firstTravellerName=null;
	public static String secondTravellerName=null;
	public static String thirdTravellerName=null;
	public void getTitle() {
		String title = driver.getTitle();
		System.out.println("title is: " + title);
	}
	
	@Test
	public void bookingInitialise() throws Exception
	{
		BookingPageAction.FillBasicBookingDetails();
		BookingPageAction.SelectCheaperFlights();
		BookingPageAction.ClicktoContinuePage();
		//Put assertion before selecting continue image....
		firstTravellerName=PassengerInfoPageAction.FillFirstTravellerDetails();
		secondTravellerName=PassengerInfoPageAction.FillSecondTravellerDetails();
		thirdTravellerName=PassengerInfoPageAction.FillThirdTravellerDetails();
		BookingPageAction.ClicktoContinuePage();
		ConfirmationPageAction.VerifyFirstTravellerDetails(firstTravellerName);
		ConfirmationPageAction.VerifySecondTravellerDetails(secondTravellerName);
		ConfirmationPageAction.VerifyThirdTravellerDetails(thirdTravellerName);
	}
	
	public void FillTravellerDetails() throws Exception{

	}
	
	public void ValidateUserDetails(){
		
	}
}
