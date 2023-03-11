package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToUnderstandGetAttributeMethod {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.kalkifashion.com/ethnic/mens-wear-under-usd199.html");
		String titleText = driver.findElement(By.xpath("(//img[@title=\"Dusty Jade Green Kurta Set With Lucknowi Thread And Sequins Embroidered Jaal And Centre Placket\"])[2]")).getAttribute("title");
        System.out.println(titleText);
        
        driver.get("https://www.woodenstreet.com/");
        String altText = driver.findElement(By.xpath("//img[@title=\"Sofa set online\"]")).getAttribute("alt");
        System.out.println(altText);
        driver.quit();
        
        
	}

}
