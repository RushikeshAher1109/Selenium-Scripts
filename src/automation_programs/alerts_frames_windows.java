package automation_programs;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class alerts_frames_windows {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumWebdriver\\ChromeDriver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		Actions act = new Actions(driver);

		// driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5));
		driver.manage().window().maximize();

		driver.get("https://the-internet.herokuapp.com/");

		driver.findElement(By.xpath("//a[contains(text(),'JavaScript Alerts')]")).click();
		// frames opened

		Thread.sleep(3000);
		/*
		 * driver.findElement(By.xpath("//button[contains(text(),'Click for JS Alert')]"
		 * )).click(); Thread.sleep(3000);
		 * 
		 * //switching to first frame driver.switchTo().alert().accept(); // alert
		 * accepted Thread.sleep(3000);
		 * 
		 * // switching to second alert (accept or decline) driver.findElement(By.
		 * xpath("//button[normalize-space()='Click for JS Confirm']")).click();
		 * Thread.sleep(3000);
		 * 
		 * driver.switchTo().alert().accept(); Thread.sleep(3000);
		 * 
		 * 
		 * //switching to third alert i.e entering messege and then accept or decline.
		 * driver.findElement(By.
		 * xpath("//button[normalize-space()='Click for JS Prompt']")).click();
		 * Thread.sleep(3000); driver.switchTo().alert().sendKeys("I am a JS prompt");
		 * Thread.sleep(3000);
		 * 
		 * driver.switchTo().alert().accept(); Thread.sleep(3000);
		 */

		
//iframe Switching		
		            
		
		
		
		
		
		
		
		
		
		driver.close();

	}

}
