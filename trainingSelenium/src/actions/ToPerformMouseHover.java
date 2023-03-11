package actions;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ToPerformMouseHover {

	public static void main(String[] args) throws InterruptedException {
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
		Actions actions = new Actions(driver);
		Thread.sleep(3000);
		actions.moveByOffset(405, 155).contextClick().perform();
		WebElement textOptions = driver.findElement(By.xpath("//div[@class='quick-card-editor-buttons fade-in']"));
		System.out.println(textOptions.getText());
		driver.quit();
	}
}
