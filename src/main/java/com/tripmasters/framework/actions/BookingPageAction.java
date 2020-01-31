package com.tripmasters.framework.actions;

import org.openqa.selenium.By;

import com.tripmasters.framework.base.TestBase;
import com.tripmasters.framework.base.TestBase2;
import com.tripmasters.framework.pages.BookingLocators;
import com.tripmasters.framework.utils.CommonLib;

public class BookingPageAction extends TestBase2{
	
	public static void FillBasicBookingDetails(String leavingFrom,String destination,String stayingTime,String guestInfo) throws Exception{
		CommonLib.ClearAndSetValues(BookingLocators.getLeavingTxtbox(), leavingFrom);
		CommonLib.ClearAndSetValues(BookingLocators.getgoingToTextbox(), destination);
		SelectStayingTime(stayingTime);
		CommonLib.ClickUsingJavaScript(BookingLocators.getnoMoreCitiesBtn());
		SelectGuestDetails(guestInfo);
	}
	
	public static void SelectStayingTime(String stayingTime){
		
		CommonLib.SelectOptionByValue(BookingLocators.getstayingDrpdown(), stayingTime);
	}
	
	public static void SelectGuestDetails(String guestInfo){

		CommonLib.SelectOptionByValue(BookingLocators.getselectGuestDrpdown(), guestInfo);
	}
	
	public static void ClickonContinueButton(){
		
		CommonLib.ClickUsingJavaScript(BookingLocators.getcontinueBtn());
	}
	
	public static void ClickonContinueLink()
	{
		CommonLib.ClickUsingJavaScript(BookingLocators.getcontinueLink());
	}
	
	public static void SelectCheaperFlights(){
		CommonLib.ClickUsingJavaScript(BookingLocators.getcheaperFlightsLink());
		CommonLib.ClickUsingJavaScript(BookingLocators.getselectFlightOption());
	
	}
	
	public static void ClicktoContinuePage(){

		CommonLib.ClickUsingJavaScript(BookingLocators.getcontinueImage());
	}
	
	public static void SelectNumberOfAdult(String numOfAdults){
		
		CommonLib.SelectOptionByValue(BookingLocators.getselectAdultDrpdown(), numOfAdults);
		
	}
	
    public static void SelectNumberOfChild(String numOfChild,String ageOfChild){
		CommonLib.SelectOptionByValue(BookingLocators.getselectChildDrpdown(), numOfChild);
		CommonLib.SelectOptionByValue(BookingLocators.getselectChildAgeDrpdown(), ageOfChild);
	}

	

	public static void SelectWithoutAir() {
		CommonLib.ClickUsingJavaScript(BookingLocators.getwithoutAir());
		
	}
	
	public static void FillBasicBookingDetails2(String destination,String stayingTime,String guestInfo ) throws Exception
	{
		CommonLib.ClearAndSetValues(BookingLocators.getgoingToTextbox(), destination);
		SelectStayingTime(stayingTime);
		CommonLib.ClickUsingJavaScript(BookingLocators.getnoMoreCitiesBtn());
		SelectGuestDetails(guestInfo);
	}
	
public static String BrowseHotels()	{
		CommonLib.ClickUsingJavaScript(BookingLocators.getBrowseHotelLink());
	    String actualhotel =driver.findElement(BookingLocators.getSelectHotelName()).getText();
		return actualhotel;
		
	}
	
	public static String SelectHotel()
	{
		CommonLib.ClickUsingJavaScript(BookingLocators.getSelectHotelOption());
		String expectedhotel = driver.findElement(BookingLocators.getVerifyHotelName()).getText();
		return expectedhotel;
	}
	
	public static void ClickChangedArriveDate()
	{
		CommonLib.ClickUsingJavaScript(BookingLocators.getChangedArriveDate());
	}
	

}
