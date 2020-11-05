package com.tripmasters.framework.pageLocators;

import org.openqa.selenium.By;

public class HomePageLocators {

	private static By moreHighlightsBtn = By.xpath("//button[contains(.,'More Highlights & Attractions')] | //*[contains(text(),'more highlights & attractions')] | //div[contains(text(),'more highlights & attractions ')]");
	private static By exploreEuropeLnk = By.xpath("//section[h1[contains(.,'popular vacation packages')]]//h3/a[contains(.,'Explore Europe')] | //div[text()='Explore Europe']");
	private static By exploreAsiaLnk = By.xpath("//div[text()='Explore Asia, Pacific & Middle East']");
	private static By romeFlorenceVeniceByTrainLnk = By.xpath("(//div[contains(text(),'other vacation packages')]/../div/h2/a)[2]");
	private static By packageUnderOtherVacationPackageOption = By.xpath("//div[contains(text(),'other vacation packages')]/..//div[@class='swiper-slide swiper-slide-active']//a");
	private static By romeFlorenceVeniceByTrainHeader = By.xpath("//h1[contains(.,'Rome - Florence - Venice by Train')]");

	private static By searchBox = By.xpath("//form[@id='frmSearch']//input[@id='q'] | //input[@id='inpSearchAWS']");
	private static By goButton = By.xpath("//input[@name='Go'] | //img[contains(@onclick,'searchGO')]");
	private static By startagain = By.xpath("(//div[@class='dvtranspMainContainer']//span[@class='goToStartAgain']//u)[2] | //div[@class = 'dvMNext ']//span[text()='Start again']");
	private static By footer = By.xpath("//div[@class='dvCopy'] | //div[@class='dvfootWording']");
	private static By exploreLatinAmericaLnk = By.xpath("//section[h1[contains(.,'popular vacation packages')]]//h3/a[contains(.,'Explore Latin America')] | //div[text()='Explore Latin America']");
	
	// ============= Locators for mobile =========================================================================================

	private static By SpotlightOnDrpDwn = By.cssSelector("div[id='dvSpot']");
	private static By firstOptionUnderSpotlightDrpDwn = By.xpath("(//div[@id='ContdvSpot'][@style='display: block;']//a)[1]");
	private static By selectPremiumEconomy = By.xpath("//span[text()='Premium Economy']");
	private static By moreHighlightsattractions = By.xpath("//div[@class='dvMbHightTblHide']"); 
	private static By highlightandAttractiontitle = By.xpath("//div[@class='dvMbHightAttrTitle']");
	private static By FirstHighLightandAttraction = By.xpath("(//div[@class='dvMbEachHigh'])[1]");
	private static By title = By.xpath("//div[@class='dvMheadLogo']/img");
	private static By topdeals = By.xpath("//div[@id='dvTopDeals']");
	private static By suggestedVacationPackageOption = By.xpath("(//div[@class='dvEachSuggImg'])[1]");
	private static By firstHighLightsBtn = By.xpath("(//div[@class='dvMbEachHigh']/img)[1] | //div[@class='dvMbEachHigh'] | (//div[@class='dvMbEachHigh'])[1]");
	private static By clickOnBuildYourOwnVacation = By.xpath("//div[@class='dvGoUrl']/a | (//a[@href='/asia/Design_Your_Own_Trip.aspx'])[2] | //a[contains(text(),' Customize your Itinerary')] | //div[@class='dvGoUrl']");
	private static By clickOnCustomizeit = By.xpath("(//div[@class='dvMCustomize'])[1]");
	private static By packagename = By.xpath("(//p[@class='pMpkInf1']/b)[1]");
	private static By firstTopdealname = By.xpath("(//p[@class='pMpkTitle'])[1]");
	
	public static By getmoreHighLightsBtn() {
		return moreHighlightsBtn;
	}

	public static By getTheLink(String linkText) {
		return By.xpath("//div[contains(@style,'display: block;')]//a[contains(.,'" + linkText + "')]");
	}

	
	public static By getExploreEuropeLnk() {
		return exploreEuropeLnk;
	}

	public static By getRomeFlorenceVeniceByTrainLnk() {
		return romeFlorenceVeniceByTrainLnk;
	}

	public static By getRomeFlorenceVeniceByTrainHeader() {
		return romeFlorenceVeniceByTrainHeader;
	}

	public static By getSearchBox() {
		return searchBox;
	}

	public static By getGoButton() {
		return goButton;
	}

	public static By getStartAgain() {
		return startagain;
	}

	public static By getFooter() {
		return footer;
	}

	public static By getExploreLatinAmericaLnk() {
		return exploreLatinAmericaLnk;
	}

	public static By getpackageDisplayedUnderOtherVacationPackageOption() {
		return packageUnderOtherVacationPackageOption;
	}

	public static By getSpotlightOnDrpDwn() {
		return SpotlightOnDrpDwn;
	}

	public static By getfirstOptionUnderSpotlightDrpDwn() {
		return firstOptionUnderSpotlightDrpDwn;
	}

	public static By getSelectPremiumEconomy() {

		return selectPremiumEconomy;
		}
	public static By getmoreHighlightsattractions() {
		return moreHighlightsattractions;
	}
	
	public static By getexploreAsiaLnk() {
		return exploreAsiaLnk;
	}
	
	public static By gethighlightandAttractiontitle() {
		return highlightandAttractiontitle;
	}
	
	public static By getFirstHighLightandAttraction() {
		return FirstHighLightandAttraction;
	}

	public static By getTitle() {
		
		return title;
	}

	public static By getTopdeals() {
	
		return topdeals;
	}
	
	//vaishali
public static By getPackageDisplayedUnderSuggestedVacationPackageOption() {
		
		return suggestedVacationPackageOption;
	}

public static By getFirstHighLightsBtn() {
	// TODO Auto-generated method stub
	return firstHighLightsBtn;
}

public static By clickOnBuildYourOwnVacation() {
	// TODO Auto-generated method stub
	return clickOnBuildYourOwnVacation;
}

public static By clickOnCustomizeit() {
	// TODO Auto-generated method stub
	return clickOnCustomizeit;
}

public static By getpackagename() {
	// TODO Auto-generated method stub
	return packagename;
}

public static By getfirstTopdealname() {
	// TODO Auto-generated method stub
	return firstTopdealname;
}
	
}
