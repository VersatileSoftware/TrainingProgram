package webDriverExamples.webDriverGridExamples;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;

public class InvokeTestOnGrid {

	private WebDriver ffBrowser;
	private String baseUrl;
	private String hubUrl;

	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		hubUrl = "http://localhost:4445/wd/hub";
		baseUrl = "http://www.bbc.com/";
		DesiredCapabilities browserType = DesiredCapabilities.firefox();
		browserType.setBrowserName(BrowserType.FIREFOX);
		ffBrowser = new RemoteWebDriver(new URL(hubUrl), browserType);
		ffBrowser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Test
	public void bbcHomePageTests() throws InterruptedException {
		ffBrowser.get(baseUrl);
		ffBrowser.findElement(By.linkText("BBC"));
		Thread.sleep(1000);
	}

	@AfterClass
	public void afterClass() {
		ffBrowser.quit();
	}

}
