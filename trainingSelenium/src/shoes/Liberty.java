package shoes;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Liberty{
	@Test
	public void buyLiberty() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.libertyshoesonline.com/");
		Reporter.log("opening Liberty website", true);
		driver.quit();
	}
}
