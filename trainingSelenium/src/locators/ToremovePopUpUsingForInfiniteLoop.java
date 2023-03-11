package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToremovePopUpUsingForInfiniteLoop {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.woodenstreet.com/");
		for(;;) {
			try {
				driver.findElement(By.id("loginclose1")).click();
				break;
			} catch (NoSuchElementException e) {
				Thread.sleep(1000);
			}
		}
		driver.findElement(By.cssSelector("img[title='Wooden Sofas Online Furniture']")).click();
	}
}