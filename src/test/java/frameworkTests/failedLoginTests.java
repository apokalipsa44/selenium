package frameworkTests;

import frameworkTests.pages.HeaderPage;
import frameworkTests.pages.LandingPage;
import frameworkTests.pages.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class failedLoginTests extends TestSetup {

    

    // provided
    private String failedLoginMessageProvided = "Invalid username or password. Signon failed.";


    @Test
    public void userTryToLoginWithBadCredencials() {
        LandingPage landingPage = new LandingPage(webDriver);
//        PageFactory.initElements(webDriver, landingPage);//<---------------- init elements!!!
                                                         // can be done also in the loginpage  constructor!
        landingPage.enterToTheStore();

        HeaderPage headerPage = new HeaderPage(webDriver);
        PageFactory.initElements(webDriver, headerPage);
        headerPage.signInToTheStore();

        LoginPage loginPage = new LoginPage(webDriver);
        PageFactory.initElements(webDriver, loginPage);
        loginPage.typeUsername("gucio");
        loginPage.typePassword("guciopass");
        loginPage.submitLoginForm();

        Assertions.assertEquals(failedLoginMessageProvided, loginPage.getFailedLoginMessage());
    }


}
