package shoes;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Adidas {
	@Test
	public void buyAdidas() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.adidas.co.in/");
		Reporter.log("opening adidas website", true);
		driver.quit();
	}
}
