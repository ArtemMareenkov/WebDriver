package Webdriver_TestNG_XML.tests;

import Webdriver_TestNG_XML.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

/**
 * Created by artem on 11.12.2016.
 */
public class LoginTest {
    private static WebDriver driver;
    private  static LoginPage loginPage;



    @BeforeSuite
    public void beforTest(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        loginPage = new LoginPage(driver);
    }

    @BeforeMethod
    public void beforeMethod() {
        loginPage.open();
    }

  @Parameters({"username","password","title"})
    @Test
    public void positiveLoginTest(String username, String password, String title){
        loginPage.setUsername(username);
        loginPage.setPassoword(password);
        loginPage.loginButtobClick();
        Assert.assertEquals(driver.getTitle(),title,"Wrong title");
    }

   @Parameters({"username","password","expectedMessage"})
    @Test
    public void negtiveLoginTestWithIncorrectPassword(String username, String password,String expectedMessage){
        loginPage.setUsername(username);
        loginPage.setPassoword(password);
        loginPage.loginButtobClick();
        Assert.assertEquals(loginPage.getErrorMessage(), expectedMessage, "Wrong error message");

    }
    @Parameters({"username","password","expectedMessage"})
    @Test
    public void negativeLoginTestWithIncorrectUsername(String username, String password, String expectedMessage){
        loginPage.setUsername(username);
        loginPage.setPassoword(password);
        loginPage.loginButtobClick();
        Assert.assertEquals(loginPage.getErrorMessage(),expectedMessage,"Wrong error message");

    }
    @Parameters ({"username","password","expectedMessage"})
    @Test
    public void emptyUsernameAndPasswordFieldTest(String username,String password, String expectedMessage){
        loginPage.setUsername(username);
        loginPage.setPassoword(password);
        loginPage.loginButtobClick();
        Assert.assertEquals(loginPage.getErrorMessage(),expectedMessage,"Wrong error message");
    }
@AfterSuite
    public void afterTest(){
        driver.quit();
}

}
