package webdriver;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToSwitchTheDriverControlInShopperStack {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://shoppersstack.com/products_page/11");
		Thread.sleep(10000);
		
		driver.findElement(By.id("fl_compare")).click();
		Thread.sleep(8000);
		
		Set<String> allWindowids = driver.getWindowHandles();
		
		for(String windowId:allWindowids) {
			driver.switchTo().window(windowId);
			String titleOfThePage = driver.getTitle();
			if(titleOfThePage.contains("amazon")) {
				driver.close();
				break;
			}
		}
	}
}
