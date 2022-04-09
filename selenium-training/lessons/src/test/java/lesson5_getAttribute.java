import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class lesson5_getAttribute {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void  start() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //wait = new WebDriverWait(driver,10);
    }

    @Test
    public void myFirstTest() {

        driver.get("http://localhost/litecart/en/");

        String a = driver.findElement(By.cssSelector("#breadcrumbs a")).getAttribute("href");
        System.out.println("Значение свойства href = " + a);

        String a2 = driver.findElement(By.cssSelector("div.content h3")).getCssValue("color");
        System.out.println("Значение свойства color = " + a2);

        //Селектор невидимый. Находится во фрейме
//        String b = driver.findElement(By.cssSelector("[name=currency_code] [value=USD]")).getAttribute("selected");
//        System.out.println("Значение свойства selected = " + b);

        //wait.until(titleIs("webdriver - Поиск в Google"));
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}
