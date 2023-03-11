package practice;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class PolarBear {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://polarbear.co.in/");
		Thread.sleep(2000);
		driver.findElement(By.linkText("Menu")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Chocolate Sundaes")).click();
		Thread.sleep(2000);
		String parentWindowId = driver.getWindowHandle();
		driver.findElement(By.partialLinkText("Brownie Fudge")).click();
		
		Set<String> allWindowIds = driver.getWindowHandles();
		allWindowIds.remove(parentWindowId);
		
		for(String windowId:allWindowIds) {
			driver.switchTo().window(windowId);
		}
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector("div[class=\"primary-cta md-text16 md-f700 location-action-cta\"]")).click();
	}
}
