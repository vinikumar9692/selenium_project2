package Selenium.Project2;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Leafground_Windows {

	@Test

	void windowhandle() throws Exception {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://www.leafground.com/");
		driver.findElement(By.xpath("//*[text()='Window']")).click();
		Thread.sleep(3000);
		String parentWindow = driver.getWindowHandle();
		System.out.println("parentWindow :"+parentWindow);
		Thread.sleep(3000);

		driver.findElement(By.xpath("//button[@id='home']")).click();
		Set<String> childWindow2 = driver.getWindowHandles();
		System.out.println(childWindow2.size());
		Iterator<String> ch2 = childWindow2.iterator();

		while(ch2.hasNext()) {
			String tit = driver.switchTo().window(ch2.next()).getTitle();
			if(tit.equalsIgnoreCase("TestLeaf - Selenium Playground"))
				driver.close();
		}
		Thread.sleep(5000);
		driver.switchTo().window(parentWindow);
		driver.findElement(By.xpath("(//*[@id='color'])[1]")).click();
		Thread.sleep(3000);
		Set<String> childWindow = driver.getWindowHandles();
		System.out.println(childWindow.size()); 

		for (String string : childWindow) {

			System.out.println(driver.switchTo().window(string).getTitle());

			if(driver.switchTo().window(string).getTitle().equalsIgnoreCase("TestLeaf - Interact with Buttons")) {
				Thread.sleep(3000);
				driver.manage().window().maximize();
				WebElement post = driver.findElement(By.xpath("//*[@id='position']"));
				System.out.println(post.getLocation().getX());
				System.out.println(post.getLocation().getY());
				Thread.sleep(3000);
				break;
			} else {
				Thread.sleep(3000);
				driver.manage().window().maximize();
				//driver.close();
			}
		}
		driver.switchTo().window(parentWindow);
		driver.findElement(By.xpath("(//button[@id='color'])[2]")).click();
		Thread.sleep(6000);
		Set<String> childWindow1 = driver.getWindowHandles();
		Iterator<String> ch = childWindow1.iterator();
		System.out.println("Parent Wind: "+ch.next());
		System.out.println("Child Wind1: "+ch.next());
		System.out.println("Child Wind2: "+ch.next());	
		driver.quit();
	}
}

	


