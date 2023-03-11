package javaScriptExecutor;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToHnadleDisabledElements {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		// enter data into disabled text box
		driver.get("https://demoapp.skillrary.com/");
		WebElement disabledTextBox = driver.findElement(By.xpath("//input[@class='form-control']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='Entering data into disabled Text box';", disabledTextBox);

		// click on disabled button
		driver.get("https://www.oracle.com/in/java/technologies/downloads/");
		driver.findElement(By.linkText("jdk-8u361-linux-x64.tar.gz")).click();
		WebElement disabledButton = driver.findElement(By.linkText("Download jdk-8u361-linux-x64.tar.gz"));
		// clicking on disabled button, it will take me to sign in page
		js.executeScript("arguments[0].click()", disabledButton);

	}
}