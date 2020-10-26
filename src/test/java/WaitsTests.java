import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



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
    public void checkboxVisibilityTest(){
//        WebElement removeButton = webDriver.findElement(By.id("btn"));
//        WebElement checkbox = webDriver.findElement(By.id("checkbox"));
//        System.out.println(checkbox.isDisplayed());
//        removeButton.click();
//        WebDriverWait webDriverWait = new WebDriverWait(webDriver, 15);
//        WebElement message = webDriver.findElement(By.id("message"));
//        webDriverWait.until(ExpectedConditions.visibilityOf(message));
//        Assertions.assertEquals(message.getText(), "It's gone!");

        WebElement checkbox = webDriver.findElement(By.id("checkbox"));

        Assertions.assertTrue(checkbox.isDisplayed());
        Assertions.assertFalse(checkbox.isSelected());

        WebElement removeButton = webDriver.findElement(By.id("btn"));
        removeButton.click();

        WebDriverWait webDriverWait = new WebDriverWait(webDriver, 15);
        webDriverWait.until(ExpectedConditions.invisibilityOf(checkbox));

        WebElement messageLabel = webDriver.findElement(By.id("message"));
        Assertions.assertEquals(messageLabel.getText(), "It's gone!");

    }

    @AfterEach
    public void closeDriver() {
        webDriver.close();
        webDriver.quit();
    }

}
