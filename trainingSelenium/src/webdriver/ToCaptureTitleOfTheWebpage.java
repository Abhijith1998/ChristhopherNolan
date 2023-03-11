package webdriver;

import org.openqa.selenium.chrome.ChromeDriver;

public class ToCaptureTitleOfTheWebpage {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\abhis\\OneDrive\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		
		driver.get("https://www.dell.com/");
		
		String windowTitle=driver.getTitle();
		System.out.println(windowTitle);
	}
}
