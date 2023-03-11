package basics;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import genericLibraries.Utility;

public class Dream11 {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("https://www.dream11.com/");
		
		driver.switchTo().frame(0);
		driver.findElement(By.id("regEmail")).sendKeys("7892814987");
//		driver.findElement(By.id("regUser")).click();
		driver.switchTo().defaultContent();
		driver.findElement(By.linkText("About Us")).click();
		
		Utility util=new Utility();
		System.out.println(util.readDataInStringFromat("DemoWebShop", "Sheet1", 1, 0));

	}
}
