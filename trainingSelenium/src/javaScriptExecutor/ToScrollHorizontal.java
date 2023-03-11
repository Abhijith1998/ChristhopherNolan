package javaScriptExecutor;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToScrollHorizontal {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		driver.get("https://www.album.alexflueras.ro/galleries/urban.html");
		JavascriptExecutor js=(JavascriptExecutor) driver;
		for(;;) {
			try {
				driver.findElement(By.id("a21")).click();
				break;
			} catch (Exception e) {
			js.executeScript("window.scrollBy(50,0)");
			}
		}	
	}
}