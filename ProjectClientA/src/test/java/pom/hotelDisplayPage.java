package pom;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Reporter;

public class hotelDisplayPage {

	private WebDriver driver;
	String parent;

	@CacheLookup
	@FindBy(xpath = "//button[@class='dwebCommonstyles__ButtonBase-sc-112ty3f-12 BookingWidgetstyles__ViewRoomOptionsButton-sc-1tsb1-11 QWIoF dwIfSP']")
	WebElement roomOptionsBtn;

	@CacheLookup
	@FindBy(xpath = "//div[@id='2']//div//div//div//a[@href='#']//div//img")
	WebElement roomImg;

	@CacheLookup
	@FindBy(xpath = "//a[@data-testid='navigation-header-cta-#location']")
	WebElement locationLink;

	@CacheLookup
	@FindBy(xpath = "//a[@data-testid='navigation-header-cta-#guest-reviews']")
	WebElement guestReviewsLink;

	@CacheLookup
	@FindBy(xpath = "//a[@data-testid='navigation-header-cta-#QnA']")
	WebElement QandALink;

	@CacheLookup
	@FindBy(xpath = "//a[@data-testid='navigation-header-cta-#hotel-policies']")
	WebElement policiesLink;

	@CacheLookup
	@FindBy(css = "body > div:nth-child(3) > section:nth-child(2) > section:nth-child(10) > section:nth-child(3) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2)")
	WebElement locationView;

	@CacheLookup
	@FindBy(xpath = "//span[@class='GuestReview__AvgReviewTextWrapper-sc-1twl4uk-5 knjXL']")
	WebElement guestreviewAvg;

	@CacheLookup
	@FindBy(xpath = "//div[@class='Policystyles__PolicyHeaderTextStyled-sc-1vd94lq-2 pgaxu']")
	WebElement locationPoliciesText;

	@CacheLookup
	@FindBy(xpath = "//span[@class='QnAstyles__QnAHeadingTextWrapperSpan-sc-1gv8sy7-10 hyuNDv']")
	WebElement QandAText;

	@CacheLookup
	@FindBy(xpath = "//div[@id='2']//div[@class='Roomstyles__LeftDiv-sc-1ivl7fs-8 gaTtbL']//div[@class='RoomFlavorsstyles__RoomFlavorsContainer-sc-1fam3y6-0 iseoc room-flavor-container']//div[@class='RoomFlavorstyles__RoomFlavorWrap-sc-1btnl3r-9 fDiXMa']//div[@class='RoomFlavorstyles__RoomFlavorColumn-sc-1btnl3r-0 cvpSzU']//div//button[@class='dwebCommonstyles__ButtonBase-sc-112ty3f-12 RoomFlavorstyles__ButtonWrapper-sc-1btnl3r-16 QWIoF cgTEmz'][1]")
	WebElement selectRoomBtn;

	public hotelDisplayPage(WebDriver driver) {

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

	public void selectRoomOptionsBtn() {

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);

		wait.until(ExpectedConditions.visibilityOf(roomOptionsBtn));

		roomOptionsBtn.click();

		Reporter.log("View Room options button clicked");

	}

	public void selectRoombtn() {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);

		wait.until(ExpectedConditions.visibilityOf(selectRoomBtn));
		wait.until(ExpectedConditions.elementToBeClickable(selectRoomBtn));

		selectRoomBtn.sendKeys(Keys.ENTER);

		Reporter.log("Selected Room");
	}

	public void captureRoomImg() throws IOException, InterruptedException {

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);

		wait.until(ExpectedConditions.visibilityOf(roomImg));

		File src = roomImg.getScreenshotAs(OutputType.FILE);
		Thread.sleep(1000);
		File dest = new File("D:\\Edureka\\SeleniumProjectClientA\\ProjectClientA\\Screenshots\\hotelRoom.png");
		FileHandler.copy(src, dest);

		Reporter.log(
				"<a href=\"D:\\Edureka\\SeleniumProjectClientA\\ProjectClientA\\Screenshots\\hotelRoom.png\">Screenshot of hotel image</a>");

	}

	public void verifyLocationDisplyed() {

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);

		wait.until(ExpectedConditions.visibilityOf(locationLink));

		locationLink.click();

		wait.until(ExpectedConditions.visibilityOf(locationView));

		assertTrue(locationView.isDisplayed(), "Location is not displayed");

		Reporter.log("Location for hotel is displayed");
	}

	public void verifyGuestReviewsDisplyed() {

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);

		wait.until(ExpectedConditions.visibilityOf(guestReviewsLink));

		guestReviewsLink.click();

		wait.until(ExpectedConditions.visibilityOf(guestreviewAvg));

		assertTrue(guestreviewAvg.isDisplayed(), "Guest reviews not displayed");

		Reporter.log("Reviews provided by Guest is displayed");
	}

	public void verifyQandADisplyed() {

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);

		wait.until(ExpectedConditions.visibilityOf(QandALink));

		QandALink.click();

		wait.until(ExpectedConditions.visibilityOf(QandAText));

		assertTrue(QandAText.isDisplayed(), "Questions and answers section not displayed");

		Reporter.log("Questions and answers section is displayed");
	}

	public void verifyPoliciesDisplyed() {

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);

		wait.until(ExpectedConditions.visibilityOf(policiesLink));

		policiesLink.click();

		wait.until(ExpectedConditions.visibilityOf(locationPoliciesText));

		assertTrue(locationPoliciesText.isDisplayed(), "Location policies section not displayed");

		Reporter.log("Location policies section is displayed");
	}

}
