import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1 {


    @Test
    public void test1(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe" );
        WebDriver webDriver=new ChromeDriver();
        webDriver.navigate().to("http://www.allegro.pl");

        webDriver.quit();

    }


}
