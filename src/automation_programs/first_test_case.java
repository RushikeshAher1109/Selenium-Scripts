package automation_programs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class first_test_case {

	@Test
	void open() 
	{
		System.out.println("Opening application");
	}
	@Test
	void login() 
	{
		System.out.println("log in application");
	}
	@Test
	void logout() 
	{
		System.out.println("log out from application");
	}
	
	 
	 @Test
	 public void openGoogle() {
	        WebDriverManager.chromedriver().browserVersion("142").setup();;
	        WebDriver driver = new ChromeDriver();
	        driver.get("https://www.google.com");
	        System.out.println("Title: " + driver.getTitle());
	        driver.quit();
	    }
	
}
