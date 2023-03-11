package actions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ToDragAndDropSQA {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.get("https://www.globalsqa.com/demo-site/draganddrop/#Photo%20Manager");
		Actions actions = new Actions(driver);
		WebElement frame1 = driver.findElement(By.xpath("//title[text()='Selenium Practice Droppable - Simple photo manager']"));
		driver.switchTo().frame(frame1);
		WebElement image1 = driver.findElement(By.xpath("//img[@alt=\"The peaks of High Tatras\"]"));
		WebElement trash = driver.findElement(By.id("trash"));
		actions.clickAndHold(image1).moveToElement(trash).perform();
	}
}