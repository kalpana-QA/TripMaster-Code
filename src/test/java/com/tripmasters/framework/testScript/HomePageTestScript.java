package com.tripmasters.framework.testScript;

import java.lang.reflect.Method;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.tripmasters.framework.base.PageBase;
import com.tripmasters.framework.base.TestBase;

import com.tripmasters.framework.pageLocators.ActionPageData;
import com.tripmasters.framework.pageLocators.HomePageLocators;
import com.tripmasters.framework.reports.ExtentTestManager;
import com.tripmasters.framework.reports.Logs;

import junit.framework.Assert;

public class HomePageTestScript extends TestBase {

	 //@Test(groups = { "regression" }, priority = 15)
	public void verifyMoreHighlightAndAttractionLinks_TC_11(Method method) throws Exception {
		ExtentTest test = ExtentTestManager.startTest(method.getName(), "verifyMoreHighlightAndAttractionLinks_TC_11");
		String homePageTitle = homePage.getPageTitle();
		PageBase.clickUsingJavaScript(HomePageLocators.getmoreHighLightsBtn());
		test.log(LogStatus.INFO, "User clicked on More HighLights & Attraction Links");
		boolean amazonLinkDisplayed = homePage.isElementDisplayed(HomePageLocators.getTheLink("The Amazon"));
		boolean middleEastDisplayed = homePage.isElementDisplayed(HomePageLocators.getTheLink("Best Of Middle East"));
		boolean londonDisplayed = homePage.isElementDisplayed(HomePageLocators.getTheLink("London - Paris and Beyond"));
		boolean europeDisplayed = homePage.isElementDisplayed(HomePageLocators.getTheLink("Best of Northern Europe"));

		Assert.assertEquals(ActionPageData.getHomePageTitle(), homePageTitle);
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
	
	@Test(groups = { "smoke" },priority = 11)
	public void TC_0011_verifyMoreHighlightAndAttractionLinks(Method method) throws Exception {
		ExtentTest test = ExtentTestManager.startTest(method.getName(), "verifyMoreHighlightAndAttractionLinks_Mob_TC_11");
		test.log(LogStatus.INFO, "Entered the URL: http://www.tripmasters.com/");
		
		
		homePage.clickOnExploreAsiaLink();
		test.log(LogStatus.INFO, "Scrolled Down.");
		test.log(LogStatus.INFO, "Tap on Explore Asia link");
		homePage.moreHighlightandAttractions();
		test.log(LogStatus.INFO, "Scrolled Down.");
		test.log(LogStatus.INFO, "HightLights and Attraction Links Verified");
	}

	@Test(groups = { "smoke" }, priority = 12)
	public void TC_0012_verifyOtherVacationPackages(Method method) throws Exception {
		String PackageTitle;
		ExtentTest test = ExtentTestManager.startTest(method.getName(), "TC_0012_verifyOtherVacationPackages");
		test.log(LogStatus.INFO, "Entered the URL: http://www.tripmasters.com/");
		
		
		PageBase.scrollDownForMob(1);
		test.log(LogStatus.INFO, "Scrolled Down.");
		PageBase.clickUsingJavaScript(HomePageLocators.getExploreEuropeLnk());
		test.log(LogStatus.INFO, "User tap on Explore Europe Link");
		//Logs.info("User clicked on Explore Europe Link");
		PageBase.scrollDownForMob(3);
		PackageTitle = homePage.clickOnPackageDisplayedUnderOtherVacationPackages();
		test.log(LogStatus.INFO, "User tap on "+ PackageTitle +" vacation package");
		//Logs.info("User clicked on particular vacation package");
		boolean romeFlorenceVeniceByTrainHeader = homePage.getPageTitle().contains(PackageTitle);
		test.log(LogStatus.INFO, "Verified User is redirected  to the " + PackageTitle + " vacation packages");
		Assert.assertTrue(romeFlorenceVeniceByTrainHeader);
		test.log(LogStatus.INFO, "verifyOtherVacationPackages is displayed & testcase passed successfully.");
		//Logs.info("verifyOtherVacationPackages is displayed & testcase passed successfully.");
	}

	 @Test(groups = {"smoke"},priority=13)
	public void TC_0013_verifyPopularVacationPackages(Method method) {
		ExtentTest test = ExtentTestManager.startTest(method.getName(), "VerifyPopularVacationPackages_TC_13");
		test.log(LogStatus.INFO, "Entered the URL: http://www.tripmasters.com/");
		
		PageBase.clickUsingJavaScript(HomePageLocators.getExploreEuropeLnk());
		test.log(LogStatus.INFO, "Scrolled Down.");
		test.log(LogStatus.INFO, "Tap on Explore europe link");
		test.log(LogStatus.INFO, "Scrolled Down.");
		test.log(LogStatus.INFO, "Tap on Popular Vacation Packages");
		//Logs.info("Clicked on Popular Vacation Packages");
		String europePageTitle = homePage.getPageTitle();
		System.out.println(europePageTitle);
		 //Assert.assertEquals(HomePageLocators.getEuropePageTitle().trim(),
		 Assert.assertEquals(ActionPageData.getEuropePageTitle().trim(),europePageTitle);
		// europePageTitle.trim());
		 test.log(LogStatus.INFO, "User is able to see all existing popular vacation packages on "+ europePageTitle);
			
		// test.log(LogStatus.INFO, "User is able to see all existing popular vacation packages");
		test.log(LogStatus.INFO, "VerifyPopularVacationPackages displayed");
		//Logs.info("VerifyPopularVacationPackages displayed");
	}

	@Test(groups = {"smoke"},priority=10)
	public void TC_0010_verifyCity(Method method) throws Exception {
		ExtentTest test=ExtentTestManager.startTest(method.getName(), "Verify Search City Button on homepage");
		test.log(LogStatus.INFO, "Entered the URL: http://www.tripmasters.com/");
		
		PageBase.waitForElement(5);
		String verifyhomepage = homePage.getPageTitle();
		Assert.assertEquals(ActionPageData.getHomePageTitle(), verifyhomepage);
		test.log(LogStatus.INFO, "Verified User is on homepage titled "+ verifyhomepage);
		//Logs.info("Verified User is on homepage");
		homePage.clickSearch();
		test.log(LogStatus.INFO, "Tap on Search textBox available on HomePage");
		//Logs.info("Click on Search textBox available on HomePage");
		homePage.fillSearch("Berlin");
		test.log(LogStatus.INFO, "Search for a particular city e.g. Berlin & Tap on Search Button");
		//Logs.info("Search for a particular city & Click on Go Button");
		homePage.validateURL();
		String searchpage = homePage.getPageTitle();
		System.out.println("title of search page is "+ searchpage);
		
	    test.log(LogStatus.INFO, "User redirected to that particular city.Verified!");
	    //Logs.info("User redirected to that particular city.Verified!");
}

	@Test(groups = {"smoke"},priority=15)
	public void TC_0015_verifyStartAgainLink(Method method) throws Exception {
		ExtentTest test = ExtentTestManager.startTest(method.getName(), "verifyStartAgainLink_TC_15");
		test.log(LogStatus.INFO, "Entered the URL: http://www.tripmasters.com/");
		
		//String verifyhomepage = homePage.getPageTitle();
		bookingPage.clickOnBuildYourVacationDropDown();
		test.log(LogStatus.INFO, "Tap on Build Your Vacation Dropdown");
		//Logs.info("Click on Build Your Vacation Dropdown");
		PageBase.waitForElement(10);
		bookingPage.fillLeavingFromDetails("New York, Newark, NJ");
		test.log(LogStatus.INFO, "User entered \"New York, Newark, NJ\" into leaving from field");
		bookingPage.fillGoingToCityDetails("Delhi (India)");
		test.log(LogStatus.INFO, "User entered \"Delhi (India)\" into Going to from field");
		bookingPage.selectStayingTime("4");
		test.log(LogStatus.INFO, "User entered \"4\" nights staying time");
		bookingPage.selectNoMoreCitiesBtn();
		test.log(LogStatus.INFO, "Tap on Next");
		bookingPage.selectGuestDetails("1|2");
		test.log(LogStatus.INFO, "User select \"1 Room With 2 Adults\" from Guest list");
		test.log(LogStatus.INFO, "User fills all the basic booking details");
		//Logs.info("User fills all the basic booking details");
		homePage.getStartAgain();
		test.log(LogStatus.INFO, "Tap on Start Again");
		String verifyhomepage = homePage.getPageTitle();
		Assert.assertEquals(ActionPageData.getHomePageTitle(), verifyhomepage);
		test.log(LogStatus.INFO, "Verify User is redirected to the  home page after tapping on StartAgain Link.");
		bookingPage.selectNoMoreCitiesBtn();
		test.log(LogStatus.INFO, "Tap on Next");
		bookingPage.clickonContinueButton();
		//test.log(LogStatus.INFO, "Scrolled Down.");
		test.log(LogStatus.INFO, "Tap on continue button");
		String value = bookingPage.getSessionid();
		test.log(LogStatus.INFO, "Session id is "+ value);
		
		//Logs.info("verifyStartAgainLink is displayed");
	}

	@Test(groups = {"smoke"},priority=16)
	public void TC_0016_verifyFooterText(Method method) {
		ExtentTest test = ExtentTestManager.startTest(method.getName(), "verifyFooterText_TC_16");
       
		test.log(LogStatus.INFO, "User enter the URL https://www.tripmasters.com/");
		boolean validatefooter = homePage.validateFooterText();
		Assert.assertTrue(validatefooter);
                                     test.log(LogStatus.INFO, "Scroll down to the footer of the page");
		test.log(LogStatus.INFO, "verifyFooterText is displayed on the super homepage");
		//Logs.info("verifyFooterText is displayed");
	}

}
