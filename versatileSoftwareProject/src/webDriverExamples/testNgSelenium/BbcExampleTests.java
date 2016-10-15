package webDriverExamples.testNgSelenium;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BbcExampleTests {

	private WebDriver ffBrowser;
	private String baseUrl;

	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		ffBrowser = new FirefoxDriver();
		baseUrl = "http://www.bbc.com/";
		ffBrowser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		ffBrowser.get(baseUrl);
		ffBrowser.manage().window().maximize();
	}

	@Test(priority = 1)
	public void bbcHomePageHeaderTests() throws IOException {
		/*
		 * Verify header presence elements on header search box they are
		 * displayed and enabled
		 */
		try {
			Assert.assertTrue(ffBrowser.findElement(By.xpath("//*[@id='orb-header']")).isDisplayed());
			Assert.assertTrue(ffBrowser.findElement(By.xpath("//*[@id='orb-header']/div[1]/div[1]/a")).isDisplayed());
			Assert.assertTrue(ffBrowser.findElement(By.xpath("//*[@id='orb-header']/div[1]/div[1]/a")).isEnabled());

			// Extract all webElements on Topnav and verify that they are
			// clickable
			// and enabled
			List<WebElement> allHeaderElements = ffBrowser.findElement(By.xpath("//*[@id='orb-nav-links']"))
					.findElements(By.tagName("a"));
			for (WebElement webElement : allHeaderElements) {
				System.out.println(webElement.getText());
				if (webElement.getText().equals("Radio"))
					break;
				Assert.assertTrue(webElement.isDisplayed());
				Assert.assertTrue(webElement.isEnabled());
			}
		} catch (Exception e) {
			takeScreenShots(ffBrowser);
		}
	}

	@Test(dependsOnMethods = "bbcHomePageHeaderTests", enabled = true, priority = 2)
	public void bbcHomePageSearchTest() throws IOException {
		try {
			Assert.assertTrue(ffBrowser.findElement(By.xpath("//*[@id='orb-search-q']")).isDisplayed());
			Assert.assertTrue(ffBrowser.findElement(By.xpath("//*[@id='orb-search-q']")).isEnabled());
			Assert.assertTrue(ffBrowser.findElement(By.xpath("//*[@id='orb-search-button']")).isDisplayed());
			Assert.assertTrue(ffBrowser.findElement(By.xpath("//*[@id='orb-search-button']")).isEnabled());
		} catch (Exception e) {
			takeScreenShots(ffBrowser);
		}
	}

	@Test(dependsOnMethods = "bbcHomePageSearchTest", enabled = false, timeOut = 10000, priority = 3)
	public void bbcHomePageSearchFunctionTest() {
		// search for British bake off
		String searchSring = "British Bake off";
		ffBrowser.findElement(By.xpath("//*[@id='orb-search-q']")).clear();
		ffBrowser.findElement(By.xpath("//*[@id='orb-search-q']")).sendKeys(searchSring);
		ffBrowser.findElement(By.xpath("//*[@id='orb-search-button']")).click();

		Assert.assertTrue(ffBrowser.findElement(By.xpath("//*[@id='search-content']/ol[1]/li[1]/article/div/h1/a"))
				.getText().contains(searchSring));
	}
	
	

	@Test(dependsOnMethods = "bbcHomePageHeaderTests", enabled = true, dataProvider = "postCode")
	public void bbcWeatherTest(String postCode, String expectedpost) {
		ffBrowser.findElement(By.xpath("//*[@id='locator-form-search']")).clear();
		ffBrowser.findElement(By.xpath("//*[@id='locator-form-search']")).sendKeys(postCode);
		ffBrowser.findElement(By.xpath("//*[@id='locator-form-submit']")).click();
		System.out.println(ffBrowser.findElement(By.xpath(".//*[@id='blq-content']/div[1]/h1/span")).getText());
		Assert.assertTrue(ffBrowser.findElement(By.xpath(".//*[@id='blq-content']/div[1]/h1/span")).getText()
				.contains(expectedpost));
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		ffBrowser.quit();
	}

	public static void takeScreenShots(WebDriver browser) throws IOException {
		TakesScreenshot scrShot = ((TakesScreenshot) browser);
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		// Move image file to new destination
		System.out.println(System.getProperty("user.dir") + "/screeShot.png");
		File DestFile = new File(System.getProperty("user.dir") + "/screeShot.png");
		// Copy file at destination
		FileUtils.copyFile(SrcFile, DestFile);

	}

	@DataProvider(name = "postCode")
	private static Object[][] postCodes() {
		return new Object[][] { { "SW18 4BP", "SW18" }, { "NG2 3AN", "NG2" }, { "WC2H 0JG", "WC2H" } };
	}
}
