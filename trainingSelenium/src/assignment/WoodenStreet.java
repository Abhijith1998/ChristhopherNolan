package assignment;
/**
 * @author abhijith
 */
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class WoodenStreet {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.woodenstreet.com/");
		driver.findElement(By.id("loginclose1")).click();
		
		//adding 1st product
		driver.findElement(By.linkText("Sofas")).click();
		driver.findElement(By.linkText("Sofa Sets")).click();
		driver.findElement(By.partialLinkText("Wooden Sofa")).click();
		driver.findElement(By.xpath("(//div[@class=\"load-product-item flex cattwo category-two\"])[1]/div[1]/div[3]/a[1]")).click();
		String productPrice1 = driver.findElement(By.xpath("//span[@class=\"offerprice\"]")).getText();
		int finalPrice1=priceConversion(productPrice1);
		driver.findElement( By.id("button-cart-buy-now")).click();
		
		//adding 2nd product
		driver.findElement(By.linkText("Living")).click();
		driver.findElement(By.linkText("Coffee Tables")).click();
		driver.findElement(By.xpath("//div[@class=\"load-product-item flex cattwo category-three\"]/div[1]/div/a")).click();
		String productPrice2 = driver.findElement(By.xpath("//span[@class=\"offerprice\"]")).getText();
		int finalPrice2=priceConversion(productPrice2);
		driver.findElement( By.id("button-cart-buy-now")).click();
		
		//adding 3rd product
		driver.findElement(By.linkText("Bedroom")).click();
		driver.findElement(By.linkText("Beds")).click();
		driver.findElement(By.xpath("//div[@class=\"load-product-item flex cattwo category-two\"]/div[1]/div/a")).click();
		String productPrice3 = driver.findElement(By.xpath("//span[@class=\"offerprice\"]")).getText();
		int finalPrice3=priceConversion(productPrice3);
		driver.findElement( By.id("button-cart-buy-now")).click();
		
		driver.findElement(By.xpath("//a[@class=\"cart\"]")).click();
		
		if(finalPrice1<finalPrice2&&finalPrice1<finalPrice3) {
			driver.findElement(By.xpath("//a[contains(text(),'Winster 5 Seater Wooden Sofa')]/..//p[@title='Remove']")).click();
			System.out.println(finalPrice1+": product deleted successfully");
		}
		else if(finalPrice2<finalPrice3) {
			driver.findElement(By.xpath("//a[contains(text(),'Vesta Sheesham Wood Coffee Table')]/..//p[@title='Remove']")).click();
			System.out.println(finalPrice2+": product deleted successfully");
		}
		else {
			driver.findElement(By.xpath("//a[contains(text(),'Walken Bed With Storage')]/..//p[@title='Remove']")).click();
			System.out.println(finalPrice3+": product deleted successfully");
		}
		Thread.sleep(4000);	
	}
	public static int priceConversion(String productPrice) {
		String[] produtPricefinal = productPrice.split("R");
		productPrice=produtPricefinal[1].replace("s", "").replace(",", "").replace(" ", "");
		int finalPrice=Integer.parseInt(productPrice);
		return finalPrice;
	}
}
