package com.tripmasters.framework.testScript;

import org.testng.annotations.Test;

import com.tripmasters.framework.base.TestBase;

public class BookingPageTest extends TestBase {
	@Test
	public void getTitle() {
		String title = driver.getTitle();
		System.out.println("title is: " + title);
	}
}
