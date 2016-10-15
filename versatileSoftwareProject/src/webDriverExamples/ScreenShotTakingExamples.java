package webDriverExamples;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ScreenShotTakingExamples {

	private WebDriver ffBrowser;
	private String baseUrl;

	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		ffBrowser = new FirefoxDriver();
		baseUrl = "http://www.bbc.com/";
		ffBrowser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Test
	public void findElementExamples() throws InterruptedException, IOException {
		ffBrowser.navigate().to(baseUrl);
		ffBrowser.manage().window().maximize();

		try {
			ffBrowser.findElement(By.id("sdfsdfdsdd"));
		} catch (Throwable t) {
			t.printStackTrace();
			TakesScreenshot scrShot = ((TakesScreenshot) ffBrowser);
			File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
			// Move image file to new destination
			System.out.println(System.getProperty("user.dir") + "/screeShot.png");
			File DestFile = new File(System.getProperty("user.dir") + "/screeShot.png");
			// Copy file at destination
			FileUtils.copyFile(SrcFile, DestFile);
			ffBrowser.close();
		}

	}

}
