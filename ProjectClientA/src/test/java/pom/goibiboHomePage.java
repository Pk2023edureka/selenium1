package pom;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class goibiboHomePage {

	private WebDriver driver;

	@CacheLookup
	@FindBy(xpath = "//a[@href = '/hotels/']")
	WebElement hotelsLink;

	@CacheLookup
	@FindBy(xpath = "//a[@href = '/flights/']")
	WebElement flightsLink;

	public goibiboHomePage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void clickHotelsLink() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		hotelsLink.click();
		
		Reporter.log("Hotels page is selected");

	}

	public void clickFlightsLink() {

		flightsLink.click();
	}

}
