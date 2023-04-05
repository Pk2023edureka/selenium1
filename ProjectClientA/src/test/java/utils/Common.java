package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Common {

	private WebDriver driver;

	public void SetUpBrowser(String browser, String url) {

		String CurDir = System.getProperty("user.dir");
		String fs = System.getProperty("file.separator");
		String path = CurDir + fs + "drivers" + fs;

		ChromeOptions co = new ChromeOptions();
		co.addArguments("--disable-notifications");
		//co.addArguments("--headless");
		co.setAcceptInsecureCerts(true);

		if (browser.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver", path + "chromedriver.exe");
			driver = new ChromeDriver(co);
		}

		else if (browser.equalsIgnoreCase("edge")) {

			System.setProperty("webdriver.edge.driver", path + "msedgedriver.exe");
			driver = new EdgeDriver();
		}

		else {
			System.out.println("Valid browser details not entered");
			System.exit(0);
		}

		driver.manage().window().maximize();

		if (url != "")
			driver.get(url);
		else
			driver.get("about:blank");

	}

	public WebDriver getDriver() {
		return driver;
	}

	public void CloseTab() {
		driver.close();
	}

	public void quitBrowser() {
		driver.quit();
	}

}
