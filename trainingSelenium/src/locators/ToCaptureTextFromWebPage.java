package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToCaptureTextFromWebPage {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://demowebshop.tricentis.com/login");
		driver.findElement(By.xpath("//input[@class=\"button-1 login-button\"]")).submit();
		Thread.sleep(3000);
		String errorMessage = driver.findElement(By.xpath("//div[@class=\"validation-summary-errors\"]")).getText();
		
		String actualErrormsg="Login was unsuccessful. Please correct the errors and try again.";
		
		if(errorMessage.equals(actualErrormsg)) {
			System.out.println("proper error message");
		}
		else {
			System.out.println("error is not correct");
		}
	}
}
