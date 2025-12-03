package Utilities;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class DriverSetup {

    public static WebDriver getDriver() {

        // Agar tum Selenium Manager use nahi kar rahe ho aur path dena padta hai toh ye uncomment karo:
        // System.setProperty("webdriver.chrome.driver", "C:\\seleniumwebdriver\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();

    	Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("profile.default_content_setting_values.notifications", 2);
        prefs.put("profile.default_content_settings.popups", 0);
        prefs.put("autofill.profile_enabled", false);
        prefs.put("autofill.credit_card_enabled", false);

        options.setExperimentalOption("prefs", prefs);

        // Extra flags
        //options.addArguments("user-data-dir=C:/Users/Sir/AppData/Local/Google/Chrome/User Data/Profile 1");

        options.addArguments("--disable-save-password-bubble");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-autofill-passwords");
        options.addArguments("--disable-blink-features=AutomationControlled");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
      ///  C:\Users\Sir\AppData\Local\Google\Chrome\User Data\Profile1
        return driver;
    }
}
