package bikes;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Ducati {
	
	@Test(groups = "smoke")
	public void buyDucati() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.ducati.com/in/en/home");
		Reporter.log("opening ducati website", true);
		driver.quit();
	}
}
