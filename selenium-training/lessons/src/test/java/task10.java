import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class task10 {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //wait = new WebDriverWait(driver,10);
    }

    @Test
    public void myFirstTest() {

        driver.get("http://localhost/litecart/en/");

        String product_name1 = driver.findElement(By.cssSelector("#box-campaigns li .name")).getAttribute("textContent");
        System.out.println(product_name1);

        String regular_price1 = driver.findElement(By.cssSelector("#box-campaigns li .regular-price")).getText();
        System.out.println(regular_price1);

        String campaign_price1 = driver.findElement(By.cssSelector("#box-campaigns li .campaign-price")).getText();
        System.out.println(campaign_price1);

        String color_regular_price1 = driver.findElement(By.cssSelector("#box-campaigns li .regular-price")).getCssValue("color");
        System.out.println(color_regular_price1);

        int regular_red1 = Color.fromString(color_regular_price1).getColor().getRed();
        int regular_green1 = Color.fromString(color_regular_price1).getColor().getGreen();
        int regular_blue1 = Color.fromString(color_regular_price1).getColor().getBlue();
        System.out.println(regular_red1);
        System.out.println(regular_green1);
        System.out.println(regular_blue1);

        String color_campaign_price1 = driver.findElement(By.cssSelector("#box-campaigns li .campaign-price")).getCssValue("color");
        System.out.println(color_campaign_price1);

        int campaign_green1 = Color.fromString(color_campaign_price1).getColor().getGreen();
        int campaign_blue1 = Color.fromString(color_campaign_price1).getColor().getBlue();
        System.out.println(campaign_green1);
        System.out.println(campaign_blue1);

        //        String hexacolor = Color.fromString(color_regular_price1).asHex();
        //        System.out.println(hexacolor);

        String font_size1_regular_price1 = driver.findElement(By.cssSelector("#box-campaigns li .regular-price")).getCssValue("font-size");
        System.out.println(font_size1_regular_price1);
        String font_size1_regular_price1_replace = font_size1_regular_price1.replace("px","");
        System.out.println(font_size1_regular_price1_replace);
        double font_size1_regular_price1_double = Double.parseDouble(font_size1_regular_price1_replace);
        System.out.println(font_size1_regular_price1_double);

        String font_size1_campaign_price1 = driver.findElement(By.cssSelector("#box-campaigns li .campaign-price")).getCssValue("font-size");
        System.out.println(font_size1_campaign_price1);
        String font_size1_campaign_price1_replace = font_size1_campaign_price1.replace("px","");
        System.out.println(font_size1_campaign_price1_replace);
        double font_size1_campaign_price1_double = Double.parseDouble(font_size1_campaign_price1_replace);
        System.out.println(font_size1_campaign_price1_double);

        driver.findElement(By.cssSelector("#box-campaigns li .link")).click();
        String product_name2 = driver.findElement(By.cssSelector("#box-product .title")).getAttribute("textContent");
        System.out.println(product_name2);

        String regular_price2 = driver.findElement(By.cssSelector(".information .regular-price")).getText();
        System.out.println(regular_price2);

        String campaign_price2 = driver.findElement(By.cssSelector(".information .campaign-price")).getText();
        System.out.println(campaign_price2);

        String color_regular_price2 = driver.findElement(By.cssSelector(".information .regular-price")).getCssValue("color");
        System.out.println(color_regular_price2);

        int regular_red2 = Color.fromString(color_regular_price2).getColor().getRed();
        int regular_green2 = Color.fromString(color_regular_price2).getColor().getGreen();
        int regular_blue2 = Color.fromString(color_regular_price2).getColor().getBlue();
        System.out.println(regular_red2);
        System.out.println(regular_green2);
        System.out.println(regular_blue2);

        String color_campaign_price2 = driver.findElement(By.cssSelector(".information .campaign-price")).getCssValue("color");
        System.out.println(color_campaign_price2);

        int campaign_green2 = Color.fromString(color_campaign_price2).getColor().getGreen();
        int campaign_blue2 = Color.fromString(color_campaign_price2).getColor().getBlue();
        System.out.println(campaign_green2);
        System.out.println(campaign_blue2);

        //        String hexacolor2 = Color.fromString(color_regular_price2).asHex();
        //        System.out.println(hexacolor2);

        String font_size2_regular_price2 = driver.findElement(By.cssSelector(".information .regular-price")).getCssValue("font-size");
        System.out.println(font_size2_regular_price2);
        String font_size2_regular_price2_replace = font_size2_regular_price2.replace("px","");
        System.out.println(font_size2_regular_price2_replace);
        double font_size2_regular_price2_double = Double.parseDouble(font_size2_regular_price2_replace);
        System.out.println(font_size2_regular_price2_double);

        String font_size2_campaign_price2 = driver.findElement(By.cssSelector(".information .campaign-price")).getCssValue("font-size");
        System.out.println(font_size2_campaign_price2);
        String font_size2_campaign_price2_replace = font_size2_campaign_price2.replace("px","");
        System.out.println(font_size2_campaign_price2_replace);
        double font_size2_campaign_price2_double = Double.parseDouble(font_size2_campaign_price2_replace);
        System.out.println(font_size2_campaign_price2_double);

        Assert.assertEquals(product_name1, product_name2);
        Assert.assertEquals(regular_price1, regular_price2);
        Assert.assertEquals(campaign_price1, campaign_price2);

        Assert.assertTrue(regular_red1 == regular_green1 && regular_green1 == regular_blue1);
        Assert.assertTrue(campaign_green1 == 0 && campaign_blue1 == 0);
        Assert.assertTrue(font_size1_regular_price1_double < font_size1_campaign_price1_double);

        Assert.assertTrue(regular_red2 == regular_green2 && regular_green2 == regular_blue2);
        Assert.assertTrue(campaign_green2 == 0 && campaign_blue2 == 0);
        Assert.assertTrue(font_size2_regular_price2_double < font_size2_campaign_price2_double);

    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}

