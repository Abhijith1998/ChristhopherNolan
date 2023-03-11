package javaScriptExecutor;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ToExploreScrollIntoViewMethod {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get("https://shoppersstack.com/");
		Thread.sleep(15000);
		WebElement swagerDocumetation = driver.findElement(By.partialLinkText("Swagger Documentation"));
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", swagerDocumetation);
//		swagerDocumetation.click();
		
		driver.get("https://www.naukri.com/registration/createAccount");
		String scrollInto="scrollIntoView(true)";
		js.executeScript("document.getElementById('mobile').arguments[0]",scrollInto);
	}
}