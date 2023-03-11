package dropDownBox;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ToUseSelectMethod {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.get("https://www.facebook.com/signup");
		WebElement dayDropDown = driver.findElement(By.id("day"));
		WebElement monthDropDown = driver.findElement(By.id("month"));
		WebElement yearDropDown = driver.findElement(By.id("year"));
		
		Select daySelect=new Select(dayDropDown);
		Select monthSelect=new Select(monthDropDown);
		Select yearSelect=new Select(yearDropDown);
		
		daySelect.selectByIndex(11);
		monthSelect.selectByValue("10");
		yearSelect.selectByVisibleText("2016");
		
		//To select last option in the year
		List<WebElement> allYear = yearSelect.getOptions();
		int lastYearIndex = allYear.size()-1;
		yearSelect.selectByIndex(lastYearIndex);
	}

}
