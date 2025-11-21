package automation_programs;

import java.time.Duration;


import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class product_order {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver","C:\\SeleniumWebdriver\\ChromeDriver\\chromedriver.exe");

		WebDriver driver =new ChromeDriver();
		Actions act=new Actions(driver);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5));
		driver.manage().window().maximize();
		
		driver.get("https://automationexercise.com/");
		
		driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("corbin@gmail.com");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("123456789");

		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();		
		Thread.sleep(3000);

		
		driver.findElement(By.xpath("//a[@href='/products']")).click();		
		Thread.sleep(3000);

		
		driver.findElement(By.xpath("//input[@id='search_product']")).sendKeys("Shirts");
		Thread.sleep(3000);

		driver.findElement(By.xpath("//button[@id='submit_search']")).click();
		Thread.sleep(3000);
		//div[@class='col-sm-9 padding-right']//div[2]//div[1]//div[1]//div[2]//div[1]//a[1]
		driver.findElement(By.xpath("//div[@class='col-sm-9 padding-right']//div[2]//div[1]//div[2]//ul[1]//li[1]//a[1]")).click();
		
		// driver.findElement(By.cssSelector("body > section:nth-child(4) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(3) > div:nt"
				//+ "h-child(1) > div:nth-child(1) > div:nth-child(1) > a:nth-child(4)")).click();
		
		//driver.findElement(By.xpath("/html[1]/body[1]/section[2]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/a[1]"));		
		Thread.sleep(3000);
		
		
		driver.findElement(By.xpath("//button[@type='button']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[normalize-space()='Continue Shopping']")).click();
		Thread.sleep(3000);

		
		driver.findElement(By.xpath("//body[1]/header[1]/div[1]/div[1]/d"
				+ "iv[1]/div[2]/div[1]/ul[1]/li[3]/a[1]")).click();
		Thread.sleep(3000);

		
		driver.findElement(By.xpath("//a[normalize-space()='Proceed To Checkout']")).click();
		
 WebElement mouse=driver.findElement(By.xpath("//input[@id='susbscribe_email']"));
 act.moveToElement(mouse).build().perform();
 
		 driver.findElement(By.xpath("//a[@class='btn btn-default check_out']")).click();
		
		//driver.findElement(By.xpath("//a[@class='btn btn-default check_out']")).click();
		
		driver.findElement(By.xpath("//input[@name='name_on_card']")).sendKeys("Corbin Bosch");
		driver.findElement(By.xpath("//input[@name='card_number']")).sendKeys("1234567891025634");
		driver.findElement(By.xpath("//input[@placeholder='ex. 311']")).sendKeys("123");
		driver.findElement(By.xpath("//input[@placeholder='MM']")).sendKeys("12");
		driver.findElement(By.xpath("//input[@placeholder='YYYY']")).sendKeys("2035");
		

		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@id='submit']")).click();
		

		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[normalize-space()='Download Invoice']")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[normalize-space()='Continue']")).click();
		
		WebElement succesmessege = driver.findElement(By.xpath("//p[normalize-space()='Congratulations! Your ord"
				+ "er has been confirmed!']"));
		String actualtext=succesmessege.getText();
		
		Assert.assertEquals(actualtext, "Congratulations! Your order has been confirmed!");
		
		System.out.println("Order Placed Succesfully");
		
		Thread.sleep(3000);
		
		
		
		
		
		
		
		
		
		
	}

}
