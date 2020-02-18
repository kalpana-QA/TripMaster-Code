package com.tripmasters.framework.actions;

import java.util.ArrayList;
import java.util.List;
import com.tripmasters.framework.pages.BookingLocators;
import com.tripmasters.framework.pages.PassengerInformationLocators;
import com.tripmasters.framework.utils.CommonLib;

public class PassengerInfoPageAction {

	public static  List<String> fillFirstTravellerDetails(String fname,String lname,String gender,String dateOfBirth,String passportInfo) throws Exception{
            List<String>list=new ArrayList<String>();
        	String firstName=CommonLib.clearAndSetValues(BookingLocators.getFirstTravelerFirstNameTxtbox(), fname);
        	String secondName=CommonLib.clearAndSetValues(BookingLocators.getFirstTravelerLastNameTxtbox(), lname);
        	String fullName=firstName +" "+ secondName;
        	list.add(fullName);
    	    list.add(CommonLib.selectOptionByText(BookingLocators.getFirstTravelerGenderDropdown(), gender));
    		list.add(CommonLib.clearAndSetValues(BookingLocators.getFirstTravelerDOB(), dateOfBirth));
    		CommonLib.selectOptionByValue(BookingLocators.getpassportDrpdownFirstTraveller(), passportInfo);
	    	return list;
	}
	
	public static List<String> fillSecondTravellerDetails(String fname,String lname,String gender,String dateOfBirth,String passportInfo,String travelerType) throws Exception{
		 List<String>list=new ArrayList<String>();
		 String firstName=CommonLib.clearAndSetValues(BookingLocators.getSecondTravelerFirstNameTxtbox(), fname);
		 String secondName=CommonLib.clearAndSetValues(BookingLocators.getSecondTravelerLastNameTxtbox(), lname);
		 String fullName=firstName +" "+ secondName;
		 list.add(fullName);
		 list.add(CommonLib.selectOptionByText(BookingLocators.getSecondTravelerGenderDropdown(), gender));
		if(travelerType.equals("Child")){
			list.add(CommonLib.clearAndSetValues(BookingLocators.getselectChildTravelerDOB(), dateOfBirth));
			CommonLib.selectOptionByValue(BookingLocators.getpassportDrpdownSecondChildTraveller(), passportInfo);
		}
	    else{
		   list.add(CommonLib.clearAndSetValues(BookingLocators.getSecondTravelerDOB(), dateOfBirth));
		   CommonLib.selectOptionByValue(BookingLocators.getpassportDrpdownSecondTraveller(), passportInfo);
		}
		
		return list;
	}
	
	public static List<String> fillThirdTravellerDetails(String fname,String lname,String gender,String dateOfBirth,String passportInfo) throws Exception{
		List<String>list=new ArrayList<String>();
		String firstName=CommonLib.clearAndSetValues(BookingLocators.getthirdTravelerFirstNameTxtbox(), fname);
		String secondName=CommonLib.clearAndSetValues(BookingLocators.getthirdTravelerLastNameTxtbox(), lname);
		String fullName=firstName +" "+ secondName;
		list.add(fullName);
		list.add(CommonLib.selectOptionByText(BookingLocators.getthirdTravelerGenderDropdown(), gender));
		list.add(CommonLib.clearAndSetValues(BookingLocators.getthirdTravelerDOB(), dateOfBirth));
		CommonLib.selectOptionByValue(BookingLocators.getpassportDrpdownThirdTraveller(), passportInfo);
		return list;
	}
	
	public static List<String> fillTravellerDetailsForMultipleRooms(String roomTravelerInfo) throws Exception{
		List<String>list=new ArrayList<String>();
		switch(roomTravelerInfo){
		case "Room1Traveller1":
        	String firstNameR1T1=CommonLib.clearAndSetValues(PassengerInformationLocators.getfnameR1T1(), "yury");
        	String secondNameR1T1=CommonLib.clearAndSetValues(PassengerInformationLocators.getlnameR1T1(), "darwin");
        	String fullNameR1T1=firstNameR1T1 +" "+ secondNameR1T1;
        	list.add(fullNameR1T1);
    	    list.add(CommonLib.selectOptionByText(PassengerInformationLocators.getgenderR1T1(), "Male"));
    		list.add(CommonLib.clearAndSetValues(PassengerInformationLocators.getdobR1T1(), "01/01/2000"));
    		CommonLib.selectOptionByValue(PassengerInformationLocators.getpassportR1T1(), "237|US");
			break;
		case "Room1Traveller2":
			String firstNameR1T2=CommonLib.clearAndSetValues(PassengerInformationLocators.getfnameR1T2(), "Larry");
        	String secondNameR1T2=CommonLib.clearAndSetValues(PassengerInformationLocators.getlnameR1T2(), "darwin");
        	String fullNameR1T2=firstNameR1T2 +" "+ secondNameR1T2;
        	list.add(fullNameR1T2);
    	    list.add(CommonLib.selectOptionByText(PassengerInformationLocators.getgenderR1T2(), "Male"));
    		list.add(CommonLib.clearAndSetValues(PassengerInformationLocators.getdobR1T2(), "01/01/2000"));
    		CommonLib.selectOptionByValue(PassengerInformationLocators.getpassportR1T2(), "237|US");
			break;
		case"Room2Traveller1":
			String firstNameR2T1=CommonLib.clearAndSetValues(PassengerInformationLocators.getfnameR2T1(), "Hanna");
        	String secondNameR2T1=CommonLib.clearAndSetValues(PassengerInformationLocators.getlnameR2T1(), "darwin");
        	String fullNameR2T1=firstNameR2T1 +" "+ secondNameR2T1;
        	list.add(fullNameR2T1);
    	    list.add(CommonLib.selectOptionByText(PassengerInformationLocators.getgenderR2T1(), "Male"));
    		list.add(CommonLib.clearAndSetValues(PassengerInformationLocators.getdobR2T1(), "01/01/2000"));
    		CommonLib.selectOptionByValue(PassengerInformationLocators.getpassportR2T1(), "237|US");
			break;
		case"Room2Traveller2":
			String firstNameR2T2=CommonLib.clearAndSetValues(PassengerInformationLocators.getfnameR2T2(), "Erwin");
        	String secondNameR2T2=CommonLib.clearAndSetValues(PassengerInformationLocators.getlnameR2T2(), "George");
        	String fullNameR2T2=firstNameR2T2 +" "+ secondNameR2T2;
        	list.add(fullNameR2T2);
    	    list.add(CommonLib.selectOptionByText(PassengerInformationLocators.getgenderR2T2(), "Male"));
    		list.add(CommonLib.clearAndSetValues(PassengerInformationLocators.getdobR2T2(), "01/01/2000"));
    		CommonLib.selectOptionByValue(PassengerInformationLocators.getpassportR2T2(), "237|US");
			break;
			
		case"Room1Child1":
			String firstNameR1C1=CommonLib.clearAndSetValues(PassengerInformationLocators.getfnameR1C1(), "Erwin");
        	String secondNameR1C1=CommonLib.clearAndSetValues(PassengerInformationLocators.getlnameR1C1(), "George");
        	String fullNameR1C1=firstNameR1C1 +" "+ secondNameR1C1;
        	list.add(fullNameR1C1);
    	    list.add(CommonLib.selectOptionByText(PassengerInformationLocators.getgenderR1C1(), "Male"));
    		list.add(CommonLib.clearAndSetValues(PassengerInformationLocators.getdobR1C1(), "01/01/2000"));
    		CommonLib.selectOptionByValue(PassengerInformationLocators.getpassportR1C1(), "237|US");
			break;
			
		case"Room2Child1":
			String firstNameR2C1=CommonLib.clearAndSetValues(PassengerInformationLocators.getfnameR2C1(), "Erwin");
        	String secondNameR2C1=CommonLib.clearAndSetValues(PassengerInformationLocators.getlnameR2C1(), "George");
        	String fullNameR2C1=firstNameR2C1 +" "+ secondNameR2C1;
        	list.add(fullNameR2C1);
    	    list.add(CommonLib.selectOptionByText(PassengerInformationLocators.getgenderR2C1(), "Male"));
    		list.add(CommonLib.clearAndSetValues(PassengerInformationLocators.getdobR2C1(), "01/01/2000"));
    		CommonLib.selectOptionByValue(PassengerInformationLocators.getpassportR2C1(), "237|US");
			break;
			
		case "Room1Child1SingleTravlr":
			String firstNameR1C1SingleTravlr=CommonLib.clearAndSetValues(PassengerInformationLocators.getfnameR1C1SingleTrvlr(), "Erwin");
        	String secondNameR1C1SingleTravlr=CommonLib.clearAndSetValues(PassengerInformationLocators.getlnameR1C1SingleTrvlr(), "George");
        	String fullNameR1C1SingleTravlr=firstNameR1C1SingleTravlr +" "+ secondNameR1C1SingleTravlr;
        	list.add(fullNameR1C1SingleTravlr);
    	    list.add(CommonLib.selectOptionByText(PassengerInformationLocators.getgenderR1C1SingleTrvlr(), "Male"));
    		list.add(CommonLib.clearAndSetValues(PassengerInformationLocators.getdobR1C1(), "01/01/2000"));
    		CommonLib.selectOptionByValue(PassengerInformationLocators.getpassportR1C1(), "237|US");
			break;
		
	case"Room2Child1SingleTravlr":
		String firstNameR2C1SingleTravlr=CommonLib.clearAndSetValues(PassengerInformationLocators.getfnameR2C1SingleTrvlr(), "Erwin");
    	String secondNameR2C1SingleTravlr=CommonLib.clearAndSetValues(PassengerInformationLocators.getlnameR2C1SingleTrvlr(), "George");
    	String fullNameR2C1SingleTravlr=firstNameR2C1SingleTravlr +" "+ secondNameR2C1SingleTravlr;
    	list.add(fullNameR2C1SingleTravlr);
	    list.add(CommonLib.selectOptionByText(PassengerInformationLocators.getgenderR2C1SingleTrvlr(), "Male"));
		list.add(CommonLib.clearAndSetValues(PassengerInformationLocators.getdobR2C1SingleTrvlr(), "01/01/2000"));
		CommonLib.selectOptionByValue(PassengerInformationLocators.getpassportR2C1SingleTrvlr(), "237|US");
		break;
		
	}
		return list;
	}
	
}
