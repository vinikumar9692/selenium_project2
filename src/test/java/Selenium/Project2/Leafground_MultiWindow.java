package Selenium.Project2;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Leafground_MultiWindow {


	@Test
	public void win1() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Window.html");
		String parentwindow = driver.getWindowHandle();
		driver.findElement(By.xpath("(//*[@class='large-6 small-12 columns'])[2]/button")).click();
		Set<String> childwindow = driver.getWindowHandles();
		Iterator<String> win = childwindow.iterator();
		String firstChildWin =win.next();
		String secondChildWin =win.next();
		String thirdChildWin =win.next();
		
		System.out.println(parentwindow);
		Thread.sleep(3000);
		System.out.println(firstChildWin);
		Thread.sleep(3000);
		System.out.println(secondChildWin);	
		Thread.sleep(3000);
		System.out.println(thirdChildWin);
		driver.quit();
		
}
}
