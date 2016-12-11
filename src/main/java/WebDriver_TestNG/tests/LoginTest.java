package WebDriver_TestNG.tests;

import WebDriver_TestNG.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;


/**
 * Created by Artem Mareenkov on 06.12.2016.
 */
public class LoginTest {

    private WebDriver driver;
    public LoginPage loginPage;

    @BeforeTest
    public void beforeTest(){
        driver = new FirefoxDriver();
    }

    @BeforeMethod
    public void beforeMethod(){
        loginPage = new LoginPage(driver);
        loginPage.open();
    }
    /**
     * Step to reproduce:
     *
     * */
    @Test
    public void positiveLoginTest(){
        loginPage.setLoginUsername("admin");
        loginPage.setLoginPassword("123");
        loginPage.logIn();
        Assert.assertEquals(loginPage.getTitle(), "Players", "Wrong title");
    }
   /**
    *
    *
    *
    *
    *
    * */
    @Test
   public void negativeUsernameTest(){
        loginPage.setLoginUsername("Addmmnn");
        loginPage.setLoginPassword("123");
        loginPage.logIn();
        Assert.assertEquals(loginPage.getErrorMessage(),"Invalid username or password","Wrong error message");
    }
     @Test
     public void negativePasswordTest(){
        loginPage.setLoginUsername("admin");
        loginPage.setLoginPassword("454726");
        loginPage.logIn();
         Assert.assertEquals(loginPage.getErrorMessage(),"Invalid username or password","Wrong error message");
     }
     @Test
     public void emptyUsernameAndPasswordFieldTest(){
         loginPage.setLoginPassword("");
         loginPage.setLoginPassword("");
         loginPage.logIn();
         Assert.assertEquals(loginPage.getErrorMessage(),"Value is required and can't be empty","Wrong error message");
     }
    @AfterTest
    public void afterTest(){
        driver.quit();
    }


}
