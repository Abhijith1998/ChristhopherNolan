package webelement;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToUseEnums {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://demowebshop.tricentis.com/register");
		WebElement passwordText = driver.findElement(By.id("Password"));
		Thread.sleep(2000);
		passwordText.sendKeys("Abhi@1998",Keys.CONTROL+"a");
		
		passwordText.sendKeys(Keys.CONTROL+"c");
		Thread.sleep(2000);
		WebElement confirmPassword = driver.findElement(By.id("ConfirmPassword"));
		confirmPassword.sendKeys(Keys.CONTROL+"v");
		Thread.sleep(2000);
		confirmPassword.sendKeys(Keys.ENTER);
		

	}

}
