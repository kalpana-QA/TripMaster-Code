package com.tripmasters.framework.pages;

import org.openqa.selenium.By;

public class HomePageLocators {

	private static By moreHighlightsBtn = By.xpath("//button[contains(.,'More Highlights & Attractions')]");
	private static By exploreEuropeLnk = By.xpath("//section[h1[contains(.,'popular vacation packages')]]//h3/a[contains(.,'Explore Europe')]");
	private static String homePageTitle = "Vacation Packages | Custom Vacation Packages | Tripmasters";
	private static By romeFlorenceVeniceByTrainLnk = By.xpath("//div[div[contains(.,'other vacation packages')]]//h2/a[contains(.,'Rome - Florence - Venice by Train')]");
	private static By romeFlorenceVeniceByTrainHeader = By.xpath("//h1[contains(.,'Rome - Florence - Venice by Train')]");
	private static String europePageTitle = "Europe Vacations | European Vacation Packages | Tripmasters";
	
	public static By getmoreHighLightsBtn() {
		return moreHighlightsBtn;
	}

	public static By getTheLink(String linkText){
		return By.xpath("//div[contains(@style,'display: block;')]//a[contains(.,'"+linkText+"')]");
	}
	
	public static String getHomePageTitle(){
		return homePageTitle;
	}
	
	public static By getExploreEuropeLnk(){
		return exploreEuropeLnk;
	}
	
	public static By getRomeFlorenceVeniceByTrainLnk(){
		return romeFlorenceVeniceByTrainLnk;
	}
	public static By getRomeFlorenceVeniceByTrainHeader(){
		return romeFlorenceVeniceByTrainHeader;
	}
	public static String getEuropePageTitle(){
		return europePageTitle;
	}
	
}
