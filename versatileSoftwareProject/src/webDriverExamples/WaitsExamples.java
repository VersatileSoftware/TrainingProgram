package webDriverExamples;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.james.mime4j.field.datetime.DateTime;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WaitsExamples {

	// Implicit Wait: During Implicit wait if the Web Driver cannot find it
	// immediately because of its availability, it will keep polling (around 250
	// milli seconds) the DOM to get the element. If the element is not
	// available within the specified Time an NoSuchElementException will be
	// raised. The default setting is zero. Once we set a time, the Web Driver
	// waits for the period of the WebDriver object instance.

	// Explicit Wait: There can be instance when a particular element takes more
	// than a minute to load. In that case you definitely not like to set a huge
	// time to Implicit wait, as if you do this your browser will going to wait
	// for the same time for every element.
	//
	// To avoid that situation you can simply put a separate time on the
	// required element only. By following this your browser implicit wait time
	// would be short for every element and it would be large for specific
	// element.
	//

	// Fluent Wait: Let’s say you have an element which sometime appears in just
	// 1 second and some time it takes minutes to appear. In that case it is
	// better to use fluent wait, as this will try to find element again and
	// again until it find it or until the final timer runs out.

	private WebDriver ffBrowser;
	private String baseUrl;

	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		ffBrowser = new FirefoxDriver();
		baseUrl = "http://www.bbc.com/";
		// Implicit test indicates how long webdriver should wait before
		// throwinh no element found exception
		ffBrowser.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}

	/*
	 * get and navigate in selenium Close
	 */
	@Test
	public void waitElemetsExamples() throws InterruptedException {
		ffBrowser.navigate().to(baseUrl);
		ffBrowser.manage().window().maximize();
		ffBrowser.findElement(By.xpath("//*[@id='orb-modules']/div[2]/section[2]/div/div/p[2]/a"));

		// Explicit wait
		Date d = new Date();
		WebDriverWait explicitWait = new WebDriverWait(ffBrowser, 10);
		ffBrowser.findElement(By.xpath("//*[@id='orb-nav-more']/a")).click();
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='orb-panel-more']/div")));
		List<WebElement> allLinks = ffBrowser.findElement(By.xpath("//*[@id='orb-panel-more']/div"))
				.findElements(By.tagName("a"));
		for (WebElement webElement : allLinks) {
			System.out.println("In wait:" + webElement.getText());
		}
		ffBrowser.navigate().refresh();

		// Fluent wait
		Wait fWait = new FluentWait<>(10).withTimeout(10, TimeUnit.SECONDS).pollingEvery(1, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);
		System.out.println("Before wait " + d);
		ffBrowser.findElement(By.xpath("//*[@id='orb-nav-more']/a")).click();

		// fWait.until(
		// (By.xpath("//*[@id='orb-panel-more']/div")).isDisplayed());
		ffBrowser.close();

	}

}
