package bikes;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Kawasaki {
	@Test(groups = "integration",dependsOnGroups = "smoke" )
	public void buyKawasaki() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://kawasaki-india.com/");
		Reporter.log("opening kawasaki website");
		driver.quit();
	}
}