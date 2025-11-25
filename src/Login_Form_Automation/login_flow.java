package Login_Form_Automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class login_flow {

	public static void main(String[] args) throws InterruptedException {


		WebDriver driver = new ChromeDriver();
		driver.get("https://practicetestautomation.com/practice-test-login/");
		driver.manage().window().maximize();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("student");
		
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Password123");
		

		driver.findElement(By.xpath("//button[@id='submit']")).click();
		

		
		 WebElement msg1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[normalize"
		 		+ "-space()='Logged In Successfully']")));
		 String text= msg1.getText();
		 
		 
		 if (text.contains("Logged In Successfully")) {
			 System.out.println("User logged in succesfully");
		 }
		 else {
			 System.out.println("Invalid credentials!");
		 }
		 
			
driver.close();
	}

}
