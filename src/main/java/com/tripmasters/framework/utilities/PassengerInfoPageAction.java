package com.tripmasters.framework.utilities;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;

import com.tripmasters.framework.base.PageBase;
import com.tripmasters.framework.pageLocators.BookingLocators;
import com.tripmasters.framework.pageLocators.PassengerInformationLocators;

public class PassengerInfoPageAction extends PageBase {

	public PassengerInfoPageAction(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public List<String> FillFirstTravellerDetails(String fname, String lname, String gender, String dateOfBirth,
			String passportInfo) throws Exception {
		List<String> list = new ArrayList<String>();
		String firstName = ClearAndSetValues(BookingLocators.getFirstTravelerFirstNameTxtbox(), fname);
		String secondName = ClearAndSetValues(BookingLocators.getFirstTravelerLastNameTxtbox(), lname);
		String fullName = firstName + " " + secondName;
		list.add(fullName);
		list.add(SelectOptionByText(BookingLocators.getFirstTravelerGenderDropdown(), gender));
		list.add(ClearAndSetValues(BookingLocators.getFirstTravelerDOB(), dateOfBirth));
		SelectOptionByValue(BookingLocators.getpassportDrpdownFirstTraveller(), passportInfo);
		return list;
	}

	public List<String> FillSecondTravellerDetails(String fname, String lname, String gender, String dateOfBirth,
			String passportInfo, String travelerType) throws Exception {
		List<String> list = new ArrayList<String>();
		String firstName = ClearAndSetValues(BookingLocators.getSecondTravelerFirstNameTxtbox(), fname);
		String secondName = ClearAndSetValues(BookingLocators.getSecondTravelerLastNameTxtbox(), lname);
		String fullName = firstName + " " + secondName;
		list.add(fullName);
		list.add(SelectOptionByText(BookingLocators.getSecondTravelerGenderDropdown(), gender));
		if (travelerType.equals("Child")) {
			list.add(ClearAndSetValues(BookingLocators.getselectChildTravelerDOB(), dateOfBirth));
			SelectOptionByValue(BookingLocators.getpassportDrpdownSecondChildTraveller(), passportInfo);
		} else {
			list.add(ClearAndSetValues(BookingLocators.getSecondTravelerDOB(), dateOfBirth));
			SelectOptionByValue(BookingLocators.getpassportDrpdownSecondTraveller(), passportInfo);
		}

		return list;
	}

	public List<String> FillThirdTravellerDetails(String fname, String lname, String gender, String dateOfBirth,
			String passportInfo) throws Exception {
		List<String> list = new ArrayList<String>();
		String firstName = ClearAndSetValues(BookingLocators.getthirdTravelerFirstNameTxtbox(), fname);
		String secondName = ClearAndSetValues(BookingLocators.getthirdTravelerLastNameTxtbox(), lname);
		String fullName = firstName + " " + secondName;
		list.add(fullName);
		list.add(SelectOptionByText(BookingLocators.getthirdTravelerGenderDropdown(), gender));
		list.add(ClearAndSetValues(BookingLocators.getthirdTravelerDOB(), dateOfBirth));
		SelectOptionByValue(BookingLocators.getpassportDrpdownThirdTraveller(), passportInfo);
		return list;
	}

	public List<String> FillTravellerDetailsForMultipleRooms(String RoomTravelerInfo) throws Exception {
		List<String> list = new ArrayList<String>();
		switch (RoomTravelerInfo) {
		case "Room1Traveller1":
			String firstNameR1T1 = ClearAndSetValues(PassengerInformationLocators.getfnameR1T1(), "yury");
			String secondNameR1T1 = ClearAndSetValues(PassengerInformationLocators.getlnameR1T1(), "darwin");
			String fullNameR1T1 = firstNameR1T1 + " " + secondNameR1T1;
			list.add(fullNameR1T1);
			list.add(SelectOptionByText(PassengerInformationLocators.getgenderR1T1(), "Male"));
			list.add(ClearAndSetValues(PassengerInformationLocators.getdobR1T1(), "01/01/2000"));
			SelectOptionByValue(PassengerInformationLocators.getpassportR1T1(), "237|US");
			break;
		case "Room1Traveller2":
			String firstNameR1T2 = ClearAndSetValues(PassengerInformationLocators.getfnameR1T2(), "Larry");
			String secondNameR1T2 = ClearAndSetValues(PassengerInformationLocators.getlnameR1T2(), "darwin");
			String fullNameR1T2 = firstNameR1T2 + " " + secondNameR1T2;
			list.add(fullNameR1T2);
			list.add(SelectOptionByText(PassengerInformationLocators.getgenderR1T2(), "Male"));
			list.add(ClearAndSetValues(PassengerInformationLocators.getdobR1T2(), "01/01/2000"));
			SelectOptionByValue(PassengerInformationLocators.getpassportR1T2(), "237|US");
			break;
		case "Room2Traveller1":
			String firstNameR2T1 = ClearAndSetValues(PassengerInformationLocators.getfnameR2T1(), "Hanna");
			String secondNameR2T1 = ClearAndSetValues(PassengerInformationLocators.getlnameR2T1(), "darwin");
			String fullNameR2T1 = firstNameR2T1 + " " + secondNameR2T1;
			list.add(fullNameR2T1);
			list.add(SelectOptionByText(PassengerInformationLocators.getgenderR2T1(), "Male"));
			list.add(ClearAndSetValues(PassengerInformationLocators.getdobR2T1(), "01/01/2000"));
			SelectOptionByValue(PassengerInformationLocators.getpassportR2T1(), "237|US");
			break;
		case "Room2Traveller2":
			String firstNameR2T2 = ClearAndSetValues(PassengerInformationLocators.getfnameR2T2(), "Erwin");
			String secondNameR2T2 = ClearAndSetValues(PassengerInformationLocators.getlnameR2T2(), "George");
			String fullNameR2T2 = firstNameR2T2 + " " + secondNameR2T2;
			list.add(fullNameR2T2);
			list.add(SelectOptionByText(PassengerInformationLocators.getgenderR2T2(), "Male"));
			list.add(ClearAndSetValues(PassengerInformationLocators.getdobR2T2(), "01/01/2000"));
			SelectOptionByValue(PassengerInformationLocators.getpassportR2T2(), "237|US");
			break;

		case "Room1Child1":
			String firstNameR1C1 = ClearAndSetValues(PassengerInformationLocators.getfnameR1C1(), "Erwin");
			String secondNameR1C1 = ClearAndSetValues(PassengerInformationLocators.getlnameR1C1(), "George");
			String fullNameR1C1 = firstNameR1C1 + " " + secondNameR1C1;
			list.add(fullNameR1C1);
			list.add(SelectOptionByText(PassengerInformationLocators.getgenderR1C1(), "Male"));
			list.add(ClearAndSetValues(PassengerInformationLocators.getdobR1C1(), "01/01/2000"));
			SelectOptionByValue(PassengerInformationLocators.getpassportR1C1(), "237|US");
			break;

		case "Room2Child1":
			String firstNameR2C1 = ClearAndSetValues(PassengerInformationLocators.getfnameR2C1(), "Erwin");
			String secondNameR2C1 = ClearAndSetValues(PassengerInformationLocators.getlnameR2C1(), "George");
			String fullNameR2C1 = firstNameR2C1 + " " + secondNameR2C1;
			list.add(fullNameR2C1);
			list.add(SelectOptionByText(PassengerInformationLocators.getgenderR2C1(), "Male"));
			list.add(ClearAndSetValues(PassengerInformationLocators.getdobR2C1(), "01/01/2000"));
			SelectOptionByValue(PassengerInformationLocators.getpassportR2C1(), "237|US");
			break;

		}
		return list;
	}

}
