package test;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import keyWords.KeyWord;

public class ScenarioThree extends BaseTest {
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

	@Parameters({ "ChekInmonth", "CheckIndate" })
	@Test(description = "Selecting CheckIn Date")
	public void Step04(String month, String date) throws InterruptedException {

		kw.SET_CHECKINDATE(month, date);

	}

	@Parameters({ "ChekOutmonth", "CheckOutdate" })
	@Test(description = "Selecting CheckOut Date")
	public void Step05(String month, String date) throws InterruptedException {

		kw.SET_CHECKOUTDATE(month, date);

	}

	@Parameters("noOfRooms")
	@Test(description = "Selecting No of Rooms")
	public void Step06(int noOfRooms) throws InterruptedException {

		kw.SET_NOOFROOMS(noOfRooms);

	}

	@Parameters("noOfAdults")
	@Test(description = "Selecting No of Adults")
	public void Step07(int noOfAdults) throws InterruptedException {

		kw.SET_NOOFADULTS(noOfAdults);

	}

	@Test(description = "Clicking on Search")
	public void Step08() {

		kw.SEARCH_HOTEL();

	}

	@Parameters("hotelName")
	@Test(description = "Selecting first hotel in the Search Results and verifying the hotel name")
	public void Step09(String hotelName) throws InterruptedException {

		kw.VERIFY_HOTEL_ANDSELECT(hotelName);

	}

	@Test(description = "Clicking on Search")
	public void Step10() throws InterruptedException {

		kw.SELECT_VIEW_ROOMS();

	}

	@Test(description = "Capturing room image")
	public void Step11() throws InterruptedException, IOException {

		kw.CAPTURE_ROOM_IMAGE();

	}

	@Test(description = "Verifying whether Location of Hotel displayed")
	public void Step13() throws InterruptedException {

		kw.VERIFY_LOCATION_OFHOTEL();

	}

	@Test(description = "Verifying whether Question and Answers section of Hotel displayed")
	public void Step14() throws InterruptedException {

		kw.VERIFY_QandA_OFHOTEL();

	}

	@Test(description = "Verifying whether Policies section of Hotel displayed")
	public void Step15() throws InterruptedException {

		kw.VERIFY_POLICIES_OFHOTEL();

	}

	@Test(description = "Verifying whether Guest reviews section of Hotel displayed")
	public void Step16() throws InterruptedException {

		kw.VERIFY_GUESTREVIEWS_OFHOTEL();

	}

}
