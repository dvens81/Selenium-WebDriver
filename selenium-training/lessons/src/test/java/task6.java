import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class task6 {

    private WebDriver driver;

    @Before
    public void  start() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //wait = new WebDriverWait(driver,10);
    }

    @Test
    public void myFirstTest() {

        driver.get("http://localhost/litecart/admin/");

        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();

        List<WebElement> menu = driver.findElements(By.cssSelector("#box-apps-menu > li"));

        for (int i = 0; i < menu.size(); i++) {
            menu = driver.findElements(By.cssSelector("#box-apps-menu > li"));
            menu.get(i).click();

            int count = driver.findElements(By.cssSelector("#box-apps-menu > li#app- [class=docs] span")).size();
            if (count > 0) {
                List<WebElement> menu2 = driver.findElements(By.cssSelector("#box-apps-menu > li#app- [class=docs] span"));
                for (int j = 0; j < menu2.size(); j++) {
                    menu2 = driver.findElements(By.cssSelector("#box-apps-menu > li#app- [class=docs] span"));
                    menu2.get(j).click();
                }
            }
        }
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}
