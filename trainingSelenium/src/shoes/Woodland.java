package shoes;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Woodland {
	@Test
	public void buyWoodland() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.woodlandworldwide.com/");
		Reporter.log("opening Woodland website", true);
		driver.quit();
	}
}
