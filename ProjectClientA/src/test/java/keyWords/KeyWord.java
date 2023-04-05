package keyWords;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import pom.goibiboHomePage;
import pom.hotelDisplayPage;
import pom.hotelInfoPage;
import pom.hotelsPage;
import pom.hotelsResultPage;

public class KeyWord {

	private WebDriver driver;

	public KeyWord(WebDriver driver) {
		this.driver = driver;
	}

	public void SELECT_HOTELS_PAGE() {

		goibiboHomePage g = new goibiboHomePage(driver);
		g.clickHotelsLink();

	}

	public void SELECT_INDIA() {

		hotelsPage h = new hotelsPage(driver);
		h.selectIndia();
		Reporter.log("India is selected");

	}

	public void SET_LOCATION(String location) throws InterruptedException {

		hotelsPage h = new hotelsPage(driver);
		h.selectLocation(location);

		Reporter.log("Location: " + location + " is eentered as per user's choice");

	}

	public void SET_CHECKINDATE(String month, String date) throws InterruptedException {

		hotelsPage h = new hotelsPage(driver);
		h.selectCheckinDate(month, date);

		Reporter.log("CheckIn date selected " + date + " " + month);
	}

	public void SET_CHECKOUTDATE(String month, String date) throws InterruptedException {

		hotelsPage h = new hotelsPage(driver);
		h.selectCheckOutDate(month, date);

		Reporter.log("CheckOut date selected " + date + " " + month);

	}

	public void SET_NOOFROOMS(int noOfRooms) throws InterruptedException {

		hotelsPage h = new hotelsPage(driver);
		h.selectNoOfRooms(noOfRooms);

		Reporter.log("The number of Rooms selected is " + noOfRooms);

	}

	public void SET_NOOFADULTS(int noOfAdults) throws InterruptedException {

		hotelsPage h = new hotelsPage(driver);
		h.selectNoOfAdults(noOfAdults);

		Reporter.log("The number of Rooms selected is " + noOfAdults);

	}

	public void SEARCH_HOTEL() {

		hotelsPage h = new hotelsPage(driver);

		h.clickDone();
		h.searchResults();

		Reporter.log("Searching the Hotel with above details entered");
	}

	public void VERIFY_HOTEL_ANDSELECT(String hotelName) throws InterruptedException {

		hotelsResultPage hr = new hotelsResultPage(driver);

		hr.verifyHotelAndSelect(hotelName);

	}

	public void APPLY_POPULAR_FILTER(String popfilterName) throws InterruptedException {

		hotelsResultPage hr = new hotelsResultPage(driver);

		hr.applyPopularFilter(popfilterName);
	}

	public void APPLY_USERRATING_FILTER(String userRating) throws InterruptedException {

		hotelsResultPage hr = new hotelsResultPage(driver);

		hr.applyUserRatingFilter(userRating);
	}

	public void APPLY_PRICERANGE_FILTER(String priceRange) throws InterruptedException {

		hotelsResultPage hr = new hotelsResultPage(driver);

		hr.applyPriceRangeFilter(priceRange);
	}

	public void SELECT_VIEW_ROOMS() throws InterruptedException {

		hotelDisplayPage hd = new hotelDisplayPage(driver);

		hd.selectRoomOptionsBtn();
	}

	public void SELECT_ROOM() throws InterruptedException {

		hotelDisplayPage hd = new hotelDisplayPage(driver);

		hd.selectRoombtn();
	}

	public void CAPTURE_ROOM_IMAGE() throws InterruptedException, IOException {

		hotelDisplayPage hd = new hotelDisplayPage(driver);

		hd.captureRoomImg();
	}

	public void VERIFY_LOCATION_OFHOTEL() throws InterruptedException {

		hotelDisplayPage hd = new hotelDisplayPage(driver);

		hd.verifyLocationDisplyed();
	}

	public void VERIFY_QandA_OFHOTEL() throws InterruptedException {

		hotelDisplayPage hd = new hotelDisplayPage(driver);

		hd.verifyQandADisplyed();
	}

	public void VERIFY_POLICIES_OFHOTEL() throws InterruptedException {

		hotelDisplayPage hd = new hotelDisplayPage(driver);

		hd.verifyPoliciesDisplyed();
	}

	public void VERIFY_GUESTREVIEWS_OFHOTEL() throws InterruptedException {

		hotelDisplayPage hd = new hotelDisplayPage(driver);

		hd.verifyGuestReviewsDisplyed();
	}

	public void VERIFY_FINAL_HOTEL_DETAILS(String hotelName) throws InterruptedException {

		hotelInfoPage hi = new hotelInfoPage(driver);

		hi.verifyHotelDetails(hotelName);
	}

	public void VERIFY_FINAL_CHECIN_CHECKOUT_DATE(String expectedChecinDate, String expectedCheckOutDate)
			throws InterruptedException {

		hotelInfoPage hi = new hotelInfoPage(driver);

		hi.verifyCheckinDate(expectedChecinDate);
		hi.verifyCheckOutDate(expectedCheckOutDate);
	}

	public void VERIFY_ROOM_ADULTS_DETAILS(String expectedGuestNRoom) throws InterruptedException {

		hotelInfoPage hi = new hotelInfoPage(driver);

		hi.verifyCheckOutDate(expectedGuestNRoom);
	}

	public void ENTER_DETAILS_OF_GUEST(String titleName, String firstName, String lastName, String emailID,
			String phoneNo) throws InterruptedException {

		hotelInfoPage hi = new hotelInfoPage(driver);

		hi.selectTitleofGuest(titleName);
		hi.enterFname(firstName);
		hi.enterLname(lastName);
		hi.enterEmail(emailID);
		hi.enterPhno(phoneNo);
	}

	public void PROCEED_TO_PAYMENT() throws InterruptedException {

		hotelInfoPage hi = new hotelInfoPage(driver);

		hi.selectBookAt1Payment();
		hi.selectProccedToPayment();

	}

	public void SELECT_CREDIT_CARD() throws InterruptedException {

		hotelInfoPage hi = new hotelInfoPage(driver);

		hi.selectCreditCard();

	}

	public void ENTER_CREDIT_CARD_DETAILS(String cardNumber, String expiryDate, String CVV, String firstName)
			throws InterruptedException {

		hotelInfoPage hi = new hotelInfoPage(driver);

		hi.enterCreditCardNo(cardNumber);
		hi.enterNameOnCard(firstName);
		hi.enterCardExpiryDate(expiryDate);
		hi.enterCardCVV(CVV);

	}
	
	public void VERIFY_INVALID_CREDIT_CARD_MSG() throws InterruptedException {

		hotelInfoPage hi = new hotelInfoPage(driver);

		hi.verifyInvalidCardMsg();

	}

}
