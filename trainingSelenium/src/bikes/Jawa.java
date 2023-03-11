package bikes;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Jawa {
	@Test(groups = {"smoke","integration"})
	public void buyJawa() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.jawamotorcycles.com/");
		Reporter.log("opening Jawa website", true);
		driver.quit();
	}
}
