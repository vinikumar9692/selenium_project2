package Selenium.Project2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Leafground_Frames {
	
	@Test
	
	void frame() throws Exception {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://www.leafground.com/");
		driver.findElement(By.xpath("//*[text()='Frame']")).click();
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@src='default.html']")));
		driver.findElement(By.id("Click")).click();
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@src='page.html']"))).switchTo().frame("frame2");
		driver.findElement(By.id("Click1")).click();
		driver.switchTo().defaultContent();
		System.out.println(driver.findElements(By.xpath("//iframe")).size());
	}

}
