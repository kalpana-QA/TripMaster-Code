package com.tripmasters.framework.actions;

import java.util.ArrayList;
import java.util.List;
import com.tripmasters.framework.pages.BookingLocators;
import com.tripmasters.framework.utils.CommonLib;

public class PassengerInfoPageAction {

	public static  List<String> FillFirstTravellerDetails(String fname,String lname,String gender,String dateOfBirth,String passportInfo) throws Exception{
            List<String>list=new ArrayList<String>();
        	String firstName=CommonLib.ClearAndSetValues(BookingLocators.getFirstTravelerFirstNameTxtbox(), fname);
        	String secondName=CommonLib.ClearAndSetValues(BookingLocators.getFirstTravelerLastNameTxtbox(), lname);
        	String fullName=firstName +" "+ secondName;
        	list.add(fullName);
    	    list.add(CommonLib.SelectOptionByText(BookingLocators.getFirstTravelerGenderDropdown(), gender));
    		list.add(CommonLib.ClearAndSetValues(BookingLocators.getFirstTravelerDOB(), dateOfBirth));
    		CommonLib.SelectOptionByValue(BookingLocators.getpassportDrpdownFirstTraveller(), passportInfo);
	    	return list;
	}
	
	public static List<String> FillSecondTravellerDetails(String fname,String lname,String gender,String dateOfBirth,String passportInfo,String travelerType) throws Exception{
		 List<String>list=new ArrayList<String>();
		 String firstName=CommonLib.ClearAndSetValues(BookingLocators.getSecondTravelerFirstNameTxtbox(), fname);
		 String secondName=CommonLib.ClearAndSetValues(BookingLocators.getSecondTravelerLastNameTxtbox(), lname);
		 String fullName=firstName +" "+ secondName;
		 list.add(fullName);
		 list.add(CommonLib.SelectOptionByText(BookingLocators.getSecondTravelerGenderDropdown(), gender));
		if(travelerType.equals("Child")){
			list.add(CommonLib.ClearAndSetValues(BookingLocators.getselectChildTravelerDOB(), dateOfBirth));
			CommonLib.SelectOptionByValue(BookingLocators.getpassportDrpdownSecondChildTraveller(), passportInfo);
		}
	    else{
		   list.add(CommonLib.ClearAndSetValues(BookingLocators.getSecondTravelerDOB(), dateOfBirth));
		   CommonLib.SelectOptionByValue(BookingLocators.getpassportDrpdownSecondTraveller(), passportInfo);
		}
		
		return list;
	}
	
	public static List<String> FillThirdTravellerDetails(String fname,String lname,String gender,String dateOfBirth,String passportInfo) throws Exception{
		List<String>list=new ArrayList<String>();
		String firstName=CommonLib.ClearAndSetValues(BookingLocators.getthirdTravelerFirstNameTxtbox(), fname);
		String secondName=CommonLib.ClearAndSetValues(BookingLocators.getthirdTravelerLastNameTxtbox(), lname);
		String fullName=firstName +" "+ secondName;
		list.add(fullName);
		list.add(CommonLib.SelectOptionByText(BookingLocators.getthirdTravelerGenderDropdown(), gender));
		list.add(CommonLib.ClearAndSetValues(BookingLocators.getthirdTravelerDOB(), dateOfBirth));
		CommonLib.SelectOptionByValue(BookingLocators.getpassportDrpdownThirdTraveller(), passportInfo);
		return list;
	}
	
}
