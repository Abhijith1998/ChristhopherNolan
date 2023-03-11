package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoWebShop {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://demowebshop.tricentis.com/");
		Thread.sleep(5000);
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.id("gender-male")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("FirstName")).sendKeys("Abhijith");
		Thread.sleep(2000);
		driver.findElement(By.id("LastName")).sendKeys("S");
		Thread.sleep(2000);
		driver.findElement(By.id("Email")).sendKeys("abhishiva1998@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.id("Password")).sendKeys("Rolex@1998");
		Thread.sleep(2000);
		driver.findElement(By.id("ConfirmPassword")).sendKeys("Rolex@1998");
		Thread.sleep(2000);
		driver.findElement(By.id("register-button")).click();
		
		
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys("abhishiva1998@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("Rolex@1998");
		driver.findElement(By.id("RememberMe")).click();
		Thread.sleep(10000);
		driver.findElement(By.name("button-1 login-button")).click();
		
		
		
		

	}

}
