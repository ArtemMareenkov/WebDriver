package WebDriverWithTestNG.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Artem Mareenkov on 06.12.2016.
 */
public class LoginPage {

    private WebDriver driver;
    private static final String URL = "http://80.92.229.236:81/auth/login";

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void open(){
        driver.get(URL);
    }
    //Enter login method
    public void setUsername(String value){
        WebElement inputLogin = driver.findElement(By.id("usernamew"));
          inputLogin.clear();
          inputLogin.sendKeys(value);
          }

    public void setPassword(String value) {
        WebElement inputPassword = driver.findElement(By.id("password"));
            inputPassword.clear();
            inputPassword.sendKeys(value);
    }

    public void logIn() {
        WebElement loginButtonClick = driver.findElement(By.id("logIn"));
        loginButtonClick.click();
    }
}
