package webDriverExamples;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstSeleniumTest {

	/*
	 * get and navigate in selenium Close
	 */
	@Test
	public void navigateAsos() {
		WebDriver ffBrowser = new FirefoxDriver();
		String baseUrl = "http://www.bbc.com/";
		ffBrowser.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		ffBrowser.get(baseUrl);
		ffBrowser.manage().window().maximize();

		String actualTitle = ffBrowser.getTitle();
		String expectedTitle = "ASOS | Shop the Latest Clothes and Fashion Online";
		System.out.println(actualTitle);
		Assert.assertEquals(actualTitle, expectedTitle);
		ffBrowser.close();

		// Quit is used to cloase all opened brwosers
		// ffBrowser.quit();
	}

}
