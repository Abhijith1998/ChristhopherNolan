package screenshot;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class ToCaptureWebElement {

	public static void main(String[] args) throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.woodenstreet.com/");
		File logo = driver.findElement(By.xpath("//img[@alt='Home Furniture Online']")).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(logo, new File("./errorShots/logo.png"));
		
		 WebElement screenshot = driver.findElement(By.cssSelector("img[alt=\"footer\"]"));
		 Thread.sleep(3000);
		 File footerCards = screenshot.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(footerCards, new File("./errorShots/footerCards.jpeg"));
	}
}
