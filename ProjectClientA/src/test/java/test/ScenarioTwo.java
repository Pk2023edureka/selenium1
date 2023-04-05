package test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import keyWords.KeyWord;

public class ScenarioTwo extends BaseTest {

	KeyWord kw;

	@BeforeClass
	public void beforeClass() {

		kw = new KeyWord(driver);
	}

	@Test(description = "Clicking on Hotels page in Goibibo Home page")
	public void Step01() {

		kw.SELECT_HOTELS_PAGE();

	}

	@Test(description = "Selecting India")
	public void Step02() {

		kw.SELECT_INDIA();

	}

	@Parameters("location")
	@Test(description = "Selecting location to book a hotel")
	public void Step03(String location) throws InterruptedException {

		kw.SET_LOCATION(location);

	}

	@Parameters({ "ChekInmonth", "CheckIndate", "ChekOutmonth", "CheckOutdate" })
	@Test(description = "Selecting CheckIn Date and CheckOut Date")
	public void Step04(String ChekInmonth, String CheckIndate, String ChekOutmonth, String CheckOutdate)
			throws InterruptedException {

		kw.SET_CHECKINDATE(ChekInmonth, CheckIndate);
		kw.SET_CHECKOUTDATE(ChekOutmonth, CheckOutdate);

	}

	@Parameters({ "noOfRooms", "noOfAdults" })
	@Test(description = "Selecting No of Rooms and no of Adults")
	public void Step05(int noOfRooms, int noOfAdults) throws InterruptedException {

		kw.SET_NOOFROOMS(noOfRooms);
		kw.SET_NOOFADULTS(noOfAdults);

	}

	@Test(description = "Clicking on Search")
	public void Step06() {

		kw.SEARCH_HOTEL();

	}

	@Parameters("hotelName")
	@Test(description = "Selecting the first hotel and verifying it")
	public void Step07(String hotelName) throws InterruptedException {

		kw.VERIFY_HOTEL_ANDSELECT(hotelName);

	}

	@Test(description = "View Rooms option is selected and Selecting Room")
	public void Step08() throws InterruptedException {

		kw.SELECT_VIEW_ROOMS();
		kw.SELECT_ROOM();

	}

	@Parameters({ "hotelName", "expectedChecinDate", "expectedCheckOutDate", "expectedGuestNRoom" })
	@Test(description = "Verifying final booking details like Hotel name,ChecIn, CheckOut, no of Guests and no of Rooms "
			+ "before booking")
	public void Step09(String hotelName, String expectedChecinDate, String expectedCheckOutDate,
			String expectedGuestNRoom) throws InterruptedException {

		kw.VERIFY_FINAL_HOTEL_DETAILS(hotelName);
		kw.VERIFY_FINAL_CHECIN_CHECKOUT_DATE(expectedChecinDate, expectedCheckOutDate);
		kw.VERIFY_ROOM_ADULTS_DETAILS(expectedGuestNRoom);

	}

	@Parameters({ "titleName", "firstName", "lastName", "emailID", "phoneNo" })
	@Test(description = "Entering Guest details")
	public void Step10(String titleName, String firstName, String lastName, String emailID, String phoneNo)
			throws InterruptedException {

		kw.ENTER_DETAILS_OF_GUEST(titleName, firstName, lastName, emailID, phoneNo);

	}

	@Test(description = "Proceeding to Final Payment page")
	public void Step11() throws InterruptedException {

		kw.PROCEED_TO_PAYMENT();

	}

	@Parameters({ "cardNumber", "expiryDate", "CVV", "firstName" })
	@Test(description = "Entering Credit Card details")
	public void Step12(String cardNumber, String expiryDate, String CVV, String firstName) throws InterruptedException {

		kw.ENTER_CREDIT_CARD_DETAILS(cardNumber, expiryDate, CVV, firstName);

	}

	@Test(description = "Verifying invalid Credit card message")
	public void Step13() throws InterruptedException {

		kw.VERIFY_INVALID_CREDIT_CARD_MSG();

	}

}
