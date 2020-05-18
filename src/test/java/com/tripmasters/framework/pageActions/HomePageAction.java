package com.tripmasters.framework.pageActions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.tripmasters.framework.base.PageBase;
import com.tripmasters.framework.base.TestBase;
import com.tripmasters.framework.pageLocators.HomePageLocators;



public class HomePageAction extends PageBase {

	public HomePageAction(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void clickSearch() {
		clickUsingJavaScript(HomePageLocators.getSearchBox());
	}

	public void fillSearch(String city) throws Exception {
		clearAndSetValues(HomePageLocators.getSearchBox(), city);
		clickUsingJavaScript(HomePageLocators.getGoButton());
	}

	public boolean validateURL() {
		boolean result = false;
		if (driver.getCurrentUrl().contains("Berlin")) {
			result = true;
		}
		return result;
	}

	public void getStartAgain() {
		clickUsingJavaScript(HomePageLocators.getStartAgain());
	}

	public boolean validateFooterText() {
		if (driver.findElement(HomePageLocators.getFooter()).isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}
	
	public void verifyHighLightsandAttractions() throws Exception {
		PageBase.waitForElement(10);
		String highlighttitle = driver.findElement(HomePageLocators.gethighlightandAttractiontitle()).getText();
		System.out.println("highlightTitle is "+ highlighttitle);
		boolean flag = false;
		if(driver.getPageSource().contains(highlighttitle)) {
			 flag = true;
			Assert.assertTrue(flag);
		}
	}
	
	public void verifyfirsthighlightandAttraction() throws Exception {
		PageBase.waitForElement(10);
	String firsthighlightandAttraction = driver.findElement(HomePageLocators.getFirstHighLightandAttraction()).getText();
	System.out.println("First highlight and Attraction is "+ firsthighlightandAttraction);
	boolean flag = false;
	if(driver.getPageSource().contains(firsthighlightandAttraction)) {
		 flag = true;
		Assert.assertTrue(flag);
		
	}
	}
	
	public void clickOntitle() {
		clickUsingJavaScript(HomePageLocators.getTitle());
	}
	
	public void topdeals() throws Exception {
		scrollDownForMob(1);
		clickUsingJavaScript(HomePageLocators.getTopdeals());
		
	}
	
public  void validateTopDealsPage() {
		
		boolean flag = false;
		System.out.println("Title is "+ driver.getTitle());
		if (driver.getTitle().contains(" Top Deals "))
			{
			flag = true;	
		
		Assert.assertTrue(flag);
		}
	}


public void clickOnExploreEuropeLink() throws Exception {
	if (TestBase.flag_Mob) {
		scrollDown();
		clickUsingJavaScript(HomePageLocators.getExploreEuropeLnk());
	}


	else {
		
		
		
		
	}
}



public void validatetopDealsList(){	
	
List<WebElement> topDeals = driver.findElements(By.className("pMpkTitle"));

System.out.println(topDeals.size());

for (WebElement webElement : topDeals) {
    String name = webElement.getText();
    System.out.println(name);
    boolean flag = false;
	if(driver.getPageSource().contains(name)) {
		 flag = true;
		Assert.assertTrue(flag);
    
}
}
}
	

	/**
	 * click On Explore Europe Link On Mobile
	 * 
	 * @throws Exception
	 * @author Mrinal
	 */
	public void clickOnExploreAsiaLink() throws Exception {
		if (TestBase.flag_Mob) {
			scrollDown();
			clickUsingJavaScript(HomePageLocators.getexploreAsiaLink());
		}
		else {
			
			
			
			
		}
	}
	
	public boolean moreHighlightandAttractions() throws Exception {
		PageBase.scrollDown();
		clickUsingJavaScript(HomePageLocators.getmoreHighLightsBtn());
	    boolean moreAttractions = isElementDisplayed(HomePageLocators.getmoreHighlightsattractions());
		Assert.assertTrue(moreAttractions);
		return moreAttractions;
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
			wbEl = driver.findElement(HomePageLocators.getpackageDisplayedUnderOtherVacationPackageOption()).findElement(By.xpath("./span[contains(@class,'Title')]"));
			Text = getText(wbEl);
			clickUsingJavaScript(HomePageLocators.getpackageDisplayedUnderOtherVacationPackageOption());
		} else {
			Text = getText(HomePageLocators.getRomeFlorenceVeniceByTrainLnk());
			clickUsingJavaScript(HomePageLocators.getRomeFlorenceVeniceByTrainLnk());
		}
		return Text;
	}


}
