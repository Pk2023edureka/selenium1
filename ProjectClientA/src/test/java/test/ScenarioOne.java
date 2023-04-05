package test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import keyWords.KeyWord;

public class ScenarioOne extends BaseTest {

	
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
	public void Step08()  {

		kw.SEARCH_HOTEL();

	}

}
