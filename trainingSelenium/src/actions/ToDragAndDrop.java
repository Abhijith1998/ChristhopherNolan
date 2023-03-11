package actions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ToDragAndDrop {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		WebDriverWait explicitWait = new WebDriverWait(driver, 15);

		driver.get("https://trello.com/");
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("user")).sendKeys("abhishiva1998@gmail.com");
		driver.findElement(By.id("login")).click();
		explicitWait.until(ExpectedConditions.elementToBeClickable(By.id("login-submit")));
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("abhijith.s7598");
		driver.findElement(By.id("login-submit")).click();
		driver.findElement(By.xpath("//div[text()='Train the Trainers']")).click();
		WebElement sourceEle1 = driver.findElement(By.partialLinkText("Mock Scheduled"));
		WebElement targetEle1 = driver.findElement(By.xpath("//h2[text()='Manual']/../..//span[text()='Add a card']"));
		Actions actions = new Actions(driver);
		actions.dragAndDrop(sourceEle1, targetEle1).perform();
		
		WebElement sourceEle2 = driver.findElement(By.partialLinkText("Mock Completed"));
		actions.dragAndDropBy(sourceEle2, 920, 0).perform();
		
		WebElement sourceEle3 = driver.findElement(By.partialLinkText("Mock Pending"));
		WebElement targetEle3 = driver.findElement(By.xpath("//h2[text()='Java']/../..//span[text()='Add a card']"));
		actions.moveToElement(sourceEle3).clickAndHold().release(targetEle3).perform();
		
		
		
	}

}
