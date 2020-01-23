package com.tripmasters.framework.actions;


import org.openqa.selenium.By;

import com.tripmasters.framework.base.TestBase;
import com.tripmasters.framework.pages.BookingLocators;
import com.tripmasters.framework.utils.CommonLib;

public class BookingPageAction extends TestBase{
	
	public static boolean FillBasicBookingDetails() throws Exception{
		
		CommonLib.ClearAndSetValues(BookingLocators.getLeavingTxtbox(), "New York  La Guardia, NY");
		CommonLib.ClearAndSetValues(BookingLocators.getgoingToTextbox(), "Berlin (Germany)");
		Thread.sleep(3000);
		CommonLib.clickUsingJavaScript(BookingLocators.getnoMoreCitiesBtn());
		Thread.sleep(3000);
		CommonLib.clickUsingJavaScript(BookingLocators.getcontinueBtn());
		Thread.sleep(3000);
		CommonLib.clickUsingJavaScript(BookingLocators.getpaymentContinueBtn());
		CommonLib.clickUsingJavaScript(BookingLocators.getEditContinueBtn());
		
		return true;
	}

}
