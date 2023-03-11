package assesment;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class ToCaptureEbayWindow {

	public static void main(String[] args) throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://shoppersstack.com/products_page/11");//products_page/11
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Thread.sleep(15000);
//		driver.findElement(By.xpath("//span[text()='APPLE 2021 Macbook Pro M1 Max']")).click();
		TakesScreenshot ts=(TakesScreenshot) driver;
		driver.findElement(By.id("fl_compare")).click();
		Set<String> allWindowIds = driver.getWindowHandles();
		for(String windowId:allWindowIds) {
			driver.switchTo().window(windowId);
			String titleOfThePage = driver.getTitle();
			if(titleOfThePage.contains("ebay")) {
				File screenShot = ts.getScreenshotAs(OutputType.FILE);
				FileHandler.copy(screenShot, new File("./errorShots/ebay.png"));
				break;
			}
		}

	}

}
