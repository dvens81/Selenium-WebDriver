import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import java.awt.*;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class task13 {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void Test() {
        driver.get("http://localhost/litecart/en/");

        for (int i = 0; i < 7; i++) {
            driver.findElement(By.cssSelector(".hover-light .image")).click();
            driver.findElement(By.cssSelector("[name=add_cart_product]")).click();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#cart .quantity[style]")));
            driver.findElement(By.cssSelector("#logotype-wrapper img")).click();
        }

        driver.findElement(By.cssSelector("#cart-wrapper .link")).click();

        List<WebElement> removeCart = driver.findElements(By.cssSelector("[name=remove_cart_item]"));
        for (int i = 0; i < removeCart.size(); i++) {
            WebElement removeProduct = driver.findElement(By.cssSelector("[name=remove_cart_item]"));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[name=remove_cart_item]"))).click();
            wait.until(ExpectedConditions.stalenessOf(removeProduct));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#checkout-summary-wrapper")));
        }

    }


    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}
