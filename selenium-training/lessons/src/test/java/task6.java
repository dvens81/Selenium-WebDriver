import org.junit.After;
import org.junit.Assert;
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
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        //wait = new WebDriverWait(driver,10);
    }

        boolean isElementPresent(WebDriver driver, By locator) {
        return driver.findElements(locator).size() > 0;
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

            int count = driver.findElements(By.cssSelector(".docs .name")).size();

            if (count > 0) {
                List<WebElement> menu2 = driver.findElements(By.cssSelector(".docs .name"));

                for (int j = 0; j < menu2.size(); j++) {

                    menu2 = driver.findElements(By.cssSelector(".docs .name"));
                    menu2.get(j).click();

                    Assert.assertTrue(isElementPresent(driver, By.cssSelector("h1")));
//                    int h1 = driver.findElements(By.cssSelector("h1")).size();
//                    if (h1 == 0){
//                        break;
//                    }
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
