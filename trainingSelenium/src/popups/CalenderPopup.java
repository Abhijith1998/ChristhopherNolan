package popups;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalenderPopup {

	public static void main(String[] args) {
		LocalDateTime ldt = LocalDateTime.now();
		String month=ldt.plusMonths(5).getMonth().toString();
		month=""+month.charAt(0)+month.substring(1, month.length()).toLowerCase();
		int year = ldt.getYear();
		int day = ldt.getDayOfMonth();
		int day2=ldt.plusDays(10).getDayOfMonth();
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		driver.get("https://www.oyorooms.com/");
		WebElement checkIn = driver.findElement(By.xpath("//div[@class=\"oyo-row oyo-row--no-spacing datePickerDesktop datePickerDesktop--home\"]"));
		checkIn.click();
		for(;;) {
			try {
				driver.findElement(By.xpath("//span[text()='"+month+"']/..//span[text()='"+year+"']/../..//span[text()='"+day+"']")).click();
				driver.findElement(By.xpath("//span[text()='"+month+"']/..//span[text()='"+year+"']/../..//span[text()='"+day2+"']")).click();
				break;
			} catch (Exception e) {
				driver.findElement(By.xpath("//div[@class=\"DateRangePicker__PaginationArrow DateRangePicker__PaginationArrow--next\"]")).click();
			}
		}
	}
}