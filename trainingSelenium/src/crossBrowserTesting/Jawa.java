package crossBrowserTesting;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Jawa extends BaseTestClass{
	
	@Test()
	public void buyJawa() {
		driver.get("https://www.jawamotorcycles.com/");
		Reporter.log("opening Jawa website", true);
	}
}
