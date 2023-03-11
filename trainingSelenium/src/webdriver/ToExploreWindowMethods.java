package webdriver;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToExploreWindowMethods {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.skillrary.com/");
		
		Dimension dimensionBeforeMax = driver.manage().window().getSize();
		System.out.println(dimensionBeforeMax);
		
		Thread.sleep(4000);
		driver.manage().window().maximize();
//		driver.manage().window().fullScreen();
		
		Dimension dimensionAfterMax = driver.manage().window().getSize();
		System.out.println(dimensionAfterMax);
		Thread.sleep(4000);
		
//		to get position of web page
		Point positionOfBrowser = driver.manage().window().getPosition();
		System.out.println(positionOfBrowser.getX());
		System.out.println(positionOfBrowser.getY());
		
//		to set size for the web page
		driver.manage().window().setSize(new Dimension(500, 300));
		
//		to set position for the web page
		driver.manage().window().setPosition(new Point(100, 500));
		
//		to set web page position at 0,0
		driver.manage().window().setPosition(new Point(0, 0));
		
		
		
		
		
		
		
		

	}

}
