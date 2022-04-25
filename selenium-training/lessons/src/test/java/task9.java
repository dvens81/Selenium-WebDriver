import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class task9 {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void myFirstTest() {

        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        driver.findElement(By.cssSelector("[href*=geo_zone]")).click();

        ArrayList<String> zone_name_List = new ArrayList<>();

        List<WebElement> countries_name = driver.findElements(By.cssSelector(".row td:nth-child(3) a"));
        for (int i = 0; i < countries_name.size(); i++) {
            countries_name = driver.findElements(By.cssSelector(".row td:nth-child(3) a"));
            countries_name.get(i).click();

            List<WebElement> zone_name = driver.findElements(By.cssSelector("#table-zones td:nth-child(3) [selected=selected]"));
            for (int j = 0; j < zone_name.size(); j++) {
                String attr_zone_name = zone_name.get(j).getAttribute("textContent");
                zone_name_List.add(j, attr_zone_name);
            }
            System.out.println(zone_name_List);

            ArrayList<String> sort_zone_name_List = new ArrayList<>();

            for (int k = 0; k < zone_name_List.size(); k++) {
                sort_zone_name_List.add(k, zone_name_List.get(k));
            }
            System.out.println(sort_zone_name_List);

            Collections.sort(sort_zone_name_List);
            Assert.assertEquals(zone_name_List, sort_zone_name_List);
            zone_name_List.clear();
            sort_zone_name_List.clear();
            driver.get("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");
        }
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}