package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToCaptureJewelleryMsgInDemoWebShop {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://demowebshop.tricentis.com/");
		driver.findElement(By.partialLinkText("Jewelry")).click();
		driver.findElement(By.linkText("Black & White Diamond Heart")).click();
		
		String description1 = driver.findElement(By.xpath("//div[@class='short-description']")).getText();
		System.out.println(description1);
		
		String description2 = driver.findElement(By.xpath("//div[@class='full-description']")).getText();
		System.out.println(description2);
		
		driver.quit();
	}

}
