package by.htp.shim.steps;

import org.openqa.selenium.WebDriver;

import by.htp.shim.driver.DriverSingleton;
import by.htp.shim.pages.MainPage;
import by.htp.shim.pages.TheCalendarOfRatesPage;

public class Steps {

	private WebDriver driver;

	public void openBrowser() {

		driver = DriverSingleton.getDriver();
	}

	public void closeBrowser() {

		DriverSingleton.closeDriver();
		System.out.println("The browser is closed");
	}

	public void findFlight(String originLocation, String destinationLocation) throws InterruptedException {

		MainPage mainPage = new MainPage(driver);
		mainPage.openPage();
		mainPage.fillInTheDetails(originLocation, destinationLocation);
	}

	public void collectAllPrices(int numberOfWeeks) throws InterruptedException {

		TheCalendarOfRatesPage theCalendarPage = new TheCalendarOfRatesPage(driver);
		for (int i = 0; i < numberOfWeeks; i++) {
			theCalendarPage.takePrice();
			Thread.sleep(3000);
			theCalendarPage.goToNextWeek();
		}
		theCalendarPage.viewAllPrices();

	}

	public int viewMinimalPrice() {

		TheCalendarOfRatesPage theCalendarPage = new TheCalendarOfRatesPage(driver);
		return theCalendarPage.findMinimalPrice();
	}

}
