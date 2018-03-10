package by.htp.shim.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends AbstractPage {

	private static final String URL = "https://belavia.by/";

	@FindBy(xpath = "//*[@id='OriginLocation_Combobox']")
	private WebElement originLocationForm;

	@FindBy(xpath = "//*[@id='DestinationLocation_Combobox']")
	private WebElement destinationLocationForm;

	@FindBy(xpath = "//*[@class=\"col-group form-group\"]/div/label[1]")
	private WebElement buttonOneWay;

	@FindBy(xpath = "//*[@class='col-mb-6 col-5']")
	private WebElement buttonCalendar;

	@FindBy(xpath = "//*[@id=\"step-2\"]/div[4]/div/button")
	private WebElement buttonFind;

	public MainPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public void fillInTheDetails(String originLocation, String destinationLocation) throws InterruptedException {

		originLocationForm.sendKeys(originLocation);
		originLocationForm.sendKeys(Keys.RETURN);
		destinationLocationForm.sendKeys(destinationLocation);
		destinationLocationForm.sendKeys(Keys.RETURN);
		buttonOneWay.click();
		buttonCalendar.click();
		// Manually enter the date of departure
		Thread.sleep(3000);
		buttonFind.click();

	}

	@Override
	public void openPage() {

		driver.get(URL);
		System.out.println("StartPage is Opened");
	}

}
