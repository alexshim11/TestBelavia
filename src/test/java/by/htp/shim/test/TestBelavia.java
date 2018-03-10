package by.htp.shim.test;

import org.testng.annotations.Test;

import by.htp.shim.steps.Steps;

import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class TestBelavia {

	private Steps steps;
	private static final String ORIGINLOCATION = "Минск (MSQ), BY";
	private static final String DESTINATIONLOCATION = "Баку (BAK), AZ";
	private static final int NUMBEROFWEEKS = 4;

	@BeforeMethod(description = "Open Browser")
	public void start() {

		steps = new Steps();
		steps.openBrowser();
	}

	@Test
	public void testCorrectLocation() throws InterruptedException {

		steps.findFlight(ORIGINLOCATION, DESTINATIONLOCATION);
		steps.collectAllPrices(NUMBEROFWEEKS);
		Assert.assertEquals(steps.viewMinimalPrice(), 192);
	}

	@AfterMethod(description = "Close Browser")
	public void closeBrowser() {

		steps.closeBrowser();
	}

}
