package webelement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToCountTotalProductsInWebPage {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.kalkifashion.com/");
		driver.findElement(By.partialLinkText("SALWAR KAMEEZ")).click();
		List<WebElement> totalProducts = driver.findElements(By.xpath("//form[@data-product]"));
		System.out.println(totalProducts.size());
		for(WebElement products:totalProducts) {
			System.out.println(products.getText());
		}
	}
}
