package Webdriver_TestNG_XML.tests;

import Webdriver_TestNG_XML.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

/**
 * Created by artem on 11.12.2016.
 */
public class LoginTest {
    private static WebDriver driver;
    private  static LoginPage loginPage;
    private SoftAssert softAssert;
    WebElement actualMessage = loginPage.getErrorMessage();

    @BeforeTest
    public void beforTest(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        loginPage = new LoginPage(driver);
        loginPage.open();
        softAssert = new SoftAssert();
    }

  @Parameters({"username","password","title"})
    @Test
    public void positiveLoginTest(String username, String password, String title){
        loginPage.setUsername(username);
        loginPage.setPassoword(password);
        loginPage.loginButtobClick();
        softAssert.assertEquals(driver.getTitle(),title,"Wrong title");
        softAssert.assertAll();
    }
   @Parameters({"username","password","expectedMessage"})
    @Test
    public void negtiveLoginTestWithIncorrectPassword(String username, String password,String expectedMessage){
        loginPage.setUsername(username);
        loginPage.setPassoword(password);
        loginPage.loginButtobClick();
        softAssert.assertEquals(actualMessage, expectedMessage, "Wrong error message");
        softAssert.assertAll();
    }
    @Test
    public void negativeLoginTestWithIncorrectUserName(String username, String password, String expectedMessage){
        loginPage.setUsername(username);
        loginPage.setPassoword(password);
        loginPage.loginButtobClick();
        softAssert.assertEquals(actualMessage,expectedMessage,"Wrong error message");
    }
@AfterTest
    public void afterTest(){
        driver.quit();
}

}
