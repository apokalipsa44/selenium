import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test2 {

    WebDriver webDriver;

    @BeforeEach
    public void setupDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.navigate().to("http://przyklady.javastart.pl/jpetstore/actions/Account.action?newAccountForm=");
    }

    @AfterEach
    public void closeDriver() {
        webDriver.quit();
    }

    @Test
    public void userNameInputSearch(){
        webDriver.findElement(By.cssSelector("input[name=username]"));
//        <input name="username" id="stripes--2087001678" type="text">
    }


}
