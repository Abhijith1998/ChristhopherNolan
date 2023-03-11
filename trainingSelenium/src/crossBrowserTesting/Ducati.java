package crossBrowserTesting;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Ducati extends BaseTestClass{
	
	@Test()
	public void buyDucati() {
		driver.get("https://www.ducati.com/in/en/home");
		Reporter.log("opening ducati website", true);
	}
}
