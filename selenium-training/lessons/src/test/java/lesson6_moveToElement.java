import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class lesson6_moveToElement {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void  start() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //wait = new WebDriverWait(driver,10);
    }

    @Test
    public void Test() {

        driver.get("https://jqueryui.com/resources/demos/sortable/connect-lists.html");

        List<WebElement> items1 = driver.findElements(By.cssSelector("#sortable1 li"));
        List<WebElement> items2 = driver.findElements(By.cssSelector("#sortable2 li"));
        new Actions(driver)
                .moveToElement(items1.get(0))
                .clickAndHold()
                .moveToElement(items2.get(0))
                .release()
                .perform();
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}
