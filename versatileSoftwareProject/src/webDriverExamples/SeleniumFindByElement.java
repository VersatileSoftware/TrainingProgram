package webDriverExamples;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SeleniumFindByElement {

	private WebDriver ffBrowser;
	private String baseUrl;

	@BeforeClass(alwaysRun = true)
	private void setUp() throws Exception {
		ffBrowser = new FirefoxDriver();
		baseUrl = "http://www.bbc.com/";
		ffBrowser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		ffBrowser.navigate().to(baseUrl);
		ffBrowser.manage().window().maximize();
	}

	/*
	 * get and navigate in selenium Close
	 */
	@Test
	public void findElementExamples() throws InterruptedException {
	
		/*
		 * Locating GUI elements on the page using find by className Id
		 * 
		 * 
		 * 
		 */
		System.out.println(ffBrowser.findElement(By.id("orb-nav-more")).getText());
		System.out.println(ffBrowser.findElement(By.className("orb-nav-iplayer")).getText());
		System.out.println(ffBrowser.findElement(By.cssSelector("#orb-nav-more")).getText());
		System.out.println(ffBrowser.findElement(By.name("q")).getText());
		System.out.println(ffBrowser.findElement(By.linkText("Radio")).getText());
		System.out.println(ffBrowser.findElement(By.xpath("//*[@id='orb-header']/div[1]/div[1]/a")).getText());

		// Sending values to input boxes
		ffBrowser.findElement(By.name("q")).sendKeys("Bake off");
		ffBrowser.findElement(By.xpath("//*[@id='orb-search-q']")).click();
		Thread.sleep(100);
		ffBrowser.findElement(By.name("q")).clear();
		ffBrowser.findElement(By.name("q")).sendKeys("India");
		ffBrowser.findElement(By.xpath("//*[@id='orb-search-q']")).submit();
		Thread.sleep(100);

		

	}
	
	@AfterClass
	private void tearDown(){
		ffBrowser.close();
	}

}
