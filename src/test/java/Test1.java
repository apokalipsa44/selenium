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

    @Test
    public void logoSearch(){
//        webDriver.findElement(By.xpath("//img[contians(src,'logo-topbar')]"));
        webDriver.findElement(By.xpath("//div[@id='Logo']//img"));
    }

    @Test
    public void signInSearch(){
        webDriver.findElement(By.xpath("//div[@id='MenuContent']//a[.='Sign In']"));
    }

    @Test
    public void mainParrotSearch(){
        webDriver.findElement(By.cssSelector("div#MainImage"));
    }

    @Test
    public void mainParrotSearchForCats(){
        webDriver.findElement(By.xpath("//area[@alt='Cats']"));
    }

    @Test
    public void inputField(){
        webDriver.findElement(By.cssSelector("input[name=keyword]"));
    }

    @Test
    public void linkAtTheEndWithXpath(){
        webDriver.findElement(By.xpath("div[@id='PoweredBy']/a"));
    }

    @Test
    public void linkAtTheEndWithCss(){
        webDriver.findElement(By.cssSelector("div#PoweredBy>a"));
    }

}
