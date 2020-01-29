package com.tripmasters.framework.actions;

import java.util.concurrent.TimeUnit;

import com.tripmasters.framework.base.TestBase;
import com.tripmasters.framework.pages.BookingLocators;
import com.tripmasters.framework.utils.CommonLib;

public class BookingPageAction extends TestBase{
	
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
	
	public static void SelectCheaperFlights(){
		CommonLib.ClickUsingJavaScript(BookingLocators.getcheaperFlightsLink());
		CommonLib.ClickUsingJavaScript(BookingLocators.getselectFlightOption());
		CommonLib.ClickUsingJavaScript(BookingLocators.getcontinueLink());
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
    
    public static void GetWithOutButton(){
    	
    	CommonLib.ClickUsingJavaScript(BookingLocators.getWithoutAirButton());
    }
    
    public static void FillBasicBookingDetailWithOutAir(String destination,String stayingTime,String destination_second,String guestinfo) throws Exception{
	
		CommonLib.ClearAndSetValues(BookingLocators.getgoingToTextbox(), destination);
		
		CommonLib.ClickUsingJavaScript(BookingLocators.getaddCityBtn());
		CommonLib.ClearAndSetValues(BookingLocators.getgoingToTextboxSecond(), destination_second);
		//Thread.sleep(2000);
		SelectStayingTime(stayingTime);
		CommonLib.ClickUsingJavaScript(BookingLocators.getnoMoreCitiesBtn());
	    //Thread.sleep(2000);
		SelectGuestDetails(guestinfo);
		
	}
    
    public static void browseHotelsButton() {
    	CommonLib.ClickUsingJavaScript(BookingLocators.getBrowseHotelsLink());
    	CommonLib.ClickUsingJavaScript(BookingLocators.getselectFirstHotel());
    	CommonLib.ClickUsingJavaScript(BookingLocators.getcontinueLink());
    }
	
	
    

	
}
