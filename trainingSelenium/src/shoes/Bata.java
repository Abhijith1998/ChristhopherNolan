package shoes;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Bata {
	@Test
	public void buyBata() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.bata.in/");
		Reporter.log("opening bata website", true);
		driver.quit();
	}
}
