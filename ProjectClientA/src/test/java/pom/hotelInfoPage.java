package pom;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Reporter;

public class hotelInfoPage {

	private WebDriver driver;
	String parent;

	@CacheLookup
	@FindBy(xpath = "(//h4[@class='dwebCommonstyles__SmallSectionHeader-sc-112ty3f-9 bjZxoj'])[1]")
	WebElement hotelNameinInfo;

	@CacheLookup
	@FindBy(xpath = "//div[1]/p[@class='DurationBlockNew__CheckInWrapPara-sc-1977hwn-3 hxhQEU']")
	WebElement checkInDateInfo;

	@CacheLookup
	@FindBy(xpath = "//div[2]/p[@class='DurationBlockNew__CheckInWrapPara-sc-1977hwn-3 hxhQEU']")
	WebElement checkOutDateInfo;

	@CacheLookup
	@FindBy(xpath = "//div[3]/p[@class='DurationBlockNew__CheckInWrapPara-sc-1977hwn-3 hxhQEU']")
	WebElement guestAndRoomInfo;

	@CacheLookup
	@FindBy(xpath = "//select[@class='PersonalProfile__NameEnterSelect-sc-1r9ak8b-7 hkMeMW']")
	WebElement title;

	@CacheLookup
	@FindBy(xpath = "//input[@data-guestdetailsinnerwrapid ='first-name']")
	WebElement Fname;

	@CacheLookup
	@FindBy(xpath = "//input[@data-guestdetailsinnerwrapid ='last-name']")
	WebElement Lname;

	@CacheLookup
	@FindBy(xpath = "//input[@data-guestdetailsinnerwrapid='guest-details-email']")
	WebElement email;

	@CacheLookup
	@FindBy(xpath = "//input[@data-guestdetailsinnerwrapid='guest-details-phone']")
	WebElement phnNo;

	@CacheLookup
	@FindBy(xpath = "//div[@class='SelectPaymentOptionstyles__SelectBookNowPayLaterOption-sc-11cctcq-13 guxmgu']")
	WebElement bookAt1PaymentOption;

	@CacheLookup
	@FindBy(xpath = "//button[@class='dwebCommonstyles__ButtonBase-sc-112ty3f-12 GuestDetailsBlockstyles__CustomButton-sc-1rzm4ar-6 QWIoF blGWwt']")
	WebElement proceedToPaymentBtn;

	@CacheLookup
	@FindBy(xpath = "//div[@class='fl width100 methodHeader'][@id='tab_card']")
	WebElement creditCardBtn;

	@CacheLookup
	@FindBy(xpath = "(//input[@placeholder='Card Number'])[1]")
	WebElement cardNo;

	@CacheLookup
	@FindBy(xpath = "//input[@name ='ccname']")
	WebElement NameonCard;

	@CacheLookup
	@FindBy(xpath = "(//div[@class='newCardDetail flightsPWACVV']//div[@class='col-md-6 col-sm-6 col-xs-6 pad0 cr_crd_exp_p']//input")
	WebElement cardExpiryDate;

	@CacheLookup
	@FindBy(xpath = "(//input[@placeholder='CVV NO.'])[1]")
	WebElement cardCVV;

	@CacheLookup
	@FindBy(xpath = "(//button[@class='button green large citipatBtn btn payNowBtn'])[3]")
	WebElement payAt1Btn;

	@CacheLookup
	@FindBy(xpath = "(//p[@class='ico13 red padT2 greyDr InvalidError'])[4]")
	WebElement cardNotValidmsg;

	public hotelInfoPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		parent = driver.getWindowHandle();

	}

	public void verifyHotelDetails(String hotelName) throws InterruptedException {

		Thread.sleep(1000);

		String expectedHotelName = hotelName;

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);

		wait.until(ExpectedConditions.visibilityOf(hotelNameinInfo));

		String actualHotelName = hotelNameinInfo.getText();

		assertTrue(actualHotelName.equalsIgnoreCase(expectedHotelName), "Hotel name is not as expected");

		Reporter.log("Finalized Hotel name: " + actualHotelName);

	}

	public void verifyCheckinDate(String expectedChecinDate) throws InterruptedException {

		Thread.sleep(1000);

		String actualCheckinDate = checkInDateInfo.getText();

		assertTrue(actualCheckinDate.equalsIgnoreCase(expectedChecinDate), "Check in date is not as expected");

		Reporter.log("Finalized Check In date : " + actualCheckinDate);
	}

	public void verifyCheckOutDate(String expectedCheckOutDate) throws InterruptedException {

		Thread.sleep(1000);

		String actualCheckOutDate = checkOutDateInfo.getText();

		assertTrue(actualCheckOutDate.equalsIgnoreCase(expectedCheckOutDate), "Cehck out date is not as expected");

		Reporter.log("Finalized Check Out date : " + actualCheckOutDate);
	}

	public void verifyGuestNRoomdetails(String expectedGuestNRoom) throws InterruptedException {

		Thread.sleep(1000);

		String actualGuestNRoom = guestAndRoomInfo.getText();

		assertTrue(actualGuestNRoom.equalsIgnoreCase(expectedGuestNRoom), "Guest and Room details are not as expected");

		Reporter.log("Finalized Guests and Room : " + actualGuestNRoom);
	}

	public void selectTitleofGuest(String titleName) throws InterruptedException {

		Thread.sleep(1000);
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);

		wait.until(ExpectedConditions.visibilityOf(title));
		wait.until(ExpectedConditions.elementToBeClickable(title));

		Select dropdown = new Select(title);

		if (titleName.equalsIgnoreCase("Mr")) {

			dropdown.selectByIndex(0);

			Reporter.log("Title of Guest set as Mr");

		}

		else if (titleName.equalsIgnoreCase("Mrs")) {

			dropdown.selectByIndex(1);

			Reporter.log("Title of Guest set as Mrs");

		}

		else if (titleName.equalsIgnoreCase("Miss")) {

			dropdown.selectByIndex(2);

			Reporter.log("Title of Guest set as Miss");

		}

		else {

			Reporter.log("Incorrect title name, please check");

		}

	}

	public void enterFname(String firstName) {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);

		wait.until(ExpectedConditions.visibilityOf(Fname));
		wait.until(ExpectedConditions.elementToBeClickable(Fname));

		Fname.click();
		Fname.clear();

		Fname.sendKeys(firstName);

		Reporter.log("First name entered");

	}

	public void enterLname(String lastName) {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);

		wait.until(ExpectedConditions.visibilityOf(Lname));

		Lname.sendKeys(lastName);

		Reporter.log("Last name entered");

	}

	public void enterEmail(String emailID) {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);

		wait.until(ExpectedConditions.visibilityOf(email));

		email.sendKeys(emailID);

		Reporter.log("Email entered");

	}

	public void enterPhno(String phoneNo) {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);

		wait.until(ExpectedConditions.visibilityOf(phnNo));

		phnNo.sendKeys(phoneNo);

		Reporter.log("Phone No entered");

	}

	public void selectBookAt1Payment() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);

		wait.until(ExpectedConditions.visibilityOf(bookAt1PaymentOption));

		bookAt1PaymentOption.click();

		Reporter.log("Slected Book @ 1 payment option");

	}

	public void selectProccedToPayment() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);

		wait.until(ExpectedConditions.visibilityOf(proceedToPaymentBtn));

		proceedToPaymentBtn.click();

		Reporter.log("Slected Procced to payment Button");

		Thread.sleep(2000);

	}

	public void selectCreditCard() throws InterruptedException {

		Thread.sleep(3000);

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);

		wait.until(ExpectedConditions.visibilityOf(creditCardBtn));
		wait.until(ExpectedConditions.elementToBeClickable(creditCardBtn));
		

		creditCardBtn.click();
		

		Reporter.log("Slected credit card for payment");

	}

	public void enterCreditCardNo(String cardNumber) {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);

		wait.until(ExpectedConditions.visibilityOf(cardNo));

		cardNo.sendKeys("cardNumber");

		Reporter.log("Entered credit card no as " +cardNumber);

	}

	public void enterNameOnCard(String firstName) {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);

		wait.until(ExpectedConditions.visibilityOf(NameonCard));

		NameonCard.sendKeys(firstName);

		Reporter.log("Entered Name on credit card as " +firstName);

	}

	public void enterCardExpiryDate(String expiryDate) {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);

		wait.until(ExpectedConditions.visibilityOf(cardExpiryDate));

		cardExpiryDate.sendKeys(expiryDate);

		Reporter.log("Entered credit card Expiry date as " +expiryDate);

	}

	public void enterCardCVV(String CVV) {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);

		wait.until(ExpectedConditions.visibilityOf(cardCVV));

		cardCVV.sendKeys(CVV);

		Reporter.log("Entered CVV of credit card as " +CVV);

	}

	public void verifyInvalidCardMsg() throws InterruptedException {

		Thread.sleep(1000);

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);

		wait.until(ExpectedConditions.visibilityOf(cardNotValidmsg));

		Reporter.log("Error message displayed as: " +cardNotValidmsg.getText());

	}

}
