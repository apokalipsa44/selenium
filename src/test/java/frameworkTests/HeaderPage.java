package frameworkTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HeaderPage {
    WebDriver webDriver;

    public HeaderPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void signInToTheStore() {
        WebElement signInLink = webDriver.findElement(By.linkText("Sign In"));
        signInLink.click();
    }
}
