package com.tripmasters.framework.testScript;

import java.lang.reflect.Method;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.tripmasters.framework.actions.BookingPageAction;
import com.tripmasters.framework.actions.HomePageAction;
import com.tripmasters.framework.base.TestBase;
import com.tripmasters.framework.pages.HomePageLocators;
import com.tripmasters.framework.utils.CommonLib;
import com.tripmasters.framework.utils.ExtentTestManager;
import com.tripmasters.framework.utils.Logs;

import junit.framework.Assert;

public class HomePageTestScript extends TestBase {

	//private static Logs log;


	 @Test(groups = {"regression"},priority=15)
	public void verifyMoreHighlightAndAttractionLinks_TC_11(Method method) throws Exception {
		ExtentTest test = ExtentTestManager.startTest(method.getName(), "verifyMoreHighlightAndAttractionLinks_TC_11");
		String homePageTitle = CommonLib.getPageTitle();
		CommonLib.ClickUsingJavaScript(HomePageLocators.getmoreHighLightsBtn());
		test.log(LogStatus.INFO, "User clicked on More HighLights & Attraction Links");
		boolean amazonLinkDisplayed = CommonLib.isElementDisplayed(HomePageLocators.getTheLink("The Amazon"));
		boolean middleEastDisplayed = CommonLib.isElementDisplayed(HomePageLocators.getTheLink("Best Of Middle East"));
		boolean londonDisplayed = CommonLib
				.isElementDisplayed(HomePageLocators.getTheLink("London - Paris and Beyond"));
		boolean europeDisplayed = CommonLib.isElementDisplayed(HomePageLocators.getTheLink("Best of Northern Europe"));

		Assert.assertEquals(HomePageLocators.getHomePageTitle(), homePageTitle);
		test.log(LogStatus.INFO, "Home Page Title Verified.");
		Logs.info("Home Page Title Verified.");
		Assert.assertTrue(amazonLinkDisplayed);
		test.log(LogStatus.INFO, "The Amazon Link is displayed.");
		Logs.info("The Amazon Link is displayed.");

		Assert.assertTrue(middleEastDisplayed);
		test.log(LogStatus.INFO, "Best Of Middle East Link is displayed.");
		Logs.info("Best Of Middle East Link is displayed.");

		Assert.assertTrue(londonDisplayed);
		test.log(LogStatus.INFO, "London - Paris and Beyond Link is displayed.");
		Logs.info("London - Paris and Beyond Link is displayed.");

		Assert.assertTrue(europeDisplayed);
		test.log(LogStatus.INFO, "London - Paris and Beyond Link is displayed.");
		test.log(LogStatus.INFO, "HightLights and Attraction Links Verified");
		Logs.info("verifyMoreHighlightAndAttractionLinks is Passed.");

	}


	 @Test(groups = {"regression"},priority=16)
	public void verifyOtherVacationPackages_TC_12(Method method) {
		ExtentTest test = ExtentTestManager.startTest(method.getName(), "verifyOtherVacationPackages_TC_12");
		CommonLib.ClickUsingJavaScript(HomePageLocators.getExploreEuropeLnk());
		test.log(LogStatus.INFO, "User clicked on Explore Europe Link");
		Logs.info("User clicked on Explore Europe Link");
		CommonLib.ClickUsingJavaScript(HomePageLocators.getRomeFlorenceVeniceByTrainLnk());
		test.log(LogStatus.INFO, "User clicked on particular vacation package");
		Logs.info("User clicked on particular vacation package");
		boolean romeFlorenceVeniceByTrainHeader = CommonLib
				.isElementDisplayed(HomePageLocators.getRomeFlorenceVeniceByTrainHeader());
		test.log(LogStatus.INFO, "Verified User is redirected  to the particular vacation packages");
		Assert.assertTrue(romeFlorenceVeniceByTrainHeader);
		test.log(LogStatus.INFO, "verifyOtherVacationPackages is displayed & testcase passed successfully.");
		Logs.info("verifyOtherVacationPackages is displayed & testcase passed successfully.");
	}

	// @Test(groups = {"smoke"},priority=17)

	public void VerifyPopularVacationPackages_TC_13(Method method) {
		ExtentTest test = ExtentTestManager.startTest(method.getName(), "VerifyPopularVacationPackages_TC_13");
		CommonLib.ClickUsingJavaScript(HomePageLocators.getExploreEuropeLnk());
		test.log(LogStatus.INFO, "Clicked on Popular Vacation Packages");

		Logs.info("Clicked on Popular Vacation Packages");
		String europePageTitle = CommonLib.getPageTitle();
		Assert.assertEquals(HomePageLocators.getEuropePageTitle(), europePageTitle);
		test.log(LogStatus.INFO, "User is able to see all existing popular vacation packages");

		test.log(LogStatus.INFO, "VerifyPopularVacationPackages displayed");
		Logs.info("VerifyPopularVacationPackages displayed");
	}


	// @Test(groups = {"smoke"},priority=18)

	public void verifyCity_TC_10(Method method) throws Exception {
		ExtentTest test = ExtentTestManager.startTest(method.getName(), "verifyCity_TC_10");
		String verifyhomepage = CommonLib.getPageTitle();
		Assert.assertEquals(HomePageLocators.getHomePageTitle(), verifyhomepage);
		test.log(LogStatus.INFO, "Verified User is on homepage");
		HomePageAction.clickSearch();
		test.log(LogStatus.INFO, "User clicked on Search Box");
		HomePageAction.fillSearch("Berlin");
		test.log(LogStatus.INFO, "User searched for particular city");
		boolean actual = HomePageAction.validateURL();
		Assert.assertTrue(actual);
		test.log(LogStatus.INFO, "User is able to get the particular city");
		Logs.info("VerifyPopularVacationPackages displayed");
	}


	// @Test(groups = {"smoke"},priority=19)
	public void verifyStartAgainLink_TC_15(Method method) throws Exception {
		ExtentTest test = ExtentTestManager.startTest(method.getName(), "verifyStartAgainLink_TC_15");
		String verifyhomepage = CommonLib.getPageTitle();
		BookingPageAction.FillBasicBookingDetails("New York, Newark, NJ", "Delhi (India)", "4", "1|2");
		HomePageAction.getStartAgain();
		Assert.assertEquals(HomePageLocators.getHomePageTitle(), verifyhomepage);
		Logs.info("verifyStartAgainLink is displayed");
	}


	// @Test(groups = {"smoke"},priority=20)
	public void verifyFooterText_TC_16(Method method) {
		ExtentTest test = ExtentTestManager.startTest(method.getName(), "verifyFooterText_TC_16");
		boolean validatefooter = HomePageAction.validateFooterText();
		Assert.assertTrue(validatefooter);
		Logs.info("verifyFooterText is displayed");
	}

}
