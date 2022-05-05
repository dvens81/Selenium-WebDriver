import org.junit.After;
import org.junit.Assert;
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
import java.util.ArrayList;
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
        String name_Product = "New Toy 4";
        driver.findElement(By.cssSelector(".input-wrapper [type=text]")).sendKeys(name_Product);
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
        JavascriptExecutor js = (JavascriptExecutor) driver;
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

        driver.findElement(By.cssSelector(".index li [href*=information]")).click();

        WebElement Manufacturer = driver.findElement(By.cssSelector("[name=manufacturer_id]"));
        Select select_Manufacturer = new Select(Manufacturer);
        select_Manufacturer.selectByVisibleText("ACME Corp.");

        driver.findElement(By.cssSelector("[name=keywords]")).sendKeys("Top product");
        driver.findElement(By.cssSelector("#tab-information tr:nth-child(4) [type=text]")).sendKeys("Top quality product");
        driver.findElement(By.cssSelector(".trumbowyg-editor")).sendKeys("When buying a soft toy, a bug is a present");
        driver.findElement(By.cssSelector("#tab-information tr:nth-child(6) [type=text]")).sendKeys("Toy");
        driver.findElement(By.cssSelector("#tab-information tr:nth-child(7) [type=text]")).sendKeys("Super toy");

        driver.findElement(By.cssSelector(".index li [href*=prices]")).click();

        driver.findElement(By.cssSelector("[name=purchase_price]")).clear();
        driver.findElement(By.cssSelector("[name=purchase_price]")).sendKeys("7");

        WebElement Purchase_Price = driver.findElement(By.cssSelector("[name=purchase_price_currency_code]"));
        Select select_Purchase_Price = new Select(Purchase_Price);
        select_Purchase_Price.selectByVisibleText("Euros");

        driver.findElement(By.cssSelector("#tab-prices table:nth-child(4) tbody tr:nth-child(2) [type=text]")).sendKeys("20");
        driver.findElement(By.cssSelector("#tab-prices table:nth-child(4) tbody tr:nth-child(3) [type=text]")).sendKeys("20");

        driver.findElement(By.cssSelector("[name=save]")).click();

        ArrayList<String> catalog_list = new ArrayList<>();

        List<WebElement> catalog = driver.findElements(By.cssSelector(".dataTable .row"));
        for (int i = 0; i < catalog.size(); i++) {
            String text = catalog.get(i).getText();
            catalog_list.add(i, text);
        }

        Assert.assertTrue(catalog_list.contains(name_Product));
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }


}