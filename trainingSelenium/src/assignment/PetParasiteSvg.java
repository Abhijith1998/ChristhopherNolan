package assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class PetParasiteSvg {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.get("https://petdiseasealerts.org/forecast-map#/");
		WebElement mapinstanceFrame = driver.findElement(By.xpath("//iframe[contains(@id,'map-instance')]"));
		driver.switchTo().frame(mapinstanceFrame);
		String state="florida";
		Thread.sleep(10000);
		Actions actions=new Actions(driver);
//		actions.moveByOffset(1256, 576).click().perform();
//		driver.findElement(By.xpath("//*[@id='10']")).click();
		driver.findElement(By.xpath("//*[name()='svg' and @id]//*[name()='g' and @id='"+state+"']")).click();	
	}
}