package webelement;

import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CompatabilityTestOnLinkedIn {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		FirefoxDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		
		driver.get("https://in.linkedin.com/");
		WebElement emailText = driver.findElement(By.xpath("//input[@id='session_key']"));
		WebElement passwordText = driver.findElement(By.xpath("//input[@id='session_password']"));
		
		Rectangle emailTextObject = emailText.getRect();
		Rectangle passwordTextObject = passwordText.getRect();
		
		if (emailTextObject.getX() == passwordTextObject.getX()) {
			System.out.println("properly alligned to the left");
		} else {
			System.out.println("Sign in allignment issue");
		}

		if (emailTextObject.getX() + emailTextObject.getWidth() == passwordTextObject.getX()
				+ passwordTextObject.getWidth()) {
			System.out.println("Sign In are of same size");
		} else {
			System.out.println("Sign In are differ in size");
		}

		if (emailTextObject.getY() + 3 <= passwordTextObject.getY()) {
			System.out.println("no overlapping");
		} else {
			System.out.println("Overlapping issue");
		}

	}

}
