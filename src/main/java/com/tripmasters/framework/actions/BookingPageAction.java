package com.tripmasters.framework.actions;


import org.openqa.selenium.By;
import com.tripmasters.framework.base.TestBase;
import com.tripmasters.framework.pages.BookingLocators;
import com.tripmasters.framework.utils.CommonLib;

public class BookingPageAction extends TestBase{
	
	public static void FillBasicBookingDetails() throws Exception{
		
		CommonLib.ClearAndSetValues(BookingLocators.getLeavingTxtbox(), "New York  La Guardia, NY");
		CommonLib.ClearAndSetValues(BookingLocators.getgoingToTextbox(), "Berlin (Germany)");
		CommonLib.SelectOptionByValue(BookingLocators.getstayingDrpdown(), "4");
		CommonLib.ClickUsingJavaScript(BookingLocators.getnoMoreCitiesBtn());
		CommonLib.SelectOptionByValue(BookingLocators.getselectGuestDrpdown(), "1|3");
		CommonLib.ClickUsingJavaScript(BookingLocators.getcontinueBtn());
	}

	public static void SelectCheaperFlights(){
		CommonLib.ClickUsingJavaScript(BookingLocators.getcheaperFlightsLink());
		CommonLib.ClickUsingJavaScript(BookingLocators.getselectFlightOption());
		CommonLib.ClickUsingJavaScript(BookingLocators.getcontinueLink());
	}
	
	public static void ClicktoContinuePage(){
	
		CommonLib.ClickUsingJavaScript(BookingLocators.getcontinueImage());
		
	}
		
	
}
