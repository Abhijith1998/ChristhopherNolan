package webdriver;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.chrome.ChromeDriver;

public class ToExploreNavigateMethods {

	public static void main(String[] args) throws InterruptedException, MalformedURLException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://polarbear.co.in/menu/");
		Thread.sleep(4000);
		
		driver.navigate().refresh();
		Thread.sleep(4000);
		
		driver.navigate().back();
		Thread.sleep(4000);
		
		driver.navigate().forward();
		Thread.sleep(4000);

		driver.navigate().to("https://petstore.swagger.io/");
		Thread.sleep(4000);
		
		driver.navigate().to(new URL("https://polarbear.co.in/menu/"));
	}

}
