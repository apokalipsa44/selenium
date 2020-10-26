package frameworkTests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class failedLoginTests {

    WebDriver webDriver;

    // provided
    private String failedLoginMessageProvided="Invalid username or password. Signon failed.";


    @BeforeEach
    public void setupDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.navigate().to("http://przyklady.javastart.pl/jpetstore/");
    }


    @Test
    public void userTryToLoginWithBadCredencials(){
        LandingPage landingPage=new LandingPage(webDriver);
        landingPage.enterToTheStore();

        HeaderPage headerPage=new HeaderPage(webDriver);
        headerPage.signInToTheStore();

        LoginPage loginPage=new LoginPage(webDriver);
        PageFactory.initElements(webDriver,loginPage);
        loginPage.typeUsername("gucio");
        loginPage.typePassword("guciopass");
        loginPage.submitLoginForm();

        Assertions.assertEquals(failedLoginMessageProvided, loginPage.getFailedLoginMessage());
    }

    @AfterEach
    public void closeDriver() {
        webDriver.close();
        webDriver.quit();
    }
}
