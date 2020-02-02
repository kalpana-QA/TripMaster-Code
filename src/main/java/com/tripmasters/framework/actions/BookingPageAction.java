package com.tripmasters.framework.actions;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
	
	public static String SelectCheaperFlights(){
		//	List<String>expectedFlightdetails=new ArrayList<String>();
		CommonLib.ClickUsingJavaScript(BookingLocators.getcheaperFlightsLink());
		
		//List<WebElement> expectedFlight=driver.findElements(BookingLocators.getfirstFlightDetails());
//		 for(WebElement details:expectedFlight){
//			 expectedFlightdetails.add(details.getText());
//		}
		String flightvalue=driver.findElement(BookingLocators.getexpectedFlight()).getText();
    	
		CommonLib.ClickUsingJavaScript(BookingLocators.getselectFlightOption());

		CommonLib.ClickUsingJavaScript(BookingLocators.getcontinueLink());
		//return expectedFlightdetails;
		return flightvalue;

	}
	
	public static void ClicktoContinuePage(){
		
		CommonLib.ClickUsingJavaScript(BookingLocators.getcontinueImage());
	}
	
	public static void SelectNumberOfAdult(String numOfAdults,By element){
		
		CommonLib.SelectOptionByValue(element, numOfAdults);
	}
	
    public static void SelectNumberOfChild(String numOfChild,String ageOfChild,String childType){
    	if(childType.equals("Child1")){
		CommonLib.SelectOptionByValue(BookingLocators.getselectChildDrpdown(), numOfChild);
		CommonLib.SelectOptionByValue(BookingLocators.getselectChildAgeDrpdown(), ageOfChild);
    	}
    	else{
    	CommonLib.SelectOptionByValue(BookingLocators.getselectChildRoom2Drpdown(), numOfChild);
   		CommonLib.SelectOptionByValue(BookingLocators.getselectChildAgeRoom2Drpdown(), ageOfChild);
    	}
	}
	

    public static void getWithoutButton(){
    	
    	CommonLib.ClickUsingJavaScript(BookingLocators.getWithoutAirButton());
    }
    
     public static void fillBasicBookingDetailForMultipleCities(String flightType,String destination, String stayingTime,String destination_second, String guestinfo) throws Exception {
        if(flightType.equalsIgnoreCase("WithAir")){
        	CommonLib.ClearAndSetValues(BookingLocators.getLeavingTxtbox(), "New York, Newark, NJ");
        }
    	CommonLib.ClearAndSetValues(BookingLocators.getgoingToTextbox(), destination);
		CommonLib.ClickUsingJavaScript(BookingLocators.getaddCityBtn());
		CommonLib.ClearAndSetValues(BookingLocators.getgoingToTextboxSecond(), destination_second);
		SelectStayingTime(stayingTime);
		CommonLib.ClickUsingJavaScript(BookingLocators.getnoMoreCitiesBtn());
		SelectGuestDetails(guestinfo);
	}
    
    public static String browseHotelsButton() {
    	CommonLib.ClickUsingJavaScript(BookingLocators.getBrowseHotelsLink());
    	String actualhotel=driver.findElement(BookingLocators.getFirstHotel()).getText();
    	System.out.println(actualhotel);
    	return actualhotel;
    }
    public static String browseSelectHotel() {
    	CommonLib.ClickUsingJavaScript(BookingLocators.getselectFirstHotel());
    	String expectedhotel = driver.findElement(BookingLocators.getExpectedHotel()).getText();
    	System.out.println(expectedhotel);
    	return expectedhotel;
    }
    public static void getContinueLink() {
    	CommonLib.ClickUsingJavaScript(BookingLocators.getcontinueLink());
    }
    
    public static List<String> GetSelectedFlightsDetails(){
    	List<String>actualFlightdetails=new ArrayList<String>();
    	
       List<WebElement> actualFlight=driver.findElements(BookingLocators.getactualFlightDetails());
       
		 for(WebElement details:actualFlight){
			 actualFlightdetails.add(details.getText());
		}
		 return actualFlightdetails;
    }
    
//    public static String GetExpectedFlight(){
//    	String flightvalue=driver.findElement(BookingLocators.getexpectedFlight()).getText();
//    	return flightvalue;
//    }
    
    public static String GetActualFlight(){
    	String flightvalue=driver.findElement(BookingLocators.getactualFlightDetails()).getText();
    	return flightvalue;
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
