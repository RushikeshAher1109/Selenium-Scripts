package TestNG_Scripts;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Google_test {
	
	    @Test
	    public void openGoogle() {
	        WebDriverManager.chromedriver().browserVersion("142").setup();;
	        WebDriver driver = new ChromeDriver();
	        driver.get("https://www.google.com");
	        System.out.println("Title: " + driver.getTitle());
	        driver.quit();
	    }
	}




	
  
  

