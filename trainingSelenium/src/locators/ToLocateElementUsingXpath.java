package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToLocateElementUsingXpath {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://pizzaonline.dominos.co.in/");
		Thread.sleep(3000);
		for(;;) {
			try {
				driver.findElement(By.xpath("//span[text()=\"Locate Me\"]")).click();
			}catch (ElementClickInterceptedException e) {
				// TODO: handle exception
				Thread.sleep(1000);
			}
		}
	}
}