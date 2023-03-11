package assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomationScriptForDemoWebShop {

	public static void main(String[] args) {
		// Test data
		String expectedHomePage = "Demo Web Shop";
		String expectedAlertMessage = "Please enter some search keyword";

		// Step 1:Open the Browser
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		System.out.println("Chrome Browser is launched succesfully");
		driver.manage().window().maximize();
		System.out.println("Browser is maximized");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		//step 2:Enter the Url and Click on 'Enter' button
		driver.get("https://demowebshop.tricentis.com/");
		String actualHomePage = driver.getTitle();
		if(expectedHomePage.equals(actualHomePage)) {
			System.out.println("Home page displayed successfully");
		}
		else {
			System.out.println("Home page is not displayed");
		}
		
		//step 3:Click on 'Search' button
		driver.findElement(By.xpath("//input[@value=\"Search\"]")).click();
		Alert alertPopup = driver.switchTo().alert();
		System.out.println("Alert Pop up is Displayed");
		
		//step 4:verify the Message is displayed properly or not
		String actualAlertMessage = alertPopup.getText();
		if (expectedAlertMessage.equals(actualAlertMessage)) {
			System.out.println("Alert message displayed properly ");
		} else {
			System.out.println("Alert message is incorrect");
		}
		alertPopup.accept();
		driver.quit();
	}

}
