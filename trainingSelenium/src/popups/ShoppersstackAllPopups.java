package popups;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ShoppersstackAllPopups {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get("https://shoppersstack.com/");
		Thread.sleep(15000);
		Actions actions=new Actions(driver);
		for(;;) {
			try {
				driver.findElement(By.partialLinkText("Swagger Documentation")).click();
				break;
			} catch (Exception e) {
				actions.sendKeys(Keys.PAGE_DOWN).perform();
			}
		}
		Alert alertPopup = driver.switchTo().alert();
		System.out.println(alertPopup.getText());
		alertPopup.accept();
		alertPopup.sendKeys("");
		alertPopup.accept();
		alertPopup.sendKeys("");
		alertPopup.accept();
		System.out.println(alertPopup.getText());
		alertPopup.accept();	
	}

}
