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

        String attr1 = driver.findElement(By.cssSelector("#breadcrumbs a")).getAttribute("href");
        System.out.println("Значение свойства href = " + attr1);

        driver.get("http://localhost/litecart/en/regional_settings"); //Селектор находится во фрейме
        String attr2 = driver.findElement(By.cssSelector("[name=currency_code] [value=USD]")).getAttribute("selected");
        System.out.println("Значение свойства selected = " + attr2);

        driver.get("http://localhost/litecart/en/");
        String attr3 = driver.findElement(By.cssSelector("div.content h3")).getCssValue("color");
        System.out.println("Значение свойства color = " + attr3);



        //wait.until(titleIs("webdriver - Поиск в Google"));
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}
