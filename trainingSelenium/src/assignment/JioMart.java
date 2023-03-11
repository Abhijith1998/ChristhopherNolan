package assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JioMart {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.jiomart.com/");
		
		driver.findElement(By.id("nav_link_2")).click();
		driver.findElement(By.xpath("//input[@class=\"ais-refinement-list--checkbox\"]")).click();
		driver.findElement(By.xpath("//span[text()='Green Peas 500 g']/../..//button[@class=\"toCart addtocartbtn\"]")).click();
		
		driver.findElement(By.id("nav_link_3")).click();
		driver.findElement(By.xpath("(//span[text()='BULLMER Men Navy Cotton Blend Printed Single T-shirt'])[1]")).click();
		driver.findElement(By.xpath("//span[text()='L']")).click();
		driver.findElement(By.xpath("//button[@title=\"ADD TO CART\"]")).click();
		
		driver.findElement(By.id("nav_link_4")).click();
		driver.findElement(By.xpath("(//span[text()='Samsung Galaxy M13 5G 64 GB, 4 GB RAM, Midnight Blue, Mobile Phone'])[1]")).click();
		driver.findElement(By.xpath("//button[@title=\"ADD TO CART\"]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//button[@class=\"close\"])[5]")).click();
		
		driver.findElement(By.xpath("//a[text()='Samsung Galaxy M13 5G 64 GB, 4 GB RAM, Midnight Blue, Mobile Phone']/../..//span[@id=\"row_itmdiscprice_597540052\"]")).getText();
		
		
		
	}

}
