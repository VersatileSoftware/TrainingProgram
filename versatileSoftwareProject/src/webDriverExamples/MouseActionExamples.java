
package webDriverExamples;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MouseActionExamples {

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
	 * @throws AWTException
	 */
	@Test
	public void mouseActionTest() throws InterruptedException, AWTException {

		// Handling special keyboard and mouse events are done using the
		// Advanced User Interactions API
		Thread.sleep(100);
		WebElement homeLogo = ffBrowser.findElement(By.className("selected"));
		// 3 steps to do this
		// Instantate Action object
		// Call the action and perfomr
		System.out.println("Before the Mouse over" + homeLogo.getCssValue("color"));
		Actions mouseAction = new Actions(ffBrowser);
		mouseAction.moveToElement(homeLogo).perform();
		System.out.println("Before the Mouse over" + homeLogo.getCssValue("color"));
		
		//Move the mouse over women
//		mouseAction.moveToElement(ffBrowser.findElement(By.xpath("//*[@id='BodyTag']/div[4]/div/header/div[5]/nav/ul/li[2]/a"))).perform();
//		mouseAction.moveToElement(ffBrowser.findElement(By.xpath("//*[@id='BodyTag']/div[4]/div/header/div[5]/nav/ul/li[2]/div/dl[3]/dd/ul/li[6]/a"))).perform();
//		Thread.sleep(1000);
//		ffBrowser.findElement(By.xpath("//*[@id='BodyTag']/div[4]/div/header/div[5]/nav/ul/li[2]/div/dl[3]/dd/ul/li[6]/a")).click();

		// Keydown or up
		// This moves your up and down arrow from keyboard
		WebElement searchInputBox = ffBrowser.findElement(By.id("txtSearch"));
		// searchInputBox.sendKeys("women");
		mouseAction.moveToElement(searchInputBox).click().sendKeys("women").perform();
		Thread.sleep(100);
		for (int i = 0; i < 5; i++) {
			mouseAction.click(searchInputBox).sendKeys(Keys.ARROW_DOWN).perform();
			Thread.sleep(1000);
		}
		searchInputBox.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		mouseAction.sendKeys(Keys.PAGE_DOWN);
		mouseAction.doubleClick(ffBrowser.findElement(By.xpath("//*[@for='emailAddress']"))).perform();
		Thread.sleep(1000);

		// When Selenium cannot handle the keyboard comands we can use Robot API
		// Robot API can simulate Keyboard and Mouse Event
		// Robot API can help in upload/download of files when using selenium
		// web driver

		String filePathtoUpload = System.getProperty("user.dir") + "\\src\\TestUploadFile.txt";
		System.out.println(filePathtoUpload);
		// Copy the path t0 ClipboardData
		StringSelection stringSelection = new StringSelection(filePathtoUpload);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

		ffBrowser.get("https://uploadfiles.io/");
		ffBrowser.findElement(By.xpath(".//*[@id='upload-window']")).click();

		// Use robot
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(10000);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		ffBrowser.close();

	}

}
