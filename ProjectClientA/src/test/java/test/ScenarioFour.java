package test;

import org.testng.annotations.Test;

import keyWords.KeyWord;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


public class ScenarioFour extends BaseTest {
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

	@Parameters("popfilterName")
	@Test(description = "Applying Popular filter")
	public void Step09(String popfilterName) throws InterruptedException {

		kw.APPLY_POPULAR_FILTER(popfilterName);

	}

	@Parameters("userRating")
	@Test(description = "Applying User rating filter")
	public void Step10(String userRating) throws InterruptedException {

		kw.APPLY_USERRATING_FILTER(userRating);

	}

	@Parameters("priceRange")
	@Test(description = "Applying Price range filter")
	public void Step11(String priceRange) throws InterruptedException {

		kw.APPLY_PRICERANGE_FILTER(priceRange);

	}

}
