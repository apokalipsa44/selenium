package frameworkTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
    WebDriver webDriver;

    public LandingPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void enterToTheStore() {
        WebElement loginLink = webDriver.findElement(By.linkText("Enter the Store"));
        loginLink.click();
    }

}
