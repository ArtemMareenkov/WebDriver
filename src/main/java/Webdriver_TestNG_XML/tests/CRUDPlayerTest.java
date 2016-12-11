package Webdriver_TestNG_XML.tests;

import Webdriver_TestNG_XML.pages.CreateEditDeletePlayerPage;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

/**
 * Created by artem on 11.12.2016.
 */
public class CRUDPlayerTest {

    private static WebDriver driver;
    private  static CreateEditDeletePlayerPage createEditDeletePlayerPage;
    String username = RandomStringUtils.random(8, true, true);
    String email = RandomStringUtils.random(10,true,true);
    String password = RandomStringUtils.random(10, true, true);
    String confirmpassword = password;
    String firstname =RandomStringUtils.random(7,true,false);
    String lastname = RandomStringUtils.random(8,true,false);
    String city = RandomStringUtils.random(7,true,false);
    String address = RandomStringUtils.random(9,true,true);
    String phone = RandomStringUtils.random(11,false,true);


    @BeforeTest
    public void beforTest(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        createEditDeletePlayerPage = new CreateEditDeletePlayerPage(driver);
        createEditDeletePlayerPage.open();
        createEditDeletePlayerPage.setUsername("admin");
        createEditDeletePlayerPage.setPassoword("123");
        createEditDeletePlayerPage.loginButtonClick();
        }

    @DataProvider
    public Object[][] createUserData() {
        return new Object[][]{
                {"insert",username, email, password, confirmpassword,firstname,lastname,city,address,phone, "Save"}
        };
    }
    @Test (dataProvider = "creataUserData")
    public void createUserTest(String username, String email, String password, String confirmpassword,  String firstname, String lastname, String city, String address, String phone){
        createEditDeletePlayerPage.insertButtonClick();
        createEditDeletePlayerPage.setUsernameValue(username);
        createEditDeletePlayerPage.setEmailValue(email);
        createEditDeletePlayerPage.setPasswordValue(password);
        createEditDeletePlayerPage.setConfirmPasswordValue(confirmpassword);
        createEditDeletePlayerPage.setFirstNameValue(firstname);
        createEditDeletePlayerPage.setLastNameValue(lastname);
        createEditDeletePlayerPage.setCityValue(city);
        createEditDeletePlayerPage.setAddressValue(address);
        createEditDeletePlayerPage.setPhoneValue(phone);
        createEditDeletePlayerPage.saveButtonClick();
    }


    }



