import lombok.SneakyThrows;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Test1 {
    WebDriver webDriver;

    @BeforeEach
    public void setupDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.navigate().to("http://przyklady.javastart.pl/jpetstore/");
        webDriver.findElement(By.linkText("Enter the Store")).click();
    }

    @AfterEach
    public void closeDriver() {
        webDriver.quit();
    }

    @SneakyThrows
    @Test
    public void test1() {
        webDriver.findElement(By.name("img_cart")).click();
        Thread.sleep(1000);


    }


}
