package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import utils.Common;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class BaseTest {

	Common common;

	static WebDriver driver;

	@Parameters({ "browser", "url" })

	@BeforeTest
	public void beforeTest(String browser, String url) {

		common = new Common();
		common.SetUpBrowser(browser, url);
		driver = common.getDriver();
	}

	@AfterTest
	public void afterTest() {
		// common.quitBrowser();
	}

}
