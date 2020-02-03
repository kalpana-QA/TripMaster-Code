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
		return flightvalue;

	}
	
	public static void ClicktoContinuePage(){
		
		CommonLib.ClickUsingJavaScript(BookingLocators.getcontinueImage());
	}
	
	public static void SelectNumberOfAdult(String numOfAdults,By element){
		
		CommonLib.SelectOptionByValue(element, numOfAdults);
	}

	public static void ClickOnWithoutAir() {
	
		BookingLocators.getWithoutAirButton();
		
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
    

    public static void getWithoutButton(){
    	
    	CommonLib.ClickUsingJavaScript(BookingLocators.getWithoutAirButton());
    }
    
    public static void fillBasicBookingDetailWithoutAir(String destination,String stayingTime,String destination_second,String guestinfo) throws Exception{
	
		CommonLib.ClearAndSetValues(BookingLocators.getgoingToTextbox(), destination);
		
		CommonLib.ClickUsingJavaScript(BookingLocators.getaddCityBtn());
		CommonLib.ClearAndSetValues(BookingLocators.getgoingToTextboxSecond(), destination_second);
		
		SelectStayingTime(stayingTime);
		CommonLib.ClickUsingJavaScript(BookingLocators.getnoMoreCitiesBtn());
	    
		SelectGuestDetails(guestinfo);
		
	}
    
    public static String browseHotelsButton() {
    	CommonLib.ClickUsingJavaScript(BookingLocators.getBrowseHotelsLink());
    	String actualhotel= driver.findElement(BookingLocators.getFirstHotel()).getText();
    	return actualhotel;
    }
    public static String browseSelectHotel() {
    	CommonLib.ClickUsingJavaScript(BookingLocators.getselectFirstHotel());
    	String expectedhotel = driver.findElement(BookingLocators.getExpectedHotel()).getText();
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
	
	public static void ClickChangedArriveDate()
	{
		CommonLib.ClickUsingJavaScript(BookingLocators.getChangedArriveDate());
	}
	
	 public static void clickSearch() {
	    	CommonLib.ClickUsingJavaScript(BookingLocators.getSearchBox());
	    	}
	    
	    public static void fillSearch(String city) throws Exception {
	    	CommonLib.ClearAndSetValues(BookingLocators.getSearchBox(), city);
	    	CommonLib.ClickUsingJavaScript(BookingLocators.getGoButton());
	    }
	    public static boolean validateURL() {
	    	boolean result = false;
	    	if(driver.getCurrentUrl().contains("Berlin"))
	    	{
	    		result = true;
	    	}
	    	return result;
	    	
	    }
	    public static void fillBasicDetails(String leavefrom,String firstdestination,String stayingTime,String seconddestination,String seconddrop,String thirddestination,String thirddrop) throws Exception {
	    	
	    	CommonLib.ClearAndSetValues(BookingLocators.getLeavingTxtbox(), leavefrom);
			CommonLib.ClearAndSetValues(BookingLocators.getgoingToTextbox(), firstdestination);
			SelectStayingTime(stayingTime);
			
			CommonLib.ClickUsingJavaScript(BookingLocators.getaddCityBtn());
			
			CommonLib.ClearAndSetValues(BookingLocators.getgoingToTextboxSecond(), seconddestination);
			SelectStayingTimeTwo(seconddrop);
			CommonLib.ClickUsingJavaScript(BookingLocators.getaddCityBtn());
			
			 CommonLib.ClearAndSetValues(BookingLocators.getgoingToTextboxThird(), thirddestination);
			SelectStayingTimeThree(thirddrop);
			
			
			
	    }
	    public static void deleteAddedCities() {
	    	CommonLib.ClickUsingJavaScript(BookingLocators.getthirdremoveCitylink());
	    	CommonLib.ClickUsingJavaScript(BookingLocators.getsecondremovecitylink());
			CommonLib.ClickUsingJavaScript(BookingLocators.getnoMoreCitiesBtn());
		   
	    }
	    public static void selectguesdetatils(String guestinfo) {
	    	SelectGuestDetails(guestinfo);
	    }
	    public static boolean isremovecitydisplayed() {
	    	boolean result = false;
	    	if(driver.findElement(BookingLocators.getsecondremovecitylink()).isDisplayed()){
	    		result  = true;
	    	}
	    	return result;
	    }
	    public static boolean validateremovedcity() {
	    	try {
	    	driver.findElement(BookingLocators.getthirdremoveCitylink()).isEnabled();
	    	return false;
	    	}
	    	catch(Exception NoSuchElementException) {
	    		return true;
	    	}
	    	
	    }
	    public static void SelectStayingTimeTwo(String stayingTimeTwo){
			
			CommonLib.SelectOptionByValue(BookingLocators.getstayingDrpdowntwo(), stayingTimeTwo);
		}
	    public static void SelectStayingTimeThree(String stayingTimeThree){
			
			CommonLib.SelectOptionByValue(BookingLocators.getstayingDrpdownthree(), stayingTimeThree);
		}
}

