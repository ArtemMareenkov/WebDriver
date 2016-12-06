package WebDriverWithTestNG.Tests;

import WebDriverWithTestNG.Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;


/**
 * Created by Artem Mareenkov on 06.12.2016.
 */
public class LoginTest {

    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeTest
    public void beforeTest(){
        driver = new FirefoxDriver();
    }

    @BeforeMethod

    public void beforeMethod(){
        loginPage = new LoginPage(driver);
        loginPage.open();
    }
    @Test
    public void positiveLoginTest(){
        loginPage.setUsername("admin");
        loginPage.setPassword("123");
        loginPage.logIn();
    }

    @Test
    public void negativeLoginTest(){}

    @AfterTest
    public void afterTest(){}


}
