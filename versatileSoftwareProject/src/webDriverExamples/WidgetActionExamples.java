package webDriverExamples;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WidgetActionExamples {

	private WebDriver ffBrowser;
	private String baseUrl;

	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		ffBrowser = new FirefoxDriver();
		baseUrl = "http://www.asos.com/";
		ffBrowser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		ffBrowser.get(baseUrl);
		ffBrowser.manage().window().maximize();
		ffBrowser.findElement(By.xpath("//*[@id='anonymous']/a[1]")).click();
	}

	/**
	 * @throws InterruptedException
	 */
	@Test
	public void widgetActionsTests() throws InterruptedException {

		// Input Box
		ffBrowser.findElement(By.id("Email")).sendKeys("testVersatile@gmail.com");
		ffBrowser.findElement(By.id("FirstName")).sendKeys("Test");
		ffBrowser.findElement(By.id("LastName")).sendKeys("Selenium");
		ffBrowser.findElement(By.id("Password")).sendKeys("aaaA!12345678901234567890");
		
		Thread.sleep(10000);
		// DropDown
		WebElement dateDropDown = ffBrowser.findElement(By.xpath("//*[@id='BirthDay']"));
		Select dateDownSignIn = new Select(dateDropDown);
		// based on value attribute
		dateDownSignIn.selectByValue("4");

		// Based visible text
		Select monthDropDownSignIn = new Select(ffBrowser.findElement(By.id("BirthMonth")));
		monthDropDownSignIn.selectByIndex(10);
		Thread.sleep(10000);
		// Select by Index
		Select yearDropDownSignIn = new Select(ffBrowser.findElement(By.id("BirthYear")));
		yearDropDownSignIn.selectByVisibleText("1984");

		Thread.sleep(1000);
		dateDownSignIn.selectByValue("20");

		// Radio Button
		ffBrowser.findElement(By.xpath(".//*[@id='main']/div[1]/div[2]/form/fieldset/div[6]/div[2]")).click();
		System.out.println("Radio Buton is selected??"+ffBrowser.findElement(By.xpath(".//*[@id='main']/div[1]/div[2]/form/fieldset/div[6]/div[2]")).isSelected());
		// Check Boxes
		System.out.println("Before Checkbx Click "+ffBrowser.findElement(By.xpath("//*[@id='main']/div[1]/div[2]/form/fieldset/div[7]/div[2]/label")).isSelected());
		ffBrowser.findElement(By.xpath("//*[@id='main']/div[1]/div[2]/form/fieldset/div[7]/div[2]/label")).click();
		System.out.println("After Checkbx Click "+ffBrowser.findElement(By.xpath("//*[@id='main']/div[1]/div[2]/form/fieldset/div[7]/div[2]/label")).isSelected());
		
		// Submit form
		ffBrowser.findElement(By.id("register")).submit();

		ffBrowser.quit();
	}

}
