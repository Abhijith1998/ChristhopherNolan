package testNG;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
/**
 * 
 * @author abhijith
 *
 */

public class ToExploreAnnotation {

	@Test(timeOut = 2000)
	public void launchDemoWebShop() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/");
		Thread.sleep(3000);
		driver.get("https://www.rediff.com/");
		driver.quit();
	}
	
	@Test(enabled = false)
	public void launchWoodenStreet() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.woodenstreet.com/");
		driver.quit();
	}
	
	@Test(priority=-2,invocationCount = 3,threadPoolSize = 2 )
	public void makeMyTrip() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		driver.quit();
	}
	
	@Test(priority=2,invocationCount = 3)
	public void flipKart() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.quit();
	}
}
