package Login_Form_Automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Form_Submission {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver","C:\\SeleniumWebdriver\\ChromeDriver\\chromedriver.exe");

		WebDriver driver =new ChromeDriver();
		Actions act=new Actions(driver);
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5));
		driver.manage().window().maximize();
		
		driver.get("https://demoqa.com/automation-practice-form");
		Thread.sleep(3000);
		
		  driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("rushi");
		  Thread.sleep(3000);
		  
		  driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("rushi");
		  Thread.sleep(3000);
		  
		  driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys(
		  "abc@gmail.com"); Thread.sleep(3000);
		  
		  driver.findElement(By.xpath("//label[@for='gender-radio-1']")).click();
		  Thread.sleep(3000);
		  
		  driver.findElement(By.xpath("//input[@id='userNumber']")).sendKeys(
		  "9876543210"); Thread.sleep(3000);
		 

		
		
		  driver.findElement(By.xpath("//input[@id='dateOfBirthInput']")).click();
		  Thread.sleep(3000);
		  
		  WebElement ele=driver.findElement(By.xpath(
		  "//select[@class='react-datepicker__year-select']")); ele.click();
		  
		  Select var1=new Select(ele); var1.selectByValue("2000"); Thread.sleep(3000);
		  
		  WebElement month =driver.findElement(By.xpath(
		  "//select[@class='react-datepicker__month-select']")); month.click(); Select
		  var2=new Select(month); var2.selectByVisibleText("March");
		  Thread.sleep(3000);
		  
		  driver.findElement(By.
		  xpath("//div[@aria-label='Choose Monday, March 6th, 2000']")).click();
		 

		Thread.sleep(3000);

		
		
//		  WebElement sub=driver.findElement(By.
//		  xpath("//div[@class='subjects-auto-complete__input']")); sub.click();
//		  sub.sendKeys(" abcd asdf sdfd dffg");
//		 
		 
		
		  driver.findElement(By.xpath("//label[@for='hobbies-checkbox-1']")).click();
		  driver.findElement(By.xpath("//label[@for='hobbies-checkbox-2']")).click();
		  driver.findElement(By.xpath("//label[@for='hobbies-checkbox-3']")).click();
		  Thread.sleep(3000);
		  
		  driver.findElement(By.id("uploadPicture")).sendKeys(
		  "C:\\Users\\Sir\\Pictures\\Screen" +
		  "shots\\Screenshot 2025-11-13 112725.png");
		  
		  Thread.sleep(3000);
		  
		  driver.findElement(By.xpath("//textarea[@id='currentAddress']")).
		  sendKeys("abcd efgh ijkl mnop qrst uvwxyz"); Thread.sleep(3000);
		 
		WebElement state =driver.findElement(By.xpath("//div[@id='state']//div[contains(@class,'css-1wy0on6')]"));
		state.click();
		driver.findElement(By.xpath("//div[contains(text(),'NCR')]")).click();
		Thread.sleep(3000);

		
		WebElement city =driver.findElement(By.xpath("//div[@id='city']//div[contains(@class,'css-1hwfws3')]"));
		city.click();
		
		driver.findElement(By.xpath("//div[contains(text(),'Delhi')]")).click();

		Thread.sleep(3000);

		driver.findElement(By.xpath("//button[@id='submit']")).click();

		Thread.sleep(3000);

		WebElement succesmessege = driver.findElement(By.xpath("//div[@id='example-modal-sizes-title-lg']"));
		String actualtext=succesmessege.getText();
		
		Assert.assertEquals(actualtext, "Thanks for submitting the form");
		
		System.out.println("User Registered Succesfully");
		
		Thread.sleep(3000);
driver.close();		
		
		
		
		
		
		
		
		
	}

}
