package pom;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Reporter;

public class hotelsResultPage {

	private WebDriver driver;
	String parent;

	@CacheLookup
	@FindBys(@FindBy(xpath = "//*[@id='root']/div[2]/div/section[2]/div/div/div"))
	List<WebElement> hotelList;

	@CacheLookup
	@FindBy(xpath = "// *[@id='root']/div[2]/div/section[2]/div/div/div[1]")
	WebElement firstlHotel;

	@CacheLookup
	@FindBy(xpath = "//h1[@itemprop='name']")
	WebElement firstlHotelName;

	@CacheLookup
	@FindBy(xpath = "(//h4[@itemprop='name'])[1]")
	WebElement firstHotelNameResults;

	@CacheLookup
	@FindBy(xpath = "//p[normalize-space()='Top Rated Affordable Properties']//*[name()='svg']")
	WebElement affordableHotelsChkbox;

	@CacheLookup
	@FindBy(xpath = "//span[contains(text(),'Book @ ₹1')]")
	WebElement bookAt1Chkbox;

	@CacheLookup
	@FindBy(xpath = "//span[normalize-space()='Free Cancellation Available']")
	WebElement freeCancellationCheckbx;

	@CacheLookup
	@FindBy(xpath = "//span[normalize-space()='Free Breakfast Included']")
	WebElement freeBfCheckBx;

	@CacheLookup
	@FindBy(xpath = "//section[@class='SRPstyles__LeftSectionWrapperStyle-sc-19ucfhx-4 jrDPQn']//div[3]//div[4]//div[1]//span[1]")
	WebElement fourNhalfStarRatingChkbox;

	@CacheLookup
	@FindBy(xpath = "//body/div[@id='root']/div/div/section/div/div/div[5]/div[3]/div[1]/span[1]")
	WebElement fourStarRatingChkbox;

	@CacheLookup
	@FindBy(xpath = "//span[@class='Filtersstyles__AverageReviewText-sc-bkjigy-9 hqHLna'][normalize-space()='3.5+']")
	WebElement threeNhalfStarRatingChkbox;

	@CacheLookup
	@FindBy(xpath = "//span[@class='Filtersstyles__AverageReviewText-sc-bkjigy-9 hqHLna'][normalize-space()='3+']")
	WebElement threeStarRatingChkbox;

	@CacheLookup
	@FindBy(xpath = "//span[@class='CheckBoxListstyles__CheckBoxListText-sc-mib0do-9 bxrSge'][contains(text(),'Upto ₹2000')]")
	WebElement upto2kPrice;

	@CacheLookup
	@FindBy(xpath = "//span[contains(text(),'₹2001 - ₹4000')]")
	WebElement upto2kto4kPrice;

	@CacheLookup
	@FindBy(xpath = "//span[contains(text(),'₹4001 - ₹6000')]")
	WebElement upto4kto6kPrice;

	@CacheLookup
	@FindBy(xpath = "//span[contains(text(),'₹6001 - ₹8000')]")
	WebElement upto6kto8kPrice;

	@CacheLookup
	@FindBy(xpath = "//span[contains(text(),'₹8000 +')]]")
	WebElement above8kPrice;

	public hotelsResultPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		parent = driver.getWindowHandle();

	}

	public void switchtoParent() throws InterruptedException {
		driver.switchTo().window(parent);
		Thread.sleep(4000);
	}

	public void switchtowindows() throws InterruptedException {

		Set<String> windows = driver.getWindowHandles();
		//System.out.println(windows.size());
		for (String child : windows) {
			if (!parent.equalsIgnoreCase(child)) {
				driver.switchTo().window(child);
			}
		}
		Thread.sleep(3000);
	}

	public void selectFirstHotelListed() throws InterruptedException {

		Thread.sleep(2000);

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);

		wait.until(ExpectedConditions.visibilityOf(firstlHotel));

		firstlHotel.click();

		switchtowindows();

		wait.until(ExpectedConditions.visibilityOf(firstlHotelName));

		Reporter.log("The First hotel listed in search results is " + firstlHotelName.getText()
				+ " and the same is selected");

	}

	public void verifyHotelAndSelect(String hotelName) throws InterruptedException {

		Thread.sleep(2000);

		String expectedHotelName = hotelName;

		String actualHotelName = firstHotelNameResults.getText();

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);

		wait.until(ExpectedConditions.visibilityOf(firstHotelNameResults));

		assertTrue(expectedHotelName.equals(actualHotelName), "Hotel names are not matching");

		Reporter.log(
				"Hotel name is as expected which is: " + firstHotelNameResults.getText() + " and the same is selected");

		firstlHotel.click();

		switchtowindows();

		wait.until(ExpectedConditions.visibilityOf(firstlHotelName));

		assertTrue(expectedHotelName.equals(firstlHotelName.getText()), "Hotel names are not matching");

		Reporter.log("Hotel name is same after selection which is: " + firstlHotelName.getText());

	}

	// using other filters as Pay at home option is not available also the hotel
	// count is also not available in results page
	public void applyPopularFilter(String popfilterName) throws InterruptedException {

		String popularFilter = "Top Rated Affordable Properties";

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);

		wait.until(ExpectedConditions.visibilityOf(bookAt1Chkbox));

		if (popularFilter.equalsIgnoreCase("Top Rated Affordable Properties")) {

			affordableHotelsChkbox.click();
			Thread.sleep(1000);

			assertTrue(affordableHotelsChkbox.isEnabled(), "Affordable Hotels check box could not be selected");

			Reporter.log("The Popular filter applied is: " + popularFilter);

		}

		else if (popularFilter.equalsIgnoreCase("Book @ ₹1")) {

			bookAt1Chkbox.click();
			Thread.sleep(1000);

			assertTrue(bookAt1Chkbox.isEnabled(), "Book at 1 check box could not be selected");
			Reporter.log("The Popular filter applied is: " + bookAt1Chkbox.getText());

		}

		else if (popularFilter.equalsIgnoreCase("Free Cancellation Available")) {

			freeCancellationCheckbx.click();
			Thread.sleep(1000);

			assertTrue(freeCancellationCheckbx.isEnabled(), "Free cancellation check box could not be selected");
			Reporter.log("The Popular filter applied is: " + freeCancellationCheckbx.getText());

		}

		else if (popularFilter.equalsIgnoreCase("Free Breakfast Included")) {

			freeBfCheckBx.click();
			Thread.sleep(1000);

			assertTrue(freeBfCheckBx.isEnabled(), "Free Breakfast check box could not be selected");
			Reporter.log("The Popular filter applied is: " + freeBfCheckBx.getText());

		}

		else {

			Reporter.log("Filter provided could be wrong or not available, please check");
		}

	}

	public void applyUserRatingFilter(String userRating) throws InterruptedException {

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);

		wait.until(ExpectedConditions.visibilityOf(fourStarRatingChkbox));

		if (userRating.equalsIgnoreCase("4.5+")) {

			fourNhalfStarRatingChkbox.click();
			Thread.sleep(2000);

			assertTrue(fourNhalfStarRatingChkbox.isEnabled(), "4.5+ rating check box could not be selected");

			Reporter.log("Applied user rating filter for: " + fourNhalfStarRatingChkbox.getText());

		}

		else if (userRating.equalsIgnoreCase("4+")) {

			fourStarRatingChkbox.click();
			Thread.sleep(2000);

			assertTrue(fourStarRatingChkbox.isEnabled(), "4+ rating check box could not be selected");

			Reporter.log("Applied user rating filter for: " + fourStarRatingChkbox.getText());

		}

		else if (userRating.equalsIgnoreCase("3.5+")) {

			threeNhalfStarRatingChkbox.click();
			Thread.sleep(2000);

			assertTrue(threeNhalfStarRatingChkbox.isEnabled(), "3.5+ rating check box could not be selected");

			Reporter.log("Applied user rating filter for: " + threeNhalfStarRatingChkbox.getText());

		}

		else if (userRating.equalsIgnoreCase("3+")) {

			threeStarRatingChkbox.click();
			Thread.sleep(2000);

			assertTrue(threeStarRatingChkbox.isEnabled(), "3+ rating check box could not be selected");

			Reporter.log("Applied user rating filter for: " + threeStarRatingChkbox.getText());

		}

		else {

			Reporter.log("Filter provided could be wrong or not available, please check");
		}

	}

	public void applyPriceRangeFilter(String priceRange) throws InterruptedException {

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);

		wait.until(ExpectedConditions.visibilityOf(upto2kPrice));

		if (priceRange.equalsIgnoreCase("Upto ₹2000")) {

			if (upto2kPrice.isEnabled())
				Reporter.log("The Price range filter applied for: " + upto2kPrice.getText());

			else {
				upto2kPrice.click();
				Reporter.log("The Price range filter applied for: " + upto2kPrice.getText());
				assertTrue(upto2kPrice.isEnabled(), "Upto 2000 Rs check box could not be selected");
			}

			Thread.sleep(1000);

		}

		else if (priceRange.equalsIgnoreCase("₹2001 - ₹4000")) {

			upto2kto4kPrice.click();

			Thread.sleep(1000);

			assertTrue(upto2kto4kPrice.isEnabled(), "2001 to 4000 Rs check box could not be selected");

			Reporter.log("The Price range filter applied for: " + upto2kto4kPrice.getText());
		}

		else if (priceRange.equalsIgnoreCase("₹4001 - ₹6000")) {

			upto4kto6kPrice.click();
			Thread.sleep(1000);

			assertTrue(upto4kto6kPrice.isEnabled(), "4001 to 6000 Rs check box could not be selected");

			Reporter.log("The Price range filter applied for: " + upto4kto6kPrice.getText());
		}

		else if (priceRange.equalsIgnoreCase("₹6001 - ₹8000")) {

			upto6kto8kPrice.click();
			Thread.sleep(1000);

			assertTrue(upto6kto8kPrice.isEnabled(), "6001 to 8000 Rs check box could not be selected");

			Reporter.log("The Price range filter applied for: " + upto6kto8kPrice.getText());
		}

		else if (priceRange.equalsIgnoreCase("₹8000 +")) {

			above8kPrice.click();
			Thread.sleep(1000);

			assertTrue(above8kPrice.isEnabled(), "Above 8000 Rs check box could not be selected");

			Reporter.log("The Price range filter applied for: " + above8kPrice.getText());
		}

		else {

			Reporter.log("Filter provided could be wrong or not available, please check");
		}

	}

}
