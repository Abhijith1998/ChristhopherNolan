package assesment;
/***
 * @author abhis
 */
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToCloseWindowsInAlphabeticalOrder {

	public static <E> void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.get("http://shoppersstack.com/");
		Thread.sleep(10000);
		driver.findElement(By.xpath("//span[text()='APPLE 2021 Macbook Pro M1 Max']")).click();
		driver.navigate().refresh();
		driver.findElement(By.id("fl_compare")).click();
		
		Map<String, String> titleAndWindowId=new TreeMap<String,String>();
		Set<String> allWindowIds = driver.getWindowHandles();
		for(String windowId:allWindowIds) {
			driver.switchTo().window(windowId);
			titleAndWindowId.put(driver.getTitle().toLowerCase().replace("www.", ""), windowId);	
		}
	
		Set<String> allKeys = titleAndWindowId.keySet();
		for(String key:allKeys) {
			driver.switchTo().window(titleAndWindowId.get(key));
			driver.close();
			Thread.sleep(1000);
		}
		driver.quit();
	}
}
