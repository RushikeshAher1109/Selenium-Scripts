package Utilities;



import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;   

    @BeforeMethod
    public void setUp() {
        driver = DriverSetup.getDriver();   
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();   
        }
    }
}
