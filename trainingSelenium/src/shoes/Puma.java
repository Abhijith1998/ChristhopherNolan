package shoes;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Puma {
	@Test
	public void buyPuma() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://in.puma.com/");
		Reporter.log("opening puma website", true);
		driver.quit();
	}
}
