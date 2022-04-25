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

public class task8 {

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
        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");

        ArrayList<String> countries_List = new ArrayList<>();
        ArrayList<String> geoZones_List = new ArrayList<>();

        List<WebElement> countries = driver.findElements(By.cssSelector(".row td:nth-child(5) a"));
        for (int i = 0; i < countries.size(); i++) {
            String attr_Countries = countries.get(i).getAttribute("textContent");
            countries_List.add(i, attr_Countries);
        }
        System.out.println("countries_List " + countries_List);

        ArrayList<String> countries_sort_List = new ArrayList<>();
        for (int i = 0; i < countries_List.size(); i++) {
            countries_sort_List.add(i, countries_List.get(i));
        }

        Collections.sort(countries_sort_List);
        System.out.println("countries_sort_List " + countries_sort_List);
        Assert.assertEquals(countries_List, countries_sort_List);

        List<WebElement> zones_number = driver.findElements(By.cssSelector(".row td:nth-child(6)"));
        for (int i = 0; i < zones_number.size(); i++) {
            zones_number = driver.findElements(By.cssSelector(".row td:nth-child(6)"));
            String attr_zones_number = zones_number.get(i).getAttribute("textContent");

            if (!attr_zones_number.equals("0")) {
                List<WebElement> count = driver.findElements(By.cssSelector(".row td:nth-child(5) a"));
                count.get(i).click();
                List<WebElement> geozones = driver.findElements(By.cssSelector("#table-zones td:nth-child(3) input:not([type=text])"));

                for (int j = 0; j < geozones.size(); j++) {
                    String attr_geoZones = geozones.get(j).getAttribute("value");
                    geoZones_List.add(j, attr_geoZones);
                }

                System.out.println("geoZones_List " + geoZones_List);

                ArrayList<String> geoZones_sort_List = new ArrayList<>();

                for (int k = 0; k < geoZones_List.size(); k++) {
                    geoZones_sort_List.add(k, geoZones_List.get(k));
                }

                Collections.sort(geoZones_sort_List);
                System.out.println("geoZones_sort_List " + geoZones_sort_List);
                Assert.assertEquals(geoZones_List, geoZones_sort_List);
                geoZones_List.clear();
                driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
            }
        }
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}
