package Login_Form_Automation;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

 public class login_automation{
	
public static void main(String[] args) {
	
	

	System.setProperty("webdriver.chrome.driver","C:\\SeleniumWebdriver\\ChromeDriver\\chromedriver.exe");

	WebDriver driver =new ChromeDriver();
	Actions act=new Actions(driver);
	
	driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(5));
	driver.get("https://practice.expandtesting.com/login");
	driver.manage().window().maximize();
	  driver.findElement(By.id("username")).sendKeys("practice");
	 driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
	    
	 WebElement ele=driver.findElement(By.xpath("//p[contains(text(),'The login feature is essential for secure websites')]"));
	 act.moveToElement(ele).build().perform();
	 
	 driver.findElement(By.xpath("//button[@id='submit-login']")).click();

	
	WebElement succesmessege = driver.findElement(By.xpath("//b[contains(text(),\"You logged into a secure area!\")]"));
	String actualtext=succesmessege.getText();
	Assert.assertEquals(actualtext, "You logged into a secure area!");
	
	System.out.println("Success Messege Matched! ");
	
	driver.close(); 
	
}
	
}