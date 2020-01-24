package com.tripmasters.framework.actions;

import java.util.ArrayList;

import com.tripmasters.framework.pages.BookingLocators;
import com.tripmasters.framework.utils.CommonLib;

public class PassengerInfoPageAction {

	public static String FillFirstTravellerDetails() throws Exception{

		String firstTravlrActualName =CommonLib.ClearAndSetValues(BookingLocators.getFirstTravelerFirstNameTxtbox(), "John");
		String firstTravlrActuallstName =CommonLib.ClearAndSetValues(BookingLocators.getFirstTravelerLastNameTxtbox(), "Leo");
	    CommonLib.SelectOptionByValue(BookingLocators.getFirstTravelerGenderDropdown(), "M");
		CommonLib.ClearAndSetValues(BookingLocators.getFirstTravelerDOB(), "01/01/1992");
		CommonLib.SelectOptionByValue(BookingLocators.getpassportDrpdownFirstTraveller(), "237|US");
		return firstTravlrActualName +" "+ firstTravlrActuallstName;
	}
	
	public static String FillSecondTravellerDetails() throws Exception{
		String secondTravlrActualName =CommonLib.ClearAndSetValues(BookingLocators.getSecondTravelerFirstNameTxtbox(), "Marie");
		String secondTravlrActuallstName =CommonLib.ClearAndSetValues(BookingLocators.getSecondTravelerLastNameTxtbox(), "Leo");
		CommonLib.SelectOptionByValue(BookingLocators.getSecondTravelerGenderDropdown(), "F");
		CommonLib.ClearAndSetValues(BookingLocators.getSecondTravelerDOB(), "01/01/1993");
		CommonLib.SelectOptionByValue(BookingLocators.getpassportDrpdownSecondTraveller(), "237|US");
		return secondTravlrActualName +" "+secondTravlrActuallstName;
	}
	
	public static String FillThirdTravellerDetails() throws Exception{
		String thirdTravlrActualName=CommonLib.ClearAndSetValues(BookingLocators.getthirdTravelerFirstNameTxtbox(), "Elvin");
		String thirdTravlrActuallstName=CommonLib.ClearAndSetValues(BookingLocators.getthirdTravelerLastNameTxtbox(), "Leo");
		CommonLib.SelectOptionByValue(BookingLocators.getthirdTravelerGenderDropdown(), "M");
		CommonLib.ClearAndSetValues(BookingLocators.getthirdTravelerDOB(), "01/01/1994");
		CommonLib.SelectOptionByValue(BookingLocators.getpassportDrpdownThirdTraveller(), "237|US");
		return thirdTravlrActualName +" " + thirdTravlrActuallstName;
	}
	
}
