import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsTests {

    private ChromeDriver webDriver;

    @BeforeEach
    public void setupDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.navigate().to("http://przyklady.javastart.pl/test/hover_mouse.html");
    }

    @Test
    public void hooverTest() {
        WebElement smiley = webDriver.findElement(By.id("smiley"));
        WebElement smiley2 = webDriver.findElement(By.id("smiley2"));

        Actions actions = new Actions(webDriver);
        sleep();
        actions.moveToElement(smiley2).perform();
        sleep();
        actions.moveToElement(smiley).clickAndHold().moveByOffset(280, 280).release().build().perform();
        sleep();

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
