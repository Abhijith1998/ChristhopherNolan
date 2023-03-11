package webelement;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PerformBooleanMethodsOnSkillrary {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://demoapp.skillrary.com/");
		
		WebElement mailbutton = driver.findElement(By.xpath("//button[@class=\"btn btn-info btn-flat\"]"));
		System.out.println(mailbutton.isEnabled());
		
		 WebElement dropdownlist = driver.findElement(By.xpath("//select[@id=\"cars\"]/option[2]"));
		dropdownlist.click();
		System.out.println(dropdownlist.isSelected());
	}

}
