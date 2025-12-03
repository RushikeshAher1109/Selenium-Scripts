package Utilities;



import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;   // Ye saare test classes mein use hoga

    @BeforeMethod
    public void setUp() {
        driver = DriverSetup.getDriver();   // Yahin se driver milega
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();   // har test ke baad browser band
        }
    }
}
