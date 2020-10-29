package frameworkTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage {
    WebDriver webDriver;

    @FindBy(linkText = "Enter the Store")
    private WebElement loginLink;

    public LandingPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void enterToTheStore() {
        loginLink.click();
    }

}
