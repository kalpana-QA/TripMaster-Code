package com.tripmasters.framework.testScript;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.tripmasters.framework.actions.BookingPageAction;
import com.tripmasters.framework.actions.ConfirmationPageAction;
import com.tripmasters.framework.actions.PassengerInfoPageAction;
import com.tripmasters.framework.base.TestBase2;

public class BookingPageTest extends TestBase2 {
	public static String firstTravellerName=null;
	public static String secondTravellerName=null;
	public static String thirdTravellerName=null;
	
	public void getTitle() {
		String title = driver.getTitle();
		System.out.println("title is: " + title);
	}
	
	//@Test
	public void bookingInitialise1() throws Exception
	{
		//generateReport.extent.createTest("bookingInitialise");
		//boolean status=BookingPageAction.FillBasicBookingDetails();
		System.out.println("hello");
		//String title = driver.getCurrentUrl();
		//Assert.assertEquals("Vacation Packages | Custom Vacation Packages | Tripmasters", title);
	}
	//@Test
	public void bookingInitialise() throws Exception
	{
		BookingPageAction.FillBasicBookingDetails();
		//BookingPageAction.SelectGuestDetails("1 Room 3 Adults");
		BookingPageAction.ClickonContinueButton();
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
	
	//@Test
	public void bookingSingleRoomAdultChild(){
		
		
	}
	@Test
	public void bookingMultipleCityWithoutAir()
		{
		BookingPageAction.ClickOnWithoutAir();                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		}
	
}
