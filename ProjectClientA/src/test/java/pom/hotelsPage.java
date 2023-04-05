package pom;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Parameters;

public class hotelsPage {

	private WebDriver driver;

	@CacheLookup
	@FindBy(xpath = "//h4[text()='India']")
	WebElement indiaBtn;

	@CacheLookup
	@FindBy(xpath = "//h4[text()='International']")
	WebElement internationalBtn;

	@CacheLookup
	@FindBy(id = "downshift-1-input")
	WebElement searchBox;

	@CacheLookup
	@FindBy(xpath = "//input[@aria-activedescendant = 'downshift-1-item-0']")
	WebElement firstSuggestion;

	@CacheLookup
	@FindBy(xpath = "//div[text()='Check-in']")
	WebElement checkIn;

	@CacheLookup
	@FindBy(xpath = "//div[text()='Check-out']")
	WebElement checkOut;

	@CacheLookup
	@FindBy(xpath = "//*[@id='root']/div[2]/div/section[1]/div[1]/div[2]/div[3]/div/div[1]/div[2]/section/div/div[1]/div[2]/div")
	WebElement calender;

	@CacheLookup
	@FindBys(@FindBy(xpath = "//li[@class='date_is_selectable_true']//span"))
	List<WebElement> currentCalenderDates;

	@CacheLookup
	@FindBys(@FindBy(xpath = "//ul[@class= 'dcalendar-newstyles__DateWrapDiv-sc-1i003by-18 eFyCNL']//li[@class= 'date_is_selectable_true']"))
	List<WebElement> dates1;

	@CacheLookup
	@FindBys(@FindBy(xpath = "//div/div[2]/div[2]/div/ul[2][@class='dcalendar-newstyles__DateWrapDiv-sc-1i003by-18 eFyCNL']"))
	List<WebElement> checkOutCalender;

	@CacheLookup
	@FindBy(xpath = "//span[@data-testid='currentCalendarMonthName']")
	WebElement currentMonth;

	@CacheLookup
	@FindBy(xpath = "//span[@data-testid='nextCalendarMonthName']")
	WebElement checkOutMonth;

	@CacheLookup
	@FindBy(xpath = "//span[@data-testid ='calendarLeftArrowBtn']")
	WebElement calenderLeftBtn;

	@CacheLookup
	@FindBy(xpath = "//span[@data-testid ='calendarRightArrowBtn']")
	WebElement calenderRightBtn;

	@CacheLookup
	@FindBy(xpath = "//body/div[@id='root']/div[2]/div[1]/section[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[2]/section[1]/div[1]/div[1]/div[2]/div[1]/ul[2]/li[28]/span[1]")
	WebElement currentcheckinDate;

	@CacheLookup
	@FindBy(xpath = "//div[4]/div/h4[@class='dwebCommonstyles__SmallSectionHeader-sc-112ty3f-9 SearchBlockUIstyles__CheckInDateWrapDiv-sc-fity7j-15 bjZxoj gbNkLl']")
	WebElement checkoutDate;

	@CacheLookup
	@FindBy(xpath = "//div[@class ='dwebCommonstyles__CenteredDivWrap-sc-112ty3f-1 SearchBlockUIstyles__NightCountWrap-sc-fity7j-16 ibYPGm fkaAjO']")
	WebElement noOfNights;

	@CacheLookup
	@FindBy(xpath = "//span[normalize-space()='Guests & Rooms']")
	WebElement guestsAndRoomsText;

	@CacheLookup
	@FindBy(xpath = "//h4[@class='dwebCommonstyles__SmallSectionHeader-sc-112ty3f-9 PaxWidgetstyles__ContentActionValueWrapperSpan-sc-gv3w6r-7 bjZxoj dkRohM'][@data-testid='room-count']")
	WebElement roomsCount;

	@CacheLookup
	@FindBy(xpath = "//span[@data-testid='button-room-dec']")
	WebElement decRoomCount;

	@CacheLookup
	@FindBy(xpath = "//span[@data-testid='button-room-add']")
	WebElement incRoomCount;

	@CacheLookup
	@FindBy(xpath = "//h4[@data-testid='adult-count']")
	WebElement adultCount;

	@CacheLookup
	@FindBy(xpath = "//span[@data-testid='button-adult-dec']")
	WebElement decAdultCount;

	@CacheLookup
	@FindBy(xpath = "//span[@data-testid='button-adult-add']")
	WebElement incAdultCount;

	@CacheLookup
	@FindBy(xpath = "//button[@class='dwebCommonstyles__ButtonBase-sc-112ty3f-12 PaxWidgetstyles__ButtonWrapper-sc-gv3w6r-11 QWIoF jxqLbm']")
	WebElement doneBtn;

	@CacheLookup
	@FindBy(xpath = "//button[@data-testid = 'searchHotelBtn']")
	WebElement searchBtn;

	public hotelsPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void selectIndia() {

		driver.navigate().refresh();

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);

		wait.until(ExpectedConditions.visibilityOf(indiaBtn));

		indiaBtn.click();

	}

	public void selectInternational() {

		internationalBtn.click();
	}

	public void selectLocation(String location) throws InterruptedException {

		Actions a = new Actions(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		searchBox.sendKeys(location);
		Thread.sleep(2000);
		a.sendKeys(Keys.DOWN).perform();
		a.sendKeys(Keys.ENTER).perform();

	}

	public void selectCheckinDate(String checkinmonth, String checkinDate) throws InterruptedException {

		checkIn.click();

		Thread.sleep(2000);

		while (true) {

			String month = currentMonth.getText();

			if (month.equalsIgnoreCase(checkinmonth)) {
				break;
			}

			else {
				calenderRightBtn.click();
			}

		}

		for (WebElement ele : currentCalenderDates) {
			String date = ele.getText();

			if (date.equals(checkinDate)) {
				ele.click();
				break;
			}

		}

		Thread.sleep(4000);

	}

	public void selectCheckOutDate(String checkOutmonth, String checkOutDate) throws InterruptedException {

		Thread.sleep(2000);

		while (true) {

			String month = currentMonth.getText();

			if (month.equalsIgnoreCase(checkOutmonth)) {
				break;
			}

			else {
				calenderRightBtn.click();
			}

		}

		for (WebElement ele : currentCalenderDates) {
			String date = ele.getText();

			if (date.equals(checkOutDate)) {
				ele.click();
				break;
			}

		}

		Thread.sleep(2000);

	}

	public void selectNoOfRooms(int NoOfRooms) throws InterruptedException {

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);

		wait.until(ExpectedConditions.visibilityOf(guestsAndRoomsText));

		guestsAndRoomsText.click();
		Thread.sleep(3000);
	//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		while (true) {
            wait.until(ExpectedConditions.visibilityOf(roomsCount));
			String roomCount = roomsCount.getText();
			int count = Integer.parseInt(roomCount);

			if (count == NoOfRooms) {
				break;
			}

			else if (count > NoOfRooms) {
				decRoomCount.click();
			}

			else {

				incRoomCount.click();

			}

		}

	}

	public void selectNoOfAdults(int NoOfAdults) {
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);
		 wait.until(ExpectedConditions.visibilityOf(adultCount));

		while (true) {

			String adultsCount = adultCount.getText();
			int count = Integer.parseInt(adultsCount);

			if (count == NoOfAdults) {

				break;
			}

			else {

				if (count > NoOfAdults) {
					decAdultCount.click();

				}

				else {
					incAdultCount.click();

				}

			}

		}

	}

	public void clickDone() {
		doneBtn.click();
	}

	public void searchResults() {

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);

		wait.until(ExpectedConditions.visibilityOf(searchBtn));

		searchBtn.click();

	}

}
