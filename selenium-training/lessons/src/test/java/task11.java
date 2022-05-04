import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class task11 {

    private WebDriver driver;

    @Before
    public void start() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void Test() {

        driver.get("http://localhost/litecart/en/");
        driver.findElement(By.cssSelector("form[name=login_form] td a")).click();
        driver.findElement(By.cssSelector("[name=tax_id]")).sendKeys("1");
        driver.findElement(By.cssSelector("[name=company]")).sendKeys("OTR");
        driver.findElement(By.cssSelector("[name=firstname]")).sendKeys("Dmitriy");
        driver.findElement(By.cssSelector("[name=lastname]")).sendKeys("Star");
        driver.findElement(By.cssSelector("[name=address1]")).sendKeys("Samara");
        driver.findElement(By.cssSelector("[name=address2]")).sendKeys("Russia");
        driver.findElement(By.cssSelector("[name=postcode]")).sendKeys("12345");
        driver.findElement(By.cssSelector("[name=city]")).sendKeys("City");

        // Как выбрать элемент из выпадающего списка
        WebElement tag_select_country = driver.findElement(By.cssSelector(".select2-hidden-accessible")); // элемент выпадающего списка ищем по тэгу select
//        String country_list = tag_select.getText();
//        System.out.println(country_list);

        // Cпособ 1. С помощью класса Select
        Select select_country = new Select(tag_select_country);
        select_country.selectByVisibleText("United States");

        // Cпособ 2. С помощью executeScript
        //((JavascriptExecutor) driver).executeScript("arguments[0].selectedIndex = 224; arguments[0].dispatchEvent(new Event('change'))", tag_select_country);

        WebElement tag_select_zon = driver.findElement(By.cssSelector("select[name=zone_code]"));
        //String zon_list = tag_select_zon.getText();
        //System.out.println(zon_list);
        Select select_zon = new Select(tag_select_zon);
        select_zon.selectByVisibleText("California");

        // Генерация уникальных email
        Random r = new java.util.Random();
        String s = Integer.toString(r.nextInt() & Integer.MAX_VALUE, 36);
        String email_unique = s + "@mail.ru";
        //System.out.println(email_unique);
        driver.findElement(By.cssSelector("[name=email]")).sendKeys(email_unique);

        driver.findElement(By.cssSelector("[name=phone]")).sendKeys("+15557733");
        driver.findElement(By.cssSelector("[name=newsletter]")).click();
        driver.findElement(By.cssSelector("[name=password]")).sendKeys("password");
        driver.findElement(By.cssSelector("[name=confirmed_password]")).sendKeys("password");
        driver.findElement(By.cssSelector("button[name=create_account]")).click();
        driver.findElement(By.cssSelector("#box-account li [href*=logout]")).click();

        driver.findElement(By.cssSelector("#box-account-login [name=email]")).sendKeys(email_unique);
        driver.findElement(By.cssSelector("#box-account-login [name=password]")).sendKeys("password");
        driver.findElement(By.cssSelector("#box-account-login button[name=login]")).click();
        driver.findElement(By.cssSelector("#box-account li [href*=logout]")).click();

    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}
