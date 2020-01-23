package com.tripmasters.framework.testScript;

import org.testng.annotations.Test;

import com.tripmasters.framework.actions.BookingPageAction;
import com.tripmasters.framework.base.TestBase;

public class BookingPageTest extends TestBase {
	
	
	public void getTitle() {
		String title = driver.getTitle();
		System.out.println("title is: " + title);
	}
	
	@Test
	public void bookingInitialise() throws Exception
	{
		boolean status=BookingPageAction.FillBasicBookingDetails();
		System.out.println(status);
	}
}
