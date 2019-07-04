package uk.co.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverUtil {

	private static WebDriver driver;

	static {

		if (AppConstants.CHROME_BROWSER.equalsIgnoreCase(AppProperties.get(AppConstants.BROWSER_TYPE))) {

			System.setProperty(AppConstants.CHROME_DRIVER,
					System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\" + "chromedriver.exe");
			driver = new ChromeDriver();

		} else if (AppConstants.FIREFOX_BROWSER.equalsIgnoreCase(AppProperties.get(AppConstants.BROWSER_TYPE))) {

			System.setProperty(AppConstants.GECKO_DRIVER,
					System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\" + "geckodriver.exe");

			driver = new FirefoxDriver();
			
		} 
	}

	public static WebDriver getDriver() {
		return driver;
	}
}
