import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class WaitsTests {
    private ChromeDriver webDriver;

    @BeforeEach
    public void setupDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.navigate().to("http://theinternet.przyklady.javastart.pl/dynamic_controls");
    }
//    WebElement foundWebElement = fluentWait
//            .pollingEvery(Duration.ofMillis(250))
//            .withTimeout(Duration.ofSeconds(5))
//            .ignoring(NoSuchElementException.class)
//            .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#something")));

    @Test
    public void checkboxVisibilityTest() {
        WebElement removeButton = webDriver.findElement(By.id("btn"));
        WebElement checkbox = webDriver.findElement(By.id("checkbox"));

        System.out.println(checkbox.isDisplayed());
        Assertions.assertFalse(checkbox.isSelected());

        removeButton.click();
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, 5);
        webDriverWait.until(ExpectedConditions.invisibilityOf(checkbox));

        WebElement message = webDriver.findElement(By.id("message"));
        Assertions.assertEquals(message.getText(), "It's gone!");

        removeButton.click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("checkbox")));
        //        StaleElementReferenceException: stale element reference: element is not attached to the page document
        checkbox = webDriver.findElement(By.id("checkbox"));
        Assertions.assertTrue(checkbox.isDisplayed());
        //        StaleElementReferenceException
        message = webDriver.findElement(By.id("message"));
        Assertions.assertEquals(message.getText(), "It's back!");

    }

    @Test
    public void dynamicLoadingTest() {
        webDriver.navigate().to("http://theinternet.przyklady.javastart.pl/dynamic_loading/1");
        //  css selector (#start > button)
        WebElement startButton = webDriver.findElement(By.xpath("//div[@id='start']//button[text()='Start']"));
        // css selector (#finish > h4)
        WebElement helloWorldTitle = webDriver.findElement(By.xpath("//div[@id='finish']//h4[.='Hello World!']"));
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(webDriver);
        startButton.click();
        wait
                .pollingEvery(Duration.ofMillis(250))
                .withTimeout(Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(helloWorldTitle));
        Assertions.assertTrue(helloWorldTitle.isDisplayed());

    }


    @Test
    public void dynamicLoadingTest2(){
        webDriver.navigate().to("http://theinternet.przyklady.javastart.pl/dynamic_loading/2");
        //  css selector (#start > button)
        WebElement startButton = webDriver.findElement(By.xpath("//div[@id='start']//button[text()='Start']"));
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(webDriver);
        startButton.click();
        wait
                .pollingEvery(Duration.ofMillis(250))
                .withTimeout(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#finish h4")));

        WebElement helloWorldTitle = webDriver.findElement(By.xpath("//div[@id='finish']//h4[.='Hello World!']"));
        Assertions.assertTrue(helloWorldTitle.isDisplayed());
    }


    @AfterEach
    public void closeDriver() {
        webDriver.close();
        webDriver.quit();
    }

}
