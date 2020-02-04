package com.tripmasters.framework.testScript;

import java.lang.reflect.Method;

import org.testng.annotations.Test;

import com.tripmasters.framework.actions.BookingPageAction;
import com.tripmasters.framework.actions.HomePageAction;
import com.tripmasters.framework.base.TestBase2;
import com.tripmasters.framework.pages.HomePageLocators;
import com.tripmasters.framework.utils.CommonLib;
import com.tripmasters.framework.utils.ExtentTestManager;
import com.tripmasters.framework.utils.Logs;

import junit.framework.Assert;

public class HomePageTestScript extends TestBase2 {

	// HomePageLocators homePageLocatos=null;
	static Logs log;


	@Test(priority=0)
	public void verifyMoreHighlightAndAttractionLinks_TC_11(Method method) throws Exception {
		ExtentTestManager.startTest(method.getName(), "verifyMoreHighlightAndAttractionLinks_TC_11");

		String homePageTitle = CommonLib.getPageTitle();

		CommonLib.ClickUsingJavaScript(HomePageLocators.getmoreHighLightsBtn());
		boolean amazonLinkDisplayed = CommonLib.isElementDisplayed(HomePageLocators.getTheLink("The Amazon"));
		boolean middleEastDisplayed = CommonLib.isElementDisplayed(HomePageLocators.getTheLink("Best Of Middle East"));
		boolean londonDisplayed = CommonLib.isElementDisplayed(HomePageLocators.getTheLink("London - Paris and Beyond"));
		boolean europeDisplayed = CommonLib.isElementDisplayed(HomePageLocators.getTheLink("Best of Northern Europe"));

		Assert.assertEquals(HomePageLocators.getHomePageTitle(), homePageTitle);
		//log.info("Home Page Title Verified.");
		Assert.assertTrue(amazonLinkDisplayed);
		//log.info("The Amazon Link is displayed.");

		Assert.assertTrue(middleEastDisplayed);
		//log.info("Best Of Middle East Link is displayed.");

		Assert.assertTrue(londonDisplayed);
		//log.info("London - Paris and Beyond Link is displayed.");

		Assert.assertTrue(europeDisplayed);
		//log.info("Best of Northern Europe Link is displayed.");
		//log.info("verifyMoreHighlightAndAttractionLinks is Passed.");
		
	}
	
	@Test(priority=3)
	public void verifyOtherVacationPackages_TC_12(Method method){
		ExtentTestManager.startTest(method.getName(), "verifyOtherVacationPackages_TC_12");
		CommonLib.ClickUsingJavaScript(HomePageLocators.getExploreEuropeLnk());
		CommonLib.ClickUsingJavaScript(HomePageLocators.getRomeFlorenceVeniceByTrainLnk());
		boolean romeFlorenceVeniceByTrainHeader = CommonLib.isElementDisplayed(HomePageLocators.getRomeFlorenceVeniceByTrainHeader());
		Assert.assertTrue(romeFlorenceVeniceByTrainHeader);
		//log.info("verifyOtherVacationPackages is Passed.");
	}//section[h1[contains(.,'popular vacation packages')]]//a[contains(.,'London')]

	@Test(priority=1)
	public void VerifyPopularVacationPackages_TC_13(Method method){
		ExtentTestManager.startTest(method.getName(), "VerifyPopularVacationPackages_TC_13");
		CommonLib.ClickUsingJavaScript(HomePageLocators.getExploreEuropeLnk());
		String europePageTitle = CommonLib.getPageTitle();
		
		Assert.assertEquals(HomePageLocators.getEuropePageTitle(), europePageTitle);
		//log.info("VerifyPopularVacationPackages_TC_13 is Passed.");
	}
	//@Test
	public void verifyCity_TC_10() throws Exception {
		String verifyhomepage = CommonLib.getPageTitle();   
    	Assert.assertEquals(HomePageLocators.getHomePageTitle(), verifyhomepage);
    	HomePageAction.clickSearch();
    	HomePageAction.fillSearch("Berlin");
    	boolean actual = HomePageAction.validateURL();
    	Assert.assertTrue(actual);
	}
	//@Test
	public void verifyStartAgainLink_TC_15() throws Exception {
		String verifyhomepage = CommonLib.getPageTitle();   
    	
		BookingPageAction.FillBasicBookingDetails("New York, Newark, NJ","Delhi (India)","4","1|2");
		HomePageAction.getStartAgain();
		Assert.assertEquals(HomePageLocators.getHomePageTitle(), verifyhomepage);
		
	}
	@Test
	public void footerText() {
		boolean validatefooter = HomePageAction.validateFooterText();
		Assert.assertTrue(validatefooter);
	}
	
	
}
