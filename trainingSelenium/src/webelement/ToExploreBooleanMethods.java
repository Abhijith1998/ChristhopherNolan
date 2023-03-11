package webelement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToExploreBooleanMethods {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.instagram.com/");
		Thread.sleep(2000);
		WebElement username = driver.findElement(By.name("username"));
		username.sendKeys("Abhijith");
		Thread.sleep(2000);
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("Abhi@1998");
		Thread.sleep(2000);
		WebElement LoginButton = driver.findElement(By.xpath("//button[.='Log in']"));
		
		System.out.println(LoginButton.isDisplayed());
		System.out.println(LoginButton.isSelected());
		System.out.println(LoginButton.isEnabled());
	}
}