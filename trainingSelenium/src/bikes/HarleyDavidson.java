package bikes;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class HarleyDavidson {
	@Test(groups = "functionality")
	public void buyHarleyDavidson() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.harley-davidson.com/");
		Reporter.log("opening Harley website", true);
		driver.quit();
	}
}
