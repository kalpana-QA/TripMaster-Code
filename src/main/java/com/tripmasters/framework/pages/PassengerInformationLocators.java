package com.tripmasters.framework.pages;

import org.openqa.selenium.By;

public class PassengerInformationLocators {
	 private static By fnameR1T1=By.xpath("(//div[div[span[contains(.,'Room 1')]]]//input[contains(@placeholder,'First and Middle Name')])[1]");
	 private static By fnameR1T2=By.xpath("(//div[div[span[contains(.,'Room 1')]]]//input[contains(@placeholder,'First and Middle Name')])[2]");
	 private static By fnameR2T1=By.xpath("(//div[div[span[contains(.,'Room 2')]]]//input[contains(@placeholder,'First and Middle Name')])[1]");
	 private static By fnameR2T2=By.xpath("(//div[div[span[contains(.,'Room 2')]]]//input[contains(@placeholder,'First and Middle Name')])[2]");
	
	 private static By lnameR1T1=By.xpath("(//div[div[span[contains(.,'Room 1')]]]//input[contains(@placeholder,'Last Name')])[1]");
	 private static By lnameR1T2=By.xpath("(//div[div[span[contains(.,'Room 1')]]]//input[contains(@placeholder,'Last Name')])[2]");
	 private static By lnameR2T1=By.xpath("(//div[div[span[contains(.,'Room 2')]]]//input[contains(@placeholder,'Last Name')])[1]");
	 private static By lnameR2T2=By.xpath("(//div[div[span[contains(.,'Room 2')]]]//input[contains(@placeholder,'Last Name')])[2]");
     
	 private static By genderR1T1=By.xpath("(//div[div[div[span[contains(.,'Room 1')]]]]//div[contains(@class,'Gender')]//select)[1]");
     private static By genderR1T2=By.xpath("(//div[div[div[span[contains(.,'Room 1')]]]]//div[contains(@class,'Gender')]//select)[2]");
     private static By genderR2T1=By.xpath("(//div[div[div[span[contains(.,'Room 2')]]]]//div[contains(@class,'Gender')]//select)[1]");
     private static By genderR2T2=By.xpath("(//div[div[div[span[contains(.,'Room 2')]]]]//div[contains(@class,'Gender')]//select)[2]");

     private static By dobR1T1=By.xpath("(//div[div[div[span[contains(.,'Room 1')]]]]//input[contains(@id,'txtPAX_DOB')])[1]");
     private static By dobR1T2=By.xpath("(//div[div[div[span[contains(.,'Room 1')]]]]//input[contains(@id,'txtPAX_DOB')])[2]");
     private static By dobR2T1=By.xpath("(//div[div[div[span[contains(.,'Room 2')]]]]//input[contains(@id,'txtPAX_DOB')])[1]");
     private static By dobR2T2=By.xpath("(//div[div[div[span[contains(.,'Room 2')]]]]//input[contains(@id,'txtPAX_DOB')])[2]");

     private static By passportR1T1=By.xpath("//select[@id='1_txtPAX_Nationality1']");
     private static By passportR1T2=By.xpath("//select[@id='1_txtPAX_Nationality2']");
     private static By passportR2T1=By.xpath("//select[@id='2_txtPAX_Nationality1']");
     private static By passportR2T2=By.xpath("//select[@id='2_txtPAX_Nationality2']");

	public static By getfnameR1T1() {
		return fnameR1T1;
	}

	public static By getfnameR1T2() {
		return fnameR1T2;
	}

	public static By getfnameR2T1() {
		return fnameR2T1;
	}

	public static By getfnameR2T2() {
		return fnameR2T2;
	}

	public static By getlnameR1T1() {
		return lnameR1T1;
	}

	public static By getlnameR1T2() {
		return lnameR1T2;
	}

	public static By getlnameR2T1() {
		return lnameR2T1;
	}

	public static By getlnameR2T2() {
		return lnameR2T2;
	}
	
	public static By getgenderR1T1() {
		return genderR1T1;
	}
	
	public static By getgenderR1T2() {
		return genderR1T2;
	}
	
	public static By getgenderR2T1() {
		return genderR2T1;
	}
	
	public static By getgenderR2T2() {
		return genderR2T2;
	}
	
	public static By getdobR1T1() {
		return dobR1T1;
	}
	
	public static By getdobR1T2() {
		return dobR1T2;
	}
	
	public static By getdobR2T1() {
		return dobR2T1;
	}
	
	public static By getdobR2T2() {
		return dobR2T2;
	}
	
	public static By getpassportR1T1() {
		return passportR1T1;
	}
	
	public static By getpassportR1T2() {
		return passportR1T2;
	}
	
	public static By getpassportR2T1() {
		return passportR2T1;
	}
	
	public static By getpassportR2T2() {
		return passportR2T2;
	}
}