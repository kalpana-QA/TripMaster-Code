package com.tripmasters.framework.actions;


import com.tripmasters.framework.base.TestBase2;
import com.tripmasters.framework.pages.HomePageLocators;
import com.tripmasters.framework.utils.CommonLib;

public class HomePageAction extends TestBase2 {
	 public static void clickSearch() {
	    	CommonLib.ClickUsingJavaScript(HomePageLocators.getSearchBox());
	    	}
	 public static void fillSearch(String city) throws Exception {
	    	CommonLib.ClearAndSetValues(HomePageLocators.getSearchBox(), city);
	    	CommonLib.ClickUsingJavaScript(HomePageLocators.getGoButton());
	    }
	 public static boolean validateURL() {
	    	boolean result = false;
	    	if(driver.getCurrentUrl().contains("Berlin"))
	    	{
	    		result = true;
	    	}
	    	return result;
	    	
	    }
	 public static void getStartAgain() {
		 CommonLib.ClickUsingJavaScript(HomePageLocators.getStartAgain());
	 }
	 public static boolean validateFooterText() {
	    	if(driver.findElement(HomePageLocators.getFooter()).isDisplayed()) {
	    		return true;
	    	}
	    	else {
	    		return false;
	    	}
	    }
}
