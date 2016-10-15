package webDriverExamples;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WindowsAlertsIframesExamples {
	// Alerts, popup

	// 1. Iframe
	// What is Iframe?
	// A web page which is embedded in another web page or an HTML document
	// embedded inside another HTML document is known as a frame.
	// Identify and move to iframe

	private WebDriver ffBrowser;
	private String iframeUrlHomepage;
	private String asosUrl;

	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		ffBrowser = new FirefoxDriver();
		iframeUrlHomepage = "http://www.javascriptkit.com/howto/externalhtml.shtml";
		asosUrl = "http://www.asos.com/";
		// Implicit test indicates how long webdriver should wait before
		// throwinh no element found exception
		ffBrowser.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}

	@Test
	public void waitElemetsExamples() throws InterruptedException {
		ffBrowser.navigate().to(iframeUrlHomepage);
		ffBrowser.manage().window().maximize();

		// IFRAME
		ffBrowser.switchTo().frame("internal");
		ffBrowser.findElement(By.className("b_searchboxForm")).sendKeys("TEST");
		Thread.sleep(100);
		ffBrowser.switchTo().defaultContent();
		ffBrowser.navigate().refresh();

		ffBrowser.switchTo().frame(0);
		ffBrowser.findElement(By.className("b_searchboxForm")).sendKeys("TEST");
		Thread.sleep(100);
		ffBrowser.switchTo().defaultContent();

		// Alerts
		// Alert is a small message box which displays on-screen notification to
		// give the user some kind of information or ask for permission to
		// perform certain kind of operation. It may be also used for warning
		// purpose.
		// ffBrowser.switchTo().alert().accept();

		// WINDOW //POPUP handling
		ffBrowser.navigate().to(asosUrl);
		ffBrowser.manage().window().maximize();
		ffBrowser.findElement(By.xpath("//*[@id='anonymous']/a[2]")).click();
		ffBrowser.findElement(By.xpath("//*[@id='signup-facebook']/div/div[2]")).click();

		String MainWindow = ffBrowser.getWindowHandle();
		System.out.println("Parent Window Identifier"+MainWindow);
		
		Thread.sleep(10000);
		// To handle all new opened window.
		Set<String> allWindowHandler = ffBrowser.getWindowHandles();
		Iterator<String> eachWindowHandlerIterator = allWindowHandler.iterator();

		while (eachWindowHandlerIterator.hasNext()) {
			
			String ChildWindow = eachWindowHandlerIterator.next();
			System.out.println(ChildWindow);
			if (!MainWindow.equalsIgnoreCase(ChildWindow)) {
				// Switching to Child window
				ffBrowser.switchTo().window(ChildWindow);
				ffBrowser.findElement(By.xpath("//*[@id='email']")).sendKeys("guruK@gmail.com");
				Thread.sleep(1000);
				ffBrowser.close();
			}
		}
		ffBrowser.switchTo().window(MainWindow);
		
		ffBrowser.close();

	}
}
