package webelement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToCountSearchBarElementsInKalki {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.kalkifashion.com/");
		driver.findElement(By.xpath("//input[@id='search-input']")).click();
		Thread.sleep(10000);
		List<WebElement> searchbarElements = driver.findElements(By.xpath("//ul[@class='click-suggestions']/li"));
		System.out.println(searchbarElements.size());
		
		for(WebElement searchEle:searchbarElements) {
			System.out.println(searchEle.getText());
		}

	}

}
