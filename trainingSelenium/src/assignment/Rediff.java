package assignment;
/**
 * @author abhis
 */

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Rediff {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.get("https://www.rediff.com/");
		driver.findElement(By.linkText("Sign in")).click();
		driver.findElement(By.id("login1")).sendKeys("sumanthelfbatch@rediffmail.com");
		driver.findElement(By.id("password")).sendKeys("Testing@123");
		driver.findElement(By.name("proceed")).click();
		driver.findElement(By.xpath("//b[text()='Write mail']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Enter name or email' and @id='TO_IDcmp2']")).sendKeys("sumanthelfbatch@rediffmail.com");
		driver.findElement(By.xpath("//input[@class='rd_inp_sub rd_subject_datacmp2']")).sendKeys("Abhijith");
		driver.switchTo().frame(1);
		driver.findElement(By.tagName("body")).sendKeys("welcome to Automation");
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//a[text()='Send']")).click();
		for(;;) {
			try {
				 driver.findElements(By.xpath("//span[@title='Abhijith']/..//cite[@title='Select mail']"));
				 break;
			} catch (NoSuchElementException e) {
				driver.findElement(By.xpath("//cite[@title='Refresh Inbox']")).click();
			}
		}
		//driver.findElement(By.xpath("//div[@id=\"div_captcha_compose_view\"]/..//span[@class=\"ui-button-icon-primary ui-icon ui-icon-closethick\"]")).click();
		driver.findElement(By.xpath("//span[text()='Delete']")).click();
		driver.findElement(By.xpath("//button[text()='Ok']")).click();
		System.out.println(driver.findElement(By.id("rdNotify")).getText());
//		driver.quit();	
	}
}
