package Webdriver_TestNG_XML.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Artem Mareenkov on 11.12.2016.
 */
public class LoginPage {

    @FindBy(id="username")
    private WebElement usernameInput;
    @FindBy(id = "password")
    private WebElement passwordInput;
    @FindBy(id = "logIn")
    private WebElement loginButton;

    private WebDriver driver;
    private static final String URL = "http://80.92.229.236:81/auth/login";

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(URL);
    }

    public void setUsername(String username) {
        usernameInput.clear();
        usernameInput.sendKeys(username);
    }

    public void setPassoword(String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void loginButtobClick() {
        loginButton.click();
    }

    public WebElement getErrorMessage() {
        WebElement errorMessage = driver.findElement(By.xpath("//ul[@class='errors']/li"));
        errorMessage.getText();
        return errorMessage;
    }
}

