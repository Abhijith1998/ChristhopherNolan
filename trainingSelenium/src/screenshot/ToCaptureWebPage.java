package screenshot;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class ToCaptureWebPage {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.woodenstreet.com/");
		
		//type casting bcz using driver ref we cannot call getScreenshotAs()
		TakesScreenshot ts=(TakesScreenshot) driver;
		File screenshot = ts.getScreenshotAs(OutputType.FILE);
		//File path will be stored in Temp folder so once the execution completed screen shot will be lost
		//we have to copy that path and store it in permanent folder
		FileHandler .copy(screenshot, new File("./errorShots/image1.png"));
	}
}
