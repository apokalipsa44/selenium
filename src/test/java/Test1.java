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
    }

    @AfterEach
    public void closeDriver() {
        webDriver.quit();
    }

    @Test
    public void test1() {

        webDriver.navigate().to("http://przyklady.javastart.pl/jpetstore/");
        webDriver.findElement(By.linkText("Enter the Store")).click();


    }


}
