package popups;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToAvoidFileUploadPopup {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		
		driver.get("https://www.freshersworld.com/user/register");
		
		//don't inspect button tag
		//identify input tag which is associated with file upload button
		driver.findElement(By.id("file-upload")).sendKeys("C:\\Users\\abhis\\OneDrive\\Pictures\\Screenshots\\Screenshot (1).png");
		Alert alertPopup = driver.switchTo().alert();
		System.out.println(alertPopup.getText());
		alertPopup.accept();
		driver.findElement(By.id("file-upload")).sendKeys("C:\\Users\\abhis\\OneDrive\\Desktop\\Resumes\\Yashwanthpn.docx");	
	}
}