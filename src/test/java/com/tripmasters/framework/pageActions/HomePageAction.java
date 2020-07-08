package com.tripmasters.framework.pageActions;

import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.tripmasters.framework.base.PageBase;
import com.tripmasters.framework.base.TestBase;
import com.tripmasters.framework.pageLocators.HomePageLocators;
import com.tripmasters.framework.reports.ExtentTestManager;

import junit.framework.Assert;

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

	/**
	 * click On Explore Europe Link On Mobile
	 * 
	 * @throws Exception
	 * @author Mrinal
	 */
	public void clickOnExploreEuropeLink() throws Exception {
		if (TestBase.flag_Mob) {
			scrollDown();
			clickUsingJavaScript(HomePageLocators.getExploreEuropeLnk());
		}


		else {
			
			
			
			
		}
	}
	
	public void clickOnExploreAsiaLink() throws Exception {
		if (TestBase.flag_Mob) {
			scrollDown();
			clickUsingJavaScript(HomePageLocators.getexploreAsiaLnk());
		}
	}
	
	//Method to verify Highlight and Attraction
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
	
	//verify first highlight and attraction
	public String verifyfirsthighlightandAttraction() throws Exception {
		PageBase.waitForElement(10);
	String firsthighlightandAttraction = driver.findElement(HomePageLocators.getFirstHighLightandAttraction()).getText();
	System.out.println("First highlight and Attraction is "+ firsthighlightandAttraction);
	boolean flag = false;
	if(driver.getPageSource().contains(firsthighlightandAttraction)) {
		 flag = true;
		Assert.assertTrue(flag);
		
	}
	return firsthighlightandAttraction;
	}
	
	
	public void clickOntitle() {
		clickUsingJavaScript(HomePageLocators.getTitle());
	}
	
	//method Satyam
	public void topdeals() throws Exception {
		scrollDownForMob(1);
		clickUsingJavaScript(HomePageLocators.getTopdeals());
		
	}
	
	//satyam
public  void validateTopDealsPage() {
		
		boolean flag = false;
		System.out.println("Title is "+ driver.getTitle());
		if (driver.getTitle().contains(" Top Deals "))
			{
			flag = true;	
		
		Assert.assertTrue(flag);
		}
	}

//Method created to validate list of the week @author Satyam
 
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

public void moreHighlightsandattractionList(){	
		
List<WebElement> morehighlights = driver.findElements(By.xpath("//div[@class='dvMbHighContent']/div/div/p"));

System.out.println(morehighlights.size());

for (WebElement webElement : morehighlights) {
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
	public boolean moreHighlightandAttractions() throws Exception {
		PageBase.scrollDown();
		
		clickUsingJavaScript(HomePageLocators.getmoreHighLightsBtn());
	boolean moreAttractions = isElementDisplayed(HomePageLocators.getmoreHighlightsattractions());
		Assert.assertTrue(moreAttractions);
		return moreAttractions;
	
		
	}
	
	public void clickOnMoreHighLight() throws Exception {
		
		PageBase.scrollDown();
		clickUsingJavaScript(HomePageLocators.getmoreHighLightsBtn());
	}
	
	public void clickonFirstHighlight() {
		clickUsingJavaScript(HomePageLocators.getFirstHighLightsBtn());
	}

	public void clickOnBuildYourOwnVacation() throws Exception {
		PageBase.scrollDown();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='dvGoUrl']/a")));
		element.click();


		
//		PageBase.scrollDown();
//		Thread.sleep(5000);
//		PageBase.waitForElement(5);
//		clickUsingJavaScript(HomePageLocators.clickOnBuildYourOwnVacation());
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.get("http://asia/Design_Your_Own_Trip.aspx");
//		
//		
//				//driver.driver.findElement(HomePageLocators.clickOnBuildYourOwnVacation()).click();
		
	}
	
	public void clickonCreateVacation() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//p[@class='pMtab'])[1]")));
		element.click();

		
		
	}
	
	

	public String clickOnCustomizeit() {
		WebElement we = driver.findElement(HomePageLocators.getfirstTopdealname()); 
		String firstTopdeal = we.getText();
		System.out.println("first top deal is " + firstTopdeal);
		clickUsingJavaScript(HomePageLocators.clickOnCustomizeit());
		return firstTopdeal;
	}

}
