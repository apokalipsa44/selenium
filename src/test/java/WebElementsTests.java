import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class WebElementsTests {
    WebDriver webDriver;
    private String typedUsername = "gucio";

    @BeforeEach
    public void setupDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.navigate().to("http://przyklady.javastart.pl/jpetstore/actions/Account.action?newAccountForm=");
    }

    @Test
    public void userNameInputSearch() {
        WebElement usernameInputField = webDriver.findElement(By.cssSelector("input[name=username]"));
        sleep();
        usernameInputField.sendKeys(typedUsername);
        sleep();
        String usernameFromInputField = usernameInputField.getAttribute("value");
        Assertions.assertEquals(typedUsername, usernameFromInputField);

    }

    @Test
    public void dropdownListTest() {
        Select languageSelector = new Select(webDriver.findElement(By.name("account.languagePreference")));
        languageSelector.selectByVisibleText("japanese");
        String selectedLang = languageSelector.getFirstSelectedOption().getText();
        Assertions.assertEquals("japanese", selectedLang);
    }

    @Test
    public void petTypeListTest(){
        WebElement element;
        Select petTypeSelector=new Select(webDriver.findElement(By.name("account.favouriteCategoryId")));
        petTypeSelector.selectByIndex(1);
        sleep();
        petTypeSelector.selectByVisibleText("FISH");
        sleep();
        petTypeSelector.selectByValue("CATS");
        sleep();
        String selectedPet = petTypeSelector.getFirstSelectedOption().getText();
        Assertions.assertEquals("CATS", selectedPet);
    }

    @Test
    public void dropdownListOptionsTest() {
        Select languageDropdown = new Select(webDriver.findElement(By.name("account.languagePreference")));
        List<WebElement> options = languageDropdown.getOptions();
        List<String> actualDropdownListOptions = new ArrayList<String>();
        List<String> expectedDropdownListOptions = new ArrayList<String>();

        for (WebElement option : options) {
            actualDropdownListOptions.add(option.getText());
        }

        expectedDropdownListOptions.add("english");
        expectedDropdownListOptions.add("japanese");

        Assertions.assertEquals(expectedDropdownListOptions, actualDropdownListOptions);

    }

    @Test
    public void checkboxesTest() {
        WebElement listOptionCheckbox = webDriver.findElement(By.name("account.listOption"));
        WebElement bannerOptionCheckbox = webDriver.findElement(By.name("account.bannerOption"));

        Assertions.assertFalse(bannerOptionCheckbox.isSelected());
        Assertions.assertFalse(listOptionCheckbox.isSelected());
        sleep();

        listOptionCheckbox.click();
        bannerOptionCheckbox.click();
        sleep();

        Assertions.assertTrue(listOptionCheckbox.isSelected());
        Assertions.assertTrue(bannerOptionCheckbox.isEnabled());
    }


    @AfterEach
    public void closeDriver() {
        webDriver.close();
        webDriver.quit();
    }

    private void sleep() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
