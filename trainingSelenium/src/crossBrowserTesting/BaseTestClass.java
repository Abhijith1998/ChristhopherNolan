package crossBrowserTesting;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTestClass {
	public WebDriver driver;

	@BeforeClass
	public void browserSetutp(@Optional("chrome") String browserName) {
		
		if (browserName.equalsIgnoreCase("chrome")) {
			driver=WebDriverManager.chromedriver().create();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			driver=WebDriverManager.firefoxdriver().create();
		}
	}
}
