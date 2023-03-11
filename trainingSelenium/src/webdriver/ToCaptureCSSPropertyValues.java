package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToCaptureCSSPropertyValues {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://demo.actitime.com/login.do");
		driver.findElement(By.id("loginButton")).click();
		Thread.sleep(3000);
		String errorColor = driver.findElement(By.xpath("//span[text()='Username or Password is invalid. Please try again.']")).getCssValue("color");
		System.out.println(errorColor);
		
		String actualColor="rgba(206, 1, 0, 1)";
		if(errorColor.equals(actualColor)) {
			System.out.println("color is correct");
		}
		driver.quit();
	}
}
