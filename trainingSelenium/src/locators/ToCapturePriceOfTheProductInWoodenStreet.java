package locators;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToCapturePriceOfTheProductInWoodenStreet {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.woodenstreet.com/");
		for (;;) {
			try {
				driver.findElement(By.id("loginclose1")).click();
				break;
			} catch (Exception e) {
				Thread.sleep(1000);
			}
		}
		driver.findElement(By.xpath("//ul[@class='container flex']/li[5]/a")).click();
		driver.findElement(By.xpath("//div[@class='top-list']/a[5]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//div[@class='load-product-item flex cattwo category-three'])[1]/div[5]/div[3]/a")).click();
		Thread.sleep(5000);
		String ProductDescription = driver.findElement(By.xpath("//div[@class='overview']")).getText();
		//System.out.println(ProductDescription);
		//optional
		//to write productDescription inside sample doc(File)
		File f=new File("C:\\selenium\\sample.txt");
		FileOutputStream fout=new FileOutputStream(f);
		fout.write(ProductDescription.getBytes());
		fout.close();
		
		String price = driver.findElement(By.xpath("//span[@class='offerprice']")).getText();
		String[] costs = price.split("R");
		String finalCost = costs[1].replace("s", "").replace(",", "").replace(" ", "");
		int priceInt = Integer.parseInt(finalCost);	
		System.out.println(priceInt);
		if (priceInt < 50000) {
			driver.findElement(By.id("button-cart-buy-now")).click();
			System.out.println("item added to cart successfully");
		}
		driver.quit();
	}
}
