package WebDriverWithTestNG.Tests;

import WebDriverWithTestNG.Pages.LoginPage;
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
        Assert.assertEquals(loginPage.getErrorMassage(),"Invalid username or password","Wrong error message");
    }
     @Test
     public void negativePasswordTest(){
        loginPage.setLoginUsername("admin");
        loginPage.setLoginPassword("454726");
        loginPage.logIn();
         Assert.assertEquals(loginPage.getErrorMassage(),"Invalid username or password","Wrong error message");
     }
     @Test
     public void emptyUsernmaeAndPasswordTest(){
         loginPage.setLoginPassword("");
         loginPage.setLoginPassword("");
         loginPage.logIn();
         Assert.assertEquals(loginPage.getErrorMassage(),"Value is required and can't be empty","Wrong error message");
     }
    @AfterTest
    public void afterTest(){
        driver.quit();
    }


}
