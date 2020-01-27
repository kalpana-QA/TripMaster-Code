package com.tripmasters.framework.actions;

import org.testng.Assert;

import com.tripmasters.framework.base.TestBase;
import com.tripmasters.framework.pages.BookingLocators;

public class ConfirmationPageAction extends TestBase{

	public static void VerifyFirstTravellerDetails(String expectedTravellerDetail) throws Exception{
	    String actualInfoFirstTraveller=driver.findElement(BookingLocators.getverifyTraveler1Name()).getText();
	    Assert.assertEquals(actualInfoFirstTraveller,expectedTravellerDetail);
	}
	
	public static void VerifySecondTravellerDetails(String expectedTravellerDetail) throws Exception{
	    String actualInfoFirstTraveller=driver.findElement(BookingLocators.getverifyTraveler2Name()).getText();
	    Assert.assertEquals(actualInfoFirstTraveller,expectedTravellerDetail);
	}
	
	public static void VerifyThirdTravellerDetails(String expectedTravellerDetail) throws Exception{
	    String actualInfoFirstTraveller=driver.findElement(BookingLocators.getverifyTraveler3Name()).getText();
	    Assert.assertEquals(actualInfoFirstTraveller,expectedTravellerDetail);
	}
}
