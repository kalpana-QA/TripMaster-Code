package com.tripmasters.framework.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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
		if (driver.getCurrentUrl().contains("Berlin")) {
			result = true;
		}
		return result;

	}

	public static void getStartAgain() {
		CommonLib.ClickUsingJavaScript(HomePageLocators.getStartAgain());
	}

	public static boolean validateFooterText() {
		if (driver.findElement(HomePageLocators.getFooter()).isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * click On Explore Europe Link On Mobile
	 * 
	 * @throws Exception
	 * @author Mrinal
	 */
	public static void clickOnExploreEuropeLinkOnMob() throws Exception {
		if (platform.equalsIgnoreCase("Mobile")) {
			CommonLib.scrollDown();
			CommonLib.ClickUsingJavaScript(HomePageLocators.getExploreEuropeLnk());
		}
	}

	/**
	 * click On Package Displayed Under Other Vacation Packages
	 * 
	 * @return
	 * @throws Exception
	 * @author Mrinal
	 */
	public static String clickOnPackageDisplayedUnderOtherVacationPackages() throws Exception {
		WebElement wbEl;
		String Text;
		if (platform.equalsIgnoreCase("Mobile")) {
			wbEl = driver.findElement(HomePageLocators.getpackageDisplayedUnderOtherVacationPackageOption())
					.findElement(By.xpath("./span[contains(@class,'Title')]"));
			Text = CommonLib.getText(wbEl);
			CommonLib.ClickUsingJavaScript(HomePageLocators.getpackageDisplayedUnderOtherVacationPackageOption());
		} else {
			Text = CommonLib.getText(HomePageLocators.getRomeFlorenceVeniceByTrainLnk());
			CommonLib.ClickUsingJavaScript(HomePageLocators.getRomeFlorenceVeniceByTrainLnk());
			}
		return Text;
	}
	
	

}
