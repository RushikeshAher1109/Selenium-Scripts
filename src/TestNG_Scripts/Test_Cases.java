package TestNG_Scripts;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Test_Cases  {

    private final String BASE = "https://the-internet.herokuapp.com";

    WebDriver driver=new ChromeDriver();
    
    @Test(description = "Login success with valid credentials")
    public void testSuccessfulLogin() {
        driver.get(BASE + "/login");

        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        WebElement flash = driver.findElement(By.id("flash"));
        Assert.assertTrue(flash.getText().contains("You logged into a secure area!"),
                "Expected success message not found. Actual: " + flash.getText());
    }

    @Test(description = "Login failure with incorrect credentials")
    public void testFailedLogin() { 
        driver.get(BASE + "/login");

        driver.findElement(By.id("username")).sendKeys("wronguser");
        driver.findElement(By.id("password")).sendKeys("badpass");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        WebElement flash = driver.findElement(By.id("flash"));
        Assert.assertTrue(flash.getText().toLowerCase().contains("your username is invalid") ||
                          flash.getText().toLowerCase().contains("invalid"),
                "Expected invalid credentials message. Actual: " + flash.getText());
    }

    @Test(description = "Checkboxes - toggle and verify")
    public void testCheckboxesToggle() {
        driver.get(BASE + "/checkboxes");

        List<WebElement> boxes = driver.findElements(By.cssSelector("#checkboxes input[type='checkbox']"));
        Assert.assertTrue(boxes.size() >= 2, "Expected at least two checkboxes");

        // toggle both
        for (WebElement box : boxes) {
            boolean before = box.isSelected();
            box.click();
            Assert.assertNotEquals(box.isSelected(), before, "Checkbox selection should toggle");
        }
    }

    @Test(description = "Add / Remove elements - add two and remove one")
    public void testAddRemoveElements() {
        driver.get(BASE + "/add_remove_elements/");

        WebElement addBtn = driver.findElement(By.cssSelector("button[onclick='addElement()']"));
        addBtn.click();
        addBtn.click();

        List<WebElement> deletes = driver.findElements(By.cssSelector("button.added-manually"));
        Assert.assertEquals(deletes.size(), 2, "Expected 2 delete buttons after adding 2 elements");

        // Remove one
        deletes.get(0).click();
        List<WebElement> deletes2 = driver.findElements(By.cssSelector("button.added-manually"));
        Assert.assertEquals(deletes2.size(), 1, "Expected 1 delete button after removing one element");
    }

    @Test(description = "Dropdown select and verify selected option")
    public void testDropdownSelect() {
        driver.get(BASE + "/dropdown");

        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdown);

        // Select by visible text
        select.selectByVisibleText("Option 2");
        WebElement selected = select.getFirstSelectedOption();
        Assert.assertEquals(selected.getText().trim(), "Option 2", "Expected Option 2 to be selected");
    }

    // If you want more tests, copy the pattern above and hit other pages like /dynamic_controls
}


