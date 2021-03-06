package frameworkTests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderPage {
    WebDriver webDriver;

    @FindBy(linkText="Sign In")
    private WebElement signInLink;



    public HeaderPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }

    public void signInToTheStore() {
        signInLink.click();
    }
}
