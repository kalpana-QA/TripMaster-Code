package com.tripmasters.framework.pageActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.tripmasters.framework.base.PageBase;
import com.tripmasters.framework.base.TestBase;
import com.tripmasters.framework.pageLocators.HomePageLocators;

public class HomePageAction extends PageBase {

	public HomePageAction(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void clickSearch() {
		ClickUsingJavaScript(HomePageLocators.getSearchBox());
	}

	public void fillSearch(String city) throws Exception {
		ClearAndSetValues(HomePageLocators.getSearchBox(), city);
		ClickUsingJavaScript(HomePageLocators.getGoButton());
	}

	public boolean validateURL() {
		boolean result = false;
		if (driver.getCurrentUrl().contains("Berlin")) {
			result = true;
		}
		return result;

	}

	public void getStartAgain() {
		ClickUsingJavaScript(HomePageLocators.getStartAgain());
	}

	public boolean validateFooterText() {
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
	public void clickOnExploreEuropeLinkOnMob() throws Exception {
		if (TestBase.flag_Mob) {
			scrollDown();
			ClickUsingJavaScript(HomePageLocators.getExploreEuropeLnk());
		}
	}

	/**
	 * click On Package Displayed Under Other Vacation Packages
	 * 
	 * @return
	 * @throws Exception
	 * @author Mrinal
	 */
	public String clickOnPackageDisplayedUnderOtherVacationPackages() throws Exception {
		WebElement wbEl;
		String Text;
		if (TestBase.flag_Mob) {
			wbEl = driver.findElement(HomePageLocators.getpackageDisplayedUnderOtherVacationPackageOption())
					.findElement(By.xpath("./span[contains(@class,'Title')]"));
			Text = getText(wbEl);
			ClickUsingJavaScript(HomePageLocators.getpackageDisplayedUnderOtherVacationPackageOption());
		} else {
			Text = getText(HomePageLocators.getRomeFlorenceVeniceByTrainLnk());
			ClickUsingJavaScript(HomePageLocators.getRomeFlorenceVeniceByTrainLnk());
		}
		return Text;
	}

}
