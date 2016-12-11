package WebDriver_TestNG.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Artem Mareenkov on 06.12.2016.
 */
public class LoginPage {

    private WebDriver driver;
    public static final String URL = "http://80.92.229.236:81/auth/login";

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void open(){
        driver.get(URL);
    }
    //Enter login method
    public void setLoginUsername(String value){
        WebElement inputLogin = driver.findElement(By.id("username"));
          inputLogin.clear();
          inputLogin.sendKeys(value);
    }

    public void setLoginPassword(String value) {
        WebElement inputPassword = driver.findElement(By.id("password"));
            inputPassword.clear();
            inputPassword.sendKeys(value);
    }

    public void logIn() {
        WebElement loginButtonClick = driver.findElement(By.id("logIn"));
          loginButtonClick.click();
    }

    public String getErrorMessage() {
        WebElement errorMessage = driver.findElement(By.xpath(".//ul[@class='errors']/li"));
          return errorMessage.getText();
    }

    public String getTitle() {
        return driver.getTitle();
    }


}
