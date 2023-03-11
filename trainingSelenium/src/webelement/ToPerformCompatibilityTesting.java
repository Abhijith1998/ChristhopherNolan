package webelement;

import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToPerformCompatibilityTesting {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.facebook.com/");

		WebElement googleSignIn = driver.findElement(By.xpath("//input[@id='email']"));

		WebElement appleSignIn = driver.findElement(By.xpath("//input[@id='passContainer']"));

		Rectangle googleRectObject = googleSignIn.getRect();
		Rectangle appleRectObject = appleSignIn.getRect();

		if (googleRectObject.getX() == appleRectObject.getX()) {
			System.out.println("properly alligned to the left");
		} else {
			System.out.println("Sign in allignment issue");
		}

		if (googleRectObject.getX() + googleRectObject.getWidth() == appleRectObject.getX()
				+ appleRectObject.getWidth()) {
			System.out.println("Sign In are of same size");
		} else {
			System.out.println("Sign In are differ in size");
		}

		if (googleRectObject.getY() + 3 <= appleRectObject.getY()) {
			System.out.println("no overlapping");
		} else {
			System.out.println("Overlapping issue");
		}
	}

}
