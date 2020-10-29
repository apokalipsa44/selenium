package frameworkTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderPage {
    WebDriver webDriver;

    @FindBy(linkText="Sign In")
    private WebElement signInLink;



    public HeaderPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void signInToTheStore() {
        signInLink.click();
    }
}
