import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class task12 {

    private WebDriver driver;

    @Before
    public void start() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void Test() {

        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();

        driver.findElement(By.cssSelector("#box-apps-menu li [href*=catalog]")).click();
        driver.findElement(By.cssSelector("#content div a[href*=product]")).click();
        driver.findElement(By.cssSelector("label [value]")).click();
        driver.findElement(By.cssSelector(".input-wrapper [type=text]")).sendKeys("New Product");
        driver.findElement(By.cssSelector("[name=code]")).sendKeys("12345");
        driver.findElement(By.cssSelector("[data-name=Subcategory]")).click();

        WebElement Default_Category = driver.findElement(By.cssSelector("[name=default_category_id]"));
        Select select_Category = new Select(Default_Category);
        select_Category.selectByVisibleText("Subcategory");

        driver.findElement(By.cssSelector("[value='1-3']")).click();
        driver.findElement(By.cssSelector("[name=quantity]")).clear();
        driver.findElement(By.cssSelector("[name=quantity]")).sendKeys("15");

        driver.findElement(By.cssSelector("[type=file]")).sendKeys("C:/Download/Screen Recorder/foto.jpeg");
        driver.findElement(By.cssSelector("#add-new-image i")).click();
        driver.findElement(By.cssSelector("#tab-general tr:nth-child(9) tbody tr:nth-child(2) input"))
                .sendKeys("C:/Download/Screen Recorder/foto2.png");

            // Работа с календарем. Выбор даты. Формат даты смотрим в свойствах элемента календаря (параметр value: "2022-05-05")
        JavascriptExecutor js =(JavascriptExecutor) driver;
        js.executeScript("document.querySelector('input[name=date_valid_from]').value='2022-05-04'");
        js.executeScript("document.querySelector('input[name=date_valid_to]').value='2023-05-04'");

            // Или так
//        LocalDate localDate = LocalDate.now();
//        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.YYYY");
//        String dateFrom = dateTimeFormatter.format(localDate);
//        String dateTo = dateTimeFormatter.format(localDate.plusYears(1));
//        driver.findElement(By.name("date_valid_from")).sendKeys(dateFrom);
//        driver.findElement(By.name("date_valid_to")).sendKeys(dateTo);

            // Или так. Самый простой вариант
        //driver.findElement(By.cssSelector("input[name=date_valid_from]")).sendKeys("04.05.2022");

    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}
