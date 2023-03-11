package popups;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AbhibusCalenderPopup {

	public static void main(String[] args) {
		LocalDateTime ldt = LocalDateTime.now();
		String month=ldt.plusMonths(2).getMonth().toString();
		month=""+month.charAt(0)+month.substring(1, month.length()).toLowerCase();
		int year = ldt.getYear();
		int day = ldt.getDayOfMonth();
		System.out.println(day);
		System.out.println(month);
		System.out.println(year);
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		driver.get("https://www.abhibus.com/");
		driver.findElement(By.id("datepicker1")).click();
		for(;;) {
		try {
			driver.findElement(By.xpath("//span[text()='"+month+"']/..//span[text()='"+year+"']/../../..//a[text()='"+day+"']")).click();
			break;
		} catch (Exception e) {
			driver.findElement(By.xpath("//span[text()='Next']")).click();
		}
	  }	
	}
}
