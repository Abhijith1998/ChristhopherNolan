package actions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ToMoveMouseOnElement {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.get("https://www.kalkifashion.com/");
		Actions actions=new Actions(driver);
		WebElement salwarKameez = driver.findElement(By.partialLinkText("SALWAR KAMEEZ"));
		actions.moveToElement(salwarKameez).perform();
		driver.findElement(By.linkText("Haldi Salwar Kameez")).click();
	}
}
