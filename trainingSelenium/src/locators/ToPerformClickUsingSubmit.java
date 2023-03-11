package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToPerformClickUsingSubmit {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		Thread.sleep(3000);
		driver.get("https://demowebshop.tricentis.com/register");
		driver.findElement(By.id("small-searchterms")).sendKeys("Abhijith");
		driver.findElement(By.xpath("//input[@value='Search']")).submit();
	}
}
