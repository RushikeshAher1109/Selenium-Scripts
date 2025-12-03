package automation_programs;


import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import Utilities.BaseTest;

public class product_order extends BaseTest {

    @Test
    public void placeOrderTest() throws InterruptedException {

        // Actions object using driver from BaseTest
        Actions act = new Actions(driver);

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        driver.get("https://automationexercise.com/");

        // LOGIN
        driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("corbin@gmail.com");
        Thread.sleep(3000);

        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("123456789");

        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//a[@href='/products']")).click();
        Thread.sleep(3000);

        // SEARCH PRODUCTS
        driver.findElement(By.xpath("//input[@id='search_product']")).sendKeys("Shirts");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@id='submit_search']")).click();
        Thread.sleep(3000);

        WebElement scroll = driver.findElement(By.xpath("//div[5]//div[1]//div[1]//div[2]//div[1]//a[1]"));

        act.moveToElement(scroll).build().perform();

        driver.findElement(By.xpath("(//a[contains(text(),'Add to cart')])[1]")).click();
        Thread.sleep(3000);

        // MOVE TO CART
        driver.findElement(By.xpath("//button[normalize-space()='Continue Shopping']")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//body[1]/header[1]/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[3]/a[1]"))
              .click();
        Thread.sleep(3000);

        // PROCEED TO CHECKOUT
        driver.findElement(By.xpath("//a[normalize-space()='Proceed To Checkout']")).click();

        WebElement mouse = driver.findElement(By.xpath("//input[@id='susbscribe_email']"));
        act.moveToElement(mouse).build().perform();

        driver.findElement(By.xpath("//a[@class='btn btn-default check_out']")).click();

        driver.findElement(By.xpath("//input[@name='name_on_card']")).sendKeys("Corbin Bosch");
        driver.findElement(By.xpath("//input[@name='card_number']")).sendKeys("1234567891025634");
        driver.findElement(By.xpath("//input[@placeholder='ex. 311']")).sendKeys("123");
        driver.findElement(By.xpath("//input[@placeholder='MM']")).sendKeys("12");
        driver.findElement(By.xpath("//input[@placeholder='YYYY']")).sendKeys("2035");

        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@id='submit']")).click();

        // ORDER SUCCESSFUL
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[normalize-space()='Download Invoice']")).click();

        Thread.sleep(3000);

        WebElement successmessege = driver.findElement(
                By.xpath("//p[normalize-space()='Congratulations! Your order has been confirmed!']"));

        String actualtext = successmessege.getText();

        Assert.assertEquals(actualtext, "Congratulations! Your order has been confirmed!");

        System.out.println("Order Placed Successfully");

        Thread.sleep(3000);

    }
}

