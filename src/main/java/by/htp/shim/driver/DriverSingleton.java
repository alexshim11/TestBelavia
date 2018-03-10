package by.htp.shim.driver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverSingleton {

	public static WebDriver driver;
	public static final String WEB_DRIVER = "webdriver.chrome.driver";
	public static final String WEB_DRIVER_PATH = "D:\\Install\\Install Developer\\Drivers\\chromedriver.exe";

	private DriverSingleton() {

	}

	public static WebDriver getDriver() {

		if (driver == null) {
			System.setProperty(WEB_DRIVER, WEB_DRIVER_PATH);
			driver = new ChromeDriver();
			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();

		}

		return driver;

	}

	public static void closeDriver() {
		driver.quit();;
		driver = null;
	}

}
