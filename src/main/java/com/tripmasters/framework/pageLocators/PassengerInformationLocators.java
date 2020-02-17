package com.tripmasters.framework.pageLocators;

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
     
     private static By fnameR1C1=By.xpath("(//div[div[span[contains(.,'Room 1')]]]//input[contains(@placeholder,'First and Middle Name')])[3]");
     private static By lnameR1C1=By.xpath("(//div[div[span[contains(.,'Room 1')]]]//input[contains(@placeholder,'Last Name')])[3]");
     private static By genderR1C1=By.xpath("(//div[div[div[span[contains(.,'Room 1')]]]]//div[contains(@class,'Gender')]//select)[3]");
     private static By dobR1C1=By.xpath("//input[@id='1_txtCPAX_DOB1']");
     private static By passportR1C1=By.xpath("//select[@id='1_txtCPAX_Nationality1']");
     
     private static By fnameR2C1=By.xpath("(//div[div[span[contains(.,'Room 2')]]]//input[contains(@placeholder,'First and Middle Name')])[4]");
     private static By lnameR2C1=By.xpath("(//div[div[span[contains(.,'Room 2')]]]//input[contains(@placeholder,'Last Name')])[4]");
     private static By genderR2C1=By.xpath("(//div[div[div[span[contains(.,'Room 2')]]]]//div[contains(@class,'Gender')]//select)[4]");
     private static By dobR2C1=By.xpath("//input[@id='2_txtCPAX_DOB2']");
     private static By passportR2C1=By.xpath("//select[@id='2_txtCPAX_Nationality2']");
     

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
	
	public static By getfnameR1C1() {
		return fnameR1C1;
	}
	
	public static By getlnameR1C1() {
		return lnameR1C1;
	}
	
	public static By getgenderR1C1() {
		return genderR1C1;
	}
	
	
	public static By getdobR1C1() {
		return dobR1C1;
	}
	
	public static By getpassportR1C1() {
		return passportR1C1;
	}
	
	public static By getfnameR2C1() {
		return fnameR2C1;
	}
	
	public static By getlnameR2C1() {
		return lnameR2C1;
	}
	
	public static By getgenderR2C1() {
		return genderR2C1;
	}
	
	
	public static By getdobR2C1() {
		return dobR2C1;
	}
	
	public static By getpassportR2C1() {
		return passportR2C1;
	}
	
}