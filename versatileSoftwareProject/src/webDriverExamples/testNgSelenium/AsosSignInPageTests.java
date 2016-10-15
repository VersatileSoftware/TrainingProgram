package webDriverExamples.testNgSelenium;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
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

public class AsosSignInPageTests {

	private WebDriver ffBrowser;
	private String baseUrl;

	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		ffBrowser = new FirefoxDriver();
		baseUrl = "http://www.asos.com/";
		ffBrowser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		ffBrowser.get(baseUrl);
		ffBrowser.manage().window().maximize();
	}

	@Test(priority = 1)
	public void verifyAsosHomePageSignInElement() throws IOException {
		try {
			/*
			 * Verify that the sign in text link is displayed Can be clicked and
			 * click on it
			 */
			Assert.assertTrue(ffBrowser.findElement(By.xpath("//*[@id='anonymous']/a[2]")).isDisplayed());
			Assert.assertTrue(ffBrowser.findElement(By.xpath(".//*[@id='anonymous']/a[2]")).isEnabled());
		} catch (Exception e) {
			Assert.assertTrue(false);
			takeScreenShots();
		}
		ffBrowser.findElement(By.xpath("//*[@id='anonymous']/a[2]")).click();
	}

	@Test(priority = 2, dependsOnMethods = "verifyAsosHomePageSignInElement")
	public void asosVerifySignInLandingPage() throws IOException {
		/*
		 * Verify that we are on sign in page
		 */
		Assert.assertTrue(ffBrowser.findElement(By.xpath("//*[@id='main']/div")).isDisplayed());
	}

	@Test(priority = 3, dependsOnMethods = "asosVerifySignInLandingPage")
	public void asosVerifySignInLandingPageElements() throws IOException {
		/*
		 * Verify all elements in the Sign in page
		 * 
		 */
		Assert.assertTrue(ffBrowser.findElement(By.xpath("//*[@id='main']/div/div[1]/div[2]")).isDisplayed());
		Assert.assertTrue(ffBrowser.findElement(By.xpath("//*[@id='EmailAddress']")).isDisplayed());
		Assert.assertTrue(ffBrowser.findElement(By.xpath("//*[@id='EmailAddress']")).isEnabled());
	}

	@Test(priority = 4, dependsOnMethods = "asosVerifySignInLandingPageElements", dataProvider = "emailIDData")
	public void asosVerifyEmaiIDInputBoxErrorHandling(String emailID, String status)
			throws IOException, InterruptedException {
		ffBrowser.findElement(By.xpath("//*[@id='EmailAddress']")).sendKeys(emailID);
		ffBrowser.findElement(By.xpath(".//*[@id='signin']")).click();
		Thread.sleep(100);
		if (status.equals("fail")) {
			Assert.assertTrue(ffBrowser.findElement(By.xpath("//*[@id='EmailAddress-error']")).isDisplayed());
		} else {
			Assert.assertFalse(isElementPresent(By.xpath("//*[@id='EmailAddress-error']")));
		}
		ffBrowser.findElement(By.xpath("//*[@id='EmailAddress']")).clear();
	}
	
	
/*
 * Create test to assert Password input box
 * Create test to sign in with valid exiting user and assert 
 * 
 * 
 * 
 */
	

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		ffBrowser.quit();
	}
	
	/*
	 * All data provider method
	 */
	
	@DataProvider(name = "emailIDData")
	public Object[][] provideData() {

		return new Object[][] { { "sdfsdf", "fail" }, { "", "fail" }, { "test@gmail.com", "pass" } };
	}
	
	/*
	 * Common methods to use
	 */

	private void takeScreenShots() throws IOException {
		TakesScreenshot scrShot = ((TakesScreenshot) ffBrowser);
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		// Move image file to new destination
		System.out.println(System.getProperty("user.dir") + "/screeShot.png");
		File DestFile = new File(System.getProperty("user.dir") + "/screeShot.png");
		// Copy file at destination
		FileUtils.copyFile(SrcFile, DestFile);
	}

	/*
	 * is the webelement present on page
	 * return false if not 
	 */
	public boolean isElementPresent(By element) {
		try {
			ffBrowser.findElement(element);
		} catch (NoSuchElementException e) {
			return false;
		}
		return true;
	}

}
