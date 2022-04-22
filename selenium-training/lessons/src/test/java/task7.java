import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class task7 {

    private WebDriver driver;

    @Before
    public void start() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        //wait = new WebDriverWait(driver,10);
    }

    @Test
    public void myFirstTest() {

        driver.get("http://localhost/litecart/en/");
        List<WebElement> products = driver.findElements(By.cssSelector(".products li"));

        for (WebElement product : products) {
            List<WebElement> sticker = product.findElements(By.cssSelector(".sticker"));
            Assert.assertEquals(1, sticker.size());
        }
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}
