package wait;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ToUnderstandImplicitWait {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://www.shoppersstack.com/products_page/6");
		driver.findElement(By.xpath("//label[text()='Check Delivery']/..//input")).sendKeys("560010");	
		
		WebDriverWait explicitWait=new WebDriverWait(driver, 15);
		explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='Check Delivery']/..//input")));
	}
}