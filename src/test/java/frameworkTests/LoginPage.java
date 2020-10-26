package frameworkTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    WebDriver webDriver;

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void typeUsername(String username){
        WebElement usernameInputField = webDriver.findElement(By.cssSelector("input[name='username']"));
        usernameInputField.sendKeys(username);
    }

    public void typePassword(String password){
        WebElement usernameInputField = webDriver.findElement(By.cssSelector("input[name='password']"));
        usernameInputField.sendKeys(password);
    }

    public void submitLoginForm(){
        WebElement loginButton = webDriver.findElement(By.cssSelector("input[name='signon']"));
        loginButton.click();
    }

    public String getFailedLoginMessage(){
        WebElement failedLoginMessage = webDriver.findElement(By.cssSelector("ul.messages>li"));
        return failedLoginMessage.getText();
    }
}
