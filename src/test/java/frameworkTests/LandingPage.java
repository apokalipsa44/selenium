package frameworkTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
    WebDriver webDriver;

    @FindBy(linkText = "Enter the Store")
    private WebElement loginLink;

    public LandingPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }

    public void enterToTheStore() {
        loginLink.click();
    }

}
