package assignment;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RelianceDigital {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.get("https://www.reliancedigital.in/");
		driver.findElement(By.id("wzrk-confirm")).click();
		driver.findElement(By.xpath("//nav/ul/li[1]")).click();
		driver.findElement(By.linkText("Smartphones")).click();
		String parentId = driver.getWindowHandle();
		System.out.println(driver.getTitle());
		Set<String> allWindowIds = driver.getWindowHandles();
		allWindowIds.remove(parentId);
		for(String windowId:allWindowIds) {
			driver.switchTo().window(windowId);
			System.out.println(driver.getTitle());
		if(driver.getTitle().contains("Mobile Phones - Latest Mobiles Online at Best Prices - Reliance Digital")) {
			driver.findElement(By.xpath("//img[@alt='Smartwatches-Small-Banner-28_12_2022.jpg']")).click();
			
			driver.findElement(By.xpath("(//p[@class=\"sp__name\"])[1]")).click();
			driver.findElement(By.id("RIL_PDPInputPincode")).sendKeys("560078");
			driver.findElement(By.id("add_to_cart_main_btn")).click();
		    driver.close();
			break;
		}
		}
		

	}

}
