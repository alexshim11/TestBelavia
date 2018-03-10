package by.htp.shim.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TheCalendarOfRatesPage extends AbstractPage {

	private static final String URL = "https://booking.belavia.by/Select/Calendar?sid=6547e85d1db1449c917da89d00e4d8b6";
	private List<WebElement> priceListElements;
	private List<Integer> priceList = new ArrayList<>();

	@FindBy(xpath = "//*[@id='matrix']/div[1]/div[1]/div[2]/a")
	private WebElement buttonNextWeek;

	public TheCalendarOfRatesPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public void takePrice() {

		priceListElements = driver.findElements(By.xpath("//div[@class = 'price']/div/label"));
		int price;
		String comparison = " ";

		for (WebElement element : priceListElements) {
			if (!(element.getText().equals(comparison))) {
				price = Integer.parseInt(element.getText().substring(0, 3));
				priceList.add(price);
			}
		}
	}

	public int findMinimalPrice() {

		takePrice();
		int minPrice = priceList.get(0);
		for (int i = 0; i < priceList.size(); i++) {

			if (minPrice > priceList.get(i)) {
				minPrice = priceList.get(i);
			}
		}
		System.out.println("-----------------");
		System.out.println(minPrice);
		return minPrice;
	}

	public void viewAllPrices() {

		takePrice();
		for (Integer element : priceList) {
			System.out.println(element + " BYN");
		}
	}

	public void viewMinimalPrice() {
		int minPrice = priceList.get(0);
		findMinimalPrice();
		System.out.println("The minimal price is " + minPrice + " BYN");

	}

	public void goToNextWeek() {

		buttonNextWeek.click();
	}

	@Override
	public void openPage() {

		driver.get(URL);
	}

}
