package webelement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToLocateMultipleElements {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.kalkifashion.com/");
		List<WebElement> navBarElements = driver.findElements(By.xpath("//nav[not(@id='mobile-nav')]/div/div[2]/div"));
		System.out.println(navBarElements.size());
		for (WebElement navEle : navBarElements) {
			System.out.println(navEle.getText());
		}
	}
}
