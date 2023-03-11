package assignment;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Flipkart {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		String parentWindowId = driver.getWindowHandle();
		String parentTilte = driver.getTitle();
		
       driver.findElement(By.linkText("Mobiles")).click();
       driver.findElement(By.xpath("//div[@class=\"_1YokD2 _3Mn1Gg col-10-12\"]/div[1]/div/div/div/div/div/div[1]")).click();
       driver.findElement(By.xpath("//div[@data-id=\"MOBGBTHFSKHF8RAU\"]/div/a/div[2]/div[1]/div")).click();
       Set<String> allWindowIds = driver.getWindowHandles();
       allWindowIds.remove(parentWindowId);
       for (String windowId : allWindowIds) {
		driver.switchTo().window(windowId);
		driver.findElement(By.xpath("//button[text()='Add to cart']")).click();
		driver.close();
		break;
       }
       driver.switchTo().window(parentWindowId);
		
//		Actions actions = new Actions(driver);
//		actions.moveToElement(driver.findElement(By.xpath("//span[text()='Electronics']"))).perform();
//		driver.findElement(By.xpath("//a[@title='Headphones & Headsets']")).click();
//		driver.findElement(By.xpath("//div[text()='Reviews for Popular Headset']/..//div/div/div[2]/a/div")).click();
//		Set<String> allWindowIds = driver.getWindowHandles();
//		for (String windowId : allWindowIds) {
//			String titleOfThePage = driver.getTitle();
//			System.out.println(titleOfThePage);
//			if (!(titleOfThePage.contains(parentTilte))){
//				driver.switchTo().window(windowId);
//				
//			}
//		}

//		driver.navigate().refresh();
//		
//		allWindowIds = driver.getWindowHandles();

//		allWindowIds.remove(parentWindowId);
//		switchDriverControl(driver, allWindowIds);

	}
	/*
	 * public static void priceConversion(String price) { price=price.substring(1,
	 * price.length()); price.replace(",", ""); System.out.println(price); }
	 */
}
