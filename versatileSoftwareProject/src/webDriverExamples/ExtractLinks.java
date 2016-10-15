package webDriverExamples;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ExtractLinks {

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

	/**
	 * @throws InterruptedException
	 */
	@Test
	public void linksTest() throws InterruptedException {

		// acess the links with the exact text match
		// if we have two links it accesses only the first one
		ffBrowser.findElement(By.linkText("WOMEN")).click();

		Thread.sleep(1000);
		// Partial text match
		ffBrowser.findElement(By.partialLinkText("MEN")).click();
		Thread.sleep(1000);

		// Image links only by xpath or css only
		ffBrowser.findElement(By.xpath("//*[@id='logo']/img")).click();

		// Extract all links
		List<WebElement> allNavigationElements = ffBrowser.findElement(By.className("floor-menus"))
				.findElements(By.tagName("a"));
		for (WebElement webElement : allNavigationElements) {
			System.out.println(webElement.getText() + "  " + webElement.getAttribute("href"));
		}

		ffBrowser.close();
	}

}
