import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;

//        Создание сети Grid. Подключение диспетчера и узлов. Команды для командной строки.

//        Создание диспетчера
//        java -jar selenium-server-4.1.4.jar hub

//        Регистрация узлов
//        java -jar selenium-server-4.1.4.jar node --hub http://192.168.56.1:4444/grid/register --port 5556
//        (Если запускается несколько узлов на одной машине, указывайте разные значения параметра port)

public class task15_Grid {
    private WebDriver driver;

    @Before
    public void  start() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setPlatform(Platform.WINDOWS);
        capabilities.setBrowserName("chrome");

        driver = new RemoteWebDriver(new URL("http://192.168.56.1:4444/wd/hub"), capabilities);
    }

    @Test
    public void myFirstTest() {
        driver.get("http://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("webdriver");
        driver.findElement(By.name("btnK")).click();
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}
