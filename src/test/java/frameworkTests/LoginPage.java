package frameworkTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
    WebDriver webDriver;

    @FindBy(name="username")
    private WebElement usernameInputField;

    @FindBy(name="password")
    private WebElement passwordInputField;

    @FindBy(name="signon")
    private WebElement loginButton;

    @FindBy(css="ul.messages>li")
    private WebElement failedLoginMessage;

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void typeUsername(String username){
        usernameInputField.clear();
        usernameInputField.sendKeys(username);
    }

    public void typePassword(String password){
        passwordInputField.sendKeys(password);
    }

    public void submitLoginForm(){

        loginButton.click();
    }

    public String getFailedLoginMessage(){
                                                                            // "#Content ul[class='messages'] li"
//        WebElement failedLoginMessage = webDriver.findElement(By.cssSelector("ul.messages>li"));
        return failedLoginMessage.getText();
    }
}
