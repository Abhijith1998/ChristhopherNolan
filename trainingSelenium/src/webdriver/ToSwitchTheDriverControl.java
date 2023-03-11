package webdriver;

import java.util.Set;

import org.openqa.selenium.chrome.ChromeDriver;

public class ToSwitchTheDriverControl {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.skillrary.com/");
		Thread.sleep(4000);
		
		Set<String> windowHandles = driver.getWindowHandles();
		for(String windowId:windowHandles) {
			driver.switchTo().window(windowId);
			if(driver.getTitle().contains("Original Italiano")) {
				driver.close();
				break;
			}
		}
	}
}