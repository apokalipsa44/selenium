import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MegaTest {
    WebDriver webDriver;

    //provided
    private String wrongUsername ="niegucio";
    private String wrongPassword ="badPassword";

//expected
    private String badCredentialsExpectedMessage = "Invalid username or password. Signon failed.";

    @BeforeEach
    public void setupDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.navigate().to("http://przyklady.javastart.pl/jpetstore/actions/Catalog.action");
    }


    @Test
    public void loginTest() {
        sleep();
        webDriver.findElement(By.cssSelector("img[src='../images/sm_reptiles.gif']")).click();
        sleep();
        webDriver.findElement(By.xpath("//a[contains(text(), 'RP-SN-01')]")).click();
        sleep();
        webDriver.findElement(By.xpath("//a[contains(@href, 'EST-12') and (@class='Button')]")).click();
        sleep();
        webDriver.findElement(By.xpath("//a[text()='Proceed to Checkout']")).click();
        sleep();
        webDriver.findElement(By.xpath("//input[@name='username']")).sendKeys(wrongUsername);
        webDriver.findElement(By.xpath("//input[@name='password']")).sendKeys(wrongPassword);
        sleep();
        webDriver.findElement(By.xpath("//input[@name='signon']")).click();
        sleep();
        WebElement bedCredentialsMessageWebElement = webDriver.findElement(By.xpath("//li[text()='Invalid username or password.  Signon failed.']"));
        String badCredentialsActualMessage = bedCredentialsMessageWebElement.getText();

        System.out.println("message is displayed"+bedCredentialsMessageWebElement.isDisplayed());
        Assertions.assertEquals(badCredentialsExpectedMessage, badCredentialsActualMessage);

    }



    @AfterEach
    public void closeDriver() {
        webDriver.close();
        webDriver.quit();
    }

    private void sleep() {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
